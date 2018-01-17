package com.finnetwork.models;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tr_nodes", catalog = "fin_network")
public class TR_Node {
	
	private double id;
	private String equity;
	
	public TR_Node() {
	
	}
	
	public TR_Node(double id, String equity) {
		this.id = id;
		this.equity = equity;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public double getId() {
		return id;
	}

	public void setId(double id) {
		this.id = id;
	}

	@Column(name = "equity")
	public String getEquity() {
		return equity;
	}

	public void setEquity(String equity) {
		this.equity = equity;
	}
}
