package com.mulcam.hier.service;


import com.mulcam.hier.dto.FreelancerUser;
import com.mulcam.hier.dto.User;


public interface UserService  {
	User userInfo(int user_id) throws Exception;
	FreelancerUser freelancerInfo(int user_id) throws Exception;
	void insert_info(FreelancerUser free) throws Exception;
	void update_type(int id) throws Exception;
	
	
	

}
