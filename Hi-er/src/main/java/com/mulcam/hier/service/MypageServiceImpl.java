package com.mulcam.hier.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulcam.hier.dao.MypageDAO;
import com.mulcam.hier.dto.FreelancerUser;
import com.mulcam.hier.dto.Orders;
import com.mulcam.hier.dto.Paging;
import com.mulcam.hier.dto.Report;
import com.mulcam.hier.dto.Review;
import com.mulcam.hier.dto.User;

@Service
public class MypageServiceImpl implements MypageService {

	@Autowired
	MypageDAO mypageDAO;
	@Override
	public List<Map<String, Object>> history2(int user_id) throws Exception {
		
		
		List<Map<String, Object>> ord = mypageDAO.queryOrdersss(user_id);
		

		return ord;
	}

	@Override
	public List<Map<String, Object>> history3(int user_id) throws Exception {
		
		
		List<Map<String, Object>> likepost = mypageDAO.queryLikepost(user_id);
		

		return likepost;
	}

	@Override
	public List<Map<String, Object>> getBoardList(int page, Paging pageInfo,int user_id) throws Exception {
		HashMap<String,Integer>map=new HashMap<>();
		int listCount = mypageDAO.countBoard(user_id);

		int lastPage = (int) Math.ceil((double) listCount / 5);
		

		int startPage = (((int) ((double) page / 5 + 0.9)) - 1) * 5 + 1;
		// 현재 페이지에 보여줄 시작 페이지수(1,11,21)

		int endPage = startPage + 5 - 1;
		// 현재 페이지에 보여줄 마지막 페이지수(10,20,30)
		if(lastPage==0)lastPage=1;
		if (endPage > lastPage)
			endPage = lastPage;
		pageInfo.setStartPage(startPage);
		pageInfo.setEndPage(endPage);
		pageInfo.setLastPage(lastPage);
		pageInfo.setNowPage(page);
		// pageInfo.setListCount(listCount);
		int startrow = (page - 1) * 5 + 1;
		map.put("startrow", startrow);
		map.put("user_id", user_id);
		return mypageDAO.selectBoardList(map);

	}

	@Override
	public List<Map<String, Object>> getBoardList2(int page, Paging pageInfo,int user_id) throws Exception {
		HashMap<String,Integer>map=new HashMap<>();
		int listCount = mypageDAO.countBoard2(user_id);
		// 지금은 1로 해놨음 나중에 겟세션아이디로 가능하면 바꿔야함 int
		// listCount=mypageDAO.countBoard(getSessionid??)

		// 내가 가진 게시글 수가 100개라면 반환된 값이 100임 ->listCount=100
		// 총페이지수 올림처리
		int lastPage = (int) Math.ceil((double) listCount / 5);
		// 가정한 리스트카운트가 100이라면 100을 10으로 나누고 더블로 캐스팅 해서 올림을 함
		// 그리고 인트형으로 바꿈 결과적으로 maxPage=10이됨

		int startPage = (((int) ((double) page / 5 + 0.9)) - 1) * 5 + 1;
		// 현재 페이지에 보여줄 시작 페이지수(1,11,21)

		int endPage = startPage + 5 - 1;
		// 현재 페이지에 보여줄 마지막 페이지수(10,20,30)
		if(lastPage==0)lastPage=1;
		if (endPage > lastPage)
			endPage = lastPage;
		pageInfo.setStartPage(startPage);
		pageInfo.setEndPage(endPage);
		pageInfo.setLastPage(lastPage);
		pageInfo.setNowPage(page);
		// pageInfo.setListCount(listCount);
		int startrow = (page - 1) * 5 + 1;
		map.put("startrow", startrow);
		map.put("user_id", user_id);
		return mypageDAO.selectBoardList2(map);

	}

	@Override
	public boolean nickOverlap(String nick) throws Exception {
		if (0 == mypageDAO.queryNick(nick)) {
			return false; // 중복된게 없음
		}
		return true;// 중복된게 있음
	}

	@Override
	public void nickupdate(String nick,int user_id) throws Exception {
		User user = new User();
		user.setNickname(nick);
		user.setUser_id(user_id);/// 수정해야함 겟세션아이디
		mypageDAO.nickupdate(user);

	}

	@Override
	public boolean passfindupdate(String pass, String pass2,int user_id) throws Exception {
		User user = new User();
		user.setPassword(pass);
		user.setUser_id(user_id);/// 수정해야함 겟세션아이디
		if (true == mypageDAO.passfind(user)) {
			user.setPassword(pass2);
			mypageDAO.passupdate(user);
			return true;
		}
		return false;

	}

