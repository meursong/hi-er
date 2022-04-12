package com.mulcam.hier.service;

import java.util.List;
import java.util.Map;

import com.mulcam.hier.dto.Paging;

public interface MypageService {
//	List<Orders> history(int id) throws Exception;
//	List<Map<String,Object>> history1(int id)throws Exception;
	List<Map<String,Object>> history2(int id)throws Exception;
	List<Map<String,Object>> history3(int id)throws Exception;
	List<Map<String,Object>> getBoardList(int page, Paging pageInfo) throws Exception;
	List<Map<String,Object>> getBoardList2(int page, Paging pageInfo) throws Exception;
	boolean nickOverlap(String nick) throws Exception;
	void nickupdate(String nick) throws Exception;
	boolean passfindupdate(String pass,String pass2) throws Exception;
	boolean introupdate(String intro) throws Exception;
	boolean addressupdate(String address, String address2);
	boolean reviewWrite(String content, int star_point,int order_id);
}