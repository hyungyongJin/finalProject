package com.ai.fishdr.vo;

import lombok.Data;

/**
 * 
 * @Class Name : WithdrawalVO.java
 * @Description : 휴약기간 테이블 관련 Value Object
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
public class WithdrawalVO {
	
	private String withdrawal_code;		// 휴악기간코드	// VARCHAR2(10)	// NOT NULL	// PK
	private String withdrawal_period;	// 휴약일수		// VARCHAR2(50)	// NOT NULL
	private String mdcin_code;			// 의약품코드	// VARCHAR2(10)	// NOT NULL	// FK
	private String fish_code;			// 어종코드		// VARCHAR2(10)	// NOT NULL	// FK
	private String withdrawal_status;	// 휴약기간상태	// CHAR(1)		// NULL (y)
	private String fish_name;
	private String mdcin_prduct_name;
	private String rnum;
	
}
