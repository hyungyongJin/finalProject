package com.ai.fishdr.nouser.dao.member;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ai.fishdr.vo.MemberVO;
import com.ai.fishdr.vo.SecessionVO;
import com.ibatis.sqlmap.client.SqlMapClient;

// <bean name="iMemberDaoImpl" class ="kr.or.ddit.dao.member.IMemberDaoImpl"/>
@Repository("memberDao")
public class IMemberDaoImpl implements IMemberDao{
	
	@Resource
	private SqlMapClient client;
	

	@Override
	public MemberVO memberInfo(Map<String, String> params) throws SQLException {
		return (MemberVO) client.queryForObject("member.memberInfo", params);
	}

	@Override
	public List<MemberVO> memberList(Map<String, String> params ) throws SQLException {
		return client.queryForList("member.memberList", params);
	}

	@Override
	public Object insertMemberInfo(MemberVO memberInfo) throws SQLException {
		 return client.insert("member.insertMemberInfo", memberInfo);
	}

	@Override
	public int deleteMemberInfo(String mem_id)
			throws Exception {
		return client.update("member.deleteMemberInfo", mem_id);
	}


	
	/**
	 * 프로필 사진 등록 여부 'y' 로 변경 관련 오버라이딩
	 */
	@Override
	public void changeProfileStatusY(Map<String, String> params) throws SQLException {
		
		client.update("member.changeProfileStatusY", params);
		
	}

	
	/**
	 * 닉네임 검색 메뉴에서 입력한 문자를 포함하는 닉네임을 가진 회원 검색 관련 오버라이딩
	 */
	@Override
	public List<MemberVO> searchNickname(Map<String, String> params) throws SQLException {

		return client.queryForList("member.searchNickname", params);
		
	}

	/**
	 * 닉네임 검색 메뉴에서 검색된 회원의 수 계산 관련 오버라이딩
	 */
	@Override
	public int totalsearchNicknameCount(Map<String, String> params) throws SQLException {

		return (int) client.queryForObject("member.totalsearchNicknameCount", params);
		
	}

	
	/**
	 * 닉네임 검색 메뉴에서 선택한 닉네임의 정보 가져오기 관련 오버라이딩
	 */
	@Override
	public MemberVO getSelectNicknameInfo(Map<String, String> params) throws SQLException {

		return (MemberVO) client.queryForObject("member.getSelectNicknameInfo", params);
		
	}

	
	/**
	 * 특정 게시판에서 특정 닉네임 선택 후 블로그 가기 버튼을 눌렀을 때 해당 닉네임의 회원 정보 가져오기
	 */
	@Override
	public MemberVO getSelectIdInfo(Map<String, String> params) throws SQLException {

		return  (MemberVO) client.queryForObject("member.getSelectIdInfo", params);
		
	}
	/**
	 * 아이디찾기
	 */
	@Override
	public MemberVO getMemid(Map<String, String> params) throws SQLException{
		return (MemberVO) client.queryForObject("member.getMemid", params);
	}
	/**
	 * 비밀번호찾기
	 */
	@Override
	public MemberVO getMempwd(Map<String, String> params) throws SQLException{
		return (MemberVO) client.queryForObject("member.getMempwd", params);
	}



	@Override
	public int updateMemberInfo(MemberVO memberInfo) throws Exception {
		// update 쿼리
		// create(table, sequence, view ... n)
		return client.update("member.updateMemberInfo", memberInfo);
	}

	
	/**
	 * 특정 아이디의 프로필 사진 등록 여부 값 가져오기 관련 오버라이딩
	 */
	@Override
	public String getProfileStatus(String mem_id) throws Exception {

		return (String) client.queryForObject("member.getProfileStatus", mem_id);
		
	}

	@Override
	public String insertSecession(SecessionVO ssVO) throws Exception {
		return (String) client.insert("member.insertSecession", ssVO);
	}

	@Override
	public String emailCheck(String mem_mail) throws Exception {
		return  (String) client.queryForObject("member.emailCheck", mem_mail);
	}

	
}
