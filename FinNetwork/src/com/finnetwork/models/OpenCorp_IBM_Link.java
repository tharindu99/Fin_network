package com.finnetwork.models;

public class OpenCorp_IBM_Link {
	
	private int source;
	private int target;
	private String context;
	private String predicate;
	
	public OpenCorp_IBM_Link() {
	
	}
	
	public OpenCorp_IBM_Link(int source, int target, String context, String predicate) {
		this.source = source;
		this.target = target;
		this.context = context;
		this.predicate = predicate;
	}

	public int getSource() {
		return source;
	}

	public void setSource(int source) {
		this.source = source;
	}

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getPredicate() {
		return predicate;
	}

	public void setPredicate(String predicate) {
		this.predicate = predicate;
	}
	
}
