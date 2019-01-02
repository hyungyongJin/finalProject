package com.ai.fishdr.vo;

import lombok.Data;

/**
 * 
 * @Class Name : BoardManageVO.java
 * @Description : 게시판 관리 테이블 관련 Value Object
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
public class BoardManageVO {
	
	private String board_code;		// 게시판고유코드	// VARCHAR2(10)		// NOT NULL		// PK
	private String board_name;		// 게시판명			// VARCHAR2(100)	// NOT NULL
	private String board_eng_name;	// 게시판영문명		// VARCHAR2(100)	// NOT NULL
	private String board_function;	// 기능				// NUMBER(5)		// NOT NULL (0)
	private String board_status;	// 상태				// CHAR(1)			// NOT NULL (y)
	private String board_function2;	// 상태				// CHAR(1)			// NOT NULL (y)
	
}
