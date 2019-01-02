package com.ai.fishdr.user.dao.fishgram;

import java.util.List;
import java.util.Map;

import com.ai.fishdr.vo.FishgramVO;

/**
 * 
 * @Class  Name : IFishgramDao.java
 * @Description : 피쉬그램 전체관리 Dao 인터페이스
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
public interface IFishgramDao {
	
	/**
	 * 
	 *    의미 : 피쉬그램 글 등록
	 * @Method : insertFishgramDiary
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : fgv (FishgramVO 타입)
	 * @return : -
	 * @throws : Exception
	 */
	public void insertFishgramDiary(FishgramVO fgv) throws Exception;
	
	
	/**
	 * 
	 *    의미 : 피쉬그램 글 수정
	 * @Method : updateFishgramDiary
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : fgv (FishgramVO 타입)
	 * @return : -
	 * @throws : Exception
	 */
	public void updateFishgramDiary(FishgramVO fgv) throws Exception;
	
	
	/**
	 * 
	 *    의미 : 피쉬그램 글 전체 리스트
	 * @Method : getFishgramList
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : List<FishgramVO>
	 * @throws : Exception
	 */
	public List<FishgramVO> getFishgramDiaryList(Map<String, String> params) throws Exception;
	
	
	/**
	 * 
	 *    제목 : 피쉬그램 글 삭제
	 * @Method : deleteFishgramDiary
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : bo_no (String 타입)
	 * @return : -
	 * @throws : Exception
	 */
	public void deleteFishgramDiary(String bo_no) throws Exception;

	
	/**
	 * 
	 *    제목 : 조건에 맞는 특정 작성자가 작성한 피쉬그램 글 개수 계산
	 * @Method : totalFishgramDiaryCount
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : int
	 * @throws : Exception
	 */
	public int totalFishgramDiaryCount(Map<String, String> params) throws Exception;
	
	
	/**
	 * 
	 *    제목 : 특정 작성자가 작성한 피쉬그램 글 총 개수 계산
	 * @Method : totalFishgramDiaryCount
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : int
	 * @throws : Exception
	 */
	int totalFishgramDiaryAllCount(Map<String, String> params) throws Exception;
	
	
	/**
	 * 
	 *    제목 : 자신의 모든 글에 카운팅된 좋아요 총 수
	 * @Method : totalLikeAllCount
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : int
	 * @throws : Exception
	 */
	public int totalLikeAllCount(Map<String, String> params) throws Exception;
	
	
	/**
	 * 
	 *    제목 : 로그인 한 회원의 친구 총 인원 구하기
	 * @Method : totalSearchFriendAllCount
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : mem_id (String 타입)
	 * @return : int
	 * @throws : Exception
	 */
	public int totalSearchFriendAllCount(String mem_id) throws Exception;
	
	
	/**
	 * 
	 *    제목 : 피쉬그램 게시글 번호를 이용한 게시글 정보 가져오기
	 * @Method : getFishgramDiaryInfoAsBoNo
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String,String> 타입)
	 * @return : FishgramVO
	 * @throws : Exception
	 */
	public FishgramVO getFishgramDiaryInfoAsBoNo(Map<String, String> params) throws Exception;
	
	
	/**
	 * 
	 *    제목 : 게시판 작성자를 이용하여 닉네임 정보 가져오기
	 * @Method : getMemIdAsBoWriter
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String,String> 타입)
	 * @return : String
	 * @throws : Exception
	 */
	public String getMemIdAsBoWriter(Map<String, String> params) throws Exception;
	
	
	/**
	 * 
	 *    제목 : 특정 글 조회수 1 증가시키기
	 * @Method : increaseHitCount
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : hitCountParams (Map<String,String> 타입)
	 * @return : -
	 * @throws : Exception
	 */
	public void increaseHitCount(Map<String, String> hitCountParams) throws Exception;


	
	
}
