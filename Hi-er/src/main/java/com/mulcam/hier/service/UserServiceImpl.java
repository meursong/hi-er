package com.mulcam.hier.service;

import java.util.HashMap;
import java.util.Map;

import com.mulcam.hier.dto.FreelancerUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulcam.hier.dao.UserDAO;
import com.mulcam.hier.dto.User;

import groovyjarjarantlr4.v4.parse.ANTLRParser.throwsSpec_return;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDAO ud;
	 
	@Override
	public User selectEmail(int user_id) throws Exception {
		User user = ud.selectUserEmail(user_id);
		if(user==null) throw new Exception("오류");
		return user;
	}
	
	@Override
	public User login(String email, String password) throws Exception {
		Map<String, String> param = new HashMap<String, String>();
		param.put("email", email);
		param.put("password",password);
		User user = ud.login(param);
		if (user == null) {
			throw new Exception("이메일 또는 비밀번호를 확인해주세요.");
		}
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

	@Override
	public Boolean nicknameCheck(String usernickname) throws Exception {
		Boolean result = false;
		String name = ud.nicknameCheck(usernickname);
		if (name == null) {
			result = true;
		}
		return result;
	}
	
	@Override
	public FreelancerUser freelancerInfo(int seller_id) throws Exception {
		FreelancerUser freelancer = ud.select_info_f(seller_id);
		if(freelancer==null) throw new Exception("오류");
		return freelancer;
	}

	@Override
	public void insert_info(FreelancerUser free) throws Exception {
		ud.insert_info_f(free);
	}

	@Override
	public void update_type(int user_id) throws Exception {
		ud.update_type_f(user_id);
		
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

	@Override
	public void signup(User user) throws Exception {
		ud.insert_user(user);
	}
}
