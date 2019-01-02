package com.ai.fishdr.user.controller.noticeboard;

import java.net.URLEncoder;
import java.sql.Clob;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.fishdr.admin.serivce.board.IBoardService;
import com.ai.fishdr.admin.serivce.boardFile.IBoardFileService;
import com.ai.fishdr.admin.serivce.boardcomment.IBoardCommentService;
import com.ai.fishdr.admin.serivce.stats.IStatsService;
import com.ai.fishdr.nouser.service.notice.INoUserService;
import com.ai.fishdr.user.service.facepicture.IFacePictureService;
import com.ai.fishdr.utils.ClobToString;
import com.ai.fishdr.utils.RoleCommentPagingUtil;
import com.ai.fishdr.utils.RolePagingUtil;
import com.ai.fishdr.vo.BoardVO;
import com.ai.fishdr.vo.MedicineVO;
import com.ai.fishdr.vo.MemberVO;

/**
 * 
 * @Class Name :NoticeUserController.java
 * @Description : 게시판 컨트롤러
 * @Modification Information
 * @author 유재훈
 * @since  2018. 11. 16.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일             수정자             수정내용
 *    -------        -------     -------------------
 *    2018. 11. 15.     유재훈             최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
@Controller
@RequestMapping("/user/noticeboard/")
public class NoticeUserController {
	@Autowired
	private IStatsService service;
	@Autowired
	private INoUserService noticeService;
	@Autowired
	private IBoardCommentService commentService;
	@Autowired
	private IBoardFileService fileService;
	@Autowired
	private IBoardService boardService;
	
	@Autowired
	private IFacePictureService facePictureService;
	
	/**
	 * 
	 *  개요 : 게시판 글 리스트
	 * @Method Name : noticeboardList
	 * @author : 유재훈
	 * -----------------------------------
	 * @param : ModelAndView model ,
	 *			HttpServletRequest request,
	 *			String bo_no,Map<String,String>params,
	 *			String search, String keyword,String currentPage
	 * @return : ModelAndView
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping("noticeboardList")
	public ModelAndView noticeboardList(ModelAndView model ,
										HttpServletRequest request,
										String bo_no,Map<String,String>params,
										String search, String keyword,String currentPage, HttpSession session) throws Exception{
		
		
		if (currentPage==null) {
			currentPage="1";
		}
		params.put("search", search);
		params.put("keyword", keyword);
		int totalCount= noticeService.getTotalCount(params);
		RolePagingUtil page= new RolePagingUtil(Integer.parseInt(currentPage), totalCount, request);
		params.put("endCount", String.valueOf(page.getEndCount()));
		params.put("startCount", String.valueOf(page.getStartCount()));
		
		List<Map<String,BoardVO>> noticeList =  noticeService.getNoticeList(params);
		model.addObject("currentPage", currentPage);
		model.addObject("search", search);
		if (keyword!=null) {
			keyword = URLEncoder.encode(keyword, "UTF-8");
		}
		model.addObject("keyword", keyword);
		
		model.addObject("paging",page.getPagingHtmls());
		model.addObject("noticeList",noticeList);
		return model;
	}
	/**
	 * 
	 *  개요 : 게시판 글 리스트
	 * @Method Name : noticeboardList
	 * @author : 유재훈
	 * -----------------------------------
	 * @param : ModelAndView model ,
	 *			HttpServletRequest request,
	 *			String bo_no,Map<String,String>params,
	 *			String search, String keyword,String currentPage
	 * @return : ModelAndView
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping("noticeboardList1")
	public ModelAndView noticeboardList1(ModelAndView model ,
			HttpServletRequest request,
			String bo_no,Map<String,String>params,
			String search, String keyword,String currentPage, HttpSession session) throws Exception{
		
		
		/////////////////////////////////////////////////////////////////////////////////////////////
		
		
		if (currentPage==null) {
			currentPage="1";
		}
		params.put("search", search);
		params.put("keyword", keyword);
		int totalCount= noticeService.getTotalCount(params);
		RolePagingUtil page= new RolePagingUtil(Integer.parseInt(currentPage), totalCount, request);
		params.put("endCount", String.valueOf(page.getEndCount()));
		params.put("startCount", String.valueOf(page.getStartCount()));
		
		List<Map<String,BoardVO>> noticeList =  noticeService.getNoticeList(params);
		model.addObject("currentPage", currentPage);
		model.addObject("search", search);
		if (keyword!=null) {
			keyword = URLEncoder.encode(keyword, "UTF-8");
		}
		model.addObject("keyword", keyword);
		
		model.addObject("paging",page.getPagingHtmls());
		model.addObject("noticeList",noticeList);
		return model;
	}
	/**
	 * 게시판 글 상세보기
	 *  개요 : 
	 * @Method Name : noticeboardView
	 * @author : 유재훈
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("noticeboardView")
	public ModelAndView noticeboardView(String commentPage,
										Map<String,String> params,
										ModelAndView model,
										String bo_no,
										String currentPage,
										String search,
										String keyword ,
										HttpServletRequest request,
										HttpSession session) throws Exception{
		params.put("bo_no", bo_no);
		noticeService.updateHit(params);
		if (commentPage==null) {
			commentPage="1";
		}
		int totalCount = commentService.getTotalCount(bo_no);
		if (keyword!=null) {
			keyword = URLEncoder.encode(keyword, "UTF-8");
		}
		model.addObject("keyword", keyword);
		RoleCommentPagingUtil page= new RoleCommentPagingUtil(Integer.parseInt(commentPage), totalCount, request, bo_no,currentPage,keyword,search);
		params.put("endCount", String.valueOf(page.getEndCount()));
		params.put("startCount", String.valueOf(page.getStartCount()));
		List<Map<String, Object>> viewInfo =  noticeService.getNoticeInfo(params);
		model.addObject("currentPage", currentPage);
		model.addObject("search", search);
		model.addObject("commentPage", commentPage);
		model.addObject("paging",page.getPagingHtmls()); 
		model.addObject("viewInfo",viewInfo);
		Clob content = (Clob) viewInfo.get(0).get("BO_CONTENT");
		if (content!=null) {
			String viewContent = ClobToString.convertClobToString(content);
			model.addObject("content",viewContent);
		}
		return model;
		
	}
	
	
	
	
	@RequestMapping("noticeList")
	public ModelAndView noticeList(ModelAndView model ,
										HttpServletRequest request,
										String message,
										String bo_no,Map<String,String>params,
										String search, String keyword,String currentPage, String profileStatus, String fp_file_save_name) throws Exception{
		
		params.put("profile_status", profileStatus);
		params.put("fp_file_save_name", fp_file_save_name);
		params.put("myProfileStatus", profileStatus);
		
		if (currentPage==null) {
			currentPage="1";
		}
		if(message!=null){
			message = URLEncoder.encode(message,"UTF-8");
			
		}
		params.put("search", search);
		params.put("keyword", keyword);
		int totalCount= noticeService.getTotalCount(params);
		RolePagingUtil page= new RolePagingUtil(Integer.parseInt(currentPage), totalCount, request);
		params.put("endCount", String.valueOf(page.getEndCount()));
		params.put("startCount", String.valueOf(page.getStartCount()));
		
		List<Map<String,BoardVO>> noticeList =  noticeService.getNoticeList(params);
		model.addObject("currentPage", currentPage);
		model.addObject("search", search);
		if (keyword!=null) {
			keyword = URLEncoder.encode(keyword, "UTF-8");
		}
		model.addObject("message", message);
		model.addObject("keyword", keyword);
		model.addObject("paging",page.getPagingHtmls());
		model.addObject("noticeList",noticeList);
		model.addObject("params", params);
		
		List<Map<String, BoardVO>> famousList = service.getFamousWriteList();
		model.addObject("famousList", famousList);
		List<MedicineVO> mdcinList = service.getFamouseMdcin();
		model.addObject("mdcinList", mdcinList);
		
		return model;
	}
	
	

}