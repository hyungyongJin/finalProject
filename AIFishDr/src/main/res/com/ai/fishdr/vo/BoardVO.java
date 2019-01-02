package com.ai.fishdr.vo;

import java.util.List;

import lombok.Data;

/**
 * 
 * @Class Name : BoardVO.java
 * @Description : 게시판 테이블 관련 Value Object
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
public class BoardVO {
	
	private String bo_no;			// 게시글번호 		// NUMBER(7)		// NOT NULL			// PK
	private String board_code;		// 게시판고유코드 	// VARCHAR2(10)		// NOT NULL			// PK
	private String bo_title;		// 게시글제목		// VARCHAR2(100)	// NOT NULL
	private String bo_nickname;		// 게시글닉네임		// VARCHAR2(100)	// NOT NULL
	private String bo_pwd;			// 게시글비밀번호	// VARCHAR2(20)		// NULL
	private String bo_good_hit;		// 게시블좋아요횟수	// NUMBER(20)		// NULL (0)
	private String bo_content;		// 게시글내용		// CLOB				// NULL
	private String bo_hit;			// 게시글조회		// NUMBER(5)		// NULL (0)
	private String bo_reg_date;		// 게시글등록일		// DATE				// NULL (sysdate)
	private String bo_status;		// 게시글상태		// CHAR(1)			// NULL (y)
	private String bo_sttemnt_hit;	// 게시글신고횟수	// NUMBER(20)		// NULL
	private String bo_writer;		// 게시글저자		// VARCHAR2(10)		// NOT NULL			// FK
	private List<BoardFileVO> items; //게시글 연결파일
	private String mem_nickname;
	private String file_save_name;
	private String board_name;
}
