package com.mulcam.hier.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

public class FreelancerForm {
	private Integer user_id;
	private String address;
	private String address2;
	private String introduction;
	
	public FreelancerForm(Integer user_id, String address, String address2, String introduction) {
		this.user_id=user_id;
		this.address=address;
		this.address2=address2;
		this.introduction=introduction;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
}

