package com.finnetwork.controllers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.finnetwork.models.TR_Link;
import com.finnetwork.models.TR_Node;
import com.finnetwork.persistence.hibernate_util;

public class TR_controller {

	public ObjectNode getBaseNetwork(String companyName) {
		System.out.println("Requested company tr: " + companyName);
		
		Session session = hibernate_util.getSession();
		session.beginTransaction();		
		
		Query querysource = session.createQuery("SELECT id FROM TR_Node WHERE equity = :companyName");
		querysource.setParameter("companyName", companyName);
		List sourceList = querysource.list();
		System.out.println(companyName + " has id : " + sourceList.get(0));	
		
		Query queryLink = session.createQuery("FROM TR_Link WHERE source = :sourceID");
		queryLink.setParameter("sourceID", sourceList.get(0));
		List<TR_Link> tr_links = queryLink.list();
		System.out.println(tr_links.size());
		
		Query querytargets = session.createQuery("SELECT DISTINCT target FROM TR_Link WHERE source = :sourceID");
		querytargets.setParameter("sourceID", sourceList.get(0));
		List targetList = querytargets.list();
		System.out.println("target size : " + targetList.size());
		
		sourceList.removeAll(targetList);
		sourceList.addAll(targetList);
		
		Query queryNode = session.createQuery("FROM TR_Node WHERE id IN (:ids)");
		queryNode.setParameter("ids", sourceList);
		List<TR_Node> tr_nodes = queryNode.list();
		System.out.println("link size : " + tr_nodes.size());
		
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayNode arrayNode = objectMapper.valueToTree(tr_nodes);
		ArrayNode arrayLink = objectMapper.valueToTree(tr_links);
		
		ObjectNode base_network = objectMapper.createObjectNode();
		base_network.putArray("nodes").addAll(arrayNode);
		base_network.putArray("links").addAll(arrayLink);
		
		session.getTransaction().commit();
		session.close();
		
		return base_network;
	}
}
