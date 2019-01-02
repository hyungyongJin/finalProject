package com.ai.fishdr.admin.controller.withDrawal;

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

import com.ai.fishdr.admin.serivce.fish.IFishService;
import com.ai.fishdr.admin.serivce.mdcin.IMdcinAdminService;
import com.ai.fishdr.admin.serivce.whthDrawal.IWithDrawalService;
import com.ai.fishdr.utils.RolePagingUtil;
import com.ai.fishdr.vo.FishVO;
import com.ai.fishdr.vo.MedicineVO;
import com.ai.fishdr.vo.WithdrawalVO;


/**
 * 
 * @Class Name :CapacityController.java
 * @Description : 휴약기간
 * @Modification Information
 * @author 
 * @since  2018. 11. 21.
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
@RequestMapping("/admin/withDrawal/")
public class WithDrawalController {
	
	@Resource
	private IWithDrawalService service;
	
	@Resource
	private IFishService fishService;
	
	@Autowired
	private IMdcinAdminService mdcinService;
	
	
	
	/**
	 * 
	 *  개요 :  휴약기간 삭제
	 * @Method Name : withDrawalDelete
	 * @author : 임범학
	 * -----------------------------------
	 * @param : ModelAndView model,
										String[] uscp_code,
										Map<String,String> params
	 * @return : ModelAndView
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping("withDrawalDelete")
	public ModelAndView withDrawalDelete(ModelAndView model,
											Map<String, String> params,
											String[] withdrawal_code)throws Exception{
		
		String message= null;
		
		for (int i = 0; i < withdrawal_code.length; i++) {
			params.put("withdrawal_code",withdrawal_code[i]);
			
			service.withDrawalDelete(params);
		}
		
		message="삭제성공";
		
		model.addObject("message", message);
		model.setViewName("redirect:/admin/withDrawal/withDrawalList.do");
		return model;
	}

	/**
	 * 
	 *  개요 :  휴약기간 등록
	 * @Method Name : withDrawalInsert
	 * @author : 임범학
	 * -----------------------------------
	 * @param : ModelAndView model
										, WithdrawalVO withVO	
	 * @return : ModelAndView
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping("withDrawalInsert")
	public ModelAndView withDrawalInsert(ModelAndView model
										, WithdrawalVO withVO
										,HttpSession session
										)throws Exception{
		String aa=null;
		String message=null;
		
		Map<String, String > params = new HashMap<String,String>();
		params.put("fish_code", withVO.getFish_code());
		params.put("mdcin_code", withVO.getMdcin_code());
		
		WithdrawalVO withCheck= service.withCheck(params);
		
		
		if(withCheck != null){
			message="중복된 데이터가 존재 합니다";
		}else{
			
			aa = service.withDrawalInsert(withVO);
			
			if(aa==null){
				message="등록완료되었습니다";
				session.removeAttribute("keyword");
			}else {
				message="등록실패";
			}
		}
			
		
		
		model.addObject("message", message);
		model.setViewName("redirect:/admin/withDrawal/withDrawalList.do");
		
		return model;
	}
	
	/**
	 * 
	 *  개요 :  휴약기간 화면
	 * @Method Name : withDrawalInfo
	 * @author : 임범학
	 * -----------------------------------
	 * @param :ModelAndView model,
										String withdrawal_code,
										Map<String, String> params
	 * @return : ModelAndView
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping("withDrawalInfo")
	public ModelAndView withDrawalInfo(ModelAndView model,
										String withdrawal_code,
										Map<String, String> params
										)throws Exception{
		
		params.put("withdrawal_code", withdrawal_code);
		
		WithdrawalVO vo = service.getWithDrawalInfo(params);
		
		
		
		model.addObject("info", vo);
		model.setViewName("jsonConvertView");
		
		return model;
	}
	
	/**
	 * 
	 *  개요 :  휴약기간 수정
	 * @Method Name : withDrawalUpdate
	 * @author : 임범학
	 * -----------------------------------
	 * @param :ModelAndView model
										,WithdrawalVO vo
										,Map<String,String> params	
	 * @return : ModelAndView
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping("withDrawalUpdate")
	public ModelAndView withDrawalUpdate(ModelAndView model
										,WithdrawalVO vo
										,Map<String,String> params	
										,HttpSession session
										) throws Exception{
		
		String message = null;
		int a=0;
		params.put("fish_code", vo.getFish_code());
		params.put("mdcin_code", vo.getMdcin_code());
		
		WithdrawalVO withCheck =  service.withCheck(params);
		
		if (withCheck != null) {
			message= "중복된 데이터가 존재 합니다";
			
			if(!withCheck.getWithdrawal_period().isEmpty() &&
					withCheck.getWithdrawal_code().trim().equals(vo.getWithdrawal_code())){
				WithdrawalVO wdVO = new WithdrawalVO();
				wdVO.setWithdrawal_code(vo.getWithdrawal_code());
				wdVO.setWithdrawal_period(vo.getWithdrawal_period());	
				
				a=(int) service.getWithDrawalUpdate(wdVO);
				
				if(a == 0){
					message = "수정실패되었습니다";
				}else{
					message= "수정완료 되었습니다";
					session.removeAttribute("keyword");
				}
			}
			
			if (withCheck.getWithdrawal_period().trim().equals(vo.getWithdrawal_period().trim())) {
				message = "중복된 데이터가 존재합니다";
			}
		}else{
			a=(int) service.getWithDrawalUpdate(vo);
			
			if(a == 0){
				message = "수정실패되었습니다";
			}else{
				message= "수정완료 되었습니다";
				session.removeAttribute("keyword");
			}
			
		}
		
		model.addObject("message", message);
		model.setViewName("redirect:/admin/withDrawal/withDrawalList.do");
		
		return model;
	}
	
	
	/**
	 * 
	 *  개요 :  휴약기간 리스트 출력
	 * @Method Name : withDrawalList
	 * @author : 임범학
	 * -----------------------------------
	 * @param :ModelAndView model,
										Map<String,String> params,
										String search,
										String keyword,
										String currentPage,
										HttpServletRequest request,
										String message
	 * @return : ModelAndView
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping("withDrawalList")
	public ModelAndView withDrawalList(ModelAndView model,
										Map<String,String> params,
										String search,
										String keyword,
										String currentPage,
										HttpServletRequest request,
										String message,
										String role,
										HttpSession session
										) throws Exception{
		
		
		
		
		if(currentPage==null||currentPage.intern() =="".intern()){
			currentPage = "1";
		}
		
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
		RolePagingUtil pagingUtil = new RolePagingUtil(Integer.parseInt(currentPage), totalCount, request);
		
		params.put("startCount", String.valueOf(pagingUtil.getStartCount()));
		params.put("endCount", String.valueOf(pagingUtil.getEndCount()));
		
		List<WithdrawalVO> withList= service.getWithDrawalList(params);
		
		List<FishVO> fishList= fishService.fishList();
		List<MedicineVO> mdcinList = mdcinService.mdcinList();
		
		model.addObject("message", message);
		model.addObject("pagingUtil",pagingUtil.getPagingHtmls());
		model.addObject("withList", withList);
		model.addObject("fishList", fishList);
		model.addObject("mdcinList", mdcinList);
		model.setViewName("admin/withDrawal/withDrawalList");
		
		return model;
	}
	
	@RequestMapping("withDrawalForm")
	public void withDrawalForm(){}
	
	@RequestMapping("withDrawalVIew")
	public void withDrawalVIew(){}
	
	

}
