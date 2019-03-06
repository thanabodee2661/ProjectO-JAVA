package com.example.TestCreateProject.Model;

import java.math.BigDecimal;

public class Searchall {
     private String nameFiction;
     private String type;
     private String preview;
     private BigDecimal sum;
     private long totalcomment;
     private long totallike;
     
	public String getNameFiction() {
		return nameFiction;
	}
	public void setNameFiction(String nameFiction) {
		this.nameFiction = nameFiction;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPreview() {
		return preview;
	}
	public void setPreview(String preview) {
		this.preview = preview;
	}
	public BigDecimal getSum() {
		return sum;
	}
	public void setSum(BigDecimal sum) {
		this.sum = sum;
	}
	public long getTotalcomment() {
		return totalcomment;
	}
	public void setTotalcomment(long totalcomment) {
		this.totalcomment = totalcomment;
	}
	public long getTotallike() {
		return totallike;
	}
	public void setTotallike(long totallike) {
		this.totallike = totallike;
	}
}