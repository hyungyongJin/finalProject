package com.ai.fishdr.user.service.imageboardcomment;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ai.fishdr.user.dao.imageboardconment.IImageboardCommentDao;
import com.ai.fishdr.vo.BoardCommentVO;


@Service
public class IImageboardCommentServiceImpl implements IImageboardCommentService{

	
	@Autowired
	private IImageboardCommentDao dao;

	@Override
	public List<Map<String, BoardCommentVO>> getBoardCommentList(
			Map<String, String> params) throws Exception {
		return dao.getBoardCommentList(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public int updateBoardComment(Map<String, String> params) throws Exception {

		return dao.updateBoardComment(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public String insertBoardComment(BoardCommentVO comment) throws Exception {
		return dao.insertBoardComment(comment);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public boolean deleteBoardComment(Map<String, String> params)
			throws Exception {
		boolean result = false;
		int cnt = dao.deleteBoardComment(params);
		if (cnt >0 ) {
			result = true;
		}
		return result;
	}

	@Override
	public BoardCommentVO getBoardCommentInfo(String comment_no)
			throws Exception {
		return dao.getBoardCommentInfo(comment_no);
	}

	@Override
	public int commendTotalcount(Map<String, String> param) throws Exception {
		int cnt=0;
		
		cnt = dao.commendTotalcount(param);
		
		return cnt;
	}

}
