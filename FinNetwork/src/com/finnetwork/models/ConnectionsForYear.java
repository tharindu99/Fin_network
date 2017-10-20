package com.finnetwork.models;

public class ConnectionsForYear {
	
	private String year;
	private long conn;
	
	public ConnectionsForYear() {
		
	}
	
	public ConnectionsForYear(String year, long conn) {
		this.year = year;
		this.conn = conn;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public long getConn() {
		return conn;
	}

	public void setConn(long conn) {
		this.conn = conn;
	}
	
}
