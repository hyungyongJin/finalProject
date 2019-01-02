package com.ai.fishdr.admin.dao.diss_fish;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ai.fishdr.vo.DissFishVO;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class IDiss_fish_DaoImpl implements IDiss_fish_Dao {
	
	@Autowired
	private SqlMapClient smc;

	@Override
	public List<DissFishVO> diss_fish_List(Map<String, String> params)
			throws Exception {
		return smc.queryForList("dissFish.diss_fish_List", params);
	}

	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return (int) smc.queryForObject("dissFish.totalCount", params);
	}

	@Override
	public Object diss_fish_Insert(Map<String, String> params) throws Exception {
		return smc.insert("dissFish.diss_fish_Insert", params);
	}

	@Override
	public DissFishVO duplicationCheck(Map<String, String> params) throws Exception {
		return (DissFishVO) smc.queryForObject("dissFish.duplicationCheck", params);
	}

	@Override
	public int diss_fish_Delete(String df_code) throws Exception {
		return smc.delete("dissFish.diss_fish_Delete", df_code);
	}

	@Override
	public DissFishVO diss_fish_Info(String df_code) throws Exception {
		return (DissFishVO) smc.queryForObject("dissFish.diss_fish_Info", df_code);
	}

	@Override
	public int diss_fish_Update(Map<String, String> params) throws Exception {
		return smc.update("dissFish.diss_fish_Update", params);
	}

	
}
