package com.ai.fishdr.user.service.doctor;

import java.util.Map;

import com.ai.fishdr.vo.DoctorVO;

/**
 * 
 * @Class Name :IDoctorService.java
 * @Description : 진료 관리 service
 * @Modification Information
 * @author 
 * @since  2018. 11. 19.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일             수정자             수정내용
 *    -------        -------     -------------------
 *    2018. 11. 19.     조성광             최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
public interface IDoctorService {
	
	/**
	 * 
	 *  개요 : 진료 정보 출력
	 * @Method Name : doctorInfo
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : DoctorVO
	 * @throws :
	 */
	public DoctorVO doctorInfo(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 *  개요 : 진료 정보 등록
	 * @Method Name : insertDoctor
	 * @author : 조성광
	 * -----------------------------------
	 * @param : doctorInfo
	 * @return : 
	 * @throws :
	 */
	public void insertDoctor(DoctorVO doctorInfo) throws Exception;
	
	/**
	 * 
	 *  개요 : 최근 진료 코드 seq값 출력
	 * @Method Name : getTreat_code
	 * @author : 조성광
	 * -----------------------------------
	 * @param : 
	 * @return : String
	 * @throws : Exception
	 */
	public String getTreat_code() throws Exception;

}
