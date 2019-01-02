package com.ai.fishdr.user.service.fishgram;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ai.fishdr.user.dao.fishgram.IFishgramDao;
import com.ai.fishdr.vo.BoardFileVO;
import com.ai.fishdr.vo.FishgramVO;

/**
 * 
 * @Class  Name : IFishgramSerivceImpl.java
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
public class IFishgramServiceImpl implements IFishgramService {
	
	@Autowired
	private IFishgramDao dao;

	/**
	 * 피쉬그램 글 추가 관련 트랜잭션 및 오버라이딩
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public void insertFishgramDiary(FishgramVO fgv) throws Exception {

		dao.insertFishgramDiary(fgv);
		
	}

	
	/**
	 * 피쉬그램 글 수정 관련 트랜잭션 및 오버라이딩
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public void updateFishgramDiary(FishgramVO fgv) throws Exception {

		dao.updateFishgramDiary(fgv);
		
	}

	
	/**
	 * 피쉬그램 글 전체 리스트 관련 트랜잭션 및 오버라이딩
	 */
	@Transactional(readOnly=true)
	@Override
	public List<FishgramVO> getFishgramDiaryList(Map<String, String> params) throws Exception {

		return dao.getFishgramDiaryList(params);
		
	}

	
	/**
	 * 피쉬그램 글 삭제 관련 트랜잭션 및 오버라이딩
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public void deleteFishgramDiary(String bo_no) throws Exception {
		
		dao.deleteFishgramDiary(bo_no);
		
	}


	/**
	 * 피쉬그램 글 총 개수 계산 관련 트랜잭션 및 오버라이딩
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public int totalFishgramDiaryCount(Map<String, String> params) throws Exception {

		return dao.totalFishgramDiaryCount(params);
		
	}


	/**
	 * 특정 작성자가 작성한 피쉬그램 글 총 개수 계산 관련 트랜잭션 및 오버라이딩
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public int totalFishgramDiaryAllCount(Map<String, String> params) throws Exception {
		
		return dao.totalFishgramDiaryAllCount(params);
		
	}
	
	
	/**
	 * 자신의 모든 글에 카운팅된 좋아요 총 수 관련 트랜잭션 및 오버라이딩 
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public int totalLikeAllCount(Map<String, String> params) throws Exception {

		return dao.totalLikeAllCount(params);
		
	}
	
	
	/**
	 * 로그인 한 회원의 친구 총 인원 구하기 관련 오버라이딩
	 */
	@Override
	public int totalSearchFriendAllCount(String mem_id) throws Exception {

		return dao.totalSearchFriendAllCount(mem_id);
		
	}


	/**
	 * 피쉬그램 게시글 번호를 이용한 게시글 정보 가져오기 관련 트랜잭션 및 오버라이딩
	 */
	@Transactional(readOnly=true)
	@Override
	public FishgramVO getFishgramDiaryInfoAsBoNo(Map<String, String> params) throws Exception {

		return dao.getFishgramDiaryInfoAsBoNo(params);
		
	}

	
	/**
	 * 게시판 작성자를 이용하여 닉네임 정보 가져오기 관련 트랜잭션 및 오버라이딩
	 */
	@Transactional(readOnly=true)
	@Override
	public String getMemIdAsBoWriter(Map<String, String> params) throws Exception {

		return dao.getMemIdAsBoWriter(params);
		
	}


	/**
	 * 특정 글 조회수 1 증가시키기 관련 트랜잭션 및 오버라이딩
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public void increaseHitCount(Map<String, String> hitCountParams) throws Exception {

		dao.increaseHitCount(hitCountParams);
		
	}


	


	
	
	
	

}
