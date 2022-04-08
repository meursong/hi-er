package com.mulcam.hier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulcam.hier.dao.UserDAO;
import com.mulcam.hier.dto.FreelancerUser;
import com.mulcam.hier.dto.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDAO userDAO;


	@Override
	public User userInfo(int user_id) throws Exception {
		User user = userDAO.selectUser(user_id);
		if(user==null) throw new Exception("오류");
		return user;
	}
	
	@Override
	public FreelancerUser freelancerInfo(int user_id) throws Exception {
		FreelancerUser freelancer = userDAO.select_info_f(user_id);
		if(freelancer==null) throw new Exception("오류");
		return freelancer;
	}

	@Override
	public void insert_info(FreelancerUser free) throws Exception {
		userDAO.insert_info_f(free);
	}

	@Override
	public void update_type(int user_id) throws Exception {
		userDAO.update_type_f(user_id);
		
	}
}