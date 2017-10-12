package com.finnetwork.models;

public class CompanyData {
	
	private String companyName;
	private ConnectionsForYear connectionDetails;
	
	public CompanyData() {
		// TODO Auto-generated constructor stub
	}
	
	public CompanyData(String companyName, ConnectionsForYear connectionDetais) {
		this.companyName = companyName;
		this.connectionDetails = connectionDetais;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public ConnectionsForYear getConnectionDetails() {
		return connectionDetails;
	}

	public void setConnectionDetails(ConnectionsForYear connectionDetails) {
		this.connectionDetails = connectionDetails;
	}
	
}
