package com.mulcam.hier.controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mulcam.hier.dto.FreelancerUser;
import com.mulcam.hier.dto.Product;
import com.mulcam.hier.dto.Review;
import com.mulcam.hier.dto.User;
import com.mulcam.hier.service.PostService;
import com.mulcam.hier.service.ReviewService;
import com.mulcam.hier.service.UserService;

@RequestMapping("/post")
@Controller
public class PostController {

	@Autowired
	UserService us;

	@Autowired
	PostService postService;

	@Autowired
	ReviewService reviewService;

	@Autowired
	UserService userService;

	@Autowired
	ServletContext servletContext;

	@Autowired
	HttpSession session;

	@GetMapping("/detail")
	public ModelAndView productDetailPage() {
		System.out.println("게시물상세보기요청");
		ModelAndView mav = new ModelAndView("product-detail");
		return mav;
	}

	@GetMapping("/designWrite")
	public String designWrite(Model model) throws Exception {
		System.out.println((User) session.getAttribute("loginedUser"));
		if ((User) session.getAttribute("loginedUser") != null) {
			int user_id = ((User) session.getAttribute("loginedUser")).getUser_id();
			User email = us.selectEmail(user_id);
			model.addAttribute("email", email);
			return "designWrite";
		} else {
			return "login";
		}
	}

	@GetMapping("/videoWrite")
	public String videoWrite(Model model) throws Exception {
		System.out.println((User) session.getAttribute("loginedUser"));
		if ((User) session.getAttribute("loginedUser") != null) {
			int user_id = ((User) session.getAttribute("loginedUser")).getUser_id();
			User email = us.selectEmail(user_id);
			model.addAttribute("email", email);
			return "videoWrite";
		} else {
			return "login";
		}
	}
	
	@GetMapping("/ITwrite")
	public String itWrite(Model model) throws Exception {
		System.out.println((User) session.getAttribute("loginedUser"));
		if ((User) session.getAttribute("loginedUser") != null) {
			int user_id = ((User) session.getAttribute("loginedUser")).getUser_id();
			User email = us.selectEmail(user_id);
			model.addAttribute("email", email);
			return "itWrite";
		} else {
			return "login";
		}
	}


