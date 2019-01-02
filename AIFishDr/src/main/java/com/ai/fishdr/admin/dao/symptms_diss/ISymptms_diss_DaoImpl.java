package com.ai.fishdr.admin.dao.symptms_diss;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ai.fishdr.vo.SymptmsDissVO;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class ISymptms_diss_DaoImpl implements ISymptms_diss_Dao {
	
	@Autowired
	private SqlMapClient smc;

	@Override
	public List<SymptmsDissVO> symptms_diss_List(Map<String, String> params)
			throws Exception {
		return smc.queryForList("symptmsDiss.symptms_diss_List", params);
	}

	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return (int) smc.queryForObject("symptmsDiss.totalCount", params);
	}

	@Override
	public Object symptms_diss_Insert(Map<String, String> params) throws Exception {
		return smc.insert("symptmsDiss.symptms_diss_Insert", params);
	}

	@Override
	public SymptmsDissVO duplicationCheck(Map<String, String> params) throws Exception {
		return  (SymptmsDissVO) smc.queryForObject("symptmsDiss.duplicationCheck", params);
	}

	@Override
	public int symptms_diss_Delete(String sd_code) throws Exception {
		return smc.delete("symptmsDiss.symptms_diss_Delete", sd_code);
	}

	@Override
	public SymptmsDissVO symptms_diss_Info(String sd_code) throws Exception {
		return  (SymptmsDissVO) smc.queryForObject("symptmsDiss.symptms_diss_Info", sd_code);
	}

	@Override
	public int symptms_diss_Update(Map<String, String> params) throws Exception {
		return smc.update("symptmsDiss.symptms_diss_Update", params);
	}
}
