package com.mulcam.hier.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mulcam.hier.dto.Review;

@Mapper
@Repository
public interface ReviewDAO {
	public List<Review> selectProdReview(Review review) throws Exception;
	public List<Review> selectReview(Review review) throws Exception;
	public int selectCount(Review review) throws Exception;
	public Integer selectMaxCount(Review review) throws Exception;
}
