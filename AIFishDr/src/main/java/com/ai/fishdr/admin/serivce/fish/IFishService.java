package com.ai.fishdr.admin.serivce.fish;

import java.util.List;
import java.util.Map;

import com.ai.fishdr.vo.FishVO;

public interface IFishService {
	
	/**
	 * 
	 *  개요 : 어종 리스트 출력
	 * @Method Name : getFishList
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : List
	 * @throws :
	 */
	public List<FishVO> getFishList(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 *  개요 : 어종 리스트 갯수
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
	 *  개요 : 어종 정보 삭제
	 * @Method Name : deleteFish
	 * @author : 조성광
	 * -----------------------------------
	 * @param : fish_code
	 * @return : boolean
	 * @throws : Exception
	 */
	public int deleteFish(String fish_code) throws Exception;
	
	/**
	 * 
	 *  개요 : 어종 정보 등록
	 * @Method Name : insertFish
	 * @author : 조성광
	 * -----------------------------------
	 * @param : fish_code
	 * @return : int
	 * @throws : Exception
	 */
	public int insertFish(String fish_name) throws Exception;
	
	/**
	 * 
	 *  개요 : 어종 정보 
	 * @Method Name : fishInfo
	 * @author : 조성광
	 * -----------------------------------
	 * @param : fish_code
	 * @return : FishVO
	 * @throws : Exception
	 */
	public FishVO fishInfo(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 *  개요 : 어종 정보 수정 
	 * @Method Name : updateFish
	 * @author : 조성광
	 * -----------------------------------
	 * @param : fish_code
	 * @return : int
	 * @throws : Exception
	 */
	public int updateFish(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 *  개요 : 어종 정보 리스트(조건x)
	 * @Method Name : fishList
	 * @author : 조성광
	 * -----------------------------------
	 * @param : 
	 * @return : List
	 * @throws : Exception
	 */
	public List<FishVO> fishList() throws Exception;
	
	/**
	 * 
	 *  개요 : 어종 중복 체크 
	 * @Method Name : duplicationCheck
	 * @author : 조성광
	 * -----------------------------------
	 * @param : fish_name
	 * @return : FishVO
	 * @throws : Exception
	 */
	public FishVO duplicationCheck(String fish_name) throws Exception;
}
