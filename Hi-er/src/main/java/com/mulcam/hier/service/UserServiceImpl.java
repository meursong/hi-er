package com.mulcam.hier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulcam.hier.dao.UserDAO;
import com.mulcam.hier.dto.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO UserDAO;

	@Override
	public User userInfo(String email) throws Exception {
		User user = UserDAO.selectUser(email);
		if(user==null) throw new Exception("오류");
		return user;
	}

}
