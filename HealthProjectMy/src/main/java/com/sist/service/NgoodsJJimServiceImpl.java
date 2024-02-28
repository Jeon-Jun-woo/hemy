package com.sist.service;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sist.vo.*;
import com.sist.dao.*;
@Service
public class NgoodsJJimServiceImpl implements NgoodsJJimService{
	@Autowired
	private NgoodsJJimDAO dao;

	@Override
	public void jjimInsert(NgoodsJJimVO vo) {
		// TODO Auto-generated method stub
		dao.jjimInsert(vo);
	}

	@Override
	public int jjimCount(Map map) {
		// TODO Auto-generated method stub
		return dao.jjimCount(map);
	}

	@Override
	public List<NgoodsJJimVO> jjimMypageData(String userId) {
		// TODO Auto-generated method stub
		return dao.jjimMypageData(userId);
	}

	@Override
	public void jjimCancel(int no) {
		// TODO Auto-generated method stub
		dao.jjimCancel(no);
	}

	@Override
	public void jjimOk(int no) {
		// TODO Auto-generated method stub
		dao.jjimOk(no);
	}
	
	
	
}
