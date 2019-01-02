package com.ai.fishdr.user.dao.prescription;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ai.fishdr.vo.PrescriptionVO;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class IPrescriptionDaoImpl implements IPrescriptionDao {
	
	@Autowired
	private SqlMapClient smc;

	@Override
	public void prscrptn_Insert(PrescriptionVO prescriptionInfo)
			throws Exception {
		smc.insert("prescription.prscrptn_Insert",prescriptionInfo);
	}

	@Override
	public String prscrptn_getCodeNumber() throws Exception {
		return (String) smc.queryForObject("prescription.prscrptn_getCodeNumber");
	}

	@Override
	public PrescriptionVO prscrptnInfo(String prscrptn_code) throws Exception {
		return (PrescriptionVO) smc.queryForObject("prescription.prscrptnInfo", prscrptn_code);
	}

	@Override
	public List<Map<String, Object>> getMemsPrscrptnInfo(
			Map<String, String> params) throws Exception {
		return  smc.queryForList("prescription.getMemsPrscrptnInfo",params);
	}

	@Override
	public int totalMemsPrsCnt(Map<String, String> params) throws Exception {
		return (int) smc.queryForObject("prescription.totalMemsPrsCnt",params);
	}

	
	/**
	 * 처방내역관리 리스트 관련 오버라이딩
	 */
	@Override
	public List<Map<String, Object>> getPrescriptionList(Map<String, String> params) throws Exception {

		return smc.queryForList("prescription.getPrescriptionList", params);
		
	}

	
	/**
	 * 처방내역관리 리스트 총 개수 관련 오버라이딩
	 */
	@Override
	public int totalPrescriptionListAllCount(Map<String, String> params) throws Exception {

		return (int) smc.queryForObject("prescription.totalPrescriptionListAllCount", params);
		
	}

	
	/**
	 * 검색 조건에 맞는 처방 내역 리스트 개수
	 */
	@Override
	public int totalPrescriptionListCount(Map<String, String> params) throws Exception {

		return (int) smc.queryForObject("prescription.totalPrescriptionListCount", params);
		
	}

	
	/**
	 * 특정한 품종에게 나타날 수 있는 증상과 해당 증상에 사용할 수 있는 약들의 용법 및 용량, 휴약기간 정보를 갖고온 리스트 관련 오버라이딩
	 */
	@Override
	public List<Map<String, Object>> resultPrescription(Map<String, String> params) throws Exception {

		return smc.queryForList("prescription.resultPrescription", params);
		
	}
	
	
	/**
	 * 처방 가능 의약품 리스트 총 개수
	 */
	@Override
	public int totalResultAllPrescription(Map<String, String> params) throws Exception {

		return (int) smc.queryForObject("prescription.totalResultAllPrescription", params);
		
	}
	
	
	
	/**
	 * 특정한 증상을 보이는 특정한 품종한테 최종적으로 처방한 약 정보 관련 오버라이딩
	 */
	@Override
	public List<Map<String, Object>> finalResultPrescription(Map<String, String> params) throws Exception {
		
		return smc.queryForList("prescription.finalResultPrescription", params);
		
	}

	
	/**
	 * 처방내역 상세 리스트 중 병명을 중복 제거하여 정보 갖고 오기 관련 오버라이딩
	 */
	@Override
	public List<String> getResultPrescriptionDissName(Map<String, String> params) throws Exception {

		return smc.queryForList("prescription.getResultPrescriptionDissName", params);
		
	}

	
	/**
	 * 처방내역 상세 리스트 중 질병파일명을 중복 제거하여 정보 갖고 오기 관련 오버라이딩
	 */
	@Override
	public List<String> getResultPrescriptionDiseaseFile(Map<String, String> params) throws Exception {

		return smc.queryForList("prescription.getResultPrescriptionDiseaseFile", params);
		
	}
	
	
	/**
	 * 특정 회원이 특정 의약품에 점수를 부여한 의사코드 총 개수 가져오기 관련 오버라이딩
	 */
	@Override
	public int searchTreatCodeAddScore(Map<String, String> params) throws Exception {

		Object treatCodeAddScore = smc.queryForObject("prescription.searchTreatCodeAddScore", params);
		
		if (treatCodeAddScore == null) {
			
			return 0;
			
		}
		
		return (int) smc.queryForObject("prescription.searchTreatCodeAddScore", params);
		
	}
	
	
	/**
	 * 특정 회원이 특정 의약품에 점수를 부여한 처방코드 총 개수 가져오기 관련 오버라이딩
	 */
	@Override
	public int searchPrscrptnCodeAddScore(Map<String, String> params) throws Exception {
		
		Object prscrptnCodeAddScore = smc.queryForObject("prescription.searchTreatCodeAddScore", params);
		
		if (prscrptnCodeAddScore == null) {
			
			return 0;
			
		}

		return (int) smc.queryForObject("prescription.searchPrscrptnCodeAddScore", params);
		
	}
	
	
	/**
	 * 처방받은 의약품 점수를 등록하기 관련 오버라이딩
	 */
	@Override
	public void insertMedicineScore(Map<String, String> params) throws Exception {

		smc.insert("prescription.insertMedicineScore", params);
		
	}

	
	/**
	 * 처방받은 관리원 장소 리스트 가져오기 관련 오버라이딩
	 */
	@Override
	public List<Map<String, Object>> getPrescriptionHospitalList(String mem_id) throws Exception {

		return smc.queryForList("prescription.getPrescriptionHospitalList", mem_id);
		
	}

	
	/**
	 * 내가 처방받은 진료코드 리스트 가져오기
	 */
	@Override
	public List<Map<String, Object>> getTreatList(String mem_id) throws Exception {
		
		return smc.queryForList("prescription.getTreatList", mem_id);
		
	}

}
