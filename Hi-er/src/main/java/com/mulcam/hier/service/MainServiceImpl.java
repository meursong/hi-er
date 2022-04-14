package com.mulcam.hier.service;

import java.io.Console;
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
	public List<User> getBestUser() throws Exception {
		List<User> bestUser = userDAO.getBestUser();
		return bestUser;
	}
	
	@Autowired
	ProductDAO productDAO;
	
	@Override
	public List<Product> getBestProducts() throws Exception{
		List<Product> bestProducts = productDAO.getBestProducts();
//		if (bestProducts.size() < 5) {
//			List<Product> addedProducts = productDAO.getProducts();
//			for (Product b : bestProducts) {
//				for (Product a : addedProducts) {
//					if(bestProducts.size() == 5) {
//						break;
//					} else {
//						if (b.getProduct_id() != a.getProduct_id()) {
//							bestProducts.add(a);
//						}
//					}
//				}
//				break;
//			}	
//		}
		return bestProducts;
		
	}

	@Override
	public List<Product> searchProduct(String keyword) throws Exception {
		List<Product> result = productDAO.searchProduct(keyword);
		return result;
	}
	

}

