package com.ai.fishdr.admin.dao.boardFile;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ai.fishdr.vo.BoardFileVO;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class IBoardFileDaoImpl implements IBoardFileDao{
	@Autowired
	private SqlMapClient smc;

	@Override
	public Object insertBoardFile(BoardFileVO boardFile) throws Exception {
		return smc.insert("boardFile.insertBoardFile",boardFile);
	}

	@Override
	public List<BoardFileVO> getBoardFileInfo(Map<String, String> params)
			throws Exception {
		return smc.queryForList("boardFile.getBoardFileList",params);
	}

	@Override
	public int deleteBoardFile(Map<String, String> params) throws Exception {
		return smc.delete("boardFile.deleteBoardFile",params);
	}

	@Override
	public int updateBoardFile(BoardFileVO boardFile) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BoardFileVO getFileInfo(Map<String, String> params) throws Exception {
		return (BoardFileVO) smc.queryForObject("boardFile.getFileInfo",params);
	}
	
}
