package com.ai.fishdr.vo;

import lombok.Data;

/**
 * 
 * @Class Name : SymptmsDissVO.java
 * @Description : 증상 및 질병 테이블 관련 Value Object
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
 *    2018. 11. 17.     조성광      데이터 추가
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */

@Data
public class SymptmsDissVO {
	
	private String sd_code;
	private String symptms_code;	// 증상코드	// VARCHAR2(10)	// NOT NULL	// FK
	private String diss_code;		// 질병코드	// VARCHAR2(10)	// NOT NULL	// FK
	private String symptms_content;
	private String diss_name;
	private String rnum;
	
}
