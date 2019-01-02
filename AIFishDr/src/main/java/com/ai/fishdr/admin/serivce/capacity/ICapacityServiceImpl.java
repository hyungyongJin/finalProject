package com.ai.fishdr.admin.serivce.capacity;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ai.fishdr.admin.dao.capacity.ICapacityDao;
import com.ai.fishdr.vo.CapacityUsageVO;

@Service
class ICapacityServiceImpl implements ICapacityService{
	@Autowired
	private ICapacityDao dao;
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<CapacityUsageVO> getCapacityList(Map<String, String> params) throws Exception {
		
		return dao.getCapacityList(params);
	}

	@Override
	public int getTotalCount(Map<String, String> params) throws Exception {
		return dao.getTotalCount(params);
	}

	@Transactional
	@Override
	public CapacityUsageVO getInfo(Map<String, String> params) throws Exception {
		return dao.getInfo(params);
	}

	@Transactional
	@Override
	public int capacityUpdate(Map<String, String> params) throws Exception {

		return dao.capacityUpdate(params);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public int capacityInsert(Map<String, String> params) throws Exception {
		
		Object result = dao.capacityInsert(params);
		int count = 0;
		
		if (result == null) {
			count = 1;
		}
		
		return count;
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public Object capacityDelete(Map<String, String> params) throws Exception {
		return dao.capacityDelete(params);
	}

	@Override
	public CapacityUsageVO capacityCheck(Map<String, String> params)
			throws Exception {
		return dao.capacityCheck(params);
	}
	
	@Transactional(readOnly=true)
	@Override
	public CapacityUsageVO prsCapacityInfo(Map<String, String> params)
			throws Exception {
		return dao.prsCapacityInfo(params);
	}
	
	
}
