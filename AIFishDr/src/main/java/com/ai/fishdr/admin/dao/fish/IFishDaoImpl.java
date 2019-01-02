package com.ai.fishdr.admin.dao.fish;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ai.fishdr.vo.DissFishVO;
import com.ai.fishdr.vo.FishVO;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class IFishDaoImpl implements IFishDao {
	
	@Autowired
	private SqlMapClient smc;

	@Override
	public List<FishVO> getFishList(Map<String, String> params)
			throws Exception {
		return smc.queryForList("fish.getFishList", params);
	}

	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return (int) smc.queryForObject("fish.totalCount", params);
	}

	@Override
	public int deleteFish(String fish_code) throws Exception {
		return smc.update("fish.deleteFish", fish_code);
	}

	@Override
	public Object insertFish(String fish_name) throws Exception {
		return smc.insert("fish.insertFish", fish_name);
	}

	@Override
	public FishVO fishInfo(Map<String, String> params) throws Exception {
		return (FishVO) smc.queryForObject("fish.fishInfo", params);
	}

	@Override
	public int updateFish(Map<String, String> params) throws Exception {
		return smc.update("fish.updateFish", params);
	}

	@Override
	public List<FishVO> fishList() throws Exception {
		return smc.queryForList("fish.fishList");
	}

	@Override
	public FishVO duplicationCheck(String fish_name) throws Exception {
		return (FishVO) smc.queryForObject("fish.duplicationCheck", fish_name);
	}

	
	
}
