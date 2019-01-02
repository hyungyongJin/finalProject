package com.ai.fishdr.vo;

import lombok.Data;

/**
 * 
 * @Class Name : ConversationVO.java
 * @Description : 진료 대화 관련 테이블 Value Object
 * @Modification Information
 * @author 조성광
 * @since  2018. 11. 20.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일            수정자      수정내용
 *    ------------ 		-------     -------------------
 *    2018. 11. 20.     조성광      최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */

@Data
public class ConversationVO {
	private String con_code;
	private String con_content;
}
