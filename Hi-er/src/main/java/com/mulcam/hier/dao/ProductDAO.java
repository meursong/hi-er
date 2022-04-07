package com.mulcam.hier.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mulcam.hier.dto.Product;

@Mapper
@Repository
public interface ProductDAO {
	public List<Product> getBestProducts() throws Exception;

	public List<Product> searchProduct(String keyword) throws Exception;
	
}
