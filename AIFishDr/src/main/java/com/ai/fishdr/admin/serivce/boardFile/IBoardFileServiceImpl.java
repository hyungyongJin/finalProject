package com.ai.fishdr.admin.serivce.boardFile;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ai.fishdr.admin.dao.boardFile.IBoardFileDao;
import com.ai.fishdr.vo.BoardFileVO;

@Service
public class IBoardFileServiceImpl implements IBoardFileService {
	@Autowired
	private IBoardFileDao dao;

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public boolean insertBoardFile(BoardFileVO boardFile) throws Exception {
		boolean result = false;
		Object obj = dao.insertBoardFile(boardFile);
		if (obj==null) {
			result = true;
		}
		return result;
	}

	@Override
	public List<BoardFileVO> getBoardFileInfo(Map<String, String> params)
			throws Exception {
		return dao.getBoardFileInfo(params);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public boolean deleteBoardFile(Map<String, String> params) throws Exception {
		boolean result = false;
		int cnt = dao.deleteBoardFile(params);
		if (cnt>0) {
			result =true;
		}
		return result;
	}

	@Override
	public boolean updateBoardFile(BoardFileVO boardFile) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	@Transactional(propagation=Propagation.SUPPORTS)
	@Override
	public boolean insertBoardFiles(List<BoardFileVO> files) throws Exception {
		boolean result = false;
		for (BoardFileVO boardFileVO : files) {
			Object obj = dao.insertBoardFile(boardFileVO);
			if (obj==null) {
				result = true;
			}
		}
		
		return result;
	}

	@Override
	public BoardFileVO getFileInfo(Map<String, String> params) throws Exception {
		return dao.getFileInfo(params);
	}
	
}
