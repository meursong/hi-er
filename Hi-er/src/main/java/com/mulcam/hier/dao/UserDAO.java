package com.mulcam.hier.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mulcam.hier.dto.User;

@Mapper
@Repository
public interface UserDAO {
	public User selectUser(String nickname) throws Exception;
	public List<User> getBestUserFive() throws Exception;
}
