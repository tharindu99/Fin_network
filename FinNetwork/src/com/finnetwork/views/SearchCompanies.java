package com.finnetwork.views;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/SearchCompanies")
public class SearchCompanies {
	
	@GET	
	@Produces(MediaType.TEXT_PLAIN)
	public String getResponse(@QueryParam("myInput") String inputCompany) {
		return "Hello " + inputCompany;
	}
	
}
