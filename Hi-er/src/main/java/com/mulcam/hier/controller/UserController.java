package com.mulcam.hier.controller;

import javax.servlet.http.HttpSession;

import com.mulcam.hier.dto.FreelancerUser;
import com.mulcam.hier.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mulcam.hier.dto.FreelancerForm;
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
		int user_id = ((User) session.getAttribute("loginedUser")).getUser_id();
		User email = us.selectEmail(user_id);
		model.addAttribute("email", email);
		return "freelancerForm";
	}

	@PostMapping("freelancerForm")
	public String joinFreelancer(FreelancerForm form) throws Exception {
		int user_id = ((User) session.getAttribute("loginedUser")).getUser_id();
		FreelancerForm freelancer = new FreelancerForm(user_id, form.getAddress(), form.getAddress2(), form.getIntroduction());
		us.insert_info(freelancer);
		us.update_type(user_id);
		return "redirect:/";
	}
	
	@GetMapping("/freelancerInfo")
	public String freelancerInfo(Model model, @ModelAttribute("params") Review params) throws Exception {
		// seller_id는 임시
		int seller_id = 2;

		FreelancerUser freelancer = us.freelancerInfo(seller_id);
		params.setSeller_id(2); // 로그인시 세션에서 값 가져와서 넣는다

		params.setRecordsPerPage(4);
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
		String name = ((User) session.getAttribute("loginedUser")).getName();
		if (name != null) {
			mav.setViewName("index");
		}
		return mav;
	}

	@PostMapping("/login") 
	public ModelAndView login(@RequestParam("email") String email, @RequestParam("password") String password) {
		ModelAndView mav = new ModelAndView("index");
		try {
			User loginedUser = us.login(email, password);
			System.out.println(loginedUser);
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

		return mav;
	}

	@PostMapping("/signup")
	public ModelAndView join(User user) {
		System.out.println(user.toString());
		ModelAndView mav = new ModelAndView("login");
		try {

		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@GetMapping("/logout")
	public ModelAndView logout() {
		ModelAndView mav = new ModelAndView("index");
		session.invalidate();
		// session.removeAttribute("loginedUser");

		return mav;
	}

	@ResponseBody
	@PostMapping("/emailcheck")
	public Boolean emailCheck(@RequestParam String useremail) {
		Boolean result = false;
		int length = useremail.length();
		System.out.println("입력한 이메일의 길이:" + length);
		try {
			result = us.emailCheck(useremail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
