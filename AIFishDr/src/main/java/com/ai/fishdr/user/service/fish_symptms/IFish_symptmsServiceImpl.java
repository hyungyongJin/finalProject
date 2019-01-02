package com.ai.fishdr.user.service.fish_symptms;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ai.fishdr.user.dao.fish_symptms.IFish_symptmsDao;
import com.ai.fishdr.vo.FishSymptmsVO;

@Repository
public class IFish_symptmsServiceImpl implements IFish_symptmsService {
	
	@Autowired
	private IFish_symptmsDao dao;
	
	@Transactional(readOnly=true)
	@Override
	public List<FishSymptmsVO> fish_symptms_List(String treat_code)
			throws Exception {
		return dao.fish_symptms_List(treat_code);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public void fish_symptms_Insert(Map<String, String> params)
			throws Exception {
		dao.fish_symptms_Insert(params);
	} 

}
