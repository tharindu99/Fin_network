package com.finnetwork.models;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "newnet", catalog = "subanalysis")
public class Newnet {
	private int statement_id;
	private String predicate;
	private String subject_entity_type;
	private String 	subject_id;
	private String subjetc_entity_name;
	private String subject_opencorporates_url;
	private String object_entity_type;
	private String object_id;
	private String object_entity_name;
	private String 	object_opencorporates_url;
	private String 	statement_url;
	private String 	page_url;
	
	public Newnet() {
		
	}
	
	public Newnet(Integer id,String predicate,String subject_entity_type,String subject_id,String subjetc_entity_name,String subject_opencorporates_url,String object_entity_type,String object_id,String object_entity_name,String object_opencorporates_url,String statement_url,String page_url){
	
		this.statement_id=statement_id;;
		this.predicate=predicate;
		this.subject_entity_type=subject_entity_type;
		this.subject_id=subject_id;
		this.subjetc_entity_name=subjetc_entity_name;
		this.subject_opencorporates_url=subject_opencorporates_url;
		this.object_entity_type=object_entity_type;
		this.object_id=object_id;
		this.object_entity_name=object_entity_name;
		this.object_opencorporates_url=object_opencorporates_url;
		this.statement_url=statement_url;
		this.page_url=page_url;
		
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "statement_id", unique = true, nullable = false)
	public Integer getId() {
		return statement_id;
	}

	public void setId(Integer id) {
		this.statement_id=statement_id;
	}
	@Column(name = "predicate")
	public String getpredicate() {
		return predicate;
	}

	public void setpredicate(String predicate) {
		this.predicate = predicate;
	}
	@Column(name = "subject_entity_type")
	public String getsubject_entity_type() {
		return subject_entity_type;
	}

	public void setsubject_entity_type(String subject_entity_type) {
		this.subject_entity_type = subject_entity_type;
	}
	@Column(name = "subject_id")
	public String getsubject_id() {
		return subject_id;
	}

	public void setsubject_id(String subject_id) {
		this.subject_id= subject_id;
	}
	@Column(name = "subjetc_entity_name")
	public String getsubjetc_entity_name() {
		return subjetc_entity_name;
	}

	public void setsubjetc_entity_name(String subjetc_entity_name) {
		this.subjetc_entity_name=subjetc_entity_name;
	}
	@Column(name = "subject_opencorporates_url")
	public String getsubject_opencorporates_url() {
		return subject_opencorporates_url;
	}

	public void setsubject_opencorporates_url(String subject_opencorporates_url) {
		this.subject_opencorporates_url= subject_opencorporates_url;
	}
	@Column(name = "object_entity_type")
	public String getobject_entity_type() {
		return object_entity_type;
	}

	public void setobject_entity_type(String object_entity_type) {
		this.object_entity_type=object_entity_type;
	}
	@Column(name = "object_id")
	public String getobject_id() {
		return object_id;
	}

	public void setobject_id(String object_id) {
		this.object_id=object_id;
	}
	@Column(name = "object_entity_name")
	public String getobject_entity_name() {
		return object_entity_name;
	}

	public void setobject_entity_name(String object_entity_name) {
		this.object_entity_name=object_entity_name;
	}
	@Column(name = "object_opencorporates_url")
	public String getobject_opencorporates_url() {
		return object_opencorporates_url;
	}

	public void setobject_opencorporates_url(String object_opencorporates_url) {
		this.object_opencorporates_url=object_opencorporates_url;
	}
	@Column(name = "statement_url")
	public String getstatement_url() {
		return statement_url;
	}

	public void setstatement_url(String statement_url) {
		this.statement_url=statement_url;
	}
	@Column(name = "page_url")
	public String getpage_url() {
		return page_url;
	}

	public void setpage_url(String page_url) {
		this.page_url=page_url;
	}
	
}
