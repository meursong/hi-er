package com.mulcam.hier.controller;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mulcam.hier.dto.Product;
import com.mulcam.hier.dto.User;
import com.mulcam.hier.service.MainService;

@Controller
public class MainController {
	
	@Autowired
	MainService mainService;
//	@GetMapping({"", "/"})
//	public String mainPage() {
//		return "index";
//	}
//	
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
//	@GetMapping({"/freelancerForm"})
//	public String freelancer() {
//		return "freelancerForm";
//	}
	
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
		
		User user1 = new User();
		user1.setNickname("halo");
		user1.setStars((float) 4.2);
		user1.setIntro("프로그래밍의 고수!!");
		user1.setProduct_type("IT 프로그래밍");
		
		User user2 = new User();
		user2.setNickname("hellow");
		user2.setStars((float) 1.1);
		user2.setIntro("구독 좋아용!!");
		user2.setProduct_type("영상 사진 음향");
		
		User user3 = new User();
		user3.setNickname("hi");
		user3.setStars((float) 5.0);
		user3.setIntro("프로그래밍의 신!!");
		user3.setProduct_type("IT 프로그래밍");
		
		User user4 = new User();
		user4.setNickname("hoho");
		user4.setStars((float) 3.6);
		user4.setIntro("디자인 좀 함 ");
		user4.setProduct_type("디자인");
		
		User user5 = new User();
		user5.setNickname("asb");
		user5.setStars((float) 2.2);
		user5.setIntro("떡상 가즈아!!");
		user5.setProduct_type("영상 사진 음향");
		
		
		List<User> userList = new ArrayList<User>();
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
		userList.add(user5);

		mav.addObject("bestUserList", userList);
	
		
		return mav;
	}
	
	@RequestMapping("/search")
	public String getSearch(HttpServletRequest httpServletRequest, Model model) {
		String search_Text = httpServletRequest.getParameter("text");
		
		model.addAttribute("text", search_Text);
		return "/search";
	}
}

