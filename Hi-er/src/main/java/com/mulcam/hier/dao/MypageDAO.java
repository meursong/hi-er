package com.mulcam.hier.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mulcam.hier.dto.Orders;

@Mapper
@Repository
public interface MypageDAO {
//	public List<Orders> queryOrders(int id)throws Exception;
//	public List<Map<String,Object>> queryOrderss(int id)throws Exception;
	public List<Map<String,Object>> queryOrdersss(int id)throws Exception;
	public List<Map<String,Object>> queryLikepost(int id)throws Exception;
	
}
