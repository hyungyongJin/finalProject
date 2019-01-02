package com.ai.fishdr.nouser.service.join;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ai.fishdr.nouser.dao.join.INoUserDaoJoin;
import com.ai.fishdr.vo.MemberVO;
@Service
public class INoUserJoinServiceImpl implements INoUserJoinService {
	
	@Autowired
	private INoUserDaoJoin dao;
	
	@Transactional(readOnly=true)
	@Override
	public MemberVO getMemberInfo(Map<String, String> params) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public boolean insertMember(MemberVO member) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
}
