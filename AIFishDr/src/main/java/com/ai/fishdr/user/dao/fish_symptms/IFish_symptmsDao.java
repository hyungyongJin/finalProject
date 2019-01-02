package com.ai.fishdr.user.dao.fish_symptms;

import java.util.List;
import java.util.Map;

import com.ai.fishdr.vo.FishSymptmsVO;

/**
 * 
 * @Class Name :IFish_symptmsDao.java
 * @Description : 진료 증상 관리 dao
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
public interface IFish_symptmsDao {

	/**
	 * 
	 *  개요 : 진료 증상 출력
	 * @Method Name : fish_symptms_List
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : FishSymptmsVO
	 * @throws : Exception
	 */
	public List<FishSymptmsVO> fish_symptms_List(String treat_code) throws Exception;
	
	/**
	 * 
	 *  개요 : 진료 증상 등록
	 * @Method Name : fish_symptms_Insert
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : 
	 * @throws : Exception
	 */
	public void fish_symptms_Insert(Map<String, String> params) throws Exception;

}
