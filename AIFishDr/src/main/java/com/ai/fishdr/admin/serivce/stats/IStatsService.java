package com.ai.fishdr.admin.serivce.stats;

import java.util.List;
import java.util.Map;

import com.ai.fishdr.vo.BoardVO;
import com.ai.fishdr.vo.MedicineVO;
import com.ai.fishdr.vo.SecessionVO;
import com.ai.fishdr.vo.StatsVO;
/**
 * @Class Name :IStatsService.java
 * @Description : 통계 관련 service
 * @Modification Information
 * @author 진형용
 * @since  2018. 11. 21.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일             수정자             수정내용
 *    -------        -------     -------------------
 *    2018. 11. 21.     진형용             최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
public interface IStatsService {
	/**
	 *  개요 : 방문자 접속환경, 시간 , ip체크 
	 * @Method Name : insertVisitorCount
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : void
	 * @throws :
	 */
	public void insertVisitorCount(StatsVO vo) throws Exception;
	/**
	 *  개요 : 방문자수 구하기
	 * @Method Name : getVisitorCount
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : Map<String,StatsVO>
	 * @throws :
	 */
	public Map<String,StatsVO> getVisitorCount() throws Exception;
	/**
	 *  개요 : 게시판 코드를 통해 게시판 글 수 구하는 메서드
	 * @Method Name : getEachBoardCount
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : void
	 * @throws :
	 */
	public List<Object> getEachBoardCount(List<String> board_code)throws Exception;
	/**
	 *  개요 : 각 주별 회원증가 수 확인
	 * @Method Name : getMemberIncreaseRatio
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : Map<String,Object>
	 * @throws :
	 */
	public Map<String,Object> getMemberIncreaseRatio() throws Exception;
	/**
	 *  개요 : 추천받은 게시글 중 상위 10개만 뽑아오는 리스트
	 * @Method Name : getFamousWriteList
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : List<Map<String,BoardVO>>
	 * @throws :
	 */
	public List<Map<String,BoardVO>> getFamousWriteList() throws Exception;
	
	/**  개요 : 검색 순위가 높은 상위10 의약품 리스트
	 * @Method Name : getFamouseMdcin
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : List<MedicineVO>
	 * @throws :
	 */
	public List<MedicineVO> getFamouseMdcin() throws Exception;
	/**
	 *  개요 : 탈퇴 사유 통계
	 * @Method Name : getSecReason
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : Map<String,SecessionVO>
	 * @throws :
	 */
	public Map<String,SecessionVO> getSecReason() throws Exception;
	/**
	 *  개요 : 등록된 의약품 수
	 * @Method Name : getMdcinCnt
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : int
	 * @throws :
	 */
	public int getMdcinCnt() throws Exception;
	/**
	 *  개요 : 게시판에 등록된 총 파일의 크기
	 * @Method Name : getTotalStorage
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : String
	 * @throws :
	 */
	public String getTotalStorage() throws Exception;
	/**
	 *  개요 : AI처방을 통해 발행된 처방전 수
	 * @Method Name : getTotalPrsCnt
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : int
	 * @throws :
	 */
	public int getTotalPrsCnt() throws Exception;
	/**
	 *  개요 : 회원이 AI처방받는 어류의 비율정보
	 * @Method Name : getFishInfo
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : Map<String,String>
	 * @throws :
	 */
	public List<Map<String, String>> getFishInfo() throws Exception;
}