	private String fileupload(MultipartFile file) {
		String filename = null;
		try {
			String path = servletContext.getRealPath("/upload/");
			String time = Long.valueOf(new Date().getTime()).toString();
			if (file != null && !file.isEmpty()) {
				filename = file.getOriginalFilename() + time;
				File destFile = new File(path + filename);
				file.transferTo(destFile);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filename;
	}
	
	private String resizeFileupload(MultipartFile file) {
		String filename = null;
		try {
			String path = servletContext.getRealPath("/upload/");
			String time = Long.valueOf(new Date().getTime()).toString();
			int width=730, height=450;
			if (file != null && !file.isEmpty()) {
				filename = file.getOriginalFilename() + time;
				File destFile = new File(path + filename);
				BufferedImage inputImage = ImageIO.read(file.getInputStream());
				BufferedImage outputImage = new BufferedImage(width,height,inputImage.getType());
				
				Graphics2D graphics2D = outputImage.createGraphics();
				graphics2D.drawImage(inputImage, 0, 0, width, height, null);
				graphics2D.dispose();
				String fileName = file.getOriginalFilename();
				String ext = fileName.substring(fileName.lastIndexOf(".") + 1);			
				ImageIO.write(outputImage, ext, destFile);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filename;
	}
	

	@PostMapping("/videoWrite")
	public String videoWrite(@ModelAttribute Product product) {
		System.out.println("영상편집 글쓰기 경로!!!!!!!!!!");
		int seller_id = ((User) session.getAttribute("loginedUser")).getUser_id();
		try {
			product.setFilename1(fileupload(product.getFile1()));
			product.setFilename2(resizeFileupload(product.getFile2()));
			product.setFilename3(resizeFileupload(product.getFile3()));
			product.setFilename4(resizeFileupload(product.getFile4()));
			product.setFilename5(resizeFileupload(product.getFile5()));
			product.setFilename6(resizeFileupload(product.getFile6()));
			product.setFilename7(resizeFileupload(product.getFile7()));
			product.setFilename8(resizeFileupload(product.getFile8()));
			product.setIs_available(0); // 0:거래가능 1:거래중지
			product.setSeller_id(seller_id); 
			postService.writePost(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/product/category/2";
	}

	@PostMapping("/designWrite")
	public String write(@ModelAttribute Product product) {
		System.out.println("디자인 글쓰기 경로!!!!!!!!!!");
		int seller_id = ((User) session.getAttribute("loginedUser")).getUser_id();
		try {
			product.setFilename1(resizeFileupload(product.getFile1()));
			product.setFilename2(resizeFileupload(product.getFile2()));
			product.setFilename3(resizeFileupload(product.getFile3()));
			product.setFilename4(resizeFileupload(product.getFile4()));
			product.setFilename5(resizeFileupload(product.getFile5()));
			product.setFilename6(resizeFileupload(product.getFile6()));
			product.setFilename7(resizeFileupload(product.getFile7()));
			product.setFilename8(resizeFileupload(product.getFile8()));
			product.setIs_available(0); // 0:거래가능 1:거래중지
			product.setSeller_id(seller_id);
			postService.writePost(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/product/category/1"; // 추후 게시판 페이지로 변경
	}

	@PostMapping("/itWrite")
	public String itWrite(@ModelAttribute Product product) {
		System.out.println("디자인 글쓰기 경로!!!!!!!!!!");
		int seller_id = ((User) session.getAttribute("loginedUser")).getUser_id();
		try {
			product.setFilename1(resizeFileupload(product.getFile1()));
			product.setFilename2(resizeFileupload(product.getFile2()));
			product.setFilename3(resizeFileupload(product.getFile3()));
			product.setFilename4(resizeFileupload(product.getFile4()));
			product.setFilename5(resizeFileupload(product.getFile5()));
			product.setFilename6(resizeFileupload(product.getFile6()));
			product.setFilename7(resizeFileupload(product.getFile7()));
			product.setFilename8(resizeFileupload(product.getFile8()));
			product.setIs_available(0); // 0:거래가능 1:거래중지
			product.setSeller_id(seller_id);
			postService.writePost(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/product/category/3"; // 추후 게시판 페이지로 변경
	}
	
	@ResponseBody
	@PostMapping("/uploadImage")
	public String uploadImage(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("upload") MultipartFile file) {
		String result = null;

		// [start] 파일 저장 경로 설정
		// 파일을 저장할 경로
		String saveDir = request.getSession().getServletContext().getRealPath("/upload/");
		String newFileName = null;

		// 해당 폴더경로(upload)가 없을 경우 폴더 자동 생성
		File dir = new File(saveDir);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		// [end] 파일 저장 경로 설정

		if (!file.isEmpty()) {
			// 원본 파일명 가져오기
			String originFileName = file.getOriginalFilename();
			// 원본 파일명에서 확장자 추출
			String extension = originFileName.substring(originFileName.lastIndexOf("."));

			// 랜덤문자 생성
			UUID uuid = UUID.randomUUID();

			// 파일명 변경 (랜덤문자 + 확장자)
			newFileName = uuid + extension;

			// 저장 전 확장자, 파일 크기 등을 제한하여 조건에 따라 저장 or 에러를 표현할 수 있다.
			try {
				// 파일 저장
				file.transferTo(new File(saveDir + "/" + newFileName));

				return "{\"filename\":\"" + newFileName + "\",\"uploaded\" : 1, \"url\":\""
						+ "http://localhost:8090/upload/" + newFileName + "\" }";
			} catch (Exception e) {
				e.printStackTrace();
				return "{ \"uploaded\" : false, \"error\": { \"message\": \"업로드 중 에러가 발생했습니다. 다시 시도해 주세요.\" } }";
			}
		}
		return result;
	}

	@GetMapping("/detail/{pid}")
	public ModelAndView detail(@PathVariable("pid") Integer pid, @ModelAttribute("params") Review params) {
		ModelAndView mav = new ModelAndView("product-detail");
		params.setProduct_id(pid);
		params.setRecordsPerPage(2);
		try {
			User logined_user = (User) session.getAttribute("loginedUser");
			if (logined_user != null) {
				Product product = postService.productDetail(pid);
				Product priceInfo = postService.priceInfo(pid);
				Integer likedNum = postService.likeNum(pid, logined_user.getUser_id());
				boolean isLike = postService.isLike(pid, logined_user.getUser_id());
				List<Review> reviews = reviewService.prodReviewList(params);
				FreelancerUser sellerInfo = userService.sellerInfo(product.getSeller_id());
				Map<String, Object> likeInfo = new HashMap<String, Object>();
				likeInfo.put("likeNum", likedNum);
				likeInfo.put("isLike", isLike);

				mav.addObject("likeInfo", likeInfo);
				mav.addObject("product", product);
				mav.addObject("priceInfo", priceInfo);
				mav.addObject("reviews", reviews);
				mav.addObject("sellerInfo", sellerInfo);
			} else {
				mav.setViewName("login");
			}

		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("err", e.getMessage());
		}
		return mav;
	}

	@ResponseBody
	@PostMapping("/report")
	public String reportPost(@RequestParam("reason") String reason, @RequestParam("pid") Integer pid,
			@RequestParam("reported_userid") Integer reported_userid) {
		String result;
		Integer report_userid = ((User) session.getAttribute("loginedUser")).getUser_id();
		try {
			postService.reportPost(reason, pid, reported_userid, report_userid);
			result = "신고완료";
		} catch (Exception e) {
			e.printStackTrace();
			result = "오류~";
		}
		return result;
	}

	@ResponseBody
	@PostMapping("/like")
	public Map<String, Object> like(@RequestParam("pid") Integer pid) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			Integer like_userid = ((User) session.getAttribute("loginedUser")).getUser_id();
			result = postService.like(pid, like_userid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// 결제하기 테스트
	@PostMapping("/payment")
	public ModelAndView pay(@ModelAttribute Product product, @ModelAttribute FreelancerUser freelancerUser) { // mav로
		ModelAndView mav = new ModelAndView("payment");
		System.out.println(product.getPaymentPkg());
		System.out.println(product.getB_price());
		//
		// abc가 b면 >> model 에다가 b를 통째로 넣어요...
		// abc가 s면 >> model 에다가 s를 통째로 넣어요...
		// a
		String pkg = product.getPaymentPkg();
		int price = product.getB_price();
		if(pkg.equals("Basic")) {
			mav.addObject("price", product.getB_price());
			mav.addObject("additional_price", product.getB_additional_price());
			mav.addObject("commercial", product.getB_commercial());
			mav.addObject("default_delivery", product.getB_default_delivery());
			mav.addObject("draft", product.getB_draft());
			mav.addObject("minimum_delivery", product.getB_minimum_delivery());
			mav.addObject("original_image", product.getB_original_image());
			mav.addObject("pkg_description", product.getB_pkg_description());
			mav.addObject("revision", product.getB_revision());
			mav.addObject("sns_Kit", product.getB_sns_Kit());
		} else if(pkg.equals("Standard")) {
			mav.addObject("price", product.getS_price());
			mav.addObject("additional_price", product.getS_additional_price());
			mav.addObject("commercial", product.getS_commercial());
			mav.addObject("default_delivery", product.getS_default_delivery());
			mav.addObject("draft", product.getS_draft());
			mav.addObject("minimum_delivery", product.getS_minimum_delivery());
			mav.addObject("original_image", product.getS_original_image());
			mav.addObject("pkg_description", product.getS_pkg_description());
			mav.addObject("revision", product.getS_revision());
			mav.addObject("sns_Kit", product.getS_sns_Kit());
		} else if(pkg.equals("Premium")) {
			mav.addObject("price", product.getP_price());
			mav.addObject("additional_price", product.getP_additional_price());
			mav.addObject("commercial", product.getP_commercial());
			mav.addObject("default_delivery", product.getP_default_delivery());
			mav.addObject("draft", product.getP_draft());
			mav.addObject("minimum_delivery", product.getP_minimum_delivery());
			mav.addObject("original_image", product.getP_original_image());
			mav.addObject("pkg_description", product.getP_pkg_description());
			mav.addObject("revision", product.getP_revision());
			mav.addObject("sns_Kit", product.getP_sns_Kit());
		}
		return mav; // 결제페이지로 이동
	}
}
