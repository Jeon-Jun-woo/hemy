package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.sist.service.ReserveyService;

@Controller
public class ReserveyController {
	@Autowired
	private ReserveyService rService;
	
	@GetMapping("goods/goods_reserve.do")
	public String goods_reserve()
	{
		return "goods/goods_reserve";
	}
	
	@GetMapping("mypage/mypage.do")
	public String mypage_main()
	{
		return "mypage/mypage_main";
	}
	
	@GetMapping("adminpage/admin.do")
	public String adminpage_main()
	{
		return "adminpage/admin_main";
	}
	
	
	
	
	
}
