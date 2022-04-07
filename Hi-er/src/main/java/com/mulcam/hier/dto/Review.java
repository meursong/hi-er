package com.mulcam.hier.dto;

import java.sql.Date;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter @Setter

public class Review extends Criteria {
	private int review_wid;
	private int product_id;
	private int user_id;
	private int seller_id;
	private String content;
	private int star_point;
	private Date CreatedAt;
	private String nickname;
}
