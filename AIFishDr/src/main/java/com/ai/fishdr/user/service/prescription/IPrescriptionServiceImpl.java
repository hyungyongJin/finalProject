package com.ai.fishdr.user.service.prescription;

import java.sql.Clob;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ai.fishdr.user.dao.prescription.IPrescriptionDao;
import com.ai.fishdr.utils.ClobToString;
import com.ai.fishdr.vo.HospitalVO;
import com.ai.fishdr.vo.PrescriptionVO;

@Repository
public class IPrescriptionServiceImpl implements IPrescriptionService {
	
	@Autowired
	private IPrescriptionDao dao;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public void prscrptn_Insert(PrescriptionVO prescriptionInfo)
			throws Exception {
		dao.prscrptn_Insert(prescriptionInfo);
	}
	
	@Transactional(readOnly=true)
	@Override
	public String prscrptn_getCodeNumber() throws Exception {
		return dao.prscrptn_getCodeNumber();
	}
	
	@Transactional(readOnly=true)
	@Override
	public PrescriptionVO prscrptnInfo(String prscrptn_code) throws Exception {
		return dao.prscrptnInfo(prscrptn_code);
	}

	@Override
	public List<Map<String, Object>> getMemsPrscrptnInfo(
			Map<String, String> params) throws Exception {
		List<Map<String, Object>> data = dao.getMemsPrscrptnInfo(params);
		Clob change = null;
		for (int i = 0; i < data.size(); i++) {
			change = (Clob) data.get(i).get("HOSPITAL_ADDR");
			String clobData = ClobToString.convertClobToString(change);
			data.get(i).put("HOSPITAL_ADDR", clobData);
		}
		return data;
	}

	@Override
	public int totalMemsPrsCnt(Map<String, String> params) throws Exception {
		return dao.totalMemsPrsCnt(params);
	}

	
	/**
	 * 처방내역관리 리스트 관련 오버라이딩
	 */
	@Override
	public List<Map<String, Object>> getPrescriptionList(Map<String, String> params) throws Exception {

//		List<Map<String, Object>> pml = dao.getPrescriptionList(params);
//		
//		Clob change = null;
//		
//		for (int i = 0 ; i < pml.size() ; i++) {
//			
//			change = (Clob) pml.get(i).get("FISH_SYMPTMS");
//			
//			String clobData = ClobToString.convertClobToString(change);
//			
//			pml.get(i).put("FISH_SYMPTMS", clobData);
//			
//		}
//				
//		return pml;
		
		return dao.getPrescriptionList(params);
		
	}

	
	/**
	 * 처방내역관리 리스트 총 개수 관련 트랜잭션 및 오버라이딩
	 */
	@Transactional(readOnly=true)
	@Override
	public int totalPrescriptionListAllCount(Map<String, String> params) throws Exception {

		return dao.totalPrescriptionListAllCount(params);
		
	}

	
	/**
	 * 검색 조건에 맞는 처방 내역 리스트 개수
	 */
	@Override
	public int totalPrescriptionListCount(Map<String, String> params) throws Exception {

		return dao.totalPrescriptionListCount(params);
		
	}

	
	/**
	 * 특정한 품종에게 나타날 수 있는 증상과 해당 증상에 사용할 수 있는 약들의 용법 및 용량, 휴약기간 정보를 갖고온 리스트 관련 오버라이딩
	 */
	@Override
	public List<Map<String, Object>> resultPrescription(Map<String, String> params) throws Exception {
		
//		List<Map<String, Object>> rpl = dao.resultPrescription(params);
//		
//		Clob change = null;
//		Clob change1 = null;
//		
//		for (int i = 0 ; i < rpl.size() ; i++) {
//			
//			change = (Clob) rpl.get(i).get("SYMPTMS_CONTENT");
//			change1 = (Clob) rpl.get(i).get("USCP_CONTENT");
//						
//			String clobData = ClobToString.convertClobToString(change);
//			String clobData1 = ClobToString.convertClobToString(change1);
//			
//			rpl.get(i).put("SYMPTMS_CONTENT", clobData);
//			rpl.get(i).put("USCP_CONTENT", clobData1);
//			
//		}
//				
//		return rpl;
		
		return dao.resultPrescription(params);
		
	}
	
	
	/**
	 * 처방 가능 의약품 리스트 총 개수
	 */
	@Override
	public int totalResultAllPrescription(Map<String, String> params) throws Exception {

		return dao.totalResultAllPrescription(params);
		
	}
	
	
	/**
	 * 특정한 증상을 보이는 특정한 품종한테 최종적으로 처방한 약 정보 관련 오버라이딩
	 */
	@Override
	public List<Map<String, Object>> finalResultPrescription(Map<String, String> params) throws Exception {
		
//		List<Map<String, Object>> frpl = dao.finalResultPrescription(params);
//		
//		Clob change = null;
//		Clob change1 = null;
//		
//		for (int i = 0 ; i < frpl.size() ; i++) {
//			
//			change = (Clob) frpl.get(i).get("SYMPTMS_CONTENT");
//			change1 = (Clob) frpl.get(i).get("USCP_CONTENT");
//						
//			String clobData = ClobToString.convertClobToString(change);
//			String clobData1 = ClobToString.convertClobToString(change1);
//			
//			frpl.get(i).put("SYMPTMS_CONTENT", clobData);
//			frpl.get(i).put("USCP_CONTENT", clobData1);
//			
//		}
//				
//		return frpl;
		
		return dao.finalResultPrescription(params);
			
	}

	
	/**
	 * 처방내역 상세 리스트 중 병명을 중복 제거하여 정보 갖고 오기 관련 오버라이딩
	 */
	@Override
	public List<String> getResultPrescriptionDissName(Map<String, String> params) throws Exception {

		return dao.getResultPrescriptionDissName(params);
		
	}

	
	/**
	 * 처방내역 상세 리스트 중 질병파일명을 중복 제거하여 정보 갖고 오기 관련 오버라이딩
	 */
	@Override
	public List<String> getResultPrescriptionDiseaseFile(Map<String, String> params) throws Exception {

		return dao.getResultPrescriptionDiseaseFile(params);
		
	}

	
	/**
	 * 특정 의약품에 점수를 등록한 의사코드 개수 가져오기 관련 오버라이딩
	 */
	@Override
	public int searchTreatCodeAddScore(Map<String, String> params) throws Exception {

		return dao.searchTreatCodeAddScore(params);
		
	}
	
	
	/**
	 * 특정 회원이 특정 의약품에 점수를 부여한 처방코드 총 개수 가져오기 관련 오버라이딩
	 */
	@Override
	public int searchPrscrptnCodeAddScore(Map<String, String> params) throws Exception {

		return dao.searchPrscrptnCodeAddScore(params);
		
	}
	
	
	/**
	 * 처방받은 의약품 점수를 등록하기 관련 트랜잭션 및 오버라이딩
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public void insertMedicineScore(Map<String, String> params) throws Exception {

		dao.insertMedicineScore(params);
		
	}
	
	
	/**
	 * 처방받은 관리원 장소 리스트 가져오기 관련 오버라이딩
	 */
	@Override
	public List<Map<String, Object>> getPrescriptionHospitalList(String mem_id) throws Exception {

		return dao.getPrescriptionHospitalList(mem_id);
		
	}

	
	/**
	 * 내가 처방받은 진료코드 리스트 가져오기
	 */
	@Override
	public List<Map<String, Object>> getTreatList(String mem_id) throws Exception {

		return dao.getTreatList(mem_id);
		
	}

}
