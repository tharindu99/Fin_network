package com.finnetwork.controllers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.finnetwork.models.FeiiiInitData;
import com.finnetwork.models.Link;
import com.finnetwork.models.Node;
import com.finnetwork.persistence.hibernate_util;

public class base_network_cntrl {
	
	public List<Node> get_base_network(int year) {
		System.out.println("Call for basenetwork controller...");
	
		Session session = hibernate_util.getSessionFactory().openSession();
		
		session.beginTransaction();		
		
		Query queryLink = session.createQuery("FROM Link WHERE fillingDate LIKE :year");
		queryLink.setParameter("year", "%"+year);		
		List<Link> links = queryLink.list();
		
		System.out.println("link size : " + links.size());
		System.out.println(links.get(2).getRole());
	
		Query querySource = session.createQuery("SELECT DISTINCT source FROM Link WHERE fillingDate LIKE :year");
		querySource.setParameter("year", "%"+year);
		List<Integer> sources  = querySource.list();
		System.out.println("sources size: " + sources.size());
		for ( Integer source : sources) {
			System.out.print(source + ", ");
		}
		
		Query queryTarget = session.createQuery("SELECT DISTINCT source FROM Link WHERE fillingDate LIKE :year");
		queryTarget.setParameter("year", "%"+year);
		List<Integer> targets = queryTarget.list();
		System.out.println("\ntarget size: " + targets.size());
		for (Integer target : targets) {
			System.out.print(target + ", ");
		}
		
		sources.removeAll(targets);
		sources.addAll(targets);
		
		System.out.println("\n");
		for (Integer i : sources) {			
			System.out.print(i + ", ");
		}
		
		Query queryNodes = session.createQuery("FROM Node WHERE id IN (:ids)");
		queryNodes.setParameter("ids", sources);
		List<Node> nodes = queryNodes.list();
		System.out.println("\nFinal size is : " + nodes.size());
		for (Node node : nodes) {
			System.out.println(node.getId() + ", " + node.getEquity());
		}
		
		session.getTransaction().commit();
		session.close();
		return nodes;
	}
}
