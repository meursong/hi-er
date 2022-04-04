package com.mulcam.hier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mulcam.hier.dto.FreelancerUser;
import com.mulcam.hier.dto.Review;
import com.mulcam.hier.dto.User;
import com.mulcam.hier.service.ReviewService;
import com.mulcam.hier.service.UserService;



@Controller
public class UserController {
	
	int user_id = 4;
	int seller_id = 4;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ReviewService reviewService;
	
	@GetMapping("freelancerForm")
	public String freelancer(Model model) throws Exception {
		User user = userService.userInfo(user_id);
		model.addAttribute("user", user);
		return "freelancerForm";
	}

	@PostMapping("freelancerForm")
	public String joinFreelancer(FreelancerUser form) throws Exception {
		FreelancerUser freelancer = new FreelancerUser(user_id, form.getAddress(), form.getAddress2(), form.getIntroduction());
		userService.insert_info(freelancer);
		userService.update_type(user_id);
		return "redirect:/";
	}
	
	@GetMapping("freelancerInfo")
	public String freelancerInfo(Model model) throws Exception {
		User user = userService.userInfo(seller_id);
		List<Review> reviews = reviewService.reviewList(seller_id);
		float sum = 0;
		
		for(Review review : reviews) {
			sum += review.getStar_point();
		}
		String avr = String.format("%.1f",sum/reviews.size());
		double pageNum = Math.ceil(reviews.size()/5);
		
		
		FreelancerUser freelancer = userService.freelancerInfo(seller_id);
		String address[] = freelancer.getAddress().split(" ");
		
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("avg", avr);
		model.addAttribute("user", user);
		model.addAttribute("freelancer", freelancer);
		model.addAttribute("address", address);
		model.addAttribute("reviews", reviews);
		
		return "freelancerInfo";
		
	}
		
}
