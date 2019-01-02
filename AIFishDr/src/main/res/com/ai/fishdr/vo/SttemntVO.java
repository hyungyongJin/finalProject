package com.ai.fishdr.vo;

import lombok.Data;
/**
 * 
 * @Class Name :SttemntVO.java
 * @Description : 게시판 신고 VO
 * @Modification Information
 * @author 진형용
 * @since  2018. 11. 19.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일             수정자             수정내용
 *    -------        -------     -------------------
 *    2018. 11. 19.     진형용             최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
@Data
public class SttemntVO {
	private String sttemnt_code; //신고코드
	private String mem_id; //회원아이디
	private String bo_no;  //
	private String reason; //신고사유
}
