package com.mulcam.hier.dto;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class Criteria {
    /**
     * 페이징 정보
     */
    private PaginationInfo paginationInfo;

    /**
     * 현재 페이지 번호
     */
    private int currentPageNo;

    /**
     * 페이지당 출력할 데이터 개수
     */
    private int recordsPerPage;

    /**
     * 화면 하단에 출력할 페이지 사이즈
     */
    private int pageSize;

    /**
     * 검색 키워드
     */
    private String keyword;

    /**
     * 검색 유형
     */
    private String searchType;

    //정렬방법
    private String sort;

    private String category;

    public Criteria() {
        this.currentPageNo = 1;
        this.recordsPerPage = 12;
        this.pageSize = 5;
        this.sort = "product_id";
        this.category="";
    }

    public String makeQueryString(int pageNo) {

        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .queryParam("sort", sort)
                .queryParam("currentPageNo", pageNo)
                .queryParam("recordsPerPage", recordsPerPage)
                .queryParam("pageSize", pageSize)
//                .queryParam("searchType", searchType)
                .queryParam("keyword", keyword)
                .queryParam("category", category)
                .build()
                .encode();

        return uriComponents.toUriString();
    }

    public String makeQueryString1(String sort1) {
        setCategory(sort1);
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .queryParam("sort", sort)
                .queryParam("currentPageNo", currentPageNo)
                .queryParam("recordsPerPage", recordsPerPage)
                .queryParam("pageSize", pageSize)
//                .queryParam("searchType", searchType)
                .queryParam("keyword", keyword)
                .queryParam("category", sort1)
                .build()
                .encode();

        return uriComponents.toUriString();
    }

    public PaginationInfo getPaginationInfo() {
        return paginationInfo;
    }

    public void setPaginationInfo(PaginationInfo paginationInfo) {
        this.paginationInfo = paginationInfo;
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

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
