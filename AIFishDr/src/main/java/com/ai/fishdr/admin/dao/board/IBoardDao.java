package com.ai.fishdr.admin.dao.board;

import java.util.List;
import java.util.Map;

import com.ai.fishdr.vo.BoardManageVO;
import com.ai.fishdr.vo.BoardVO;
import com.ai.fishdr.vo.SttemntVO;

/**
 * 
 * @Class Name :IBoardDao.java
 * @Description : 게시판 전체관리 dao
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
public interface IBoardDao {
	/**
	 * 
	 *  개요 : 게시판 등록
	 * @Method Name : insertBoard
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : boolean
	 * @throws :
	 */
	public String insertBoard(BoardManageVO board) throws Exception;
	/**
	 * 
	 *  개요 : 게시판 수정
	 * @Method Name : updateBoard
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : boolean
	 * @throws :
	 */
	public int updateBoard(BoardManageVO board) throws Exception;
	/**
	 * 
	 *  개요 : 게시판 전체리스트
	 * @Method Name : getBoardList
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : Map<String,BoardManageVO>
	 * @throws :
	 */
	public List<BoardManageVO> getBoardList() throws Exception;
	/**
	 * 
	 *  개요 : 게시판 정보
	 * @Method Name : getBoardInfo
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : BoardManageVO
	 * @throws :
	 */
	public BoardManageVO getBoardInfo(Map<String,String>params) throws Exception;
	/**
	 * 
	 *  개요 : 게시판삭제
	 * @Method Name : deleteBoard
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : boolean
	 * @throws :
	 */
	public int deleteBoard(String board_code) throws Exception;
	/**
	 * 
	 *  개요 : 전체 게시글 리스트
	 * @Method Name : getBoardWriteList
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : List<Map<String,BoardVO>>
	 * @throws :
	 */
	public List<Map<String,BoardVO>> getBoardWriteList(Map<String,String>params)throws Exception;
	/**
	 * 
	 *  개요 : 게시글 상세정보
	 * @Method Name : getBoardWriteInfo
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : BoardVO
	 * @throws :
	 */
	public Map<String,Object> getBoardWriteInfo(Map<String,String>params) throws Exception;
	/**
	 * 
	 *  개요 : 게시글 등록
	 * @Method Name : insertBoardWrite
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : boolean
	 * @throws :
	 */
	public String insertBoardWrite(BoardVO board) throws Exception;
	/**
	 * 
	 *  개요 : 게시글 수정
	 * @Method Name : updateBoardWrite
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : boolean
	 * @throws :
	 */
	public int updateBoardWrite(BoardVO board) throws Exception;
	/**
	 * 
	 *  개요 : 게시글 삭제
	 * @Method Name : deleteBoardWrite
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : boolean
	 * @throws :
	 */
	public int deleteBoardWrite(String bo_no) throws Exception;
	/**
	 * 
	 *  개요 : 불러올 게시글 전체 수
	 * @Method Name : getTotalCount
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : int
	 * @throws :
	 */
	public int getTotalCount(Map<String,String>params) throws Exception;
	/**
	 *  개요 : 신고된 게시물 불러오는 메서드
	 * @Method Name : getBlackWriteList
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : List<Map<String,BoardVO>>
	 * @throws :
	 */
	public List<Map<String, BoardVO>> getBlackWriteList(Map<String, String> params) throws Exception;
	/**
	 *  개요 : 신고된 게시글 리스트 총 갯수 
	 * @Method Name : getBlackTotalCount
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : int
	 * @throws :
	 */
	public int getBlackTotalCount(Map<String, String> params) throws Exception;
		/**
	 *  개요 : 게시글 클릭 시 신고사유 불러오는 메서드
	 * @Method Name : getBlackReason
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : List<Map<String,SttemntVO>>
	 * @throws :
	 */
	public List<Map<String, SttemntVO>> getBlackReason(String bo_no)throws Exception;
	/**
	 *  개요 : 회원들이 의약품을 요청한 질병명과 해당 질병에 대해 처방받은 수
	 * @Method Name : getListOfMemesPrscrptn
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : List<Map<String,String>>
	 * @throws :
	 */
	public List<Map<String, String>> getListOfMemesPrscrptn(
			Map<String, String> params) throws Exception;
	/**
	 *  개요 : 회원들이 의약품을 요청한 질병명에 대한 리스트 수
	 * @Method Name : getListOfMemesPrscrptnCnt
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : int
	 * @throws :
	 */
	public int getListOfMemesPrscrptnCnt(Map<String, String> params)throws Exception;


}
