package com.ai.fishdr.admin.serivce.symptms;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ai.fishdr.admin.dao.symptms.ISymptmsDao;
import com.ai.fishdr.vo.SymptomsVO;


@Repository
public class ISymptmsServiceImpl implements ISymptmsService {
	
	@Autowired
	private ISymptmsDao dao;
	
	@Transactional(readOnly=true)
	@Override
	public List<SymptomsVO> getSymptmsList(Map<String, String> params)
			throws Exception {
		return dao.getSymptmsList(params);
	}
	
	@Transactional(readOnly=true)
	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return dao.totalCount(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public int deleteSymptms(String symptms_code) throws Exception {
		int count = dao.deleteSymptms(symptms_code);
		return count;
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public int insertSymptms(String symptms_content) throws Exception {
		Object result = dao.insertSymptms(symptms_content);
		int count = 0;
		if (result == null) {
			count = 1;
		}
		return count;
	}
	
	@Transactional(readOnly=true)
	@Override
	public SymptomsVO symptmsInfo(Map<String, String> params) throws Exception {
		return dao.symptmsInfo(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public int updateSymptms(Map<String, String> params) throws Exception {
		return dao.updateSymptms(params);
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<SymptomsVO> prsSymptmsList(Map<String, String> params) throws Exception {
		return dao.prsSymptmsList(params);
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<SymptomsVO> symptmsList() throws Exception {
		return dao.symptmsList();
	}
	
	@Transactional(readOnly=true)
	@Override
	public SymptomsVO duplicationCheck(String symptms_content) throws Exception {
		return dao.duplicationCheck(symptms_content);
	}



}
