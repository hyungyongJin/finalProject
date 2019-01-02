package com.ai.fishdr.user.dao.fishgramlike;

import java.util.List;
import java.util.Map;

import com.ai.fishdr.vo.FishgramLikeVO;
import com.ai.fishdr.vo.FriendVO;


/**
 * 
 * @Class  Name : IFishgramLikeDao.java
 * @Description : 피쉬그램 좋아요 전체관리 Dao 인터페이스
 * @Modification Information
 * @author 심재형
 * @since  2018. 11. 30.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일            수정자      수정내용
 *    -------------		-------     -------------------
 *    2018. 11. 30.     심재형      최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
public interface IFishgramLikeDao {
	
	/**
	 * 
	 *    의미 : 선택한 피쉬그램 글에 좋아요 추가
	 * @Method : insertFishgramDiaryLike
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : -
	 * @throws : Exception
	 */
	public void insertFishgramDiaryLike(Map<String, String> params) throws Exception;
	
	
	/**
	 * 
	 *    의미 : 선택한 피쉬그램 글에 추가한 좋아요를 취소하기
	 * @Method : deleteFishgramDiaryLike
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : -
	 * @throws : Exception
	 */
	public void deleteFishgramDiaryLike(Map<String, String> params) throws Exception;
	
	
	/**
	 * 
	 *    의미 : 현재 글의 좋아요 수 구하기
	 * @Method : insertFishgramDiaryLike
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : -
	 * @throws : Exception
	 */
	public int totalFishgramDiaryLikeCount(String bo_no) throws Exception;
	
	
	/**
	 * 
	 *    의미 : 해당 글의 특정 아이디의 좋아요 상태 값을 가져오기
	 * @Method : getLikeStatus
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : String
	 * @throws : Exception
	 */
	public String getLikeStatus(Map<String, String> params) throws Exception;
	
	
	/**
	 * 
	 *    의미 : 입력받은 닉네임 조건에 맞는 좋아요 누른 회원 리스트 출력
	 * @Method : searchLike
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : List<Map<String, FishgramLikeVO>>
	 * @throws : Exception
	 */
	public List<Map<String, FishgramLikeVO>> searchLike(Map<String, String> params) throws Exception;
		
}
