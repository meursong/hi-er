package com.mulcam.hier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.mulcam.hier.dto.ProductList;
import com.mulcam.hier.service.ProductListService;

@Controller
public class MainController {
	
	@Autowired
	ProductListService productListService;
	@GetMapping({"", "/"})
	public String mainPage() {
		return "index";
	}
	
	
	@GetMapping("product/category/{id}")
	public String catePage(@PathVariable("id") String id, @ModelAttribute("params") ProductList params, Model model) throws Exception {
		System.out.println(id);
		
		switch(id) {
		case "1":
			List<ProductList> selectProduct1 = productListService.selectProduct1(params);
			model.addAttribute("productList", selectProduct1);
			break;

		case "2":
			List<ProductList> selectProduct2= productListService.selectProduct2(params);
			model.addAttribute("productList", selectProduct2);
			break;

		case "3":
			List<ProductList> selectProduct3=productListService.selectProduct3(params);
			model.addAttribute("productList", selectProduct3);
			break;
		}
		return "/product";
	}

}
