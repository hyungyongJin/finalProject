package com.ai.fishdr.user.service.fishgramfile;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ai.fishdr.user.dao.fishgram.IFishgramDao;
import com.ai.fishdr.user.dao.fishgramfile.IFishgramFileDao;
import com.ai.fishdr.vo.FishgramFileVO;
import com.ai.fishdr.vo.FishgramVO;

/**
 * 
 * @Class  Name : IFishgramFileSerivceImpl.java
 * @Description : 피쉬그램 파일 ServiceImpl 클래스
 * @Modification Information
 * @author 심재형
 * @since  2018. 11. 13.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일            수정자      수정내용
 *    -------------		-------     -------------------
 *    2018. 11. 13.     심재형      최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
@Service
public class IFishgramFileServiceImpl implements IFishgramFileService {
	
	@Autowired
	private IFishgramFileDao dao;

	
	/**
	 * 피쉬그램 파일 업로드 관련 오버라이딩
	 */
	@Override
	public void insertFishgramFileInfo(FishgramFileVO ffv) {

		try {
			
			dao.insertFishgramFileInfo(ffv);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
	}

	
	/**
	 * 피쉬그램 파일 교체 관련 오버라이딩
	 */
	@Override
	public void updateFishgramFileInfo(FishgramFileVO ffv) {

		try {
			
			dao.updateFishgramFileInfo(ffv);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
	}

	
	/**
	 * 피쉬그램 파일 삭제 관련 오버라이딩
	 */
	@Override
	public void deleteFishgramFileInfo(Map<String, String> params) {

		try {
			
			dao.deleteFishgramFileInfo(params);
			
		} catch (SQLException e) {

			e.printStackTrace();
			
		}
		
	}

	
	/**
	 * 피쉬그램 파일 정보 가져오기 관련 트랜잭션 및 오버라이딩
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW, rollbackFor={Exception.class})
	@Override
	public FishgramFileVO fishgramFileInfo(Map<String, String> params) throws SQLException {

		return dao.fishgramFileInfo(params);
		
	}

}
