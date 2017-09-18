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
	public Response getResponse (@PathParam("param") int req){
		
		base_network_cntrl base_net_cntrl = new base_network_cntrl();
		JsonObject finalList = base_net_cntrl.get_base_network(req);
		Response response = Response.status(200).entity(finalList).build();				
		return response;
	}
}
