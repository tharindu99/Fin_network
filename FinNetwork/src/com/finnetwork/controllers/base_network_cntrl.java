package com.finnetwork.controllers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.finnetwork.models.FeiiiInitData;
import com.finnetwork.models.Link;
import com.finnetwork.models.Node;
import com.finnetwork.persistence.hibernate_util;


public class base_network_cntrl {
	
	public ObjectNode get_base_network(int year) {
		System.out.println("Call for basenetwork controller...");
	
		Session session = hibernate_util.getSessionFactory().openSession();
		
		session.beginTransaction();		
		
		Query queryLink = session.createQuery("FROM Link WHERE fillingDate LIKE :year");
		queryLink.setParameter("year", "%"+year);		
		List<Link> links = queryLink.list();
		
		System.out.println("link size : " + links.size());
	
		Query querySource = session.createQuery("SELECT DISTINCT source FROM Link WHERE fillingDate LIKE :year");
		querySource.setParameter("year", "%"+year);
		List<Integer> sources  = querySource.list();
		System.out.println("sources size: " + sources.size());
		for ( Integer source : sources) {
			System.out.print(source + ", ");
		}
		
		Query queryTarget = session.createQuery("SELECT DISTINCT source FROM Link WHERE fillingDate LIKE :year");
		queryTarget.setParameter("year", "%"+year+ " limit 1");
		List<Integer> targets = queryTarget.list();
		System.out.println("\ntarget size: " + targets.size());
		/*for (Integer target : targets) {
			System.out.print(target + ", ");
		}*/
		
		sources.removeAll(targets);
		sources.addAll(targets);
		
		/*System.out.println("\n");
		for (Integer i : sources) {			
			System.out.print(i + ", ");
		}*/
		
		Query queryNodes = session.createQuery("FROM Node WHERE id IN (:ids)");
		queryNodes.setParameter("ids", sources);
		List<Node> nodes = queryNodes.list();
		System.out.println("\nFinal size is : " + nodes.size());
		/*for (Node node : nodes) {
			System.out.println(node.getId() + ", " + node.getEquity());
		}*/
		
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode array_node = mapper.valueToTree(nodes);
		ArrayNode array_link = mapper.valueToTree(links);
		
		ObjectNode base_net = mapper.createObjectNode();
		base_net.putArray("nodes").addAll(array_node);
		base_net.putArray("links").addAll(array_link);
		
		
		System.out.println(base_net.toString());
		
		/*ObjectNode base_net = mapper.valueToTree(company);
		companyNode.putArray("nodes").addAll(array_node);
		JsonNode result = mapper.createObjectNode().set("company", companyNode);*/
		
		
		/*
		Gson gson = new Gson();
		JsonObject listToBeSent = new JsonObject();
		JsonElement jsonNodes = gson.toJsonTree(nodes);
		JsonElement jsonLinks = gson.toJsonTree(links);
		listToBeSent.add("nodes", jsonNodes);
		listToBeSent.add("links", jsonLinks);
		System.out.println(listToBeSent);	*/	
		
		session.getTransaction().commit();
		session.close();
		return base_net;
	}
}
