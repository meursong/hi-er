package com.mulcam.hier.dto;

import org.springframework.web.multipart.MultipartFile;


public class ProductList extends Criteria {
	
	//게시글 이미지 필요
	private int product_id;
	private String category;
	private String nickname;
	private MultipartFile filename1;
	private String job;
	private String title;
	private int commission;
	private float avg_star_point;
	private int review_count;
	private String createdAt;


	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getCommission() {
		return commission;
	}

	public void setCommission(int commission) {
		this.commission = commission;
	}

	public float getAvg_star_point() {
		return avg_star_point;
	}

	public void setAvg_star_point(float avg_star_point) {
		this.avg_star_point = avg_star_point;
	}

	public int getReview_count() {
		return review_count;
	}

	public void setReview_count(int review_count) {
		this.review_count = review_count;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public MultipartFile getFilename1() {
		return filename1;
	}

	public void setFilename1(MultipartFile filename1) {
		this.filename1 = filename1;
	}
}
