package com.finnetwork.controllers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.finnetwork.persistence.hibernate_util;

public class base_network_cntrl {
	
	public void get_base_network(int year) {
		System.out.println("Call for basenetwork controller..");
	
		Session session = hibernate_util.getSessionFactory().openSession();
		
		session.beginTransaction();
		String sql = "select version()";

	    String result = (String) session.createNativeQuery(sql).getSingleResult();
	    System.out.println(result);
		
		/*Query query = session.createQuery("from feiii_init_data where fillingData = :year ");
		query.setParameter("year", year);
		List list = query.list();
		System.out.println("size of the selected data list : " +list.size());*/
		session.getTransaction().commit();
		session.close();
	}
}
