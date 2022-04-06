package com.mulcam.hier.dto;

public class Product {
	private String nickname;
	private String content;
	private int work_available;
	private int commission;
	private int report;
	private String title;
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getProduct_content() {
		return content;
	}
	public void setProduct_content(String product_content) {
		this.content = product_content;
	}
	public int getWork_available() {
		return work_available;
	}
	public void setWork_available(int work_available) {
		this.work_available = work_available;
	}
	public int getCommission() {
		return commission;
	}
	public void setCommission(int commission) {
		this.commission = commission;
	}
	public int getReport() {
		return report;
	}
	public void setReport(int report) {
		this.report = report;
	}
	
	public Product() {}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

}
