package com.ai.fishdr.user.dao.fishgramfile;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ai.fishdr.vo.FacePictureVO;
import com.ai.fishdr.vo.FishgramFileVO;
import com.ai.fishdr.vo.MemberVO;
import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * 
 * @Class  Name : IFishgramFileDaoImpl.java
 * @Description : 피쉬그램 파일 DaoImpl 클래스
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
@Repository
public class IFishgramFileDaoImpl implements IFishgramFileDao {

	@Autowired
	private SqlMapClient smc;

	
	/**
	 * 피쉬그램 파일 업로드 관련 오버라이딩
	 */
	@Override
	public void insertFishgramFileInfo(FishgramFileVO ffv) throws SQLException {

		smc.insert("fishgramFile.insertFishgramFileInfo", ffv);
		
	}

	
	/**
	 * 피쉬그램 파일 교체 관련 오버라이딩
	 */
	@Override
	public void updateFishgramFileInfo(FishgramFileVO ffv) throws SQLException {

		smc.update("fishgramFile.updateFishgramFileInfo", ffv);
		
	}

	
	/**
	 * 피쉬그램 파일 삭제 관련 오버라이딩
	 */
	@Override
	public void deleteFishgramFileInfo(Map<String, String> params) throws SQLException {

		smc.update("fishgramFile.deleteFishgramFileInfo", params);
		
	}
	

	/**
	 * 피쉬그램 파일 정보 가져오기 관련 오버라이딩
	 */
	@Override
	public FishgramFileVO fishgramFileInfo(Map<String, String> params) throws SQLException {

		return (FishgramFileVO) smc.queryForObject("fishgramFile.fishgramFileInfo", params);
		
	}

}
