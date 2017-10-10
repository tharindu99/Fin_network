package com.finnetwork.controllers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.fasterxml.jackson.databind.node.ObjectNode;
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
		
		Query queryMentionedEntities = session.createQuery("SELECT DISTINCT MENTIONED_FINANCIAL_ENTITY FROM FeiiiY2Working where MENTIONED_FINANCIAL_ENTITY LIKE :companyName");
		queryMentionedEntities.setParameter("companyName", "%"+companyName+"%");	
		List<String> mentionedEntityList = queryMentionedEntities.list();
		
		System.out.println(mentionedEntityList);
		System.out.println("mention size is : " + mentionedEntityList.size());
		
		Query queryFillerEntities = session.createQuery("SELECT DISTINCT FILER_NAME, FILER_CIK FROM FeiiiY2Working where FILER_NAME LIKE :companyName or FILER_CIK LIKE :companyName");
		queryFillerEntities.setParameter("companyName", "%"+companyName+"%");	
		List<String> fillerEntityList = queryFillerEntities.list();
		
		System.out.println(fillerEntityList);
		System.out.println("filler size is : " + fillerEntityList.size());
		
		
		
		session.close();
		
	}
}
