package com.mulcam.hier.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.mulcam.hier.others.PaginationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulcam.hier.dao.ReviewDAO;
import com.mulcam.hier.dto.Review;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewDAO reviewDAO;
	
	@Override
	public List<Review> reviewList(Review params) throws Exception {
		List<Review> review = Collections.emptyList();

		int reviewcount = reviewDAO.selectCount(params);

		PaginationInfo paginationInfo = new PaginationInfo(params);
		paginationInfo.setTotalRecordCount(reviewcount);

		params.setPaginationInfo(paginationInfo);
		if (reviewcount > 0) {
			review = reviewDAO.selectReview(params);
		}
		return review;
	}

	@Override
	public List<Review> prodReviewList(Review params) throws Exception {
		List<Review> review = Collections.emptyList();
		
		Integer reviewcount = reviewDAO.selectMaxCount(params);
		
		PaginationInfo paginationInfo = new PaginationInfo(params);
		paginationInfo.setTotalRecordCount(reviewcount);
		
		params.setPaginationInfo(paginationInfo);
		if (reviewcount > 0) {
			review = reviewDAO.selectProdReview(params);
		}
		
		return review;
	}

	@Override
	public List<Map<String,Integer>> reviewCount(Integer pid) throws Exception {
		List<Map<String,Integer>> reviewCount = reviewDAO.selectReviewCount(pid);
		return reviewCount;
	}

	@Override
	public Integer maxReviewCnt(Integer pid) throws Exception {
		Integer maxReviewCnt = reviewDAO.totalReviewCount(pid);
		return maxReviewCnt;
	}

	

}
