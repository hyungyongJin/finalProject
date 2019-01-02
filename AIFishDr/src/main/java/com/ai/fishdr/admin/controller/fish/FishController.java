package com.ai.fishdr.admin.controller.fish;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.fishdr.admin.serivce.fish.IFishService;
import com.ai.fishdr.utils.RolePagingUtil;
import com.ai.fishdr.vo.FishVO;

/**
 * 
 * @Class Name :MdcinController.java
 * @Description : 관리자 어종 관리 컨트롤러
 * @Modification Information
 * @author 
 * @since  2018. 11. 14.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일             수정자             수정내용
 *    -------        -------     -------------------
 *    2018. 11. 14.     조성광             최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
@Controller
@RequestMapping("/admin/fish/")
public class FishController {
	
	@Autowired
	private IFishService service;
	
	/**
	 * 
	 *  개요 : 어류 리스트 출력
	 * @Method Name : getFishList
	 * @author : 조성광
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("fishList")
	public ModelAndView getFishList(ModelAndView model
			 	,Map<String, String> params
				,String search_keyword
				,String role
				,String currentPage
				,HttpServletRequest request
				,HttpSession session) throws Exception {
		
		List<FishVO> fishList = new ArrayList<FishVO>();
		
		if (currentPage == null) {
			currentPage = "1";
		}
		
		if (role != null) {
			if (role.equals("select")) {
				params.put("search_keyword", search_keyword);
				session.setAttribute("search_keyword", search_keyword);
			}
		}else {
			params.put("search_keyword", (String)session.getAttribute("search_keyword"));
		}
		
		
		int totalCount = service.totalCount(params);
		
		RolePagingUtil pagingUtil = new RolePagingUtil(Integer.parseInt(currentPage), totalCount, request);
		params.put("startCount", String.valueOf(pagingUtil.getStartCount()));
		params.put("endCount", String.valueOf(pagingUtil.getEndCount()));
		
		fishList = service.getFishList(params);
		
		model.addObject("paging", pagingUtil.getPagingHtmls());
		model.addObject("fishList", fishList);
		model.setViewName("admin/fish/fishList");
		
		return model;
	}
	
	/**
	 * 
	 *  개요 : 어류 정보 삭제
	 * @Method Name : deleteFish
	 * @author : 조성광
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("deleteFish")
	public ModelAndView deleteFish(String code
				,ModelAndView model) throws Exception{
		String fish_code[] = code.split(",");
		String message = "";
		int count = 0;
		for (int i = 0; i < fish_code.length; i++) {
			count += service.deleteFish(fish_code[i]);
		}
		
		if (count == fish_code.length) {
			message = count + "개의 데이터가 삭제되었습니다.";
		}else {
			message = "삭제 실패하였습니다.";
		}
		model.addObject("message", message);
		model.setViewName("redirect:fishList.do");
		return model;
	}
	
	/**
	 * 
	 *  개요 : 어류 정보 등록
	 * @Method Name : insertFish
	 * @author : 조성광
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("insertFish")
	public ModelAndView insertFish(String name
				,ModelAndView model
				,HttpSession session) throws Exception{
		
		String fish_name = URLDecoder.decode(name, "UTF-8");
		String message = "";
		
		FishVO duplicationCheck = service.duplicationCheck(fish_name);
		
		if (duplicationCheck != null) {
			message = "중복된 데이터가 있습니다.";
		}else {
			int count = service.insertFish(fish_name);
			if (count == 1 ) {
				message = "등록이 완료되었습니다.";
				session.removeAttribute("search_keyword");
			}else {
				message = "등록 실패하였습니다.";
			}
		}
		
		model.addObject("message", message);
		model.setViewName("redirect:fishList.do");
		
		return model;
	}
	
	/**
	 * 
	 *  개요 : 어류 정보 
	 * @Method Name : fishView
	 * @author : 조성광
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("fishView")
	public ModelAndView fishView(String code
				,ModelAndView model
				,FishVO fishInfo
				,Map<String, String> params) throws Exception{
		
		params.put("fish_code", code);
		fishInfo = service.fishInfo(params);
		
		model.addObject("fishInfo",fishInfo);
		
		model.setViewName("jsonConvertView");
		
		return model;
	}
	
	/**
	 * 
	 *  개요 : 어류 정보 수정
	 * @Method Name : updateFish
	 * @author : 조성광
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("updateFish")
	public ModelAndView updateFish(String code
				,String name
				,ModelAndView model
				,Map<String, String> params
				,HttpSession session) throws Exception{
		
		params.put("fish_code", code);
		params.put("fish_name", name);
		
		String message = "";
		
		FishVO duplicationCheck = service.duplicationCheck(name);
		
		if (duplicationCheck != null) {
			message = "중복된 데이터가 있습니다.";
		}else {
			int result = service.updateFish(params);
			
			if (result >= 1) {
				message = "수정이 완료 되었습니다.";
				session.removeAttribute("search_keyword");
			}else {
				message = "수정 실패하였습니다.";
			}
		}
		
		model.addObject("message", message);
		model.setViewName("redirect:fishList.do");
		
		return model;
	}
}
