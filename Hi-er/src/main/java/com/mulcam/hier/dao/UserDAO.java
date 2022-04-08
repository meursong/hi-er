package com.mulcam.hier.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mulcam.hier.dto.User;

@Mapper
@Repository
public interface UserDAO {

	User login(Map<String, String> param) throws Exception;

	String emailCheck(String useremail) throws Exception;

//	String signup(Map<String, String> param) throws Exception;

}