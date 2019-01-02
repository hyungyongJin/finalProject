package com.ai.fishdr.nouser.dao.join;

import java.util.Map;

import com.ai.fishdr.vo.MemberVO;


/**
 * 
 * @Class Name :INoUserDaoJoin.java
 * @Description : 비회원 회원가입dao
 * @Modification Information
 * @author 
 * @since  2018. 11. 12.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일             수정자             수정내용
 *    -------        -------     -------------------
 *    2018. 11. 12.     진형용             최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
public interface INoUserDaoJoin {
	/**
	 * 
	 *  개요 : 해당 회원정보 있는지 확인
	 * @Method Name : getMemberInfo
	 * @author : Administrator
	 * -----------------------------------
	 * @param : 
	 * @return : MemberVO
	 * @throws :
	 */
	public MemberVO getMemberInfo(Map<String,String>params) throws Exception;
	/**
	 * 
	 *  개요 : 회원가입
	 * @Method Name : insertMember
	 * @author : Administrator
	 * -----------------------------------
	 * @param : 
	 * @return : boolean
	 * @throws :
	 */
	public boolean insertMember(MemberVO member) throws Exception;
}
