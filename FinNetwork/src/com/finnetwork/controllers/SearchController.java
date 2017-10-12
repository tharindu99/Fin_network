package com.finnetwork.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.finnetwork.models.ConnectionsForYear;
import com.finnetwork.persistence.hibernate_util;

public class SearchController {	
	
	public static List<String> searchCompanies() {
		System.out.println("Call for Search Comapanies ...");	
		
		Session session = hibernate_util.getSessionFactory().openSession();
		session.beginTransaction();
		
		Query queryCIK = session.createQuery("SELECT DISTINCT CONCAT('CIK:', FILER_CIK) FROM FeiiiY2Working");
		List<String> cikList = queryCIK.list();		
		
		Query queryFillerEntities = session.createQuery("SELECT DISTINCT CONCAT('filler:', FILER_NAME) FROM FeiiiY2Working");
		List<String> fillerNameList = queryFillerEntities.list();
		
		Query queryMentionedEntities = session.createQuery("SELECT DISTINCT CONCAT('mentioned:', MENTIONED_FINANCIAL_ENTITY) FROM FeiiiY2Working");
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
		
		String yearArray[] = {"2011", "2012", "2013", "2014", "2015", "2016"};
		
		ArrayList<ArrayList<ConnectionsForYear>> connectionsForMentionedCompany = new ArrayList<ArrayList<ConnectionsForYear>>();
		
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
			connectionsForMentionedCompany.add(connectionsList);
		}
		
		ArrayList<ArrayList<ConnectionsForYear>> connectionsForFillerCompany = new ArrayList<ArrayList<ConnectionsForYear>>();
		
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
			connectionsForFillerCompany.add(connectionsList);
		}
		
		List<String> mentionedCompanyDetails = new ArrayList<>();
		Iterator<String> iMentioned = mentionedEntityList.iterator();
		Iterator<ArrayList<ConnectionsForYear>> iMConnections = connectionsForMentionedCompany.iterator();
		
		while (iMentioned.hasNext() && iMConnections.hasNext()) {
			mentionedCompanyDetails.add(iMentioned.next() + ":" + iMConnections.next());
		}
		
		for (int i = 0; i < mentionedCompanyDetails.size(); i++) {
			System.out.println(mentionedCompanyDetails.get(i));
		}
		System.out.println("mentioned size : " + mentionedCompanyDetails.size());
		
		List<String> fillerCompanyDetails = new ArrayList<>();
		Iterator<String> iFiller = fillerEntityList.iterator();
		Iterator<String> iCIK = cikList.iterator();
		Iterator<ArrayList<ConnectionsForYear>> iFConnections = connectionsForFillerCompany.iterator();
		
		while (iFiller.hasNext() && iCIK.hasNext() && iFConnections.hasNext()) {
			fillerCompanyDetails.add(iFiller.next()+":"+iCIK.next()+":"+iFConnections.next());
		}
		
		for (int i = 0; i < fillerCompanyDetails.size(); i++) {
			System.out.println(fillerCompanyDetails.get(i));
		}
		System.out.println("filler size : " + fillerCompanyDetails.size());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		session.close();
		
		
		
	}
}
