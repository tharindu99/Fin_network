package com.finnetwork.views;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.finnetwork.controllers.TNIC2_controller;
import com.finnetwork.controllers.TRDF_gt_controller;


@Path("/trdf_gt")
public class TRDF_gt {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public Response getNetwork(@PathParam("id") String id) {
		System.out.println("inside getBaseNetwork TRDF_gt");
		TRDF_gt_controller trdf_gt_controller = new TRDF_gt_controller();
		JsonNode json_base_network = trdf_gt_controller.getBaseNetwork(id);		
		Response response = Response.ok(json_base_network, MediaType.APPLICATION_JSON).build();		
		return response;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/company")
	public Response getCompanyData(){
		TRDF_gt_controller trdf_gt_controller = new TRDF_gt_controller();
		ObjectNode json_company_data = trdf_gt_controller.getCompanyData();
		Response response = Response.ok(json_company_data.toString(), MediaType.APPLICATION_JSON).build();	
		System.out.println(json_company_data.toString());
		return response;
	}
	

}
