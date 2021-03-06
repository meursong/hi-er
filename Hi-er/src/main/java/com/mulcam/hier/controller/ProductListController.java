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

    @GetMapping("/product/category/{id}")
    public String categoryPage(@PathVariable("id") String id, @ModelAttribute("params") ProductList params, Model model)
            throws Exception {
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
        return "productList";
    }

    @GetMapping("/search")
    public String searchPage(@ModelAttribute("params") ProductList params, Model model)
            throws Exception {
        List<ProductList> selectProductDate = productListService.selectProductTotal(params);
        model.addAttribute("productList", selectProductDate);
        return "productListSearch";
    }


    @PostMapping("/product/category/{id}")
    public String productLisSort(@PathVariable("id") String id, @RequestParam String value, @ModelAttribute("params") ProductList params,
                                 Model model) throws Exception {
        switch (id) {
            case "1":
                params.setSort(value);
                List<ProductList> sortProduct1 = productListService.selectProduct1(params);
                model.addAttribute("productList", sortProduct1);
                break;
            case "2":
                params.setSort(value);
                List<ProductList> sortProduct2 = productListService.selectProduct2(params);
                model.addAttribute("productList", sortProduct2);
                break;
            case "3":
                params.setSort(value);
                List<ProductList> sortProduct3 = productListService.selectProduct3(params);
                model.addAttribute("productList", sortProduct3);
                break;
        }
        return "/productList :: #productList";
    }

    @PostMapping("/search")
    public String productLisSort(@RequestParam String value, @ModelAttribute("params") ProductList params,
                                    Model model) throws Exception {
        switch (value) {
            case "product_id":
            case "avg_star_point":
            case "review_count":
                params.setSort(value);
                List<ProductList> sortProduct1 = productListService.selectProductTotal(params);
                model.addAttribute("productList", sortProduct1);
                break;
            case "design":
            case "video":
            case "it":
                params.setCategory(value);
                List<ProductList> sortProduct2 = productListService.selectProductTotal(params);
                model.addAttribute("productList", sortProduct2);
                break;
        }

        return "/productListSearch :: #productList";
    }


}
