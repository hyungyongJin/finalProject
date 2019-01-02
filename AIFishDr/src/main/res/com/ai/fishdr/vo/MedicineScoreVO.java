package com.ai.fishdr.vo;

import lombok.Data;

/**
 * 
 * @Class Name : MedicineCategoryVO.java
 * @Description : 의약품점수 테이블 관련 Value Object
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
public class MedicineScoreVO {
	
	private String mdcin_no;		// 의약품번호	// NUMBER(7)	// NOT NULL	// PK
	private String mdcin_score;		// 의약품점수	// NUMBER(10)	// NULL
	private String mdcin_code;		// 의약품코드	// VARCHAR2(10)	// NOT NULL	// FK
	private String mem_id;			// 아이디		// VARCHAR2(10)	// NOT NULL	// FK
	private String mdcin_status;	// 상태			// CHAR(1)		// NULL (y)
	
}
