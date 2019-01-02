package com.ai.fishdr.vo;

import lombok.Data;

/**
 * 
 * @Class Name : DiseaseVO.java
 * @Description : 질병 테이블 관련 Value Object
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
 *    2018. 11. 15.     조성광      데이터 추가
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */

@Data
public class DiseaseVO {
	
	private String diss_code;	// 질병코드 // VARCHAR2(10)	// NOT NULL	// PK
	private String diss_name; 	// 질병명	// VARCHAR2(50)	// NOT NULL
	private String diss_status;	// 질병상태	// CHAR(1)		// NULL (y)
	private String rnum;
	
}
