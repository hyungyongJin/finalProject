package com.ai.fishdr.admin.serivce.disease;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ai.fishdr.admin.dao.disease.IDiseaseDao;
import com.ai.fishdr.utils.AttachFileMapper;
import com.ai.fishdr.vo.BoardFileVO;
import com.ai.fishdr.vo.DiseaseFileVO;
import com.ai.fishdr.vo.DiseaseVO;

@Repository
public class IDiseaseServiceImpl implements IDiseaseService {

	@Autowired
	private IDiseaseDao dao;

	@Transactional(readOnly = true)
	@Override
	public List<DiseaseVO> getDiseaseList(Map<String, String> params)
			throws Exception {
		return dao.getDiseaseList(params);
	}

	@Transactional(readOnly = true)
	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return dao.totalCount(params);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public int deleteDisease(String disease_code) throws Exception {
		int count = dao.deleteDisease(disease_code);
		return count;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public int insertDisease(String disease_name) throws Exception {
		Object result = dao.insertDisease(disease_name);
		int count = 0;
		if (result == null) {
			count = 1;
		}
		return count;
	}

	@Transactional(readOnly = true)
	@Override
	public DiseaseVO diseaseInfo(Map<String, String> params) throws Exception {
		return dao.diseaseInfo(params);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public int updateDisease(Map<String, String> params) throws Exception {
		return dao.updateDisease(params);
	}

	@Transactional(readOnly = true)
	@Override
	public List<DiseaseVO> dissList() throws Exception {
		return dao.dissList();
	}

	@Override
	public List<Map<String, DiseaseVO>> getDisaseFileList(
			Map<String, String> params) throws Exception {
		return dao.getDisaseFileList(params);
	}

	@Override
	public int getTotalFileCount(Map<String, String> params) throws Exception {
		return dao.getTotalFileCount(params);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public String insertDissFile(String diss_code, MultipartFile[] files)
			throws Exception {
		List<DiseaseFileVO> fileItemList = new ArrayList<DiseaseFileVO>();
		if (files != null) {
			DiseaseFileVO fileItemInfo = null;
			for (MultipartFile file : files) {
				if (file.getSize() > 0) {
					fileItemInfo = new DiseaseFileVO();
					fileItemInfo.setDiss_code(diss_code);
					String fileName = FilenameUtils.getName(file
							.getOriginalFilename());
					fileItemInfo.setFile_name(fileName);
					String baseName = FilenameUtils.getBaseName(fileName);
					String extension = FilenameUtils.getExtension(fileName);
					String genID = UUID.randomUUID().toString()
							.replace("-", "");
					String saveFileName = baseName + genID + "." + extension;
					fileItemInfo.setFile_save_name(saveFileName);
					fileItemInfo.setFile_content_type(file.getContentType());
					fileItemList.add(fileItemInfo);
					File saveFile = new File(AttachFileMapper.FILE_PATH,
							saveFileName);
					try {
						file.transferTo(saveFile);
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		String dissName = "";
		if (fileItemList.size()!=0) {
			for (DiseaseFileVO diseaseFileVO : fileItemList) {
				dissName = dao.insertDissFile(diseaseFileVO);
			}
		}else{
			return diss_code;
		}
		return dissName;
	}

	@Override
	public List<DiseaseFileVO> getDissFileInfo(String diss_code)
			throws Exception {
		return dao.getDissFileInfo(diss_code);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public boolean deleteDissFile(String file_no) throws Exception {
		boolean result  = false;
		int cnt = dao.deleteDissFile(file_no);
		if (cnt > 0) {
			result = true;
		}
		return result;
	}
	
	@Transactional(readOnly = true)
	@Override
	public DiseaseVO duplicationCheck(String diss_name) throws Exception {
		return dao.duplicationCheck(diss_name);
	}

	@Override
	public int getShowDissCnt(Map<String, String> params) throws Exception {
		return dao.getShowDissCnt(params);
	}

	@Override
	public List<Map<String, String>> getShowDissList(Map<String, String> params) throws Exception {
		return dao.getShowDissList(params);
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<DiseaseVO> getDissCode(Map<String, String> params)
			throws Exception {
		return dao.getDissCode(params);
	}
}
