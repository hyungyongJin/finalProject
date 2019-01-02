package com.ai.fishdr.vo;

import lombok.Data;

/**
 * 
 * @Class Name : MessageVO.java
 * @Description : 쪽지 테이블 관련 Value Object
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
public class MessageVO {
	
	private String ms_no;			// 쪽지번호		// NUMBER(7)	// NOT NULL				// PK
	private String ms_content;		// 내용			// CLOB(7)		// NULL
	private String ms_send_date;	// 보낸일시		// DATE			// NOT NULL (sysdate)
	private String ms_get_date;		// 받을일시		// DATE			// NOT NULL
	private String ms_status;		// 상태			// CHAR(1)		// NULL (y)
	private String ms_send_id;		// 보내는아이디	// VARCHAR2(10)	// NOT NULL				// FK
	private String me_get_id;		// 받는 아이디	// VARCHAR2(10)	// NOT NULL				// FK
	
}
