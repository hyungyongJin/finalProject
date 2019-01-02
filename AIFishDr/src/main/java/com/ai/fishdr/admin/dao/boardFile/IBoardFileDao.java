package com.ai.fishdr.admin.dao.boardFile;

import java.util.List;
import java.util.Map;

import com.ai.fishdr.vo.BoardFileVO;

/**
 * 
 * @Class Name :IBoardFileDao.java
 * @Description : 게시판 파일 dao
 * @Modification Information
 * @author 
 * @since  2018. 11. 14.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일             수정자             수정내용
 *    -------        -------     -------------------
 *    2018. 11. 14.     진형용             최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
public interface IBoardFileDao {
	/**
	 * 
	 *  개요 : 파일등록
	 * @Method Name : insertBoardFile
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : boolean
	 * @throws :
	 */
	public Object insertBoardFile(BoardFileVO boardFile) throws Exception;
	/**
	 * 
	 *  개요 : 게시판 파일정보
	 * @Method Name : getBoardFileInfo
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : BoardFileVO
	 * @throws :
	 */
	public List<BoardFileVO> getBoardFileInfo(Map<String,String>params) throws Exception;
	/**
	 * 
	 *  개요 : 게시판 파일 삭제
	 * @Method Name : deleteBoardFile
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : boolean
	 * @throws :
	 */
	public int deleteBoardFile(Map<String,String>params) throws Exception;
	/**
	 * 
	 *  개요 : 게시파일 수정
	 * @Method Name : updateBoardFile
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : boolean
	 * @throws :
	 */
	public int updateBoardFile(BoardFileVO boardFile) throws Exception;
	/**
	 * 
	 *  개요 : 파일 상세정보
	 * @Method Name : getFileInfo
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : BoardFileVO
	 * @throws :
	 */
	public BoardFileVO getFileInfo(Map<String, String> params) throws Exception;
	

}
