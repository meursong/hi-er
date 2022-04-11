package com.mulcam.hier.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping; 

@Controller 
public class PaymentController {
	@GetMapping("/iamport") public String iamport(){ 
		return "index"; 
	}
}
