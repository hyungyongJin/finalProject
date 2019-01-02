package com.ai.fishdr.user.service.mdcinPrscrptn;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ai.fishdr.user.dao.mdcinPrscptn.IMdcinPrscptnDao;
import com.ai.fishdr.vo.MdcinPrscrptnVO;

@Repository
public class IMdcinPrsptnServiceImpl implements IMdcinPrscptnService {
	
	@Autowired
	private IMdcinPrscptnDao dao;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public void mdcinPrscrptnInsert(Map<String, String> params)
			throws Exception {
		dao.mdcinPrscrptnInsert(params);
	}
	
	@Transactional(readOnly=true)
	@Override
	public MdcinPrscrptnVO getMdcinCode(String prscrptn_code)
			throws Exception {
		return dao.getMdcinCode(prscrptn_code);
	}
}
