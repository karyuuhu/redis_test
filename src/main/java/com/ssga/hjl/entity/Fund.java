package com.ssga.hjl.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Fund implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String fundCode;
	private String tickerSymbol;
	private String name;
	private String status;
	private Set<Document> documents = new HashSet<Document>();
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFundCode() {
		return fundCode;
	}
	public void setFundCode(String fundCode) {
		this.fundCode = fundCode;
	}
	public String getTickerSymbol() {
		return tickerSymbol;
	}
	public void setTickerSymbol(String tickerSymbol) {
		this.tickerSymbol = tickerSymbol;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Set<Document> getDocuments() {
		return documents;
	}
	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}
	
	public String toString() {
		String fundInfo = this.fundCode + "," + this.name;
		fundInfo = fundInfo + "[";
		for (Document doc : this.documents) {
			fundInfo = fundInfo + doc.getTitle() + "," + doc.getPathType() + ";";
		}
		fundInfo = fundInfo + "]";
		return fundInfo;
	}
}
