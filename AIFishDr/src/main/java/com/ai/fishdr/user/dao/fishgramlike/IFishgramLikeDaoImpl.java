package com.ai.fishdr.user.dao.fishgramlike;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ai.fishdr.vo.FishgramLikeVO;
import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * 
 * @Class  Name : IFishgramLikeDaoImpl.java
 * @Description : 피쉬그램 좋아요 전체관리 DaoImpl 클래스
 * @Modification Information
 * @author 심재형
 * @since  2018. 11. 30.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일            수정자      수정내용
 *    -------------		-------     -------------------
 *    2018. 11. 30.     심재형      최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
@Repository
public class IFishgramLikeDaoImpl implements IFishgramLikeDao {

	@Autowired
	private SqlMapClient smc;
	
	
	/**
	 * 선택한 피쉬그램 글에 좋아요 추가 관련 오버라이딩
	 */
	@Override
	public void insertFishgramDiaryLike(Map<String, String> params) throws Exception {

		smc.insert("fishgramLike.insertFishgramDiaryLike", params);
		
	}
	
	
	/**
	 * 선택한 피쉬그램 글에 추가한 좋아요를 취소하기
	 */
	@Override
	public void deleteFishgramDiaryLike(Map<String, String> params) throws Exception {

		smc.delete("fishgramLike.deleteFishgramDiaryLike", params);
		
	}


	/**
	 * 현재 글의 좋아요 수 구하기 관련 오버라이딩
	 */
	@Override
	public int totalFishgramDiaryLikeCount(String bo_no) throws Exception {

		return (int) smc.queryForObject("fishgramLike.totalFishgramDiaryLikeCount", bo_no);
		
	}


	/**
	 * 해당 글의 특정 아이디의 좋아요 상태 값을 가져오기 관련 오버라이딩
	 */
	@Override
	public String getLikeStatus(Map<String, String> params) throws Exception {

		return (String) smc.queryForObject("fishgramLike.getLikeStatus", params);
		
	}


	/**
	 * 입력받은 닉네임 조건에 맞는 좋아요 누른 회원 리스트 출력
	 */
	@Override
	public List<Map<String, FishgramLikeVO>> searchLike(Map<String, String> params) throws Exception {

		return smc.queryForList("fishgramLike.searchLike", params);
		
	}


	
	
	


	

	

}
