package com.ai.fishdr.vo;

import lombok.Data;

/**
 * 
 * @Class Name : SymptomsVO.java
 * @Description : 증상 테이블 관련 Value Object
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
 *    2018. 11. 15.     조성광      데이터추가
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */

@Data
public class SymptomsVO {
	
	private String symptms_code;	// 증상코드	// VARCHAR2(10)	// NOT NULL	// PK
	private String symptms_content;	// 증상		// CLOB			// NOT NULL
	private String symptms_status;	// 증상상태	// CHAR(1)		// NULL (y)
	private String rnum;
}
