package com.sist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import javax.servlet.http.HttpSession;

import com.sist.vo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.mapper.NgoodsMapper;
import com.sist.service.*;
@RestController
public class NgoodsJJimRestController {
	@Autowired
	private NgoodsJJimService service;
	
	@PostMapping(value = "goods/jjim.do",produces = "text/plain;charset=UTF-8")
	public String jjim_ok(NgoodsJJimVO vo,HttpSession session) throws Exception
	{
		String result="no";
		try {
			vo.setUserId((String)session.getAttribute("userId"));
			/*System.out.println("fno:"+vo.getFno());
			System.out.println("date:"+vo.getRDate());
			System.out.println("time:"+vo.getRTime());
			System.out.println("inwon:"+vo.getRInwon());
			System.out.println("userId: "+vo.getUserId());*/
			service.jjimInsert(vo);
			service.jjimOk(vo.getNo());
			result="yes";
		}catch(Exception ex) 
		{
			result="no";
		}
		Map map=new HashMap();
		map.put("result", result);
		map.put("jjim_count",vo.getJjim_ok());
		ObjectMapper mapper=new ObjectMapper();
		String json=mapper.writeValueAsString(map);
		return json;
	}
}
