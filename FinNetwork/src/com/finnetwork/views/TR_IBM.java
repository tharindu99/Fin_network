package com.finnetwork.views;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.JsonNode;
import com.finnetwork.controllers.OpenCorp_IBM_controller;
import com.finnetwork.controllers.TR_IBM_controller;

@Path("/TR_IBM")
public class TR_IBM {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getResponse() {
		TR_IBM_controller ibm_controller = new TR_IBM_controller();
		JsonNode json_TR_IBM = ibm_controller.get_TR_IBM();
		
		Response response = Response.ok(json_TR_IBM, MediaType.APPLICATION_JSON).build();
		return response;
	}
}
