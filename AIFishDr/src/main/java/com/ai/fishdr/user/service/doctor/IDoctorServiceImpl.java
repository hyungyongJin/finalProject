package com.ai.fishdr.user.service.doctor;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ai.fishdr.user.dao.doctor.IDoctorDao;
import com.ai.fishdr.vo.DoctorVO;


@Repository
public class IDoctorServiceImpl implements IDoctorService {
	
	@Autowired
	private IDoctorDao dao;
	
	@Transactional(readOnly=true)
	@Override
	public DoctorVO doctorInfo(Map<String, String> params) throws Exception {
		return dao.doctorInfo(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public void insertDoctor(DoctorVO doctorInfo) throws Exception {
		dao.insertDoctor(doctorInfo);
	}
	
	@Transactional(readOnly=true)
	@Override
	public String getTreat_code() throws Exception {
		return dao.getTreat_code();
	}
}
