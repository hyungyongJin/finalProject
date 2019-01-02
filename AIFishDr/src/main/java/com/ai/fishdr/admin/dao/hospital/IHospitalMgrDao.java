package com.ai.fishdr.admin.dao.hospital;

import java.util.List;
import java.util.Map;

import com.ai.fishdr.vo.HospitalVO;

/**
 * 
 * @Class Name :IHospitalMgrDao.java
 * @Description : 질병관리원 정보 관리 dao
 * @Modification Information
 * @author 진형용
 * @since  2018. 11. 20.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일             수정자             수정내용
 *    -------        -------     -------------------
 *    2018. 11. 20.     진형용             최초작성
 *    2018. 11. 28.     조성광             데이터 추가
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
public interface IHospitalMgrDao {
	/**
	 *  개요 : 질병관리원 정보 리스트
	 * @Method Name : hospitalList
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : List<HospitalVO>
	 * @throws :
	 */
	public List<HospitalVO> hospitalList(Map<String,String>params)throws Exception;
	/**
	 *  개요 : 질병관리원 검색 갯수
	 * @Method Name : getTotalCount
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : int
	 * @throws :
	 */
	public int getTotalCount(Map<String,String>params)throws Exception;
	/**
	 *  개요 : 관리원 상세정보
	 * @Method Name : hospitalInfo
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : HospitalVO
	 * @throws :
	 */
	public HospitalVO hospitalInfo(Map<String,String>params) throws Exception;
	/**
	 *  개요 : 관리원 정보 수정
	 * @Method Name : updateHospital
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : boolean
	 * @throws :
	 */
	public int updateHospital(HospitalVO vo) throws Exception;
	/**
	 *  개요 : 관리원 등록
	 * @Method Name : insertHospital
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : String(관리원명)
	 * @throws :
	 */
	public String insertHospital(HospitalVO vo) throws Exception;
	/**
	 *  개요 : 관리원 정보 삭제
	 * @Method Name : deleteHospital
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : boolean
	 * @throws :
	 */
	public int deleteHospital(Map<String,String>params) throws Exception;
	
	/**
	 *  개요 : 관리원 정보 조회
	 * @Method Name : converHospitalInfo
	 * @author : 조성광
	 * -----------------------------------
	 * @param : hospital_name
	 * @return : boolean
	 * @throws : Exception
	 */
	public HospitalVO converHospitalInfo(String hospital_name) throws Exception;
	
}
