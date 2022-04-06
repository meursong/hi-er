package com.mulcam.hier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mulcam.hier.dto.ProductList;
import com.mulcam.hier.service.ProductListService;

@Controller
public class ProductListController {

	@Autowired
	ProductListService productListService;

	@GetMapping("/product")
	public String productListTotal(@ModelAttribute("params") ProductList params, Model model) throws Exception {
		List<ProductList> selectProductDate = productListService.selectProductTotal(params);
		model.addAttribute("productList", selectProductDate);

		return "product";
	}

	@PostMapping("/product")
	public String productLisSortTotal(@RequestParam String value, @ModelAttribute("params") ProductList params, Model model)
			throws Exception {

		switch (value) {
		case "product_id":
			params.setSort(value);
			List<ProductList> sorttProductDate1 = productListService.selectProductTotal(params);
			model.addAttribute("productList", sorttProductDate1);
			break;

		case "avg_star_point":
			params.setSort(value);
			List<ProductList> sorttProductDate2 = productListService.selectProductTotal(params);
			model.addAttribute("productList", sorttProductDate2);
			break;

		case "review_count":
			params.setSort(value);
			List<ProductList> sorttProductDate3 = productListService.selectProductTotal(params);
			model.addAttribute("productList", sorttProductDate3);
			break;

		}

		return "/product :: #productList";
	}

	@GetMapping("product/category/{id}")
	public String categoryPage(@PathVariable("id") String id, @ModelAttribute("params") ProductList params, Model model)
			throws Exception {
		System.out.println(id);

		switch (id) {
		case "1":

			List<ProductList> selectProduct1 = productListService.selectProduct1(params);
			model.addAttribute("productList", selectProduct1);
			break;

		case "2":

			List<ProductList> selectProduct2 = productListService.selectProduct2(params);
			model.addAttribute("productList", selectProduct2);
			break;

		case "3":

			List<ProductList> selectProduct3 = productListService.selectProduct3(params);
			model.addAttribute("productList", selectProduct3);
			break;
		}
		return "/productCategory";
	}

	@PostMapping("/product/category")
	public String categoryPageSort(@RequestParam String value,
			@ModelAttribute("params") ProductList params, Model model) throws Exception {

		switch (value) {
		case "product_id":
			params.setSort(value);
			List<ProductList> sortProduct1 = productListService.selectProduct3(params);
			model.addAttribute("productList", sortProduct1);
			break;

		case "avg_star_point":
			params.setSort(value);
			List<ProductList> sortProduct2 = productListService.selectProduct3(params);
			model.addAttribute("productList", sortProduct2);
			break;

		case "review_count":
			params.setSort(value);
			List<ProductList> sorttProduct3 = productListService.selectProduct3(params);
			model.addAttribute("productList", sorttProduct3);
			break;

		}
		return "/productCategory :: #productList";

	}

}