	@Override
	public boolean introupdate(String intro,int user_id) throws Exception {

		FreelancerUser freelancerUser = new FreelancerUser();
		freelancerUser.setF_id(user_id);
		freelancerUser.setIntroduction(intro);
		try {
			mypageDAO.introupdate(freelancerUser);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addressupdate(String address, String address2,int user_id) {

		FreelancerUser freelancerUser = new FreelancerUser();
		freelancerUser.setF_id(user_id);
		freelancerUser.setAddress(address);
		freelancerUser.setAddress(address2);
		try {
			mypageDAO.locationupdate(freelancerUser);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean reviewWrite(String content, int star_point, int order_id,int user_id) {
		Review review = new Review();
		Orders order = mypageDAO.findorder(order_id);

		review.setReview_wid(user_id);// 내가쓴거임
		review.setProduct_id(order.getProduct_id());
		review.setSeller_id(order.getSeller_id());
		review.setContent(content);
		review.setStar_point(star_point);
		try {
			mypageDAO.insertreview(review);
			mypageDAO.fourToFive(order_id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;// 에러뜨면 펄스 반환
		}
		// 컨텐츠 쓴사람아이디 스타포인트
		// 상품아이디 생성시간 판매자아이디
		return true;// 정상적으로 하면 트루 반환함
	}

	@Override
	public boolean heartremove(int like_id) {
		try {
			mypageDAO.deletelike(like_id);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Map<String, Object> count(int user_id) throws Exception {
		//구매 건수
		int buyOrder=mypageDAO.countBoard(user_id);
		//판매 건수
		int sellOrder=mypageDAO.sellCount(user_id);
		//구매 총가격
		Integer buySumOrder=mypageDAO.buySum(user_id);
		if(buySumOrder==null) {
			buySumOrder=0;
		}
		//판매 총가격
		Integer sellSumOrder=mypageDAO.sellSum(user_id);
		if(sellSumOrder==null) {
			sellSumOrder=0;
		}
		//누른 좋아요 수
		int clickLike=mypageDAO.countBoard2(user_id);
		//눌린 좋아요 수
		int clikedLike=mypageDAO.countLiked(user_id);
	
		
		
		Map<String,Object>map=new HashMap<String,Object>();
		map.put("buyOrder",buyOrder);
		map.put("sellOrder", sellOrder);
		map.put("buySumOrder", buySumOrder);
		map.put("sellSumOrder", sellSumOrder);
		map.put("clickLike", clickLike);
		map.put("clickedLike", clikedLike);

		return map;
	}

	@Override
	public List<Map<String, Object>> report5() throws Exception {
		List<Map<String, Object>> report=mypageDAO.report5();
		
		
		return report;
	}

	@Override
	public List<Map<String, Object>> sortBoardCount(String id) throws Exception {
		
		
		if("sortBoardCount".equals(id)) {
			List<Map<String, Object>> sortBoardCount=mypageDAO.sortBoardCount();
			return sortBoardCount;
		}
		else if("sortPriceTotal".equals(id)) {
			List<Map<String, Object>> sortBoardCount=mypageDAO.sortAllPrice();
			return sortBoardCount;
		}
		else if("sortreported".equals(id)) {
			List<Map<String, Object>> sortBoardCount=mypageDAO.sortReported();
			return sortBoardCount;
		}
		else {
			List<Map<String, Object>> sortBoardCount=mypageDAO.sortLiked();
			return sortBoardCount;
		}
		
		
	}

	@Override
	public void userdelete(int user_id) throws Exception {
	
		
			mypageDAO.userdelete(user_id);
		
	}

	@Override
	public void postdelete(int id) throws Exception {
		mypageDAO.postdelete(id);
		
	}

	@Override
	public void updatestatus1(int id, int num) throws Exception {
		try {
			if (num == 1) {
				mypageDAO.zeroToOne(id);
			} else if (num == 2) {
				mypageDAO.oneToTwo(id);
			} else if (num == 3) {
				mypageDAO.twoToThree(id);
			} else if (num == 4) {
				mypageDAO.threeToFour(id);
			} else if(num==6) {
				mypageDAO.oneToSix(id);
			} else if(num==7) {
				mypageDAO.oneToSeven(id);
			} else if(num==8) {
				mypageDAO.oneToEight(id);
			}
			
			
			
			else if(num==9) {
				mypageDAO.sevenToNine(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Map<String, Object>> trade() throws Exception {
		List<Map<String, Object>> trade=mypageDAO.trade();
		return trade;
	}

	@Override
	public List<Map<String, Object>> allTrade() throws Exception {
		List<Map<String, Object>> trade=mypageDAO.allTrade();
		return trade;
	}

	@Override
	public void postwarning(int id) throws Exception {//리포트 아이디로 리포트를 찾아서 유저에게 경고 메세지 인서트
		User user = new User();
		HashMap<String,Object>map=new HashMap<>();

		map = (HashMap<String, Object>) mypageDAO.findreport(id);


		mypageDAO.postwarning(map);

	}

	@Override
	public List<Map<String, Object>> warningMsg(int user_id) throws Exception {
		List<Map<String, Object>> warning=mypageDAO.findWarningMsg(user_id);
		return warning;
	}
	
	
	
	
	
	public void profileUpdate(String profile_image, int user_id) throws Exception {
		User user = new User();
		user.setProfile_image(profile_image);
		user.setUser_id(user_id);/// 
		mypageDAO.profileUpdate(user);

	}
	
	
	
	

}
