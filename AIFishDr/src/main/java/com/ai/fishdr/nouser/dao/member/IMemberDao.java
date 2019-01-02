package com.ai.fishdr.nouser.dao.member;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ai.fishdr.vo.MemberVO;
import com.ai.fishdr.vo.SecessionVO;
import com.ai.fishdr.vo.SttemntVO;

public interface IMemberDao {

	public MemberVO memberInfo(Map<String, String> params) throws SQLException;
	
	public List<MemberVO> memberList(Map<String, String> params ) throws SQLException;
	
	public Object insertMemberInfo(MemberVO memberInfo) throws SQLException;
	
	
	
	
	/**
	 * 
	 *    의미 : 회원탈퇴신청
	 * @Method : deleteMemberInfo
	 * @author : 임범학
	 * -----------------------------------
	 * @param  : String mem_id
	 * @return : boolean
	 * @throws : Exception
	 */
	public int deleteMemberInfo(String mem_id) throws Exception;
	
	
	
	/**
	 * 
	 *    의미 : 프로필 사진 등록 여부 'y' 로 수정하기
	 * @Method : changeProfileStatusY
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : fishgram (FishgramVO 타입)
	 * @return : boolean
	 * @throws : Exception
	 */
	public void changeProfileStatusY(Map<String, String> params) throws SQLException;
	
	
	/**
	 * 
	 *    의미 : 닉네임 검색 메뉴에서 입력한 문자를 포함하는 닉네임을 가진 회원 검색
	 * @Method : searchNickname
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : param (Map<String, String> 타입)
	 * @return : List<MemberVO>
	 * @throws : Exception
	 */
	public List<MemberVO> searchNickname(Map<String, String> params) throws SQLException;
	
	
	/**
	 * 
	 *    의미 : 닉네임 검색 메뉴에서 검색된 회원의 수 계산
	 * @Method : searchNickname
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : param (Map<String, String> 타입)
	 * @return : List<MemberVO>
	 * @throws : Exception
	 */
	public int totalsearchNicknameCount(Map<String, String> params) throws SQLException;
	
	
	/**
	 * 
	 *    의미 : 닉네임 검색 메뉴에서 선택한 닉네임의 정보 가져오기
	 * @Method : getSelectNicknameInfo
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : MemberVO
	 * @throws : Exception
	 */
	public MemberVO getSelectNicknameInfo(Map<String, String> params) throws SQLException;
	
	
	/**
	 * 
	 *    의미 : 특정 게시판에서 특정 닉네임 선택 후 블로그 가기 버튼을 눌렀을 때 해당 닉네임의 회원 정보 가져오기
	 * @Method : getSelectIdInfo
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * @return : MemberVO
	 * @throws : Exception
	 */
	public MemberVO getSelectIdInfo(Map<String, String> params) throws SQLException;
	/**
	 * 
	 *    의미 : 아이디찾기
	 * @Method : getMemid
	 * @author : 유재훈
	 * -----------------------------------
	 * @param  : String emailtext
	 * @return : MemberVO
	 * @throws : Exception
	 */
	public MemberVO getMemid(Map<String, String> params)throws SQLException;
	/**
	 * 
	 *    의미 : 비밀번호찾기
	 * @Method : getMempwd
	 * @author : 유재훈
	 * -----------------------------------
	 * @param  : Map<String, String> params
	 * @return : MemberVO
	 * @throws : Exception
	 */
	public MemberVO getMempwd(Map<String, String> params) throws SQLException;
	
	/**
	 * 
	 *    의미 : 회원 수정 하기
	 * @Method : updateMemberInfo
	 * @author : 임범학
	 * -----------------------------------
	 * @param  : MemberVO (MemberVO 타입)
	 * @return : void
	 * @throws : Exception
	 */
	public int updateMemberInfo(MemberVO memberInfo) throws Exception;
	
	
	/**
	 * 
	 *    의미 : 특정 아이디의 프로필 사진 등록 여부 값 가져오기
	 * @Method : getProfileStatus
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : MemberVO (MemberVO 타입)
	 * @return : void
	 * @throws : Exception
	 */
	public String getProfileStatus(String mem_id) throws Exception;
	
	public String insertSecession(SecessionVO ssVO) throws Exception;

	
	/**
	 * 
	 *    의미 : 이메일 중복확인
	 * @Method : emailCheck
	 * @author : 임범학
	 * -----------------------------------
	 * @param  : String mem_mail
	 * @return : int
	 * @throws : Exception
	 */
	public String emailCheck(String mem_mail) throws Exception;
}
