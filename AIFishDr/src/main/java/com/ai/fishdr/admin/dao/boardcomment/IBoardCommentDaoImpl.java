package com.ai.fishdr.admin.dao.boardcomment;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ai.fishdr.vo.BoardCommentVO;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class IBoardCommentDaoImpl implements IBoardCommentDao {
	@Autowired
	private SqlMapClient smc;

	@Override
	public List<Map<String, BoardCommentVO>> getBoardCommentList(
			Map<String, String> params) throws Exception {
		return smc.queryForList("boardComment.getBoardComment",params);
	}

	@Override
	public int updateBoardComment(BoardCommentVO comment) throws Exception {
		return smc.update("boardComment.updateBoardComment",comment);
	}

	@Override
	public String insertBoardComment(BoardCommentVO comment) throws Exception {
		return (String) smc.insert("boardComment.insertBoardComment",comment);
	}

	@Override
	public int deleteBoardComment(Map<String, String> params) throws Exception {
		return smc.delete("boardComment.deleteBoardComment",params);
	}

	@Override
	public BoardCommentVO getBoardCommentInfo(String comment_no)
			throws Exception {
		return (BoardCommentVO) smc.queryForObject("boardComment.getBoardCommentInfo",comment_no);
	}

	@Override
	public int getTotalCount(String bo_no) throws Exception {
		return (int) smc.queryForObject("boardComment.getTotalCount",bo_no);
	}

}
