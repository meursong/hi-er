package com.mulcam.hier.dao;

import java.util.List;
import java.util.Map;

import com.mulcam.hier.dto.FreelancerForm;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mulcam.hier.dto.FreelancerUser;
import com.mulcam.hier.dto.SelectP;
import com.mulcam.hier.dto.User;

@Mapper
@Repository
public interface UserDAO {
	public User selectUserEmail(int user_id) throws Exception;
    public FreelancerUser select_info_f(int seller_id) throws Exception;
	public void insert_info_f(FreelancerForm f_info) throws Exception;
	public User selectType(int user_id) throws Exception;
	User login(Map<String, String> param) throws Exception;

	String emailCheck(String useremail) throws Exception;

	String nicknameCheck(String usernickname) throws Exception;

	public List<User> getBestUserFive() throws Exception;
	public List <SelectP> getList() throws Exception;
	public User selectUser(int user_id) throws Exception;
  	public void update_type_f(int user_id) throws Exception;
	public void insert_user(User user) throws Exception;
	public FreelancerUser sellet_seller(int seller_id) throws Exception;
}
