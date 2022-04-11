package com.mulcam.hier.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.mulcam.hier.dto.Product;

@Mapper       
@Repository("postDAO")   
public interface PostDAO {
	public void insertProduct(Product prod) throws Exception;  
	public void insertPriceInfo(Product prod) throws Exception;  
	public Integer getMaxProductId() throws Exception;
	public Product queryProduct(Integer pid) throws Exception;
	public Product queryPriceInfo(Integer pid) throws Exception;
	public void insertReport(@Param("reason") String reason,
				@Param("product_id") Integer product_id,@Param("reported_userid") Integer reported_userid,
				@Param("report_userid") Integer report_userid)  throws Exception;
	public void like(@Param("product_id") Integer product_id,@Param("liked_userid") Integer liked_userid,@Param("like_userid") Integer like_userid) throws Exception;
	public void unlike(@Param("product_id") Integer product_id,@Param("like_userid") Integer like_userid) throws Exception;
	public Integer likeCheck(@Param("product_id") Integer product_id,@Param("like_userid") Integer like_userid) throws Exception;
	public Integer likeNum(@Param("product_id") Integer product_id) throws Exception;
}
