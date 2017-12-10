package com.finnetwork.models;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TR_IBM", catalog = "fin_network ")

public class TR_IBM {

	
	private String subject_id;
	private String subject_entity_name;
	private String object_id;
	private String object_entity_name;
	private int relationship_id;

	public TR_IBM() {
	
	}
	
	public TR_IBM(String subject_id, String subject_entity_name,String object_id, String object_entity_name,int relationship_id) {
		
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "relationship_id")
	public int getRelationship_id() {
		return relationship_id;
	}

	public void setRelationship_id(int relationship_id) {
		this.relationship_id = relationship_id;
	}
	
	@Column(name = "subject_id")
	public String getSubject_id() {
		return subject_id;
	}

	public void setSubject_id(String subject_id) {
		this.subject_id = subject_id;
	}

	@Column(name = "sbject_entity_name")
	public String getSubject_entity_name() {
		return subject_entity_name;
	}

	public void setSubject_entity_name(String subject_entity_name) {
		this.subject_entity_name = subject_entity_name;
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
}
