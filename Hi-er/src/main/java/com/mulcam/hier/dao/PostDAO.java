package com.mulcam.hier.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mulcam.hier.dto.Product;

@Mapper       
@Repository("postDAO")   
public interface PostDAO {
	public void insertProduct(Product prod) throws Exception;  
	public void insertDesignPriceInfo(Product prod) throws Exception;  
	public Integer getMaxProductId() throws Exception;
	public Product queryProduct(Integer pid) throws Exception;
	public Product queryDesignPriceInfo(Integer pid) throws Exception;
	public void insertReport(@Param("reason") String reason,
				@Param("product_id") Integer product_id,@Param("reported_userid") Integer reported_userid,
				@Param("report_userid") Integer report_userid)  throws Exception;
	public boolean like_unlike(Integer product_id, Integer liked_userid, Integer like_userid);
}
