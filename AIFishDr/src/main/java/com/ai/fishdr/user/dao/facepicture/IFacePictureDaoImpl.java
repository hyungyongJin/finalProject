package com.ai.fishdr.user.dao.facepicture;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ai.fishdr.vo.FacePictureVO;
import com.ai.fishdr.vo.MemberVO;
import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * 
 * @Class  Name : IFacePictureDaoImpl.java
 * @Description : 프로필 사진 DaoImpl 클래스
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
public class IFacePictureDaoImpl implements IFacePictureDao {

	@Autowired
	private SqlMapClient smc;

	/**
	 * 프로필 사진 등록 관련 오버라이딩
	 */
	@Override
	public void insertFacePictureInfo(FacePictureVO fpv) throws Exception {

		smc.insert("facePicture.insertFacePictureInfo", fpv);
		
	}

	
	/**
	 * 프로필 사진 수정 관련 오버라이딩
	 */
	@Override
	public void updateFacePictureInfo(Map<String, String> params) throws Exception {

		smc.update("facePicture.updateFacePictureInfo", params);
		
	}

	
	/**
	 * AJAX 처리를 위한 프로필 정보 가져오기 관련 오버라이딩
	 */
	@Override
	public FacePictureVO facePictureInfoAjax(Map<String, String> params) throws Exception {

		return (FacePictureVO) smc.queryForObject("facePicture.facePictureInfoAjax", params);
		
	}
	
	
	/**
	 * 프로필 사진 정보 가져오기 관련 오버라이딩
	 */
	@Override
	public FacePictureVO facePictureInfo(Map<String, String> params) throws Exception {

		return (FacePictureVO) smc.queryForObject("facePicture.facePictureInfo", params);
		
	}

	
	/**
	 * 프로필 사진 수 세기 관련 오버라이딩
	 */
	@Override
	public int facePictureCount(Map<String, String> params) throws Exception {

		return (int) smc.queryForObject("facePicture.facePictureCount", params);
		
	}

	
	/**
	 * 프로필 사진 삭제 관련 오버라이딩
	 */
	@Override
	public void deleteFacePictureInfo(Map<String, String> params) throws Exception {

		smc.delete("facePicture.deleteFacePictureInfo", params);
		
	}


	/**
	 * 특정 아이디의 프로필 사진 파일명 가져오기 관련 오버라이딩
	 */
	@Override
	public String getFpFileSaveName(String fp_mem_id) throws Exception {
		
		return (String) smc.queryForObject("facePicture.getFpFileSaveName", fp_mem_id);
		
	}


	

}
