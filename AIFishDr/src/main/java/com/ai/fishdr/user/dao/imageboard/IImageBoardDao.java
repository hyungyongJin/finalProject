package com.ai.fishdr.user.dao.imageboard;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.ai.fishdr.vo.BoardVO;
import com.ai.fishdr.vo.SttemntVO;


/**
 * 
 * @Class  Name : IImageBoardDao.java
 * @Description : 이미지게시판 Dao 인터페이스
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

public interface IImageBoardDao {

	
	
	/**
	 * 
	 *    의미 : 이미지 게시판 게시글 리스트 출력
	 * @Method : getBBS
	 * @author : 임범학
	 * -----------------------------------
	 * @param  : parmas 
	 * @return : List
	 * @throws : Exception
	 */
	public List<BoardVO> getBBS(Map<String, String> params) throws Exception;
//	public String insertBBS(BoardVO vo) throws SQLException;
	
	
	
	/**
	 * 
	 *    의미 : 이미지 게시판 게시글 조회수
	 * @Method : getBBS
	 * @author : 임범학
	 * -----------------------------------
	 * @param  : parmas 
	 * @return : List
	 * @throws : Exception
	 */
	public void updateHit(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 *    의미 : 이미지 게시판 해당 게시글 정보
	 * @Method : getBBSInfo
	 * @author : 임범학
	 * -----------------------------------
	 * @param  : parmas 
	 * @return : BoardVO
	 * @throws : Exception
	 */
	public Map<String, Object> getBBSInfo(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 *  개요 : 좋아요 
	 * @Method Name : updateGoodHit
	 * @author : 임범학
	 * -----------------------------------
	 * @param : 
	 * @return : boolean
	 * @throws :
	 */
	public int updateGoodHit(String bo_no)throws Exception;
	/**
	 * 
	 *  개요 : 신고
	 * @Method Name : updateBadHit
	 * @author : 임범학
	 * -----------------------------------
	 * @param : 
	 * @return : boolean
	 * @throws :
	 */
	public Object insertBadHit(SttemntVO vo)throws Exception;
	/**
	 *  개요 : 신고한 게시글인지 아닌지 체크
	 * @Method Name : getBlack
	 * @author : 임범학
	 * -----------------------------------
	 * @param : 
	 * @return : int
	 * @throws :
	 */
	public int getBlack(Map<String, String> params)throws Exception;
	
	/**
	 * 
	 *    의미 : 이미지 게시판 게시글 삭제
	 * @Method : deleteBBS
	 * @author : 임범학
	 * -----------------------------------
	 * @param  : parmas 
	 * @return : void
	 * @throws : Exception
	 */
	public void deleteBBS(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 *    의미 : 이미지 게시판 게시글 수정
	 * @Method : deleteBBS
	 * @author : 임범학
	 * -----------------------------------
	 * @param  : parmas 
	 * @return : void
	 * @throws : Exception
	 */
	public int updateBBS(BoardVO vo) throws Exception;
	
	/**
	 * 
	 *    의미 : 이미지 게시판 게시글 댓글 등록
	 * @Method : insertReplyBBS
	 * @author : 임범학
	 * -----------------------------------
	 * @param  : parmas 
	 * @return : void
	 * @throws : Exception
	 */
	public void insertReplyBBS(BoardVO vo) throws Exception;
	
	/**
	 * 
	 *    의미 : 이미지 게시판 총 게시글 수
	 * @Method : totalCount
	 * @author : 임범학
	 * -----------------------------------
	 * @param  : parmas 
	 * @return : void
	 * @throws : Exception
	 */
	public int totalCount(Map<String, String> params) throws Exception;
//	public void updateThumnail(Map<String, String> params) throws Exception;
//	public void updatePic(Map<String, String> params) throws Exception;
	
	
	public String insertBBS(BoardVO vo) throws Exception;
	
}
