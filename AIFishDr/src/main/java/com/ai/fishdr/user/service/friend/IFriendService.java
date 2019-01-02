package com.ai.fishdr.user.service.friend;

import java.util.List;
import java.util.Map;

import com.ai.fishdr.vo.FriendVO;

/**
 * 
 * @Class  Name : IFriendService.java
 * @Description : 피쉬그램 친구관리 Service 인터페이스
 * @Modification Information
 * @author 심재형
 * @since  2018. 11. 28.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일            수정자      수정내용
 *    -------------		-------     -------------------
 *    2018. 11. 28.     심재형      최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
public interface IFriendService {
	
	/**
	 * 
	 *    의미 : 중복 친구 신청 방지
	 * @Method : duplicateApplyProtect
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : -
	 * @throws : Exception
	 */
	public int duplicateApplyProtect(Map<String, String> params) throws Exception;
	
	
	/**
	 * 
	 *    의미 : 피쉬그램 친구 신청
	 * @Method : applyFishgramFriend
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : -
	 * @throws : Exception
	 */
	public void applyFishgramFriend(Map<String, String> params) throws Exception;
	
	
	/**
	 * 
	 *    의미 : 내가 상대방에게 요청한 친구 신청을 취소하기
	 * @Method : cancelFishgramFriendApply
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : -
	 * @throws : Exception
	 */
	public void cancelFishgramFriendApply(Map<String, String> params) throws Exception;
	
	
	/**
	 * 
	 *    의미 : 상대방이 나에게 요청한 친구 신청을 수락하기
	 * @Method : acceptFishgramFriendApply
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : -
	 * @throws : Exception
	 */
	public void acceptFishgramFriendApply(Map<String, String> params) throws Exception;
	
	
	/**
	 * 
	 *    의미 : 상대방이 나에게 요청한 친구 신청을 거절하기
	 * @Method : refuseFishgramFriendApply
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : -
	 * @throws : Exception
	 */
	public void refuseFishgramFriendApply(Map<String, String> params) throws Exception;
	
	
	/**
	 * 
	 *    의미 : 친구신청 아이디와 친구신청 받은 아이디를 이용한 친구신청 상태 정보 불러오기
	 * @Method : getFishgramFriendInfo
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : FriendVO
	 * @throws : Exception
	 */
	public FriendVO getFishgramFriendInfo(Map<String, String> params) throws Exception;
	
	
	/**
	 * 
	 *    의미 : 아이디를 이용한 친구상태 확인하기
	 * @Method : getFrStatus
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : String
	 * @throws : Exception
	 */
	public String getFrStatus(Map<String, String> params) throws Exception;
	
	
	/**
	 * 
	 *    의미 : 자신에게 친구신청을 요청한 회원의 수 구하기
	 * @Method : totalReceiveFriendApplyCount
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : mem_id (String 타입)
	 * @return : int
	 * @throws : Exception
	 */
	public int totalReceiveFriendApplyCount(String mem_id) throws Exception;
	
	
	/**
	 * 
	 *    의미 : 내가 친구신청 요청한 회원의 수 구하기
	 * @Method : totalSendFriendApplyCount
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : mem_id (String 타입)
	 * @return : int
	 * @throws : Exception
	 */
	public int totalSendFriendApplyCount(String mem_id) throws Exception;
		
	
	/**
	 * 
	 *    의미 : 자신에게 친구신청을 요청한 회원들 리스트 보기
	 * @Method : receiveFriendApplyList
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : receiveFriendParams (Map<String, String> 타입)
	 * @return : List<Map<String, FriendVO>>
	 * @throws : Exception
	 */
	public List<Map<String, FriendVO>> receiveFriendApplyList(Map<String, String> receiveFriendParams) throws Exception;
	
	
	/**
	 * 
	 *    의미 : 내가 친구신청을 한 회원들 리스트 보기
	 * @Method : sendFriendApplyList
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : sendFriendParams (Map<String, String> 타입)
	 * @return : List<Map<String, FriendVO>>
	 * @throws : Exception
	 */
	public List<Map<String, FriendVO>> sendFriendApplyList(Map<String, String> sendFriendParams) throws Exception;
	
	
	/**
	 * 
	 *    의미 : 친구 관리 메뉴에서 입력받은 닉네임 조건에 맞는 친구 수 구하기
	 * @Method : totalSearchFriendCount
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : int
	 * @throws : Exception
	 */
	public int totalSearchFriendCount(Map<String, String> params) throws Exception;
	
	
	/**
	 * 
	 *    의미 : 친구 관리 메뉴에서 입력받은 닉네임 조건에 맞는 친구 리스트 출력
	 * @Method : searchFriend
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : List<Map<String, FriendVO>>
	 * @throws : Exception
	 */
	public List<Map<String, FriendVO>> searchFriend(Map<String, String> params) throws Exception;
	
	
}
