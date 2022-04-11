package com.mulcam.hier.dto;

import java.sql.Date;

public class FreelancerUser extends User {
	private int f_id;
	private String address;
	private float avg_star_point;
	private String introduction;
	private Date switchAt;

	

	public FreelancerUser(int f_id, String address, float avg_star_point, String introduction, Date switchAt) {
		super();
		this.f_id = f_id;
		this.address = address;
		this.avg_star_point = avg_star_point;
		this.introduction = introduction;
		this.switchAt = switchAt;
	}
	public FreelancerUser(int f_id, String address, String introduction) {
		super();
		this.f_id = f_id;
		this.address = address;
		this.introduction = introduction;
	}
	public int getF_id() {
		return f_id;
	}
	public void setF_id(int f_id) {
		this.f_id = f_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
//	public String getAddress2() {
//		return address2;
//	}
//	public void setAddress2(String address2) {
//		this.address2 = address2;
//	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public Date getSwitchAt() {
		return switchAt;
	}

	public void setSwitchAt(Date switchAt) {
		this.switchAt = switchAt;
	}

	public float getAvg_star_point() {
		return avg_star_point;
	}

	public void setAvg_star_point(float avg_star_point) {
		this.avg_star_point = avg_star_point;
	}

	
}

