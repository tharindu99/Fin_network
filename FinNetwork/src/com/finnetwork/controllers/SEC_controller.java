package com.finnetwork.controllers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.finnetwork.models.SEC_Link;
import com.finnetwork.models.SEC_Node;
import com.finnetwork.persistence.hibernate_util;

public class SEC_controller {

	public ObjectNode getBaseNetwork(String companyName) {
		System.out.println("Requested company : " + companyName);
		
		Session session = hibernate_util.getSessionFactory().openSession();
		session.beginTransaction();		
		
		Query querysource = session.createQuery("SELECT id FROM SEC_Node WHERE equity = :companyName");
		querysource.setParameter("companyName", companyName);
		List sourceList = querysource.list();
		System.out.println(companyName + " has id : " + sourceList.get(0));	
		
		Query queryLink = session.createQuery("FROM SEC_Link WHERE source = :sourceID");
		queryLink.setParameter("sourceID", sourceList.get(0));
		List<SEC_Link> sec_links = queryLink.list();
		System.out.println(sec_links.size());
		
		Query querytargets = session.createQuery("SELECT DISTINCT target FROM SEC_Link WHERE source = :sourceID");
		querytargets.setParameter("sourceID", sourceList.get(0));
		List targetList = querytargets.list();
		System.out.println("target size : " + targetList.size());
		
		sourceList.removeAll(targetList);
		sourceList.addAll(targetList);
		
		Query queryNode = session.createQuery("FROM SEC_Node WHERE id IN (:ids)");
		queryNode.setParameter("ids", sourceList);
		List<SEC_Node> sec_nodes = queryNode.list();
		System.out.println("link size : " + sec_nodes.size());
		
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayNode arrayNode = objectMapper.valueToTree(sec_nodes);
		ArrayNode arrayLink = objectMapper.valueToTree(sec_links);
		
		ObjectNode base_network = objectMapper.createObjectNode();
		base_network.putArray("nodes").addAll(arrayNode);
		base_network.putArray("links").addAll(arrayLink);
		
		session.getTransaction().commit();
		session.close();
		
		return base_network;
	}
}

