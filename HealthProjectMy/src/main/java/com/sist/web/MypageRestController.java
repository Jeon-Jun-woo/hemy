package com.sist.web;

import java.util.*;

import javax.servlet.http.HttpSession;

import com.sist.vo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MypageRestController {
	@Autowired
	private MemberService mService;
	
	@GetMapping(value = "member/update_vue.do", produces = "text/plain;charset=UTF-8")
	public String member_update(String userId) throws Exception
	{
		MemberVO vo=mService.memberUpdateData(userId);
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(vo);
		
		return json;
	}
	@PostMapping(value="member/update_ok_vue.do",produces = "text/plain;charset=UTF-8")
	public String member_update_ok(MemberVO vo)
	{
		   String result=mService.memberUpdate(vo);
		   return result;
	}
	
}
