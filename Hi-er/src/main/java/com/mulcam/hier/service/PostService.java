package com.mulcam.hier.service;

import com.mulcam.hier.dto.Product;

public interface PostService {

	void writePost(Product prod) throws Exception;

	Product productDetail(Integer pid) throws Exception;
	
	Product priceInfo(Integer pid) throws Exception;

	void reportPost(String reason, Integer product_id,Integer reported_userid,Integer report_userid) throws Exception ;
	
	boolean likePost(Integer product_id,Integer liked_userid,Integer like_userid) throws Exception ;
	
}
