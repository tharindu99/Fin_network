package com.finnetwork.models;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tr_edges", catalog = "fin_network")
public class TR_Link {

	private int id;
	private double source;
	private double target;
	private String context;
	private String predicts;
	
	public TR_Link() {
		
	}
	
	public TR_Link(int id, double source, double target, String context, String predicts) {
		
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "source")
	public double getSource() {
		return source;
	}

	public void setSource(double source) {
		this.source = source;
	}

	@Column(name = "target")
	public double getTarget() {
		return target;
	}

	public void setTarget(double target) {
		this.target = target;
	}

	@Column(name = "context")
	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	@Column(name = "predicts")
	public String getPredicts() {
		return predicts;
	}

	public void setPredicts(String predicts) {
		this.predicts = predicts;
	}
	
}
