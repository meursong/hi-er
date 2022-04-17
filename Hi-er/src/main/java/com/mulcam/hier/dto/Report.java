package com.mulcam.hier.dto;

public class Report {
	int report_id;
	int product_id; //신고당한 게시물
	String reason; //신고사유
	int reported_userid; //신고당한 유저(유저가 작성한 게시물이 일정 횟수 이상 누적 시 회원 제재 )
	int report_userid; //신고한 유저
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public int getReported_userid() {
		return reported_userid;
	}
	public void setReported_userid(int reported_userid) {
		this.reported_userid = reported_userid;
	}
	public int getReport_userid() {
		return report_userid;
	}
	public void setReport_userid(int report_userid) {
		this.report_userid = report_userid;
	}
	public int getReport_id() {
		return report_id;
	}
	public void setReport_id(int report_id) {
		this.report_id = report_id;
	}
	
	//******신고한 시간 추가 필요
	
	
	
}
