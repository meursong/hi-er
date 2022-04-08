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
	public List<ProductList> selectProductTotal(ProductList params) throws Exception {

		List<ProductList> product = Collections.emptyList();

		int totalCount = productListDAO.selectTotalCount();

		PaginationInfo paginationInfo = new PaginationInfo(params);
		paginationInfo.setTotalRecordCount(totalCount);

		params.setPaginationInfo(paginationInfo);

		if (totalCount > 0) {
			product = productListDAO.selectProductTotal(params);
		}

		return product;
	}


	@Override
	public List<ProductList> selectProduct1(ProductList params) throws Exception {
		List<ProductList> product = Collections.emptyList();

		int count1 = productListDAO.selectCount1();

		PaginationInfo paginationInfo = new PaginationInfo(params);
		paginationInfo.setTotalRecordCount(count1);
		
		params.setPaginationInfo(paginationInfo);

		if (count1 > 0) {
			product = productListDAO.selectProduct1(params);
		}
		return product;
	}

	@Override
	public List<ProductList> selectProduct2(ProductList params) throws Exception {
		List<ProductList> product = Collections.emptyList();

		int count2 = productListDAO.selectCount2();

		PaginationInfo paginationInfo = new PaginationInfo(params);
		paginationInfo.setTotalRecordCount(count2);
		
		params.setPaginationInfo(paginationInfo);

		if (count2 > 0) {
			product = productListDAO.selectProduct2(params);
		}
		return product;
	}

	@Override
	public List<ProductList> selectProduct3(ProductList params) throws Exception {
		List<ProductList> product = Collections.emptyList();

		int count3 = productListDAO.selectCount3();

		PaginationInfo paginationInfo = new PaginationInfo(params);
		paginationInfo.setTotalRecordCount(count3);
		
		params.setPaginationInfo(paginationInfo);

		if (count3 > 0) {
			product = productListDAO.selectProduct3(params);
		}
		return product;
	}

	@Override
	public List<ProductList> selectProductSearch(ProductList params) throws Exception {
		List<ProductList> product = Collections.emptyList();

		int SearchCount = productListDAO.selectSearchCount();

		PaginationInfo paginationInfo = new PaginationInfo(params);
		paginationInfo.setTotalRecordCount(SearchCount);

		params.setPaginationInfo(paginationInfo);

		if (SearchCount > 0) {
			product = productListDAO.selectProductSearch(params);
		}

		return product;
	}

}
