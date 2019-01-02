package com.ai.fishdr.user.dao.imageboardconment;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ai.fishdr.vo.BoardCommentVO;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class IImageboardCommentDaoImpl implements IImageboardCommentDao{
	@Autowired
	private SqlMapClient smc;

	@Override
	public List<Map<String, BoardCommentVO>> getBoardCommentList(
			Map<String, String> params) throws Exception {
		return smc.queryForList("imageboard.getBoardComment",params);
	}

	@Override
	public int updateBoardComment(Map<String, String> params) throws Exception {
		
		return smc.update("imageboard.updateBoardComment", params);
	}

	@Override
	public String insertBoardComment(BoardCommentVO comment) throws Exception {
		return (String) smc.insert("imageboard.insertBoardComment",comment);
	}

	@Override
	public int deleteBoardComment(Map<String, String> params) throws Exception {
		return smc.delete("imageboard.deleteBoardComment",params);
	}

	@Override
	public BoardCommentVO getBoardCommentInfo(String comment_no)
			throws Exception {
		return (BoardCommentVO) smc.queryForObject("imageboard.getBoardCommentInfo",comment_no);
	}

	@Override
	public int commendTotalcount(Map<String, String> param) throws Exception {
		
		return (int) smc.queryForObject("imageboard.getCommendTotalcount", param);
	}
}
