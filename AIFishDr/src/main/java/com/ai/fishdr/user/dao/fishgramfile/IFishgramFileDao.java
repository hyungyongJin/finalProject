package com.ai.fishdr.user.dao.fishgramfile;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ai.fishdr.vo.FacePictureVO;
import com.ai.fishdr.vo.FishgramFileVO;


/**
 * 
 * @Class  Name : IFishgramFileDao.java
 * @Description : 피쉬그램 파일 Dao 인터페이스
 * @Modification Information
 * @author 심재형
 * @since  2018. 11. 14.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일            수정자      수정내용
 *    -------------		-------     -------------------
 *    2018. 11. 14.     심재형      최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
public interface IFishgramFileDao {
	
	/**
	 * 
	 *    의미 : 피쉬그램 파일 등록
	 * @Method : insertFishgramFileInfo
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : ffv (FishgramFileVO 타입)
	 * @return : -
	 * @throws : SQLException
	 */
	public void insertFishgramFileInfo(FishgramFileVO ffv) throws SQLException;
	
	
	/**
	 * 
	 *    의미 : 피쉬그램 파일 교체
	 * @Method : updateFishgramFileInfo
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : ffv (FishgramFileVO 타입)
	 * @return : -
	 * @throws : SQLException
	 */
	public void updateFishgramFileInfo(FishgramFileVO ffv) throws SQLException;
	
	
	/**
	 * 
	 *    의미 : 피쉬그램 파일 삭제
	 * @Method : deleteFishgramFileInfo
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : -
	 * @throws : SQLException
	 */
	public void deleteFishgramFileInfo(Map<String, String> params) throws SQLException;
	
	
	/**
	 * 
	 *    의미 : 피쉬그램 파일 정보 가져오기
	 * @Method : fishgramFileInfo
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : FishgramFileVO
	 * @throws : SQLException
	 */
	public FishgramFileVO fishgramFileInfo(Map<String, String> params) throws SQLException;
		
}
