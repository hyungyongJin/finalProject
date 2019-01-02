package com.ai.fishdr.admin.serivce.boardcomment;

import java.util.List;
import java.util.Map;

import com.ai.fishdr.vo.BoardCommentVO;

/**
 * 
 * @Class Name :IBoardCommentService.java
 * @Description : 관리자 게시판 댓글관리
 * @Modification Information
 * @author 진형용
 * @since  2018. 11. 15.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일             수정자             수정내용
 *    -------        -------     -------------------
 *    2018. 11. 15.     진형용             최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
public interface IBoardCommentService {
	/**
	 * 
	 *  개요 : 댓글리스트 불러오는 메서드
	 * @Method Name : getBoardCommentList
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : List<Map<String,BoardCommentVO>>
	 * @throws :
	 */
	public List<Map<String,BoardCommentVO>> getBoardCommentList(Map<String,String>params) throws Exception;
	/**
	 * 
	 *  개요 : 댓글 수정
	 * @Method Name : updateBoardComment
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : boolean
	 * @throws :
	 */
	public boolean updateBoardComment(BoardCommentVO comment) throws Exception;
	/**
	 * 
	 *  개요 : 댓글 등록
	 * @Method Name : insertBoardComment
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : String
	 * @throws :
	 */
	public String insertBoardComment(BoardCommentVO comment) throws Exception;
	/**
	 * 
	 *  개요 : 댓글 삭제
	 * @Method Name : deleteBoardComment
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : boolean
	 * @throws :
	 */
	public boolean deleteBoardComment(Map<String, String>params) throws Exception;
	/**
	 * 
	 *  개요 :댓글 정보 
	 * @Method Name : getBoardCommentInfo
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : BoardCommentVO
	 * @throws :
	 */
	public BoardCommentVO getBoardCommentInfo(String comment_no) throws Exception;
	/**
	 * 
	 *  개요 :댓글 총 갯수 
	 * @Method Name : getTotalCount
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : int
	 * @throws :
	 */
	public int getTotalCount(String bo_no) throws Exception;
}
