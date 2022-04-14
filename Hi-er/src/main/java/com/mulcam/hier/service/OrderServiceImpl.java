package com.mulcam.hier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulcam.hier.dao.OrderDAO;
import com.mulcam.hier.dto.Orders;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderDAO orderDAO;
	
	@Override
	public Integer makeOrder(Orders order) throws Exception {
		Integer orderId = orderDAO.getMaxOrderId();
		if(orderId==null) orderId = 0;
		orderId++;
		order.setOrder_id(orderId);
		orderDAO.insertOrder(order);
		return orderId;
	}

}
