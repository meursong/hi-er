package com.mulcam.hier.dto;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class User {
	int user_id, type,product_id,seller_id,f_id;
	public int getF_id() {
		return f_id;
	}

	public void setF_id(int f_id) {
		this.f_id = f_id;
	}
	float avg_star_point;
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

	public float getAvg_star_point() {
		return avg_star_point;
	}

	public void setAvg_star_point(float avg_star_point) {
		this.avg_star_point = avg_star_point;
	}
	String email, password, job, nickname, name, profile_image, interest, introduction;
	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	Date createdAt, updatedAt; 
	
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", type=" + type + ", email=" + email + ", password=" + password + ", job="
				+ job + ", nickname=" + nickname + ", name=" + name + ", profile_image=" + profile_image + ", interest="
				+ interest + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getProfile_image() {
		return profile_image;
	}
	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}


