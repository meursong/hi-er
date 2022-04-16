package com.mulcam.hier.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mulcam.hier.dto.Paging;
import com.mulcam.hier.dto.User;
import com.mulcam.hier.service.MypageService;

@Controller
public class MypageController {

	@Autowired
	MypageService mypageService;

	@Autowired
	ServletContext servletContext;

	@Autowired
	HttpSession session;

	@Value("${upload.filepath}")
	private String filepath;

	@Value("${upload.filepath.cloud}")
	private boolean iscloud;

	@GetMapping("mypage")
	public ModelAndView mypage() {
		ModelAndView mav = new ModelAndView("account");
		try {
			int user_id = ((User) session.getAttribute("loginedUser")).getUser_id();// 세션에서 유저의 아이디를 가져옴
			System.out.println(user_id);
			Map<String, Object> statistics1 = mypageService.count(user_id);

			// List<Map<String, Object>> count = null;
			// count.add(count1);
			// listMapInsert.add(map);
			List<Map<String, Object>> ord = mypageService.history2(user_id);// 유저의 아이디로 거래내역을 가져옴
			List<Map<String, Object>> likepost = mypageService.history3(user_id);// 유저의 아이디로 찜한 목록을 가져옴
			// System.out.println(count+"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
			mav.addObject("statistics", statistics1);// 가져온 ord를 orders로 프론트로 내려보낼거임
			mav.addObject("orders", ord);// 가져온 ord를 orders로 프론트로 내려보낼거임
			mav.addObject("likeposts", likepost);
			mav.addObject("page", "0");// 페이지0으로 들어갈거임 마이페이지 홈
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@GetMapping("admin") // 마이페이지 들어오면
	public ModelAndView admin() {
		ModelAndView mav = new ModelAndView("admin");
		try {
			int user_id = ((User) session.getAttribute("loginedUser")).getUser_id();// 세션에서 유저의 아이디를 가져옴
			System.out.println(user_id);
			Map<String, Object> statistics1 = mypageService.count(user_id);
			List<Map<String, Object>> report = mypageService.report5();// 유저의 아이디로 거래내역을 가져옴

			mav.addObject("statistics", statistics1);// 가져온 ord를 orders로 프론트로 내려보낼거임
			mav.addObject("reports", report);

			mav.addObject("page", "0");// 페이지0으로 들어갈거임 마이페이지 홈
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@PostMapping("sortBoardCount")
	public String sortBoardCount(@RequestParam String id, Model model) {// 아이디 소트보드카운트/소트 어쩌고...

		try {
			if ("sortBoardCount".equals(id)) {
				System.out.println("들어오모옴옴오모들어오모옴옴오모들어오모옴옴오모들어오모옴옴오모들어오모옴옴오모");
				List<Map<String, Object>> sortBoardCount1 = mypageService.sortBoardCount(id);
				System.out.println(sortBoardCount1);
				model.addAttribute("sortBoardCounts", sortBoardCount1);

			} else if ("sortPriceTotal".equals(id)) {
				List<Map<String, Object>> sortBoardCount1 = mypageService.sortBoardCount(id);
				System.out.println(sortBoardCount1);
				model.addAttribute("sortBoardCounts", sortBoardCount1);
			} else if ("sortreported".equals(id)) {
				List<Map<String, Object>> sortBoardCount1 = mypageService.sortBoardCount(id);
				System.out.println(sortBoardCount1);
				model.addAttribute("sortBoardCounts", sortBoardCount1);
			} else {// sortliked
				List<Map<String, Object>> sortBoardCount1 = mypageService.sortBoardCount(id);
				System.out.println(sortBoardCount1);
				model.addAttribute("sortBoardCounts", sortBoardCount1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/admin :: #kkk";

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
				List<Map<String, Object>> ord = mypageService.getBoardList(page, pageInfo, user_id);// 페이지에 맞는 5개의 결과값을
																									// 가져옴
				mav.addObject("pageInfo", pageInfo);//
				mav.addObject("orders", ord);
				mav.addObject("page", num);
				return mav;

			} else if (num.equals("2")) {// 2라면
				ModelAndView mav = new ModelAndView("account2");
				Paging pageInfo = new Paging();
				int page = Integer.parseInt(page2);
				List<Map<String, Object>> likepost = mypageService.getBoardList2(page, pageInfo, user_id);
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

		User user = (User) session.getAttribute("loginedUser");
		// boolean nickupdate=false;

		try {
			System.out.println("트라이 안");
			mypageService.nickupdate(nick, user.getUser_id());
			user.setNickname(nick);
			session.invalidate();
			session.setAttribute("loginedUser", user);
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
		User user = (User) session.getAttribute("loginedUser");

		try {

			if (true == mypageService.passfindupdate(pass, pass2, user.getUser_id())) {
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
		User user = (User) session.getAttribute("loginedUser");

		try {
			if (true == mypageService.introupdate(intro, user.getUser_id())) {
				/*
				 * user.setNickname(nick); session.invalidate();
				 * session.setAttribute("loginedUser", user);
				 */
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
			if (true == mypageService.addressupdate(address, address2, user_id)) {
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
			review = mypageService.reviewWrite(content, star_point, order_id, user_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return String.valueOf(review);
	}

	// 이미지 업로드 아직 미완성
	@PostMapping("/profileImageUpdate")
	public void profileImageUpdate(MultipartFile file) {
		System.out.println("회원 이미지 수정 컨트롤러 도착");
		String filename = null;
		try {
			String path = "";
			if (iscloud) {
				path = filepath;
			} else {
				path = servletContext.getRealPath(filepath);
			}
			String time = Long.valueOf(new Date().getTime()).toString();
			if (file != null && !file.isEmpty()) {
				System.out.println(file.getOriginalFilename());
				filename = time + file.getOriginalFilename();
				File destFile = new File(path + filename);
				System.out.println(destFile);
				file.transferTo(destFile);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

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

	// 하트 리무브
	@ResponseBody
	@PostMapping("heartremove")
	public String heartremove(@RequestParam(value = "like_id") int like_id) {
		boolean like = false;

		try {
			like = mypageService.heartremove(like_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return String.valueOf(like);
	}

	// 유저 삭제
	@ResponseBody
	@PostMapping("userdelete")
	public String userdelete(@RequestParam(value = "id") int like_id) {
		System.out.println("kkkkkkkkkkkk");
		return null;
	}

	@ResponseBody
	@PostMapping("clicktitle")
	public String clicktitle(@RequestParam(value = "id") String id) {

		String value = "/post/detail/" + id;
		return String.valueOf(value);
	}

	@ResponseBody
	@PostMapping("clickname")
	public String clickname(@RequestParam(value = "id") String id) {

		String value = "/freelancerInfo/" + id;
		return String.valueOf(value);
	}

}
