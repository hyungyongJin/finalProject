package com.ai.fishdr.admin.serivce.diss_fish;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ai.fishdr.admin.dao.diss_fish.IDiss_fish_Dao;
import com.ai.fishdr.vo.DissFishVO;

@Repository
public class IDiss_fish_ServiceImpl implements IDiss_fish_Service {
	
	@Autowired
	private IDiss_fish_Dao dao;
	
	@Transactional(readOnly=true)
	@Override
	public List<DissFishVO> diss_fish_List(Map<String, String> params)
			throws Exception {
		return dao.diss_fish_List(params);
	}
	
	@Transactional(readOnly=true)
	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return dao.totalCount(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public int diss_fish_Insert(Map<String, String> params) throws Exception {
		Object result = dao.diss_fish_Insert(params);
		
		int count = 0;
		
		if (result == null) {
			count = 1;
		}
		return count;
	}
	
	@Transactional(readOnly=true)
	@Override
	public DissFishVO duplicationCheck(Map<String, String> params) throws Exception {
		return dao.duplicationCheck(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public int diss_fish_Delete(String df_code) throws Exception {
		return dao.diss_fish_Delete(df_code);
	}
	
	@Transactional(readOnly=true)
	@Override
	public DissFishVO diss_fish_Info(String df_code) throws Exception {
		return dao.diss_fish_Info(df_code);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public int diss_fish_Update(Map<String, String> params) throws Exception {
		return dao.diss_fish_Update(params);
	}
}
