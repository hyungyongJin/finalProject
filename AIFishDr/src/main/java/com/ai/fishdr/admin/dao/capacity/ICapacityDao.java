package com.ai.fishdr.admin.dao.capacity;

import java.util.List;
import java.util.Map;

import com.ai.fishdr.vo.CapacityUsageVO;

/**
 * 
 * @Class Name :ICapacityDao.java
 * @Description : 용법및용량 dao
 * @Modification Information
 * @author 
 * @since  2018. 11. 12.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일             수정자             수정내용
 *    -------        -------     -------------------
 *    2018. 11. 12.     임범학             최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
public interface ICapacityDao {

	/**
	 * 
	 *  개요 : 용법및 용량 전체 리스트 출력
	 * @Method Name : getCapacityList
	 * 	@author : 임범학
	 * 	 * -----------------------------------
	 * @param : Map<String, String> params
	 * @return : List<CapacityUsageVO>
	 * @throws :
	 */
	public List<CapacityUsageVO> getCapacityList(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 *  개요 : 용법및 용량 전체 리스트 갯수
	 * @Method Name : getTotalCount
	 * 	@author : 임범학
	 * 	 * -----------------------------------
	 * @param : Map<String, String> params
	 * @return : int
	 * @throws :
	 */
	public int getTotalCount(Map<String, String> params) throws Exception;

	/**
	 * 
	 *  개요 : 용법및 용량 해당 리스트 정보
	 * @Method Name : getInfo
	 * 	@author : 임범학
	 * 	 * -----------------------------------
	 * @param : Map<String, String> params
	 * @return : CapacityUsageVO
	 * @throws :
	 */
	public CapacityUsageVO getInfo(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 *  개요 : 용법및 용량 해당 리스트 수정
	 * @Method Name : capacityUpdate
	 * 	@author : 임범학
	 * 	 * -----------------------------------
	 * @param : Map<String, String> params
	 * @return : int
	 * @throws :
	 */
	public int capacityUpdate(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 *  개요 : 용법및 용량 해당 리스트 등록
	 * @Method Name : capacityInsert
	 * 	@author : 임범학
	 * 	 * -----------------------------------
	 * @param : Map<String, String> params
	 * @return : Object
	 * @throws :
	 */
	public Object capacityInsert(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 *  개요 : 용법및 용량 해당 리스트 삭제
	 * @Method Name : capacityDelete
	 * 	@author : 임범학
	 * 	 * -----------------------------------
	 * @param : Map<String, String> params
	 * @return : Object
	 * @throws :
	 */
	public Object capacityDelete(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 *  개요 : 용법및 용량 중복체크
	 * @Method Name : capacityCheck
	 * 	@author : 임범학
	 * 	 * -----------------------------------
	 * @param : Map<String, String> params
	 * @return : CapacityUsageVO
	 * @throws :
	 */
	public CapacityUsageVO capacityCheck(Map<String, String> params) throws Exception; 
	
	
	/**
	 * 
	 *  개요 : 처방전에서 사용 될 용법 및 용량 정보
	 *  @Method Name : prsCapacityInfo
	 * 	@author : 조성광
	 * 	 * -----------------------------------
	 *  @param : Map<String, String> params
	 *  @return : CapacityUsageVO
	 *  @throws : Exception
	 */
	public CapacityUsageVO prsCapacityInfo(Map<String, String> params) throws Exception;
}
