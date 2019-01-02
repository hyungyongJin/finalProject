package com.ai.fishdr.nouser.service.notice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ai.fishdr.admin.serivce.boardFile.IBoardFileService;
import com.ai.fishdr.admin.serivce.boardcomment.IBoardCommentService;
import com.ai.fishdr.nouser.dao.notice.INoUserDao;
import com.ai.fishdr.utils.AttachFileMapper;
import com.ai.fishdr.vo.BoardCommentVO;
import com.ai.fishdr.vo.BoardFileVO;
import com.ai.fishdr.vo.BoardVO;

@Service
public class INoUserServiceImpl implements INoUserService {
	@Autowired
	private INoUserDao dao;
	@Autowired
	private IBoardFileService fileService;
	@Autowired
	private IBoardCommentService commentService;
	@Autowired
	private AttachFileMapper mapper;

	@Transactional(readOnly=true)
	@Override
	public List<Map<String, BoardVO>> getNoticeList(Map<String, String> params)
			throws Exception {
		return dao.getNoticeList(params);
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<Map<String, Object>> getNoticeInfo(Map<String, String> params)
			throws Exception {
		
		List<Map<String, Object>> totalViewInfo = new ArrayList<Map<String,Object>>();
		Map<String, Object> map = new HashMap<String, Object>();
		
		Map<String, Object> totalInfo = dao.getNoticeInfo(params);
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
	

}
