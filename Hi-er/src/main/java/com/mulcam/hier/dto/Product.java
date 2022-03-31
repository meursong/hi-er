package com.mulcam.hier.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

	// 제목
	String title;

	// 이미지
	MultipartFile file1;
	MultipartFile file2;
	MultipartFile file3;
	MultipartFile file4;
	MultipartFile file5;
	MultipartFile file6;
	MultipartFile file7;
	MultipartFile file8;

	// 내용(ckeditor)
	String content;

	// 패키지 설명
	String basicPkgDescription;
	String standardPkgDescription;
	String premiumPkgDescription;

	// 원본 이미지 제공
	String basicOriginalImageProvide;
	String standardOriginalImageProvide;
	String premiumOriginalImageProvide;

	// 상업적 이용 가능
	String basicCommercializeAvailable;
	String standardCommercializeAvailable;
	String premiumCommercializeAvailable;

	// sns 이미지 키트
	String basicSNSKitProvide;
	String standardSNSKitProvide;
	String premiumSNSKitProvide;

	// 시안 개수
	int basicDraftNumber;
	int standardDraftNumber;
	int premiumDraftNumber;

	// 수정 횟수
	int basicRevisionNumber;
	int standardRevisionNumber;
	int premiumRevisionNumber;

	// 기본 작업일
	int basicDefaultDeliveryDate;
	int standardDefaultDeliveryDate;
	int premiumDefaultDeliveryDate;

	// 최소 작업일
	int basicCostomizedDeliveryDate;
	int standardCostomizedDeliveryDate;
	int premiumCostomizedDeliveryDate;

	// 작업단축 하루 당 추가요금
	int basicCostomizedDeliveryPrice;
	int standardCostomizedDeliveryPrice;
	int premiumCostomizedDeliveryPrice;

	// 기본금액
	int baicPrice;
	int standardPrice;
	int premiumPrice;

	// 수정 및 재진행
	String revisionPolicy;

	// 취소 및 환불
	String refundPolicy;

	// 기타 안내 사항
	String otherInformation;

	public Product() {
	}

	public Product(String title, MultipartFile file1, MultipartFile file2, MultipartFile file3, MultipartFile file4,
			MultipartFile file5, MultipartFile file6, MultipartFile file7, MultipartFile file8, String content,
			String basicPkgDescription, String standardPkgDescription, String premiumPkgDescription,
			String basicOriginalImageProvide, String standardOriginalImageProvide, String premiumOriginalImageProvide,
			String basicCommercializeAvailable, String standardCommercializeAvailable,
			String premiumCommercializeAvailable, String basicSNSKitProvide, String standardSNSKitProvide,
			String premiumSNSKitProvide, int basicDraftNumber, int standardDraftNumber, int premiumDraftNumber,
			int basicRevisionNumber, int standardRevisionNumber, int premiumRevisionNumber,
			int basicDefaultDeliveryDate, int standardDefaultDeliveryDate, int premiumDefaultDeliveryDate,
			int basicCostomizedDeliveryDate, int standardCostomizedDeliveryDate, int premiumCostomizedDeliveryDate,
			int basicCostomizedDeliveryPrice, int standardCostomizedDeliveryPrice, int premiumCostomizedDeliveryPrice,
			int baicPrice, int standardPrice, int premiumPrice, String revisionPolicy, String refundPolicy,
			String otherInformation
	) {
		this.title = title;
		this.file1 = file1;
		this.file2 = file2;
		this.file3 = file3;
		this.file4 = file4;
		this.file5 = file5;
		this.file6 = file6;
		this.file7 = file7;
		this.file8 = file8;
		this.content = content;
		this.basicPkgDescription = basicPkgDescription;
		this.standardPkgDescription = standardPkgDescription;
		this.premiumPkgDescription = premiumPkgDescription;
		this.basicOriginalImageProvide = basicOriginalImageProvide;
		this.standardOriginalImageProvide = standardOriginalImageProvide;
		this.premiumOriginalImageProvide = premiumOriginalImageProvide;
		this.basicCommercializeAvailable = basicCommercializeAvailable;
		this.standardCommercializeAvailable = standardCommercializeAvailable;
		this.premiumCommercializeAvailable = premiumCommercializeAvailable;
		this.basicSNSKitProvide = basicSNSKitProvide;
		this.standardSNSKitProvide = standardSNSKitProvide;
		this.premiumSNSKitProvide = premiumSNSKitProvide;
		this.basicDraftNumber = basicDraftNumber;
		this.standardDraftNumber = standardDraftNumber;
		this.premiumDraftNumber = premiumDraftNumber;
		this.basicRevisionNumber = basicRevisionNumber;
		this.standardRevisionNumber = standardRevisionNumber;
		this.premiumRevisionNumber = premiumRevisionNumber;
		this.basicDefaultDeliveryDate = basicDefaultDeliveryDate;
		this.standardDefaultDeliveryDate = standardDefaultDeliveryDate;
		this.premiumDefaultDeliveryDate = premiumDefaultDeliveryDate;
		this.basicCostomizedDeliveryDate = basicCostomizedDeliveryDate;
		this.standardCostomizedDeliveryDate = standardCostomizedDeliveryDate;
		this.premiumCostomizedDeliveryDate = premiumCostomizedDeliveryDate;
		this.basicCostomizedDeliveryPrice = basicCostomizedDeliveryPrice;
		this.standardCostomizedDeliveryPrice = standardCostomizedDeliveryPrice;
		this.premiumCostomizedDeliveryPrice = premiumCostomizedDeliveryPrice;
		this.baicPrice = baicPrice;
		this.standardPrice = standardPrice;
		this.premiumPrice = premiumPrice;
		this.revisionPolicy = revisionPolicy;
		this.refundPolicy = refundPolicy;
		this.otherInformation = otherInformation;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getBasicPkgDescription() {
		return basicPkgDescription;
	}

	public void setBasicPkgDescription(String basicPkgDescription) {
		this.basicPkgDescription = basicPkgDescription;
	}

	public String getStandardPkgDescription() {
		return standardPkgDescription;
	}

	public void setStandardPkgDescription(String standardPkgDescription) {
		this.standardPkgDescription = standardPkgDescription;
	}

	public String getPremiumPkgDescription() {
		return premiumPkgDescription;
	}

	public void setPremiumPkgDescription(String premiumPkgDescription) {
		this.premiumPkgDescription = premiumPkgDescription;
	}

	public String getBasicOriginalImageProvide() {
		return basicOriginalImageProvide;
	}

	public void setBasicOriginalImageProvide(String basicOriginalImageProvide) {
		this.basicOriginalImageProvide = basicOriginalImageProvide;
	}

	public String getStandardOriginalImageProvide() {
		return standardOriginalImageProvide;
	}

	public void setStandardOriginalImageProvide(String standardOriginalImageProvide) {
		this.standardOriginalImageProvide = standardOriginalImageProvide;
	}

	public String getPremiumOriginalImageProvide() {
		return premiumOriginalImageProvide;
	}

	public void setPremiumOriginalImageProvide(String premiumOriginalImageProvide) {
		this.premiumOriginalImageProvide = premiumOriginalImageProvide;
	}

	public String getBasicCommercializeAvailable() {
		return basicCommercializeAvailable;
	}

	public void setBasicCommercializeAvailable(String basicCommercializeAvailable) {
		this.basicCommercializeAvailable = basicCommercializeAvailable;
	}

	public String getStandardCommercializeAvailable() {
		return standardCommercializeAvailable;
	}

	public void setStandardCommercializeAvailable(String standardCommercializeAvailable) {
		this.standardCommercializeAvailable = standardCommercializeAvailable;
	}

	public String getPremiumCommercializeAvailable() {
		return premiumCommercializeAvailable;
	}

	public void setPremiumCommercializeAvailable(String premiumCommercializeAvailable) {
		this.premiumCommercializeAvailable = premiumCommercializeAvailable;
	}

	public String getBasicSNSKitProvide() {
		return basicSNSKitProvide;
	}

	public void setBasicSNSKitProvide(String basicSNSKitProvide) {
		this.basicSNSKitProvide = basicSNSKitProvide;
	}

	public String getStandardSNSKitProvide() {
		return standardSNSKitProvide;
	}

	public void setStandardSNSKitProvide(String standardSNSKitProvide) {
		this.standardSNSKitProvide = standardSNSKitProvide;
	}

	public String getPremiumSNSKitProvide() {
		return premiumSNSKitProvide;
	}

	public void setPremiumSNSKitProvide(String premiumSNSKitProvide) {
		this.premiumSNSKitProvide = premiumSNSKitProvide;
	}

	public int getBasicDraftNumber() {
		return basicDraftNumber;
	}

	public void setBasicDraftNumber(int basicDraftNumber) {
		this.basicDraftNumber = basicDraftNumber;
	}

	public int getStandardDraftNumber() {
		return standardDraftNumber;
	}

	public void setStandardDraftNumber(int standardDraftNumber) {
		this.standardDraftNumber = standardDraftNumber;
	}

	public int getPremiumDraftNumber() {
		return premiumDraftNumber;
	}

	public void setPremiumDraftNumber(int premiumDraftNumber) {
		this.premiumDraftNumber = premiumDraftNumber;
	}

	public int getBasicRevisionNumber() {
		return basicRevisionNumber;
	}

	public void setBasicRevisionNumber(int basicRevisionNumber) {
		this.basicRevisionNumber = basicRevisionNumber;
	}

	public int getStandardRevisionNumber() {
		return standardRevisionNumber;
	}

	public void setStandardRevisionNumber(int standardRevisionNumber) {
		this.standardRevisionNumber = standardRevisionNumber;
	}

	public int getPremiumRevisionNumber() {
		return premiumRevisionNumber;
	}

	public void setPremiumRevisionNumber(int premiumRevisionNumber) {
		this.premiumRevisionNumber = premiumRevisionNumber;
	}

	public int getBasicDefaultDeliveryDate() {
		return basicDefaultDeliveryDate;
	}

	public void setBasicDefaultDeliveryDate(int basicDefaultDeliveryDate) {
		this.basicDefaultDeliveryDate = basicDefaultDeliveryDate;
	}

	public int getStandardDefaultDeliveryDate() {
		return standardDefaultDeliveryDate;
	}

	public void setStandardDefaultDeliveryDate(int standardDefaultDeliveryDate) {
		this.standardDefaultDeliveryDate = standardDefaultDeliveryDate;
	}

	public int getPremiumDefaultDeliveryDate() {
		return premiumDefaultDeliveryDate;
	}

	public void setPremiumDefaultDeliveryDate(int premiumDefaultDeliveryDate) {
		this.premiumDefaultDeliveryDate = premiumDefaultDeliveryDate;
	}

	public int getBasicCostomizedDeliveryDate() {
		return basicCostomizedDeliveryDate;
	}

	public void setBasicCostomizedDeliveryDate(int basicCostomizedDeliveryDate) {
		this.basicCostomizedDeliveryDate = basicCostomizedDeliveryDate;
	}

	public int getStandardCostomizedDeliveryDate() {
		return standardCostomizedDeliveryDate;
	}

	public void setStandardCostomizedDeliveryDate(int standardCostomizedDeliveryDate) {
		this.standardCostomizedDeliveryDate = standardCostomizedDeliveryDate;
	}

	public int getPremiumCostomizedDeliveryDate() {
		return premiumCostomizedDeliveryDate;
	}

	public void setPremiumCostomizedDeliveryDate(int premiumCostomizedDeliveryDate) {
		this.premiumCostomizedDeliveryDate = premiumCostomizedDeliveryDate;
	}

	public int getBasicCostomizedDeliveryPrice() {
		return basicCostomizedDeliveryPrice;
	}

	public void setBasicCostomizedDeliveryPrice(int basicCostomizedDeliveryPrice) {
		this.basicCostomizedDeliveryPrice = basicCostomizedDeliveryPrice;
	}

	public int getStandardCostomizedDeliveryPrice() {
		return standardCostomizedDeliveryPrice;
	}

	public void setStandardCostomizedDeliveryPrice(int standardCostomizedDeliveryPrice) {
		this.standardCostomizedDeliveryPrice = standardCostomizedDeliveryPrice;
	}

	public int getPremiumCostomizedDeliveryPrice() {
		return premiumCostomizedDeliveryPrice;
	}

	public void setPremiumCostomizedDeliveryPrice(int premiumCostomizedDeliveryPrice) {
		this.premiumCostomizedDeliveryPrice = premiumCostomizedDeliveryPrice;
	}

	public int getBaicPrice() {
		return baicPrice;
	}

	public void setBaicPrice(int baicPrice) {
		this.baicPrice = baicPrice;
	}

	public int getStandardPrice() {
		return standardPrice;
	}

	public void setStandardPrice(int standardPrice) {
		this.standardPrice = standardPrice;
	}

	public int getPremiumPrice() {
		return premiumPrice;
	}

	public void setPremiumPrice(int premiumPrice) {
		this.premiumPrice = premiumPrice;
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
	
}
