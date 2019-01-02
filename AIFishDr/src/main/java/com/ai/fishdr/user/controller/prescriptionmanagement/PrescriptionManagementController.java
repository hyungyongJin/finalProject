package com.ai.fishdr.user.controller.prescriptionmanagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.fishdr.admin.serivce.hospital.IHospitalMgrService;
import com.ai.fishdr.nouser.service.member.IMemberService;
import com.ai.fishdr.user.service.facepicture.IFacePictureService;
import com.ai.fishdr.user.service.fishgram.IFishgramService;
import com.ai.fishdr.user.service.fishgramcomment.IFishgramCommentService;
import com.ai.fishdr.user.service.fishgramlike.IFishgramLikeService;
import com.ai.fishdr.user.service.friend.IFriendService;
import com.ai.fishdr.user.service.prescription.IPrescriptionService;
import com.ai.fishdr.utils.RolePagingUtilFifteen;
import com.ai.fishdr.utils.RolePagingUtilFishgramComment;
import com.ai.fishdr.utils.RolePagingUtilMedicine;
import com.ai.fishdr.utils.RolePagingUtilPrescription;
import com.ai.fishdr.vo.FacePictureVO;
import com.ai.fishdr.vo.FishgramCommentVO;
import com.ai.fishdr.vo.FishgramVO;
import com.ai.fishdr.vo.FriendVO;
import com.ai.fishdr.vo.HospitalVO;
import com.ai.fishdr.vo.MemberVO;
import com.ai.fishdr.vo.PrescriptionVO;

