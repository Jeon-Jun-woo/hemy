package com.sist.vo;

import lombok.Data;

@Data
public class NgoodsJJimVO {
	private int no,gno,jjim_ok;
	private String userId;
	private NgoodsVO gvo=new NgoodsVO();
}
