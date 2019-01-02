package com.ai.fishdr.user.dao.mdcin_category;

import java.util.List;
import java.util.Map;

import com.ai.fishdr.vo.MedicineCategoryVO;
import com.ai.fishdr.vo.MedicineVO;

/**
 * 
 * @Class Name :IMdcinCategoryDao.java
 * @Description : 의약품-카테고리 관리 dao
 * @Modification Information
 * @author 
 * @since  2018. 11. 12.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일             수정자             수정내용
 *    -------        -------     -------------------
 *    2018. 11. 12.     조성광             최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
public interface IMdcinCategoryDao {
	/**
	 * 
	 *  개요 : 의약품 카테고리 리스트 출력
	 * @Method Name : getMdcinCategoryList
	 * @author : 조성광
	 * -----------------------------------
	 * @param : 
	 * @return : MedicineCategoryVO
	 * @throws : Exception
	 */
	public List<MedicineCategoryVO> getMdcinCategoryList() throws Exception;
	
	/**
	 * 
	 *  개요 : 의약품 카테고리 정보 출력
	 * @Method Name : getMdcinCategoryInfo
	 * @author : 조성광
	 * -----------------------------------
	 * @param : 
	 * @return : MedicineCategoryVO
	 * @throws : Exception
	 */
	public MedicineCategoryVO getMdcinCategoryInfo(Map<String, String> params) throws Exception;

}
