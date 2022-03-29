package com.mulcam.hier.dto;

import java.sql.Date;

public class Product {
	private int product_id;
	private int seller_id;
	private int work_available;
	private String title;
	private int price;
	private String category;
	private String content;
	private int commission;
	private String refund_policy;
	private Date createdAt;
	private Date updatedAt;
	
	public Product() {}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public int getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}

	public int getWork_available() {
		return work_available;
	}

	public void setWork_available(int work_available) {
		this.work_available = work_available;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getCommission() {
		return commission;
	}

	public void setCommission(int commission) {
		this.commission = commission;
	}

	public String getRefund_policy() {
		return refund_policy;
	}

	public void setRefund_policy(String refund_policy) {
		this.refund_policy = refund_policy;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	

}
