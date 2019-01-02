package com.ai.fishdr.user.controller.fishgram;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.fishdr.nouser.service.member.IMemberService;
import com.ai.fishdr.user.service.facepicture.IFacePictureService;
import com.ai.fishdr.user.service.fishgram.IFishgramService;
import com.ai.fishdr.user.service.fishgramcomment.IFishgramCommentService;
import com.ai.fishdr.user.service.fishgramlike.IFishgramLikeService;
import com.ai.fishdr.user.service.friend.IFriendService;
import com.ai.fishdr.utils.RolePagingUtilFifteen;
import com.ai.fishdr.utils.RolePagingUtilFishgramComment;
import com.ai.fishdr.vo.FacePictureVO;
import com.ai.fishdr.vo.FishgramCommentVO;
import com.ai.fishdr.vo.FishgramVO;
import com.ai.fishdr.vo.FriendVO;
import com.ai.fishdr.vo.MemberVO;

/**
 * 
 * @Class Name : FishgramController.java
 * @Description : 피쉬그램 관련 컨트롤러
 * @Modification Information
 * @author 
 * @since  2018. 11. 12.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일            수정자      수정내용
 *    ------------      -------     -------------------
 *    2018. 11. 12.     심재형      최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
@Controller
@RequestMapping("/user/fishgram/")
public class FishgramController {

	private static String static_mem_id = null;
	
	@Autowired
	private IFishgramService fishgramService;
	
	@Autowired
	private IFacePictureService facePictureService;
	
	@Autowired
	private IMemberService memberService;
	
	@Autowired
	private IFishgramCommentService fishgramCommentService;
	
	@Autowired
	private IFriendService friendService;
	
	@Autowired
	private IFishgramLikeService fishgramLikeService;
	
	
	@RequestMapping("fishgramChat")
	public void fishgramChat() {
		
	}
	
	
	@RequestMapping("fishgramIcon")
	public void fishgramIcon() {
		
	}
	
	
	@RequestMapping("fishgramSample")
	public void fishgramSample() {
		
	}
	
	
	@RequestMapping("diary/fishgramDiaryForm")
	public void fishgramDiaryForm() {
		
	}
	
	
	@RequestMapping("idPicFileUpload")
	public void idPicFileUpload() {
		
	}
	
	
	/**
	 * 
	 *    의미 : 자신의 피쉬그램 글 전체 리스트를 위한 데이터 전달
	 * @Method : fishgramMeMain
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : mav (ModelAndView 타입)
	 * 			 request (HttpServletRequest 타입)
	 * 			 params (Map<String, String> 타입)
	 * 			 search_keyword (String 타입)
	 *			 search_keycode (String 타입)
	 * 			 currentPage (String 타입)
	 * 			 session (HttpSession 타입)
	 * @return : mav (ModelAndView 타입)
	 * @throws : Exception
	 */
	@RequestMapping("fishgramMeMain")
	public ModelAndView fishgramMeMain(ModelAndView mav,
											 HttpServletRequest request,
											 Map<String, String> params,
											 String search_keyword,
											 String search_keycode,
											 String currentPage,
											 HttpSession session) throws Exception {
		
		List<FishgramVO> fdl = new ArrayList<FishgramVO>();
				
		if (currentPage == null) {
			
			currentPage = "1";
			
		}
		
		String bo_writer = ((MemberVO)session.getAttribute("LOGIN_MEMBER")).getMem_id();
		String profile_status = ((MemberVO)session.getAttribute("LOGIN_MEMBER")).getProfile_status();
		
		params.put("myProfileStatus", profile_status);
		
		FacePictureVO fpv = new FacePictureVO();
		
		String fp_mem_id = bo_writer;
		
		String fp_file_save_name = null;
		
		params.put("fp_mem_id", fp_mem_id);
		
		if (profile_status.equals("y")) {
			
			fp_file_save_name = facePictureService.facePictureInfo(params).getFp_file_save_name();
			
		}
		
		params.put("fp_file_save_name", fp_file_save_name);
		params.put("search_keycode", search_keycode);
		params.put("search_keyword", search_keyword);
		params.put("bo_writer", bo_writer);
		params.put("profile_status", profile_status);
		
		
		// 자신의 피쉬그램에 등록된 글의 총 개수
		int totalFishgramDiaryAllCount = fishgramService.totalFishgramDiaryAllCount(params);		
		
		// 검색 조건에 맞는 피쉬그램 글 수
		int totalFishgramDiaryCount = fishgramService.totalFishgramDiaryCount(params);
		
		// 자신의 모든 글에 카운팅된 좋아요 총 수
		int totalLikeAllCount = fishgramService.totalLikeAllCount(params);
		
		// 자신의 모든 친구 수
		int totalSearchFriendAllCount = fishgramService.totalSearchFriendAllCount(bo_writer);
		
		RolePagingUtilFifteen page = new RolePagingUtilFifteen(Integer.parseInt(currentPage), totalFishgramDiaryCount, request);
		
		params.put("startCount", String.valueOf(page.getStartCount()));
		params.put("endCount", String.valueOf(page.getEndCount()));
		
		fdl = fishgramService.getFishgramDiaryList(params);
		
		// 해당 글의 좋아요 수 넣기
		for (int i = 0 ; i < fdl.size() ; i++) {
			
			int bo_good_hit = fishgramLikeService.totalFishgramDiaryLikeCount(fdl.get(i).getBo_no());
			
			String bo_good_hit_string = String.valueOf(bo_good_hit);
			
			fdl.get(i).setBo_good_hit(bo_good_hit_string);
			
		}
		
		mav.addObject("paging", page.getPagingHtmls());
		mav.addObject("fdl", fdl);
		mav.addObject("totalAllDiary", totalFishgramDiaryAllCount);
		mav.addObject("totalDiary", totalFishgramDiaryCount);
		mav.addObject("totalAllLike", totalLikeAllCount);
		mav.addObject("totalAllFriend", totalSearchFriendAllCount);
		mav.addObject("params", params);
		mav.addObject("myProfileStatus", profile_status);
		
		mav.setViewName("user/fishgram/fishgramMeMain");
		
		return mav;
		
	}
	
	
	/**
	 * 
	 *    의미 : 자신의 피쉬그램 또는 타인의 피쉬그램을 접속할 때 피쉬그램 리스트를 보여주기
	 * @Method : fishgramYouList
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : session (HttpSession 타입)
	 * 			 mem_id (String 타입)
	 * @return : String
	 * @throws : -
	 */
	@RequestMapping("fishgramYouList")
	public String fishgramYouList(HttpSession session, String mem_id) {
		
		String myId = ((MemberVO)session.getAttribute("LOGIN_MEMBER")).getMem_id();
		
		if (myId.equals(mem_id)) {
		
			return "forward:/user/fishgram/fishgramMeMain.do";
			
		} else {
			
			return "forward:/user/fishgram/fishgramYouMain.do";
			
		}
		
		
	}
	
	
	/**
	 * 
	 *    의미 : 타인의 피쉬그램 글 전체 리스트를 위한 데이터 전달
	 * @Method : fishgramYouMain
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : mav (ModelAndView 타입)
	 * 			 request (HttpServletRequest 타입)
	 * 			 params (Map<String, String> 타입)
	 * 			 search_keyword (String 타입)
	 *			 search_keycode (String 타입)
	 * 			 currentPage (String 타입)
	 * 			 session (HttpSession 타입)
	 * @return : mav (ModelAndView 타입)
	 * @throws : Exception
	 */
	@RequestMapping("fishgramYouMain")
	public ModelAndView fishgramYouMain(ModelAndView mav,
											 HttpServletRequest request,
											 Map<String, String> params,
											 Map<String, String> yourParams,
											 Map<String, String> friendSendParams,
											 Map<String, String> friendReceiveParams,
											 String search_keyword,
											 String search_keycode,
											 String currentPage,
											 String selectNickname,
											 String mem_id, String yourId,
											 String sendApplyStatus,
											 String receiveApplyStatus,
											 HttpSession session) throws Exception {
		
		// 타인의 아이디 정보가 mem_id 변수에 담겨져 있는 경우 임시아이디저장소에 타인의 아이디 정보 넣기
		if (mem_id != null) {
		
			static_mem_id = request.getParameter("mem_id");
			
		}
		
		
		// 타인의 아이디 정보가 yourId 변수에 담겨져 있는 경우 임시아이디저장소에 타인의 아이디 정보 넣기 
		if (yourId != null) {
			
			static_mem_id = yourId;
			
		}
		
		List<FishgramVO> fdl = new ArrayList<FishgramVO>();
				
		
		// 현재 페이지가 정해져 있지 않은 경우 (최초접근) 기본적으로 1페이지로 설정
		if (currentPage == null) {
			
			currentPage = "1";
			
		}
				
		
		// 본인의 아이디와 프로필 사진 정보 넣기
		String myId = ((MemberVO)session.getAttribute("LOGIN_MEMBER")).getMem_id();
		
		String myProfileStatus = ((MemberVO)session.getAttribute("LOGIN_MEMBER")).getProfile_status();
		
		String fp_file_save_name = null;
		
		params.put("fp_mem_id", myId);
		params.put("profile_status", myProfileStatus);
		params.put("myProfileStatus", myProfileStatus);
				
		if (myProfileStatus.equals("y")) {
			
			fp_file_save_name = facePictureService.facePictureInfo(params).getFp_file_save_name();
			
		}
		
		params.put("fp_file_save_name", fp_file_save_name);
		
		
		// 타인의 아이디, 닉네임, 프로필 사진 정보 넣기
		String mem_nickname = null;
		
		String profile_status = null;
		
		String fp_mem_id = null;
		
		String bo_writer = null;
		
		String yourfp_file_save_name = null;
		
		MemberVO mv = new MemberVO();
		
		
		// 피쉬그램의 닉네임 검색 메뉴를 통하여 타인의 피쉬그램에 접속했을 경우
		if (selectNickname != null && mem_id == null) {
			
			mem_nickname = selectNickname;
			
			yourParams.put("mem_nickname", mem_nickname);
			
			mv = memberService.getSelectNicknameInfo(yourParams);
			
			profile_status = mv.getProfile_status();
			
			fp_mem_id = mv.getMem_id();
			
			bo_writer = mv.getMem_id();
			
		}
		
		// 게시판에서 해당 닉네임을 클릭한 후 블로그 가기 항목을 선택했을 경우
		else {
			
			fp_mem_id = static_mem_id;
			
			bo_writer = static_mem_id;
			
			yourParams.put("mem_id", fp_mem_id);
			
			mv = memberService.getSelectIdInfo(yourParams);
			
			if (mv!=null) {
				profile_status = mv.getProfile_status();
				
				mem_nickname = mv.getMem_nickname();
			}
			
			yourParams.put("mem_nickname", mem_nickname);
			
		}
		
		yourParams.put("fp_mem_id", fp_mem_id);
		params.put("your_mem_id", fp_mem_id);
		
		
		// 친구 신청 상태 확인하기
		friendSendParams.put("mem_id", myId);
		friendSendParams.put("fr_id", fp_mem_id);
		
		FriendVO fvSend = friendService.getFishgramFriendInfo(friendSendParams);
		
		friendReceiveParams.put("mem_id", fp_mem_id);
		friendReceiveParams.put("fr_id", myId);
			
		FriendVO fvReceive = friendService.getFishgramFriendInfo(friendReceiveParams);
		
		String sendEmptyStatus = null;
		String receiveEmptyStatus = null;
		
		
		// 내가 상대방에게 친구신청을 하였을 때
		if (fvSend != null) {
		
			sendApplyStatus = fvSend.getFr_status();
			
			friendSendParams.put("sendApplyStatus", sendApplyStatus);
			
			receiveEmptyStatus = "empty";
			
			friendReceiveParams.put("receiveEmptyStatus", receiveEmptyStatus);
		
			
		// 상대방이 나에게 친구신청을 하였을 때
		} else if (fvReceive != null) {
			
			receiveApplyStatus = fvReceive.getFr_status();
			
			sendEmptyStatus = "empty";
			
			friendReceiveParams.put("receiveApplyStatus", receiveApplyStatus);
			
			friendSendParams.put("sendEmptyStatus", sendEmptyStatus);
			
			
		// 서로 친구상태이거나 친구상태가 아닐 경우	
		} else {
			
			String fvSendConfirm = null;
			
			fvSendConfirm = friendService.getFrStatus(friendSendParams);
			
			
			String fvReceiveConfirm = null;
			
			fvReceiveConfirm = friendService.getFrStatus(friendReceiveParams);
			
			if (fvSendConfirm == null && fvReceiveConfirm == null) {
				
				sendApplyStatus = "noFriend";
				receiveApplyStatus = "noFriend";
								
			} else if (fvSendConfirm.equals("y") || fvReceiveConfirm.equals("y")) {
					
				sendApplyStatus = "friend";
				receiveApplyStatus = "friend";
				
			}
			
			friendSendParams.put("sendApplyStatus", sendApplyStatus);
			friendReceiveParams.put("receiveApplyStatus", receiveApplyStatus);
							
		}
		
		
		///////////////////////////////////////////////////////////////////////////////////////
		
		if (profile_status.equals("y")) {
			
			yourfp_file_save_name = facePictureService.facePictureInfo(yourParams).getFp_file_save_name();
			
		}
		
		yourParams.put("yourfp_file_save_name", yourfp_file_save_name);
		yourParams.put("search_keycode", search_keycode);
		yourParams.put("search_keyword", search_keyword);
		yourParams.put("bo_writer", bo_writer);
		yourParams.put("profile_status", profile_status);
		yourParams.put("currentPage", currentPage);
		
		
		// 방문한 회원 피쉬그램에 등록된 글의 총 개수
		int totalFishgramDiaryAllCount = fishgramService.totalFishgramDiaryAllCount(yourParams);
				
		// 방문한 회원 피쉬그램에서 검색 조건에 맞는 피쉬그램 글 수
		int totalFishgramDiaryCount = fishgramService.totalFishgramDiaryCount(yourParams);
		
		// 자신의 모든 글에 카운팅된 좋아요 총 수
		int totalLikeAllCount = fishgramService.totalLikeAllCount(params);
		
		// 자신의 모든 친구 수
		int totalSearchFriendAllCount = fishgramService.totalSearchFriendAllCount(bo_writer);
		
		RolePagingUtilFifteen page = new RolePagingUtilFifteen(Integer.parseInt(currentPage), totalFishgramDiaryCount, request);
		
		yourParams.put("startCount", String.valueOf(page.getStartCount()));
		yourParams.put("endCount", String.valueOf(page.getEndCount()));
		
		fdl = fishgramService.getFishgramDiaryList(yourParams);
		
		
		// 해당 글의 좋아요 수 넣기
		for (int i = 0 ; i < fdl.size() ; i++) {
			
			int bo_good_hit = fishgramLikeService.totalFishgramDiaryLikeCount(fdl.get(i).getBo_no());
			
			String bo_good_hit_string = String.valueOf(bo_good_hit);
			
			fdl.get(i).setBo_good_hit(bo_good_hit_string);
			
		}
		
		mav.addObject("paging", page.getPagingHtmls());
		mav.addObject("fdl", fdl);
		mav.addObject("totalAllDiary", totalFishgramDiaryAllCount);
		mav.addObject("totalDiary", totalFishgramDiaryCount);
		mav.addObject("totalAllLike", totalLikeAllCount);
		mav.addObject("totalAllFriend", totalSearchFriendAllCount);
		mav.addObject("params", params);
		mav.addObject("yourParams", yourParams);
		mav.addObject("friendSendParams", friendSendParams);
		mav.addObject("friendReceiveParams", friendReceiveParams);
		mav.addObject("myProfileStatus", myProfileStatus);
		
		mav.setViewName("user/fishgram/fishgramYouMain");
		
		return mav;
		
	}
	
	
	/**
	 * 
	 *    의미 : 자신의 피쉬그램 리스트에서 특정 글에 해당하는 행을 선택하였을 때 특정 글에 대한 상세 정보
	 * @Method : fishgramDiaryMeView
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : mav (ModelAndView 타입)
	 * 			 request (HttpServletRequest 타입)
	 * 			 params (Map<String, String> 타입)
	 * 			 search_keyword (String 타입)
	 *			 search_keycode (String 타입)
	 * 			 currentPage (String 타입)
	 * 			 session (HttpSession 타입)
	 * @return : mav (ModelAndView 타입)
	 * @throws : IOException
	 */
	@RequestMapping("diary/fishgramDiaryMeView")
	public ModelAndView fishgramDiaryMeView(ModelAndView mav, Map<String, String> params, Map<String, String> commentParmas, Map<String, String> hitCountParams,
										  HttpServletRequest request, HttpSession session,
										  String bo_no, String rnum, String currentPage, String commentCurrentPage,
										  String search_keyword, String search_keycode,
										  String query, String bo_hit, String hitCount) throws Exception {
	
		hitCountParams.put("bo_no", bo_no);
		hitCountParams.put("bo_hit", bo_hit);
		
		if(hitCount == null) {
			
			hitCount = "no";
			
		}
		
		if (hitCount.equals("ok")) {
			
			fishgramService.increaseHitCount(hitCountParams);
			
			hitCount = "no";
			
		}
		
		
		if (commentCurrentPage == null) {
			
			commentCurrentPage = "1";
			
		}
		
		String myId = ((MemberVO)session.getAttribute("LOGIN_MEMBER")).getMem_id();
		String myProfileStatus = ((MemberVO)session.getAttribute("LOGIN_MEMBER")).getProfile_status();
		
		params.put("myProfileStatus", myProfileStatus);
		
		String fp_file_save_name = null;
		
		params.put("bo_no", bo_no);
		
		FishgramVO fgv = fishgramService.getFishgramDiaryInfoAsBoNo(params);
		
		String bo_writer = fgv.getBo_writer();
		
		params.put("bo_writer", bo_writer);
		
		String mem_nickname = fishgramService.getMemIdAsBoWriter(params);
		
		params.put("mem_nickname", mem_nickname);
		
		String bo_title = fgv.getBo_title(); 
		
		params.put("bo_title", bo_title);
		
		String bo_reg_date = fgv.getBo_reg_date();
		
		params.put("bo_reg_date", bo_reg_date);
		
		String bo_content = fgv.getBo_content();
				
		params.put("bo_content", bo_content);
		
		params.put("fp_mem_id", myId);
		params.put("profile_status", myProfileStatus);
		
		params.put("search_keyword", search_keyword);
		params.put("search_keycode", search_keycode);
		
		
		if (myProfileStatus.equals("y")) {
			
			fp_file_save_name = facePictureService.facePictureInfo(params).getFp_file_save_name();
			
		}
		
		params.put("fp_file_save_name", fp_file_save_name);
		
		
		
		// 댓글 페이징 관련
		int totalFishgramDiaryCommentCount = fishgramCommentService.totalFishgramDiaryCommentCount(params);
		
		RolePagingUtilFishgramComment page = new RolePagingUtilFishgramComment(Integer.parseInt(commentCurrentPage), totalFishgramDiaryCommentCount, request);
		
		params.put("startCount", String.valueOf(page.getStartCount()));
		params.put("endCount", String.valueOf(page.getEndCount()));
		
		// 댓글 리스트
		List<Map<String, FishgramCommentVO>> fgcl = fishgramCommentService.getFishgramDiaryCommentList(params);
		
		
		// 좋아요 수 확인
		int totalFishgramDiaryLikeCount = 0;
		
		totalFishgramDiaryLikeCount = fishgramLikeService.totalFishgramDiaryLikeCount(bo_no);
		
		
		// 해당 글의 특정 아이디의 좋아요 상태 값 확인하기
		String likeStatus = null;
		
		params.put("mem_id", myId);
		
		likeStatus = fishgramLikeService.getLikeStatus(params);
		
		
		mav.addObject("params", params);
		mav.addObject("paging", page.getPagingHtmls());
		mav.addObject("totalFishgramDiaryCommentCount", totalFishgramDiaryCommentCount);
		mav.addObject("totalLike", totalFishgramDiaryLikeCount);
		mav.addObject("likeStatus", likeStatus);
		mav.addObject("fgcl", fgcl);
		
		return mav;
		
	}
	
	
	/**
	 * 
	 *    의미 : 타인의 피쉬그램 리스트에서 특정 글에 해당하는 행을 선택하였을 때 특정 글에 대한 상세 정보
	 * @Method : fishgramDiaryYouView
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : mav (ModelAndView 타입)
	 * 			 request (HttpServletRequest 타입)
	 * 			 params (Map<String, String> 타입)
	 * 			 search_keyword (String 타입)
	 *			 search_keycode (String 타입)
	 * 			 currentPage (String 타입)
	 * 			 session (HttpSession 타입)
	 * @return : mav (ModelAndView 타입)
	 * @throws : IOException
	 */
	@RequestMapping("diary/fishgramDiaryYouView")
	public ModelAndView fishgramDiaryYouView(ModelAndView mav, Map<String, String> params, Map<String, String> yourParams, Map<String, String> commentParmas, Map<String, String> hitCountParams,
										  HttpServletRequest request, HttpSession session,
										  String bo_no, String rnum, String bo_hit, String yourId,
										  String currentPage, String commentCurrentPage, String search_keyword, String search_keycode,
										  String hitCount) throws Exception {
			
		hitCountParams.put("bo_no", bo_no);
		hitCountParams.put("bo_hit", bo_hit);
		
		if (hitCount.equals("ok")) {
			
			fishgramService.increaseHitCount(hitCountParams);
			
			hitCount = "no";
			
		}
		
		
		if (commentCurrentPage == null) {
			
			commentCurrentPage = "1";
			
		}
		
		// 자신의 프로필 사진이 LEFT 메뉴 및 댓글에 항상 뜰 수 있도록 설정
		String myId = ((MemberVO)session.getAttribute("LOGIN_MEMBER")).getMem_id();
		String myProfileStatus = ((MemberVO)session.getAttribute("LOGIN_MEMBER")).getProfile_status();
		
		params.put("myProfileStatus", myProfileStatus);
		
		String fp_file_save_name = null;
		
		params.put("fp_mem_id", myId);
		params.put("profile_status", myProfileStatus);
		
		if (myProfileStatus.equals("y")) {
			
			fp_file_save_name = facePictureService.facePictureInfo(params).getFp_file_save_name();
			
		}
		
		params.put("fp_file_save_name", fp_file_save_name);
		
		
		// 타인의 프로필 사진 정보 전달하기
		String yourProfileStatus = memberService.getProfileStatus(yourId);
		
		String yourfp_file_save_name = null;
		
		yourParams.put("fp_mem_id", yourId);
		yourParams.put("profile_status", yourProfileStatus);
		
		if (yourProfileStatus.equals("y")) {
			
			yourfp_file_save_name = facePictureService.facePictureInfo(params).getFp_file_save_name();
			
		}
		
		yourParams.put("yourfp_file_save_name", yourfp_file_save_name);
		
		
		yourParams.put("bo_no", bo_no);
		
		FishgramVO fgv = fishgramService.getFishgramDiaryInfoAsBoNo(params);
		
		String bo_writer = fgv.getBo_writer();
		
		yourParams.put("bo_writer", bo_writer);
		
		String mem_nickname = fishgramService.getMemIdAsBoWriter(params);
		
		yourParams.put("mem_nickname", mem_nickname);
		
		String bo_title = fgv.getBo_title(); 
		
		yourParams.put("bo_title", bo_title);
		
		String bo_reg_date = fgv.getBo_reg_date();
		
		yourParams.put("bo_reg_date", bo_reg_date);
		
		String bo_content = fgv.getBo_content();
				
		yourParams.put("bo_content", bo_content);
		
		yourParams.put("search_keyword", search_keyword);
		yourParams.put("search_keycode", search_keycode);
		
		
		// 댓글 페이징 관련
		int totalFishgramDiaryCommentCount = fishgramCommentService.totalFishgramDiaryCommentCount(yourParams);
		
		RolePagingUtilFishgramComment page = new RolePagingUtilFishgramComment(Integer.parseInt(commentCurrentPage), totalFishgramDiaryCommentCount, request);
		
		yourParams.put("startCount", String.valueOf(page.getStartCount()));
		yourParams.put("endCount", String.valueOf(page.getEndCount()));
		
		// 댓글 리스트
		List<Map<String, FishgramCommentVO>> fgcl = fishgramCommentService.getFishgramDiaryCommentList(yourParams);
		
		
		// 좋아요 수 확인
		int totalFishgramDiaryLikeCount = 0;
		
		totalFishgramDiaryLikeCount = fishgramLikeService.totalFishgramDiaryLikeCount(bo_no);
		
		// 해당 글의 특정 아이디의 좋아요 상태 값 확인하기
		String likeStatus = null;
		
		params.put("mem_id", myId);
		params.put("bo_no", bo_no);
		
		likeStatus = fishgramLikeService.getLikeStatus(params);
				
		mav.addObject("params", params);
		mav.addObject("yourParams", yourParams);
		mav.addObject("paging", page.getPagingHtmls());
		mav.addObject("totalFishgramDiaryCommentCount", totalFishgramDiaryCommentCount);
		mav.addObject("totalLike", totalFishgramDiaryLikeCount);
		mav.addObject("likeStatus", likeStatus);
		mav.addObject("fgcl", fgcl);
		
		return mav;
		
	}
	
	
	
	
	
	/**
	 * 
	 *    의미 : 피쉬그램 글 등록을 위한 데이터 전달
	 * @Method : insertFishgramDiary
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : mav (ModelAndView 타입)
	 * @return : mav (ModelAndView 타입)
	 * @throws : IOException
	 */
	@RequestMapping("diary/insertFishgramDiary")
	public ModelAndView insertFishgramDiary(ModelAndView mav, FishgramVO fgv) throws Exception {
		System.out.println(fgv);
		fishgramService.insertFishgramDiary(fgv);
		
		mav.setViewName("redirect:/user/fishgram/fishgramMeMain.do");
		
		return mav;
		
	}
	
	
	/**
	 * 
	 *    의미 : 피쉬그램 글 수정 창 이동 및 데이터 전달
	 * @Method : fishgramDiaryModify
	 * @author : 심재형
	 * -----------------------------------
	 * @param  :  mav (ModelAndView 타입) // bo_no (String 타입)
	 * @return : mav (ModelAndView 타입)
	 * @throws : IOException
	 */
	@RequestMapping("diary/fishgramDiaryModify")
	public ModelAndView fishgramDiaryModify(ModelAndView mav, String bo_no, Map<String, String> params) throws Exception {
		
		params.put("bo_no", bo_no);
		
		FishgramVO fgv = fishgramService.getFishgramDiaryInfoAsBoNo(params);
		
		mav.addObject("fgv", fgv);
		
		mav.setViewName("user/fishgram/diary/fishgramDiaryModify");
		
		return mav;
		
		
	}
		
	
	/**
	 * 
	 *    의미 : 피쉬그램 글 수정을 위한 데이터 전달
	 * @Method : updateFishgramDiary
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : fgv (FishgramVO 타입) // mav (ModelAndView 타입)
	 * @return : mav (ModelAndView 타입)
	 * @throws : Exception
	 */
	@RequestMapping("diary/updateFishgramDiary")
	public ModelAndView updateFishgramDiary(FishgramVO fgv, ModelAndView mav, String bo_no, String bo_writer, String bo_content, Map<String, String> params) throws Exception {
		
		params.put("bo_no", bo_no);
		params.put("bo_writer", bo_writer);
//		params.put("bo_content", bo_content);
		
		fishgramService.updateFishgramDiary(fgv);
		
		mav.addObject("params", params);
		
		mav.setViewName("redirect:/user/fishgram/fishgramMeMain.do");
		
		return mav;
		
	}
	
	
	/**
	 * 
	 *    의미 : 피쉬그램 글 삭제를 위한 데이터 전달
	 * @Method : deleteFishgramDiary
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : mav (ModelAndView 타입)
	 * @return : mav (ModelAndView 타입)
	 * @throws : 
	 */
	@RequestMapping("diary/deleteFishgramDiary")
	public ModelAndView deleteFishgramDiary(ModelAndView mav, String bo_no, Map<String, String> params) throws Exception {
		
		fishgramService.deleteFishgramDiary(bo_no);
		
		mav.setViewName("redirect:/user/fishgram/fishgramMeMain.do");
		
		return mav;
		
	}
	
	
	
	
}
