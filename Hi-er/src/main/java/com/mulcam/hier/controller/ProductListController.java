package com.mulcam.hier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mulcam.hier.dto.ProductList;
import com.mulcam.hier.service.ProductListService;

@Controller
public class ProductListController {

	@Autowired
	ProductListService productListService;

	@GetMapping(value="/product")
	public String productList1(@ModelAttribute("params") ProductList params, Model model) throws Exception {
		List<ProductList> selectProductDate = productListService.selectProductDate(params);
		
		model.addAttribute("productList", selectProductDate);

		return "product";
	}

	@PostMapping("/product")
	public String productList(@RequestParam String value, @ModelAttribute("params") ProductList params,
			Model model) throws Exception {
		

		switch (value) {
		case "1":
			List<ProductList> selectProductDate = productListService.selectProductDate(params);
			model.addAttribute("productList", selectProductDate);
			break;

		case "2":
			List<ProductList> selectProductStarPoint = productListService.selectProductStarPoint(params);
			model.addAttribute("productList", selectProductStarPoint);
			break;

		case "3":
			List<ProductList> selectProductReviewCount = productListService.selectProductReviewCount(params);
			model.addAttribute("productList", selectProductReviewCount);
			break;
			
		}
	
				
			
		return "/product :: #productList";
	}

}
