package com.ai.fishdr.user.controller.member;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.fishdr.nouser.service.member.IMemberService;
import com.ai.fishdr.user.service.facepicture.IFacePictureService;
import com.ai.fishdr.vo.MemberVO;
import com.ai.fishdr.vo.SecessionVO;

/**
 * 
 * @Class Name :NoUserJoinController.java
 * @Description : 회원 회원수정 및 탈퇴 컨트롤러
 * @Modification Information
 * @author 
 * @since  2018. 11. 12.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일             수정자             수정내용
 *    -------        -------     -------------------
 *    2018. 11. 12.      임범학            최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
@Controller
@RequestMapping("/user/member/")
public class MemberController {
	
	@Resource
	private IMemberService service;
	
	@Autowired
	private IFacePictureService facePictureService;
	
	
	
	/**
	 * 
	 *  개요 : 회원탈퇴 신청
	 * @Method Name : memberOut
	 * @author : 임범학
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("memberOut")
	public ModelAndView memberOut(ModelAndView model,SecessionVO ssVO, HttpServletResponse response) throws Exception{
		
		
		
		int cnt = service.deleteMemberInfo(ssVO.getMem_id());
		service.insertSecession(ssVO);
		
		String message=null;
		
		if (cnt == 0) {
			message = "탈퇴완료";
		}else{
			message = "탈퇴실패";
		}
		
		model.setViewName("redirect:/nouser/join/logOut.do?message="+message);
		return model;
		
	}
	
	
	/**
	 * 
	 *  개요 : 회원수정 페이지 이동
	 * @Method Name : memberUpdateView
	 * @author : 임범학
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("memberUpdateView")
	public ModelAndView memberUpdateView(ModelAndView model, HttpSession session, Map<String, String> params) throws Exception{
		
		MemberVO mv = new MemberVO();
		
		String mem_id = ((MemberVO)session.getAttribute("LOGIN_MEMBER")).getMem_id();
		
		params.put("mem_id", mem_id);
		
		mv = service.memberInfo(params);
		
		model.addObject("memberInfo", mv);
		
		model.setViewName("user/member/updateMember");
		
		return model;
		
	}
	
	
	/**
	 * 
	 *  개요 : 회원수정 
	 * @Method Name : memberUpdate
	 * @author : 임범학
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("memberUpdate")
	public ModelAndView memberUpdate(ModelAndView model
									,Map<String,String> params
									,HttpServletResponse response
									,MemberVO vo
									,HttpSession session)throws Exception{
		
//		int cnt= 0;
//		cnt=
		service.updateMemberInfo(vo);
//		String message= null;
//		
//		
//		if (cnt == 0) {
//			
//			message = "제대로 입력해 주세요";
//			model.addObject("message", message);
//		}else{
//			message = "수정완료되었습니다";
//			model.addObject("message", message);
//
//		}
		model.setViewName("redirect:/main.do");
		
		return model;
	}
	
	/**
	 * 
	 *  개요 : 회원 이메일 중복확인
	 * @Method Name : memberUpdate
	 * @author : 임범학
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("emailCheck")
	public ModelAndView mailCheck(ModelAndView model
									, String mem_mail) throws Exception{
		
		boolean boo = service.emailCheck(mem_mail);
		
		model.addObject("boo", boo);
		model.setViewName("jsonConvertView");
		
		return model;
	}
	
	
}
