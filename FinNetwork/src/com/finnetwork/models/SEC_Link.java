package com.finnetwork.models;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sec_edges", catalog = "fin_network")
public class SEC_Link {
	
	private int id;
	private int source;
	private int year;
	private int target;
	private String Role;
	private String ThreeSentences;
	
	public SEC_Link() {
	
	}
	
	public SEC_Link(int source, int year, int target, String Role, String ThreeSentences) {
		this.source = source;
		this.target = target;
		this.year = year;
		this.Role =Role;
		this.ThreeSentences = ThreeSentences;
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
	public int getSource() {
		return source;
	}

	public void setSource(int source) {
		this.source = source;
	}
	
	@Column(name = "year")
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Column(name = "target")
	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

	@Column(name = "Role")
	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	@Column(name = "ThreeSentences")
	public String getThreeSentences() {
		return ThreeSentences;
	}

	public void setThreeSentences(String threeSentences) {
		ThreeSentences = threeSentences;
	}
	
}
