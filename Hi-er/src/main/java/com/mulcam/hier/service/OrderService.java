package com.mulcam.hier.service;
import org.springframework.stereotype.Service;

import com.mulcam.hier.dto.Orders;

@Service
public interface OrderService {

	Integer makeOrder(Orders order) throws Exception;
	
	
}
