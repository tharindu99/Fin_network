package com.finnetwork.controllers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.finnetwork.persistence.hibernate_util;

public class SearchController {	
	
	public static List<String> searchCompanies() {
		System.out.println("Call for Search Comapanies ...");	
		
		Session session = hibernate_util.getSessionFactory().openSession();
		session.beginTransaction();
		
		Query queryCIK = session.createQuery("SELECT DISTINCT FILER_CIK FROM FeiiiY2Working");
		List<String> cikList = queryCIK.list();		
		System.out.println(cikList);
		System.out.println("CIK list size : " + cikList.size());
		
		Query queryFillerEntities = session.createQuery("SELECT DISTINCT FILER_NAME FROM FeiiiY2Working");
		List<String> fillerNameList = queryFillerEntities.list();
		System.out.println(fillerNameList);
		System.out.println("Filler list size : " + fillerNameList.size());
		
		Query queryMentionedEntities = session.createQuery("SELECT DISTINCT MENTIONED_FINANCIAL_ENTITY FROM FeiiiY2Working");
		List<String> mentionedEntitiesList = queryMentionedEntities.list();
		System.out.println(mentionedEntitiesList);
		System.out.println("Mentioned list size : " + mentionedEntitiesList.size());
		
		fillerNameList.removeAll(mentionedEntitiesList);
		fillerNameList.addAll(mentionedEntitiesList);
		fillerNameList.addAll(cikList);
		
		System.out.println(fillerNameList);
		System.out.println("Final list size : " + fillerNameList.size());
		
		session.close();
		return fillerNameList;		
	}	
}
