package com.ai.fishdr.admin.dao.capacity;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ai.fishdr.vo.CapacityUsageVO;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class ICapacityDaoImpl implements ICapacityDao{
	@Autowired
	private SqlMapClient smc;

	@Override
	public List<CapacityUsageVO> getCapacityList(Map<String, String> params) throws Exception {
		return smc.queryForList("capacity.getCapacityList", params);
	}

	@Override
	public int getTotalCount(Map<String, String> params) throws Exception {
		return (int) smc.queryForObject("capacity.getTotalCount" ,params);
	}

	@Override
	public CapacityUsageVO getInfo(Map<String, String> params) throws Exception {
		return (CapacityUsageVO) smc.queryForObject("capacity.getInfo", params);
	}

	@Override
	public int capacityUpdate(Map<String, String> params) throws Exception {
		return smc.update("capacity.capacityUpdate", params);
	}

	@Override
	public Object capacityInsert(Map<String, String> params) throws Exception {
		return smc.insert("capacity.capacityInsert", params);
	}

	@Override
	public Object capacityDelete(Map<String, String> params) throws Exception {
		return smc.update("capacity.capacityDelete", params);
	}

	@Override
	public CapacityUsageVO capacityCheck(Map<String, String> params)
			throws Exception {
		return (CapacityUsageVO) smc.queryForObject("capacity.capacityCheck", params);
	}

	@Override
	public CapacityUsageVO prsCapacityInfo(Map<String, String> params)
			throws Exception {
		return (CapacityUsageVO) smc.queryForObject("capacity.prsCapacityInfo", params);
	}
	
}
