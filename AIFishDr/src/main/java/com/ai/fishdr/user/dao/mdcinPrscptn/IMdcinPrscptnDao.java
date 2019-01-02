package com.ai.fishdr.user.dao.mdcinPrscptn;

import java.util.List;
import java.util.Map;

import com.ai.fishdr.vo.MdcinPrscrptnVO;

/**
 * 
 * @Class Name :IMdcinPrscptnDao.java
 * @Description : 의약품 처방전 관리 dao
 * @Modification Information
 * @author 
 * @since  2018. 12. 04.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일             수정자             수정내용
 *    -------        -------     -------------------
 *    2018. 12. 04.     조성광             최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
public interface IMdcinPrscptnDao {
	
	/**
	 * 
	 *  개요 : 의약품 처방전 등록
	 * @Method Name : mdcinprscrptnInsert
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : 
	 * @throws : Exception
	 */
	public void mdcinPrscrptnInsert(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 *  개요 : 의약품 코드 추출 메서드
	 * @Method Name : getMdcinCode
	 * @author : 조성광
	 * -----------------------------------
	 * @param : prscrptn_code
	 * @return : MdcinPrscrptnVO
	 * @throws : Exception
	 */
	public MdcinPrscrptnVO getMdcinCode(String prscrptn_code) throws Exception;
}
