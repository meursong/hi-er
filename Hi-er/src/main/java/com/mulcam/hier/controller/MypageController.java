package com.mulcam.hier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mulcam.hier.dto.Orders;
import com.mulcam.hier.service.MypageService;

@Controller
public class MypageController {
	
	@Autowired
	MypageService mypageService;
	
	@GetMapping("mypage")
	public ModelAndView mypage() {
		ModelAndView mav = new ModelAndView("account");
		System.out.println("fklsafklsakflsakflsakfls");
		try {
			System.out.println("트라이 안이다다다다다다");
			List<Orders> ord=mypageService.history(1);
			System.out.println("hdlfksalfkalfkaslfkla");
			System.out.println(ord);
			mav.addObject("orders",ord);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@GetMapping("logout")
	public String logout() {
		return "account";
	}
}
