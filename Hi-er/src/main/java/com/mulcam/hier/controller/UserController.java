package com.mulcam.hier.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mulcam.hier.dto.User;
import com.mulcam.hier.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService us;

	@Autowired
	HttpSession session;

	@GetMapping("/login")
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView("login");
		String name = (String) session.getAttribute("loginedUser");
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
