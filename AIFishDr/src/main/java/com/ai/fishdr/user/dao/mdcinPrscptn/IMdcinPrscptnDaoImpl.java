package com.ai.fishdr.user.dao.mdcinPrscptn;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ai.fishdr.vo.MdcinPrscrptnVO;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class IMdcinPrscptnDaoImpl implements IMdcinPrscptnDao {
	
	@Autowired
	private SqlMapClient smc;

	@Override
	public void mdcinPrscrptnInsert(Map<String, String> params)
			throws Exception {
		smc.insert("mdcinPrscrptn.mdcinPrscrptnInsert", params);
	}

	@Override
	public MdcinPrscrptnVO getMdcinCode(String prscrptn_code)
			throws Exception {
		return (MdcinPrscrptnVO) smc.queryForObject("mdcinPrscrptn.getMdcinCode", prscrptn_code);
	}
}
