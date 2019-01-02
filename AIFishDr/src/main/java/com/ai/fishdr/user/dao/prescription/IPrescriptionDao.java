package com.ai.fishdr.user.dao.prescription;

import java.util.List;
import java.util.Map;

import com.ai.fishdr.vo.FriendVO;
import com.ai.fishdr.vo.PrescriptionVO;

/**
 * 
 * @Class Name :IPrescriptionDao.java
 * @Description : 처방전 관리 dao
 * @Modification Information
 * @author 
 * @since  2018. 11. 12.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일             수정자             수정내용
 *    -------        -------     -------------------
 *    2018. 11. 12.     조성광             최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
public interface IPrescriptionDao {
	
	/**
	 * 
	 *  개요 : 처방전 등록
	 * @Method Name : prscrptn_Insert
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : 
	 * @throws : Exception
	 */
	public void prscrptn_Insert(PrescriptionVO prescriptionInfo) throws Exception;
	
	
	/**
	 * 
	 *  개요 : 처방전 최신 등록 코드 번호
	 * @Method Name : prscrptn_getCodeNumber
	 * @author : 조성광
	 * -----------------------------------
	 * @param :
	 * @return : String
	 * @throws : Exception
	 */
	public String prscrptn_getCodeNumber() throws Exception;
	
	
	/**
	 * 
	 *  개요 : 처방전 최신 등록 코드 번호
	 * @Method Name : prscrptnInfo
	 * @author : 조성광
	 * -----------------------------------
	 * @param : prscrptn_code
	 * @return : PrescriptionVO
	 * @throws : Exception
	 */
	public PrescriptionVO prscrptnInfo(String prscrptn_code) throws Exception;
	
	
	/**
	 *  개요 : 해당 회원의 처방전 정보 가져오는 메서드
	 * @Method Name : getMemsPrscrptnInfo
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : Map<String,PrescriptionVO>
	 * @throws :
	 */
	public List<Map<String, Object>> getMemsPrscrptnInfo(Map<String,String>params) throws Exception;
	
	
	/**
	 *  개요 : 회원 총 처방 카운트
	 * @Method Name : totalMemsPrsCnt
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : int
	 * @throws :
	 */
	public int totalMemsPrsCnt(Map<String, String> params) throws Exception;
	
	
	/**
	 *  개요 : 처방내역관리 리스트
	 * @Method Name : getPrescriptionList
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : List<Map<String, Object>>
	 * @throws : Exception
	 */
	public List<Map<String, Object>> getPrescriptionList(Map<String, String> params) throws Exception;
	
	
	/**
	 *  개요 : 처방내역관리 리스트 총 개수
	 * @Method Name : totalPrescriptionListAllCount
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : int
	 * @throws : Exception
	 */
	public int totalPrescriptionListAllCount(Map<String, String> params) throws Exception;
	
	
	/**
	 *  개요 : 검색 조건에 맞는 처방 내역 리스트 개수
	 * @Method Name : totalPrescriptionListCount
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : int
	 * @throws : Exception
	 */
	public int totalPrescriptionListCount(Map<String, String> params) throws Exception;
	
	
	/**
	 *  개요 : 특정한 품종에게 나타날 수 있는 증상과 해당 증상에 사용할 수 있는 약들의 용법 및 용량, 휴약기간 정보를 갖고온 리스트
	 * @Method Name : resultPrescription
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : nameSymptomsList (List<List<String>> 타입)
	 * @return : List<Map<String, Object>>
	 * @throws : Exception
	 */
	public List<Map<String, Object>> resultPrescription(Map<String, String> params) throws Exception;
	
	
	/**
	 *  개요 : 처방 가능 의약품 리스트 총 개수
	 * @Method Name : totalResultAllPrescription
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : int
	 * @throws : Exception
	 */
	public int totalResultAllPrescription(Map<String, String> params) throws Exception;
	
	
	
	/**
	 *  개요 : 특정한 증상을 보이는 특정한 품종한테 최종적으로 처방한 약 정보
	 * @Method Name : finalResultPrescription
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : List<Map<String, Object>>
	 * @throws : Exception
	 */
	public List<Map<String, Object>> finalResultPrescription(Map<String, String> params) throws Exception;
	
	
	/**
	 *  개요 : 처방내역 상세 리스트 중 병명을 중복 제거하여 정보 갖고 오기
	 * @Method Name : getResultPrescriptionDissName
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : List<String>
	 * @throws : Exception
	 */
	public List<String> getResultPrescriptionDissName(Map<String, String> params) throws Exception;
	
	
	/**
	 *  개요 : 처방내역 상세 리스트 중 질병파일명을 중복 제거하여 정보 갖고 오기
	 * @Method Name : getResultPrescriptionDiseaseFile
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : List<String>
	 * @throws : Exception
	 */
	public List<String> getResultPrescriptionDiseaseFile(Map<String, String> params) throws Exception;
	
	
	/**
	 *  개요 : 특정 회원이 특정 의약품에 점수를 부여한 의사코드 총 개수 가져오기
	 * @Method Name : searchTreatCodeAddScore
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : int
	 * @throws : Exception
	 */
	public int searchTreatCodeAddScore(Map<String, String> params) throws Exception;
	
	
	/**
	 *  개요 : 특정 회원이 특정 의약품에 점수를 부여한 처방코드 총 개수 가져오기
	 * @Method Name : searchPrscrptnCodeAddScore
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : int
	 * @throws : Exception
	 */
	public int searchPrscrptnCodeAddScore(Map<String, String> params) throws Exception;
	
	
	/**
	 *  개요 : 처방받은 의약품 점수를 등록하기
	 * @Method Name : insertMedicineScore
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : -
	 * @throws : Exception
	 */
	public void insertMedicineScore(Map<String, String> params) throws Exception;
	
	
	/**
	 *  개요 : 내가 처방받은 처방코드와 그 처방을 받은 관리원 리스트 가져오기
	 * @Method Name : getPrescriptionHospitalList
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : mem_id (String 타입)
	 * @return : List<Map<String, Object>>
	 * @throws : Exception
	 */
	public List<Map<String, Object>> getPrescriptionHospitalList(String mem_id) throws Exception;
	
	
	/**
	 *  개요 : 내가 처방받은 진료코드 리스트 가져오기
	 * @Method Name : getPrescriptionHospitalList
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : mem_id (String 타입)
	 * @return : List<Map<String, Object>>
	 * @throws : Exception
	 */
	public List<Map<String, Object>> getTreatList(String mem_id) throws Exception;
	
}
