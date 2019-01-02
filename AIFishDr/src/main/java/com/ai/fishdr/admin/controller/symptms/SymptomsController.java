package com.ai.fishdr.admin.controller.symptms;

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

import com.ai.fishdr.admin.serivce.symptms.ISymptmsService;
import com.ai.fishdr.utils.RolePagingUtil;
import com.ai.fishdr.vo.SymptomsVO;

/**
 * 
 * @Class Name :SymptomsController.java
 * @Description : 관리자 증상 관리 컨트롤러
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
@RequestMapping("/admin/symptms/")
public class SymptomsController {
	
	@Autowired
	private ISymptmsService service;
	
	/**
	 * 
	 *  개요 : 증상 리스트 출력
	 * @Method Name : getSymptmsList
	 * @author : 조성광
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("symptmsList")
	public ModelAndView getsymptmsList(ModelAndView model
			 	,Map<String, String> params
				,String search_keyword
				,String role
				,HttpSession session
				,String currentPage
				,HttpServletRequest request) throws Exception {
		
		List<SymptomsVO> symptmsList = new ArrayList<SymptomsVO>();
		
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
		
		symptmsList = service.getSymptmsList(params);
		
		model.addObject("paging", pagingUtil.getPagingHtmls());
		model.addObject("symptmsList", symptmsList);
		model.setViewName("admin/symptoms/symptomsList");
		
		return model;
	}
	
	/**
	 * 
	 *  개요 : 증상 정보 삭제
	 * @Method Name : deleteSymptms
	 * @author : 조성광
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("deleteSymptms")
	public ModelAndView deleteSymptms(String code
				,ModelAndView model) throws Exception{
		String symptms_code[] = code.split(",");
		String message = "";
		int count = 0;
		for (int i = 0; i < symptms_code.length; i++) {
			count += service.deleteSymptms(symptms_code[i]);
		}
		
		if (count == symptms_code.length) {
			message = count + "개의 데이터가 삭제되었습니다.";
		}else {
			message = "삭제 실패하였습니다.";
		}
		model.addObject("message", message);
		model.setViewName("redirect:symptmsList.do");
		return model;
	}
	
	/**
	 * 
	 *  개요 : 증상 정보 등록
	 * @Method Name : insertSymptms
	 * @author : 조성광
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("insertSymptms")
	public ModelAndView insertFish(String content
				,ModelAndView model
				,HttpSession session) throws Exception{
		String symptms_content = URLDecoder.decode(content, "UTF-8");
		String message = "";
		
		SymptomsVO duplicationCheck = service.duplicationCheck(symptms_content);
		
		if (duplicationCheck != null) {
			message = "중복된 데이터가 있습니다.";
		}else {
			int count = service.insertSymptms(symptms_content);
			if (count == 1 ) {
				message = "등록이 완료되었습니다.";
				session.removeAttribute("search_keyword");
			}else {
				message = "등록 실패하였습니다.";
			}
		}
		
		model.addObject("message", message);
		model.setViewName("redirect:symptmsList.do");
		
		return model;
	}
	
	/**
	 * 
	 *  개요 : 증상 정보 
	 * @Method Name : symptmsView
	 * @author : 조성광
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("symptmsView")
	public ModelAndView symptmsView(String code
				,ModelAndView model
				,SymptomsVO symptmsInfo
				,Map<String, String> params) throws Exception{
		
		params.put("symptms_code", code);
		symptmsInfo = service.symptmsInfo(params);
		
		model.addObject("symptmsInfo",symptmsInfo);
		
		model.setViewName("jsonConvertView");
		
		return model;
	}
	
	/**
	 * 
	 *  개요 : 증상 정보 수정
	 * @Method Name : updateSymptms
	 * @author : 조성광
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("updateSymptms")
	public ModelAndView updateSymptms(String code
				,String content
				,ModelAndView model
				,Map<String, String> params
				,HttpSession session) throws Exception{
		
		params.put("symptms_code", code);
		params.put("symptms_content", content);
		
		String message = "";
		
		SymptomsVO duplicationCheck = service.duplicationCheck(content);
		
		if (duplicationCheck != null) {
			message = "중복된 데이터가 있습니다.";
		}else {
			int result = service.updateSymptms(params);
			
			if (result >= 1) {
				message = "수정이 완료 되었습니다.";
				session.removeAttribute("search_keyword");
			}else {
				message = "수정 실패하였습니다.";
			}
		}
		
		model.addObject("message", message);
		model.setViewName("redirect:symptmsList.do");
		
		return model;
	}
}
