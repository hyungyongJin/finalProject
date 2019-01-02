package com.ai.fishdr.vo;

import lombok.Data;

/**
 * 
 * @Class Name : MessageVO.java
 * @Description : 알림 카테고리 테이블 관련 Value Object
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
public class NotiCategoryVO {
	
	private String ctgry_code;		// 카테고리코드	// VARCHAR2(10)	// NOT NULL	// PK
	private String ctgry_name;		// 카테고리명	// VARCHAR2(50)	// NOT NULL
	private String ctgry_status;	// 카테고리상태	// CHAR(1)		// NULL (y)
	
}
