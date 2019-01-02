package com.ai.fishdr.user.controller.mdcin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.fishdr.user.service.facepicture.IFacePictureService;
import com.ai.fishdr.user.service.mdcin.IMdcinService;
import com.ai.fishdr.user.service.mdcin_category.IMdcinCategoryService;
import com.ai.fishdr.utils.RolePagingUtil;
import com.ai.fishdr.vo.MedicineCategoryVO;
import com.ai.fishdr.vo.MedicineVO;
import com.ai.fishdr.vo.MemberVO;
/**
 * 
 * @Class Name :MdcinController.java
 * @Description : 회원 의약품 관리 컨트롤러
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
@RequestMapping("/user/mdcin/")
public class MdcinUserController {
	
	@Autowired
	private IMdcinService service;
	@Autowired
	private IMdcinCategoryService cateService;
	
	@Autowired
	private IFacePictureService facePictureService;
	
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
				,HttpServletRequest request
				,HttpSession session) throws Exception{
		
		
		List<MedicineVO> mdcinList = new ArrayList<MedicineVO>();
		List<MedicineCategoryVO> mdcinCategoryList = new ArrayList<MedicineCategoryVO>();
		
		if (currentPage == null) {
			currentPage = "1";
		}
		
		
		params.put("search_L_keycode", search_L_keycode);
		params.put("search_M_keycode", search_M_keycode);
		params.put("search_keyword", search_keyword);
		
		int totalCount = service.totalCount(params);
		
		RolePagingUtil pagingUtil = new RolePagingUtil(Integer.parseInt(currentPage), totalCount, request);
		params.put("startCount", String.valueOf(pagingUtil.getStartCount()));
		params.put("endCount", String.valueOf(pagingUtil.getEndCount()));
		
		mdcinList = service.getMdcinList(params);
		mdcinCategoryList = cateService.getMdcinCategoryList();
		
		
		// 의약품 점수 매기기
		List<String> medicineScoreList = new ArrayList<String>();
		
		for (int i = 0 ; i < mdcinList.size() ; i++) {
			
			int medicineCount = service.medicineCount(mdcinList.get(i).getMdcin_code());
			
			int totalMedicineScore = service.totalMedicineScore(mdcinList.get(i).getMdcin_code());
			
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
		model.setViewName("user/mdcin/mdcinList");
		return model;
	}
	
	@RequestMapping("mdcinView")
	public ModelAndView getMdicinView(String code
				,ModelAndView model
				,Map<String, String> params
				,MedicineVO mdcinInfo
				,MedicineCategoryVO mdcinCateInfo) throws Exception {
		
		// 의약품 조회수 증가
		service.updateHit(code);
		
		mdcinInfo = service.getMdcinInfo(code);
		params.put("ctgry_code", mdcinInfo.getCtgry_code());
		mdcinCateInfo = cateService.getMdcinCategoryInfo(params);
		
		
		model.addObject("mdcinInfo", mdcinInfo);
		model.addObject("mdcinCateInfo", mdcinCateInfo);
		
		
		
		model.setViewName("jsonConvertView");
		
		
		return model;
	}
	
	
}
