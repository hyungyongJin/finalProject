package com.ai.fishdr.user.service.freeboard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ai.fishdr.admin.serivce.boardFile.IBoardFileService;
import com.ai.fishdr.admin.serivce.boardcomment.IBoardCommentService;
import com.ai.fishdr.user.dao.freeboard.IFreeboardDao;
import com.ai.fishdr.utils.AttachFileMapper;
import com.ai.fishdr.vo.BoardCommentVO;
import com.ai.fishdr.vo.BoardFileVO;
import com.ai.fishdr.vo.BoardVO;
import com.ai.fishdr.vo.SttemntVO;

@Service
public class IFreeboardServiceImpl implements IFreeboardService {
	@Autowired
	private IFreeboardDao dao;
	@Autowired
	private IBoardFileService fileService;
	@Autowired
	private IBoardCommentService commentService;
	@Autowired
	private AttachFileMapper mapper;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public String insertBoard(BoardVO vo, MultipartFile[] files) throws Exception {
		String bo_no = dao.insertBoard(vo);
		List<BoardFileVO> fileList =  mapper.mapping(files, bo_no);
		if (fileList.size()!=0) {
			fileService.insertBoardFiles(fileList);
		}
		return bo_no;
		
		
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public boolean updateBoard(BoardVO vo, MultipartFile[] files) throws Exception {
		boolean result = false;
		List<BoardFileVO> fileList =  mapper.mapping(files, vo.getBo_no());
		if (fileList.size()!=0) {
			fileService.insertBoardFiles(fileList);
		}
		int cnt = dao.updateBoard(vo);
		if (cnt>0) {
			result = true;
		}
		return result;
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public boolean deleteBoard(Map<String, String> params) throws Exception {
		boolean result = false;
		int cnt = dao.deleteBoard(params);
		if (cnt>0) {
			result = true;
		}
		return result;
	}
	@Transactional(readOnly=true)
	@Override
	public List<Map<String, BoardVO>> getBoardList(Map<String, String> params)
			throws Exception {
		return dao.getBoardList(params);
	}
	@Transactional(readOnly=true)
	@Override
	public List<Map<String, Object>> boardInfo(Map<String, String> params)
			throws Exception {
		
		List<Map<String, Object>> totalViewInfo = new ArrayList<Map<String,Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		Map<String, Object> totalInfo = dao.boardInfo(params);
		List<BoardFileVO> fileInfo = fileService.getBoardFileInfo(params);
		List<Map<String, BoardCommentVO>> commentInfo = commentService.getBoardCommentList(params);
		
		map.put("fileInfo", fileInfo);
		map.put("commentInfo", commentInfo);
		
		totalViewInfo.add(totalInfo);
		totalViewInfo.add(map);
		
		return totalViewInfo;
	}
	@Transactional(readOnly=true)
	@Override
	public int getTotalCount(Map<String, String> params) throws Exception {
		return dao.getTotalCount(params);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public void updateHit(Map<String, String> params) throws Exception {
		dao.updateHit(params);
		
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public boolean updateGoodHit(String bo_no) throws Exception {
		boolean result = false;
		int cnt = dao.updateGoodHit(bo_no);
		if (cnt > 0) {
			result = true;
		}
		return result;
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public boolean insertBadHit(SttemntVO vo) throws Exception {
		boolean result  = false;
		Object obj = dao.insertBadHit(vo);
		if (obj == null) {
			result = true;
		}
		return result;
	}
	@Override
	public boolean getBlack(Map<String, String> params) throws Exception {
		boolean result = false;
		int cnt = dao.getBlack(params);
		if (cnt !=0) {
			result = true;
		}
		return result;
	}
	@Override
	public List<Map<String, BoardVO>> getAdminWriteList() throws Exception {
		return dao.getAdminWriteList();
	}

}
