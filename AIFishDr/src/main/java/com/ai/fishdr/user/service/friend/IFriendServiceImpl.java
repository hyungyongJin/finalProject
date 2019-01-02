package com.ai.fishdr.user.service.friend;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ai.fishdr.user.dao.friend.IFriendDao;
import com.ai.fishdr.vo.FriendVO;

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
public class IFriendServiceImpl implements IFriendService {
	
	@Autowired
	private IFriendDao dao;

	
	/**
	 * 중복 친구 신청 방지 관련 오버라이딩
	 */
	@Override
	public int duplicateApplyProtect(Map<String, String> params) throws Exception {

		return dao.duplicateApplyProtect(params);
		
	}
	
	
	/**
	 * 피쉬그램 친구 신청 관련 트랜잭션 및 오버라이딩
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public void applyFishgramFriend(Map<String, String> params) throws Exception {
		
		dao.applyFishgramFriend(params);
		
	}
	
	
	/**
	 * 내가 상대방에게 요청한 친구 신청을 취소하기 관련 트랜잭션 및 오버라이딩 
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public void cancelFishgramFriendApply(Map<String, String> params) throws Exception {

		dao.cancelFishgramFriendApply(params);
		
	}


	/**
	 * 상대방이 나에게 요청한 친구 신청을 수락하기
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public void acceptFishgramFriendApply(Map<String, String> params) throws Exception {

		dao.acceptFishgramFriendApply(params);
		
	}
	
	
	/**
	 * 상대방이 나에게 요청한 친구 신청을 거절하기 관련 오버라이딩
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public void refuseFishgramFriendApply(Map<String, String> params) throws Exception {

		dao.refuseFishgramFriendApply(params);
		
	}


	/**
	 * 친구신청 아이디와 친구신청 받은 아이디를 이용한 친구신청 상태 정보 불러오기 관련 오버라이딩
	 */
	@Transactional(readOnly=true)
	@Override
	public FriendVO getFishgramFriendInfo(Map<String, String> params) throws Exception {

		return dao.getFishgramFriendInfo(params);
		
	}
	
	
	/**
	 * 아이디를 이용한 친구상태 확인하기
	 */
	@Transactional(readOnly=true)
	@Override
	public String getFrStatus(Map<String, String> params) throws Exception {

		return dao.getFrStatus(params);
		
	}


	/**
	 * 자신에게 친구신청을 요청한 회원의 수 구하기
	 */
	@Override
	public int totalReceiveFriendApplyCount(String mem_id) throws Exception {

		return dao.totalReceiveFriendApplyCount(mem_id);
		
	}
	
	
	/**
	 * 상대방이 나에게 요청한 친구 신청을 거절하기 관련 오버라이딩
	 */
	@Override
	public int totalSendFriendApplyCount(String mem_id) throws Exception {

		return dao.totalSendFriendApplyCount(mem_id);
		
	}
	
	
	/**
	 * 자신에게 친구신청을 요청한 회원들 리스트 보기 관련 트랜잭션 및 오버라이딩
	 */
	@Transactional(readOnly=true)
	@Override
	public List<Map<String, FriendVO>> receiveFriendApplyList(Map<String, String> receiveFriendParams) throws Exception {
		
		return dao.receiveFriendApplyList(receiveFriendParams);
		
	}


	/**
	 * 내가 친구신청을 한 회원들 리스트 보기 관련 트랜잭션 및 오버라이딩
	 */
	@Transactional(readOnly=true)
	@Override
	public List<Map<String, FriendVO>> sendFriendApplyList(Map<String, String> sendFriendParams) throws Exception {

		return dao.sendFriendApplyList(sendFriendParams);
		
	}


	/**
	 * 친구 관리 메뉴에서 입력받은 닉네임 조건에 맞는 친구 수 구하기 관련 오버라이딩
	 */
	@Override
	public int totalSearchFriendCount(Map<String, String> params) throws Exception {
		
		return dao.totalSearchFriendCount(params);
		
	}


	/**
	 * 친구 관리 메뉴에서 입력받은 닉네임 조건에 맞는 친구 리스트 출력 관련 오버라이딩
	 */
	@Override
	public List<Map<String, FriendVO>> searchFriend(Map<String, String> params) throws Exception {

		return dao.searchFriend(params);
		
	}


	

	
	


	

}
