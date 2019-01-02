package com.ai.fishdr.admin.dao.hospital;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ai.fishdr.vo.HospitalVO;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class IHospitalMgrDaoImpl implements IHospitalMgrDao {
	@Autowired
	private SqlMapClient smc;

	@Override
	public List<HospitalVO> hospitalList(Map<String, String> params)
			throws Exception {
		return smc.queryForList("hospital.hospitalList",params);
	}

	@Override
	public int getTotalCount(Map<String, String> params) throws Exception {
		return (int) smc.queryForObject("hospital.getTotalCount",params);
	}

	@Override
	public HospitalVO hospitalInfo(Map<String, String> params) throws Exception {
		return (HospitalVO) smc.queryForObject("hospital.hospitaInfo",params);
	}

	@Override
	public int updateHospital(HospitalVO vo) throws Exception {
		return smc.update("hospital.updateHospital",vo);
	}

	@Override
	public String insertHospital(HospitalVO vo) throws Exception {
		return (String) smc.insert("hospital.insertHospital",vo);
	}

	@Override
	public int deleteHospital(Map<String, String> params) throws Exception {
		return smc.delete("hospital.deleteHospital",params);
	}

	@Override
	public HospitalVO converHospitalInfo(String hospital_name) throws Exception {
		return (HospitalVO) smc.queryForObject("hospital.converHospitalInfo", hospital_name);
	}
}
