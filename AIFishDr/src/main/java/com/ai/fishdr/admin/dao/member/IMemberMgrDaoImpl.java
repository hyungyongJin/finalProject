package com.ai.fishdr.admin.dao.member;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ai.fishdr.vo.MemberVO;
import com.ai.fishdr.vo.MessageVO;
import com.ibatis.sqlmap.client.SqlMapClient;
@Repository
public class IMemberMgrDaoImpl implements IMemberDaoMgr{
	@Autowired
	private SqlMapClient smc;

	@Override
	public List<MemberVO> getMemberList(Map<String, String> params)
			throws Exception {
		return smc.queryForList("secession.getMemberList",params);
	}

	@Override
	public int getMemberCnt(Map<String, String> params) throws Exception {
		return (int) smc.queryForObject("secession.getMemberCnt",params);
	}

	@Override
	public int getBlackMemberCnt(Map<String, String> params) throws Exception {
		return (int) smc.queryForObject("secession.getBlackMemberCnt",params);
	}

	@Override
	public List<Map<String, MemberVO>> getBlackMemberList(
			Map<String, String> params) throws Exception {
		return smc.queryForList("secession.getBlackMemberList",params);
	}

	@Override
	public int getSecMemberCnt(Map<String, String> params) throws Exception {
		return (int) smc.queryForObject("secession.getSecMemberCnt",params);
	}

	@Override
	public List<Map<String, MemberVO>> getSecMemberList(
			Map<String, String> params) throws Exception {
		return smc.queryForList("secession.getSecMemberList",params);
	}

	@Override
	public int deleteMember(String string) throws Exception {
		return smc.delete("secession.deleteMember",string);
	}

	@Override
	public String warningMsg(MessageVO vo) throws Exception {
		return (String) smc.insert("message.warnMessage",vo);
	}

	@Override
	public int updateSttemnt(String mem_id) throws Exception {
		return smc.update("secession.updateSttemnt",mem_id);
	}

	@Override
	public List<Map<String, Object>> getMemsSttBoard(String mem_id)
			throws Exception {
		return smc.queryForList("secession.getMemsSttBoard",mem_id);
	}

	@Override
	public List<MemberVO> allMemberForExcel() throws Exception {
		return smc.queryForList("secession.allMemberForExcel");
	}

	@Override
	public int backMemStt(List<String> forStt) throws Exception {
		return smc.update("secession.backMemStt",forStt);
	}

	
	
	
	
	
	
	
	
	
	@Override
	public int getMsgCheck(String mem_id) throws Exception {
		return (int) smc.queryForObject("message.getMsgCheck",mem_id);
	}
}
