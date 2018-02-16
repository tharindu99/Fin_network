package com.finnetwork.controllers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.finnetwork.persistence.hibernate_util;

public class IDController {
	
	public static int getID(String companyName) {
		System.out.println("Searching for : " + companyName);
		
		Session session = hibernate_util.getSession();
		session.beginTransaction();
		
		Query queryID = session.createQuery("SELECT id FROM SEC_Node WHERE equity = :companyName");
		queryID.setParameter("companyName", companyName);
		int id = (int) queryID.list().get(0);
		System.out.println("id : " + id);
		
		session.getTransaction().commit();
		session.close();
		
		return id;
	}
}
