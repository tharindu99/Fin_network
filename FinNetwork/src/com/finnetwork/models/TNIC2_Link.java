package com.finnetwork.models;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tnic2_edges", catalog = "fin_network")
public class TNIC2_Link {
	
	private int id;
	private int year;
	private String CIK_1;
	private String CIK_2;
	private double score;
	
	public TNIC2_Link(){
	}
	public TNIC2_Link(int year,String CIK_1,String CIK_2,double score){	
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
	
	@Column(name = "year")
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Column(name = "CIK_1")
	public String getCIK_1() {
		return CIK_1;
	}
	public void setCIK_1(String cIK_1) {
		CIK_1 = cIK_1;
	}
	@Column(name = "CIK_2")
	public String getCIK_2() {
		return CIK_2;
	}
	public void setCIK_2(String cIK_2) {
		CIK_2 = cIK_2;
	}
	@Column(name = "score")
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	
	

}
