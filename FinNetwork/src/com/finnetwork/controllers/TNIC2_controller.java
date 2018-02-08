package com.finnetwork.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.finnetwork.models.TNIC2_Link;
import com.finnetwork.models.TNIC2_Node;
import com.finnetwork.models.TR_Link;
import com.finnetwork.models.TR_Node;
import com.finnetwork.persistence.hibernate_util;

public class TNIC2_controller {
	public ObjectNode getBaseNetwork_annual(String cik, int year) {
		System.out.println("Requested company TNIC2: " + cik + " " + year);

		Session session = hibernate_util.getSessionFactory().openSession();
		session.beginTransaction();

		Query querysource = session
				.createQuery("FROM TNIC2_Link WHERE (CIK_1 = :cik ) AND year= :year");
		querysource.setParameter("cik", cik);
		querysource.setParameter("year", year);
		List<TNIC2_Link> tnic2_edges = querysource.list();
		
		TNIC2_controller tnic_con = new TNIC2_controller();
		Set<String> nodeSet = tnic_con.node_list(tnic2_edges);
		
		Query querynodes =session.createQuery("FROM TNIC2_Node WHERE cik in(:ciks)");
		querynodes.setParameterList("ciks", nodeSet);
		List<TNIC2_Node> tnic2_nodes = querynodes.list();
		
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayNode arrayNode = objectMapper.valueToTree(tnic2_nodes);
		ArrayNode arrayLink = objectMapper.valueToTree(tnic2_edges);
		ObjectNode base_network = objectMapper.createObjectNode();
		base_network.putArray("nodes").addAll(arrayNode);
		base_network.putArray("links").addAll(arrayLink);
		session.getTransaction().commit();
		session.close();
		return base_network;
	}

	public ObjectNode getCompanyData() {
		System.out.println("Requested company data TNIC2 ");

		Session session = hibernate_util.getSessionFactory().openSession();
		session.beginTransaction();
		Query querysource = session
				.createQuery("SELECT concat(ticker_symbol,' : ' ,security,' : ' ,gics_Sector,' : ' ,gics_sub_Industry,'  cik: ' ,cik,' naics: ' ,naics) as company FROM TNIC2_Node");

		List sourceList = querysource.list();

		ObjectMapper mapper = new ObjectMapper();
		// List<Employee> e = new ArrayList<Employee>();
		ArrayNode array = mapper.valueToTree(sourceList);
		ObjectNode companyNode = mapper.createObjectNode();
		companyNode.putArray("company").addAll(array);

		session.getTransaction().commit();
		session.close();
		// System.out.println("size of company records : "+companyNode.toString());
		return companyNode;
	}

	public Set<String> node_list(List<TNIC2_Link> nodes){
		Set<String> node_set = new HashSet<>();
		for (TNIC2_Link entity : nodes) {
			node_set.add(entity.getCIK_1());
			node_set.add(entity.getCIK_2());
		}
		System.out.println("lllllllllll :"+node_set.size());
		return node_set;
	}
}
