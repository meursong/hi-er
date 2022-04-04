package com.mulcam.hier.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulcam.hier.dao.ProductListDAO;
import com.mulcam.hier.dto.ProductList;

@Service
public class ProductListServiceImpl implements ProductListService {

	@Autowired
	ProductListDAO productListDAO;
	
	@Override
	public List<ProductList> selectProductDate() throws Exception {
		List<ProductList> product = productListDAO.selectProductDate();
		return product;
	}

	@Override
	public List<ProductList> selectProductReviewCount() throws Exception {
		List<ProductList> product = productListDAO.selectProductReviewCount();
		return product;
	}

	@Override
	public List<ProductList> selectProductStarPoint() throws Exception {
		List<ProductList> product = productListDAO.selectProductStarPoint();
		return product;
	}

}
