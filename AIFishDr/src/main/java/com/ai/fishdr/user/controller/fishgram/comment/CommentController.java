package com.ai.fishdr.user.controller.fishgram.comment;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ai.fishdr.nouser.service.member.IMemberService;
import com.ai.fishdr.user.service.facepicture.IFacePictureService;
import com.ai.fishdr.user.service.fishgram.IFishgramService;
import com.ai.fishdr.user.service.fishgramcomment.IFishgramCommentService;

import com.ai.fishdr.vo.FishgramVO;
import com.ai.fishdr.vo.MemberVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * 
 * @Class Name : CommentController.java
 * @Description :  피쉬그램 댓글 관련 컨트롤러
 * @Modification Information
 * @author 
 * @since  2018. 11. 21.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일            수정자      수정내용
 *    ------------      -------     -------------------
 *    2018. 11. 21.     심재형      최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */

@Controller
@RequestMapping("/user/fishgram/comment/")
public class CommentController {
	
	@Autowired
	private IFishgramCommentService fishgramCommentService;
	
	@Autowired
	private IMemberService memberService;
	
	@Autowired
	private IFishgramService fishgramService;
	
	@Autowired
	private IFacePictureService facePictureService;
	
	
	/**
	 * 
	 *    의미 : 피쉬그램 댓글 추가
	 * @Method : insertFishgramDiaryComment
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : mav (ModelAndView 타입)
	 * @return : mav (ModelAndView 타입)
	 * @throws : Exception
	 */
	@RequestMapping("insertFishgramDiaryComment")
	public ModelAndView insertFishgramDiaryComment(ModelAndView mav, Map<String, String> params, Map<String, String> confirmParams, String mem_id, String yourId, String bo_no, String inputComment, String hitCount, HttpServletRequest request, HttpSession session) throws Exception {
				
		if (yourId != null) {
			
			params.put("bo_writer", yourId);
			
		} else {
		
			params.put("bo_writer", mem_id);
			
		}
		
		params.put("mem_id", mem_id);
		params.put("bo_no", bo_no);
		params.put("comment_content", inputComment);
		params.put("hitCount", hitCount);
		
		fishgramCommentService.insertFishgramDiaryComment(params);
		
		String mem_nickname = fishgramService.getMemIdAsBoWriter(params);
		
		params.put("mem_nickname", mem_nickname);
	
		mav.addObject("params",params);
		
		
		// 현재 작성한 댓글에 해당하는 글 작성자가 본인인지 다른 사람인지 확인
		confirmParams.put("bo_no", bo_no);
		
		FishgramVO fgv = fishgramService.getFishgramDiaryInfoAsBoNo(confirmParams);
		
		String confirmMemId = fgv.getBo_writer();
		
		if (confirmMemId.equals(((MemberVO)session.getAttribute("LOGIN_MEMBER")).getMem_id())) {
		
			mav.setViewName("redirect:/user/fishgram/diary/fishgramDiaryMeView.do?hitCount=" + hitCount + "&yourId=" + yourId);
			
		} else {
			
			mav.setViewName("redirect:/user/fishgram/diary/fishgramDiaryYouView.do?hitCount=" + hitCount + "&yourId=" + yourId);
			
		}
		
		return mav;
		
	}
	
	
	/**
	 * 
	 *    의미 : 피쉬그램 댓글 수정
	 * @Method : modifyFishgramDiaryComment
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : mav (ModelAndView 타입)
	 * @return : mav (ModelAndView 타입)
	 * @throws : Exception
	 */
	@RequestMapping("modifyFishgramDiaryComment")
	public ModelAndView modifyFishgramDiaryComment(ModelAndView mav, Map<String, String> params, Map<String, String> confirmParams, String hiddenCommentNo, String modifyComment, String bo_no, String yourId, String hitCount, HttpServletRequest request, HttpSession session) throws Exception {
		
		if (yourId != null) {
			
			params.put("bo_writer", yourId);
			
		}

		params.put("comment_no", hiddenCommentNo);
		params.put("comment_content", modifyComment);
		params.put("bo_no", bo_no);
//		params.put("hitCount", hitCount);
				
		fishgramCommentService.modifyFishgramDiaryComment(params);
		
		mav.addObject("params", params);
		
		// 현재 작성한 댓글에 해당하는 글 작성자가 본인인지 다른 사람인지 확인
		confirmParams.put("bo_no", bo_no);
		
		FishgramVO fgv = fishgramService.getFishgramDiaryInfoAsBoNo(confirmParams);
		
		String confirmMemId = fgv.getBo_writer();
		
		if (confirmMemId.equals(((MemberVO)session.getAttribute("LOGIN_MEMBER")).getMem_id())) {
		
			mav.setViewName("redirect:/user/fishgram/diary/fishgramDiaryMeView.do?hitCount=" + hitCount + "&yourId=" + yourId);
			
		} else {
			
			mav.setViewName("redirect:/user/fishgram/diary/fishgramDiaryYouView.do?hitCount=" + hitCount + "&yourId=" + yourId);
			
		}
		
		return mav;
		
	}
	
	
	/**
	 * 
	 *    의미 : 피쉬그램 댓글 삭제
	 * @Method : deleteFishgramDiaryComment
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : mav (ModelAndView 타입)
	 * @return : mav (ModelAndView 타입)
	 * @throws : Exception
	 */
	@RequestMapping("deleteFishgramDiaryComment")
	public ModelAndView deleteFishgramDiaryComment(ModelAndView mav, Map<String, String> params, Map<String, String> confirmParams, String hiddenCommentNo, String bo_no, String hitCount, String yourId, HttpServletRequest request, HttpSession session) throws Exception {
		
		if (yourId != null) {
			
			params.put("bo_writer", yourId);
			
		}
		
		params.put("comment_no", hiddenCommentNo);
		params.put("bo_no", bo_no);
		params.put("hitCount", hitCount);
				
		fishgramCommentService.deleteFishgramDiaryComment(params);
		
		mav.addObject("params", params);
		
		// 현재 작성한 댓글에 해당하는 글 작성자가 본인인지 다른 사람인지 확인
		confirmParams.put("bo_no", bo_no);
		
		FishgramVO fgv = fishgramService.getFishgramDiaryInfoAsBoNo(confirmParams);
		
		String confirmMemId = fgv.getBo_writer();
		
		if (confirmMemId.equals(((MemberVO)session.getAttribute("LOGIN_MEMBER")).getMem_id())) {
		
			mav.setViewName("redirect:/user/fishgram/diary/fishgramDiaryMeView.do?hitCount=" + hitCount + "&yourId=" + yourId);
			
		} else {
			
			mav.setViewName("redirect:/user/fishgram/diary/fishgramDiaryYouView.do?hitCount=" + hitCount + "&yourId=" + yourId);
			
		}
		
		return mav;
		
	}
	
}
