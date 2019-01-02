package com.ai.fishdr.nouser.dao.join;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ai.fishdr.vo.MemberVO;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class INoUserJoinDaoImpl implements INoUserDaoJoin{
	
	@Autowired
	private SqlMapClient smc;

	@Override
	public MemberVO getMemberInfo(Map<String, String> params) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertMember(MemberVO member) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
}
