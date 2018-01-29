package com.finnetwork.models;

public class OpenCorp_IBM_Node {
	private int id;
	private String equity;
	
	public OpenCorp_IBM_Node() {
		
	}
	
	public OpenCorp_IBM_Node(int id, String equity) {
		this.id = id;
		this.equity = equity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEquity() {
		return equity;
	}

	public void setEquity(String equity) {
		this.equity = equity;
	}
}
