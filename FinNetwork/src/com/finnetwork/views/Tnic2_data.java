package com.finnetwork.views;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.finnetwork.controllers.TR_controller;
import com.finnetwork.controllers.TNIC2_controller;

@Path("/tnic2")
public class Tnic2_data {
	
	/*@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{cik}")
	public Response getBaseNetwork(@PathParam("cik") String cik) {
		System.out.println("inside getBaseNetwork TNIC");
		TNIC2_controller tnic2_controller = new TNIC2_controller();
		JsonNode json_base_network = tnic2_controller.getBaseNetwork(cik);		
		
		Response response = Response.ok(json_base_network, MediaType.APPLICATION_JSON).build();		
		return response;
	}*/
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{cik}/{year}")
	public Response getYearlyNetwork(@PathParam("cik") String companyName,@PathParam("year") int year) {
		System.out.println("inside getBaseNetwork TNIC");
		TNIC2_controller tnic2_controller = new TNIC2_controller();
		JsonNode json_base_network = tnic2_controller.getBaseNetwork_annual(companyName,year);		
		
		Response response = Response.ok(json_base_network, MediaType.APPLICATION_JSON).build();		
		return response;
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/company")
	public Response getCompanyData(){
		TNIC2_controller tnic2_controller = new TNIC2_controller();
		ObjectNode json_company_data = tnic2_controller.getCompanyData();
		Response response = Response.ok(json_company_data.toString(), MediaType.APPLICATION_JSON).build();	
		System.out.println(json_company_data.toString());
		return response;
	}

}
