package com.finnetwork.models;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tnic2_nodes", catalog = "fin_network")
public class TNIC2_Node {
	
	private int id;
	private String ticker_symbol;
	private String security;
	private String gics_Sector;
	private String gics_sub_Industry;
	private String address_of_headquarters;
	private String date_first_added;
	private String cik;
	private String naics;
	private String open_corporate_id;
	private String ConfirmCIK;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "ticker_symbol")
	public String getTicker_symbol() {
		return ticker_symbol;
	}
	public void setTicker_symbol(String ticker_symbol) {
		this.ticker_symbol = ticker_symbol;
	}
	@Column(name = "security")
	public String getSecurity() {
		return security;
	}
	public void setSecurity(String security) {
		this.security = security;
	}
	@Column(name = "gics_Sector")
	public String getGics_Sector() {
		return gics_Sector;
	}
	public void setGics_Sector(String gics_Sector) {
		this.gics_Sector = gics_Sector;
	}
	@Column(name = "gics_sub_Industry")
	public String getGics_sub_Industry() {
		return gics_sub_Industry;
	}
	public void setGics_sub_Industry(String gics_sub_Industry) {
		this.gics_sub_Industry = gics_sub_Industry;
	}
	@Column(name = "address_of_headquarters")
	public String getAddress_of_headquarters() {
		return address_of_headquarters;
	}
	public void setAddress_of_headquarters(String address_of_headquarters) {
		this.address_of_headquarters = address_of_headquarters;
	}
	@Column(name = "date_first_added")
	public String getDate_first_added() {
		return date_first_added;
	}
	public void setDate_first_added(String date_first_added) {
		this.date_first_added = date_first_added;
	}
	@Column(name = "cik")
	public String getCik() {
		return cik;
	}
	public void setCik(String cik) {
		this.cik = cik;
	}
	@Column(name = "naics")
	public String getNaics() {
		return naics;
	}
	public void setNaics(String naics) {
		this.naics = naics;
	}
	@Column(name = "open_corporate_id")
	public String getOpen_corporate_id() {
		return open_corporate_id;
	}
	public void setOpen_corporate_id(String open_corporate_id) {
		this.open_corporate_id = open_corporate_id;
	}
	@Column(name = "ConfirmCIK")
	public String getConfirmCIK() {
		return ConfirmCIK;
	}
	public void setConfirmCIK(String confirmCIK) {
		ConfirmCIK = confirmCIK;
	}
	
}
