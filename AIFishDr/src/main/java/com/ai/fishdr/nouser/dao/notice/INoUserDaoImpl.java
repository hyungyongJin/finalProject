package com.ai.fishdr.nouser.dao.notice;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ai.fishdr.vo.BoardVO;
import com.ai.fishdr.vo.SttemntVO;
import com.ibatis.sqlmap.client.SqlMapClient;

	@Repository
	public class INoUserDaoImpl implements INoUserDao {
	@Autowired
	private SqlMapClient smc;

	
	@Override
	public List<Map<String, BoardVO>> getNoticeList(Map<String, String> params)
			throws Exception {
		return smc.queryForList("noticeboard.getNoticeList",params);
	}

	@Override
	public Map<String, Object> getNoticeInfo(Map<String, String> params)
			throws Exception {
		return  (Map<String, Object>) smc.queryForObject("noticeboard.getNoticeInfo",params);
	}

	@Override
	public int getTotalCount(Map<String, String> params) throws Exception {
		return (int) smc.queryForObject("noticeboard.getTotalCount",params);
	}

	@Override
	public void updateHit(Map<String, String> params) throws Exception {
		smc.update("noticeboard.updateHit",params);
	}

	
	@Override
	public int updateGoodHit(String bo_no) throws Exception {
		return smc.update("noticeboard.updateGoodHit",bo_no);
	}


	
}
