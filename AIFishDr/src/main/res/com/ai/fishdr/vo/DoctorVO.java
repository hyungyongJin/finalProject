package com.ai.fishdr.vo;

import lombok.Data;

/**
 * 
 * @Class Name : DoctorVO.java
 * @Description : AI 의사 테이블 관련 Value Object
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
public class DoctorVO {
	
	private String treat_code;		// 진료코드		// VARCHAR2(20)	// NOT NULL				// PK
	private String fish_name;		// 어종			// VARCHAR2(50)	// NOT NULL
	private String fish_weight;		// 중량			// NUMBER(7)	// NULL
	private String fish_number;		// 마리수		// NUMBER(10)	// NULL
	private String treat_reg_date;	// 진료받은날짜	// DATE			// NOT NULL (sysdate)
	private String mem_id;			// 아이디		// VARCHAR2(10)	// NOT NULL				// FK
	private String treat_status;	// 상태			// CHAR(1)		// NULL (y)
	
}
