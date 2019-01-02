package com.ai.fishdr.vo;

import lombok.Data;

/**
 * 
 * @Class Name : PrescriptionVO.java
 * @Description : 알림 테이블 관련 Value Object
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
public class NotificationVO {
	
	private String ntcn_code;		// 알림코드		// VARCHAR2(10)	// NOT NULL	// PK
	private String ntcn_content;	// 알림내용		// CLOB			// NULL
	private String ntcn_status;		// 상태			// CHAR(1)		// NULL
	private String ntcn_send_date;	// 보낸일시		// DATE			// NOT NULL
	private String ntcn_get_date;	// 받은일시		// DATE			// NOT NULL
	private String ntcn_send_id;	// 보내는아이디	// VARCHAR2(10)	// NOT NULL	// FK
	private String ntcn_get_id;		// 받는아이디	// VARCHAR2(10)	// NOT NULL	// FK
	private String ctgry_code;		// 카테고리코드	// VARCHAR2(10)	// NOT NULL	// FK
	
}
