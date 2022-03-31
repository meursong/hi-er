package com.mulcam.hier.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mulcam.hier.dto.Review;

@Mapper
@Repository
public interface ReviewDAO {
	public List<Review> selectReview(int seller_id) throws Exception;
}
