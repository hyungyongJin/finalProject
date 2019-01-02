package com.ai.fishdr.admin.serivce.whthDrawal;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ai.fishdr.admin.dao.withDrawal.IWithDrawalDao;
import com.ai.fishdr.vo.WithdrawalVO;

@Service
public class IWithDrawalServiceImpl implements IWithDrawalService{
	
	@Resource
	private IWithDrawalDao dao;

	
	@Transactional
	@Override
	public List<WithdrawalVO> getWithDrawalList(Map<String, String> parmas)
			throws Exception {
		return dao.getWithDrawalList(parmas);
	}


	@Override
	public int getTotalCount(Map<String, String> parmas) throws Exception {
		return dao.getTotalCount(parmas);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public Object getWithDrawalUpdate(WithdrawalVO vo)
			throws Exception {
		return dao.getWithDrawalUpdate(vo);
	}

	@Transactional
	@Override
	public WithdrawalVO getWithDrawalInfo(Map<String, String> parma)
			throws Exception {
		return dao.getWithDrawalInfo(parma);
	}


	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public String withDrawalInsert(WithdrawalVO vo) throws Exception {
		return dao.withDrawalInsert(vo);
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public int withDrawalDelete(Map<String, String> parmas) throws Exception {
		return dao.withDrawalDelete(parmas);
	}

	@Transactional
	@Override
	public WithdrawalVO withCheck(Map<String, String> params) throws Exception {

		return dao.withCheck(params);
	}

	
	@Transactional(readOnly=true)
	@Override
	public WithdrawalVO getWithInfo(Map<String, String> params)
			throws Exception {
		return dao.getWithInfo(params);
	}
	
}
