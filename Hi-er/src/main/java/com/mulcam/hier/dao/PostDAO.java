package com.mulcam.hier.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mulcam.hier.dto.Product;

@Mapper       
@Repository("PostDAO")   
public interface PostDAO {
	public static void insertProduct(Product prod) throws Exception {
		// TODO Auto-generated method stub
		
	}  
}
