package com.ai.fishdr.admin.serivce.boardcomment;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ai.fishdr.admin.dao.boardcomment.IBoardCommentDao;
import com.ai.fishdr.vo.BoardCommentVO;

@Service
public class IBoardCommentServiceImpl implements IBoardCommentService {
	@Autowired
	private IBoardCommentDao dao;

	@Override
	public List<Map<String, BoardCommentVO>> getBoardCommentList(
			Map<String, String> params) throws Exception {
		return dao.getBoardCommentList(params);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public boolean updateBoardComment(BoardCommentVO comment) throws Exception {
		boolean result = false;
		int cnt = dao.updateBoardComment(comment);
		if (cnt>0) {
			result = true;
		}
		return result;
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
	public int getTotalCount(String bo_no) throws Exception {
		return dao.getTotalCount(bo_no);
	}

}
