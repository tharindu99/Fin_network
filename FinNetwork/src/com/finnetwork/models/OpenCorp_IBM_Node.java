package com.finnetwork.models;

public class OpenCorp_IBM_Node {
	private String id;
	private String equity;
	
	public OpenCorp_IBM_Node() {
		
	}
	
	public OpenCorp_IBM_Node(String id, String equity) {
		this.id = id;
		this.equity = equity;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEquity() {
		return equity;
	}

	public void setEquity(String equity) {
		this.equity = equity;
	}
}
