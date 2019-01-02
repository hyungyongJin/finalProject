package com.ai.fishdr.vo;

import lombok.Data;

/**
 * 
 * @Class Name : FishSymptmsVO.java
 * @Description : 피쉬증상 테이블 관련 Value Object
 * @Modification Information
 * @author 조성광
 * @since  2018. 11. 19.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일            수정자      수정내용
 *    ------------ 		-------     -------------------
 *    2018. 11. 19.     조성광      최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
@Data
public class FishSymptmsVO {
	private String no;
	private String fish_symptms;
	private String treat_code;
}
