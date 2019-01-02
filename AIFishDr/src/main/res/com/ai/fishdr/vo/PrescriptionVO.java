package com.ai.fishdr.vo;

import lombok.Data;

/**
 * 
 * @Class Name : NotificationVO.java
 * @Description : 처방전 테이블 관련 Value Object
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
public class PrescriptionVO {
	
	private String prscrptn_code;			// 처방전코드	// VARCHAR2(10)		// NOT NULL				// PK 
	private String prscrptn_name;			// 처장전명		// VARCHAR2(50)		// NOT NULL
	private String prscrptn_content_type;	// 처방전확장자	// VARCHAR2(50)		// NOT NULL
	private String prscrptn_ex_hit;			// 출력횟수		// NUMBER(7)		// NULL
	private String prscrptn_status;			// 처방전상태	// CHAR(1)			// NULL (y)
	private String prscrptn_reg_date;		// 처방받은날짜	// DATE				// NOT NULL (sysdate)
	private String mem_id;					// 아이디		// VARCHAR2(10)		// NOT NULL				// FK
	private String hospital_code;			// 관리원코드
	
	private String rnum;
}
