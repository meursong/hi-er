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
	
	@GetMapping("product/category/{id}")
	public String categoryPage(@PathVariable("id") String id, @ModelAttribute("params") ProductList params, Model model)
			throws Exception {
		System.out.println(id);

		switch (id) {
		
		case "all":

			List<ProductList> selectProductDate = productListService.selectProductTotal(params);
			model.addAttribute("productList", selectProductDate);
			break;
		
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
		return "/productCategory"+id;
	}

	@PostMapping("/product/category/all")
	public String productLisSortAll(@RequestParam String value, @ModelAttribute("params") ProductList params,
			Model model) throws Exception {

		params.setSort(value);
		List<ProductList> sorttProductDate1 = productListService.selectProductTotal(params);
		model.addAttribute("productList", sorttProductDate1);

		return "/productCategoryall :: #productList";
	}

	@PostMapping("/product/category/1")
	public String categoryPageSort1(@RequestParam String value, @ModelAttribute("params") ProductList params,
			Model model) throws Exception {

		params.setSort(value);
		List<ProductList> sortProduct1 = productListService.selectProduct1(params);
		model.addAttribute("productList", sortProduct1);

		return "/productCategory1 :: #productList";

	}
	
	@PostMapping("/product/category/2")
	public String categoryPageSort2(@RequestParam String value, @ModelAttribute("params") ProductList params,
			Model model) throws Exception {

		params.setSort(value);
		List<ProductList> sortProduct2 = productListService.selectProduct2(params);
		model.addAttribute("productList", sortProduct2);

		return "/productCategory2 :: #productList";

	}
	
	@PostMapping("/product/category/3")
	public String categoryPageSort3(@RequestParam String value, @ModelAttribute("params") ProductList params,
			Model model) throws Exception {

		params.setSort(value);
		List<ProductList> sortProduct3 = productListService.selectProduct3(params);
		model.addAttribute("productList", sortProduct3);

		return "/productCategory3 :: #productList";

	}

}
