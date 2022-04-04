package com.mulcam.hier.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter @Setter
public class User {
	private int user_id;
	private String email;
	private String nickname;
	private String job;
	private int avg_star_point;
	private String address;
	private String switchAt;
	private String introduction;
}


