package com.mulcam.hier.dto;

import com.mulcam.hier.others.Criteria;
import com.mulcam.hier.others.Time;

import java.sql.Date;

public class Review extends Criteria {
	private int review_wid;
	private int product_id;
	private int user_id;
	private int seller_id;
	private String content;
	private int star_point;
	private String createdAt;
	private String nickname;

	private int count;
	
	
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

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = Time.calculateTime(createdAt);
	}
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}
