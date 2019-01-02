package com.ai.fishdr.vo;

import lombok.Data;

/**
 * 
 * @Class Name : FishgramCommentVO.java
 * @Description : 피쉬그램 댓글 테이블 관련 Value Object
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
public class FishgramCommentVO {
	
	private String comment_no;			// 댓글글번호		// NUMBER(7)	// NOT NULL			// PK
	private String comment_status;		// 상태				// CHAR(1)		// NULL (y)
	private String comment_content;		// 내용				// CLOB			// NULL
	private String comment_reg_date;	// 등록일			// DATE			// NULL (sysdate)
	private String board_code;			// 게시판고유코드	// VARCHAR2(10)	// NOT NULL			// FK
	private String bo_no;				// 게시글번호		// NUMBER(7)	// NOT NULL			// FK
	private String mem_id;				// 아이디			// VARCHAR2(10)	// NOT NULL			// FK
	
	private String rnum;
	
}
