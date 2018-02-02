package com.finnetwork.views;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.JsonNode;
import com.finnetwork.controllers.TR_controller;

@Path("/tr")
public class TR_data {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{companyName}")
	public Response getBaseNetwork(@PathParam("companyName") String companyName) {
		System.out.println("inside getBaseNetwork tr");
		TR_controller tr_controller = new TR_controller();
		JsonNode json_base_network = tr_controller.getBaseNetwork(companyName);		
		
		Response response = Response.ok(json_base_network, MediaType.APPLICATION_JSON).build();		
		return response;
	}
	
}
