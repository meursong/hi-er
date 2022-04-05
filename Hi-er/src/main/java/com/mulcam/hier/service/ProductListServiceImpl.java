package com.mulcam.hier.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulcam.hier.dao.ProductListDAO;
import com.mulcam.hier.dto.PaginationInfo;
import com.mulcam.hier.dto.ProductList;

@Service
public class ProductListServiceImpl implements ProductListService {

	@Autowired
	ProductListDAO productListDAO;

	@Override
	public List<ProductList> selectProductDate(ProductList params) throws Exception {

		List<ProductList> product = Collections.emptyList();

		int totalCount = productListDAO.selectTotalCount(params);

		PaginationInfo paginationInfo = new PaginationInfo(params);
		paginationInfo.setTotalRecordCount(totalCount);

		params.setPaginationInfo(paginationInfo);

		if (totalCount > 0) {
			product = productListDAO.selectProductDate(params);
		}

		return product;
	}

	@Override
	public List<ProductList> selectProductReviewCount(ProductList params) throws Exception {

		List<ProductList> product = Collections.emptyList();

		int totalCount = productListDAO.selectTotalCount(params);

		PaginationInfo paginationInfo = new PaginationInfo(params);
		paginationInfo.setTotalRecordCount(totalCount);

		params.setPaginationInfo(paginationInfo);

		if (totalCount > 0) {
			product = productListDAO.selectProductReviewCount(params);
		}
		return product;
	}

	@Override
	public List<ProductList> selectProductStarPoint(ProductList params) throws Exception {
		List<ProductList> product = Collections.emptyList();

		int totalCount = productListDAO.selectTotalCount(params);

		PaginationInfo paginationInfo = new PaginationInfo(params);
		paginationInfo.setTotalRecordCount(totalCount);
		
		params.setPaginationInfo(paginationInfo);

		if (totalCount > 0) {
			product = productListDAO.selectProductStarPoint(params);
		}
		return product;
	}

}
