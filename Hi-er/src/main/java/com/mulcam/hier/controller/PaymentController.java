package com.mulcam.hier.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mulcam.hier.dto.Orders;
import com.mulcam.hier.service.OrderService;

@Controller 
public class PaymentController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	ServletContext servletContext;
	
	@Value("${upload.filepath}")
	private String filepath;
	
	@Value("${upload.filepath.cloud}")
	private boolean iscloud;
	
	@GetMapping("/iamport") public String iamport(){ 
		return "index"; 
	}
	
	@ResponseBody
	@PostMapping("/order") 
	public int order(@ModelAttribute Orders order){ 
		int orderNumber = 0;
		try {
			orderNumber = orderService.makeOrder(order) ;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderNumber; 
	}
	
	@ResponseBody
	@GetMapping("/upload/{filename}")
	public void fileview(@PathVariable String filename, HttpServletResponse response) {
		String saveDir="";
		if(iscloud) {
			saveDir=filepath;
		} else {
			saveDir = servletContext.getRealPath(filepath);
		}
		File file = new File(saveDir+filename);
		FileInputStream fis = null;
		try {
			OutputStream out = response.getOutputStream();
			fis = new FileInputStream(file);
			FileCopyUtils.copy(fis, out);
			out.flush();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch(Exception e) {}
			}
		}
	}
}
