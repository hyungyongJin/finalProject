package com.ai.fishdr.admin.serivce.symptms;

import java.util.List;
import java.util.Map;

import com.ai.fishdr.vo.SymptomsVO;



public interface ISymptmsService {
	
	/**
	 * 
	 *  개요 : 증상 리스트 출력
	 * @Method Name : getSymptmsList
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : List
	 * @throws :
	 */
	public List<SymptomsVO> getSymptmsList(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 *  개요 : 증상 리스트 갯수
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
	 *  개요 : 증상 정보 삭제
	 * @Method Name : deleteSymptms
	 * @author : 조성광
	 * -----------------------------------
	 * @param : symptms_code
	 * @return : int
	 * @throws : Exception
	 */
	public int deleteSymptms(String symptms_code) throws Exception;
	
	/**
	 * 
	 *  개요 : 증상 정보 등록
	 * @Method Name : insertSymptms
	 * @author : 조성광
	 * -----------------------------------
	 * @param : symptms_content
	 * @return : int
	 * @throws : Exception
	 */
	public int insertSymptms(String symptms_content) throws Exception;
	
	/**
	 * 
	 *  개요 : 증상 정보 
	 * @Method Name : symptmsInfo
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : SymptomsVO
	 * @throws : Exception
	 */
	public SymptomsVO symptmsInfo(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 *  개요 : 증상 정보 수정 
	 * @Method Name : updateSymptms
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : int
	 * @throws : Exception
	 */
	public int updateSymptms(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 *  개요 : 증상 정보 리스트 
	 * @Method Name : symptmsList
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : List
	 * @throws : Exception
	 */
	public List<SymptomsVO> prsSymptmsList(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 *  개요 : 증상 정보 리스트 
	 * @Method Name : symptmsList
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : List
	 * @throws : Exception
	 */
	public List<SymptomsVO> symptmsList() throws Exception;
	
	/**
	 * 
	 *  개요 : 증상 중복 확인 
	 * @Method Name : duplicationCheck
	 * @author : 조성광
	 * -----------------------------------
	 * @param : symptms_content
	 * @return : SymptomsVO
	 * @throws : Exception
	 */
	public SymptomsVO duplicationCheck(String symptms_content) throws Exception;
	

	
}
