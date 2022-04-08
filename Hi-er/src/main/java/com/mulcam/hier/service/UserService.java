package com.mulcam.hier.service;

import com.mulcam.hier.dto.FreelancerForm;
import com.mulcam.hier.dto.FreelancerUser;
import com.mulcam.hier.dto.User;

public interface UserService  {
	User selectEmail(int user_id) throws Exception;
	FreelancerUser freelancerInfo(int user_id) throws Exception;
	void insert_info(FreelancerForm free) throws Exception;
	void update_type(int id) throws Exception;
	
	
	
	User login(String email, String password) throws Exception;

	Boolean emailCheck(String useremail) throws Exception;
 
//	String signup(String name, String email, String password, String job) throws Exception;

}
