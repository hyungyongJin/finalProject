package com.ai.fishdr.admin.serivce.member;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ai.fishdr.admin.dao.member.IMemberDaoMgr;
import com.ai.fishdr.vo.MemberVO;
import com.ai.fishdr.vo.MessageVO;

@Service
public class IMemberMgrServiceImpl implements IMemberMgrService {
	@Autowired
	private IMemberDaoMgr dao;

	@Override
	public List<MemberVO> getMemberList(Map<String, String> params)
			throws Exception {
		return dao.getMemberList(params);
	}

	@Override
	public int getMemberCnt(Map<String, String> params) throws Exception {
		return dao.getMemberCnt(params);
	}

	@Override
	public int getBlackMemberCnt(Map<String, String> params) throws Exception {
		return dao.getBlackMemberCnt(params);
	}

	@Override
	public List<Map<String, MemberVO>> getBlackMemberList(
			Map<String, String> params) throws Exception {
		return dao.getBlackMemberList(params);
	}

	@Override
	public int getSecMemberCnt(Map<String, String> params) throws Exception {
		return dao.getSecMemberCnt(params);
	}

	@Override
	public List<Map<String, MemberVO>> getSecMemberList(
			Map<String, String> params) throws Exception {
		return dao.getSecMemberList(params);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public boolean deleteMember(String[] id) throws Exception {
		boolean result = true;
		int cnt = 0;
		for (String string : id) {
			cnt += dao.deleteMember(string);
		}
		if (cnt==id.length) {
			result = true;
		}
		return result;
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public boolean warningMsg(MessageVO vo) throws Exception {
		boolean result = false;
		String chk = dao.warningMsg(vo);
		if (chk!= null||chk=="".intern()) {
			result = true;
		}
		return result;
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public boolean updateSttemnt(String mem_id) throws Exception {
		boolean result = false;
		int cnt = dao.updateSttemnt(mem_id);
		if (cnt>0) {
			result = true;
		}
		return result;
	}

	@Override
	public List<Map<String, Object>> getMemsSttBoard(String mem_id)
			throws Exception {
		return dao.getMemsSttBoard(mem_id);
	}

	@Override
	public List<MemberVO> allMemberForExcel() throws Exception {
		return dao.allMemberForExcel();
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public boolean backMemStt(List<String> forStt) throws Exception {
		boolean result = false;
		int cnt = dao.backMemStt(forStt);
		if (cnt>0) {
			result =true;
		}
		return result;
	}

	
	
	
	
	
	
	
	
	@Override
	public int getMsgCheck(String mem_id) throws Exception {
		return dao.getMsgCheck(mem_id);
	}
}
