package com.mulcam.hier.service;

import java.util.List;

import com.mulcam.hier.dto.ProductList;

public interface ProductListService {
	
	List<ProductList> selectProductTotal(ProductList params) throws Exception;
	List<ProductList> selectProduct1(ProductList params) throws Exception;
	List<ProductList> selectProduct2(ProductList params) throws Exception;
	List<ProductList> selectProduct3(ProductList params) throws Exception;
}