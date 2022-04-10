package com.mulcam.hier.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mulcam.hier.dto.FreelancerForm;
import com.mulcam.hier.dto.SelectP;
import com.mulcam.hier.dto.FreelancerUser;
import com.mulcam.hier.dto.User;

@Mapper
@Repository
public interface UserDAO {
	public User selectUSerEmail(int user_id) throws Exception;
    public FreelancerUser select_info_f(int user_id) throws Exception;
    public void insert_info_f(FreelancerForm f_info) throws Exception;

	User login(Map<String, String> param) throws Exception;

	String emailCheck(String useremail) throws Exception;

	//	String signup(Map<String, String> param) throws Exception;
	public List<User> getBestUserFive() throws Exception;
	public List <SelectP> getList() throws Exception;
	public User selectUser(int user_id) throws Exception;
  	public void insert_info_f(FreelancerUser f_info) throws Exception;
  	public void update_type_f(int user_id) throws Exception;
	public String emailCheck(String useremail);
	public User login(Map<String, String> param);
}
