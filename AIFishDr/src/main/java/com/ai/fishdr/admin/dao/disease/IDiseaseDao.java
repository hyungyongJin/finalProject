package com.ai.fishdr.admin.dao.disease;

import java.util.List;
import java.util.Map;






import com.ai.fishdr.vo.DiseaseFileVO;
import com.ai.fishdr.vo.DiseaseVO;

/**
 * 
 * @Class Name :IDiseaseDao.java
 * @Description : 질병 관리 dao
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
public interface IDiseaseDao {
	
	/**
	 * 
	 *  개요 : 질병 리스트 출력
	 * @Method Name : getDiseaseList
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : List
	 * @throws :
	 */
	public List<DiseaseVO> getDiseaseList(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 *  개요 : 질병 리스트 갯수
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
	 *  개요 : 질병 정보 삭제
	 * @Method Name : deleteDisease
	 * @author : 조성광
	 * -----------------------------------
	 * @param : diss_code
	 * @return : int
	 * @throws : Exception
	 */
	public int deleteDisease(String diss_code) throws Exception;
	
	/**
	 * 
	 *  개요 : 질병 정보 등록
	 * @Method Name : insertDisease
	 * @author : 조성광
	 * -----------------------------------
	 * @param : diss_name
	 * @return : Object
	 * @throws : Exception
	 */
	public Object insertDisease(String diss_name) throws Exception;
	
	/**
	 * 
	 *  개요 : 질병 정보 
	 * @Method Name : diseaseInfo
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : DiseaseVO
	 * @throws : Exception
	 */
	public DiseaseVO diseaseInfo(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 *  개요 : 질병 정보 수정 
	 * @Method Name : updateDisease
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : int
	 * @throws : Exception
	 */
	public int updateDisease(Map<String, String> params) throws Exception;

	/**
	 * 
	 *  개요 : 질병 정보 리스트 
	 * @Method Name : dissList
	 * @author : 조성광
	 * -----------------------------------
	 * @param : 
	 * @return : List
	 * @throws : Exception
	 */
	public List<DiseaseVO> dissList() throws Exception;

	
	/**
	 *  개요 : 질병리스트와 등록된 사진 갯수 불러오는 리스트
	 * @Method Name : getDisaseFileList
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : List<Map<String,DiseaseVO>>
	 * @throws :
	 */
	public List<Map<String,DiseaseVO>> getDisaseFileList(Map<String,String>params) throws Exception;
	/**
	 *  개요 :  질병리스트와 등록된 사진 갯수 불러오는 메서드
	 * @Method Name : getTotalFileCount
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : int
	 * @throws :
	 */
	public int getTotalFileCount(Map<String,String>params) throws Exception;
	/**
	 *  개요 :  질병 사진등록할 메서드
	 * @Method Name : insertDissFile
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : String
	 * @throws :
	 */
	public String insertDissFile(DiseaseFileVO vo)throws Exception;
	/**
	 *  개요 : 해당 질병사진을 불러오는 메서드
	 * @Method Name : getDissFileInfo
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : List<DiseaseFileVO>
	 * @throws :
	 */
	public List<DiseaseFileVO> getDissFileInfo(String diss_code) throws Exception;
	/**
	 *  개요 : 질병관련 파일 삭제
	 * @Method Name : deleteDissFile
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : int
	 * @throws :
	 */
	public int deleteDissFile(String file_no)throws Exception;
	
	/**
	 *  개요 : 질병 중복 체크 
	 * @Method Name : deleteDissFile
	 * @author : 조성광
	 * -----------------------------------
	 * @param : diss_name
	 * @return : DiseaseVO
	 * @throws : Exception
	 */
	public DiseaseVO duplicationCheck(String diss_name) throws Exception;
	/**
	 *  개요 : 회원이 보게될 질병리스트 수(어류+질병)
	 * @Method Name : getShowDissCnt
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : int
	 * @throws :
	 */
	public int getShowDissCnt(Map<String, String> params) throws Exception;
	
	/**
	 *  개요 : 회원이 보게될 질병리스트 (어류+질병)
	 * @Method Name : getShowDissList
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : List<Map<String,String>>
	 * @throws :
	 */
	public List<Map<String, String>> getShowDissList(Map<String, String> params) throws Exception;
	
	/**
	 *  개요 : 어종과 증상을 통한 질병 정보
	 * @Method Name : getDissCode
	 * @author : 조성광
	 * -----------------------------------
	 * @param : 
	 * @return : DiseaseVO
	 * @throws : Exception
	 */
	public List<DiseaseVO> getDissCode(Map<String, String> params) throws Exception;
	
}
