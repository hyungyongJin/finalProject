package com.ai.fishdr.user.service.fishgramcomment;

import java.util.List;
import java.util.Map;

import com.ai.fishdr.vo.FishgramCommentVO;

/**
 * 
 * @Class  Name : IFishgramCommentService.java
 * @Description : 피쉬그램 댓글 전체관리 Service 인터페이스
 * @Modification Information
 * @author 심재형
 * @since  2018. 11. 21.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일            수정자      수정내용
 *    -------------		-------     -------------------
 *    2018. 11. 21.     심재형      최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
public interface IFishgramCommentService {
	
	/**
	 * 
	 *    의미 : 피쉬그램 댓글 등록
	 * @Method : insertFishgramDiaryComment
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : -
	 * @throws : Exception
	 */
	public void insertFishgramDiaryComment(Map<String, String> params) throws Exception;
	
	
	/**
	 * 
	 *    의미 : 피쉬그램 댓글 수정
	 * @Method : modifyFishgramDiaryComment
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : -
	 * @throws : Exception
	 */
	public void modifyFishgramDiaryComment(Map<String, String> params) throws Exception;
	
	
	/**
	 * 
	 *    의미 : 피쉬그램 댓글 삭제
	 * @Method : deleteFishgramDiaryComment
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : -
	 * @throws : Exception
	 */
	public void deleteFishgramDiaryComment(Map<String, String> params) throws Exception;
	
	
	/**
	 * 
	 *    의미 : 특정 글에 등록된 댓글 전체 리스트 가져오기
	 * @Method : getFishgramDiaryCommentList
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : List<FishgramCommentVO>
	 * @throws : Exception
	 */
	public List<Map<String, FishgramCommentVO>> getFishgramDiaryCommentList(Map<String, String> params) throws Exception;
	
	
	/**
	 * 
	 *    의미 : 특정 글에 댓글을 올린 아이디 리스트 (중복제거, 아이디 오름차순)
	 * @Method : getFishgramDiaryCommentList
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : List<FishgramCommentVO>
	 * @throws : Exception
	 */
	public List<String> getCommentMemIdNoDuplicate() throws Exception;
	
	
	/**
	 * 
	 *    의미 : 특정 글의 댓글 총 개수
	 * @Method : totalFishgramDiaryCommentCount
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : int
	 * @throws : Exception
	 */
	public int totalFishgramDiaryCommentCount(Map<String, String> params) throws Exception;
	
}
