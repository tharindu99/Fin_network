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
import com.finnetwork.models.CompanyData;
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
	
	public ObjectNode getCompanyDetails(String companyName) {
		System.out.println("Call for get company details..." + companyName);
		
		Session session = hibernate_util.getSessionFactory().openSession();
		session.beginTransaction();		
		
		Query queryFillerEntities = session.createQuery("SELECT DISTINCT FILER_NAME FROM FeiiiY2Working WHERE FILER_NAME LIKE :companyName or FILER_CIK LIKE :companyName");
		queryFillerEntities.setParameter("companyName", "%"+companyName+"%");	
		List<String> fillerEntityList = queryFillerEntities.list();
		
		System.out.println(fillerEntityList);
		System.out.println("filler size is : " + fillerEntityList.size());		
		
		Query queryMentionedEntities = session.createQuery("SELECT DISTINCT MENTIONED_FINANCIAL_ENTITY FROM FeiiiY2Working WHERE MENTIONED_FINANCIAL_ENTITY LIKE :companyName");
		queryMentionedEntities.setParameter("companyName", "%"+companyName+"%");	
		List<String> mentionedEntityList = queryMentionedEntities.list();
		
		System.out.println(mentionedEntityList);
		System.out.println("mention size is : " + mentionedEntityList.size());		
			
		
		
		
		
		//	count number of connections for a given company
		String yearArray[] = {"2011", "2012", "2013", "2014", "2015", "2016"};
		
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
		
		
		
		// modify filler company names with tags
		Query queryFillerEntitiesAndCIKs = session.createQuery("SELECT DISTINCT CONCAT('filler:', FILER_NAME, ':', FILER_CIK) FROM FeiiiY2Working WHERE FILER_NAME LIKE :company OR FILER_CIK LIKE :company ");
		queryFillerEntitiesAndCIKs.setParameter("company", "%"+companyName+"%");	
		List<String> fillerEntityListAndCIKs = queryFillerEntitiesAndCIKs.list();
		
		
		
		
		// modify mentioned company names with a tag
		for (int i = 0; i < mentionedEntityList.size(); i++) {
			String name = "mentioned:" + mentionedEntityList.get(i);
			mentionedEntityList.set(i, name);
		}
		
		
		
		
		
		
		
		
		// create one list
		Iterator<String> iFiller = fillerEntityListAndCIKs.iterator();
		Iterator<ArrayList<ConnectionsForYear>> iConnectionsForFiller = connectionsForFillerCompany.iterator();
		
		Iterator<String> iMentioned = mentionedEntityList.iterator();
		Iterator<ArrayList<ConnectionsForYear>> iConnectionsForMentioned = connectionsForMentionedCompany.iterator();
		
		List<CompanyData> companyDataList = new ArrayList<>();		
		
		while (iFiller.hasNext() && iConnectionsForFiller.hasNext()) {
			CompanyData companyData = new CompanyData(iFiller.next(), iConnectionsForFiller.next());	
			companyDataList.add(companyData);
		}
		while (iMentioned.hasNext() && iConnectionsForMentioned.hasNext()) {
			CompanyData companyData = new CompanyData(iMentioned.next(), iConnectionsForMentioned.next());
			companyDataList.add(companyData);
		}
		
		for (int i = 0; i < companyDataList.size(); i++) {
			System.out.println(companyDataList.get(i).getCompanyName());
			for (int j = 0; j < yearArray.length; j++) {
				System.out.print(companyDataList.get(i).getConnectionDetails().get(j).getYear() + " has " + companyDataList.get(i).getConnectionDetails().get(j).getConn() + ", ");
			}
			System.out.println();
		}
	
		
		// create JSON
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode arrayData = mapper.valueToTree(companyDataList);
		ObjectNode finalOutput = mapper.createObjectNode();
		finalOutput.putArray("companyData").addAll(arrayData);	
		
		session.close();	
		return finalOutput;
	}
}
