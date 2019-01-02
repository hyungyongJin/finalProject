package com.ai.fishdr.nouser.service.member;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang.exception.NestableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ai.fishdr.nouser.dao.member.IMemberDao;
import com.ai.fishdr.vo.MemberVO;
import com.ai.fishdr.vo.SecessionVO;
import com.ai.fishdr.vo.SttemntVO;
// <bean id="IMemberServiceImpl" class = "kr.or.ddit.service.member.IMemberServiceImpl"/>
@Service
public class IMemberServiceImpl implements IMemberService{
	@Autowired
	private IMemberDao dao;
	
//	@Resource
//	private IMemberService service;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW, readOnly=true, rollbackFor={RuntimeException.class, SQLException.class, NestableException.class})
	@Override
	public MemberVO memberInfo(Map<String, String> params) 
			throws Exception{
		
		return dao.memberInfo(params);
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=true)
	@Override
	public List<MemberVO> memberList(Map<String, String> params ) 
				throws Exception{
		
		return dao.memberList(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW, rollbackFor=(Exception.class))
	@Override
	public int insertMemberInfo(MemberVO memberInfo) throws Exception {
		Object result = dao.insertMemberInfo(memberInfo);
		int count = 0;
		if (result == null) {
			count = 1;
		}
		return count;
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW, rollbackFor=(Exception.class))
	@Override
	public int deleteMemberInfo(String mem_id) throws Exception{
			return dao.deleteMemberInfo(mem_id);
	}
	
	
	
	/**
	 * 프로필 사진 등록 여부 'y' 로 변경 관련 오버라이딩
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public void changeProfileStatusY(Map<String, String> params) throws Exception {

		dao.changeProfileStatusY(params);
		
	}

	
	/**
	 * 닉네임 검색 메뉴에서 입력한 문자를 포함하는 닉네임을 가진 회원 검색 관련 오버라이딩
	 */
	@Transactional(readOnly=true)
	@Override
	public List<MemberVO> searchNickname(Map<String, String> params) throws Exception {

		return dao.searchNickname(params);
		
	}

	
	/**
	 * 닉네임 검색 메뉴에서 검색된 회원의 수 계산 관련 트랜잭션 및 오버라이딩
	 */
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public int totalsearchNicknameCount(Map<String, String> params) throws Exception {

		return dao.totalsearchNicknameCount(params);
		
	}

	
	/**
	 * 닉네임 검색 메뉴에서 선택한 닉네임의 정보 가져오기 관련 오버라이딩
	 */
	@Override
	public MemberVO getSelectNicknameInfo(Map<String, String> params) throws Exception {

		return dao.getSelectNicknameInfo(params);
		
	}

	
	/**
	 * 특정 게시판에서 특정 닉네임 선택 후 블로그 가기 버튼을 눌렀을 때 해당 닉네임의 회원 정보 가져오기
	 */
	@Override
	public MemberVO getSelectIdInfo(Map<String, String> params) throws Exception {

		return dao.getSelectIdInfo(params);
		
	}

	/**
	 * 아이디찾기
	 */
	@Override
	public MemberVO getMemid(Map<String, String> params) throws Exception {
		return dao.getMemid(params);
	}
	
	/**
	 * 비밀번호찾기
	 */
	@Override
	public MemberVO getMempwd(Map<String, String> params) throws Exception{
		return dao.getMempwd(params);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW, rollbackFor=(Exception.class))
	@Override
	public int updateMemberInfo(MemberVO memberInfo) throws Exception{
			return dao.updateMemberInfo(memberInfo);
	}

	
	/**
	 * 특정 아이디의 프로필 사진 등록 여부 값 가져오기 관련 오버라이딩
	 */
	@Override
	public String getProfileStatus(String mem_id) throws Exception {

		return dao.getProfileStatus(mem_id);
		
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW, rollbackFor=(Exception.class))
	@Override
	public String insertSecession(SecessionVO ssVO) throws Exception {
		return dao.insertSecession(ssVO);
	}

	@Override
	public boolean emailCheck(String mem_mail) throws Exception {
		boolean boo = false;
		String mail=dao.emailCheck(mem_mail);
		if (mail != null) {
			boo = true;
		}
		return boo;
	}

}
