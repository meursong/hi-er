package com.mulcam.hier.dto;

import java.time.LocalDate;
import org.springframework.web.multipart.MultipartFile;


public class Product {
	private String nickname;
	private int review_count;
	private float avg_star_point;
	private String profile_image;
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getReview_count() {
		return review_count;
	}

	public void setReview_count(int review_count) {
		this.review_count = review_count;
	}

	int product_id;
	
	// 제목
	String title;
	
	// 프리랜서(글쓴이) id
	int seller_id;
	
	// 작업가능 여부 - 거래신청 블락
	int is_available;
	
	// category
	String category;
	
	// 이미지
	MultipartFile file1;
	MultipartFile file2;
	MultipartFile file3;
	MultipartFile file4;
	MultipartFile file5;
	MultipartFile file6;
	MultipartFile file7;
	MultipartFile file8;
	
	String filename1;
	String filename2;
	String filename3;
	String filename4;
	String filename5;
	String filename6;
	String filename7;
	String filename8;

	// 내용(ckeditor)
	String content;

	// 패키지 설명
	String b_pkg_description;
	String s_pkg_description;
	String p_pkg_description;

	// 원본 이미지 제공
	String b_original_image;
	String s_original_image;
	String p_original_image;

	// 상업적 이용 가능
	String b_commercial;
	String s_commercial;
	String p_commercial;

	// sns 이미지 키트
	String b_sns_Kit;
	String s_sns_Kit;
	String p_sns_Kit;

	// 시안 개수
	int b_draft;
	int s_draft;
	int p_draft;

	// 수정 횟수
	int b_revision;
	int s_revision;
	int p_revision;

	// 기본 작업일
	int b_default_delivery;
	int s_default_delivery;
	int p_default_delivery;

	// 단축 작업일
	int b_minimum_delivery;
	int s_minimum_delivery;
	int p_minimum_delivery;

	// 작업단축 추가요금
	int b_additional_price;
	int s_additional_price;
	int p_additional_price;

	// 기본금액
	int b_price;
	int s_price;
	int p_price;

	// 수정 및 재진행
	String revisionPolicy;

	// 취소 및 환불
	String refundPolicy;

	// 기타 안내 사항
	String otherInformation;
	
	// 글쓴 시간
	LocalDate createdAt;
	
