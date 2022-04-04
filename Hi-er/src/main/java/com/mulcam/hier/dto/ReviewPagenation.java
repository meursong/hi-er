package com.mulcam.hier.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ReviewPagenation {
	
	private int currentPageNo; //현제 페이지
	private int recordsPerPage; //페이지당 풀력 개수
	private int pageSize; //화면 하단에 출력할 페이지 사이즈 
	
	public ReviewPagenation() {
		this.currentPageNo = 1;
		this.recordsPerPage = 5;
		this.pageSize = 5;
	}
	
	public int getStartPage() {
		return (currentPageNo - 1) * recordsPerPage;
	}

	
	

}
