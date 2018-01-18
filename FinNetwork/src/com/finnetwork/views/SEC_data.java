package com.finnetwork.views;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.jdt.internal.compiler.flow.InsideSubRoutineFlowContext;

import com.fasterxml.jackson.databind.JsonNode;
import com.finnetwork.controllers.SEC_controller;

@Path("/sec/")
public class SEC_data {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{companyName}")
	public Response getBaseNetwork(@PathParam("companyName") String companyName) {
		System.out.println("inside getBaseNetwork");
		SEC_controller sec_controller = new SEC_controller();
		JsonNode json_base_network = sec_controller.getBaseNetwork(companyName);		
		
		Response response = Response.ok(json_base_network, MediaType.APPLICATION_JSON).build();		
		return response;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{companyName}/{year}")
	public Response getBaseNetworkYear(@PathParam("companyName") String companyName, @PathParam("year") int year) {
		System.out.println("inside getBaseNetworkYear");
		SEC_controller sec_controller = new SEC_controller();
		JsonNode json_base_network_yearly = sec_controller.getDataYearWise(companyName, year);
		
		Response response = Response.ok(json_base_network_yearly, MediaType.APPLICATION_JSON).build();		
		return response;
	}
}
