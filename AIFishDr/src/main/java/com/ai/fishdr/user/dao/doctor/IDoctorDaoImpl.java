package com.ai.fishdr.user.dao.doctor;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ai.fishdr.vo.DoctorVO;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class IDoctorDaoImpl implements IDoctorDao {
	
	@Autowired
	private SqlMapClient smc;

	@Override
	public DoctorVO doctorInfo(Map<String, String> params) throws Exception {
		return (DoctorVO) smc.queryForObject("doctor.doctorInfo", params);
	}

	@Override
	public void insertDoctor(DoctorVO doctorInfo) throws Exception {
		smc.insert("doctor.insertDoctor", doctorInfo);
	}

	@Override
	public String getTreat_code() throws Exception {
		return (String) smc.queryForObject("doctor.getTreat_code");
	}
	
	

}
