package com.ai.fishdr.user.dao.mdcin;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ai.fishdr.vo.MedicineVO;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class IMdcinDaoImpl implements IMdcinDao {
	
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
	public MedicineVO getMdcinInfo(String mdcin_code) throws Exception {
		return (MedicineVO) smc.queryForObject("medicine.getMdcinInfo", mdcin_code);
	}

	@Override
	public void updateHit(String mdcin_code) throws Exception {
		smc.update("medicine.updateHit", mdcin_code);
		
	}

	
	/**
	 * 특정 의약품에게 점수를 매긴 횟수 구하기
	 */
	@Override
	public int medicineCount(String mdcin_code) throws Exception {

		return (int) smc.queryForObject("medicine.medicineCount", mdcin_code);
		
	}

	
	/**
	 * 특정 의약품에게 매겨진 점수의 총합 구하기
	 */
	@Override
	public int totalMedicineScore(String mdcin_code) throws Exception {

		Object medicineScore = smc.queryForObject("medicine.totalMedicineScore", mdcin_code);
		
		if (medicineScore == null) {
			
			return 0;
			
		} else {
		
			return (int) smc.queryForObject("medicine.totalMedicineScore", mdcin_code);
			
		}
		
		
		
	}
	
}
