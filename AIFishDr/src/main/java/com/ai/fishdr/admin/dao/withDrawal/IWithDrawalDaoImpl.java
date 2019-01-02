package com.ai.fishdr.admin.dao.withDrawal;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ai.fishdr.vo.WithdrawalVO;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class IWithDrawalDaoImpl implements IWithDrawalDao{
	
	@Autowired
	private SqlMapClient smc;

	@Override
	public List<WithdrawalVO> getWithDrawalList(Map<String, String> params)
			throws Exception {
		return smc.queryForList("withdrawal.getWithDrawalList", params);
	}

	@Override
	public int getTotalCount(Map<String, String> parmas) throws Exception {
		return (int) smc.queryForObject("withdrawal.getTotalCount", parmas);
	}

	@Override
	public Object getWithDrawalUpdate(WithdrawalVO vo)
			throws Exception {
		return smc.update("withdrawal.getWithDrawalUpdate", vo);
	}

	@Override
	public WithdrawalVO getWithDrawalInfo(Map<String, String> params)
			throws Exception {
		return (WithdrawalVO) smc.queryForObject("withdrawal.getWithDrawalInfo", params);
	}

	@Override
	public String withDrawalInsert(WithdrawalVO vo) throws Exception {
		return (String) smc.insert("withdrawal.withDrawalInsert", vo);
	}

	@Override
	public int withDrawalDelete(Map<String, String> parmas) throws Exception {
		return smc.update("withdrawal.withDrawalDelete", parmas);
	}

	@Override
	public WithdrawalVO withCheck(Map<String, String> params) throws Exception {
		return (WithdrawalVO) smc.queryForObject("withdrawal.withCheck", params);
	}

	@Override
	public WithdrawalVO getWithInfo(Map<String, String> params)
			throws Exception {
		return (WithdrawalVO) smc.queryForObject("withdrawal.getWithInfo", params);
	}
}
