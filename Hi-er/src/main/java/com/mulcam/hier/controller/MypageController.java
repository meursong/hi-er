package com.mulcam.hier.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mulcam.hier.dto.Paging;
import com.mulcam.hier.dto.User;
import com.mulcam.hier.service.MypageService;

@Controller
public class MypageController {

	@Autowired
	MypageService mypageService;

	@Autowired
	HttpSession session;

	// 마이페이지 들어오면 처음 불려오는것들 찾아옴
	@GetMapping("mypage") // 마이페이지 들어오면
	public ModelAndView mypage() {
		ModelAndView mav = new ModelAndView("account");
		try {
			int user_id = ((User) session.getAttribute("loginedUser")).getUser_id();// 세션에서 유저의 아이디를 가져옴
			System.out.println(user_id);
			List<Map<String, Object>> ord = mypageService.history2(user_id);// 유저의 아이디로 거래내역을 가져옴
			List<Map<String, Object>> likepost = mypageService.history3(user_id);// 유저의 아이디로 찜한 목록을 가져옴
			mav.addObject("orders", ord);// 가져온 ord를 orders로 프론트로 내려보낼거임
			mav.addObject("likeposts", likepost);
			mav.addObject("page", "0");// 페이지0으로 들어갈거임 마이페이지 홈
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	// 마이페이지에서 자세히 눌렀을때 페이지 이동/값들을 가져옴
	@GetMapping("mypage/{num}/{page2}") // 넘이 1이면 거래내역자세히 2면 찜한목록자세히 3이면 쪽지내역 자세히 page2는 자세히 안에서 페이지임
	public ModelAndView mypage1(@PathVariable String num, @PathVariable String page2) {
		try {
			int user_id = ((User) session.getAttribute("loginedUser")).getUser_id();
			if (num.equals("1")) {// 거래내역자세히가 눌렸다면
				ModelAndView mav = new ModelAndView("account1");// 목표 뷰는 account1임->거래내역 자세히 나오는 페이지

//				
				Paging pageInfo = new Paging();
				System.out.println(pageInfo);
				int page = Integer.parseInt(page2);// 페이지2는 스트링으로 들어왔기 때문에 인티저로 바꿔줌
				List<Map<String, Object>> ord = mypageService.getBoardList(page, pageInfo,user_id);// 페이지에 맞는 5개의 결과값을 가져옴
				mav.addObject("pageInfo", pageInfo);//
				mav.addObject("orders", ord);
				mav.addObject("page", num);
				return mav;

			} else if (num.equals("2")) {// 2라면
				ModelAndView mav = new ModelAndView("account2");
				Paging pageInfo = new Paging();
				int page = Integer.parseInt(page2);
				List<Map<String, Object>> likepost = mypageService.getBoardList2(page, pageInfo,user_id);
				mav.addObject("pageInfo2", pageInfo);
				mav.addObject("likeposts", likepost);
				mav.addObject("page", num);
				return mav;
			} else {
				ModelAndView mav = new ModelAndView("account");
				return mav;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 닉네임이 중복인지 확인
	@ResponseBody
	@PostMapping("nickoverlap")
	public String accoverlap(@RequestParam(value = "nick") String nick) {
		boolean overlap = false;
		try {
			overlap = mypageService.nickOverlap(nick);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return String.valueOf(overlap);
	}

	// 닉네임 업데이트
	@ResponseBody
	@PostMapping("nickupdate")
	public String nickupdate(@RequestParam(value = "nick") String nick) {
		System.out.println("여기 닉네임업데이트");
		int user_id = ((User) session.getAttribute("loginedUser")).getUser_id();
		// boolean nickupdate=false;
		try {
			System.out.println("트라이 안");
			mypageService.nickupdate(nick,user_id);
			return String.valueOf(true);
		} catch (Exception e) {
			e.printStackTrace();
			return String.valueOf(false);
		}

	}

	// 패스워드 업데이트
	@ResponseBody
	@PostMapping("passupdate")
	public String passupdate(@RequestParam(value = "pass") String pass, @RequestParam(value = "pass2") String pass2) {
		System.out.println("여기 패스워드 업데이트");
		int user_id = ((User) session.getAttribute("loginedUser")).getUser_id();
		try {

			if (true == mypageService.passfindupdate(pass, pass2,user_id)) {
				return String.valueOf(true);
			} else
				return String.valueOf(false);
		} catch (Exception e) {
			e.printStackTrace();
			return String.valueOf(false);
		}

	}

	// 프리랜서 소개글 수정
	@ResponseBody
	@PostMapping("intromody")
	public String intromody(@RequestParam(value = "intro") String intro) {
		System.out.println("여기가 인트로 안임");
		int user_id = ((User) session.getAttribute("loginedUser")).getUser_id();
		try {
			if (true == mypageService.introupdate(intro,user_id)) {
				return String.valueOf(true);
			} else
				return String.valueOf(false);
		} catch (Exception e) {
			e.printStackTrace();
			return String.valueOf(false);
		}

	}

	// 프리랜서 지역 수정
	@ResponseBody
	@PostMapping("locationmody")
	public String locationmody(@RequestParam(value = "address") String address,
			@RequestParam(value = "address2") String address2) {
		int user_id = ((User) session.getAttribute("loginedUser")).getUser_id();
		System.out.println("여기가 로케이션모디 안임");
		try {
			if (true == mypageService.addressupdate(address, address2,user_id)) {
				return String.valueOf(true);
			} else
				return String.valueOf(false);
		} catch (Exception e) {
			e.printStackTrace();
			return String.valueOf(false);
		}

	}

	// 리뷰 작성
	@ResponseBody
	@PostMapping("review")
	public String review(@RequestParam(value = "content") String content,
			@RequestParam(value = "rating") int star_point, @RequestParam(value = "order_id") int order_id) {
		boolean review = false;
		int user_id = ((User) session.getAttribute("loginedUser")).getUser_id();
		try {
			review = mypageService.reviewWrite(content, star_point, order_id,user_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return String.valueOf(review);
	}

	// 이미지 업로드 아직 미완성
	@PostMapping("imageupload")
	public String imageupload() {
		System.out.println("sssssssssssssssssssssssss");
		return "account";
	}

	// 내정보수정,프리랜서정보수정
	@GetMapping("mypage/{num}")
	public ModelAndView memmodify(@PathVariable String num) {
		int num1 = Integer.parseInt(num);
		if (num1 == 4) {
			ModelAndView mav = new ModelAndView("account4");
			mav.addObject("page", num);
			return mav;
		} else if (num1 == 5) {
			ModelAndView mav = new ModelAndView("account5");
			mav.addObject("page", num);
			return mav;
		}
		return null;

	}

}
