package com.ai.fishdr.admin.controller.symptms_diss;

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
import com.ai.fishdr.admin.serivce.symptms.ISymptmsService;
import com.ai.fishdr.admin.serivce.symptms_diss.ISymptms_diss_Service;
import com.ai.fishdr.utils.RolePagingUtil;
import com.ai.fishdr.vo.DiseaseVO;
import com.ai.fishdr.vo.DissFishVO;
import com.ai.fishdr.vo.FishVO;
import com.ai.fishdr.vo.SymptmsDissVO;
import com.ai.fishdr.vo.SymptomsVO;

@Controller
@RequestMapping("/admin/symptms_diss/")
public class Symptms_Diss_Controller {

	@Autowired
	private ISymptms_diss_Service service;
	@Autowired
	private ISymptmsService symptmsService;
	@Autowired
	private IDiseaseService dissService;

	/**
	 * 
	 * 개요 : 증상 질병 리스트 출력
	 * 
	 * @Method Name : symptms_diss_List
	 * @author : 조성광 -----------------------------------
	 * @param :
	 * @return : ModelAndView
	 * @throws Exception
	 */
	@RequestMapping("symptms_diss_List")
	public ModelAndView symptms_diss_List(ModelAndView model,
				Map<String, String> params
				,String search_keyword
				,String search_keycode
				,String role
				,HttpSession session
				,String currentPage,
				HttpServletRequest request) throws Exception {

		List<SymptmsDissVO> symptmsDissList = new ArrayList<SymptmsDissVO>();

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

		RolePagingUtil pagingUtil = new RolePagingUtil(
				Integer.parseInt(currentPage), totalCount, request);
		params.put("startCount", String.valueOf(pagingUtil.getStartCount()));
		params.put("endCount", String.valueOf(pagingUtil.getEndCount()));

		symptmsDissList = service.symptms_diss_List(params);

		List<SymptomsVO> symptmsList = symptmsService.symptmsList();
		List<DiseaseVO> dissList = dissService.dissList();

		model.addObject("symptmsList", symptmsList);
		model.addObject("dissList", dissList);
		model.addObject("paging", pagingUtil.getPagingHtmls());
		model.addObject("symptmsDissList", symptmsDissList);
		model.setViewName("admin/symptms_diss/symptms_diss_List");

		return model;
	}

	/**
	 * 
	 * 개요 : 증상 질병 등록
	 * 
	 * @Method Name : symptms_diss_Insert
	 * @author : 조성광 -----------------------------------
	 * @param :
	 * @return : ModelAndView
	 * @throws Exception
	 */
	@RequestMapping("symptms_diss_Insert")
	public ModelAndView symptms_diss_Insert(ModelAndView model,
				Map<String, String> params
				,String s_code
				,String d_code
				,HttpSession session) throws Exception {

		params.put("diss_code", d_code.trim());
		params.put("symptms_code", s_code.trim());

		SymptmsDissVO duplicationCheck = service.duplicationCheck(params);
		String message = "";

		if (duplicationCheck != null) {
			message = "중복된 데이터가 있습니다.";
		} else {
			int count = service.symptms_diss_Insert(params);

			if (count == 1) {
				message = "등록이 완료되었습니다.";
				session.removeAttribute("search_keyword");
			} else {
				message = "등록 실패하였습니다.";
			}
		}

		model.addObject("message", message);
		model.setViewName("redirect:symptms_diss_List.do");

		return model;

	}

	/**
	 * 
	 * 개요 : 증상 질병 삭제
	 * 
	 * @Method Name : symptms_diss_Delete
	 * @author : 조성광 -----------------------------------
	 * @param :
	 * @return : ModelAndView
	 * @throws Exception
	 */
	@RequestMapping("symptms_diss_Delete")
	public ModelAndView symptms_diss_Delete(ModelAndView model
				,String sd_code)throws Exception {
		
		String symptms_diss_code[] = sd_code.split(",");

		String message = "";
		int count = 0;

		for (int i = 0; i < symptms_diss_code.length; i++) {
			count += service.symptms_diss_Delete(symptms_diss_code[i]);
		}

		if (count == symptms_diss_code.length) {
			message = count + "개의 데이터가 삭제되었습니다.";
		} else {
			message = "삭제 실패하였습니다.";
		}
		model.addObject("message", message);
		model.setViewName("redirect:symptms_diss_List.do");
		return model;
	}

	/**
	 * 
	 * 개요 : 증상 질병 정보
	 * 
	 * @Method Name : symptms_diss_View
	 * @author : 조성광 -----------------------------------
	 * @param :
	 * @return : ModelAndView
	 * @throws Exception
	 */
	@RequestMapping("symptms_diss_View")
	public ModelAndView symptms_diss_View(ModelAndView model
				,Map<String, String> params
				,String sd_code) throws Exception {

		SymptmsDissVO symptmsDissInfo = service.symptms_diss_Info(sd_code);

		model.addObject("symptmsDissInfo", symptmsDissInfo);
		model.setViewName("jsonConvertView");

		return model;
	}
	
	/**
	 * 
	 * 개요 : 증상 질병 수정
	 * 
	 * @Method Name : symptms_diss_Update
	 * @author : 조성광 -----------------------------------
	 * @param :
	 * @return : ModelAndView
	 * @throws Exception
	 */
	@RequestMapping("symptms_diss_Update")
	public ModelAndView diss_fish_Update(ModelAndView model
				,Map<String, String> params
				,Map<String, String> map
				,String s_code
				,String d_code
				,String os_code
				,String od_code
				,HttpSession session) throws Exception{
		
		map.put("diss_code", od_code.trim());
		map.put("symptms_code", os_code.trim());
		
		SymptmsDissVO orginal_sd_code = service.duplicationCheck(map);
		String sd_code = orginal_sd_code.getSd_code();
		
		params.put("diss_code",d_code.trim());
		params.put("symptms_code",s_code.trim());
		
		SymptmsDissVO duplicationCheck = service.duplicationCheck(params);
		String message = "";
		
		if (duplicationCheck != null) {
			message = "중복된 데이터가 있습니다.";
		}else {
			params.put("sd_code", sd_code);
			int count = service.symptms_diss_Update(params);
			
			if (count == 1) {
				message = "수정이 완료되었습니다.";
				session.removeAttribute("search_keyword");
			}else {
				message = "수정 실패하였습니다.";
			}
		}
		
		model.addObject("message", message);
		model.setViewName("redirect:symptms_diss_List.do");
		
		return model;
	}
}
