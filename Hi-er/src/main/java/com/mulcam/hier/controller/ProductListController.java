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

	@GetMapping("/product")
	public String productList1(@ModelAttribute("params") ProductList params, Model model, @RequestParam(defaultValue =  "product_id", name="filter", required=false) String value) throws Exception {
		
		
		switch (value) {
		case "product_id":
			
			List<ProductList> selectProductDate = productListService.selectProductDate(params);
			model.addAttribute("productList", selectProductDate);
			break;

		case "avg_star_point":
			
			List<ProductList> selectProductDate2 = productListService.selectProductDate(params);
			model.addAttribute("productList", selectProductDate2);
			break;

		case "review_count":
	
			List<ProductList> selectProductDate3 = productListService.selectProductDate(params);
			model.addAttribute("productList", selectProductDate3);
			break;
			
		}
		
		
		/*
		 * List<ProductList> selectProductDate =
		 * productListService.selectProductDate(params);
		 * 
		 * model.addAttribute("productList", selectProductDate);
		 */
		return "product";
	}

	@PostMapping("/product")
	public String productList(@RequestParam String value, @ModelAttribute("params") ProductList params,
			Model model) throws Exception {
		

		switch (value) {
		case "product_id":
			params.setSort(value);
			List<ProductList> selectProductDate = productListService.selectProductDate(params);
			model.addAttribute("productList", selectProductDate);
			break;

		case "avg_star_point":
			params.setSort(value);
			List<ProductList> selectProductDate2 = productListService.selectProductDate(params);
			model.addAttribute("productList", selectProductDate2);
			break;

		case "review_count":
			params.setSort(value);
			List<ProductList> selectProductDate3 = productListService.selectProductDate(params);
			model.addAttribute("productList", selectProductDate3);
			break;
			
		}
	
				
			
		return "/product :: #productList";
	}

}
