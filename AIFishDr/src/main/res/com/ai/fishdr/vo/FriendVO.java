package com.ai.fishdr.vo;

import lombok.Data;

/**
 * 
 * @Class Name : FriendVO.java
 * @Description : 친구 테이블 관련 Value Object
 * @Modification Information
 * @author 심재형
 * @since  2018. 11. 12.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일            수정자      수정내용
 *    ------------ 		-------     -------------------
 *    2018. 11. 12.     심재형      최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */

@Data
public class FriendVO {
	
	private String fr_no;			// 친구번호		// NUMBER(7)	// NOT NULL			// PK
	private String fr_status;		// 상태			// CHAR(1)		// NULL (y)
	private String mem_id;			// 회원아이디	// VARCHAR2(10)	// NOT NULL			// FK
	private String fr_id;			// 친구아이디	// VARCHAR2(10)	// NOT NULL			// FK
	private String fr_apply_date;	// 친구신청날짜	// DATE			// NULL (sysdate)
	private String fr_accpet_date;	// 친구수락날짜	// DATE			// NULL
	
	private String rnum;
	
}
