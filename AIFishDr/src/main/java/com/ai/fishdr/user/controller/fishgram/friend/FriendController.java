package com.ai.fishdr.user.controller.fishgram.friend;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ai.fishdr.user.service.friend.IFriendService;
import com.ai.fishdr.utils.RolePagingUtilAjaxFriendReceive;
import com.ai.fishdr.utils.RolePagingUtilAjaxFriendSearch;
import com.ai.fishdr.utils.RolePagingUtilAjaxFriendSend;
import com.ai.fishdr.vo.FriendVO;
import com.ai.fishdr.vo.MemberVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * 
 * @Class Name : FriendController.java
 * @Description :  피쉬그램 친구 관련 컨트롤러
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
@RequestMapping("/user/fishgram/friend/")
public class FriendController {
	
	@Autowired
	private IFriendService friendService;
	
	
	/**
	 * 
	 *    의미 : 원하는 회원에게 피쉬그램 친구 신청
	 * @Method : applyFishgramFriend
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : mav (ModelAndView 타입)
	 * 			 params (Map<String, String> 타입)
	 *           mem_id (String 타입)
	 *           fr_id (String 타입)
	 * @return : "forward:/user/fishgram/fishgramYouMain.do?applyStatus=" + applyStatus + "&yourId=" + yourId (String 타입)
	 * @throws : Exception
	 */
	@RequestMapping("applyFishgramFriend")
	public String applyFishgramFriend(ModelAndView mav, Map<String, String> params, String mem_id, String fr_id) throws Exception {

		params.put("mem_id", mem_id);
		params.put("fr_id", fr_id);
		
		int duplicateCount = friendService.duplicateApplyProtect(params);
		
		if (duplicateCount == 0) {
		
			friendService.applyFishgramFriend(params);
			
		}
		
//		FriendVO fv = friendService.getFishgramFriendInfo(params);
		
//		String applyStatus = fv.getFr_status();
		
		String yourId = fr_id;
		
		return "forward:/user/fishgram/fishgramYouMain.do?yourId=" + yourId;
		
	}
	
	
	/**
	 * 
	 *    의미 : 내가 상대방에게 요청한 친구 신청을 취소하기
	 * @Method : cancelDeleteFishgramFriendApply
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : mav (ModelAndView 타입)
	 * 			 params (Map<String, String> 타입)
	 *           mem_id (String 타입)
	 *           fr_id (String 타입)
	 * @return : "forward:/user/fishgram/fishgramYouMain.do?yourId=" + yourId (String 타입)
	 * @throws : Exception
	 */
	@RequestMapping("cancelFishgramFriendApply")
	public String cancelDeleteFishgramFriendApply(ModelAndView mav, Map<String, String> params, String mem_id, String fr_id) throws Exception {

		params.put("mem_id", mem_id);
		params.put("fr_id", fr_id);
		
		friendService.cancelFishgramFriendApply(params);
		
		String yourId = fr_id;
		
		return "forward:/user/fishgram/fishgramYouMain.do?yourId=" + yourId;
		
	}
	
	
	
	/**
	 * 
	 *    의미 : 상대방이 나에게 요청한 친구 신청을 수락하기
	 * @Method : acceptFishgramFriendApply
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : mav (ModelAndView 타입)
	 * 			 params (Map<String, String> 타입)
	 *           mem_id (String 타입)
	 *           fr_id (String 타입)
	 * @return : "forward:/user/fishgram/fishgramYouMain.do?yourId=" + yourId (String 타입)
	 * @throws : Exception
	 */
	@RequestMapping("acceptFishgramFriendApply")
	public String acceptFishgramFriendApply(ModelAndView mav, Map<String, String> params, String mem_id, String fr_id) throws Exception {

		params.put("mem_id", mem_id);
		params.put("fr_id", fr_id);
		
		friendService.acceptFishgramFriendApply(params);
		
		String yourId = fr_id;
		
		return "forward:/user/fishgram/fishgramYouMain.do?yourId=" + yourId;
		
	}
	
