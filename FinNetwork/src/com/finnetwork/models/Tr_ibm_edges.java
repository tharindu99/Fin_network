package com.finnetwork.models;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tr_ibm_edges", catalog = "newdata")
public class Tr_ibm_edges {
	private int id;
	private String src;
	private String dst;
	private String context;
	private String predicate;	
	
	public Tr_ibm_edges() {
		
	}
	
	public Tr_ibm_edges(Integer id,String src,String dst,String context,String predicate) {
		this.id = id;
		this.src = src;
		this.dst = dst;
		this.context=context;
		this.predicate=predicate;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "src")
	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}
	@Column(name = "dst")
	public String getDst() {
		return dst;
	}

	public void setDst(String dst) {
		this.dst =dst;
	}
	@Column(name = "context")
	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context =context;
	}
	@Column(name = "predicate")
	public String getPredicate() {
		return predicate;
	}

	public void setPredicate(String predicate) {
		this.predicate =predicate;
	}
	
}
