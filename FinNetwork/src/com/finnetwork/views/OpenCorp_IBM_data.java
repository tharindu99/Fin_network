package com.finnetwork.views;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.finnetwork.controllers.OpenCorp_IBM_controller;

@Path("/oc")
public class OpenCorp_IBM_data {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIBMNetwork() {		
		System.out.println("Inside OC view...");
		
		OpenCorp_IBM_controller openCorp_IBM_controller = new OpenCorp_IBM_controller();
		openCorp_IBM_controller.get_OpenCorp_IBM();
		return "Hello IBM";
	}
}
