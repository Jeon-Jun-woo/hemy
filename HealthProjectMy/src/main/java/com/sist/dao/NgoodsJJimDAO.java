package com.sist.dao;
import java.util.*;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;
@Repository
public class NgoodsJJimDAO {
	@Autowired
	private NgoodsJJimMapper mapper;
	
	public void jjimInsert(NgoodsJJimVO vo)
	{
		mapper.jjimInsert(vo);
	}
	
	public int jjimCount(Map map)
	{
		return mapper.jjimCount(map);
	}
	
	public List<NgoodsJJimVO> jjimMypageData(String userId)
	{
		return mapper.jjimMypageData(userId);
	}

	public void jjimCancel(int no)
	{
		mapper.jjimCancel(no);
	}
	
	public void jjimOk(int no)
	{
		mapper.jjimOk(no);
	}
}
