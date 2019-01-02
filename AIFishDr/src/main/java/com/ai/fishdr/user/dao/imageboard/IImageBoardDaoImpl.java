package com.ai.fishdr.user.dao.imageboard;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ai.fishdr.vo.BoardVO;
import com.ai.fishdr.vo.SttemntVO;
import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * 
 * @Class  Name : IImageBoardDao.java
 * @Description : 이미지게시판  DaoImpl 클래스
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

@Repository
public class IImageBoardDaoImpl implements IImageBoardDao{
	@Resource
	private SqlMapClient smc;
	
	
	
	/**
	 * 이미지게시판 리스트 출력 오버라이딩
	 */
	@Override
	public List<BoardVO> getBBS(Map<String, String> params)
			throws SQLException {
		return smc.queryForList("imageboard.getBoardWriteList",params);
	}
//	@Override
//	public String insertBBS(BoardVO vo) throws SQLException {
//		return (String) smc.insert("imageboard.insertSomeboard",vo);
//	}
	
	/**
	 * 이미지게시판 게시글 조회수
	 */
	@Override
	public void updateHit(Map<String, String> params) throws Exception {
		smc.update("imageboard.updateHit",params);
	}
	
	
	/**
	 * 이미지게시판 게시글 정보
	 */
	@Override
	public Map<String, Object> getBBSInfo(Map<String, String> params)
			throws Exception {
		return  (Map<String, Object>) smc.queryForObject("imageboard.getBBSInfo",params);
	}
	
	/**
	 * 이미지게시판 게시글 삭제
	 */
	
	@Override
	public void deleteBBS(Map<String, String> params) throws Exception {
		smc.update("imageboard.deleteBBS",params);
	}
//	@Override
//	public void updateBBS(BoardVO vo) throws SQLException {
//		smc.update("imageboard.updateBBS",vo);
//	}
	
	/**
	 * 이미지게시판 해당 게시글 댓글입력
	 */
	@Override
	public void insertReplyBBS(BoardVO vo) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 이미지게시판 해당 게시글 갯수
	 */
	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return (int) smc.queryForObject("imageboard.getTotalCount",params);
	}
	

	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public String insertBBS(BoardVO vo) throws Exception {
		
		return (String) smc.insert("imageboard.insertBoardWrite", vo);
		
	}

	/*
	 	이미지게시글 수정 메서드
	 *
	 */
	@Override
	public int updateBBS(BoardVO vo) throws Exception {
		return smc.update("imageboard.updateBoard", vo);
		
	}

	@Override
	public int updateGoodHit(String bo_no) throws Exception {
		return smc.update("imageboard.updateGoodHit",bo_no);
	}

	@Override
	public Object insertBadHit(SttemntVO vo) throws Exception {
		return smc.insert("imageboard.insertBadHit",vo);
	}

	@Override
	public int getBlack(Map<String, String> params) throws Exception {
		return (int) smc.queryForObject("imageboard.getBlack",params);
	}
}
