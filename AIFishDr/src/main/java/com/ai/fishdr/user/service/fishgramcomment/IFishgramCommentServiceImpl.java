package com.ai.fishdr.user.service.fishgramcomment;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ai.fishdr.user.dao.fishgramcomment.IFishgramCommentDao;
import com.ai.fishdr.vo.FishgramCommentVO;

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
public class IFishgramCommentServiceImpl implements IFishgramCommentService {
	
	@Autowired
	private IFishgramCommentDao dao;

	/**
	 * 피쉬그램 댓글 등록 관련 트랜잭션 및 오버라이딩
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public void insertFishgramDiaryComment(Map<String, String> params) throws Exception {
		
		dao.insertFishgramDiaryComment(params);
		
	}
	
	
	/**
	 * 피쉬그램 댓글 수정 관련 트랜잭션 및 오버라이딩
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public void modifyFishgramDiaryComment(Map<String, String> params) throws Exception {
		
		dao.modifyFishgramDiaryComment(params);
		
	}
	
	
	/**
	 * 피쉬그램 댓글 삭제 관련 트랜잭션 및 오버라이딩
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public void deleteFishgramDiaryComment(Map<String, String> params) throws Exception {

		dao.deleteFishgramDiaryComment(params);
		
	}

	
	/**
	 * 특정 글에 등록된 댓글 전체 리스트 가져오기
	 */
	@Override
	public List<Map<String, FishgramCommentVO>> getFishgramDiaryCommentList(Map<String, String> params) throws Exception {
		
		return dao.getFishgramDiaryCommentList(params);
		
	}
	
	
	/**
	 * 특정 글에 댓글을 올린 아이디 리스트 (중복제거, 아이디 오름차순) 
	 */
	@Override
	public List<String> getCommentMemIdNoDuplicate() throws Exception {

		return dao.getCommentMemIdNoDuplicate();
		
	}


	/**
	 * 특정 글의 댓글 총 개수 
	 */
	@Override
	public int totalFishgramDiaryCommentCount(Map<String, String> params) throws Exception {

		return dao.totalFishgramDiaryCommentCount(params);
		
	}


	


	
}
