package com.ai.fishdr.admin.controller.capacity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.fishdr.admin.serivce.capacity.ICapacityService;
import com.ai.fishdr.admin.serivce.fish.IFishService;
import com.ai.fishdr.admin.serivce.mdcin.IMdcinAdminService;
import com.ai.fishdr.utils.RolePagingUtil;
import com.ai.fishdr.vo.CapacityUsageVO;
import com.ai.fishdr.vo.FishVO;
import com.ai.fishdr.vo.MedicineVO;


/**
 * 
 * @Class Name :CapacityController.java
 * @Description : 용법및 용량
 * @Modification Information
 * @author 
 * @since  2018. 11. 15.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일            수정자      수정내용
 *    ------------      -------     -------------------
 *    2018. 11. 15.     임범학      최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
@Controller
@RequestMapping("/admin/capacity/")
public class CapacityController {

		@Autowired
		private ICapacityService service;
	
		@Resource
		private IFishService fishService;
		
		@Autowired
		private IMdcinAdminService mdcinService;
		
		
		/**
		 * 
		 *  개요 :  용법및 용량 수정 화면
		 * @Method Name : capacityUpdate
		 * @author : 임범학
		 * -----------------------------------
		 * @param : ModelAndView model
											, Map<String,String> params
											, String uscp_code
		 * @return : ModelAndView
		 * @throws Exception 
		 * @throws :
		 */
		@RequestMapping("capacityInfo")
		public ModelAndView capacityUpdate(ModelAndView model
											, Map<String,String> params
											, String uscp_code
				) throws Exception{
			
			params.put("uscp_code", uscp_code);
			
			CapacityUsageVO info =  service.getInfo(params);
			
			model.addObject("info", info);
			model.setViewName("jsonConvertView");
			
			return model;
		}
		
		/**
		 * 
		 *  개요 :  용법및 용량 리스트 출력
		 * @Method Name : capacityList
		 * @author : 임범학
		 * -----------------------------------
		 * @param : ModelAndView model,
											String search,
											String keyword,
											String currentPage,
											HttpServletRequest request,
											String message
		 * @return : ModelAndView
		 * @throws Exception 
		 * @throws :
		 */
		@RequestMapping("capacityList")
		public ModelAndView capacityList(ModelAndView model,
											String search,
											String keyword,
											String currentPage,
											String role,
											HttpServletRequest request,
											String message,
											HttpSession session
											) throws Exception{
			if(currentPage==null||currentPage.intern() =="".intern()){
				currentPage = "1";
			}
			
			Map<String, String> params = new HashMap<String, String>();
			if (role != null) {
				if (role.equals("select")) {
					params.put("search", search);
					params.put("keyword", keyword);
					session.setAttribute("search", search);
					session.setAttribute("keyword", keyword);
				}
			}else{
				params.put("search", (String)session.getAttribute("search"));
				params.put("keyword", (String)session.getAttribute("keyword"));
			}
			
			int totalCount = service.getTotalCount(params);
			RolePagingUtil paginUtil = new RolePagingUtil(Integer.parseInt(currentPage),totalCount,request);
			
			params.put("startCount", String.valueOf(paginUtil.getStartCount()));
			params.put("endCount", String.valueOf(paginUtil.getEndCount()));
			
			List<CapacityUsageVO> CapacityList= service.getCapacityList(params);
			
			List<FishVO> fishList= fishService.fishList();
			List<MedicineVO> mdcinList = mdcinService.mdcinList();
			
			model.addObject("message", message);
			model.addObject("mdcinList", mdcinList);
			model.addObject("fishList",fishList);
			model.addObject("CapacityPaging",paginUtil.getPagingHtmls());
			model.addObject("CapacityList", CapacityList);
			model.setViewName("admin/capacity/capacityList");
			
			return model;
		}
		
		
		/**
		 * 
		 *  개요 :  용법및 용량 수정
		 * @Method Name : capacityUpdate
		 * @author : 임범학
		 * -----------------------------------
		 * @param : ModelAndView model
											, String uscp_code
											, String fish_code
											, String mdcin_code
											, String uscp_content
											,Map<String,String> params
		 * @return : ModelAndView
		 * @throws Exception 
		 * @throws :
		 */
		@RequestMapping("capacityUpdate")
		public ModelAndView capacityUpdate(ModelAndView model
											, String uscp_code
											, String fish_code
											, String mdcin_code
											, String uscp_content
											,Map<String,String> params
											,HttpSession session
									) throws Exception{
			params.put("fish_code", fish_code);
			params.put("mdcin_code", mdcin_code);
			CapacityUsageVO capaCheck = service.capacityCheck(params);
			
			params.put("uscp_content", uscp_content);
			params.put("uscp_code", uscp_code);
			
			String message = null;
			int bb = 0;
			if (capaCheck != null) {
				message="중복된 데이터가 존재합니다";
				
				if(!capaCheck.getUscp_content().isEmpty() && capaCheck.getUscp_code().trim().equals(uscp_code)){
					Map<String, String> contentParam = new HashMap<String, String>();
					contentParam.put("uscp_content", uscp_content);
					contentParam.put("uscp_code", uscp_code);
					
					bb = service.capacityUpdate(contentParam);
					
					if (bb==0) {
						message="수정실패";
					}else{
						message="수정성공";
						session.removeAttribute("keyword");
					}
				}
				
				if(capaCheck.getUscp_content().trim().equals(uscp_content.trim())){
					message="중복된 데이터가 존재합니다";
				}
			}else{
				bb = service.capacityUpdate(params);
				
				if (bb==0) {
					message="수정실패";
				}else{
					message="수정성공";
					session.removeAttribute("keyword");
				}
			}
			
			
			
			model.addObject("message", message);
			model.setViewName("redirect:capacityList.do");
			
			return model;
		}
		
		
		/**
		 * 
		 *  개요 :  용법및 용량 등록
		 * @Method Name : capacityInsert
		 * @author : 임범학
		 * -----------------------------------
		 * @param : ModelAndView model
				, String uscp_code
				, String fish_code
				, String mdcin_code
				, String uscp_content
				,Map<String,String> params
		 * @return : ModelAndView
		 * @throws Exception 
		 * @throws :
		 */
		@RequestMapping("capacityInsert")
		public ModelAndView capacityInsert(ModelAndView model
				, String uscp_code
				, String fish_code
				, String mdcin_code
				, String uscp_content
				,Map<String,String> params
				,HttpSession session
				) throws Exception{
			
			params.put("fish_code", fish_code);
			params.put("mdcin_code", mdcin_code);
			
			int aa = 0;
			String message= null;
			
			CapacityUsageVO cuVO = service.capacityCheck(params);
			
//			params.put("uscp_code", uscp_code);
			
					
			if(cuVO != null){
				message="중복된 데이터가 존재합니다";
			}else{
				
				params.put("uscp_content", uscp_content);
				
				aa = service.capacityInsert(params);
				
				if(aa == 0){
					message="등록실패하였습니다";
				}else{
					message="등록되었습니다";
					session.removeAttribute("keyword");
				}
			}
			
			
			model.addObject("message", message);
			model.setViewName("redirect:/admin/capacity/capacityList.do");
			
			return model;
		}
		
		
		/**
		 * 
		 *  개요 :  용법및 용량 삭제
		 * @Method Name : capacityDelete
		 * @author : 임범학
		 * -----------------------------------
		 * @param : ModelAndView model,
											String[] uscp_code,
											Map<String,String> params
		 * @return : ModelAndView
		 * @throws Exception 
		 * @throws :
		 */
		@RequestMapping("capacityDelete")		
		public ModelAndView capacityDelete(ModelAndView model,
											String[] uscp_code,
											Map<String,String> params
											)throws Exception{
			String message = null;
			
			for (int i = 0; i < uscp_code.length; i++) {
				params.put("uscp_code", uscp_code[i]);
				
				service.capacityDelete(params);
			}
			
			
			message = "삭제 성공";
			model.addObject("message", message);
			
			
			model.setViewName("redirect:/admin/capacity/capacityList.do");
			
			return model;			
			
		}
}












