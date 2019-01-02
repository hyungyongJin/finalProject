package com.ai.fishdr.admin.serivce.whthDrawal;

import java.util.List;
import java.util.Map;

import com.ai.fishdr.vo.WithdrawalVO;
/**
 * 
 * @Class Name :IWithDrawalService.java
 * @Description : 휴약기간 service
 * @Modification Information
 * @author 
 * @since  2018. 11. 21.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일             수정자             수정내용
 *    -------        -------     -------------------
 *    2018. 11. 14.    임범학             최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
public interface IWithDrawalService {


	/**
	 * 
	 *  개요 : 휴약기간 리스트 출력
	 * @Method Name : getWithDrawalList
	 * @author : 임범학
	 * -----------------------------------
	 * @param : Map<String, String> params
	 * @return : List<WithdrawalVO>
	 * @throws :
	 */
	public List<WithdrawalVO> getWithDrawalList(Map<String, String> parmas) throws Exception;
	

	/**
	 * 
	 *  개요 : 휴약기간 리스트 갯수
	 * @Method Name : getTotalCount
	 * @author : 임범학
	 * -----------------------------------
	 * @param : Map<String, String> params
	 * @return : int
	 * @throws :
	 */
	public int getTotalCount(Map<String, String> parmas) throws Exception;
	
	
	/**
	 * 
	 *  개요 : 휴약기간 수정
	 * @Method Name : getWithDrawalUpdate
	 * @author : 임범학
	 * -----------------------------------
	 * @param :WithdrawalVO vo
	 * @return : Object
	 * @throws :
	 */
	public Object getWithDrawalUpdate(WithdrawalVO vo) throws Exception;
	
	/**
	 * 
	 *  개요 : 휴약기간 정보
	 * @Method Name : getWithDrawalInfo
	 * @author : 임범학
	 * -----------------------------------
	 * @param :Map<String, String> parma
	 * @return : WithdrawalVO
	 * @throws :
	 */
	public WithdrawalVO getWithDrawalInfo(Map<String, String> parma) throws Exception;

	/**
	 * 
	 *  개요 : 휴약기간 등록
	 * @Method Name : withDrawalInsert
	 * @author : 임범학
	 * -----------------------------------
	 * @param :WithdrawalVO vo
	 * @return : String
	 * @throws :
	 */
	public String withDrawalInsert(WithdrawalVO vo) throws Exception;
	
	/**
	 * 
	 *  개요 : 휴약기간 삭제
	 * @Method Name : withDrawalDelete
	 * @author : 임범학
	 * -----------------------------------
	 * @param :Map<String, String> parmas
	 * @return :int
	 * @throws :
	 */
	public int withDrawalDelete(Map<String, String> parmas) throws Exception;
	
	/**
	 * 
	 *  개요 : 휴약기간 중복확인
	 * @Method Name : withCheck
	 * @author : 임범학
	 * -----------------------------------
	 * @param :Map<String, String> parmas
	 * @return :WithdrawalVO
	 * @throws :
	 */
	public WithdrawalVO withCheck(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 *  개요 : 어종명과 의약품 코드를 입력하여 정보를 추출하는 메서드
	 * @Method Name : getWithInfo
	 * @author : 조성광
	 * -----------------------------------
	 * @param : Map<String, String> parmas
	 * @return : WithdrawalVO
	 * @throws : Exception
	 */
	public WithdrawalVO getWithInfo(Map<String, String> params) throws Exception;
}
