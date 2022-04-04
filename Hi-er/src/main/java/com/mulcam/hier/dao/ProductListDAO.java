package com.mulcam.hier.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mulcam.hier.dto.ProductList;

@Mapper
@Repository
public interface ProductListDAO {
	public List<ProductList> selectProductDate();
	public List<ProductList> selectProductReviewCount();
	public List<ProductList> selectProductStarPoint();

}
