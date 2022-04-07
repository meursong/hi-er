package com.mulcam.hier.service;

import java.util.List;

import com.mulcam.hier.dto.Product;
import com.mulcam.hier.dto.User;

public interface MainService {

	List<User> getBestUserFive() throws Exception;
	List<Product> getBestProducts() throws Exception;
	List<Product> searchProduct(String keyword) throws Exception;
}
