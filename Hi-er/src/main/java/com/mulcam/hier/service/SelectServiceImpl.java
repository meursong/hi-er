package com.mulcam.hier.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulcam.hier.dao.UserDAO;
import com.mulcam.hier.dto.SelectP;

@Service
public class SelectServiceImpl implements SelectService{
	
	@Autowired
	UserDAO userDAO;
	
	@Override
	public List<SelectP> getList() throws Exception{
		List<SelectP> selectList = userDAO.getList();
		if(selectList == null) throw new Exception("없음  ");
		return selectList;
	}
	
	

}
