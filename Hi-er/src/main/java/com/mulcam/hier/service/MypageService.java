package com.mulcam.hier.service;

import java.util.List;

import com.mulcam.hier.dto.Orders;

public interface MypageService {
	List<Orders> history(int id) throws Exception;
}
