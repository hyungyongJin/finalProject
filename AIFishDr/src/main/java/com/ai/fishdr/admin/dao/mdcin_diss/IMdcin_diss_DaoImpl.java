package com.ai.fishdr.admin.dao.mdcin_diss;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ai.fishdr.vo.MdcinDissVO;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class IMdcin_diss_DaoImpl implements IMdcin_diss_Dao {
	
	@Autowired
	private SqlMapClient smc;

	@Override
	public List<MdcinDissVO> mdcin_diss_List(Map<String, String> params)
			throws Exception {
		return smc.queryForList("mdcinDiss.mdcin_diss_List", params);
	}

	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return (int) smc.queryForObject("mdcinDiss.totalCount", params);
	}

	@Override
	public Object mdcin_diss_Insert(Map<String, String> params) throws Exception {
		return smc.insert("mdcinDiss.mdcin_diss_Insert", params);
	}

	@Override
	public MdcinDissVO duplicationCheck(Map<String, String> params) throws Exception {
		return (MdcinDissVO) smc.queryForObject("mdcinDiss.duplicationCheck", params);
	}

	@Override
	public int mdcin_diss_Delete(String md_code) throws Exception {
		return smc.delete("mdcinDiss.mdcin_diss_Delete", md_code);
	}

	@Override
	public MdcinDissVO mdcin_diss_Info(String md_code) throws Exception {
		return (MdcinDissVO) smc.queryForObject("mdcinDiss.mdcin_diss_Info", md_code);
	}

	@Override
	public int mdcin_diss_Update(Map<String, String> params) throws Exception {
		return smc.update("mdcinDiss.mdcin_diss_Update", params);
	}

	@Override
	public List<MdcinDissVO> getMdcinCode(String diss_code) throws Exception {
		return smc.queryForList("mdcinDiss.getMdcinCode", diss_code);
	}
	
	
}
