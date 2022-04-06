package com.mulcam.hier.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	@GetMapping({"", "/"})
	public String mainPage() {
		return "index";
	}
	
	@GetMapping({"write"})
	public String writePage() {
		return "write" ;
	}
	
	@GetMapping("cate/{id}")
	public ModelAndView catePage(@PathVariable("id") String id) {
		System.out.println(id);
		ModelAndView mav = new ModelAndView("gitTest");
		switch(id) {
			case "1":
				mav.addObject("cate", "<i>aaaaa</i>");
				break;
			case "2":
				mav.addObject("cate", "dudtkd");
				break;
			case "3":
				mav.addObject("cate", "it");
				break;
		}
		return mav;
	}

}
