package com.finnetwork.views;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.finnetwork.controllers.base_network_cntrl;
import com.google.gson.JsonObject;

@Path("/base_network")
public class base_network {

	@GET
	@Path("/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getResponse (@PathParam("param") int year){
		
		base_network_cntrl base_net_cntrl = new base_network_cntrl();
		
		//	Pass the year parameter to get JSON object which has all the nodes and links for a given year
		JsonObject finalList = base_net_cntrl.get_base_network(year);
		String result = finalList.toString();
		Response response = Response.status(200).entity(result).build();		
		
		return response;
	}
}
