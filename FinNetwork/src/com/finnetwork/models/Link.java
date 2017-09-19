package com.finnetwork.models;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "base_network_links", catalog = "fin_network")
public class Link {
	private int link_id;
	private int source;
	private int target;
	private String fillingDate;
	private String role;
	private String three_sentences;
	
	public Link() {
		
	}
	
	public Link(int link_id, int source, int target, String fillingDate, String role, String three_sentences) {
		this.link_id = link_id;
		this.source = source;
		this.target = target;
		this.fillingDate = fillingDate;
		this.role = role;
		this.three_sentences = three_sentences;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "link_id")
	public Integer getLink_id() {
		return link_id;
	}

	public void setLink_id(Integer link_id) {
		this.link_id = link_id;
	}
	
	@Column(name = "source")
	public int getSource() {
		return source;
	}

	public void setSource(int source) {
		this.source = source;
	}

	@Column(name = "target")
	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

	@Column(name = "FILING_DATE")
	public String getFillingDate() {
		return fillingDate;
	}

	public void setFillingDate(String fillingDate) {
		this.fillingDate = fillingDate;
	}

	@Column(name = "ROLE")
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Column(name = "THREE_SENTENCES")
	public String getThree_sentences() {
		return three_sentences;
	}

	public void setThree_sentences(String three_sentences) {
		this.three_sentences = three_sentences;
	}	
}
