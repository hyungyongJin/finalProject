package com.ai.fishdr.admin.serivce.mdcin;

import java.util.List;
import java.util.Map;

import com.ai.fishdr.vo.MedicineVO;

public interface IMdcinAdminService {
	
	/**
	 * 
	 *  개요 : 의약품 리스트 출력
	 * @Method Name : getMdcinList
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : List
	 * @throws :
	 */
	public List<MedicineVO> getMdcinList(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 *  개요 : 의약품 리스트 갯수
	 * @Method Name : totalCount
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : int
	 * @throws : Exception
	 */
	public int totalCount(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 *  개요 : 의약품 정보 삭제
	 * @Method Name : deleteMdcin
	 * @author : 조성광
	 * -----------------------------------
	 * @param : mdcin_code
	 * @return : int
	 * @throws : Exception
	 */
	public int deleteMdcin(String mdcin_code) throws Exception;
	
	/**
	 * 
	 *  개요 : 의약품 정보 등록
	 * @Method Name : insertMdcin
	 * @author : 조성광
	 * -----------------------------------
	 * @param : mdcinInfo
	 * @return : int
	 * @throws : Exception
	 */
	public int insertMdcin(MedicineVO mdcinInfo) throws Exception;
	
	/**
	 * 
	 *  개요 : 의약품 정보 
	 * @Method Name : getMdcinInfo
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : MedicineVO
	 * @throws : Exception
	 */
	public MedicineVO getMdcinInfo(String mdcin_code) throws Exception;
	
	/**
	 * 
	 *  개요 : 의약품 정보 수정 
	 * @Method Name : updateMdcin
	 * @author : 조성광
	 * -----------------------------------
	 * @param : mdcinInfo
	 * @return : int
	 * @throws : Exception
	 */
	public int updateMdcin(MedicineVO mdcinInfo) throws Exception;
	
	/**
	 * 
	 *  개요 : 의약품 정보 리스트(조건x)
	 * @Method Name : mdcinList
	 * @author : 조성광
	 * -----------------------------------
	 * @param : 
	 * @return : List
	 * @throws : Exception
	 */
	public List<MedicineVO> mdcinList() throws Exception;
}
