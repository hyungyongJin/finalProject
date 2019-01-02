package com.ai.fishdr.admin.dao.mdcin;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ai.fishdr.vo.MedicineVO;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class IMdcinAdminDaoImpl implements IMdcinAdminDao {
	
	@Autowired
	private SqlMapClient smc;

	@Override
	public List<MedicineVO> getMdcinList(Map<String, String> params)
			throws Exception {
		return smc.queryForList("medicine.getMdcinList", params);
	}

	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return (int) smc.queryForObject("medicine.totalCount", params);
	}

	@Override
	public int deleteMdcin(String mdcin_code) throws Exception {
		return smc.update("medicine.deleteMdcin", mdcin_code);
	}

	@Override
	public Object insertMdcin(MedicineVO mdcinInfo) throws Exception {
		return smc.insert("medicine.insertMdcin", mdcinInfo);
	}

	@Override
	public MedicineVO getMdcinInfo(String mdcin_code) throws Exception {
		return (MedicineVO) smc.queryForObject("medicine.getMdcinInfo", mdcin_code);
	}

	@Override
	public int updateMdcin(MedicineVO mdcinInfo) throws Exception {
		return smc.update("medicine.updateMdcin", mdcinInfo);
	}

	@Override
	public List<MedicineVO> mdcinList() throws Exception {
		return smc.queryForList("medicine.mdcinList");
	}

	
	
}
