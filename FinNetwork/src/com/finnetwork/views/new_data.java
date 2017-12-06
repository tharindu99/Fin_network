package com.finnetwork.views;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.JsonNode;
import com.finnetwork.controllers.base_network_cntrl;

// Every url with the format of base_url/new_network will be directed to this class
@Path("/new_network")
public class new_data {
	
	//Every GET request will be handled by this method
	@GET
	//URLs with base_url/new_network/year format will be handled here
	@Path("/{param}&{param1}")
	
	//	This method produces JSON output
	@Produces(MediaType.APPLICATION_JSON)
	//	url parameter year is stored in int variable called year
	public Response getResponse (@PathParam("param") String company_name,@PathParam("param1")String status){
	
		
		//	Create an instance of base_network_cntrl class
		base_network_cntrl base_net_cntrl = new base_network_cntrl();
		
		//	Call the relevant method with requested year parameter 
		JsonNode json_baseNet = base_net_cntrl.get_base_network(company_name,status);
		
	
		
		//	Create a Response and return a JSON with status code 200 OK
		Response response = Response.ok(json_baseNet, MediaType.APPLICATION_JSON).build();		
		return response;
	
	}
}
