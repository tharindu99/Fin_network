package com.finnetwork.views;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.finnetwork.controllers.base_network_cntrl;
import com.finnetwork.models.FeiiiInitData;

@Path("/base_network")
public class base_network {

	@GET
	@Path("/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getResponse (@PathParam("param") int req){
		
		base_network_cntrl base_net_cntrl = new base_network_cntrl();
		List<FeiiiInitData> temp_list = base_net_cntrl.get_base_network(req);
		GenericEntity<List<FeiiiInitData>> entity = new GenericEntity<List<FeiiiInitData>>(temp_list){};
		
		return Response.status(200).entity(entity).build();	
	}
}
