package com.ai.fishdr.user.service.facepicture;

import java.util.Map;

import com.ai.fishdr.vo.FacePictureVO;
import com.ai.fishdr.vo.MemberVO;
/**
 * 
 * @Class  Name : IFacePictureService.java
 * @Description : 프로필 사진 Service 인터페이스
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
public interface IFacePictureService {
	
	/**
	 * 
	 *    의미 : 프로필 사진 등록
	 * @Method : insertFacePictureInfo
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : fishgram (FishgramVO 타입)
	 * @return : -
	 * @throws : Exception
	 */
	public void insertFacePictureInfo(FacePictureVO fpv) throws Exception;
	
	
	/**
	 * 
	 *    의미 : 프로필 사진 수정
	 * @Method : updateFacePictureInfo
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : -
	 * @throws : Exception
	 */
	public void updateFacePictureInfo(Map<String, String> params) throws Exception;
	
	
	/**
	 * 
	 *    의미 : AJAX 처리를 위한 프로필 정보 가져오기
	 * @Method : facePictureInfoAjax
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : FacePictureVO
	 * @throws : Exception
	 */
	public FacePictureVO facePictureInfoAjax(Map<String, String> params) throws Exception;
	
	
	/**
	 * 
	 *    의미 : 프로필 사진 정보 가져오기
	 * @Method : facePictureInfo
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : FacePictureVO
	 * @throws : Exception
	 */
	public FacePictureVO facePictureInfo(Map<String, String> params) throws Exception;
	
	
	/**
	 * 
	 *    의미 : 프로필 사진 등록 수 세기
	 * @Method : facePictureCount
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : int
	 * @throws : Exception
	 */
	public int facePictureCount(Map<String, String> params) throws Exception;
	
	
	/**
	 * 
	 *    의미 : 프로필 사진 삭제
	 * @Method : deleteFacePictureInfo
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : -
	 * @throws : Exception
	 */
	public void deleteFacePictureInfo(Map<String, String> params) throws Exception;
	
	
	/**
	 * 
	 *    의미 : 특정 아이디의 프로필 사진 파일명 가져오기
	 * @Method : deleteFacePictureInfo
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : -
	 * @throws : Exception
	 */
	public String getFpFileSaveName(String fp_mem_id) throws Exception;
	
	
	
}
