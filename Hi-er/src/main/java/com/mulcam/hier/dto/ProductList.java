package com.mulcam.hier.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class ProductList extends Criteria {
	
	//게시글 이미지 필요
	private String category;
	private String nickname;
	private MultipartFile profile_image;
	private String job;
	private String title;
	private int commission;
	private float avg_star_point;
	private int review_count;
	private String createdAt;
	
}
