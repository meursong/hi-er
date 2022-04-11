package com.mulcam.hier.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulcam.hier.dao.MypageDAO;
import com.mulcam.hier.dto.FreelancerUser;
import com.mulcam.hier.dto.Paging;
import com.mulcam.hier.dto.User;

@Service
public class MypageServiceImpl implements MypageService {

	@Autowired
	MypageDAO mypageDAO;
	
//	@Override
//	public List<Orders> history(int id) throws Exception {
//		System.out.println("서비스임플 안이다다다다다다");
//		//아이디로 찾아서 orderdto에 넣음
//		List<Orders> ord= mypageDAO.queryOrders(id);
//		System.out.println("ord찍기 바로전");
//		System.out.println(ord);
//		
//		return ord;
//	}
//	
//	@Override
//	public List<Map<String,Object>> history1(int id) throws Exception {
//		System.out.println("서비스임플 안이다다다다다다");
//		//아이디로 찾아서 orderdto에 넣음
//		List<Map<String,Object>> ord= mypageDAO.queryOrderss(id);
//		System.out.println("ord찍기 바로전");
//		System.out.println(ord);
//		
//		return ord;
//	}
	
	@Override
	public List<Map<String,Object>> history2(int id) throws Exception {
		System.out.println("서비스임플 안이다다다다다다");
		//아이디로 찾아서 orderdto에 넣음
		List<Map<String,Object>> ord= mypageDAO.queryOrdersss(id);
		System.out.println("ord찍기 바로전");
		System.out.println(ord);
		
		return ord;
	}
	
	@Override
	public List<Map<String,Object>> history3(int id) throws Exception {
		System.out.println("서비스임플 안이다다다다다다");
		//아이디로 찾아서 orderdto에 넣음
		List<Map<String,Object>> likepost= mypageDAO.queryLikepost(id);
		System.out.println("ord찍기 바로전");
		//System.out.println(ord);
		
		return likepost;
	}
	
	
	@Override
	public List<Map<String,Object>> getBoardList(int page, Paging pageInfo) throws Exception {
		
		int listCount=mypageDAO.countBoard(1);
		
		//내가 가진 게시글 수가 100개라면 반환된 값이 100임 ->listCount=100
		//총페이지수 올림처리
		int lastPage=(int)Math.ceil((double)listCount/5);
		//가정한 리스트카운트가 100이라면 100을 10으로 나누고 더블로 캐스팅 해서 올림을 함
		//그리고 인트형으로 바꿈 결과적으로 maxPage=10이됨
		
		int startPage=(((int)((double)page/5+0.9))-1)*5+1;
		//현재 페이지에 보여줄 시작 페이지수(1,11,21)
		
		int endPage=startPage+5-1;
		//현재 페이지에 보여줄 마지막 페이지수(10,20,30)
		
		if(endPage>lastPage)endPage=lastPage;
		pageInfo.setStartPage(startPage);
		pageInfo.setEndPage(endPage);
		pageInfo.setLastPage(lastPage);
		pageInfo.setNowPage(page);
		//pageInfo.setListCount(listCount);
		int startrow=(page-1)*5+1;
		return mypageDAO.selectBoardList(startrow);
		
	}
	
	@Override
	public List<Map<String,Object>> getBoardList2(int page, Paging pageInfo) throws Exception {
		
		int listCount=mypageDAO.countBoard2(1);
		//지금은 1로 해놨음 나중에 겟세션아이디로 가능하면 바꿔야함 int listCount=mypageDAO.countBoard(getSessionid??)
		
		//내가 가진 게시글 수가 100개라면 반환된 값이 100임 ->listCount=100
		//총페이지수 올림처리
		int lastPage=(int)Math.ceil((double)listCount/5);
		//가정한 리스트카운트가 100이라면 100을 10으로 나누고 더블로 캐스팅 해서 올림을 함
		//그리고 인트형으로 바꿈 결과적으로 maxPage=10이됨
		
		int startPage=(((int)((double)page/5+0.9))-1)*5+1;
		//현재 페이지에 보여줄 시작 페이지수(1,11,21)
		
		int endPage=startPage+5-1;
		//현재 페이지에 보여줄 마지막 페이지수(10,20,30)
		
		if(endPage>lastPage)endPage=lastPage;
		pageInfo.setStartPage(startPage);
		pageInfo.setEndPage(endPage);
		pageInfo.setLastPage(lastPage);
		pageInfo.setNowPage(page);
		//pageInfo.setListCount(listCount);
		int startrow=(page-1)*5+1;
		return mypageDAO.selectBoardList2(startrow);
		
	}
	
	@Override
	public boolean nickOverlap(String nick)throws Exception{
		if(0==mypageDAO.queryNick(nick)) {
			return false; //중복된게 없음
		}
		return true;//중복된게 있음 
	}
	
	@Override
	public void nickupdate(String nick)throws Exception{
		User user=new User();
		user.setNickname(nick);
		user.setUser_id(1);///수정해야함 겟세션아이디
		mypageDAO.nickupdate(user);
		
		
		
	}
	
	@Override
	public boolean passfindupdate(String pass,String pass2)throws Exception{
		User user=new User();
		user.setPassword(pass);
		user.setUser_id(1);///수정해야함 겟세션아이디
		if(true==mypageDAO.passfind(user)) {
			user.setPassword(pass2);
			mypageDAO.passupdate(user);
			return true;
		}
		return false;
		
		
		
		
	}

	@Override
	public boolean introupdate(String intro) throws Exception {
		
	
		FreelancerUser freelancerUser=new FreelancerUser();
		freelancerUser.setF_id(1);
		freelancerUser.setIntroduction(intro);
		try {
		mypageDAO.introupdate(freelancerUser);
		return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean addressupdate(String address, String address2) {
		
		FreelancerUser freelancerUser=new FreelancerUser();
		freelancerUser.setF_id(1);
		freelancerUser.setAddress(address);
		freelancerUser.setAddress(address2);
		try {
			mypageDAO.locationupdate(freelancerUser);
			return true;
			}catch(Exception e) {
				e.printStackTrace();
				return false;
			}
	
	}
	
	
	

}
