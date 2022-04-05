package com.mulcam.hier.dto;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter @Setter
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
}


