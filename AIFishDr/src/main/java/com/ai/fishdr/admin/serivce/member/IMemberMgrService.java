package com.ai.fishdr.admin.serivce.member;

import java.util.List;
import java.util.Map;

import com.ai.fishdr.vo.MemberVO;
import com.ai.fishdr.vo.MessageVO;

/**
 * @Class Name :IMemberService.java
 * @Description : 관리자 회원관리 service
 * @Modification Information
 * @author 진형용
 * @since  2018. 11. 26.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일             수정자             수정내용
 *    -------        -------     -------------------
 *    2018. 11. 26.     진형용             최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
public interface IMemberMgrService {
	/**
	 *  개요 : 일반회원 리스트 
	 * @Method Name : getMemberList
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : List<MemberVO>
	 * @throws :
	 */
	public List<MemberVO> getMemberList(Map<String, String>params) throws Exception;
	/**
	 *  개요 : 일반회원 카운트
	 * @Method Name : getMemberCnt
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : int
	 * @throws :
	 */
	public int getMemberCnt(Map<String, String>params) throws Exception;
	/**
	 *  개요 : 블랙리스트 회원 카운트
	 * @Method Name : getBlackMemberCnt
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : int
	 * @throws :
	 */
	public int getBlackMemberCnt(Map<String,String>params) throws Exception;
	/**
	 *  개요 : 블랙리스트 회원 리스트
	 * @Method Name : getBlackMemberList
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : List<Map<String,MemberVO>>
	 * @throws :
	 */
	public List<Map<String,MemberVO>> getBlackMemberList(Map<String,String>params) throws Exception;
	/**
	 *  개요 : 탈퇴신청회원 수
	 * @Method Name : getSecMemberCnt
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : int
	 * @throws :
	 */
	public int getSecMemberCnt(Map<String,String>params) throws Exception;
	/**
	 *  개요 : 탈퇴 신청회원 리스트
	 * @Method Name : getSecMemberList
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : List<Map<String,MemberVO>>
	 * @throws :
	 */
	public List<Map<String,MemberVO>> getSecMemberList(Map<String,String>params) throws Exception;
	/**
	 *  개요 : 회원 탈퇴승인 처리 메서드
	 * @Method Name : deleteMember
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : boolean
	 * @throws :
	 */
	public boolean deleteMember(String[] id) throws Exception;
	/**
	 *  개요 : 회원 경고메세지 insert
	 * @Method Name : warningMsg
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : MessageVO
	 * @throws :
	 */
	public boolean warningMsg(MessageVO vo) throws Exception;
	/**
	 *  개요 : 회원 경고 수 없데이트
	 * @Method Name : updateSttemnt
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : boolean
	 * @throws :
	 */
	public boolean updateSttemnt(String mem_id) throws Exception;
	/**
	 *  개요 : 블랙리스트 회원이 작성했던 신고된 게시글 리스트
	 * @Method Name : getMemsSttBoard
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : List<Map<String,Object>>
	 * @throws :
	 */
	public List<Map<String,Object>> getMemsSttBoard(String mem_id)throws Exception;
	/**
	 *  개요 : 회원전체 리스트(엑셀 다운로드)
	 * @Method Name : allMemberForExcel
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : List<MemberVO>
	 * @throws :
	 */
	public List<MemberVO> allMemberForExcel()throws Exception;
	/**
	 *  개요 : 블랙리스트 초기화
	 * @Method Name : backMemStt
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : boolean
	 * @throws :
	 */
	public boolean backMemStt(List<String> forStt) throws Exception;
	
	
	
	
	public int getMsgCheck(String mem_id)throws Exception;
}
