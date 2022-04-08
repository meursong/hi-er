package com.mulcam.hier.dto;

import java.sql.Date;

public class Review {
	private int review_wid;
	private int product_id;
	private int seller_id;
	private String content;
	private int star_point;
	private Date CreatedAt;
	private String nickname;
	public int getReview_wid() {
		return review_wid;
	}
	public void setReview_wid(int review_wid) {
		this.review_wid = review_wid;
	}
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getStar_point() {
		return star_point;
	}
	public void setStar_point(int star_point) {
		this.star_point = star_point;
	}
	public Date getCreatedAt() {
		return CreatedAt;
	}
	public void setCreatedAt(Date createdAt) {
		CreatedAt = createdAt;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
}
