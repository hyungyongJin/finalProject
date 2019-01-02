package com.ai.fishdr.vo;

import lombok.Data;

/**
 * 
 * @Class Name : StatsVO.java
 * @Description : 통계 테이블 관련 Value Object
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
public class StatsVO {
	
	private String conect_time;			// 접속시간	// DATE			// NOT NULL	// PK
	private String conect_ip;			// 접속IP	// VARCHAR2(50)	// NULL
	private String conect_environment;	// 접속환경	// VARCHAR2(50)	// NULL
	
}
