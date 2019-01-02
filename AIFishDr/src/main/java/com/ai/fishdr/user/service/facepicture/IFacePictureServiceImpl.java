package com.ai.fishdr.user.service.facepicture;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ai.fishdr.nouser.dao.member.IMemberDao;
import com.ai.fishdr.user.dao.facepicture.IFacePictureDao;
import com.ai.fishdr.user.dao.fishgram.IFishgramDao;
import com.ai.fishdr.vo.FacePictureVO;
import com.ai.fishdr.vo.FishgramVO;
import com.ai.fishdr.vo.MemberVO;

/**
 * 
 * @Class  Name : IFacePictureSerivceImpl.java
 * @Description : 프로필 사진 ServiceImpl 클래스
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
@Service
public class IFacePictureServiceImpl implements IFacePictureService {
	
	@Autowired
	private IFacePictureDao dao;

	
	/**
	 * 프로필 사진 등록 관련 오버라이딩
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public void insertFacePictureInfo(FacePictureVO fpv) throws Exception {

		dao.insertFacePictureInfo(fpv);
		
	}

	
	/**
	 * 프로필 사진 수정 관련 오버라이딩
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public void updateFacePictureInfo(Map<String, String> params) throws Exception {

		dao.updateFacePictureInfo(params);
		
	}

	
	/**
	 * AJAX 처리를 위한 프로필 정보 가져오기 관련 오버라이딩
	 */
	@Override
	public FacePictureVO facePictureInfoAjax(Map<String, String> params) throws Exception {

		FacePictureVO fpv = null;
		
		fpv = dao.facePictureInfo(params);
		
		return fpv;
		
	}
	
	
	/**
	 * 프로필 사진 정보 가져오기 관련 오버라이딩
	 */
	@Override
	public FacePictureVO facePictureInfo(Map<String, String> params) throws Exception {

		FacePictureVO fpv = null;
		
		fpv = dao.facePictureInfo(params);
		
		return fpv;
		
	}

	
	/**
	 * 프로필 사진 수 세기 관련 오버라이딩
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public int facePictureCount(Map<String, String> params) throws Exception {

		int count = 0;
		
		count = dao.facePictureCount(params);
		
		return count;
	}

	
	/**
	 * 프로필 사진 삭제 관련 오버라이딩
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public void deleteFacePictureInfo(Map<String, String> params) throws Exception {

		dao.deleteFacePictureInfo(params);
		
	}


	/**
	 * 특정 아이디의 프로필 사진 파일명 가져오기 관련 오버라이딩
	 */
	@Override
	public String getFpFileSaveName(String fp_mem_id) throws Exception {

		return dao.getFpFileSaveName(fp_mem_id);
		
	}


	

	

	

}
