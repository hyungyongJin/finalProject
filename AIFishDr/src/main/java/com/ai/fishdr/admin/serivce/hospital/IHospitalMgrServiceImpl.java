package com.ai.fishdr.admin.serivce.hospital;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ai.fishdr.admin.dao.hospital.IHospitalMgrDao;
import com.ai.fishdr.vo.HospitalVO;

@Service
public class IHospitalMgrServiceImpl implements IHospitalMgrService {

	@Autowired
	private IHospitalMgrDao dao;

	@Override
	public List<HospitalVO> hospitalList(Map<String, String> params)
			throws Exception {
		return dao.hospitalList(params);
	}

	@Override
	public int getTotalCount(Map<String, String> params) throws Exception {
		return dao.getTotalCount(params);
	}

	@Override
	public HospitalVO hospitalInfo(Map<String, String> params) throws Exception {
		return dao.hospitalInfo(params);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public boolean updateHospital(HospitalVO vo) throws Exception {
		boolean result =false;
		int cnt = dao.updateHospital(vo);
		if (cnt > 0) {
			result = true;
		}
		return result;
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public String insertHospital(HospitalVO vo) throws Exception {
		return dao.insertHospital(vo);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public boolean deleteHospital(String[] code) throws Exception {
		boolean result =false;
		Map<String,String>params = new HashMap<String, String>();
		int cnt = 0;
		for (int i = 0; i < code.length; i++) {
			params.put("hospital_code", code[i]);
			cnt += dao.deleteHospital(params);
		}
		if (code.length == cnt) {
			result = true;
		}
		return result;
	}

	@Override
	public HospitalVO converHospitalInfo(String hospital_name) throws Exception {
		return dao.converHospitalInfo(hospital_name);
	}
}
