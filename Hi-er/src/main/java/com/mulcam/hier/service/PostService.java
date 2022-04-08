package com.mulcam.hier.service;

import java.util.Map;

import com.mulcam.hier.dto.Product;

public interface PostService {

	void writePost(Product prod) throws Exception;

	Product productDetail(Integer pid) throws Exception;
	
	Product priceInfo(Integer pid) throws Exception;

	void reportPost(String reason, Integer product_id,Integer reported_userid,Integer report_userid) throws Exception ;
	
	Integer likeNum(Integer product_id, Integer like_userid) throws Exception;
	
	boolean isLike(Integer product_id, Integer like_userid) throws Exception;

	Map<String, Object> like(Integer pid, Integer like_userid) throws Exception;
	
}
