package com.finnetwork.controllers;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.finnetwork.models.OpenCorp_IBM_Link;
import com.finnetwork.models.OpenCorp_IBM_Node;
import com.finnetwork.persistence.hibernate_util;

public class OpenCorp_IBM_controller {

	public ObjectNode get_OpenCorp_IBM() {
		System.out.println("Call for OpenCorp_IBM...");

		Session session = hibernate_util.getSession();
		session.beginTransaction();		
		
		Query subjectQuery = session.createQuery("SELECT DISTINCT NEW com.finnetwork.models.OpenCorp_IBM_Node (subject_id AS id, subject_entity_name AS equity) FROM OpenCorp_IBM");
		List<OpenCorp_IBM_Node> subjectList = subjectQuery.list();		
		
		Query objectQuery = session.createQuery("SELECT DISTINCT NEW com.finnetwork.models.OpenCorp_IBM_Node (object_id AS id, object_entity_name AS equity) FROM OpenCorp_IBM");
		List<OpenCorp_IBM_Node> objectList = objectQuery.list();
		System.out.println(objectList.size());
		
		// nodes
		subjectList.removeAll(objectList);
		subjectList.addAll(objectList);		
		System.out.println("final nodes" + subjectList.size());
		
		// links
		Query linkQuery = session.createQuery("SELECT NEW com.finnetwork.models.OpenCorp_IBM_Link (subject_id AS source, object_id AS target, context, predicate) FROM OpenCorp_IBM");
		List<OpenCorp_IBM_Link> connectionList = linkQuery.list();
		System.out.println("links " + connectionList.size());
		
		ObjectMapper mapper = new ObjectMapper();
		ArrayNode array_node = mapper.valueToTree(subjectList);
		ArrayNode array_link = mapper.valueToTree(connectionList);
		
		ObjectNode OpenCorp_IBM_graph = mapper.createObjectNode();
		OpenCorp_IBM_graph.putArray("nodes").addAll(array_node);
		OpenCorp_IBM_graph.putArray("links").addAll(array_link);
		
		session.getTransaction().commit();
		session.close();
		
		return OpenCorp_IBM_graph;
	}
}
