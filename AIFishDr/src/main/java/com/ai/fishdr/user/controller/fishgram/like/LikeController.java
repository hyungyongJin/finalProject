package com.ai.fishdr.user.controller.fishgram.like;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ai.fishdr.nouser.service.member.IMemberService;
import com.ai.fishdr.user.service.facepicture.IFacePictureService;
import com.ai.fishdr.user.service.fishgram.IFishgramService;
import com.ai.fishdr.user.service.fishgramcomment.IFishgramCommentService;
import com.ai.fishdr.user.service.fishgramlike.IFishgramLikeService;
import com.ai.fishdr.utils.RolePagingUtilAjaxLikeSearch;
import com.ai.fishdr.vo.FishgramLikeVO;
import com.ai.fishdr.vo.MemberVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * 
 * @Class Name : LikeController.java
 * @Description :  피쉬그램 좋아요 관련 컨트롤러
 * @Modification Information
 * @author 
 * @since  2018. 11. 27.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일            수정자      수정내용
 *    ------------      -------     -------------------
 *    2018. 11. 27.     심재형      최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */

@Controller
@RequestMapping("/user/fishgram/like/")
public class LikeController {
	
	@Autowired
	private IFishgramLikeService fishgramLikeService;
	
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
	 *    의미 : 선택한 피쉬그램 글에 좋아요 추가
	 * @Method : insertFishgramDiaryLike
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : mav (ModelAndView 타입)
	 * 			 params (Map<String, String> 타입)
	 * 			 your_id (String 타입)
	 * 			 bo_no (String 타입)
	 * 			 hitCount (String 타입)
	 * 			 request (HttpServletRequest)
	 *			 session (HttpSession)
	 * @return : mav (ModelAndView 타입)
	 * @throws : Exception
	 */
	@RequestMapping("insertFishgramDiaryLike")
	public ModelAndView insertFishgramDiaryLike(ModelAndView mav, Map<String, String> params, String yourId, String bo_no, String hitCount, HttpServletRequest request, HttpSession session) throws Exception {
		
		String mem_id = ((MemberVO)session.getAttribute("LOGIN_MEMBER")).getMem_id();
		
		params.put("mem_id", mem_id);
		params.put("bo_no", bo_no);
		params.put("hitCount", hitCount);
		
		fishgramLikeService.insertFishgramDiaryLike(params);
		
		mav.addObject("params", params);
		
		mav.setViewName("redirect:/user/fishgram/diary/fishgramDiaryYouView.do?hitCount=" + hitCount + "&yourId=" + yourId);
		
		return mav;
		
	}
	
	
	/**
	 * 
	 *    의미 : 선택한 피쉬그램 글에 추가한 좋아요를 취소하기
	 * @Method : deleteFishgramDiaryLike
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : mav (ModelAndView 타입)
	 * 			 params (Map<String, String> 타입)
	 * 			 your_id (String 타입)
	 * 			 bo_no (String 타입)
	 * 			 hitCount (String 타입)
	 * 			 request (HttpServletRequest)
	 *			 session (HttpSession)
	 * @return : mav (ModelAndView 타입)
	 * @throws : Exception
	 */
	@RequestMapping("deleteFishgramDiaryLike")
	public ModelAndView deleteFishgramDiaryLike(ModelAndView mav, Map<String, String> params, String yourId, String bo_no, String hitCount, HttpServletRequest request, HttpSession session) throws Exception {
		
		String mem_id = ((MemberVO)session.getAttribute("LOGIN_MEMBER")).getMem_id();
		
		params.put("mem_id", mem_id);
		params.put("bo_no", bo_no);
		params.put("hitCount", hitCount);
		
		fishgramLikeService.deleteFishgramDiaryLike(params);
		
		mav.addObject("params", params);
		
		mav.setViewName("redirect:/user/fishgram/diary/fishgramDiaryYouView.do?hitCount=" + hitCount + "&yourId=" + yourId);
		
		return mav;
		
	}
	
	
	/**
	 * 
	 *    의미 : 입력받은 닉네임 조건에 맞는 좋아요 누른 회원 리스트 출력
	 * @Method : searchLike
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : mav (ModelAndView 타입)
	 *			 params (Map<String, String> 타입)
	 *           friendNickname (String 타입)
	 *           pageNo (String 타입)
	 *           request (HttpServletRequest 타입)
	 *           session (HttpSession 타입)
	 * @return : mav (ModelAndView 타입)
	 * @throws : 
	 */
	@RequestMapping("searchLike")
	public ModelAndView searchLike(ModelAndView mav, Map<String, String> params, String likeNickname, String pageNo, String bo_no, HttpServletRequest request, HttpSession session) throws Exception {
		
		String mem_id = ((MemberVO)session.getAttribute("LOGIN_MEMBER")).getMem_id();
		
		params.put("mem_id", mem_id);
		params.put("bo_no", bo_no);
		params.put("mem_nickname", likeNickname);
				
		if (pageNo == null) {
			
			pageNo = "1";
			
		}
		
		// 좋아요 수 확인
		int totalFishgramDiaryLikeCount = 0;
				
		totalFishgramDiaryLikeCount = fishgramLikeService.totalFishgramDiaryLikeCount(bo_no);
		
		RolePagingUtilAjaxLikeSearch page = new RolePagingUtilAjaxLikeSearch(Integer.parseInt(pageNo), totalFishgramDiaryLikeCount, request);
		
		params.put("startCount", String.valueOf(page.getStartCount()));
		params.put("endCount", String.valueOf(page.getEndCount()));
		
		List<Map<String, FishgramLikeVO>> searchLikelist = fishgramLikeService.searchLike(params);
		
		mav.addObject("searchLikePaging", page.getPagingHtmls());
		mav.addObject("searchLikelist",searchLikelist);
		
		mav.setViewName("jsonConvertView");
		
		return mav;
		
	}
	
}
