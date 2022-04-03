package com.mulcam.hier.service;

import com.mulcam.hier.dto.Product;

public interface PostService {

	void writePost(Product prod) throws Exception;

	Product productDetail(Integer pid) throws Exception;
	
}
