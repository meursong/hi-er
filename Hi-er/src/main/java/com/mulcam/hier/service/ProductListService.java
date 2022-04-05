package com.mulcam.hier.service;

import java.util.List;

import com.mulcam.hier.dto.ProductList;

public interface ProductListService {
	List<ProductList> selectProductDate(ProductList params) throws Exception;
//	public int selectTotalCount(Criteria criteria) throws Exception;
	
	List<ProductList> selectProductReviewCount(ProductList params) throws Exception;
	List<ProductList> selectProductStarPoint(ProductList params) throws Exception;
}
