package com.mulcam.hier.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulcam.hier.dao.ReviewDAO;
import com.mulcam.hier.dto.Review;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewDAO reviewDAO;
	
	@Override
	public List<Review> reviewList(int seller_id) throws Exception {
		List<Review> review = reviewDAO.selectReview(seller_id);
//		if(review==null) throw new Exception("오류");
		return review;
	}

	@Override
	public List<Review> prodReviewList(int product_id) throws Exception {
		List<Review> review = reviewDAO.selectProdReview(product_id);
		return review;
	}

}
