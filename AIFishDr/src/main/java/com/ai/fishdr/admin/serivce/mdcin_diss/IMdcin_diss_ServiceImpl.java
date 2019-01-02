package com.ai.fishdr.admin.serivce.mdcin_diss;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ai.fishdr.admin.dao.mdcin_diss.IMdcin_diss_Dao;
import com.ai.fishdr.vo.MdcinDissVO;

@Repository
public class IMdcin_diss_ServiceImpl implements IMdcin_diss_Service {
	
	@Autowired
	private IMdcin_diss_Dao dao;
	
	@Transactional(readOnly=true)
	@Override
	public List<MdcinDissVO> mdcin_diss_List(Map<String, String> params)
			throws Exception {
		return dao.mdcin_diss_List(params);
	}
	
	@Transactional(readOnly=true)
	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return dao.totalCount(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public int mdcin_diss_Insert(Map<String, String> params) throws Exception {
		Object result = dao.mdcin_diss_Insert(params);
		
		int count = 0;
		
		if (result == null) {
			count = 1;
		}
		return count;
	}
	
	@Transactional(readOnly=true)
	@Override
	public MdcinDissVO duplicationCheck(Map<String, String> params) throws Exception {
		return dao.duplicationCheck(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public int mdcin_diss_Delete(String md_code) throws Exception {
		return dao.mdcin_diss_Delete(md_code);
	}
	
	@Transactional(readOnly=true)
	@Override
	public MdcinDissVO mdcin_diss_Info(String md_code) throws Exception {
		return dao.mdcin_diss_Info(md_code);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public int mdcin_diss_Update(Map<String, String> params) throws Exception {
		return dao.mdcin_diss_Update(params);
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<MdcinDissVO> getMdcinCode(String diss_code) throws Exception {
		return dao.getMdcinCode(diss_code);
	}
}
