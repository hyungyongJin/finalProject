package com.ai.fishdr.admin.serivce.fish;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ai.fishdr.admin.dao.fish.IFishDao;
import com.ai.fishdr.vo.FishVO;

@Repository
public class IFishServiceImpl implements IFishService {
	
	@Autowired
	private IFishDao dao;
	
	@Transactional(readOnly=true)
	@Override
	public List<FishVO> getFishList(Map<String, String> params)
			throws Exception {
		return dao.getFishList(params);
	}
	
	@Transactional(readOnly=true)
	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return dao.totalCount(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public int deleteFish(String fish_code) throws Exception {
		int count = dao.deleteFish(fish_code);
		return count;
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public int insertFish(String fish_name) throws Exception {
		Object result = dao.insertFish(fish_name);
		int count = 0;
		if (result == null) {
			count = 1;
		}
		return count;
	}
	
	@Transactional(readOnly=true)
	@Override
	public FishVO fishInfo(Map<String, String> params) throws Exception {
		return dao.fishInfo(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public int updateFish(Map<String, String> params) throws Exception {
		return dao.updateFish(params);
	}
	
	@Transactional(readOnly=true)
	@Override
	public List<FishVO> fishList() throws Exception {
		return dao.fishList();
	}
	
	@Transactional(readOnly=true)
	@Override
	public FishVO duplicationCheck(String fish_name) throws Exception {
		return dao.duplicationCheck(fish_name);
	}

}
