package com.finnetwork.controllers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.finnetwork.models.FeiiiInitData;
import com.finnetwork.models.Link;
import com.finnetwork.models.Node;
import com.finnetwork.persistence.hibernate_util;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class base_network_cntrl {
	
	public JsonObject get_base_network(int year) {
		System.out.println("Call for basenetwork controller...");
	
		Session session = hibernate_util.getSessionFactory().openSession();
		
		session.beginTransaction();		
		
		//	Get all the links for a given year
		Query queryLink = session.createQuery("FROM Link WHERE fillingDate LIKE :year");
		queryLink.setParameter("year", "%"+year);		
		List<Link> links = queryLink.list();
		
		//	Get all the source companies in links
		Query querySource = session.createQuery("SELECT DISTINCT source FROM Link WHERE fillingDate LIKE :year");
		querySource.setParameter("year", "%"+year);
		List<Integer> sources  = querySource.list();
		
		//	Get all the target companies in links
		Query queryTarget = session.createQuery("SELECT DISTINCT source FROM Link WHERE fillingDate LIKE :year");
		queryTarget.setParameter("year", "%"+year);
		List<Integer> targets = queryTarget.list();
		
		// Merge source and target lists such that duplicates are eliminated
		sources.removeAll(targets);
		sources.addAll(targets);
		
		//	Now all the nodes(companies) id s are in sources list 
		//	sources is given to the query to retrieve the all nodes for a given year
		Query queryNodes = session.createQuery("FROM Node WHERE id IN (:ids)");
		queryNodes.setParameter("ids", sources);
		List<Node> nodes = queryNodes.list();
		
		
		
		Gson gson = new Gson();
		//	Create a JsonObject to hold the JSON output of the method
		JsonObject listToBeSent = new JsonObject();
		
		//	Convert nodes into JSON
		JsonElement jsonNodes = gson.toJsonTree(nodes);
		//	Convert links into JSON
		JsonElement jsonLinks = gson.toJsonTree(links);
		
		// Add both nodes and links to JSON output
		listToBeSent.add("nodes", jsonNodes);
		listToBeSent.add("links", jsonLinks);
		System.out.println(listToBeSent);		
				
		session.getTransaction().commit();
		session.close();
		
		//	Return the JSON output
		return listToBeSent;
	}
}
