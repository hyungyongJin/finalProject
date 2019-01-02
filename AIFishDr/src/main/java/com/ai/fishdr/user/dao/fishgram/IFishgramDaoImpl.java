package com.ai.fishdr.user.dao.fishgram;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ai.fishdr.vo.FishgramVO;
import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * 
 * @Class  Name : IFishgramDaoImpl.java
 * @Description : 피쉬그램 전체관리 DaoImpl 클래스
 * @Modification Information
 * @author 심재형
 * @since  2018. 11. 13.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일            수정자      수정내용
 *    -------------		-------     -------------------
 *    2018. 11. 13.     심재형      최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
@Repository
public class IFishgramDaoImpl implements IFishgramDao {

	@Autowired
	private SqlMapClient smc;
	
	/**
	 * 피쉬그램 글 등록 관련 오버라이딩
	 */
	@Override
	public void insertFishgramDiary(FishgramVO fgv) throws Exception {

		smc.insert("fishgram.insertFishgramDiary", fgv);
		
	}

	
	/**
	 * 피쉬그램 글 수정 관련 오버라이딩
	 */
	@Override
	public void updateFishgramDiary(FishgramVO fgv) throws Exception {

		smc.update("fishgram.updateFishgramDiary", fgv);
		
	}

	
	/**
	 * 피쉬그램 글 전체 리스트 관련 오버라이딩
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<FishgramVO> getFishgramDiaryList(Map<String, String> params) throws Exception {

		return smc.queryForList("fishgram.getFishgramDiaryList", params);
		
	}

		
	/**
	 * 피쉬그램 글 삭제 관련 오버라이딩
	 */
	@Override
	public void deleteFishgramDiary(String bo_no) throws Exception {
		
		smc.update("fishgram.deleteFishgramDiary", bo_no);
		
	}


	/**
	 * 조건에 맞는 특정 작성자가 작성한 피쉬그램 글 개수 계산 오버라이딩
	 */
	@Override
	public int totalFishgramDiaryCount(Map<String, String> params) throws Exception {

		return (int) smc.queryForObject("fishgram.totalFishgramDiaryCount", params);
		
	}
	
	/**
	 * 특정 작성자가 작성한 피쉬그램 글 총 개수 계산 관련 오버라이딩
	 */
	@Override
	public int totalFishgramDiaryAllCount(Map<String, String> params) throws Exception {

		return (int) smc.queryForObject("fishgram.totalFishgramDiaryAllCount", params);
		
	}
	
	
	/**
	 * 자신의 모든 글에 카운팅된 좋아요 총 수 관련 오버라이딩
	 */
	@Override
	public int totalLikeAllCount(Map<String, String> params) throws Exception {

		return (int) smc.queryForObject("fishgram.totalLikeAllCount", params);
		
	}
	
	
	/**
	 * 로그인 한 회원의 친구 총 인원 구하기 관련 오버라이딩
	 */
	@Override
	public int totalSearchFriendAllCount(String mem_id) throws Exception {

		return (int) smc.queryForObject("fishgram.totalSearchFriendAllCount", mem_id);
		
	}


	/**
	 * 피쉬그램 게시글 번호를 이용한 게시글 정보 가져오기 관련 오버라이딩
	 */
	@Override
	public FishgramVO getFishgramDiaryInfoAsBoNo(Map<String, String> params) throws Exception {

		return (FishgramVO) smc.queryForObject("fishgram.getFishgramDiaryInfoAsBoNo", params);
		
	}

	
	/**
	 * 게시판 작성자를 이용하여 닉네임 정보 가져오기 관련 오버라이딩
	 */
	@Override
	public String getMemIdAsBoWriter(Map<String, String> params) throws Exception {

		return (String) smc.queryForObject("fishgram.getMemIdAsBoWriter", params);
		
	}


	/**
	 * 특정 글 조회수 1 증가시키기 관련 오버라이딩
	 */
	@Override
	public void increaseHitCount(Map<String, String> hitCountParams) throws Exception {

		smc.update("fishgram.increaseHitCount", hitCountParams);
		
	}


	


	

	

}
