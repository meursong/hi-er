package com.mulcam.hier.service;

import java.util.List;

import com.mulcam.hier.dto.Review;

public interface ReviewService {
	List<Review> reviewList(int seller_id) throws Exception;
}
