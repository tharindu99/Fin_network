package com.finnetwork.views;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.JsonNode;
import com.finnetwork.controllers.OpenCorp_IBM_controller;

@Path("/OpenCorp_IBM")
public class OpenCorp_IBM {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getResponse() {
		OpenCorp_IBM_controller ibm_controller = new OpenCorp_IBM_controller();
		JsonNode json_OpenCorp_IBM = ibm_controller.get_OpenCorp_IBM();
		
		Response response = Response.ok(json_OpenCorp_IBM, MediaType.APPLICATION_JSON).build();
		return response;
	}
}