	/**
	 * 
	 *    의미 : 상대방이 나에게 요청한 친구 신청을 거절하기
	 * @Method : refuseFishgramFriendApply
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : mav (ModelAndView 타입)
	 * 			 params (Map<String, String> 타입)
	 *           mem_id (String 타입)
	 *           fr_id (String 타입)
	 * @return : "forward:/user/fishgram/fishgramYouMain.do?yourId=" + yourId (String 타입)
	 * @throws : Exception
	 */
	@RequestMapping("refuseFishgramFriendApply")
	public String refuseFishgramFriendApply(ModelAndView mav, Map<String, String> params, String mem_id, String fr_id) throws Exception {

		params.put("mem_id", mem_id);
		params.put("fr_id", fr_id);
		
		friendService.refuseFishgramFriendApply(params);
		
		String yourId = fr_id;
		
		return "forward:/user/fishgram/fishgramYouMain.do?yourId=" + yourId;
		
	}
	
	
	/**
	 * 
	 *    의미 : 나와 상대방의 친구 관계를 삭제
	 * @Method : deleteFishgramFriendApply
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : mav (ModelAndView 타입)
	 * 			 params (Map<String, String> 타입)
	 *           mem_id (String 타입)
	 *           fr_id (String 타입)
	 * @return : "forward:/user/fishgram/fishgramYouMain.do?yourId=" + yourId (String 타입)
	 * @throws : Exception
	 */
	@RequestMapping("deleteFishgramFriendApply")
	public String deleteFishgramFriendApply(ModelAndView mav, Map<String, String> params, String mem_id, String fr_id) throws Exception {

		// 내가 상대방에게 먼저 친구신청을 해서 서로 친구가 된 경우
		String test1 = null;
		
		params.put("mem_id", mem_id);
		params.put("fr_id", fr_id);
		
		test1 = friendService.getFrStatus(params);
		
		if (test1 != null && test1.equals("y")) {
			
			friendService.cancelFishgramFriendApply(params);
			
		} else {
			
			// 상대방이 나에게 먼저 친구신청을 해서 서로 친구가 된 경우
			String test2 = null;
			
			// 나의 아이디와 상대방의 아이디 서로 바꾼다음 Map에 다시 넣기
			params.put("mem_id", fr_id);
			params.put("fr_id", mem_id);
			
			test2 = friendService.getFrStatus(params);

			if (test2 != null && test2.equals("y")) {
				
				friendService.cancelFishgramFriendApply(params);
				
			}
			
		}
		
		String yourId = fr_id;
		
		return "forward:/user/fishgram/fishgramYouMain.do?yourId=" + yourId;
		
	}
	
	
	/**
	 * 
	 *    의미 : 자신에게 친구신청을 요청한 회원들 리스트 보기
	 * @Method : receiveFriendApplyList
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : mav (ModelAndView 타입)
	 * @return : mav (ModelAndView 타입)
	 * @throws : Exception
	 */
	@RequestMapping("receiveFriendApplyList")
	public ModelAndView receiveFriendApplyList(ModelAndView mav, Map<String, String> receiveFriendParams, String pageNo, HttpServletRequest request, HttpSession session) throws Exception {
		
		if (pageNo == null) {
			
			pageNo = "1";
			
		}
		
		String mem_id = ((MemberVO)session.getAttribute("LOGIN_MEMBER")).getMem_id();
		
		int totalReceiveFriendApplyCount = friendService.totalReceiveFriendApplyCount(mem_id);
		
		receiveFriendParams.put("mem_id", mem_id);
		
		RolePagingUtilAjaxFriendReceive page = new RolePagingUtilAjaxFriendReceive(Integer.parseInt(pageNo), totalReceiveFriendApplyCount, request);
		
		receiveFriendParams.put("startCount", String.valueOf(page.getStartCount()));
		receiveFriendParams.put("endCount", String.valueOf(page.getEndCount()));
		
		
		// 친구신청 요청 리스트
		List<Map<String, FriendVO>> receiveFal = friendService.receiveFriendApplyList(receiveFriendParams);
		
		mav.addObject("friendReceivePaging", page.getPagingHtmls());
//		mav.addObject("totalReceiveFriendApplyCount", totalReceiveFriendApplyCount);
		mav.addObject("receiveFal", receiveFal);
		
		mav.setViewName("jsonConvertView");
		
		return mav;
		
	}
	
	
	/**
	 * 
	 *    의미 : 내가 친구신청 요청한 회원들 리스트 보기
	 * @Method : sendFriendApplyList
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : mav (ModelAndView 타입)
	 * @return : mav (ModelAndView 타입)
	 * @throws : Exception
	 */
	@RequestMapping("sendFriendApplyList")
	public ModelAndView sendFriendApplyList(ModelAndView mav, Map<String, String> sendFriendParams, String pageNo, HttpServletRequest request, HttpSession session) throws Exception {
		
		if (pageNo == null) {
			
			pageNo = "1";
			
		}
		
		String mem_id = ((MemberVO)session.getAttribute("LOGIN_MEMBER")).getMem_id();
		
		int totalSendFriendApplyCount = friendService.totalSendFriendApplyCount(mem_id);
		
		sendFriendParams.put("mem_id", mem_id);
		
		RolePagingUtilAjaxFriendSend page = new RolePagingUtilAjaxFriendSend(Integer.parseInt(pageNo), totalSendFriendApplyCount, request);
		
		sendFriendParams.put("startCount", String.valueOf(page.getStartCount()));
		sendFriendParams.put("endCount", String.valueOf(page.getEndCount()));
		
		
		// 친구신청 요청 리스트
		List<Map<String, FriendVO>> sendFal = friendService.sendFriendApplyList(sendFriendParams);
		
		mav.addObject("friendSendPaging", page.getPagingHtmls());
//		mav.addObject("totalReceiveFriendApplyCount", totalReceiveFriendApplyCount);
		mav.addObject("sendFal", sendFal);
		
		mav.setViewName("jsonConvertView");
		
		return mav;
		
	}
	
	
	/**
	 * 
	 *    의미 : 입력받은 닉네임 조건에 맞는 친구 리스트 출력
	 * @Method : searchFriend
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
	@RequestMapping("searchFriend")
	public ModelAndView searchFriend(ModelAndView mav, Map<String, String> params, String friendNickname, String pageNo, HttpServletRequest request, HttpSession session) throws Exception {
		
		String mem_id = ((MemberVO)session.getAttribute("LOGIN_MEMBER")).getMem_id();
		
		params.put("mem_id", mem_id);
		params.put("mem_nickname", friendNickname);
				
		if (pageNo == null) {
			
			pageNo = "1";
			
		}
		
		int totalSearchFriendCount = friendService.totalSearchFriendCount(params);
		
		RolePagingUtilAjaxFriendSearch page = new RolePagingUtilAjaxFriendSearch(Integer.parseInt(pageNo), totalSearchFriendCount, request);
		
		params.put("startCount", String.valueOf(page.getStartCount()));
		params.put("endCount", String.valueOf(page.getEndCount()));
		
		List<Map<String, FriendVO>> searchFal = friendService.searchFriend(params);
		
		mav.addObject("searchFriendPaging", page.getPagingHtmls());
		mav.addObject("searchFal",searchFal);
		
		mav.setViewName("jsonConvertView");
		
		return mav;
		
	}
	
	
	
}
