package com.mulcam.hier.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mulcam.hier.dto.FreelancerUser;
import com.mulcam.hier.dto.User;
import com.mulcam.hier.service.UserService;



@Controller
public class UserController {
	
	int user_id = 2;
	
	@Autowired
	UserService userService;
	
	@GetMapping("freelancerForm")
	public String freelancer(Model model) throws Exception {
		User user = userService.userInfo(user_id);
		model.addAttribute("user", user);
		return "freelancerForm";
	}

	@PostMapping("/freelancer/form")
	public String joinFreelancer(FreelancerUser form) throws Exception {
		FreelancerUser freelancer = new FreelancerUser(user_id, form.getAddress(), form.getAddress2(), form.getIntroduction());
		userService.insert_info(freelancer);
		userService.update_type(user_id);
		return "redirect:/";
	}
	
	@GetMapping("freelancerInfo")
	public String freelancerInfo(Model model) throws Exception {
//		User user = userService.userInfo(user_id);
//		FreelancerUser freelancer = userService.freelancerInfo(user_id);
//		model.addAttribute("user", user);
//		model.addAttribute("freelancer", freelancer);
		return "freelancerInfo";
		
	}
		
}
