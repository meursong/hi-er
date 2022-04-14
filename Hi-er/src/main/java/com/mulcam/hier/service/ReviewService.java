package com.mulcam.hier.service;

import java.util.List;
import java.util.Map;

import com.mulcam.hier.dto.Review;

public interface ReviewService {
	List<Review> prodReviewList(Review params) throws Exception;
	List<Review> reviewList(Review params) throws Exception;
	List<Map<String,Integer>> reviewCount(Integer pid) throws Exception;
	Integer maxReviewCnt(Integer pid) throws Exception;

}
