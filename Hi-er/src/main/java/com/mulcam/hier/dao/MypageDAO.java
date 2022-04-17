package com.mulcam.hier.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mulcam.hier.dto.FreelancerUser;
import com.mulcam.hier.dto.Orders;
import com.mulcam.hier.dto.Report;
import com.mulcam.hier.dto.Review;
import com.mulcam.hier.dto.User;

@Mapper
@Repository
public interface MypageDAO {
//	public List<Orders> queryOrders(int id)throws Exception;
//	public List<Map<String,Object>> queryOrderss(int id)throws Exception;
	public List<Map<String,Object>> queryOrdersss(int id)throws Exception;
	public List<Map<String,Object>> queryLikepost(int id)throws Exception;
	public int countBoard(int id)throws Exception;
	public int countBoard2(int id)throws Exception;
	public int sellCount(int id)throws Exception;
	public Integer buySum(int user_id);
	public Integer sellSum(int user_id);
	public int countLiked(int user_id);
	
	public List<Map<String,Object>> selectBoardList(HashMap<String, Integer> map) throws Exception;
	public List<Map<String,Object>> selectBoardList2(HashMap<String, Integer> map) throws Exception;
	public int queryNick(String nick)throws Exception;
	public void nickupdate(User user)throws Exception;
	public void profileUpdate(User user)throws Exception;
	public boolean passfind(User user)throws Exception;
	public boolean passupdate(User user)throws Exception;
	public boolean introupdate(FreelancerUser freelancerUser);
	public boolean locationupdate(FreelancerUser freelancerUser);
	public Orders findorder(int order_id);
	public void insertreview(Review review);
	public void deletelike(int like_id);
	public List<Map<String,Object>> report5()throws Exception;
	public List<Map<String,Object>> sortBoardCount()throws Exception;
	public List<Map<String,Object>> sortAllPrice()throws Exception;
	public List<Map<String,Object>> sortReported()throws Exception;
	public List<Map<String,Object>> sortLiked()throws Exception;
	public void userdelete(int user_id)throws Exception;
	public void postdelete(int id)throws Exception;
	public void zeroToOne(int id)throws Exception;
	public void oneToTwo(int id)throws Exception;
	public void twoToThree(int id)throws Exception;
	public void threeToFour(int id)throws Exception;
	public void oneToSix(int id) throws Exception;
	public void oneToSeven(int id)throws Exception;
	public void sevenToNine(int id)throws Exception;
	public void fourToFive(int id)throws Exception;
	public void oneToEight(int id)throws Exception;
	public List<Map<String, Object>> trade()throws Exception;
	public List<Map<String, Object>> allTrade()throws Exception;
	public void postwarning(Map<String, Object> map) throws Exception;
	public Map<String,Object> findreport(int id) throws Exception;
	public List<Map<String,Object>> findWarningMsg(int user_id);
	
	
	
	
	
	
}
