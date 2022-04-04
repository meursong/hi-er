package com.mulcam.hier.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter @Setter
public class ProductList {
	private int product_id;
	private String nickname;
	private String job;
	private String title;
	private int commission;
	private int avg_star_point;
	private int review_count;
	
}
