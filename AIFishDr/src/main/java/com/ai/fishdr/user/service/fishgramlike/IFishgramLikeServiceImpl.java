package com.ai.fishdr.user.service.fishgramlike;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ai.fishdr.user.dao.fishgram.IFishgramDao;
import com.ai.fishdr.user.dao.fishgramlike.IFishgramLikeDao;
import com.ai.fishdr.vo.BoardFileVO;
import com.ai.fishdr.vo.FishgramLikeVO;
import com.ai.fishdr.vo.FishgramVO;

/**
 * 
 * @Class  Name : IFishgramLikeSerivceImpl.java
 * @Description : 피쉬그램 전체관리 ServiceImpl 클래스
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
@Service
public class IFishgramLikeServiceImpl implements IFishgramLikeService {
	
	@Autowired
	private IFishgramLikeDao dao;

	
	/**
	 * 선택한 피쉬그램 글에 좋아요 추가 관련 트랜잭션 및 오버라이딩
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public void insertFishgramDiaryLike(Map<String, String> params) throws Exception {
		
		dao.insertFishgramDiaryLike(params);
		
	}
	
	
	/**
	 * 선택한 피쉬그램 글에 추가한 좋아요를 취소하기 관련 트랜잭션 및 오버라이딩
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public void deleteFishgramDiaryLike(Map<String, String> params) throws Exception {

		dao.deleteFishgramDiaryLike(params);
		
	}


	/**
	 * 현재 글의 좋아요 수 구하기
	 */
	@Override
	public int totalFishgramDiaryLikeCount(String bo_no) throws Exception {

		return dao.totalFishgramDiaryLikeCount(bo_no);
		
	}


	/**
	 * 해당 글의 특정 아이디의 좋아요 상태 값을 가져오기 관련 오버라이딩
	 */
	@Override
	public String getLikeStatus(Map<String, String> params) throws Exception {

		return dao.getLikeStatus(params);
				
	}


	@Override
	public List<Map<String, FishgramLikeVO>> searchLike(Map<String, String> params) throws Exception {

		return dao.searchLike(params);
		
	}

}
