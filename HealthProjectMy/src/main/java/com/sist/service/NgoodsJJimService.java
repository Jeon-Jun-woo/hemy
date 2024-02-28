package com.sist.service;
import com.sist.vo.*;
import java.util.*;
public interface NgoodsJJimService {
	public void jjimInsert(NgoodsJJimVO vo);
	public int jjimCount(Map map);
	public List<NgoodsJJimVO> jjimMypageData(String userId);
	public void jjimCancel(int no);
	public void jjimOk(int no);
}
