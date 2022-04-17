package com.mulcam.hier.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.mulcam.hier.dto.FreelancerUser;
import com.mulcam.hier.dto.Product;
import com.mulcam.hier.dto.Review;
import com.mulcam.hier.dto.User;
import com.mulcam.hier.service.MainService;
import com.mulcam.hier.service.PostService;
import com.mulcam.hier.service.UserService;

@Controller
public class MainController {
    @Autowired
    PostService postService;

	@Autowired
	HttpSession session;

	@Autowired
	MainService mainService;

	@Autowired
	UserService userService;
	
	@GetMapping({"", "/","/index"})
	public ModelAndView mainView() {
		ModelAndView mav = new ModelAndView("index");
		try {
			List<User> bestUser = mainService.getBestUser();
			List<Product> bestProduct = mainService.getBestProducts();
			mav.addObject("bestProduct", bestProduct);
			mav.addObject("bestUser", bestUser);
			User user = (User) session.getAttribute("loginedUser");
			List<Boolean> isLikeList = new ArrayList<>();
			
			if (user != null) {
				for(Product p : bestProduct) {
					int pid = p.getProduct_id();
					boolean isLike = postService.isLike(pid, user.getUser_id());
					isLikeList.add(isLike);
				}
			}
			mav.addObject("isLikeList", isLikeList);
			
			
		} catch(Exception e){
			e.printStackTrace();
		}
		
		return mav;
	}
	
	
	@GetMapping("/about")
	public ModelAndView aboutView() {
		ModelAndView mav = new ModelAndView("about");
		return mav;
	}
	
	@GetMapping("/Contact")
	public ModelAndView ContactUsView() {
		ModelAndView mav = new ModelAndView("contact");
		return mav;
	}
}
