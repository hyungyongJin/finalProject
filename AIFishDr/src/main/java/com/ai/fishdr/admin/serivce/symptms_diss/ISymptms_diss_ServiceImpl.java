package com.ai.fishdr.admin.serivce.symptms_diss;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ai.fishdr.admin.dao.symptms_diss.ISymptms_diss_Dao;
import com.ai.fishdr.vo.SymptmsDissVO;

@Repository
public class ISymptms_diss_ServiceImpl implements ISymptms_diss_Service {
	
	@Autowired
	private ISymptms_diss_Dao dao;
	
	@Transactional(readOnly=true)
	@Override
	public List<SymptmsDissVO> symptms_diss_List(Map<String, String> params)
			throws Exception {
		return dao.symptms_diss_List(params);
	}
	
	@Transactional(readOnly=true)
	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return dao.totalCount(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public int symptms_diss_Insert(Map<String, String> params) throws Exception {
		Object result = dao.symptms_diss_Insert(params);
		
		int count = 0;
		
		if (result == null) {
			count = 1;
		}
		return count;
	}
	
	@Transactional(readOnly=true)
	@Override
	public SymptmsDissVO duplicationCheck(Map<String, String> params) throws Exception {
		return dao.duplicationCheck(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public int symptms_diss_Delete(String sd_code) throws Exception {
		return dao.symptms_diss_Delete(sd_code);
	}
	
	@Transactional(readOnly=true)
	@Override
	public SymptmsDissVO symptms_diss_Info(String sd_code) throws Exception {
		return dao.symptms_diss_Info(sd_code);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public int symptms_diss_Update(Map<String, String> params) throws Exception {
		return dao.symptms_diss_Update(params);
	}
}
