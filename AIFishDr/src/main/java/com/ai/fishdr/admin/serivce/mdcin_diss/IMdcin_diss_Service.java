package com.ai.fishdr.admin.serivce.mdcin_diss;

import java.util.List;
import java.util.Map;

import com.ai.fishdr.vo.MdcinDissVO;

public interface IMdcin_diss_Service {
	/**
	 * 
	 *  개요 : 의약품 질병 리스트 출력
	 * @Method Name : mdcin_diss_List
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : List
	 * @throws :
	 */
	public List<MdcinDissVO> mdcin_diss_List(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 *  개요 : 의약품 질병 카운트
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
	 *  개요 : 의약품 질병 등록
	 * @Method Name : mdcin_diss_Insert
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : int
	 * @throws : Exception
	 */
	public int mdcin_diss_Insert(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 *  개요 : 의약품 질병 중복 확인
	 * @Method Name : duplicationCheck
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : MdcinDissVO
	 * @throws : Exception
	 */
	public MdcinDissVO duplicationCheck(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 *  개요 : 의약품 질병 삭제
	 * @Method Name : mdcin_diss_Delete
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : int
	 * @throws : Exception
	 */
	public int mdcin_diss_Delete(String md_code) throws Exception;
	
	/**
	 * 
	 *  개요 : 의약품 질병 정보
	 * @Method Name : mdcin_diss_Info
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : int
	 * @throws : Exception
	 */
	public MdcinDissVO mdcin_diss_Info(String md_code) throws Exception;
	
	/**
	 * 
	 *  개요 : 의약품 질병 수정
	 * @Method Name : mdcin_diss_Update
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : int
	 * @throws : Exception
	 */
	public int mdcin_diss_Update(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 *  개요 : 질병코드로 인한 의약품 코드 추출
	 * @Method Name : getMdcinCode
	 * @author : 조성광
	 * -----------------------------------
	 * @param : diss_code
	 * @return : MdcinDissVO
	 * @throws : Exception
	 */
	public List<MdcinDissVO> getMdcinCode(String diss_code) throws Exception;
	
}