/**
 * 
 * @Class Name : PrescriptionManagementController.java
 * @Description : 처방내역관리 관련 컨트롤러
 * @Modification Information
 * @author 
 * @since  2018. 12. 04.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일            수정자      수정내용
 *    ------------      -------     -------------------
 *    2018. 12. 04.     심재형      최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
@Controller
@RequestMapping("/user/prescriptionManagement/")
public class PrescriptionManagementController {
	
	public static String temp_search_keycode = null;
	public static String temp_search_keyword = null;
	
	@Autowired
	private IFishgramService fishgramService;
	
	@Autowired
	private IFacePictureService facePictureService;
	
	@Autowired
	private IMemberService memberService;
	
	@Autowired
	private IFishgramCommentService fishgramCommentService;
	
	@Autowired
	private IFriendService friendService;
	
	@Autowired
	private IFishgramLikeService fishgramLikeService;
	
	@Autowired
	private IPrescriptionService prescriptionService;
	
	@Autowired
	private IHospitalMgrService hospitalService;
	
	
	/**
	 * 
	 *    의미 : 자신이 AiDoctor 에게 진단받은 리스트
	 * @Method : prescriptionManagementList
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : mav (ModelAndView 타입)
	 * 			 request (HttpServletRequest 타입)
	 * 			 params (Map<String, String> 타입)
	 * 			 search_keyword (String 타입)
	 *			 search_keycode (String 타입)
	 * 			 currentPage (String 타입)
	 * 			 session (HttpSession 타입)
	 * @return : mav (ModelAndView 타입)
	 * @throws : Exception
	 */
	@RequestMapping("prescriptionManagementList")
	public ModelAndView prescriptionManagementList(ModelAndView mav,
											 HttpServletRequest request,
											 Map<String, String> params,
											 String search_keyword,
											 String search_keycode,
											 String currentPage,
											 HttpSession session) throws Exception {
		
		temp_search_keycode = search_keycode;
		temp_search_keyword = search_keyword;
		
		if (currentPage == null || currentPage == "") {
			
			currentPage = "1";
			
		}
		
		String mem_id = ((MemberVO)session.getAttribute("LOGIN_MEMBER")).getMem_id();
		
		params.put("mem_id", mem_id);
		
		
		// 내가 처방받은 처방코드와 그 처방을 받은 관리원 리스트 가져오기
		List<Map<String, Object>> hospitalList = prescriptionService.getPrescriptionHospitalList(mem_id);
				
		// 내가 처방받은 진료코드 리스트 가져오기
		List<Map<String, Object>> treatList = prescriptionService.getTreatList(mem_id);
		
		
		// 처방내역 리스트와 비교할 리스트 생성
		List<Map<String, Object>> compareList = new ArrayList<Map<String,Object>>();
		
		for (int i = 0 ; i < hospitalList.size() ; i++) {
			
			Map<String, Object> getHospitalListMap = hospitalList.get(i);
			
			String getPrscrptnCode = (String) getHospitalListMap.get("PRSCRPTN_CODE");
			String getHospitalName = (String) getHospitalListMap.get("HOSPITAL_NAME");

			Map<String, Object> getTreatListMap = treatList.get(i);
			
			String getFishName = (String) getTreatListMap.get("FISH_NAME");
			
			Map<String, Object> putData = new HashMap<String, Object>();
			
			putData.put("PRSCRPTN_CODE", getPrscrptnCode);
			putData.put("HOSPITAL_NAME", getHospitalName);
			putData.put("FISH_NAME", getFishName);
			
			compareList.add(putData);
			
		}
		
		mav.addObject("compareList", compareList);
		
		params.put("search_keycode", search_keycode);
		params.put("search_keyword", search_keyword);
		params.put("currentPage", currentPage);
		
		// 처방 내역 리스트 총 개수
		int totalPrescriptionListAllCount = prescriptionService.totalPrescriptionListAllCount(params);
		
		// 검색 조건에 맞는 처방 내역 리스트 수
		int totalPrescriptionListCount = prescriptionService.totalPrescriptionListCount(params);
				
		RolePagingUtilPrescription page = new RolePagingUtilPrescription(Integer.parseInt(currentPage), totalPrescriptionListCount, request);
		
		params.put("startCount", String.valueOf(page.getStartCount()));
		params.put("endCount", String.valueOf(page.getEndCount()));
		
		// 처방내역 리스트
		List<Map<String, Object>> pml = prescriptionService.getPrescriptionList(params);
		
		mav.addObject("params", params);
		mav.addObject("paging", page.getPagingHtmls());
		mav.addObject("pml", pml);
		mav.addObject("totalPrescriptionListAllCount", totalPrescriptionListAllCount);
		
		mav.setViewName("user/prescriptionManagement/prescriptionManagementList");
		
		return mav;
		
	}
	
	
	/**
	 * 
	 *    의미 : 자신이 AiDoctor 에게 진단받은 리스트의 상세내역
	 * @Method : prescriptionManagementView
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : mav (ModelAndView 타입)
	 * 			 request (HttpServletRequest 타입)
	 * 			 params (Map<String, String> 타입)
	 * 			 search_keyword (String 타입)
	 *			 search_keycode (String 타입)
	 * 			 currentPage (String 타입)
	 * 			 session (HttpSession 타입)
	 * @return : mav (ModelAndView 타입)
	 * @throws : Exception
	 */
	@RequestMapping("prescriptionManagementView")
	public ModelAndView prescriptionManagementView(ModelAndView mav,
											 HttpServletRequest request,
											 Map<String, String> params,
											 String currentPage,
											 String treat_code,
											 String prscrptn_code,
											 String fish_name,
											 String fish_weight,
											 String fish_number,
											 String fish_symptms,
											 String treat_reg_date,
											 String hospital_name,
											 String prscrptn_name,
											 HttpSession session) throws Exception {
		
		
		if (currentPage == null || currentPage == "") {
			
			currentPage = "1";
			
		}
		
		
		// 회원 정보 불러오기
		String mem_id = ((MemberVO)session.getAttribute("LOGIN_MEMBER")).getMem_id();
		
		params.put("mem_id", mem_id);
				
		MemberVO mv = memberService.getSelectIdInfo(params);
		
		mav.addObject("mv", mv);
		
		
		// 수산질병관리원 정보 불러오기
		params.put("hospital_name", hospital_name.trim());
		
		HospitalVO hv = hospitalService.converHospitalInfo(hospital_name);

		mav.addObject("hv", hv);
		
		
		// 진단 내용 불러오기
		params.put("treat_code", treat_code);
		params.put("prscrptn_code", prscrptn_code);
		params.put("prscrptn_name", prscrptn_name.trim());
		params.put("fish_name", fish_name.trim());
		params.put("fish_weight", fish_weight.trim());
		params.put("fish_number", fish_number.trim());
		
		
		// 처방 가능 의약품 리스트 총 개수
		int totalResultAllPrescription = prescriptionService.totalResultAllPrescription(params);
		
		params.put("currentPage", currentPage);
		
		RolePagingUtilMedicine page = new RolePagingUtilMedicine(Integer.parseInt(currentPage), totalResultAllPrescription, request);
		
		params.put("startCount", String.valueOf(page.getStartCount()));
		params.put("endCount", String.valueOf(page.getEndCount()));
		
		
		// 물고기 증상 리스트에 담기
		String[] fish_symptms_array;
		
		fish_symptms_array = fish_symptms.split("_");
		
		String representSymptms = fish_symptms_array[0];
		
		params.put("representSymptms", representSymptms);
		
		String representSymptmsCount = String.valueOf((fish_symptms_array.length - 1));
		
		params.put("representSymptmsCount", representSymptmsCount);
		
		
		// 모든 증상에 대한 리스트
		List<Map<String, Object>> mergeSymptomsList = new ArrayList<Map<String,Object>>();
		
		// 증상을 합쳐서 한가지 의약품에 넣은 후의 리스트
		List<Map<String, Object>> finalMergeList = new ArrayList<Map<String,Object>>();
		
		
		// 처방 가능 의약품 리스트 불러오기
		for (int i = 0 ; i < fish_symptms_array.length ; i++) {
			
			params.put("fish_symptms", fish_symptms_array[i].trim());
			
			List<Map<String, Object>> rpl = prescriptionService.resultPrescription(params);
			
			for (int j = 0 ; j < rpl.size() ; j++) {
			
				Map<String, Object> getRplMap = rpl.get(j);
				
				mergeSymptomsList.add(getRplMap);
				
			}
			
		}
				
		String addMdcinCode = null;
		
		int medicineCount = 0;
		
		for (int i = 0 ; i < mergeSymptomsList.size() ; i++) {
			
			Map<String, Object> getMdcinCodeMap = mergeSymptomsList.get(i);
			
			String getMdcinCode = (String) getMdcinCodeMap.get("MDCIN_CODE");
			
			if (i == 0) {
			
				addMdcinCode = getMdcinCode;
				
				medicineCount++;
				
			} else {
				
				if (!addMdcinCode.contains(getMdcinCode)) {
				
					addMdcinCode = addMdcinCode + getMdcinCode;
					
					medicineCount++;
					
				}
								
			}
			
		}
		
		String saveSymptoms = null;
		
		
		// 증상을 합치는 과정
		for (int i = 0 ; i < medicineCount ; i++) {
			
			Map<String, Object> getMergeBeforeMap = mergeSymptomsList.get(i);
			
			String getFishCodeBefore = (String) getMergeBeforeMap.get("FISH_CODE");
			String getDissCodeBefore = (String) getMergeBeforeMap.get("DISS_CODE");
			String getMdcinCodeBefore = (String) getMergeBeforeMap.get("MDCIN_CODE");
			String getSymptmsCodeBefore = (String) getMergeBeforeMap.get("SYMPTMS_CODE");
			String getSymptmsContentBefore = (String) getMergeBeforeMap.get("SYMPTMS_CONTENT");
			
			saveSymptoms = getSymptmsContentBefore;
			
			for (int j = i + 1 ; j < mergeSymptomsList.size() ; j++) {
						
				Map<String, Object> getMergeAfterMap = mergeSymptomsList.get(j);
				
				String getFishCodeAfter = (String) getMergeAfterMap.get("FISH_CODE");
				String getDissCodeAfter = (String) getMergeAfterMap.get("DISS_CODE");
				String getMdcinCodeAfter = (String) getMergeAfterMap.get("MDCIN_CODE");
				String getSymptmsCodeAfter = (String) getMergeAfterMap.get("SYMPTMS_CODE");
				String getSymptmsContentAfter = (String) getMergeAfterMap.get("SYMPTMS_CONTENT");
				
				if ((getFishCodeBefore.equals(getFishCodeAfter)) && (getDissCodeBefore.equals(getDissCodeAfter)) && (getMdcinCodeBefore.equals(getMdcinCodeAfter)) && !(getSymptmsCodeBefore.equals(getSymptmsCodeAfter))) {
					
					saveSymptoms = saveSymptoms + ", " + getSymptmsContentAfter;
					
				}
								
			}
			
			System.out.println(saveSymptoms);
			
			getMergeBeforeMap.put("SYMPTMS_CONTENT", saveSymptoms);
			
			finalMergeList.add(getMergeBeforeMap);
			
		}
				
		
		// 모든 증상에 대한 리스트 (최종선택)
		List<Map<String, Object>> mergeSymptomsFinalList = new ArrayList<Map<String,Object>>();
		
		
		// 증상을 합쳐서 한가지 의약품에 넣은 후의 리스트
		List<Map<String, Object>> finalMergeChoiceList = new ArrayList<Map<String,Object>>();
		
		
		// 최종적으로 처방받은 약 정보에 증상 합치기
		for (int i = 0 ; i < fish_symptms_array.length ; i++) {
			
			params.put("fish_symptms", fish_symptms_array[i].trim());
			
			List<Map<String, Object>> frpl = prescriptionService.finalResultPrescription(params);
			
			for (int j = 0 ; j < frpl.size() ; j++) {
			
				Map<String, Object> getFrplMap = frpl.get(j);
				
				mergeSymptomsFinalList.add(getFrplMap);
				
			}
			
		}
		
		String saveSymptomsFinal = null;
		
		
		// 증상을 합치는 과정
//		for (int i = 0 ; i < fish_symptms_array.length ; i++) {
			
		Map<String, Object> getMergeBeforeMap = mergeSymptomsFinalList.get(0);

		String getMdcinCodeBefore = ((String) getMergeBeforeMap.get("MDCIN_CODE")).trim();
		String getDissCodeBefore = ((String) getMergeBeforeMap.get("DISS_CODE")).trim();
		String getSymptmsCodeBefore = ((String) getMergeBeforeMap.get("SYMPTMS_CODE")).trim();
		String getSymptmsContentBefore = ((String) getMergeBeforeMap.get("SYMPTMS_CONTENT")).trim();
		
		saveSymptomsFinal = getSymptmsContentBefore;
		
		for (int j = 1 ; j < mergeSymptomsFinalList.size() ; j++) {
					
			Map<String, Object> getMergeAfterMap = mergeSymptomsFinalList.get(j);
			
			String getMdcinCodeAfter = ((String) getMergeAfterMap.get("MDCIN_CODE")).trim();
			String getDissCodeAfter = ((String) getMergeAfterMap.get("DISS_CODE")).trim();
			String getSymptmsCodeAfter = ((String) getMergeAfterMap.get("SYMPTMS_CODE")).trim();
			String getSymptmsContentAfter = ((String) getMergeAfterMap.get("SYMPTMS_CONTENT")).trim();
			
			if ((getMdcinCodeBefore.equals(getMdcinCodeAfter)) && (getDissCodeBefore.equals(getDissCodeAfter)) && !(getSymptmsCodeBefore.equals(getSymptmsCodeAfter))) {
				
				if (!saveSymptomsFinal.contains(getSymptmsContentAfter)) {
					
					saveSymptomsFinal = saveSymptomsFinal + ", " + getSymptmsContentAfter;
					
				}
								
			}
							
		}
		
		System.out.println(saveSymptomsFinal);
		
		getMergeBeforeMap.put("SYMPTMS_CONTENT", saveSymptomsFinal);
		
		finalMergeChoiceList.add(getMergeBeforeMap);
		
		
		// 최종적으로 처방받은 약 정보 불러오기
		params.put("prscrptn_code", prscrptn_code);
		
//		List<Map<String, Object>> frpl = prescriptionService.finalResultPrescription(params);
		
		Map<String, Object> getFrplMap = finalMergeChoiceList.get(0);
		
		String getFinalMdcinCode = (String) getFrplMap.get("MDCIN_CODE");
		String getFinalMdcinPrductName = (String) getFrplMap.get("MDCIN_PRDUCT_NAME");
		String getFinalDissCode = (String) getFrplMap.get("DISS_CODE");
		String getFinalDissName = (String) getFrplMap.get("DISS_NAME");
		String getFinalSymptms_code = (String) getFrplMap.get("SYMPTMS_CODE");
		String getFinalSymptms_content = (String) getFrplMap.get("SYMPTMS_CONTENT");
		String getFinalUscpContent = (String) getFrplMap.get("USCP_CONTENT");
		String getFinalWithdrawalPeriod = (String) getFrplMap.get("WITHDRAWAL_PERIOD");
		
		params.put("MDCIN_CODE", getFinalMdcinCode);
		params.put("MDCIN_PRDUCT_NAME", getFinalMdcinPrductName);
		params.put("DISS_CODE", getFinalDissCode);
		params.put("DISS_NAME", getFinalDissName);
		params.put("SYMPTMS_CODE", getFinalSymptms_code);
		params.put("SYMPTMS_CONTENT_CHOICE", getFinalSymptms_content);
		params.put("USCP_CONTENT", getFinalUscpContent);
		params.put("WITHDRAWAL_PERIOD", getFinalWithdrawalPeriod);
		
		
		// 처방내역 상세 리스트 중 병명을 중복 제거하여 정보 갖고 오기
		List<String> getDiseaseNameList = prescriptionService.getResultPrescriptionDissName(params);
		
		int getDiseaseNameListSize = getDiseaseNameList.size();
		
		List<String> filterDiseaseNameList = new ArrayList<String>();
		
		for (int i = 1 ; i <= getDiseaseNameListSize ; i++) {
			
			if (i != getDiseaseNameListSize) {
				
				if (getDiseaseNameList.get(i - 1).equals(getDiseaseNameList.get(i))) {
					
				} else {
					
					filterDiseaseNameList.add(getDiseaseNameList.get(i - 1));
					
				}
				
			} else if (i == getDiseaseNameListSize) {
				
				filterDiseaseNameList.add(getDiseaseNameList.get(i - 1));
				
			}
			
		}
		
		
		// 처방내역 상세 리스트 중 질병파일명을 중복 제거하여 정보 갖고 오기
		List<String> getDiseaseFileNameList = prescriptionService.getResultPrescriptionDiseaseFile(params);
		
		String getDiseaseFileNameString = getDiseaseFileNameList.get((int)(Math.random() * getDiseaseFileNameList.size()));
		
		params.put("fish_disease_file_save_name", getDiseaseFileNameString);
		
		
		// 특정 회원이 특정 의약품에 점수를 부여한 의사코드 총 개수 가져오기
		int totalCountTreatCode = prescriptionService.searchTreatCodeAddScore(params);
		
		// 특정 회원이 특정 의약품에 점수를 부여한 처방코드 총 개수 가져오기
		int totalCountPrscrptnCode = prescriptionService.searchPrscrptnCodeAddScore(params);
		
		
		mav.addObject("rpl", finalMergeList);
		
		mav.addObject("saveDiseaseNameList", filterDiseaseNameList);
				
		mav.addObject("params", params);
		
		mav.addObject("paging", page.getPagingHtmls());
		
		mav.addObject("totalResultAllPrescription", totalResultAllPrescription);
		
		mav.addObject("totalCountTreatCode", totalCountTreatCode);
		
		mav.addObject("totalCountPrscrptnCode", totalCountPrscrptnCode);
		
		mav.addObject("fish_symptms_array", fish_symptms_array);
				
		mav.setViewName("user/prescriptionManagement/prescriptionManagementView");
		
		return mav;
		
	}
	
	
	/**
	 * 
	 *    의미 : 처방받은 의약품 점수를 등록하기
	 * @Method : insertMedicineScore
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : mav (ModelAndView 타입)
	 * 			 request (HttpServletRequest 타입)
	 * 			 params (Map<String, String> 타입)
	 * 			 search_keyword (String 타입)
	 *			 search_keycode (String 타입)
	 * 			 currentPage (String 타입)
	 * 			 session (HttpSession 타입)
	 * @return : mav (ModelAndView 타입)
	 * @throws : Exception
	 */
	@RequestMapping("insertMedicineScore")
	public ModelAndView insertMedicineScore(ModelAndView mav, Map<String, String> params,
											String mdcin_code, String treat_code, String prscrptn_code, String mdcin_score,
											HttpSession session) throws Exception {
		
		String mem_id = ((MemberVO)session.getAttribute("LOGIN_MEMBER")).getMem_id();
		
		params.put("mdcin_code", mdcin_code);
		params.put("prscrptn_code", prscrptn_code);
		params.put("treat_code", treat_code);
		params.put("mdcin_score", mdcin_score);
		params.put("mem_id", mem_id);
		
		prescriptionService.insertMedicineScore(params);
		
		mav.setViewName("jsonConvertView");
		
		return mav;
		
	}
	
	
	
	
}
