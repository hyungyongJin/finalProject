package com.ai.fishdr.vo;

import lombok.Data;

/**
 * 
 * @Class Name : MedicineVO.java
 * @Description : 의약품 테이블 관련 Value Object
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
 *    2018. 11. 13.     조성광      데이터추가(RNUM)
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */

@Data
public class MedicineVO {
	
	private String mdcin_code;			// 의약품코드		// VARCHAR2(10)		// NOT NULL	// PK
	private String mdcin_entrps_name;	// 업체명			// VARCHAR2(100)	// NOT NULL
	private String mdcin_prduct_name;	// 제품명			// VARCHAR2(100)	// NOT NULL
	private String mdcin_atpn;			// 주의사항			// CLOB				// NULL
	private String mdcin_pack;			// 포장단위			// VARCHAR2(100)	// NULL
	private String mdcin_efcy_effect;	// 효능 및 효과		// CLOB				// NULL
	private String mdcin_material;		// 원료 및 성분분량	// CLOB				// NULL
	private String mdcin_status;		// 의약품상태		// CHAR(1)			// NULL (y)
	private String mdcin_hit;			// 의약품조회수		// NUMBER(7)		// NULL (0)
	private String ctgry_code;			// 카테고리코드		// VARCHAR2(10)		// NOT NULL // FK
	private String rnum;
	
}
