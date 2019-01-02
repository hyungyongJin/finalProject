package com.ai.fishdr.vo;

import lombok.Data;

/**
 * 
 * @Class Name : CapacityUsageVO.java
 * @Description : 용법 및 용량 테이블 관련 Value Object
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
public class CapacityUsageVO {
	
	private String uscp_code;		// 용법 및 용량 코드	// VARCHAR2(10)	// NOT NULL	// PK
	private String uscp_content;	// 내용					// CLOB			// NOT NULL
	private String mdcin_code;		// 의약품코드			// VARCHAR2(10)	// NOT NULL	// FK
	private String fish_code;		// 어종코드				// VARCHAR2(10)	// NOT NULL	// FK
	private String uscp_status;		// 상태					// CHAR(1)		// NULL (y)
	private String fish_name;
	private String mdcin_prduct_name;
	private String rnum;
	
}
