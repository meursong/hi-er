package com.mulcam.hier.controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
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
	
	@Value("${upload.filepath}")
	private String filepath;
	
	@Value("${upload.filepath.cloud}")
	private boolean iscloud;	

	@GetMapping("/detail")
	public ModelAndView productDetailPage() {
		ModelAndView mav = new ModelAndView("product-detail");
		return mav;
	}

	@GetMapping("/designWrite")
	public String designWrite(Model model) throws Exception {
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
			String path="";
			if(iscloud) {
				path=filepath;
			} else {
				path = servletContext.getRealPath(filepath);
			}
			String time = Long.valueOf(new Date().getTime()).toString();
			if (file != null && !file.isEmpty()) {
				filename = time + file.getOriginalFilename() ;
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
			String path="";
			if(iscloud) {
				path=filepath;
			} else {
				path = servletContext.getRealPath(filepath);
			}
			String time = Long.valueOf(new Date().getTime()).toString();
			int width = 730, height = 450;
			if (file != null && !file.isEmpty()) {
				filename = time + file.getOriginalFilename();
				File destFile = new File(path + filename);
				BufferedImage inputImage = ImageIO.read(file.getInputStream());
				BufferedImage outputImage = new BufferedImage(width, height, inputImage.getType());

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
		int seller_id = ((User) session.getAttribute("loginedUser")).getUser_id();
		try {
			product.setFilename1(resizeFileupload(product.getFile1()));
			product.setFilename2(fileupload(product.getFile2()));
			product.setFilename3(resizeFileupload(product.getFile3()));
			product.setFilename4(resizeFileupload(product.getFile4()));
			product.setFilename5(resizeFileupload(product.getFile5()));
			product.setFilename6(resizeFileupload(product.getFile6()));
			product.setFilename7(resizeFileupload(product.getFile7()));
			product.setFilename8(resizeFileupload(product.getFile8()));
			product.setIs_available(0); // 0:???????????? 1:????????????
			product.setSeller_id(seller_id);
			postService.writePost(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/product/category/2";
	}

	@PostMapping("/designWrite")
	public String write(@ModelAttribute Product product) {
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
			product.setIs_available(0); // 0:???????????? 1:????????????
			product.setSeller_id(seller_id);
			postService.writePost(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/product/category/1"; // ?????? ????????? ???????????? ??????
	}

	@PostMapping("/itWrite")
	public String itWrite(@ModelAttribute Product product) {
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
			product.setIs_available(0); // 0:???????????? 1:????????????
			product.setSeller_id(seller_id);
			postService.writePost(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/product/category/3"; // ?????? ????????? ???????????? ??????
	}

	//ckeditor ????????? ?????????
	@ResponseBody
	@PostMapping("/uploadImage")
	public String uploadImage(HttpServletResponse response, @RequestParam("upload") MultipartFile file) {
		String result = null;

		// [start] ?????? ?????? ?????? ??????
		// ????????? ????????? ??????
	
		String saveDir="";
		if(iscloud) {
			saveDir=filepath;
		} else {
			saveDir = servletContext.getRealPath(filepath);
		}
		
		String newFileName = null;

		// ?????? ????????????(upload)??? ?????? ?????? ?????? ?????? ??????
		File dir = new File(saveDir);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		// [end] ?????? ?????? ?????? ??????

		if (!file.isEmpty()) {
			// ?????? ????????? ????????????
			String originFileName = file.getOriginalFilename();
			// ?????? ??????????????? ????????? ??????
			String extension = originFileName.substring(originFileName.lastIndexOf("."));

			// ???????????? ??????
			UUID uuid = UUID.randomUUID();

			// ????????? ?????? (???????????? + ?????????)
			newFileName = uuid + extension;

			// ?????? ??? ?????????, ?????? ?????? ?????? ???????????? ????????? ?????? ?????? or ????????? ????????? ??? ??????.
			try {
				// ?????? ??????
				file.transferTo(new File(saveDir + "/" + newFileName));

				return "{\"filename\":\"" + newFileName + "\",\"uploaded\" : 1, \"url\":\""
						+ "/upload/" + newFileName + "\" }";
			} catch (Exception e) {
				e.printStackTrace();
				return "{ \"uploaded\" : false, \"error\": { \"message\": \"????????? ??? ????????? ??????????????????. ?????? ????????? ?????????.\" } }";
			}
		}
		return result;
	}

	@GetMapping("/detail/{pid}")
	public ModelAndView detail(@PathVariable("pid") Integer pid, @ModelAttribute("params") Review params) {
		ModelAndView mav = new ModelAndView("product-detail");
		params.setProduct_id(pid);
		params.setRecordsPerPage(3);
		try {
			User logined_user = (User) session.getAttribute("loginedUser");
			if (logined_user != null) {
				Product product = postService.productDetail(pid);
				Product priceInfo = postService.priceInfo(pid);
				Integer likedNum = postService.likeNum(pid, logined_user.getUser_id());
				boolean isLike = postService.isLike(pid, logined_user.getUser_id());
				List<Review> reviews = reviewService.prodReviewList(params);
				Integer maxReviewCnt = reviewService.maxReviewCnt(pid);
				Integer maxReviewCntOriginal = maxReviewCnt;
				List<Map<String, Integer>> reviewCount = reviewService.reviewCount(pid);

				List<Map<String, Integer>> fiveReviewCount = new ArrayList<>();

				// fiveReviewCount ?????? <??????,0>?????? ???????????????
				for (int i = 0; i < 5; i++) {
					Map<String, Integer> nullreview = new HashMap<String, Integer>();
					nullreview.put("star_point", i + 1);
					nullreview.put("count", 0);
					fiveReviewCount.add(i, nullreview);
				}
				// ?????? ???????????? ?????? ????????? add
				for (int j = 0; j < reviewCount.size(); j++) {
					fiveReviewCount.set(reviewCount.get(j).get("star_point") - 1, reviewCount.get(j));
				}

			
				fiveReviewCount = fiveReviewCount.stream().sorted((o1, o2) -> o2.get("star_point").compareTo(o1.get("star_point")) ).collect(Collectors.toList());
				
				
				
				FreelancerUser sellerInfo = userService.sellerInfo(product.getSeller_id());
				System.out.println(sellerInfo.getSeller_id() + ": ???????????????????????????????????????????????????????????????");
				Map<String, Object> likeInfo = new HashMap<String, Object>();

				

				if (maxReviewCnt == 0) {
					maxReviewCnt = 1;
				}
				likeInfo.put("likeNum", likedNum);
				likeInfo.put("isLike", isLike);

				mav.addObject("likeInfo", likeInfo);
				mav.addObject("product", product);
				mav.addObject("priceInfo", priceInfo);
				mav.addObject("reviews", reviews);
				mav.addObject("sellerInfo", sellerInfo);
				mav.addObject("reviewCounts", fiveReviewCount);
				mav.addObject("maxReviewCnt", maxReviewCnt);
				mav.addObject("maxReviewCntOriginal", maxReviewCntOriginal);
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
			result = "????????????";
		} catch (Exception e) {
			e.printStackTrace();
			result = "??????~";
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

	// ???????????? ?????????
	@PostMapping("/payment")
	public ModelAndView pay(@ModelAttribute Product product, @ModelAttribute FreelancerUser freelancerUser) { // mav???
		ModelAndView mav = new ModelAndView("payment");
		//
		// abc??? b??? >> model ????????? b??? ????????? ?????????...
		// abc??? s??? >> model ????????? s??? ????????? ?????????...
		// a
		String pkg = product.getPaymentPkg();
		int price = product.getB_price();
		if (pkg.equals("Basic")) {
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
			int total_price = product.getB_price()+product.getB_additional_price();
			mav.addObject("total_price", total_price);
		} else if (pkg.equals("Standard")) {
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
			int total_price = product.getS_price()+product.getS_additional_price();
			mav.addObject("total_price", total_price);
		} else if (pkg.equals("Premium")) {
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
			int total_price = product.getP_price()+product.getP_additional_price();
			mav.addObject("total_price", total_price);
		}
		return mav; // ?????????????????? ??????
	}
}
