package com.mulcam.hier.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {
	@GetMapping({"", "/"})
	public String mainPage() {
		return "index";
	}
	
	@GetMapping("product/category/{id}")
	public String catePage(@PathVariable("id") String id, Model model) {
		System.out.println(id);
		
		switch(id) {
			case "1":
				
				break;
			case "2":
				
				break;
			case "3":
				
				break;
		}
		return "product";
	}

}
