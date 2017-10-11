package com.finnetwork.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.finnetwork.models.ConnectionsForYear;
import com.finnetwork.models.FeiiiY2Working;
import com.finnetwork.persistence.hibernate_util;

public class SearchController {	
	
	public static List<String> searchCompanies() {
		System.out.println("Call for Search Comapanies ...");	
		
		Session session = hibernate_util.getSessionFactory().openSession();
		session.beginTransaction();
		
		Query queryCIK = session.createQuery("SELECT DISTINCT FILER_CIK FROM FeiiiY2Working");
		List<String> cikList = queryCIK.list();		
		
		Query queryFillerEntities = session.createQuery("SELECT DISTINCT FILER_NAME FROM FeiiiY2Working");
		List<String> fillerNameList = queryFillerEntities.list();
		
		Query queryMentionedEntities = session.createQuery("SELECT DISTINCT MENTIONED_FINANCIAL_ENTITY FROM FeiiiY2Working");
		List<String> mentionedEntitiesList = queryMentionedEntities.list();
		
		fillerNameList.removeAll(mentionedEntitiesList);
		fillerNameList.addAll(mentionedEntitiesList);
		fillerNameList.addAll(cikList);
		
		session.close();
		return fillerNameList;		
	}	
	
	public void getCompanyDetails(String companyName) {
		System.out.println("Call for get company details..." + companyName);
		
		Session session = hibernate_util.getSessionFactory().openSession();
		session.beginTransaction();
		
		Query queryMentionedEntities = session.createQuery("SELECT DISTINCT MENTIONED_FINANCIAL_ENTITY FROM FeiiiY2Working WHERE MENTIONED_FINANCIAL_ENTITY LIKE :companyName");
		queryMentionedEntities.setParameter("companyName", "%"+companyName+"%");	
		List<String> mentionedEntityList = queryMentionedEntities.list();
		
		System.out.println(mentionedEntityList);
		System.out.println("mention size is : " + mentionedEntityList.size());
		
		Query queryFillerEntities = session.createQuery("SELECT DISTINCT FILER_NAME FROM FeiiiY2Working WHERE FILER_NAME LIKE :companyName or FILER_CIK LIKE :companyName");
		queryFillerEntities.setParameter("companyName", "%"+companyName+"%");	
		List<String> fillerEntityList = queryFillerEntities.list();
		
		System.out.println(fillerEntityList);
		System.out.println("filler size is : " + fillerEntityList.size());
		
		Query queryCIK = session.createQuery("SELECT DISTINCT FILER_CIK FROM FeiiiY2Working WHERE FILER_NAME IN (:companies)");
		queryCIK.setParameter("companies", fillerEntityList);
		List<String> cikList = queryCIK.list();
		
		System.out.println("CIK list size : " + cikList.size());
		System.out.println(cikList);
		
		//	combine filer names with their cik s
		List<String> combinedList = new ArrayList<>();
		Iterator<String> iFiller = fillerEntityList.iterator();
		Iterator<String> iCIK = cikList.iterator();
		
		while (iFiller.hasNext() && iCIK.hasNext()) {
			combinedList.add(iFiller.next() + " : " + iCIK.next());
		}
		
		System.out.println("combined list size : " + combinedList.size());
		System.out.println(combinedList);		
		
		String yearArray[] = {"2011", "2012", "2013", "2014", "2015", "2016"};
		
		ArrayList<ArrayList<ConnectionsForYear>> connectionsForCompany = new ArrayList<ArrayList<ConnectionsForYear>>();
		
		for (int i = 0; i < mentionedEntityList.size(); i++) {
			ArrayList<ConnectionsForYear> connectionsList = new ArrayList<ConnectionsForYear>();
			for (int j = 0; j < yearArray.length; j++) {
				Query queryConnections = session.createQuery("SELECT COUNT(*) FROM FeiiiY2Working WHERE MENTIONED_FINANCIAL_ENTITY = :companyName AND FILING_DATE LIKE :year");
				queryConnections.setParameter("companyName", mentionedEntityList.get(i));
				queryConnections.setParameter("year", "%"+yearArray[j]);				
				long num = (long) queryConnections.uniqueResult();
				
				//create new ConnectionsForYear object
				ConnectionsForYear newConnection = new ConnectionsForYear(yearArray[j], num);
				connectionsList.add(newConnection);
			}
			connectionsForCompany.add(connectionsList);
		}
		
		for (int i = 0; i < fillerEntityList.size(); i++) {
			ArrayList<ConnectionsForYear> connectionsList = new ArrayList<ConnectionsForYear>();
			for (int j = 0; j < yearArray.length; j++) {
				Query queryConnections = session.createQuery("SELECT COUNT(*) FROM FeiiiY2Working WHERE FILER_NAME = :companyName AND FILING_DATE LIKE :year");
				queryConnections.setParameter("companyName", fillerEntityList.get(i));
				queryConnections.setParameter("year", "%"+yearArray[j]);				
				long num = (long) queryConnections.uniqueResult();
				
				//create new ConnectionsForYear object
				ConnectionsForYear newConnection = new ConnectionsForYear(yearArray[j], num);
				connectionsList.add(newConnection);
			}
			connectionsForCompany.add(connectionsList);
		}
		
		for (int i = 0; i < connectionsForCompany.size(); i++) {
			for (int j = 0; j < yearArray.length; j++) {
				System.out.print(connectionsForCompany.get(i).get(j).getYear() + " : " + connectionsForCompany.get(i).get(j).getConn() + " AND ");
			}
			System.out.println();
		}		
		
		session.close();
		
	}
}
