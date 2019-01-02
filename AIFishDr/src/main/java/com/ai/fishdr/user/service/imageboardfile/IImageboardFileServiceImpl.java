package com.ai.fishdr.user.service.imageboardfile;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ai.fishdr.user.dao.imageboard.IImageBoardDao;
import com.ai.fishdr.user.dao.imageboardfile.IImageFileItemDao;
import com.ai.fishdr.utils.AttachFileMapper;
import com.ai.fishdr.vo.BoardFileVO;


@Service
public class IImageboardFileServiceImpl implements IImageboardFileService{
   
	
	@Autowired
	private IImageFileItemDao dao;
	@Autowired
	private IImageBoardDao boardDao;
	@Autowired
	private AttachFileMapper file;
	
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

	@Override
	public boolean deleteBoardFile(Map<String, String> params) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateBoardFile(BoardFileVO boardFile) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
}
