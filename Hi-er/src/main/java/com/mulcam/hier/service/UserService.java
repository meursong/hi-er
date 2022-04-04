package com.mulcam.hier.service;


import com.mulcam.hier.dto.FreelancerForm;
import com.mulcam.hier.dto.User;


public interface UserService  {
	User selectEmail(int user_id) throws Exception;
	User freelancerInfo(int user_id) throws Exception;
	void insert_info(FreelancerForm free) throws Exception;
	void update_type(int id) throws Exception;
	
	
	

}
