package com.mulcam.hier.service;

import com.mulcam.hier.dto.User;

public interface UserService {

	User login(String email, String password) throws Exception;

	Boolean emailCheck(String useremail) throws Exception;

//	String signup(String name, String email, String password, String job) throws Exception;

}
