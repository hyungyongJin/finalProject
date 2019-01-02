package com.ai.fishdr.user.dao.imageboardfile;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ai.fishdr.vo.BoardFileVO;

/**
 * 
 * @Class  Name : IImageBoardDao.java
 * @Description : 이미지게시판 파일  Dao 인터페이스
 * @Modification Information
 * @author  임범학
 * @since  2018. 11. 15.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일            수정자      수정내용
 *    -------------		-------     -------------------
 *    2018. 11. 13.     임범학      최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */

public interface IImageFileItemDao {

	
	/**
	 * 
	 *  개요 : 파일등록
	 * @Method Name : insertBoardFile
	 * @author : 임범학
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
	 * @author : 임범학
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
	 * @author : 임범학
	 * -----------------------------------
	 * @param : 
	 * @return : boolean
	 * @throws :
	 */
	public boolean deleteBoardFile(Map<String,String>params) throws Exception;
	/**
	 * 
	 *  개요 : 게시파일 수정
	 * @Method Name : updateBoardFile
	 * @author : 임범학
	 * -----------------------------------
	 * @param : 
	 * @return : boolean
	 * @throws :
	 */
	public boolean updateBoardFile(BoardFileVO boardFile) throws Exception;
	
}
