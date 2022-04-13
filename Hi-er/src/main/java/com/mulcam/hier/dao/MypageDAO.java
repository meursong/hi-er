package com.mulcam.hier.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.mulcam.hier.dto.FreelancerUser;
import com.mulcam.hier.dto.Orders;
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
	public List<Map<String,Object>> selectBoardList(HashMap<String, Integer> map) throws Exception;
	public List<Map<String,Object>> selectBoardList2(HashMap<String, Integer> map) throws Exception;
	public int queryNick(String nick)throws Exception;
	public void nickupdate(User user)throws Exception;
	public boolean passfind(User user)throws Exception;
	public boolean passupdate(User user)throws Exception;
	public boolean introupdate(FreelancerUser freelancerUser);
	public boolean locationupdate(FreelancerUser freelancerUser);
	public Orders findorder(int order_id);
	public void insertreview(Review review);
	public void deletelike(int like_id);
}
