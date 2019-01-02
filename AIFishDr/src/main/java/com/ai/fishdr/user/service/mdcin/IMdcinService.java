package com.ai.fishdr.user.service.mdcin;

import java.util.List;
import java.util.Map;

import com.ai.fishdr.vo.MedicineVO;

/**
 * 
 * @Class Name :IMdcinService.java
 * @Description : 의약품 관리 service
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
public interface IMdcinService {
	/**
	 * 
	 *  개요 : 의약품 리스트 출력
	 * @Method Name : getMdcinList
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : List
	 * @throws :
	 */
	public List<MedicineVO> getMdcinList(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 *  개요 : 의약품 리스트 갯수
	 * @Method Name : totalCount
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : int
	 * @throws : Exception
	 */
	public int totalCount(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 *  개요 : 의약품 정보
	 * @Method Name : getMdcinInfo
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : MedicineVO
	 * @throws : Exception
	 */
	public MedicineVO getMdcinInfo(String mdcin_code) throws Exception;
	
	/**
	 * 
	 *  개요 : 의약품 조회수 증가 
	 * @Method Name : updateHit
	 * @author : 조성광
	 * -----------------------------------
	 * @param : mdcin_code
	 * @return : 
	 * @throws : Exception
	 */
	public void updateHit(String mdcin_code) throws Exception;
	
	
	/**
	 * 
	 *    제목 : 특정 의약품에게 점수를 매긴 횟수 구하기
	 * @Method : medicineCount
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : mdcin_code (String 타입)
	 * @return : int
	 * @throws : Exception
	 */
	public int medicineCount(String mdcin_code) throws Exception;
	
	
	/**
	 * 
	 *    제목 : 특정 의약품에게 매겨진 점수의 총합 구하기
	 * @Method : totalMedicineScore
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : mdcin_code (String 타입)
	 * @return : int
	 * @throws : Exception
	 */
	public int totalMedicineScore(String mdcin_code) throws Exception;


}
