package com.finnetwork.models;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "feiii_y2_working", catalog="fin_network")
public class FeiiiY2Working {
	
	private int id;
	private String DOCUMENT_TYPE;
	private String FILER_NAME;
	private String FILER_CIK;
	private String FILING_INTERVAL;
	private String FILING_DATE;
	private String MENTIONED_FINANCIAL_ENTITY;
	private String PP_RSSD_ID;
	private String ROLE;
	private String THREE_SENTENCES;
	
	public FeiiiY2Working() {
		
	}
	public FeiiiY2Working(String DOCUMENT_TYPE, String FILER_NAME, String FILER_CIK, String FILING_INTERVAL, String FILING_DATE, String MENTIONED_FINANCIAL_ENTITY, String PP_RSSD_ID, String ROLE, String THREE_SENTENCES) {
		this.DOCUMENT_TYPE = DOCUMENT_TYPE;
		this.FILER_NAME = FILER_NAME;
		this.FILER_CIK = FILER_CIK;
		this.FILING_INTERVAL = FILING_INTERVAL;
		this.FILING_DATE = FILING_DATE;
		this.MENTIONED_FINANCIAL_ENTITY = MENTIONED_FINANCIAL_ENTITY;
		this.PP_RSSD_ID = PP_RSSD_ID;
		this.ROLE = ROLE;
		this.THREE_SENTENCES = THREE_SENTENCES;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	@Column(name="DOCUMENT_TYPE")
	public String getDOCUMENT_TYPE() {
		return DOCUMENT_TYPE;
	}
	public void setDOCUMENT_TYPE(String dOCUMENT_TYPE) {
		DOCUMENT_TYPE = dOCUMENT_TYPE;
	}
	@Column(name="FILER_NAME")
	public String getFILER_NAME() {
		return FILER_NAME;
	}
	public void setFILER_NAME(String fILER_NAME) {
		FILER_NAME = fILER_NAME;
	}
	@Column(name="FILER_CIK")
	public String getFILER_CIK() {
		return FILER_CIK;
	}
	public void setFILER_CIK(String fILER_CIK) {
		FILER_CIK = fILER_CIK;
	}
	@Column(name="FILING_INTERVAL")
	public String getFILING_INTERVAL() {
		return FILING_INTERVAL;
	}
	public void setFILING_INTERVAL(String fILING_INTERVAL) {
		FILING_INTERVAL = fILING_INTERVAL;
	}
	@Column(name="FILING_DATE")
	public String getFILING_DATE() {
		return FILING_DATE;
	}
	public void setFILING_DATE(String fILING_DATE) {
		FILING_DATE = fILING_DATE;
	}
	@Column(name="MENTIONED_FINANCIAL_ENTITY")
	public String getMENTIONED_FINANCIAL_ENTITY() {
		return MENTIONED_FINANCIAL_ENTITY;
	}
	public void setMENTIONED_FINANCIAL_ENTITY(String mENTIONED_FINANCIAL_ENTITY) {
		MENTIONED_FINANCIAL_ENTITY = mENTIONED_FINANCIAL_ENTITY;
	}
	@Column(name="PP_RSSD_ID")
	public String getPP_RSSD_ID() {
		return PP_RSSD_ID;
	}
	public void setPP_RSSD_ID(String pP_RSSD_ID) {
		PP_RSSD_ID = pP_RSSD_ID;
	}
	@Column(name="ROLE")
	public String getROLE() {
		return ROLE;
	}
	public void setROLE(String rOLE) {
		ROLE = rOLE;
	}
	@Column(name="THREE_SENTENCES")
	public String getTHREE_SENTENCES() {
		return THREE_SENTENCES;
	}
	public void setTHREE_SENTENCES(String tHREE_SENTENCES) {
		THREE_SENTENCES = tHREE_SENTENCES;
	}
}
