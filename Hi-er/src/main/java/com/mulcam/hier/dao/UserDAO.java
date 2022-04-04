package com.mulcam.hier.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mulcam.hier.dto.FreelancerForm;
import com.mulcam.hier.dto.User;

@Mapper
@Repository
public interface UserDAO {
	public User selectUSerEmail(int user_id) throws Exception;
    public User select_info_f(int user_id) throws Exception;
    public void insert_info_f(FreelancerForm f_info) throws Exception;
    public void update_type_f(int user_id) throws Exception;
}
