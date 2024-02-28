package com.sist.web;

import java.util.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MypageController {
	@GetMapping("mypage/mypage_main1.do")
	public String mypage_main()
	{
		return "mypage/mypage_main1";
	}
	
	
	@GetMapping("member/update.do")
    public String member_update()
    {
    	return "member/update";
    }
}
