package com.mulcam.hier.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mulcam.hier.dto.ProductList;

@Mapper
@Repository
public interface ProductListDAO {
	
	public List<ProductList> selectProductTotal(ProductList productList);
	public List<ProductList> selectProduct1(ProductList productList);
	public List<ProductList> selectProduct2(ProductList productList);
	public List<ProductList> selectProduct3(ProductList productList);

	public Integer selectTotalCount(ProductList productList);
	public Integer selectCount1();
	public Integer selectCount2();
	public Integer selectCount3();

	

}
