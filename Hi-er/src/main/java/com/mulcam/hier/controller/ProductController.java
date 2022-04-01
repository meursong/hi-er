package com.mulcam.hier.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
	
	@GetMapping("product")
	public String productList() {
		return "product";
	}
	
	@GetMapping("product2")
	public String productList2() {
		return "product2";
	}

}
