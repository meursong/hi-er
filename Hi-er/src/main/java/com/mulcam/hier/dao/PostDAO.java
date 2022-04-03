package com.mulcam.hier.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mulcam.hier.dto.Product;

@Mapper       
@Repository("postDAO")   
public interface PostDAO {
	public void insertProduct(Product prod) throws Exception;  
	public void insertDesignPriceInfo(Product prod) throws Exception;  
	public Integer getMaxProductId() throws Exception;
	public Product querryProduct(Integer pid) throws Exception;
}
