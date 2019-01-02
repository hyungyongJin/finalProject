package com.ai.fishdr.admin.controller.diss_fish;

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
import com.ai.fishdr.admin.serivce.diss_fish.IDiss_fish_Service;
import com.ai.fishdr.admin.serivce.fish.IFishService;
import com.ai.fishdr.utils.RolePagingUtil;
import com.ai.fishdr.vo.DiseaseVO;
import com.ai.fishdr.vo.DissFishVO;
import com.ai.fishdr.vo.FishVO;

/**
 * 
 * @Class Name :Diss_Fish_Controller.java
 * @Description : 관리자 질병 어종 관리 컨트롤러
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
@RequestMapping("/admin/diss_fish/")
public class Diss_Fish_Controller {
	
	@Autowired
	private IDiss_fish_Service service;
	@Autowired
	private IFishService fishService;
	@Autowired
	private IDiseaseService dissService;
	
	
	/**
	 * 
	 *  개요 : 질병 어종 리스트 출력
	 * @Method Name : fish_diss_List
	 * @author : 조성광
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("diss_fish_List")
	public ModelAndView diss_fish_List(ModelAndView model
				,Map<String, String> params
				,String search_keyword
				,String search_keycode
				,String currentPage
				,String role
				,HttpSession session
				,HttpServletRequest request) throws Exception{
		
		List<DissFishVO> dissFishList = new ArrayList<DissFishVO>();
		
		if (currentPage == null) {
			currentPage = "1";
		}
		
		if (role != null) {
			if (role.equals("select")) {
				params.put("search_keyword", search_keyword);
				params.put("search_keycode", search_keycode);
				
				session.setAttribute("search_keyword", search_keyword);
				session.setAttribute("search_keycode", search_keycode);
			}
		}else {
			params.put("search_keyword", (String)session.getAttribute("search_keyword"));
			params.put("search_keycode", (String)session.getAttribute("search_keycode"));
		}
		
		int totalCount = service.totalCount(params);
		
		RolePagingUtil pagingUtil = new RolePagingUtil(Integer.parseInt(currentPage), totalCount, request);
		params.put("startCount", String.valueOf(pagingUtil.getStartCount()));
		params.put("endCount", String.valueOf(pagingUtil.getEndCount()));
		
		dissFishList = service.diss_fish_List(params);
		
		List<FishVO> fishList = fishService.fishList();
		List<DiseaseVO> dissList = dissService.dissList();
		
		model.addObject("fishList", fishList);
		model.addObject("dissList", dissList);
		model.addObject("paging", pagingUtil.getPagingHtmls());
		model.addObject("dissFishList", dissFishList);
		model.setViewName("admin/diss_fish/diss_fish_List");
		
		return model;
	}
	
	/**
	 * 
	 *  개요 : 질병 어종 등록
	 * @Method Name : diss_fish_Insert
	 * @author : 조성광
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("diss_fish_Insert")
	public ModelAndView diss_fish_Insert(ModelAndView model
				,Map<String, String> params
				,String f_code
				,String d_code
				,HttpSession session) throws Exception{
		
		params.put("diss_code",d_code.trim());
		params.put("fish_code",f_code.trim());
		
		DissFishVO duplicationCheck = service.duplicationCheck(params);
		String message = "";
		
		if (duplicationCheck != null) {
			message = "중복된 데이터가 있습니다.";
		}else {
			int count = service.diss_fish_Insert(params);
			
			if (count == 1) {
				message = "등록이 완료되었습니다.";
				session.removeAttribute("search_keyword");
			}else {
				message = "등록 실패하였습니다.";
			}
		}
		
		model.addObject("message", message);
		model.setViewName("redirect:diss_fish_List.do");
		
		return model;
		
	}
	
	/**
	 * 
	 *  개요 : 질병 어종 삭제
	 * @Method Name : diss_fish_Delete
	 * @author : 조성광
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("diss_fish_Delete")
	public ModelAndView diss_fish_Delete(ModelAndView model
				,String df_code) throws Exception {
		String diss_fish_code[] = df_code.split(",");
		
		String message = "";
		int count = 0;
		
		for (int i = 0; i < diss_fish_code.length; i++) {
			count += service.diss_fish_Delete(diss_fish_code[i]);
		}
		
		if (count == diss_fish_code.length) {
			message = count + "개의 데이터가 삭제되었습니다.";
		}else {
			message = "삭제 실패하였습니다.";
		}
		model.addObject("message", message);
		model.setViewName("redirect:diss_fish_List.do");
		return model;
	}
	
	/**
	 * 
	 *  개요 : 질병 어종 정보
	 * @Method Name : diss_fish_View
	 * @author : 조성광
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("diss_fish_View")
	public ModelAndView diss_fish_View(ModelAndView model
				,Map<String, String> params
				,String df_code) throws Exception{
		
		DissFishVO dissFishInfo = service.diss_fish_Info(df_code);
		
		model.addObject("dissFishInfo",dissFishInfo);
		model.setViewName("jsonConvertView");
		
		return model;
	}
	
	/**
	 * 
	 *  개요 : 질병 어종 수정
	 * @Method Name : diss_fish_Update
	 * @author : 조성광
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("diss_fish_Update")
	public ModelAndView diss_fish_Update(ModelAndView model
				,Map<String, String> params
				,Map<String, String> map
				,String f_code
				,String d_code
				,String of_code
				,String od_code
				,HttpSession session) throws Exception{
		
		map.put("diss_code", od_code.trim());
		map.put("fish_code", of_code.trim());
		
		DissFishVO orginal_df_code = service.duplicationCheck(map);
		String df_code = orginal_df_code.getDf_code();
		
		params.put("diss_code",d_code.trim());
		params.put("fish_code",f_code.trim());
		
		DissFishVO duplicationCheck = service.duplicationCheck(params);
		String message = "";
		
		if (duplicationCheck != null) {
			message = "중복된 데이터가 있습니다.";
		}else {
			params.put("df_code", df_code);
			int count = service.diss_fish_Update(params);
			
			if (count == 1) {
				message = "수정이 완료되었습니다.";
				session.removeAttribute("search_keyword");
			}else {
				message = "수정 실패하였습니다.";
			}
		}
		
		model.addObject("message", message);
		model.setViewName("redirect:diss_fish_List.do");
		
		return model;
	} 
}
