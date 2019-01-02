package com.ai.fishdr.vo;

import lombok.Data;

/**
 * 
 * @Class Name : MemberVO.java
 * @Description : 회원 테이블 관련 Value Object
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
public class MemberVO {
	
	private String mem_id;			// 아이디				// VARCHAR2(10)		// NOT NULL			// PK
	private String mem_name;		// 회원이름				// VARCHAR2(50)		// NOT NULL
	private String mem_pwd;			// 회원비밀번호			// VARCHAR2(50)		// NOT NULL
	private String mem_phone;		// 회원전화번호			// VARCHAR2(50)		// NULL
	private String mem_mail;		// 회원이메일			// VARCHAR2(100)	// NULL
	private String mem_nickname;	// 회원닉네임			// VARCHAR2(100)	// NULL
	private String mem_reg_date;	// 회원가입일			// DATE				// NULL (sysdate)
	private String mem_position;	// 회원직위				// VARCHAR2(30)		// NULL (mem)
	private String mem_sttemnt_hit;	// 회원경고회수			// NUMBER(7)		// NULL (0)
	private String mem_status;		// 회원상태				// CHAR(1)			// NULL (y)
	private String conect_way;		// 접속방법				// VARCHAR2(30)		// NULL (n)
	private String conect_status;	// 접속여부				// CHAR(1)			// NULL (n)
	private String profile_status;	// 프로필사진등록여부	// CHAR(1)			// NULL (n)
	
	private String rnum;
	
}
