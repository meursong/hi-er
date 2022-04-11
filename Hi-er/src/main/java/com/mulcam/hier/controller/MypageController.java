package com.mulcam.hier.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mulcam.hier.dto.Paging;
import com.mulcam.hier.service.MypageService;

@Controller
public class MypageController {
	
	@Autowired
	MypageService mypageService;
	
	@GetMapping("mypage")
	public ModelAndView mypage() {
		ModelAndView mav = new ModelAndView("account");
		System.out.println("마이페이지안");
		try {
			System.out.println("트라이 안이다다다다다다");
			List<Map<String,Object>> ord=mypageService.history2(1);
			List<Map<String,Object>> likepost=mypageService.history3(1);
			System.out.println(ord);
			System.out.println(likepost);
			mav.addObject("orders",ord);
			mav.addObject("likeposts",likepost);
			mav.addObject("page","0");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return mav;
	}
	
	@ResponseBody
	@PostMapping("nickoverlap")
	public String accoverlap(@RequestParam(value="nick")String nick) {
		boolean overlap=false;
		try {
			overlap=mypageService.nickOverlap(nick);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return String.valueOf(overlap);
	}
	
	@ResponseBody
	@PostMapping("nickupdate")
	public String nickupdate(@RequestParam(value="nick")String nick) {
		System.out.println("여기 닉네임업데이트");
		//boolean nickupdate=false;
		try {
			System.out.println("트라이 안");
			mypageService.nickupdate(nick);
			return String.valueOf(true);
		}catch(Exception e) {
			e.printStackTrace();
			return String.valueOf(false);
		}
		
	}
	
	@ResponseBody
	@PostMapping("passupdate")
	public String passupdate(@RequestParam(value="pass")String pass,@RequestParam(value="pass2")String pass2) {
		System.out.println("여기 패스워드 업데이트");
		
		try {
			
			if(true==mypageService.passfindupdate(pass,pass2)) {
				return String.valueOf(true);
			}
			else return String.valueOf(false);
		}catch(Exception e) {
			e.printStackTrace();
			return String.valueOf(false);
		}
		
	}
	
	
	@GetMapping("mypage/{num}/{page2}")
	public ModelAndView mypage1(@PathVariable String num,@PathVariable String page2) {
		ModelAndView mav = new ModelAndView("account");
		System.out.println("111111111111111111111111111111111" + num);

		try {
			if (num.equals("1")) {
				
				System.out.println("페이지2@@@@@@@@@@@@@@@@@@@@:"+page2);
				System.out.println("jjjjaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaj");
//				
				Paging pageInfo=new Paging();
				System.out.println(pageInfo);
				int page=Integer.parseInt(page2);
				System.out.println("페이지 @@@@@@@@@@@@@@@@@@@@@@@@@@@2:"+page);
				List<Map<String, Object>> ord = mypageService.getBoardList(page,pageInfo);
				System.out.println(ord);
				mav.addObject("pageInfo",pageInfo);
				mav.addObject("orders", ord);

			} else if(num.equals("2")){
				System.out.println("jjjjaaaaaa222222222222222222222222222222222222222");
				Paging pageInfo=new Paging();
				int page=Integer.parseInt(page2);
				List<Map<String, Object>> likepost = mypageService.getBoardList2(page,pageInfo);
				System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
				mav.addObject("pageInfo2",pageInfo);
				mav.addObject("likeposts",likepost);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("fklsafklsakflsakflsakfls");
		mav.addObject("page", num);
		return mav;
	}
	
	@PostMapping("/imageupload")
	public String imageupload() {
		System.out.println("sssssssssssssssssssssssss");
		return "account";
	}
	
	@GetMapping("mypage/{num}")
	public ModelAndView memmodify(@PathVariable String num) {
		ModelAndView mav = new ModelAndView("account");
		System.out.println("111111111111111111111111111111111" + num);
		
		
		
		
//		try {
//			if (num.equals("1")) {
//				
//				System.out.println("페이지2@@@@@@@@@@@@@@@@@@@@:"+page2);
//				System.out.println("jjjjaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaj");
////				
//				Paging pageInfo=new Paging();
//				System.out.println(pageInfo);
//				int page=Integer.parseInt(page2);
//				System.out.println("페이지 @@@@@@@@@@@@@@@@@@@@@@@@@@@2:"+page);
//				List<Map<String, Object>> ord = mypageService.getBoardList(page,pageInfo);
//				System.out.println(ord);
//				mav.addObject("pageInfo",pageInfo);
//				mav.addObject("orders", ord);
//
//			} else if(num.equals("2")){
//				System.out.println("jjjjaaaaaa222222222222222222222222222222222222222");
//				Paging pageInfo=new Paging();
//				int page=Integer.parseInt(page2);
//				List<Map<String, Object>> likepost = mypageService.getBoardList2(page,pageInfo);
//				System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
//				mav.addObject("pageInfo2",pageInfo);
//				mav.addObject("likeposts",likepost);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println("fklsafklsakflsakflsakfls");
		mav.addObject("page", num);
		return mav;
	}
	
//	@GetMapping("mypage/2")
//	public ModelAndView mypage2() {
//		ModelAndView mav = new ModelAndView("account");
//		System.out.println("fklsafklsakflsakflsakfls");
//		mav.addObject("page","2");
//		return mav;
//	}
//	
//	@GetMapping("mypage/3")
//	public ModelAndView mypage3() {
//		ModelAndView mav = new ModelAndView("account");
//		System.out.println("fklsafklsakflsakflsakfls");
//		mav.addObject("page","3");
//		return mav;
//	}
}
