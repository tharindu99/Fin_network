package com.finnetwork.models;

public class OpenCorp_IBM_Link {
	
	private String source;
	private String target;
	
	public OpenCorp_IBM_Link() {
		
	}
	
	public OpenCorp_IBM_Link(String source, String target) {
		this.source = source;
		this.target = target;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}
}
