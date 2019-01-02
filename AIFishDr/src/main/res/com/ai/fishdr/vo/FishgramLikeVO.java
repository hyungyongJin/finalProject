package com.ai.fishdr.vo;

import lombok.Data;

/**
 * 
 * @Class Name : FishgramLikeVO.java
 * @Description : 피쉬그램 좋아요 테이블 관련 Value Object
 * @Modification Information
 * @author 심재형
 * @since  2018. 11. 27.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일            수정자      수정내용
 *    ------------ 		-------     -------------------
 *    2018. 11. 27.     심재형      최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */

@Data
public class FishgramLikeVO {
	
	private String like_code;			// 좋아요코드		// VARCHAR2(15) // NOT NULL			// PK
	private String like_status;			// 상태				// CHAR(1)		// NULL (y)
	private String mem_id;				// 아이디			// VARCHAR2(10)	// NOT NULL			// FK
	private String bo_no;				// 게시글번호		// NUMBER(7)	// NOT NULL			// FK
	
	private String rnum;
	
}
