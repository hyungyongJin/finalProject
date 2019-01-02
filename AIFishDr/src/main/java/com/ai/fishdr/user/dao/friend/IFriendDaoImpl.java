package com.ai.fishdr.user.dao.friend;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ai.fishdr.vo.FriendVO;
import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * 
 * @Class  Name : IFishgramCommentDaoImpl.java
 * @Description : 피쉬그램 댓글 전체관리 DaoImpl 클래스
 * @Modification Information
 * @author 심재형
 * @since  2018. 11. 21.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일            수정자      수정내용
 *    -------------		-------     -------------------
 *    2018. 11. 21.     심재형      최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
@Repository
public class IFriendDaoImpl implements IFriendDao {

	@Autowired
	private SqlMapClient smc;
	
	
	/**
	 * 중복 친구 신청 방지 관련 오버라이딩
	 */
	@Override
	public int duplicateApplyProtect(Map<String, String> params) throws Exception {

		Object duplicateCount = smc.queryForObject("friend.duplicateApplyProtect", params);
		
		if (duplicateCount == null) {
			
			return 0;
			
		} else {
			
			return (int) smc.queryForObject("friend.duplicateApplyProtect", params);
			
		}
				
	}

	
	/**
	 * 피쉬그램 친구 신청 관련 오버라이딩
	 */
	@Override
	public void applyFishgramFriend(Map<String, String> params) throws Exception {

		smc.insert("friend.applyFishgramFriend", params);
		
	}
	
	
	/**
	 * 내가 상대방에게 요청한 친구 신청을 취소하기 관련 오버라이딩
	 */
	@Override
	public void cancelFishgramFriendApply(Map<String, String> params) throws Exception {

		smc.delete("friend.cancelFishgramFriendApply", params);
		
	}
	
	
	/**
	 * 상대방이 나에게 요청한 친구 신청을 수락하기
	 */
	@Override
	public void acceptFishgramFriendApply(Map<String, String> params) throws Exception {

		smc.update("friend.acceptFishgramFriendApply", params);
		
	}
	
	
	/**
	 * 상대방이 나에게 요청한 친구 신청을 거절하기 관련 오버라이딩
	 */
	@Override
	public void refuseFishgramFriendApply(Map<String, String> params) throws Exception {

		smc.delete("friend.refuseFishgramFriendApply", params);
		
	}


	/**
	 * 친구신청 아이디와 친구신청 받은 아이디를 이용한 친구신청 상태 정보 불러오기 관련 오버라이딩
	 */
	@Override
	public FriendVO getFishgramFriendInfo(Map<String, String> params) throws Exception {

		return (FriendVO) smc.queryForObject("friend.getFishgramFriendInfo", params);
		
	}
	
	
	/**
	 * 아이디를 이용한 친구상태 확인하기 관련 오버라이딩
	 */
	@Override
	public String getFrStatus(Map<String, String> params) throws Exception {
		
		return (String) smc.queryForObject("friend.getFrStatus", params);
		
	}


	/**
	 * 자신에게 친구신청을 요청한 회원의 수 구하기 관련 오버라이딩
	 */
	@Override
	public int totalReceiveFriendApplyCount(String mem_id) throws Exception {
		
		return (int) smc.queryForObject("friend.totalReceiveFriendApplyCount", mem_id);
		
	}
	
	
	/**
	 * 내가 친구신청 요청한 회원의 수 구하기 관련 오버라이딩
	 */
	@Override
	public int totalSendFriendApplyCount(String mem_id) throws Exception {

		return (int) smc.queryForObject("friend.totalSendFriendApplyCount", mem_id);
		
	}
	
	
	/**
	 * 자신에게 친구신청을 요청한 회원들 리스트 보기 관련 오버라이딩
	 */
	@Override
	public List<Map<String, FriendVO>> receiveFriendApplyList(Map<String, String> receiveFriendParams) throws Exception {

		return smc.queryForList("friend.receiveFriendApplyList", receiveFriendParams);
		
	}


	/**
	 * 내가 친구신청을 한 회원들 리스트 보기
	 */
	@Override
	public List<Map<String, FriendVO>> sendFriendApplyList(Map<String, String> sendFriendParams) throws Exception {

		return smc.queryForList("friend.sendFriendApplyList", sendFriendParams);
		
	}


	/**
	 * 친구 관리 메뉴에서 입력받은 닉네임 조건에 맞는 친구 수 구하기 관련 오버라이딩
	 */
	@Override
	public int totalSearchFriendCount(Map<String, String> params) throws Exception {

		return (int) smc.queryForObject("friend.totalSearchFriendCount", params);
		
	}


	/**
	 * 친구 관리 메뉴에서 입력받은 닉네임 조건에 맞는 친구 리스트 출력 관련 오버라이딩
	 */
	@Override
	public List<Map<String, FriendVO>> searchFriend(Map<String, String> params) throws Exception {

		return smc.queryForList("friend.searchFriend", params);
		
	}


	


	


	


	


	

}
