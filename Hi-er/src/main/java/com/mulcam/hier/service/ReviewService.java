package com.mulcam.hier.service;

import java.util.List;

import com.mulcam.hier.dto.Review;

public interface ReviewService {
	List<Review> prodReviewList(Integer product_id) throws Exception;
	List<Review> reviewList(Review params) throws Exception;

}
