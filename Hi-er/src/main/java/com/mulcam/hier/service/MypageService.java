package com.mulcam.hier.service;

import java.util.List;
import java.util.Map;

import com.mulcam.hier.dto.Paging;
import com.mulcam.hier.dto.User;

public interface MypageService {
	List<Map<String,Object>> history2(int user_id)throws Exception;
	List<Map<String,Object>> history3(int user_id)throws Exception;
	List<Map<String,Object>> getBoardList(int page, Paging pageInfo,int user_id) throws Exception;
	List<Map<String,Object>> getBoardList2(int page, Paging pageInfo,int user_id) throws Exception;
	Map<String,Object> count(int user_id) throws Exception;
	boolean nickOverlap(String nick) throws Exception;
	void nickupdate(String nick,int user_id) throws Exception;
	boolean passfindupdate(String pass,String pass2,int user_id) throws Exception;
	boolean introupdate(String intro,int user_id) throws Exception;
	boolean addressupdate(String address, String address2,int user_id);
	boolean reviewWrite(String content, int star_point,int order_id,int user_id);
	
	boolean heartremove(int like_id);
	List<Map<String, Object>> report5() throws Exception;
	List<Map<String,Object>> sortBoardCount(String id) throws Exception;
	void userdelete(int user_id) throws Exception;
	void postdelete(int id) throws Exception;
	
	void updatestatus1(int id, int num)throws Exception;
	List<Map<String, Object>> trade()throws Exception;
	List<Map<String, Object>> allTrade()throws Exception;
	void postwarning(int id)throws Exception;
	List<Map<String, Object>> warningMsg(int user_id)throws Exception;
}