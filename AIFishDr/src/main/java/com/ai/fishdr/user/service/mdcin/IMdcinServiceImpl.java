package com.ai.fishdr.user.service.mdcin;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ai.fishdr.user.dao.mdcin.IMdcinDao;
import com.ai.fishdr.vo.MedicineVO;

@Repository
public class IMdcinServiceImpl implements IMdcinService {
	
	@Autowired
	private IMdcinDao dao;
	
	@Transactional(readOnly=true)
	@Override
	public List<MedicineVO> getMdcinList(Map<String, String> params)
			throws Exception {
		return dao.getMdcinList(params);
	}
	
	@Transactional(readOnly=true)
	@Override
	public int totalCount(Map<String, String> params) throws Exception {
		return dao.totalCount(params);
	}
	
	@Transactional(readOnly=true)
	@Override
	public MedicineVO getMdcinInfo(String mdcin_code) throws Exception {
		return dao.getMdcinInfo(mdcin_code);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public void updateHit(String mdcin_code) throws Exception {
		dao.updateHit(mdcin_code);
	}

	
	/**
	 * 특정 의약품에게 점수를 매긴 횟수 구하기
	 */
	@Override
	public int medicineCount(String mdcin_code) throws Exception {

		return dao.medicineCount(mdcin_code);
		
	}

	
	/**
	 * 특정 의약품에게 매겨진 점수의 총합 구하기
	 */
	@Override
	public int totalMedicineScore(String mdcin_code) throws Exception {

		return dao.totalMedicineScore(mdcin_code);
		
	}
	
}
