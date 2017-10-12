package com.finnetwork.models;

import java.util.List;

public class CompanyData {
	
	private String companyName;
	private List<ConnectionsForYear> connectionDetails;
	
	public CompanyData() {
		
	}
	
	public CompanyData(String companyName, List<ConnectionsForYear> connectionDetails) {
		this.companyName = companyName;
		this.connectionDetails = connectionDetails;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public List<ConnectionsForYear> getConnectionDetails() {
		return connectionDetails;
	}

	public void setConnectionDetails(List<ConnectionsForYear> connectionDetails) {
		this.connectionDetails = connectionDetails;
	}

}
