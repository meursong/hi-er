package com.mulcam.hier.dto;

public class FreelancerUser {
	private int f_id;
	private String address;
	private String address2;
	private String introduction;
	
	public FreelancerUser(String address, String address2, String introduction) {
		this.address=address;
		this.address2=address2;
		this.introduction=introduction;
	}
	public FreelancerUser(int f_id, String address, String address2, String introduction) {
		this.f_id=f_id;
		this.address=address;
		this.address2=address2;
		this.introduction=introduction;
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

