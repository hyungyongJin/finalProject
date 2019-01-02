package com.ai.fishdr.admin.controller.disease;

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

import com.ai.fishdr.admin.serivce.disease.IDiseaseService;
import com.ai.fishdr.utils.RolePagingUtil;
import com.ai.fishdr.vo.DiseaseVO;
import com.ai.fishdr.vo.FishVO;

/**
 * 
 * @Class Name :DiseaseController.java
 * @Description : 관리자 질병 관리 컨트롤러
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
@RequestMapping("/admin/disease/")
public class DiseaseController {
	
	@Autowired
	private IDiseaseService service;
	
	/**
	 * 
	 *  개요 : 질병 리스트 출력
	 * @Method Name : getDiseaseList
	 * @author : 조성광
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("diseaseList")
	public ModelAndView getDiseaseList(ModelAndView model
			 	,Map<String, String> params
				,String search_keyword
				,String role
				,HttpSession session
				,String currentPage
				,HttpServletRequest request) throws Exception {
		
		List<DiseaseVO> diseaseList = new ArrayList<DiseaseVO>();
		
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
		
		diseaseList = service.getDiseaseList(params);
		
		model.addObject("paging", pagingUtil.getPagingHtmls());
		model.addObject("diseaseList", diseaseList);
		model.setViewName("admin/disease/dissList");
		
		return model;
	}
	
	/**
	 * 
	 *  개요 : 질병 정보 삭제
	 * @Method Name : deleteDisease
	 * @author : 조성광
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("deleteDisease")
	public ModelAndView deleteDisease(String code
				,ModelAndView model) throws Exception{
		String diss_code[] = code.split(",");
		String message = "";
		int count = 0;
		for (int i = 0; i < diss_code.length; i++) {
			count += service.deleteDisease(diss_code[i]);
		}
		
		if (count == diss_code.length) {
			message = count + "개의 데이터가 삭제되었습니다.";
		}else {
			message = "삭제 실패하였습니다.";
		}
		model.addObject("message", message);
		model.setViewName("redirect:diseaseList.do");
		return model;
	}
	
	/**
	 * 
	 *  개요 : 질병 정보 등록
	 * @Method Name : insertDisease
	 * @author : 조성광
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("insertDisease")
	public ModelAndView insertFish(String name
				,ModelAndView model
				,HttpSession session) throws Exception{
		String diss_name = URLDecoder.decode(name, "UTF-8");
		
		DiseaseVO duplicationCheck = service.duplicationCheck(diss_name);
		String message = "";
		
		if (duplicationCheck != null ) {
			message = "중복된 데이터가 있습니다.";
		}else {
			int count = service.insertDisease(diss_name);
			
			if (count == 1 ) {
				message = "등록이 완료되었습니다.";
				session.removeAttribute("search_keyword");
			}else {
				message = "등록 실패하였습니다.";
			}
			
		}
		
		model.addObject("message", message);
		model.setViewName("redirect:diseaseList.do");
		
		return model;
	}
	
	/**
	 * 
	 *  개요 : 질병 정보 
	 * @Method Name : diseaseView
	 * @author : 조성광
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("diseaseView")
	public ModelAndView diseaseView(String code
				,ModelAndView model
				,DiseaseVO diseaseInfo
				,Map<String, String> params) throws Exception{
		
		params.put("diss_code", code);
		diseaseInfo = service.diseaseInfo(params);
		
		model.addObject("diseaseInfo",diseaseInfo);
		
		model.setViewName("jsonConvertView");
		
		return model;
	}
	
	/**
	 * 
	 *  개요 : 질병 정보 수정
	 * @Method Name : updateDisease
	 * @author : 조성광
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("updateDisease")
	public ModelAndView updateDisease(String code
				,String name
				,ModelAndView model
				,Map<String, String> params
				,HttpSession session) throws Exception{
		
		params.put("diss_code", code);
		params.put("diss_name", name);
		
		String message = "";
		
		DiseaseVO duplicationCheck = service.duplicationCheck(name);
		
		if (duplicationCheck != null) {
			message = "중복된 데이터가 있습니다.";
		}else {
			int result = service.updateDisease(params);
			
			if (result >= 1) {
				message = "수정이 완료 되었습니다.";
				session.removeAttribute("search_keyword");
			}else {
				message = "수정 실패하였습니다.";
			}
		}
		
		model.addObject("message", message);
		model.setViewName("redirect:diseaseList.do");
		
		return model;
	}

}
