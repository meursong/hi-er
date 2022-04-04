package com.mulcam.hier.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter
@RequiredArgsConstructor
public class FreelancerForm {
	private int f_id;
	private String address;
	private String address2;
	private String introduction;
	
	public FreelancerForm(int f_id, String address, String address2, String introduction) {
		this.f_id=f_id;
		this.address=address;
		this.address2=address2;
		this.introduction=introduction;
	}

}

