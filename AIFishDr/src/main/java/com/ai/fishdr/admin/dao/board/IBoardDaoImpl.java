package com.ai.fishdr.admin.dao.board;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ai.fishdr.vo.BoardManageVO;
import com.ai.fishdr.vo.BoardVO;
import com.ai.fishdr.vo.SttemntVO;
import com.ibatis.sqlmap.client.SqlMapClient;
@Repository
public class IBoardDaoImpl implements IBoardDao{

	@Autowired
	private SqlMapClient smc;

	@Override
	public String insertBoard(BoardManageVO board) throws Exception {
		return (String) smc.insert("boardManage.insertBoard",board);
	}

	@Override
	public int updateBoard(BoardManageVO board) throws Exception {
		return smc.update("boardManage.updateBoard",board);
	}

	@Override
	public List<BoardManageVO> getBoardList() throws Exception {
		return smc.queryForList("boardManage.getBoardList");
	}

	@Override
	public BoardManageVO getBoardInfo(Map<String, String> params)
			throws Exception {
		return (BoardManageVO) smc.queryForObject("boardManage.getBoardInfo",params);
	}

	@Override
	public int deleteBoard(String board_code) throws Exception {
		return smc.update("boardManage.deleteBoard",board_code);
	}
	@Override
	public List<Map<String, BoardVO>> getBoardWriteList(
			Map<String, String> params) throws Exception {
		return smc.queryForList("board.getBoardWriteList",params);
	}

	@Override
	public Map<String, Object> getBoardWriteInfo(Map<String, String> params)
			throws Exception {
		return (Map<String, Object>) smc.queryForObject("board.getBoardWriteInfo",params);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public String insertBoardWrite(BoardVO board) throws Exception {
		return (String) smc.insert("board.insertBoardWrite",board);
	}

	@Override
	public int updateBoardWrite(BoardVO board) throws Exception {
		return smc.update("board.updateBoardWrite",board);
	}

	@Override
	public int deleteBoardWrite(String bo_no)
			throws Exception {
		return smc.delete("board.deleteBoardWrite",bo_no);
	}

	@Override
	public int getTotalCount(Map<String, String> params) throws Exception {
		return (int) smc.queryForObject("board.getTotalCount", params);
	}

	@Override
	public List<Map<String, BoardVO>> getBlackWriteList(
			Map<String, String> params) throws Exception {
		return smc.queryForList("board.getBlackWriteList",params);
	}

	@Override
	public int getBlackTotalCount(Map<String, String> params) throws Exception {
		return (int) smc.queryForObject("board.getBlackTotalCount",params);
	}

	@Override
	public List<Map<String, SttemntVO>> getBlackReason(String bo_no)
			throws Exception {
		return smc.queryForList("board.getBlackReason",bo_no);
	}

	@Override
	public List<Map<String, String>> getListOfMemesPrscrptn(
			Map<String, String> params) throws Exception {
		return smc.queryForList("board.getListOfMemesPrscrptn",params);
	}

	@Override
	public int getListOfMemesPrscrptnCnt(Map<String, String> params) throws SQLException {
		return (int) smc.queryForObject("board.getListOfMemesPrscrptnCnt",params);
	}

}
