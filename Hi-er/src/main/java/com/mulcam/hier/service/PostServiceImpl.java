package com.mulcam.hier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulcam.hier.dao.PostDAO;
import com.mulcam.hier.dto.Product;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	PostDAO postDAO;
	
	@Override
	public void writePost(Product prod) throws Exception {
		Integer pid = postDAO.getMaxProductId();
		if(pid==null) pid = 1;
		prod.setProduct_id(pid+1);
		postDAO.insertProduct(prod);
		postDAO.insertDesignPriceInfo(prod);
	}

	@Override
	public Product productDetail(Integer pid) throws Exception {
		Product product = postDAO.queryProduct(pid);
		if(product==null) new Exception("존재하지 않는 게시물 입니다");
		return product;
	}

	@Override
	public Product priceInfo(Integer pid) throws Exception {
		Product priceInfo = postDAO.queryDesignPriceInfo(pid);
		return priceInfo;
	}

	@Override
	public void reportPost(String reason, Integer product_id, Integer reported_userid, Integer report_userid) throws Exception  {
		postDAO.insertReport(reason, product_id, reported_userid, report_userid);
	}

	@Override
	public boolean likePost(Integer product_id, Integer liked_userid, Integer like_userid) throws Exception {
		postDAO.like_unlike(product_id,liked_userid,like_userid);
		return false;
	}
	
	

	
}
