package com.ai.fishdr.vo;

import lombok.Data;

/**
 * 
 * @Class Name : SecessionVO.java
 * @Description : 탈퇴사유 테이블 관련 Value Object
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
public class SecessionVO {
	
	private String secsn_no;		// 탈퇴번호	// NUMBER(7)	// NOT NULL	// PK
	private String secsn_reason;	// 탈퇴사유	// CLOB			// NULL
	private String mem_id;			// 아이디	// VARCHAR2(10)	// NOT NULL	// FK
	
}
