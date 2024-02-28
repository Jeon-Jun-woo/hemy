package com.sist.mapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.sist.vo.*;

public interface NgoodsJJimMapper {
	// 찜 저장
	@Insert("INSERT INTO ngoods_jjim(no,userId,gno) "
			+"VALUES(gj_no_seq.nextval,#{userId},#{gno})")
	public void jjimInsert(NgoodsJJimVO vo);
	
	//찜 확인
	@Select("SELECT COUNT(*) FROM ngoods_jjim "
			+"WHERE gno=#{gno} AND userId=#{userId}")
	public int jjimCount(Map map);
	
	
	@Update("UPDATE ngoods_jjim SET "
			+"jjim_ok=1 "
			+"WHERE no=#{no}")
	public void jjimOk(int no);
	
	
	//  찜목록
	@Results({
		@Result(column = "kName",property = "gvo.kName"),
		@Result(column = "poster",property = "gvo.poster")
	}) //조인
	@Select("SELECT no,j.gno,kName,poster "
			+"FROM ngoods_jjim j,goods_nut g "
			+"WHERE j.gno=g.gno "
			+"AND userId=#{userId} "
			+"ORDER BY no DESC")
	public List<NgoodsJJimVO> jjimMypageData(String userId);

	//찜 취소
	
	@Delete("DELETE FROM ngoods_jjim "
			+"WHERE no=#{no}")
	public void jjimCancel(int no);
}
