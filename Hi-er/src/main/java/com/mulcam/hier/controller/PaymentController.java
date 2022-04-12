package com.mulcam.hier.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody; 

import com.mulcam.hier.dto.Orders;
import com.mulcam.hier.service.OrderService;

@Controller 
public class PaymentController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("/iamport") public String iamport(){ 
		return "index"; 
	}
	
	@ResponseBody
	@PostMapping("/order") 
	public int order(Orders order){ 
		int orderNumber = 0;
		try {
			orderNumber = orderService.makeOrder(order) ;
			System.out.println(orderNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderNumber; 
	}
}
