package com.ai.fishdr.user.dao.imageboardconment;

import java.util.List;
import java.util.Map;

import com.ai.fishdr.vo.BoardCommentVO;

public interface IImageboardCommentDao {
	/**
	 * 
	 *  개요 : 댓글리스트 불러오는 메서드
	 * @Method Name : getBoardCommentList
	 * @author : 임범학
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
	 * @author : 임범학
	 * -----------------------------------
	 * @param : 
	 * @return : boolean
	 * @throws :
	 */
	public int updateBoardComment(Map<String, String> params) throws Exception;
	/**
	 * 
	 *  개요 : 댓글 등록
	 * @Method Name : insertBoardComment
	 * @author : 임범학
	 * -----------------------------------
	 * @param : 
	 * @return : boolean
	 * @throws :
	 */
	public String insertBoardComment(BoardCommentVO comment) throws Exception;
	/**
	 * 
	 *  개요 : 댓글 삭제
	 * @Method Name : deleteBoardComment
	 * @author : 임범학
	 * -----------------------------------
	 * @param : 
	 * @return : boolean
	 * @throws :
	 */
	public int deleteBoardComment(Map<String, String>params) throws Exception;
	/**
	 * 
	 *  개요 : 댓글 정보
	 * @Method Name : getBoardCommentInfo
	 * @author : 임범학
	 * -----------------------------------
	 * @param : 
	 * @return : BoardCommentVO
	 * @throws :
	 */
	public BoardCommentVO getBoardCommentInfo(String comment_no)throws Exception;
	

	/**
	 * 
	 *  개요 :댓글 페이징 
	 * @Method Name : commendTotalcount
	 * @author : 임범학
	 * -----------------------------------
	 * @param : 
	 * @return : Map<String, String> param
	 * @throws :Exception
	 */
	public int commendTotalcount(Map<String, String> param) throws Exception;	
}
