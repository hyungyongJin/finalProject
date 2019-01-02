package com.ai.fishdr.user.service.imageboard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ai.fishdr.user.dao.imageboard.IImageBoardDao;
import com.ai.fishdr.user.dao.imageboardfile.IImageFileItemDao;
import com.ai.fishdr.user.service.imageboardfile.IImageboardFileService;
import com.ai.fishdr.utils.AttachFileMapper;
import com.ai.fishdr.vo.BoardFileVO;
import com.ai.fishdr.vo.BoardVO;
import com.ai.fishdr.vo.SttemntVO;


@Service
public class IImageboardServiceImpl implements IImageboardService{

	@Autowired
	private IImageBoardDao dao;
	@Autowired
	private IImageboardFileService fileService;
	
	
	@Autowired
	private IImageFileItemDao fileDao;
	@Autowired
	private AttachFileMapper file;
	
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<BoardVO> getBBS(Map<String, String> params) throws Exception{
		
		return  dao.getBBS(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public boolean insertBBS(BoardVO vo, MultipartFile[] files) throws Exception{
		String bo_no = dao.insertBBS(vo);
		boolean result = false;
		List<BoardFileVO> fileList=file.mapping(files, bo_no);
		if (!fileList.isEmpty()) {
			for (int i = 0; i < fileList.size(); i++) {
				BoardFileVO filevo = fileList.get(i);
				result  = fileService.insertBoardFile(filevo);
			}
		}
		return result;
	}
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public void updateHit(Map<String, String> params) throws Exception{
			dao.updateHit(params);
	}
	@Transactional
	@Override
	public Map<String,Object> getBBSInfo(Map<String, String> params) throws Exception{
		return dao.getBBSInfo(params);
	}
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public void deleteBBS(Map<String, String> params) throws Exception{
			dao.deleteBBS(params);
	}
//	@Transactional
//	@Override
//	public void updateBBS(BoardVO vo) throws Exception{
//			dao.updateBBS(vo);
//			String bo_no =vo.getBo_no();
//					
//			List<BoardFileVO> fileList = SomeAttachFileMapper.someAllUpdate_mapping(vo, bo_no);
//			if (fileList.size()!=0) {
//				Map<String, String> params = new HashMap<String, String>();
//				String fileName = fileList.get(0).getFile_save_name();
//				params.put("some_no", bo_no);
//				params.put("some_pic", fileName);
//				dao.updateThumnail(params);
//			}
//			fileDao.insertFileItemInfo(fileList);
//	}
	@Transactional
	@Override
	public int totalCount(Map<String, String> params) throws Exception{
		return  dao.totalCount(params);
	}
	

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public int updateBBS(BoardVO vo) throws Exception {
		return dao.updateBBS(vo);
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
	
	
	
}
