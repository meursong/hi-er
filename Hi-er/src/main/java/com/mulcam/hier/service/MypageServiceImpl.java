package com.mulcam.hier.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mulcam.hier.dao.MypageDAO;
import com.mulcam.hier.dto.Orders;

@Service
public class MypageServiceImpl implements MypageService {

	@Autowired
	MypageDAO mypageDAO;
	
	@Override
	public List<Orders> history(int id) throws Exception {
		System.out.println("서비스임플 안이다다다다다다");
		//아이디로 찾아서 orderdto에 넣음
		List<Orders> ord= mypageDAO.queryOrders(id);
		System.out.println("ord찍기 바로전");
		System.out.println(ord);
		
		return ord;
	}

}
