package com.finnetwork.controllers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.finnetwork.models.Link;
import com.finnetwork.models.Node;
import com.finnetwork.persistence.hibernate_util;


public class base_network_cntrl {
	//	take the year parameter and return ObjectNode
	public ObjectNode get_base_network(int year) {
		System.out.println("Call for basenetwork controller...");
		
		//	Creata a session
		Session session = hibernate_util.getSessionFactory().openSession();
		//	Begin transaction
		session.beginTransaction();		
		
		//	Retrieve all the links for a given year
		Query queryLink = session.createQuery("FROM Link WHERE fillingDate LIKE :year");
		queryLink.setParameter("year", "%"+year);		
		List<Link> links = queryLink.list();
		
		//	Select all the distinct source nodes from given year
		Query querySource = session.createQuery("SELECT DISTINCT source FROM Link WHERE fillingDate LIKE :year");
		querySource.setParameter("year", "%"+year);
		List<Integer> sources  = querySource.list();
		
		//	Select all the distinct target nodes from given year
		Query queryTarget = session.createQuery("SELECT DISTINCT target FROM Link WHERE fillingDate LIKE :year");
		queryTarget.setParameter("year", "%"+year);
		List<Integer> targets = queryTarget.list();
		
		// 	List of all the nodes for a given year 
		sources.removeAll(targets);
		sources.addAll(targets);
		//	Now all the distinct nodes are stored in sources List
		
		//	It is passed to the query to retrieve all the node details
		Query queryNodes = session.createQuery("FROM Node WHERE id IN (:ids)");
		queryNodes.setParameter("ids", sources);
		List<Node> nodes = queryNodes.list();		
		
		//	Convert both nodes and links to ArrayNodes
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode array_node = mapper.valueToTree(nodes);
		ArrayNode array_link = mapper.valueToTree(links);
		
		// 	Add both array_node and array_link to single ObjectNode which is the type of the output of the method
		ObjectNode base_net = mapper.createObjectNode();
		base_net.putArray("nodes").addAll(array_node);
		base_net.putArray("links").addAll(array_link);
		
		session.getTransaction().commit();
		session.close();
		
		//	Return the output
		return base_net;
	}
}
