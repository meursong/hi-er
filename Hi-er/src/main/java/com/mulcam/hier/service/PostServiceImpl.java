package com.mulcam.hier.service;

import java.util.HashMap;
import java.util.Map;

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
		if(pid==null) pid = 0;
		prod.setProduct_id(pid+1);
		postDAO.insertProduct(prod);
		postDAO.insertPriceInfo(prod);
	}

	@Override
	public Product productDetail(Integer pid) throws Exception {
		Product product = postDAO.queryProduct(pid);
		if(product==null) new Exception("존재하지 않는 게시물 입니다");
		return product;
	}

	@Override
	public Product priceInfo(Integer pid) throws Exception {
		Product priceInfo = postDAO.queryPriceInfo(pid);
		return priceInfo;
	}

	@Override
	public void reportPost(String reason, Integer product_id, Integer reported_userid, Integer report_userid) throws Exception  {
		postDAO.insertReport(reason, product_id, reported_userid, report_userid);
	}

	@Override
	public Integer likeNum(Integer product_id, Integer like_userid) throws Exception {
			// 본 게시물의 좋아요 수
			return postDAO.likeNum(product_id);
	}
	
	@Override
	public boolean isLike(Integer product_id, Integer like_userid) throws Exception {
		return postDAO.likeCheck(product_id, like_userid).equals(1);
	}

	@Override
	public Map<String, Object> like(Integer pid, Integer like_userid)  throws Exception {
		Map<String, Object> likeInfo = new HashMap<String,Object>();
		
		Product product = postDAO.queryProduct(pid);
		Integer liked_userid = product.getSeller_id();
		//Integer liked_userid = 10;
		
		boolean isLike = postDAO.likeCheck(pid, like_userid).equals(1);
		if (isLike == true) {
			postDAO.unlike(pid, like_userid);
		} else {
			postDAO.like(pid, liked_userid, like_userid);
		}
		
		isLike = postDAO.likeCheck(pid, like_userid).equals(1);
		Integer likedNum = postDAO.likeNum(pid);
		
		likeInfo.put("likeNum", likedNum);
		likeInfo.put("isLike", isLike);
		return likeInfo;
	}
	
}
