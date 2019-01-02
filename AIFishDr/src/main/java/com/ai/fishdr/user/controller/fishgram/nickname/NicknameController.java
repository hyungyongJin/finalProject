package com.ai.fishdr.user.controller.fishgram.nickname;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ai.fishdr.nouser.service.member.IMemberService;
import com.ai.fishdr.utils.RolePagingUtilAjax;
import com.ai.fishdr.vo.MemberVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * 
 * @Class Name : NicknameController.java
 * @Description :  피쉬그램 닉네임 검색 관련 컨트롤러
 * @Modification Information
 * @author 
 * @since  2018. 11. 19.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일            수정자      수정내용
 *    ------------      -------     -------------------
 *    2018. 11. 19.     심재형      최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */

@Controller
@RequestMapping("/user/fishgram/nickname/")
public class NicknameController {
	
	@Autowired
	private IMemberService memberService;
	
	
	/**
	 * 
	 *    의미 : 닉네임 검색피쉬그램 글 삭제를 위한 데이터 전달
	 * @Method : deleteFishgramDiary
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : mav (ModelAndView 타입)
	 * @return : mav (ModelAndView 타입)
	 * @throws : 
	 */
	@RequestMapping("searchNickname")
	public ModelAndView searchNickname(Map<String, String> params, String nickname, ModelAndView mav, String pageNo, HttpServletRequest request, HttpSession session) throws Exception {
		
		String myId = ((MemberVO)session.getAttribute("LOGIN_MEMBER")).getMem_id();
		
		params.put("mem_id", myId);
		
		params.put("mem_nickname", nickname);
				
		if (pageNo == null) {
			
			pageNo = "1";
			
		}
		
		int totalsearchNicknameCount = memberService.totalsearchNicknameCount(params);
		
		RolePagingUtilAjax page = new RolePagingUtilAjax(Integer.parseInt(pageNo), totalsearchNicknameCount, request);
		
		params.put("startCount", String.valueOf(page.getStartCount()));
		params.put("endCount", String.valueOf(page.getEndCount()));
		
		List<MemberVO> mv = memberService.searchNickname(params);
		
		mav.addObject("pagingNickname", page.getPagingHtmls());
		mav.addObject("mv",mv);
		mav.setViewName("jsonConvertView");
		
		return mav;
		
	}
	
}
