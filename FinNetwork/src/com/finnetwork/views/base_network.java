package com.finnetwork.views;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.JsonNode;
import com.finnetwork.controllers.base_network_cntrl;


@Path("/base_network")
public class base_network {

	@GET
	@Path("/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getResponse (@PathParam("param") int year){
		
		base_network_cntrl base_net_cntrl = new base_network_cntrl();
		
		//	Call the relevant method with requested year parameter 
		JsonNode json_baseNet = base_net_cntrl.get_base_network(year);
		
		//	Create a Response and return a JSON
		Response response = Response.ok(json_baseNet, MediaType.APPLICATION_JSON).build();		
		return response;
		
	}
}
