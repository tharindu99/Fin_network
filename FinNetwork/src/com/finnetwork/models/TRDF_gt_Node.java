package com.finnetwork.models;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trdf_gt_nodes", catalog = "fin_network")
public class TRDF_gt_Node {

	private String company_id;
	private String commonName_attr;
	private String hasShortName_attr;
	private String exchangeTicker_attr;
	private String RIC_attr;
	private String taxID_attr;
	private String geoName_attr;
	private String hasCIK_attr;
	private String hasDateOfIncorporation_attr;
	private String hasIPODate_attr;
	private String hasInactiveDate_attr;
	private String hasLEI_attr;
	private String hasOrganizationFoundedDate_attr;
	private String hasPermId_attr;
	private String hasPrimaryCIK_attr;
	private String hasPrimaryCusip6_attr;
	private String industryName_attr;
	private String name_attr;
	private String organizationCountryCode_attr;
	private String organizationCountry_attr;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "company_id")
	public String getCompany_id() {
		return company_id;
	}
	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}
	@Column(name = "commonName_attr")
	public String getCommonName_attr() {
		return commonName_attr;
	}
	public void setCommonName_attr(String commonName_attr) {
		this.commonName_attr = commonName_attr;
	}
	@Column(name = "hasShortName_attr")
	public String getHasShortName_attr() {
		return hasShortName_attr;
	}
	public void setHasShortName_attr(String hasShortName_attr) {
		this.hasShortName_attr = hasShortName_attr;
	}
	@Column(name = "exchangeTicker_attr")
	public String getExchangeTicker_attr() {
		return exchangeTicker_attr;
	}
	public void setExchangeTicker_attr(String exchangeTicker_attr) {
		this.exchangeTicker_attr = exchangeTicker_attr;
	}
	@Column(name = "RIC_attr")
	public String getRIC_attr() {
		return RIC_attr;
	}
	public void setRIC_attr(String rIC_attr) {
		RIC_attr = rIC_attr;
	}
	@Column(name = "taxID_attr")
	public String getTaxID_attr() {
		return taxID_attr;
	}
	public void setTaxID_attr(String taxID_attr) {
		this.taxID_attr = taxID_attr;
	}
	@Column(name = "geoName_attr")
	public String getGeoName_attr() {
		return geoName_attr;
	}
	public void setGeoName_attr(String geoName_attr) {
		this.geoName_attr = geoName_attr;
	}
	@Column(name = "hasCIK_attr")
	public String getHasCIK_attr() {
		return hasCIK_attr;
	}
	public void setHasCIK_attr(String hasCIK_attr) {
		this.hasCIK_attr = hasCIK_attr;
	}
	@Column(name = "hasDateOfIncorporation_attr")
	public String getHasDateOfIncorporation_attr() {
		return hasDateOfIncorporation_attr;
	}
	public void setHasDateOfIncorporation_attr(String hasDateOfIncorporation_attr) {
		this.hasDateOfIncorporation_attr = hasDateOfIncorporation_attr;
	}
	@Column(name = "hasIPODate_attr")
	public String getHasIPODate_attr() {
		return hasIPODate_attr;
	}
	public void setHasIPODate_attr(String hasIPODate_attr) {
		this.hasIPODate_attr = hasIPODate_attr;
	}
	@Column(name = "hasInactiveDate_attr")
	public String getHasInactiveDate_attr() {
		return hasInactiveDate_attr;
	}
	public void setHasInactiveDate_attr(String hasInactiveDate_attr) {
		this.hasInactiveDate_attr = hasInactiveDate_attr;
	}
	@Column(name = "hasLEI_attr")
	public String getHasLEI_attr() {
		return hasLEI_attr;
	}
	public void setHasLEI_attr(String hasLEI_attr) {
		this.hasLEI_attr = hasLEI_attr;
	}
	@Column(name = "hasOrganizationFoundedDate_attr")
	public String getHasOrganizationFoundedDate_attr() {
		return hasOrganizationFoundedDate_attr;
	}
	public void setHasOrganizationFoundedDate_attr(
			String hasOrganizationFoundedDate_attr) {
		this.hasOrganizationFoundedDate_attr = hasOrganizationFoundedDate_attr;
	}
	@Column(name = "hasPermId_attr")
	public String getHasPermId_attr() {
		return hasPermId_attr;
	}
	public void setHasPermId_attr(String hasPermId_attr) {
		this.hasPermId_attr = hasPermId_attr;
	}
	@Column(name = "hasPrimaryCIK_attr")
	public String getHasPrimaryCIK_attr() {
		return hasPrimaryCIK_attr;
	}
	public void setHasPrimaryCIK_attr(String hasPrimaryCIK_attr) {
		this.hasPrimaryCIK_attr = hasPrimaryCIK_attr;
	}
	@Column(name = "hasPrimaryCusip6_attr")
	public String getHasPrimaryCusip6_attr() {
		return hasPrimaryCusip6_attr;
	}
	public void setHasPrimaryCusip6_attr(String hasPrimaryCusip6_attr) {
		this.hasPrimaryCusip6_attr = hasPrimaryCusip6_attr;
	}
	@Column(name = "industryName_attr")
	public String getIndustryName_attr() {
		return industryName_attr;
	}
	public void setIndustryName_attr(String industryName_attr) {
		this.industryName_attr = industryName_attr;
	}
	@Column(name = "name_attr")
	public String getName_attr() {
		return name_attr;
	}
	public void setName_attr(String name_attr) {
		this.name_attr = name_attr;
	}
	@Column(name = "organizationCountryCode_attr")
	public String getOrganizationCountryCode_attr() {
		return organizationCountryCode_attr;
	}
	public void setOrganizationCountryCode_attr(String organizationCountryCode_attr) {
		this.organizationCountryCode_attr = organizationCountryCode_attr;
	}
	@Column(name = "organizationCountry_attr")
	public String getOrganizationCountry_attr() {
		return organizationCountry_attr;
	}
	public void setOrganizationCountry_attr(String organizationCountry_attr) {
		this.organizationCountry_attr = organizationCountry_attr;
	}
	
}
