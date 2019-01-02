package com.ai.fishdr.admin.serivce.board;

import java.sql.Clob;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ai.fishdr.admin.dao.board.IBoardDao;
import com.ai.fishdr.admin.serivce.boardFile.IBoardFileService;
import com.ai.fishdr.admin.serivce.boardcomment.IBoardCommentService;
import com.ai.fishdr.utils.AttachFileMapper;
import com.ai.fishdr.utils.ClobToString;
import com.ai.fishdr.vo.BoardCommentVO;
import com.ai.fishdr.vo.BoardFileVO;
import com.ai.fishdr.vo.BoardManageVO;
import com.ai.fishdr.vo.BoardVO;
import com.ai.fishdr.vo.SttemntVO;

@Service
public class IBoardServiceImpl implements IBoardService {
	@Autowired
	private IBoardDao dao;
	@Autowired
	private IBoardFileService fileService;
	@Autowired
	private AttachFileMapper file;
	@Autowired
	private IBoardCommentService commentService;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public String insertBoard(BoardManageVO board) throws Exception {
		return dao.insertBoard(board);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public boolean updateBoard(BoardManageVO board) throws Exception {
		boolean result = false;
		int cnt = dao.updateBoard(board);
		if (cnt > 0) {
			result = true;
		}
		return result;
	}
	@Transactional(readOnly=true)
	@Override
	public List<BoardManageVO> getBoardList() throws Exception {
		return dao.getBoardList();
	}

	@Transactional(readOnly=true)
	@Override
	public BoardManageVO getBoardInfo(Map<String, String> params)
			throws Exception {
		return dao.getBoardInfo(params);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public boolean deleteBoard(String[] board_code) throws Exception {
		boolean result = false;
		int cnt =0;
		for (int i = 0; i < board_code.length; i++) {
			cnt +=dao.deleteBoard(board_code[i]);
		}
		if (cnt==board_code.length) {
			result = true;
		}
		return result;
	}
	@Transactional(readOnly=true)
	@Override
	public List<Map<String, BoardVO>> getBoardWriteList(
			Map<String, String> params) throws Exception {
		return dao.getBoardWriteList(params);
	}
	@Transactional(readOnly=true)
	@Override
	public Map<String, Object> getBoardWriteInfo(Map<String, String> params)
			throws Exception {
		Map<String, Object> map = dao.getBoardWriteInfo(params); 
		Clob data = (Clob) map.get("BO_CONTENT");
		String bo_content = ClobToString.convertClobToString(data);
		map.put("BO_CONTENT", bo_content);
		
		Object obj = map.get("BO_NO");
		params.put("bo_no", obj.toString());
		List<BoardFileVO> files = fileService.getBoardFileInfo(params);
		List<Map<String, BoardCommentVO>> comment = commentService.getBoardCommentList(params);
		map.put("FILE", files);
		map.put("comment", comment);
		
		
		return map;
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public boolean insertBoardWrite(BoardVO board, MultipartFile[] files) throws Exception {
		String bo_no = dao.insertBoardWrite(board);
		boolean result = false;
		List<BoardFileVO> fileList=file.mapping(files, bo_no);
		if (!fileList.isEmpty()) {
			BoardFileVO vo = fileList.get(0);
			result  = fileService.insertBoardFile(vo);
		}
		return result;
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public boolean updateBoardWrite(BoardVO board) throws Exception {
		boolean result = false;
		int cnt = dao.updateBoardWrite(board);
		if (cnt>0) {
			result = true;
		} 
		return result;
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public boolean deleteBoardWrite(String[] bo_no)
			throws Exception {
		boolean result = false;
		int cnt = 0;
		for (int i = 0; i < bo_no.length; i++) {
			cnt += dao.deleteBoardWrite(bo_no[i]);
		}
		if (cnt == bo_no.length) {
			result =true;
		}
		return result;
	}

	@Override
	public int getTotalCount(Map<String, String> params) throws Exception {
		return dao.getTotalCount(params);
	}
	@Override
	public List<Map<String, BoardVO>> getBlackWriteList(
			Map<String, String> params) throws Exception {
		return dao.getBlackWriteList(params);
	}
	@Override
	public int getBlackTotalCount(Map<String, String> params) throws Exception {
		return dao.getBlackTotalCount(params);
	}
	@Override
	public List<Map<String, SttemntVO>> getBlackReason(String bo_no) throws Exception {
		return dao.getBlackReason(bo_no);
	}
	@Override
	public List<Map<String, String>> getListOfMemesPrscrptn(
			Map<String, String> params) throws Exception {
		return dao.getListOfMemesPrscrptn(params);
	}
	@Override
	public int getListOfMemesPrscrptnCnt(Map<String, String> params)throws Exception {
		return dao.getListOfMemesPrscrptnCnt(params);
	}
	
	
	
}
