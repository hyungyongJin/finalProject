package com.ai.fishdr.admin.dao.mdcin_diss;

import java.util.List;
import java.util.Map;

import com.ai.fishdr.vo.MdcinDissVO;

/**
 * 
 * @Class Name :IMdcin_diss_Dao.java
 * @Description : 의약품 질병 관리 dao
 * @Modification Information
 * @author 
 * @since  2018. 11. 14.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일             수정자             수정내용
 *    -------        -------     -------------------
 *    2018. 11. 18.     조성광             최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
public interface IMdcin_diss_Dao {
	
	/**
	 * 
	 *  개요 : 의약품 질병 리스트 출력
	 * @Method Name : mdcin_diss_List
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : List
	 * @throws : Exception
	 */
	public List<MdcinDissVO> mdcin_diss_List(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 *  개요 : 의약품 질병 카운트
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
	 *  개요 : 의약품 질병 등록
	 * @Method Name : mdcin_diss_Insert
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : Object
	 * @throws : Exception
	 */
	public Object mdcin_diss_Insert(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 *  개요 : 의약품 질병 중복 확인
	 * @Method Name : duplicationCheck
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : MdcinDissVO
	 * @throws : Exception
	 */
	public MdcinDissVO duplicationCheck(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 *  개요 : 의약품 질병 삭제
	 * @Method Name : mdcin_diss_Delete
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : int
	 * @throws : Exception
	 */
	public int mdcin_diss_Delete(String md_code) throws Exception;
	
	/**
	 * 
	 *  개요 : 의약품 질병 정보
	 * @Method Name : mdcin_diss_Info
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : int
	 * @throws : Exception
	 */
	public MdcinDissVO mdcin_diss_Info(String md_code) throws Exception;
	
	/**
	 * 
	 *  개요 : 의약품 질병 수정
	 * @Method Name : mdcin_diss_Update
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : int
	 * @throws : Exception
	 */
	public int mdcin_diss_Update(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 *  개요 : 질병코드로 인한 의약품 코드 추출
	 * @Method Name : getMdcinCode
	 * @author : 조성광
	 * -----------------------------------
	 * @param : diss_code
	 * @return : MdcinDissVO
	 * @throws : Exception
	 */
	public List<MdcinDissVO> getMdcinCode(String diss_code) throws Exception;
	
}