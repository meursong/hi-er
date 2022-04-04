package com.mulcam.hier.service;

import java.util.List;

import com.mulcam.hier.dto.ProductList;

public interface ProductListService {
	List<ProductList> selectProductDate() throws Exception;
	List<ProductList> selectProductReviewCount() throws Exception;
	List<ProductList> selectProductStarPoint() throws Exception;
}
