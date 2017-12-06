package com.finnetwork.models;


import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tr_ibm_nodes", catalog = "newdata")
public class Tr_ibm_nodes {
	private int id;
	private String uri;
	private String CommonName_attr;
	public  Tr_ibm_nodes() {
		
	}
	
	public  Tr_ibm_nodes(Integer id, String uri,String CommonName_attr){
		this.id = id;
		this.uri = uri;
		this.CommonName_attr=CommonName_attr;
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
	@Column(name = "uri")
	public String getUri(){
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}
	@Column(name = "CommonName_attr")
	public String getCommonName_attr(){
		return CommonName_attr;
	}

	public void setCommonName_attr(String CommonName_attr) {
		this.CommonName_attr = CommonName_attr;
	}
}
