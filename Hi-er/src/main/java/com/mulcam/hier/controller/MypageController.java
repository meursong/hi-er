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
	
	@GetMapping("mypage/{num}/{page2}")
	public ModelAndView mypage1(@PathVariable String num,@PathVariable String page2) {
		//ModelAndView mav = new ModelAndView("account");
		System.out.println("111111111111111111111111111111111" + num);

		try {
			if (num.equals("1")) {
				ModelAndView mav = new ModelAndView("account1");
				
//				
				Paging pageInfo=new Paging();
				System.out.println(pageInfo);
				int page=Integer.parseInt(page2);
				System.out.println("페이지 @@@@@@@@@@@@@@@@@@@@@@@@@@@:"+page);
				List<Map<String, Object>> ord = mypageService.getBoardList(page,pageInfo);
				System.out.println(ord);
				mav.addObject("pageInfo",pageInfo);
				mav.addObject("orders", ord);
				mav.addObject("page", num);
				return mav;
				
			} else if(num.equals("2")){
				ModelAndView mav = new ModelAndView("account2");
				Paging pageInfo=new Paging();
				int page=Integer.parseInt(page2);
				List<Map<String, Object>> likepost = mypageService.getBoardList2(page,pageInfo);
				System.out.println("jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj");
				mav.addObject("pageInfo2",pageInfo);
				mav.addObject("likeposts",likepost);
				mav.addObject("page", num);
				return mav;
			} else {
				ModelAndView mav = new ModelAndView("account");
				return mav;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println("fklsafklsakflsakflsakfls");
		//mav.addObject("page", num);
		//return mav;
		return null;
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
	
	@ResponseBody
	@PostMapping("intromody")
	public String intromody(@RequestParam(value = "intro") String intro) {
		System.out.println("여기가 인트로 안임");
		try {
			if (true == mypageService.introupdate(intro)) {
				return String.valueOf(true);
			} else
				return String.valueOf(false);
		} catch (Exception e) {
			e.printStackTrace();
			return String.valueOf(false);
		}

	}
	
	@ResponseBody
	@PostMapping("locationmody")
	public String locationmody(@RequestParam(value = "address") String address,@RequestParam(value = "address2") String address2) {
		System.out.println("여기가 로케이션모디 안임");
		try {
			if (true == mypageService.addressupdate(address,address2)) {
				return String.valueOf(true);
			} else
				return String.valueOf(false);
		} catch (Exception e) {
			e.printStackTrace();
			return String.valueOf(false);
		}

	}
	
	@ResponseBody
	@PostMapping("review")
	public String review(@RequestParam(value="content")String content,@RequestParam(value="rating")int star_point,@RequestParam(value="order_id")int order_id) {
		System.out.println("들ddddddddddddddddddddddddddd어옴");
		System.out.println("들ddddddddddddddddddddddddddd어옴");
		System.out.println("들ddddddddddddddddddddddddddd어옴");
		System.out.println("들ddddddddddddddddddddddddddd어옴");
		System.out.println("들ddddddddddddddddddddddddddd어옴");
		System.out.println("들ddddddddddddddddddddddddddd어옴");
		boolean review=false;
		try {
			review=mypageService.reviewWrite(content,star_point,order_id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return String.valueOf(review);
	}
	
	
	
	@PostMapping("imageupload")
	public String imageupload() {
		System.out.println("sssssssssssssssssssssssss");
		return "account";
	}
	
	
	
	
	@GetMapping("mypage/{num}")
	public ModelAndView memmodify(@PathVariable String num) {
		System.out.println("들어왔음");
		int num1=Integer.parseInt(num);
		if(num1==4) {
			System.out.println("4안에있음");
			ModelAndView mav = new ModelAndView("account4");
			mav.addObject("page", num);
			return mav;
		}
		else if(num1==5) {
			System.out.println("5안에있음");
			ModelAndView mav = new ModelAndView("account5");
			mav.addObject("page", num);
			return mav;
		}
		return null;
	
	}
		
		
		
		
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
	
	
	
	

