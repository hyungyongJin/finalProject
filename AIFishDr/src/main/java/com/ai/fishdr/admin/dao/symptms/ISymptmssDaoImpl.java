package com.ai.fishdr.admin.dao.symptms;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ai.fishdr.vo.DiseaseVO;
import com.ai.fishdr.vo.SymptomsVO;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class ISymptmssDaoImpl implements ISymptmsDao {
	
	@Autowired
	private SqlMapClient smc;

	@Override
	public List<SymptomsVO> getSymptmsList(Map<String, String> params)
			throws Exception {
		return smc.queryForList("symptms.getSymptmsList", params);
	}

	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return (int) smc.queryForObject("symptms.totalCount", params);
	}

	@Override
	public int deleteSymptms(String symptms_code) throws Exception {
		return smc.update("symptms.deleteSymptms", symptms_code);
	}

	@Override
	public Object insertSymptms(String symptms_content) throws Exception {
		return smc.insert("symptms.insertSymptms", symptms_content);
	}

	@Override
	public SymptomsVO symptmsInfo(Map<String, String> params) throws Exception {
		return (SymptomsVO) smc.queryForObject("symptms.symptmsInfo", params);
	}

	@Override
	public int updateSymptms(Map<String, String> params) throws Exception {
		return smc.update("symptms.updateSymptms", params);
	}

	@Override
	public List<SymptomsVO> prsSymptmsList(Map<String, String> params) throws Exception {
		return smc.queryForList("symptms.prsSymptmsList",params);
	}
	

	public List<SymptomsVO> symptmsList() throws Exception {
		return smc.queryForList("symptms.symptmsList");
	}

	@Override
	public SymptomsVO duplicationCheck(String symptms_content) throws Exception {
		return (SymptomsVO) smc.queryForObject("symptms.duplicationCheck", symptms_content);
	}
	
}
