package com.ai.fishdr.admin.controller.hospital;

import java.net.URLEncoder;
import java.util.List;
import java.util.Map;














import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.fishdr.admin.serivce.hospital.IHospitalMgrService;
import com.ai.fishdr.utils.RolePagingUtil;
import com.ai.fishdr.vo.HospitalVO;
/**
 * @Class Name :HospitalMgrController.java
 * @Description : 질병관리원 관리 컨트롤러
 * @Modification Information
 * @author 진형용
 * @since  2018. 12. 6.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일             수정자             수정내용
 *    -------        -------     -------------------
 *    2018. 12. 6.     진형용             최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
@Controller
@RequestMapping("/admin/hospital/")
public class HospitalMgrController {
	@Autowired
	private IHospitalMgrService mgrService;
	/**
	 *  개요 : 질병관리원 리스트 출력
	 * @Method Name : hospitalList
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws :
	 */
	@RequestMapping("hospitalList")
	public ModelAndView hospitalList(ModelAndView model, String currentPage,String keyword,String search,
			Map<String,String>params, HttpServletRequest request) throws Exception{
		if (currentPage==null||currentPage=="".intern()) {
			currentPage="1";
		}
		params.put("search", search);
		params.put("keyword", keyword);
		int totalCount= mgrService.getTotalCount(params);
		RolePagingUtil page= new RolePagingUtil(Integer.parseInt(currentPage), totalCount, request);
		params.put("endCount", String.valueOf(page.getEndCount()));
		params.put("startCount", String.valueOf(page.getStartCount()));
		List<HospitalVO> list = mgrService.hospitalList(params);
		model.addObject("hospitalList",list);
		model.addObject("paging",page.getPagingHtmls());
		
		return model;
	}
	/**
	 *  개요 : 질병관리원 상세정보
	 * @Method Name : hospitalView
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws :
	 */
	@RequestMapping("hospitalView")
	public ModelAndView hospitalView(ModelAndView model, String hospital_code, Map<String,String>params) throws Exception{
		params.put("hospital_code", hospital_code);
		HospitalVO vo = mgrService.hospitalInfo(params);
		model.addObject("info",vo);
		model.setViewName("jsonConvertView");
		return model;
		
	}
	/**
	 *  개요 : 질병관리원 삭제
	 * @Method Name : deleteHospital
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : String
	 * @throws :
	 */
	@RequestMapping("deleteHospital")
	public String deleteHospital(String hospital_code) throws Exception{
		String[] code = hospital_code.split(",");
		String message = "";
		boolean result = mgrService.deleteHospital(code);
		if (result) {
			message = "?message="+code.length+URLEncoder.encode("건의 데이터를 삭제완료 하였습니다.","UTF-8");
		}
		return "redirect:/admin/hospital/hospitalList.do"+message;
	}
	/**
	 *  개요 : 질병관리원 등록
	 * @Method Name : insertHospital
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws :
	 */
	@RequestMapping("insertHospital")
	public ModelAndView insertHospital (HospitalVO vo,ModelAndView model) throws Exception{
		String result = mgrService.insertHospital(vo);
		model.addObject("result",result);
		model.setViewName("jsonConvertView");
		return model;
	}
	/**
	 *  개요 : 질병관리원 정보 수정
	 * @Method Name : updateHospital
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping("updateHospital")
	public ModelAndView updateHospital(ModelAndView model,HospitalVO vo) throws Exception{
		boolean result = mgrService.updateHospital(vo);
		String message = "";
		if (result) {
			message = "?message="+URLEncoder.encode("정보 수정완료","UTF-8");
		}
		model.setViewName("redirect:/admin/hospital/hospitalList.do"+message);
		return model;
	}
	
}
