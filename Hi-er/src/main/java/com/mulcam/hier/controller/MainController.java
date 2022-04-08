package com.mulcam.hier.controller;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mulcam.hier.dto.Product;
import com.mulcam.hier.dto.User;
import com.mulcam.hier.service.MainService;

@Controller
public class MainController {
	
	@Autowired
	MainService mainService;

	@RequestMapping("/")
	public ModelAndView mainView() {
		ModelAndView mav = new ModelAndView("index");
		try {
//			List<User> userList = mainService.getBestUserFive();
//			List<Board> boardList = mainService.getBestBoardFive();
			List<Product> bestProduct = mainService.getBestProducts();

			mav.addObject("bestProduct", bestProduct);
		} catch(Exception e){
			e.printStackTrace();
		}
		
		
		
		List<User> userList = new ArrayList<User>();

		mav.addObject("bestUserList", userList);
	
		
		return mav;
	}
	
	@RequestMapping("/search")
	public ModelAndView getSearch(String keyword) {
		ModelAndView mav = new ModelAndView("404");
		try {
			
			List<Product> ResultList = mainService.searchProduct(keyword);
			if(!ResultList.isEmpty()) {
				mav.addObject("ResultList", ResultList);
				for(Product p: ResultList) {
					System.out.println(p.getTitle());
				}
			} else {
				mav.addObject("SearchCheck", "empty");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

}

