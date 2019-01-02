package com.ai.fishdr.vo;

import lombok.Data;

/**
 * 
 * @Class Name : HospitalVO.java
 * @Description : 수산질병관리원 테이블 관련 Value Object
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
public class HospitalVO {
	
	private String hospital_code;		// 관리원명	// VARCHAR2(100)	// NOT NULL	// PK
	private String hospital_name;		// 관리원명	// VARCHAR2(100)	// NOT NULL	// PK
	private String hospital_addr;		// 주소		// CLOB				// NOT NULL
	private String hospital_phone;		// 번호		// VARCHAR2(50)		// NOT NULL
	private String hospital_fax;		// 팩스		// VARCHAR2(50)		// NULL
	private String hospital_mail;		// 이메일	// VARCHAR2(40)		// NULL
	private String hospital_dr_name;	// 원장명	// VARCHAR2(50)		// NOT NULL
	private String hospital_agp_code;	// 서명코드	// VARCHAR2(100)	// NOT NULL
	private String hospital_license;	// 면허번호	// VARCHAR2(100)	// NOT NULL
	private String hospital_status;		// 상태		// CHAR(1)			// NULL (y)
	
}
