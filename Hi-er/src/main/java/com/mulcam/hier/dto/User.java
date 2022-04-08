package com.mulcam.hier.dto;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


public class User {
	private int user_id;
	private String email;
	private String nickname;
	private MultipartFile profile_image;
	private String job;
	private float avg_star_point;
	private String address;
	private Date switchAt;
	private String introduction;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public float getAvg_star_point() {
		return avg_star_point;
	}

	public void setAvg_star_point(float avg_star_point) {
		this.avg_star_point = avg_star_point;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getSwitchAt() {
		return switchAt;
	}

	public void setSwitchAt(Date switchAt) {
		this.switchAt = switchAt;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
}


