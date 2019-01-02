package com.ai.fishdr.admin.dao.diss_fish;

import java.util.List;
import java.util.Map;

import com.ai.fishdr.vo.DissFishVO;

/**
 * 
 * @Class Name :IDiseaseDao.java
 * @Description : 질병 어종 관리 dao
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
public interface IDiss_fish_Dao {
	
	/**
	 * 
	 *  개요 : 질병 어종 리스트 출력
	 * @Method Name : getList
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : List
	 * @throws : Exception
	 */
	public List<DissFishVO> diss_fish_List(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 *  개요 : 질병 어종 카운트
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
	 *  개요 : 질병 어종 등록
	 * @Method Name : diss_fish_Insert
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : Object
	 * @throws : Exception
	 */
	public Object diss_fish_Insert(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 *  개요 : 질병 어종 중복 확인
	 * @Method Name : duplicationCheck
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : DissFishVO
	 * @throws : Exception
	 */
	public DissFishVO duplicationCheck(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 *  개요 : 질병 어종 삭제
	 * @Method Name : diss_fish_Delete
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : int
	 * @throws : Exception
	 */
	public int diss_fish_Delete(String df_code) throws Exception;
	
	/**
	 * 
	 *  개요 : 질병 어종 정보
	 * @Method Name : diss_fish_Info
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : int
	 * @throws : Exception
	 */
	public DissFishVO diss_fish_Info(String df_code) throws Exception;
	
	/**
	 * 
	 *  개요 : 질병 어종 수정
	 * @Method Name : diss_fish_Update
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : int
	 * @throws : Exception
	 */
	public int diss_fish_Update(Map<String, String> params) throws Exception;
	
	
}