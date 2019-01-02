package com.ai.fishdr.admin.dao.symptms_diss;

import java.util.List;
import java.util.Map;

import com.ai.fishdr.vo.SymptmsDissVO;

/**
 * 
 * @Class Name :ISymptms_diss_Dao.java
 * @Description : 증상 질병 관리 dao
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
public interface ISymptms_diss_Dao {
	
	/**
	 * 
	 *  개요 : 증상 질병 리스트 출력
	 * @Method Name : symptms_diss_List
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : List
	 * @throws : Exception
	 */
	public List<SymptmsDissVO> symptms_diss_List(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 *  개요 : 증상 질병 카운트
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
	 *  개요 : 증상 질병 등록
	 * @Method Name : symptms_diss_Insert
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : Object
	 * @throws : Exception
	 */
	public Object symptms_diss_Insert(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 *  개요 : 증상 질병 중복 확인
	 * @Method Name : duplicationCheck
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : DissFishVO
	 * @throws : Exception
	 */
	public SymptmsDissVO duplicationCheck(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 *  개요 : 증상 질병 삭제
	 * @Method Name : symptms_diss_Delete
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : int
	 * @throws : Exception
	 */
	public int symptms_diss_Delete(String sd_code) throws Exception;
	
	/**
	 * 
	 *  개요 : 증상 질병 정보
	 * @Method Name : symptms_diss_Info
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : int
	 * @throws : Exception
	 */
	public SymptmsDissVO symptms_diss_Info(String sd_code) throws Exception;
	
	/**
	 * 
	 *  개요 : 증상 질병 수정
	 * @Method Name : symptms_diss_Update
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : int
	 * @throws : Exception
	 */
	public int symptms_diss_Update(Map<String, String> params) throws Exception;
	
}