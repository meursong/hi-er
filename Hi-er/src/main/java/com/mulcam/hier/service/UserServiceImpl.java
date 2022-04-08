package com.mulcam.hier.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulcam.hier.dao.UserDAO;
import com.mulcam.hier.dto.User;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDAO ud;
	 
	@Override
	public User login(String email, String password) throws Exception {
		Map<String, String> param = new HashMap<String, String>();
		param.put("email", email);
		param.put("password",password);
		User user = ud.login(param);
		user.setPassword("안가르쳐주지");
		return user;
	}

	@Override
	public Boolean emailCheck(String useremail) throws Exception {
		Boolean result = false;
		String name = ud.emailCheck(useremail);
		if (name == null) {
			result = true;
		}
		return result;
	}
	
//	@Override
//	public String signup(String name,String email, String password, String job ) throws Exception {
//		Map<String, String> param = new HashMap<String, String>();
//		param.put("name", name);
//		param.put("email", email);
//		param.put("password", password);
//		param.put("job", job);
//		String name = ud.login(param);
//		return name;
//	}
}
