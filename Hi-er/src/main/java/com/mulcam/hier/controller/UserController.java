package com.mulcam.hier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.mulcam.hier.dto.FreelancerForm;
import com.mulcam.hier.dto.Review;
import com.mulcam.hier.dto.User;
import com.mulcam.hier.service.ReviewService;
import com.mulcam.hier.service.UserService;



@Controller
public class UserController {
	
	int user_id = 2;
	int seller_id = 2;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ReviewService reviewService;
	
	@GetMapping("/freelancerForm")
	public String freelancer(Model model) throws Exception {
		User email = userService.selectEmail(user_id);
		model.addAttribute("email", email);
		return "freelancerForm";
	}

	@PostMapping("freelancerForm")
	public String joinFreelancer(FreelancerForm form) throws Exception {
		FreelancerForm freelancer = new FreelancerForm(user_id, form.getAddress(), form.getAddress2(), form.getIntroduction());
		userService.insert_info(freelancer);
		userService.update_type(user_id);
		return "redirect:/";
	}
	
	@GetMapping("/freelancerInfo")
	public String freelancerInfo(Model model, @ModelAttribute("params") Review params) throws Exception {

		User freelancer = userService.freelancerInfo(seller_id);
		params.setSeller_id(2); // 로그인시 세션에서 값 가져와서 넣는다

		params.setRecordsPerPage(4);
		List<Review> reviews = reviewService.reviewList(params);
		
		String address[] = freelancer.getAddress().split(" ");
		
		model.addAttribute("freelancer", freelancer);
		model.addAttribute("address", address);
		model.addAttribute("reviews", reviews);
		
		return "freelancerInfo";
		
	}
	
	
		
}
