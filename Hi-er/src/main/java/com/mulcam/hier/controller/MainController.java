package com.mulcam.hier.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mulcam.hier.dto.Product;
import com.mulcam.hier.dto.User;
import com.mulcam.hier.service.MainService;

@Controller
public class MainController {


	@Autowired
	HttpSession session;

	@Autowired
	MainService mainService;

	@GetMapping({"", "/","/index"})
	public ModelAndView mainView() {
		ModelAndView mav = new ModelAndView("index");
		try {
//			List<User> userList = mainService.getBestUserFive();
			List<Product> bestProduct = mainService.getBestProducts();
//			for (Product p : bestProduct) {
//				System.out.println(p.getTitle());
//			}
			System.out.println(bestProduct);
			mav.addObject("bestProduct", bestProduct);
		} catch(Exception e){
			e.printStackTrace();
		}
//		List<User> userList = new ArrayList<User>();
		
//		mav.addObject("bestUserList", userList);
		return mav;
	}

	@GetMapping("/about")
	public ModelAndView aboutView() {
		ModelAndView mav = new ModelAndView("about");
		return mav;
	}
	
//	@RequestMapping("/search")
//	public ModelAndView getSearch(String keyword) {
//		ModelAndView mav = new ModelAndView("404");
//		try {
//			
//			List<Product> ResultList = mainService.searchProduct(keyword);
//			if(!ResultList.isEmpty()) {
//				mav.addObject("ResultList", ResultList);
//				for(Product p: ResultList) {
//					System.out.println(p.getTitle());
//				}
//			} else {
//				mav.addObject("SearchCheck", "empty");
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return mav;
//	}
//	@GetMapping("cate/{id}")
//	public ModelAndView catePage(@PathVariable("id") String id) {
//		System.out.println(id);
//		ModelAndView mav = new ModelAndView("gitTest");
//		switch(id) {
//			case "1":
//				mav.addObject("cate", "<i>aaaaa</i>");
//				break;
//			case "2":
//				mav.addObject("cate", "dudtkd");
//				break;
//			case "3":
//				mav.addObject("cate", "it");
//				break;
//		}
//		return mav;
//	}
//
}
