package com.ai.fishdr.nouser.service.notice;

import java.util.List;
import java.util.Map;

import com.ai.fishdr.vo.BoardVO;

/**
 * 
 * @Class Name :INoUserService.java
 * @Description : 비회원 공지사항 service
 * @Modification Information
 * @author 
 * @since  2018. 11. 12.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일             수정자             수정내용
 *    -------        -------     -------------------
 *    2018. 11. 12.     진형용             최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
public interface INoUserService {

	/**
	 * 
	 *  개요 : 게시글 전체 리스트를 가져오는 메서드
	 * @Method Name : getNoticeList
	 * @author : 유재훈
	 * -----------------------------------
	 * @param : Map<String,String>params
	 * @return : List<Map<String,BoardVO>>
	 * @throws : Exception
	 */
	public List<Map<String,BoardVO>> getNoticeList(Map<String,String>params) throws Exception;
	/**
	 * 
	 *  개요 : 게시물 상세정보를 불러오는 메서드
	 * @Method Name : getNoticeInfo
	 * @author : 유재훈
	 * -----------------------------------
	 * @param : Map<String, String> params
	 * @return : List<Map<String, Object>>
	 * @throws : Exception
	 */
	public List<Map<String, Object>> getNoticeInfo(Map<String, String> params)throws Exception;
	/**
	 * 
	 *  개요 : 해당 게시물의 총게시글 수 불러오는 메서드
	 * @Method Name : getTotalCount
	 * @author : 유재훈
	 * -----------------------------------
	 * @param : Map<String,String>params
	 * @return : int
	 * @throws : Exception
	 */
	public int getTotalCount(Map<String,String>params) throws Exception;
	
	/**
	 * 
	 *  개요 : 조회수
	 * @Method Name : updateHit
	 * @author : 유재훈
	 * -----------------------------------
	 * @param : Map<String, String> params
	 * @return : void
	 * @throws : Exception
	 */
	public void updateHit(Map<String, String> params)throws Exception;
	
	/**
	 * 
	 *  개요 : 좋아요 
	 * @Method Name : updateGoodHit
	 * @author : 유재훈
	 * -----------------------------------
	 * @param : String bo_no
	 * @return : boolean
	 * @throws : Exception
	 */
	public boolean updateGoodHit(String bo_no)throws Exception;
	
	
}
