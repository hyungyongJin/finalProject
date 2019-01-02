package com.ai.fishdr.admin.dao.disease;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ai.fishdr.vo.DiseaseFileVO;
import com.ai.fishdr.vo.DiseaseVO;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class IDiseaseDaoImpl implements IDiseaseDao {
	
	@Autowired
	private SqlMapClient smc;

	@Override
	public List<DiseaseVO> getDiseaseList(Map<String, String> params)
			throws Exception {
		return smc.queryForList("diss.getDiseaseList", params);
	}

	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return (int) smc.queryForObject("diss.totalCount", params);
	}

	@Override
	public int deleteDisease(String diss_code) throws Exception {
		return smc.update("diss.deleteDisease", diss_code);
	}

	@Override
	public Object insertDisease(String diss_name) throws Exception {
		return smc.insert("diss.insertDisease", diss_name);
	}

	@Override
	public DiseaseVO diseaseInfo(Map<String, String> params) throws Exception {
		return (DiseaseVO) smc.queryForObject("diss.diseaseInfo", params);
	}

	@Override
	public int updateDisease(Map<String, String> params) throws Exception {
		return smc.update("diss.updateDisease", params);
	}

	@Override
	public List<DiseaseVO> dissList() throws Exception {
		return smc.queryForList("diss.dissList");
	}

	@Override
	public List<Map<String, DiseaseVO>> getDisaseFileList(
			Map<String, String> params) throws Exception {
		return smc.queryForList("diseaseFile.getDisaseFileList", params);
	}

	@Override
	public int getTotalFileCount(Map<String, String> params) throws Exception {
		return (int) smc.queryForObject("diseaseFile.getTotalFileCount",params);
	}

	@Override
	public String insertDissFile(DiseaseFileVO vo) throws Exception {
		return (String) smc.insert("diseaseFile.insertDissFile",vo);
	}

	@Override
	public List<DiseaseFileVO> getDissFileInfo(String diss_code)
			throws Exception {
		return smc.queryForList("diseaseFile.getDissFileInfo", diss_code);
	}

	@Override
	public int deleteDissFile(String file_no) throws Exception {
		return smc.delete("diseaseFile.deleteDissFile",file_no);
	}

	@Override
	public DiseaseVO duplicationCheck(String diss_name) throws Exception {
		return (DiseaseVO) smc.queryForObject("diss.duplicationCheck", diss_name);
	}

	@Override
	public int getShowDissCnt(Map<String, String> params) throws Exception {
		return (int) smc.queryForObject("diseaseFile.getShowDissCnt",params);
	}

	@Override
	public List<Map<String, String>> getShowDissList(Map<String, String> params) throws SQLException {
		return smc.queryForList("diseaseFile.getShowDissList", params);
	}

	@Override
	public List<DiseaseVO> getDissCode(Map<String, String> params)
			throws Exception {
		return smc.queryForList("diss.getDissCode", params);
	}
	
}
