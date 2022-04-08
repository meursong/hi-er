package com.mulcam.hier.dto;

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

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public int getRecordsPerPage() {
		return recordsPerPage;
	}

	public void setRecordsPerPage(int recordsPerPage) {
		this.recordsPerPage = recordsPerPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	
	

}
