package com.mulcam.hier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulcam.hier.dao.UserDAO;
import com.mulcam.hier.dto.FreelancerForm;
import com.mulcam.hier.dto.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO userDAO;

	@Override
	public User selectEmail(int user_id) throws Exception {
		User user = userDAO.selectUSerEmail(user_id);
		if(user==null) throw new Exception("오류");
		return user;
	}
	
	@Override
	public User freelancerInfo(int user_id) throws Exception {
		User freelancer = userDAO.select_info_f(user_id);
		if(freelancer==null) throw new Exception("오류");
		return freelancer;
	}

	@Override
	public void insert_info(FreelancerForm free) throws Exception {
		userDAO.insert_info_f(free);
	}

	@Override
	public void update_type(int user_id) throws Exception {
		userDAO.update_type_f(user_id);
		
	}
}