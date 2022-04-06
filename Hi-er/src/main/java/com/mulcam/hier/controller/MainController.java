package com.mulcam.hier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.mulcam.hier.service.ProductListService;

@Controller
public class MainController {
	
	@Autowired
	ProductListService productListService;
	@GetMapping({"", "/"})
	public String mainPage() {
		return "index";
	}
	
	


}
