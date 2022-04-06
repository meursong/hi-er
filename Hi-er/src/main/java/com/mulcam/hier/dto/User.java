package com.mulcam.hier.dto;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

public class User {
	private String email;
	private String password;
	private String job;
	private String nickname;
	private MultipartFile profile_image;
	private int type;
	private Date createdAt;
	private User() {}
	
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
	public MultipartFile getProfile_image() {
		return profile_image;
	}
	public void setProfile_image(MultipartFile profile_image) {
		this.profile_image = profile_image;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
}


