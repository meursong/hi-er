package com.mulcam.hier.controller;

import javax.servlet.http.HttpSession;

import com.mulcam.hier.dto.FreelancerForm;
import com.mulcam.hier.dto.FreelancerUser;
import com.mulcam.hier.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.mulcam.hier.dto.Review;
import com.mulcam.hier.dto.User;
import com.mulcam.hier.service.UserService;

import java.util.List;

@Controller
public class UserController {
	@Autowired
	UserService us;

	@Autowired
	ReviewService reviewService;
	
	@Autowired
	HttpSession session;

	@GetMapping("/freelancerForm")
	public String freelancer(Model model) throws Exception {
		if ((User) session.getAttribute("loginedUser") != null) {
			int user_id = ((User) session.getAttribute("loginedUser")).getUser_id();
			User email = us.selectEmail(user_id);
			model.addAttribute("email", email);
			return "freelancerForm";
		} else {
			return "login";
		}
		
	}

	@PostMapping("freelancerForm")
	public String joinFreelancer(FreelancerForm form) throws Exception {
		if (((User) session.getAttribute("loginedUser")) != null) {
			int user_id = ((User) session.getAttribute("loginedUser")).getUser_id();
			FreelancerForm freelancer = new FreelancerForm(user_id, form.getAddress(), form.getAddress2(), form.getIntroduction());
			us.insert_info(freelancer);
			us.update_type(user_id);
			return "redirect:/";
		} else {
			return "login";
		}
	}
	
	@GetMapping("/freelancerInfo/{id}")
	public String freelancerInfo(@PathVariable("id") String id, Model model, @ModelAttribute("params") Review params) throws Exception {
		// seller_id는 임시
		int seller_id = 1;

		FreelancerUser freelancer = us.freelancerInfo(seller_id);
		params.setSeller_id(seller_id); // 로그인시 세션에서 값 가져와서 넣는다

		// params.setRecordsPerPage(4);
		List<Review> reviews = reviewService.reviewList(params);

		String address[] = freelancer.getAddress().split(" ");
		model.addAttribute("freelancer", freelancer);
		model.addAttribute("address", address);
		model.addAttribute("reviews", reviews);
		
		return "freelancerInfo";
	}
	
	@GetMapping("/login")
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView("login");
		if ((User) session.getAttribute("loginedUser") != null) {
			mav.setViewName("index");
		}
		return mav;
	}

	@PostMapping("/login") 
	public ModelAndView login(@RequestParam("email") String email, @RequestParam("password") String password) {
		ModelAndView mav = new ModelAndView("index");
		try {
			User loginedUser = us.login(email, password);
			session.setAttribute("loginedUser", loginedUser);
			if (loginedUser == null) {
				mav.setViewName("login");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@GetMapping("/signup")
	public ModelAndView joinPage() {
		// 로그인 된 상태에서 들어가지 못하게 만들기
		ModelAndView mav = new ModelAndView("signup");
		if ((User) session.getAttribute("loginedUser") != null) {	
			mav.setViewName("index");
		}
		return mav;
	}

	@PostMapping("/signup")
	public ModelAndView join(User user) {
		System.out.println(user.toString());
		ModelAndView mav = new ModelAndView("login");
		try {
			us.signup(user);
		} catch (Exception e) {
			mav.setViewName("signup");
			mav.addObject("errMsg", "회원가입 중 오류가 발생했습니다.");
			e.printStackTrace();
		}
		return mav;
	}

	@GetMapping("/logout")
	public ModelAndView logout() {
		ModelAndView mav = new ModelAndView("index");
		session.invalidate();
//		 session.removeAttribute("loginedUser");

		return mav;
	}

	@ResponseBody
	@PostMapping("/emailcheck")
	public Boolean emailCheck(@RequestParam String useremail) {
		Boolean result = false;
		
		try {
			result = us.emailCheck(useremail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@ResponseBody
	@PostMapping("/nicknamecheck")
	public Boolean nicknameCheck(@RequestParam String usernickname) {
		Boolean result = false;
		try {
			result = us.nicknameCheck(usernickname);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
