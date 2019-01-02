package com.ai.fishdr.user.service.imageboardfile;

import java.util.List;
import java.util.Map;

import com.ai.fishdr.vo.BoardFileVO;

public interface IImageboardFileService {
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
	public boolean insertBoardFile(BoardFileVO boardFile) throws Exception;
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
