package com.ai.fishdr.admin.controller.mdcin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.fishdr.admin.serivce.mdcin.IMdcinAdminService;
import com.ai.fishdr.user.service.mdcin.IMdcinService;
import com.ai.fishdr.user.service.mdcin_category.IMdcinCategoryService;
import com.ai.fishdr.utils.RolePagingUtil;
import com.ai.fishdr.vo.MedicineCategoryVO;
import com.ai.fishdr.vo.MedicineVO;

/**
 * 
 * @Class Name :MdcinController.java
 * @Description : 관리자 의약품 관리 컨트롤러
 * @Modification Information
 * @author 
 * @since  2018. 11. 12.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일             수정자             수정내용
 *    -------        -------     -------------------
 *    2018. 11. 12.     조성광             최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
@Controller
@RequestMapping("/admin/mdcin/")
public class MdcinAdminController {
	
	@Autowired
	private IMdcinAdminService service;
	@Autowired
	private IMdcinCategoryService cateService;
	
	@Autowired
	private IMdcinService mdcinService;
	
	/**
	 * 
	 *  개요 : 의약품 리스트 출력
	 * @Method Name : getMdcinList
	 * @author : 조성광
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("mdcinList")
	public ModelAndView getMdcinList(ModelAndView model
				,Map<String, String> params
				,String search_L_keycode
				,String search_M_keycode
				,String search_keyword
				,String currentPage
				,String role
				,HttpSession session
				,HttpServletRequest request) throws Exception{
		
		List<MedicineVO> mdcinList = new ArrayList<MedicineVO>();
		List<MedicineCategoryVO> mdcinCategoryList = new ArrayList<MedicineCategoryVO>();
		
		if (currentPage == null) {
			currentPage = "1";
		}
		
		if (role != null) {
			if (role.equals("select")) {
				params.put("search_L_keycode", search_L_keycode);
				params.put("search_M_keycode", search_M_keycode);
				params.put("search_keyword", search_keyword);
				session.setAttribute("search_L_keycode", search_L_keycode);
				session.setAttribute("search_M_keycode", search_M_keycode);
				session.setAttribute("search_keyword", search_keyword);
			}
		}else {
			params.put("search_L_keycode", (String)session.getAttribute("search_L_keycode"));
			params.put("search_M_keycode", (String)session.getAttribute("search_M_keycode"));
			params.put("search_keyword", (String)session.getAttribute("search_keyword"));
		}
		
		
		
		int totalCount = service.totalCount(params);
		
		RolePagingUtil pagingUtil = new RolePagingUtil(Integer.parseInt(currentPage), totalCount, request);
		params.put("startCount", String.valueOf(pagingUtil.getStartCount()));
		params.put("endCount", String.valueOf(pagingUtil.getEndCount()));
		
		mdcinList = service.getMdcinList(params);
		mdcinCategoryList = cateService.getMdcinCategoryList();
		
		// 의약품 점수 매기기
		List<String> medicineScoreList = new ArrayList<String>();
		
		for (int i = 0 ; i < mdcinList.size() ; i++) {
			
			int medicineCount = mdcinService.medicineCount(mdcinList.get(i).getMdcin_code());
			
			int totalMedicineScore = mdcinService.totalMedicineScore(mdcinList.get(i).getMdcin_code());
			
			if (totalMedicineScore == 0) {
				
				medicineScoreList.add("0");
				
			} else {
				
				float averageMedicineScore = (float) (Math.round((totalMedicineScore / medicineCount) * 10) / 10.0);
				
				String changeAMS = Float.toString(averageMedicineScore);
				
				medicineScoreList.add(changeAMS);
				
			}
						
		}
		
		model.addObject("medicineScoreList", medicineScoreList);
		
		model.addObject("paging", pagingUtil.getPagingHtmls());
		model.addObject("mdcincate", mdcinCategoryList);
		model.addObject("mdcinList", mdcinList);
		model.setViewName("admin/mdcin/mdcinList");
		return model;
	}
	
	/**
	 * 
	 *  개요 : 의약품 정보 삭제
	 * @Method Name : deleteMdcin
	 * @author : 조성광
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("deleteMdcin")
	public ModelAndView deleteMdcin(String code
				,ModelAndView model) throws Exception{
		String mdcin_code[] = code.split(",");
		String message = "";
		int count = 0;
		for (int i = 0; i < mdcin_code.length; i++) {
			count += service.deleteMdcin(mdcin_code[i]);
		}
		
		if (count == mdcin_code.length) {
			message = count + "개의 데이터가 삭제되었습니다.";
		}else {
			message = "삭제 실패하였습니다.";
		}
		model.addObject("message", message);
		model.setViewName("redirect:mdcinList.do");
		return model;
	}
	
	/**
	 * 
	 *  개요 : 의약품 정보 등록
	 * @Method Name : insertMdcin
	 * @author : 조성광
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("insertMdcin")
	public ModelAndView insertMdcin(MedicineVO mdcinInfo
				,String mdcinCate
				,ModelAndView model
				,HttpSession session) throws Exception{
		
		List<MedicineCategoryVO> cateList = cateService.getMdcinCategoryList();
		
		String ctgry_code = "";
		for (int i = 0; i < cateList.size(); i++) {
			if (cateList.get(i).getCtgry_name().equals(mdcinCate)) {
				ctgry_code = cateList.get(i).getCtgry_code();
			}
		}
		
		mdcinInfo.setCtgry_code(ctgry_code);
		
		int count = service.insertMdcin(mdcinInfo);
		String message = "";
		
		if (count == 1 ) {
			message = "등록이 완료되었습니다.";
			session.removeAttribute("search_keyword");
		}else {
			message = "등록 실패하였습니다.";
		}
		
		
		model.addObject("message", message);
		model.setViewName("redirect:mdcinList.do");
		
		return model;
	}
	
	@RequestMapping("mdcinView")
	public ModelAndView getMdicinView(String code
				,ModelAndView model
				,Map<String, String> params
				,MedicineVO mdcinInfo
				,MedicineCategoryVO mdcinCateInfo) throws Exception {
		
		mdcinInfo = service.getMdcinInfo(code);
		params.put("ctgry_code", mdcinInfo.getCtgry_code());
		mdcinCateInfo = cateService.getMdcinCategoryInfo(params);
		
		model.addObject("mdcinInfo", mdcinInfo);
		model.addObject("mdcinCateInfo", mdcinCateInfo);
		
		model.setViewName("jsonConvertView");
		
		return model;
	}
	
	/**
	 * 
	 *  개요 : 의약품 정보 수정
	 * @Method Name : updateMdcin
	 * @author : 조성광
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("updateMdcin")
	public ModelAndView updateMdcin(MedicineVO mdcinInfo
				,String ctgry_name
				,ModelAndView model
				,Map<String, String> params
				,HttpSession session) throws Exception{
		
		List<MedicineCategoryVO> cateList = cateService.getMdcinCategoryList();
		
		String ctgry_code = "";
		for (int i = 0; i < cateList.size(); i++) {
			if (cateList.get(i).getCtgry_name().equals(ctgry_name)) {
				ctgry_code = cateList.get(i).getCtgry_code();
			}
		}
		
		mdcinInfo.setCtgry_code(ctgry_code);
		String message = "";
		int result = service.updateMdcin(mdcinInfo);
		
		if (result >= 1) {
			message = "수정이 완료 되었습니다.";
			session.removeAttribute("search_keyword");
		}else {
			message = "수정 실패하였습니다.";
		}
		
		model.addObject("message", message);
		model.setViewName("redirect:mdcinList.do");
		
		return model;
	}
	
}
