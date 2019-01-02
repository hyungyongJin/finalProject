package com.ai.fishdr.admin.controller.mdcin_diss;

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
import com.ai.fishdr.admin.serivce.mdcin.IMdcinAdminService;
import com.ai.fishdr.admin.serivce.mdcin_diss.IMdcin_diss_Service;
import com.ai.fishdr.utils.RolePagingUtil;
import com.ai.fishdr.vo.DiseaseVO;
import com.ai.fishdr.vo.MdcinDissVO;
import com.ai.fishdr.vo.MedicineVO;

/**
 * 
 * @Class Name :Mdcin_Diss_Controller.java
 * @Description : 관리자 의약품 의약품 관리 컨트롤러
 * @Modification Information
 * @author 
 * @since  2018. 11. 18.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일             수정자             수정내용
 *    -------        -------     -------------------
 *    2018. 11. 18.     조성광             최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
@Controller
@RequestMapping("/admin/mdcin_diss/")
public class Mdcin_Diss_Controller {

	@Autowired
	private IMdcin_diss_Service service;
	@Autowired
	private IMdcinAdminService mdcinService;
	@Autowired
	private IDiseaseService dissService;
	
	
	/**
	 * 
	 *  개요 : 의약품 어종 리스트 출력
	 * @Method Name : mdcin_diss_List
	 * @author : 조성광
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("mdcin_diss_List")
	public ModelAndView mdcin_diss_List(ModelAndView model
				,Map<String, String> params
				,String search_keyword
				,String search_keycode
				,String currentPage
				,String role
				,HttpSession session
				,HttpServletRequest request) throws Exception{
		
		List<MdcinDissVO> mdcinDissList = new ArrayList<MdcinDissVO>();
		
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
		
		mdcinDissList = service.mdcin_diss_List(params);
		
		List<MedicineVO> mdcinList = mdcinService.mdcinList();
		List<DiseaseVO> dissList = dissService.dissList();
		
		model.addObject("mdcinList", mdcinList);
		model.addObject("dissList", dissList);
		model.addObject("paging", pagingUtil.getPagingHtmls());
		model.addObject("mdcinDissList", mdcinDissList);
		model.setViewName("admin/mdcin_diss/mdcin_diss_List");
		
		return model;
	}
	
	/**
	 * 
	 *  개요 : 의약품 어종 등록
	 * @Method Name : mdcin_diss_Insert
	 * @author : 조성광
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("mdcin_diss_Insert")
	public ModelAndView mdcin_diss_Insert(ModelAndView model
				,Map<String, String> params
				,String m_code
				,String d_code
				,HttpSession session) throws Exception{
		
		params.put("diss_code",d_code.trim());
		params.put("mdcin_code",m_code.trim());
		
		MdcinDissVO duplicationCheck = service.duplicationCheck(params);
		String message = "";
		
		if (duplicationCheck != null) {
			message = "중복된 데이터가 있습니다.";
		}else {
			int count = service.mdcin_diss_Insert(params);
			
			if (count == 1) {
				message = "등록이 완료되었습니다.";
				session.removeAttribute("search_keyword");
			}else {
				message = "등록 실패하였습니다.";
			}
		}
		
		model.addObject("message", message);
		model.setViewName("redirect:mdcin_diss_List.do");
		
		return model;
		
	}
	
	/**
	 * 
	 *  개요 : 의약품 어종 삭제
	 * @Method Name : mdcin_diss_Delete
	 * @author : 조성광
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("mdcin_diss_Delete")
	public ModelAndView mdcin_diss_Delete(ModelAndView model
				,String md_code) throws Exception {
		
		String mdcin_diss_code[] = md_code.split(",");
		
		String message = "";
		int count = 0;
		
		for (int i = 0; i < mdcin_diss_code.length; i++) {
			count += service.mdcin_diss_Delete(mdcin_diss_code[i]);
		}
		
		if (count == mdcin_diss_code.length) {
			message = count + "개의 데이터가 삭제되었습니다.";
		}else {
			message = "삭제 실패하였습니다.";
		}
		model.addObject("message", message);
		model.setViewName("redirect:mdcin_diss_List.do");
		return model;
	}
	
	/**
	 * 
	 *  개요 : 의약품 어종 정보
	 * @Method Name : mdcin_diss_View
	 * @author : 조성광
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("mdcin_diss_View")
	public ModelAndView mdcin_diss_View(ModelAndView model
				,Map<String, String> params
				,String md_code) throws Exception{
		
		MdcinDissVO mdcinDissInfo = service.mdcin_diss_Info(md_code);
		
		model.addObject("mdcinDissInfo",mdcinDissInfo);
		model.setViewName("jsonConvertView");
		
		return model;
	}
	
	/**
	 * 
	 *  개요 : 의약품 어종 수정
	 * @Method Name : mdcin_diss_Update
	 * @author : 조성광
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("mdcin_diss_Update")
	public ModelAndView mdcin_diss_Update(ModelAndView model
				,Map<String, String> params
				,Map<String, String> map
				,String m_code
				,String d_code
				,String om_code
				,String od_code
				,HttpSession session
				,HttpServletRequest request) throws Exception{
		
		map.put("diss_code", od_code.trim());
		map.put("mdcin_code", om_code.trim());
		
		MdcinDissVO orginal_md_code = service.duplicationCheck(map);
		String md_code = orginal_md_code.getMd_code();
		
		params.put("diss_code",d_code.trim());
		params.put("mdcin_code",m_code.trim());
		
		MdcinDissVO duplicationCheck = service.duplicationCheck(params);
		String message = "";
		
		if (duplicationCheck != null) {
			message = "중복된 데이터가 있습니다.";
		}else {
			params.put("md_code", md_code);
			int count = service.mdcin_diss_Update(params);
			
			if (count == 1) {
				message = "수정이 완료되었습니다.";
				session.setAttribute("message", message);
			}else {
				message = "수정 실패하였습니다.";
			}
		}
		session.removeAttribute("search_keyword");
		
		model.addObject("message", message);
		model.setViewName("redirect:/admin/mdcin_diss/mdcin_diss_List.do");
		
		return model;
	} 
}
