package com.finnetwork.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.finnetwork.models.TNIC2_Link;
import com.finnetwork.models.TNIC2_Node;
import com.finnetwork.models.TRDF_gt_Link;
import com.finnetwork.models.TRDF_gt_Node;
import com.finnetwork.persistence.hibernate_util;

public class TRDF_gt_controller {

	public JsonNode getBaseNetwork(String id) {
		System.out.println("Requested company TRDF_gt: " + id );

		Session session = hibernate_util.getSession();
		session.beginTransaction();

		Query querysource = session
				.createQuery("FROM TRDF_gt_Link t WHERE (source = :id ) OR (target = :id )");
		querysource.setParameter("id", id);
		
		List<TRDF_gt_Link> trdf_gt_edges = querysource.list();
		System.out.println("done......");
		//System.out.println("query out put :"+trdf_gt_edges.size()+" : "+id);
		TRDF_gt_controller tnic_con = new TRDF_gt_controller();
		Set<String> nodeSet = tnic_con.node_list(trdf_gt_edges);
		
		Query querynodes =session.createQuery("FROM TRDF_gt_Node WHERE company_id in(:ids)");
		querynodes.setParameterList("ids", nodeSet);
		List<TRDF_gt_Node> trdf_gt_nodes = querynodes.list();
		
		ObjectMapper objectMapper = new ObjectMapper();
		ArrayNode arrayNode = objectMapper.valueToTree(trdf_gt_nodes);
		ArrayNode arrayLink = objectMapper.valueToTree(trdf_gt_edges);
		ObjectNode base_network = objectMapper.createObjectNode();
		base_network.putArray("nodes").addAll(arrayNode);
		base_network.putArray("links").addAll(arrayLink);
		
		session.getTransaction().commit();
		session.close();
		
		return base_network;
	}

	public ObjectNode getCompanyData() {
		System.out.println("Requested company data TRDF_gt ");

		Session session = hibernate_util.getSession();
		session.beginTransaction();
		Query querysource = session
				.createQuery("SELECT concat(commonName_attr,' CIK: ',hasCIK_attr,' uri_id: ',company_id ) from TRDF_gt_Node where hasCIK_attr is not null");

		List sourceList = querysource.list();

		ObjectMapper mapper = new ObjectMapper();
		ArrayNode array = mapper.valueToTree(sourceList);
		ObjectNode companyNode = mapper.createObjectNode();
		companyNode.putArray("company").addAll(array);

		session.getTransaction().commit();
		session.close();
		
		return companyNode;
		
	}
	public Set<String> node_list(List<TRDF_gt_Link> nodes){
		Set<String> node_set = new HashSet<>();
		for (TRDF_gt_Link entity : nodes) {
			System.out.println("oooo "+ entity.getSource());
			node_set.add(entity.getSource());
			node_set.add(entity.getTarget());
		}
		System.out.println("lllllllllll :"+node_set.size()+" : "+nodes.size());
		return node_set;
	}
	
}
