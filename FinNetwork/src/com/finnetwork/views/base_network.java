package com.finnetwork.views;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/base_network")
public class base_network {

	@GET
	@Path("/{param}")
	public Response getResponse (@PathParam("param") String req){
		String output = "hureaaa"+ req;
		return Response.status(200).entity(output).build();	
	}
	
}
