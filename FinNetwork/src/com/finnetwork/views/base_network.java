package com.finnetwork.views;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.finnetwork.controllers.base_network_cntrl;

@Path("/base_network")
public class base_network {

	@GET
	@Path("/{param}")
	public Response getResponse (@PathParam("param") int req){
		
		//int yr = Integer.getInteger(req);
		base_network_cntrl base_net_cntrl = new base_network_cntrl();
		base_net_cntrl.get_base_network(req);
		
		String output = "hureaaa :"+ req; // you can call from here for any external methods.
		return Response.status(200).entity(output).build();	
	}
}
