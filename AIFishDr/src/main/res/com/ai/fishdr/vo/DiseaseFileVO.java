package com.ai.fishdr.vo;

import lombok.Data;

/**
 * 
 * @Class Name : DiseaseFileVO.java
 * @Description : 질병 파일 테이블 관련 Value Object
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
public class DiseaseFileVO {
	
	private String file_no;				// 파일번호		// NUMBER(7)		// NOT NULL	// PK
	private String file_name;			// 파일명		// VARCHAR2(100)	// NOT NULL
	private String file_save_name;		// 파일저장명	// VARCHAR2(100)	// NOT NULL
	private String file_content_type;	// 파일확장자	// VARCHAR2(50)		// NOT NULL
	private String file_status;			// 파일상태		// CHAR(1)			// NULL (y)
	private String diss_code;			// 질병코드		// VARCHAR2(10)		// NOT NULL	// FK
	
}
