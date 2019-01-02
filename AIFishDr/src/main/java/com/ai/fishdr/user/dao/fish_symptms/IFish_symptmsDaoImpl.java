package com.ai.fishdr.user.dao.fish_symptms;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ai.fishdr.vo.FishSymptmsVO;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class IFish_symptmsDaoImpl implements IFish_symptmsDao {
	
	@Autowired
	private SqlMapClient smc;

	@Override
	public List<FishSymptmsVO> fish_symptms_List(String treat_code)
			throws Exception {
		return smc.queryForList("fishsymptms.fish_symptms_List", treat_code);
	}

	@Override
	public void fish_symptms_Insert(Map<String, String> params)
			throws Exception {
		smc.insert("fishsymptms.fish_symptms_Insert", params);
	}

}
