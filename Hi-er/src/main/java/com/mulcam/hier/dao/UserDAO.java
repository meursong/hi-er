package com.mulcam.hier.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mulcam.hier.dto.User;

@Mapper
@Repository
public interface UserDAO {
	public User selectUser(String email) throws Exception;
}
