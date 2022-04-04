package com.mulcam.hier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mulcam.hier.dto.ProductList;
import com.mulcam.hier.service.ProductListService;

@Controller
public class ProductListController {
	
	@Autowired
	ProductListService productListService;
	

	@GetMapping("/product")
	public String productList1(Model model) throws Exception {
		 List<ProductList> selectProductDate = productListService.selectProductDate();
			model.addAttribute("productList", selectProductDate);
		
		return "/product";
	}
	
	@PostMapping("/product")
	public String productList(@RequestParam(name="value", required=false, defaultValue = "1") String value, Model model) throws Exception {
		
		switch(value) {
		case "1" : List<ProductList> selectProductDate = productListService.selectProductDate();
				model.addAttribute("productList", selectProductDate); break;
				
		case "2" : List<ProductList> selectProductReviewCount = productListService.selectProductReviewCount();
		model.addAttribute("productList", selectProductReviewCount); break;
		
		case "3" : List<ProductList> selectProductStarPoint = productListService.selectProductStarPoint();
		model.addAttribute("productList", selectProductStarPoint); break;
		
		default : List<ProductList> selectProductdefault = productListService.selectProductDate();
		model.addAttribute("productList", selectProductdefault);
		}
		return "/product :: #productList1";
	}
	
}
