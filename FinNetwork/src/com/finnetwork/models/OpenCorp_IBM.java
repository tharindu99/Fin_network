package com.finnetwork.models;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OpenCorp_IBM_graph_2", catalog = "TR_IBM")
public class OpenCorp_IBM {

	private int statement_id;
	private String predicate;
	private String subject_entity_type;
	private String subject_id;
	private String subject_entity_name;
	private String subject_opencorporates_url;
	private String object_entity_type;
	private String object_id;
	private String object_entity_name;
	private String object_opencorporates_url;
	private String statement_url;
	private String page_url;
	
	public OpenCorp_IBM() {
	
	}
	
	public OpenCorp_IBM(int statement_id, String predicate, String subject_entity_type, String subject_id, String subject_entity_name, String subject_opencorporates_url, String object_entity_type, String object_id, String object_entity_name, String object_opencorporates_url, String statement_url, String page_url) {
		
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "statement_id")
	public int getStatement_id() {
		return statement_id;
	}

	public void setStatement_id(int statement_id) {
		this.statement_id = statement_id;
	}

	@Column(name = "predicate")
	public String getPredicate() {
		return predicate;
	}

	public void setPredicate(String predicate) {
		this.predicate = predicate;
	}

	@Column(name = "subject_entity_type")
	public String getSubject_entity_type() {
		return subject_entity_type;
	}

	public void setSubject_entity_type(String subject_entity_type) {
		this.subject_entity_type = subject_entity_type;
	}

	@Column(name = "subject_id")
	public String getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(String subject_id) {
		this.subject_id = subject_id;
	}

	@Column(name = "subject_entity_name")
	public String getSubject_entity_name() {
		return subject_entity_name;
	}

	public void setSubject_entity_name(String subject_entity_name) {
		this.subject_entity_name = subject_entity_name;
	}

	@Column(name = "subject_opencorporates_url")
	public String getSubject_opencorporates_url() {
		return subject_opencorporates_url;
	}

	public void setSubject_opencorporates_url(String subject_opencorporates_url) {
		this.subject_opencorporates_url = subject_opencorporates_url;
	}

	@Column(name = "object_entity_type")
	public String getObject_entity_type() {
		return object_entity_type;
	}

	public void setObject_entity_type(String object_entity_type) {
		this.object_entity_type = object_entity_type;
	}

	@Column(name = "object_id")
	public String getObject_id() {
		return object_id;
	}

	public void setObject_id(String object_id) {
		this.object_id = object_id;
	}

	@Column(name = "object_entity_name")
	public String getObject_entity_name() {
		return object_entity_name;
	}

	public void setObject_entity_name(String object_entity_name) {
		this.object_entity_name = object_entity_name;
	}

	@Column(name = "object_opencorporates_url")
	public String getObject_opencorporates_url() {
		return object_opencorporates_url;
	}

	public void setObject_opencorporates_url(String object_opencorporates_url) {
		this.object_opencorporates_url = object_opencorporates_url;
	}

	@Column(name = "statement_url")
	public String getStatement_url() {
		return statement_url;
	}

	public void setStatement_url(String statement_url) {
		this.statement_url = statement_url;
	}

	@Column(name = "page_url")
	public String getPage_url() {
		return page_url;
	}

	public void setPage_url(String page_url) {
		this.page_url = page_url;
	}
}
