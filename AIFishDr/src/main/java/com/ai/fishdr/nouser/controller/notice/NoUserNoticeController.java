package com.ai.fishdr.nouser.controller.notice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
 * @Class Name :NoUserNoticeController.java
 * @Description : 비회원 공지사항컨트롤러 및 메인화면 처리
 * @Modification Information
 * @author 
 * @since  2018. 11. 12.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일             수정자             수정내용
 *    -------        -------     -------------------
 *    2018. 11. 12.     진형용             최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
@Controller
@RequestMapping("/nouser/noticeboard/")
public class NoUserNoticeController {

	/**s
	 * 
	 *  개요 : 테스트
	 * @Method Name : hello
	 * @author : Administrator
	 * -----------------------------------
	 * @param : 
	 * @return : String
	 * @throws :
	 */
	@RequestMapping("noticeView")
	public void noticeView(){
		
	}
	@RequestMapping("noticeboardList")
	public void noticeList(){
		
	}
	
}
