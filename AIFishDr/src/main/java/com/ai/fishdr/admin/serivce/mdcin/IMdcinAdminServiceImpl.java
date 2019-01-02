package com.ai.fishdr.admin.serivce.mdcin;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ai.fishdr.admin.dao.mdcin.IMdcinAdminDao;
import com.ai.fishdr.vo.MedicineVO;

@Repository
public class IMdcinAdminServiceImpl implements IMdcinAdminService {
	
	@Autowired
	private IMdcinAdminDao dao;
	
	@Transactional(readOnly=true)
	@Override
	public List<MedicineVO> getMdcinList(Map<String, String> params)
			throws Exception {
		return dao.getMdcinList(params);
	}
	
	@Transactional(readOnly=true)
	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return dao.totalCount(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public int deleteMdcin(String mdcin_code) throws Exception {
		int count = dao.deleteMdcin(mdcin_code);
		return count;
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public int insertMdcin(MedicineVO mdcinInfo) throws Exception {
		Object result = dao.insertMdcin(mdcinInfo);
		int count = 0;
		if (result == null) {
			count = 1;
		}
		return count;
	}
	
	@Transactional(readOnly=true)
	@Override
	public MedicineVO getMdcinInfo(String mdcin_code) throws Exception {
		return dao.getMdcinInfo(mdcin_code);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public int updateMdcin(MedicineVO mdcinInfo) throws Exception {
		return dao.updateMdcin(mdcinInfo);
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<MedicineVO> mdcinList() throws Exception {
		return dao.mdcinList();
	}

}