	// basic, standard, premium 구분
	String paymentPkg;

	

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getSeller_id() {
		return seller_id;
	}

	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}

	public int getIs_available() {
		return is_available;
	}

	public void setIs_available(int is_available) {
		this.is_available = is_available;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public MultipartFile getFile1() {
		return file1;
	}

	public void setFile1(MultipartFile file1) {
		this.file1 = file1;
	}

	public MultipartFile getFile2() {
		return file2;
	}

	public void setFile2(MultipartFile file2) {
		this.file2 = file2;
	}

	public MultipartFile getFile3() {
		return file3;
	}

	public void setFile3(MultipartFile file3) {
		this.file3 = file3;
	}

	public MultipartFile getFile4() {
		return file4;
	}

	public void setFile4(MultipartFile file4) {
		this.file4 = file4;
	}

	public MultipartFile getFile5() {
		return file5;
	}

	public void setFile5(MultipartFile file5) {
		this.file5 = file5;
	}

	public MultipartFile getFile6() {
		return file6;
	}

	public void setFile6(MultipartFile file6) {
		this.file6 = file6;
	}

	public MultipartFile getFile7() {
		return file7;
	}

	public void setFile7(MultipartFile file7) {
		this.file7 = file7;
	}

	public MultipartFile getFile8() {
		return file8;
	}

	public void setFile8(MultipartFile file8) {
		this.file8 = file8;
	}

	public String getFilename1() {
		return filename1;
	}

	public void setFilename1(String filename1) {
		this.filename1 = filename1;
	}

	public String getFilename2() {
		return filename2;
	}

	public void setFilename2(String filename2) {
		this.filename2 = filename2;
	}

	public String getFilename3() {
		return filename3;
	}

	public void setFilename3(String filename3) {
		this.filename3 = filename3;
	}

	public String getFilename4() {
		return filename4;
	}

	public void setFilename4(String filename4) {
		this.filename4 = filename4;
	}

	public String getFilename5() {
		return filename5;
	}

	public void setFilename5(String filename5) {
		this.filename5 = filename5;
	}

	public String getFilename6() {
		return filename6;
	}

	public void setFilename6(String filename6) {
		this.filename6 = filename6;
	}

	public String getFilename7() {
		return filename7;
	}

	public void setFilename7(String filename7) {
		this.filename7 = filename7;
	}

	public String getFilename8() {
		return filename8;
	}

	public void setFilename8(String filename8) {
		this.filename8 = filename8;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getB_pkg_description() {
		return b_pkg_description;
	}

	public void setB_pkg_description(String b_pkg_description) {
		this.b_pkg_description = b_pkg_description;
	}

	public String getS_pkg_description() {
		return s_pkg_description;
	}

	public void setS_pkg_description(String s_pkg_description) {
		this.s_pkg_description = s_pkg_description;
	}

	public String getP_pkg_description() {
		return p_pkg_description;
	}

	public void setP_pkg_description(String p_pkg_description) {
		this.p_pkg_description = p_pkg_description;
	}

	public String getB_original_image() {
		return b_original_image;
	}

	public void setB_original_image(String b_original_image) {
		this.b_original_image = b_original_image;
	}

	public String getS_original_image() {
		return s_original_image;
	}

	public void setS_original_image(String s_original_image) {
		this.s_original_image = s_original_image;
	}

	public String getP_original_image() {
		return p_original_image;
	}

	public void setP_original_image(String p_original_image) {
		this.p_original_image = p_original_image;
	}

	public String getB_commercial() {
		return b_commercial;
	}

	public void setB_commercial(String b_commercial) {
		this.b_commercial = b_commercial;
	}
	
	public String getS_commercial() {
		return s_commercial;
	}

	public void setS_commercial(String s_commercial) {
		this.s_commercial = s_commercial;
	}

	public String getP_commercial() {
		return p_commercial;
	}

	public void setP_commercial(String p_commercial) {
		this.p_commercial = p_commercial;
	}

	public String getB_sns_Kit() {
		return b_sns_Kit;
	}

	public void setB_sns_Kit(String b_sns_Kit) {
		this.b_sns_Kit = b_sns_Kit;
	}

	public String getS_sns_Kit() {
		return s_sns_Kit;
	}

	public void setS_sns_Kit(String s_sns_Kit) {
		this.s_sns_Kit = s_sns_Kit;
	}

	public String getP_sns_Kit() {
		return p_sns_Kit;
	}

	public void setP_sns_Kit(String p_sns_Kit) {
		this.p_sns_Kit = p_sns_Kit;
	}

	public int getB_draft() {
		return b_draft;
	}

	public void setB_draft(int b_draft) {
		this.b_draft = b_draft;
	}

	public int getS_draft() {
		return s_draft;
	}

	public void setS_draft(int s_draft) {
		this.s_draft = s_draft;
	}

	public int getP_draft() {
		return p_draft;
	}

	public void setP_draft(int p_draft) {
		this.p_draft = p_draft;
	}

	public int getB_revision() {
		return b_revision;
	}

	public void setB_revision(int b_revision) {
		this.b_revision = b_revision;
	}

	public int getS_revision() {
		return s_revision;
	}

	public void setS_revision(int s_revision) {
		this.s_revision = s_revision;
	}

	public int getP_revision() {
		return p_revision;
	}

	public void setP_revision(int p_revision) {
		this.p_revision = p_revision;
	}

	public int getB_default_delivery() {
		return b_default_delivery;
	}

	public void setB_default_delivery(int b_default_delivery) {
		this.b_default_delivery = b_default_delivery;
	}

	public int getS_default_delivery() {
		return s_default_delivery;
	}

	public void setS_default_delivery(int s_default_delivery) {
		this.s_default_delivery = s_default_delivery;
	}

	public int getP_default_delivery() {
		return p_default_delivery;
	}

	public void setP_default_delivery(int p_default_delivery) {
		this.p_default_delivery = p_default_delivery;
	}

	public int getB_minimum_delivery() {
		return b_minimum_delivery;
	}

	public void setB_minimum_delivery(int b_minimum_delivery) {
		this.b_minimum_delivery = b_minimum_delivery;
	}

	public int getS_minimum_delivery() {
		return s_minimum_delivery;
	}

	public void setS_minimum_delivery(int s_minimum_delivery) {
		this.s_minimum_delivery = s_minimum_delivery;
	}

	public int getP_minimum_delivery() {
		return p_minimum_delivery;
	}

	public void setP_minimum_delivery(int p_minimum_delivery) {
		this.p_minimum_delivery = p_minimum_delivery;
	}

	public int getB_additional_price() {
		return b_additional_price;
	}

	public void setB_additional_price(int b_additional_price) {
		this.b_additional_price = b_additional_price;
	}

	public int getS_additional_price() {
		return s_additional_price;
	}

	public void setS_additional_price(int s_additional_price) {
		this.s_additional_price = s_additional_price;
	}

	public int getP_additional_price() {
		return p_additional_price;
	}

	public void setP_additional_price(int p_additional_price) {
		this.p_additional_price = p_additional_price;
	}

	public int getB_price() {
		return b_price;
	}

	public void setB_price(int b_price) {
		this.b_price = b_price;
	}

	public int getS_price() {
		return s_price;
	}

	public void setS_price(int s_price) {
		this.s_price = s_price;
	}

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public String getRevisionPolicy() {
		return revisionPolicy;
	}

	public void setRevisionPolicy(String revisionPolicy) {
		this.revisionPolicy = revisionPolicy;
	}

	public String getRefundPolicy() {
		return refundPolicy;
	}

	public void setRefundPolicy(String refundPolicy) {
		this.refundPolicy = refundPolicy;
	}

	public String getOtherInformation() {
		return otherInformation;
	}

	public void setOtherInformation(String otherInformation) {
		this.otherInformation = otherInformation;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}
	
	public String getPaymentPkg() {
		return paymentPkg;
	}

	public void setPaymentPkg(String paymentPkg) {
		this.paymentPkg = paymentPkg;
	}

	public float getAvg_star_point() {
		return avg_star_point;
	}

	public void setAvg_star_point(float avg_star_point) {
		this.avg_star_point = avg_star_point;
	}

	public String getProfile_image() {
		return profile_image;
	}

	public void setProfile_image(String profile_image) {
		this.profile_image = profile_image;
	}
	

}
