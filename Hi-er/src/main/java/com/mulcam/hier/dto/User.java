package com.mulcam.hier.dto;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {
	private String email;
	private String password;
	private String job;
	private String nickname;
	private MultipartFile profile_image;
	private int type;
	private Date updateAt;
	
	public User() {}
}


