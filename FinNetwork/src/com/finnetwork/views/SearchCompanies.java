package com.finnetwork.views;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.databind.JsonNode;
import com.finnetwork.controllers.SearchController;

@Path("/SearchCompanies")
public class SearchCompanies {
	
	@GET	
	@Produces(MediaType.TEXT_PLAIN)
	public Response getResponse(@QueryParam("myInput") String inputCompany) {
		
		SearchController searchController = new SearchController();
		
		JsonNode jsonCompanyDetails = searchController.getCompanyDetails(inputCompany);
		
		Response response = Response.ok(jsonCompanyDetails, MediaType.APPLICATION_JSON).build();
		return response;
	}
	
}
