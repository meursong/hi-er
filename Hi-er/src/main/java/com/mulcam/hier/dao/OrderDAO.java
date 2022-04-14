package com.mulcam.hier.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mulcam.hier.dto.Orders;

@Mapper
@Repository("orderDAO") 
public interface OrderDAO {
	public Integer getMaxOrderId() throws Exception;
	public Integer insertOrder(Orders order) throws Exception;  
}
