package com.ai.fishdr.admin.serivce.symptms_diss;

import java.util.List;
import java.util.Map;

import com.ai.fishdr.vo.SymptmsDissVO;

public interface ISymptms_diss_Service {
	/**
	 * 
	 *  개요 : 증상 질병 리스트 출력
	 * @Method Name : symptms_diss_List
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : List
	 * @throws :
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
	 * @return : int
	 * @throws : Exception
	 */
	public int symptms_diss_Insert(Map<String, String> params) throws Exception;
	
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
