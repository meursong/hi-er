package com.mulcam.hier.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mulcam.hier.dto.Orders;

@Mapper
@Repository
public interface MypageDAO {
	public List<Orders> queryOrders(int id)throws Exception;
}
