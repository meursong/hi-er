package com.mulcam.hier.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/post")
@Controller
public class PostController {

	@GetMapping("/detail")
	public ModelAndView productDetailPage() {
		System.out.println("게시물상세보기요청");
		ModelAndView mav = new ModelAndView("product-detail");
		return mav;
	}

	@GetMapping("/write")
	public ModelAndView write() {
		ModelAndView mav = new ModelAndView("write");
		return mav;
	}
	
	@PostMapping("/write")
	public String write(HttpServletRequest request) {
		System.out.println("글쓰기경로!!!!!!!!!!");
		System.out.println(request);
		System.out.println(request.getParameter("file1"));
		System.out.println(request.getParameter("basicPkgDescription"));
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		System.out.println(title);
		System.out.println(content);
		
		
		return "/product-detail";
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
}
