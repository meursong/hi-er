package com.mulcam.hier.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulcam.hier.dao.ProductDAO;
import com.mulcam.hier.dao.UserDAO;
import com.mulcam.hier.dto.Product;
import com.mulcam.hier.dto.User;

@Service
public class MainServiceImpl implements MainService{

	@Autowired
	UserDAO userDAO;
	
	@Override
	public List<User> getBestUserFive() throws Exception {
		List<User> userList = userDAO.getBestUserFive();
		return userList;
	}
	
	@Autowired
	ProductDAO productDAO;
	
	@Override
	public List<Product> getBestProducts() throws Exception{
		List<Product> bestProducts = productDAO.getBestProducts();
		return bestProducts;
		
	}
	

}
