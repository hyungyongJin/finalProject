package com.ai.fishdr.user.dao.freeboard;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ai.fishdr.vo.BoardVO;
import com.ai.fishdr.vo.SttemntVO;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class IFreeboardDaoImpl implements IFreeboardDao{
	@Autowired
	private SqlMapClient smc;

	@Override
	public String insertBoard(BoardVO vo) throws Exception {
		return (String) smc.insert("freeboard.insertBoard",vo);
	}

	@Override
	public int updateBoard(BoardVO vo) throws Exception {
		return smc.update("freeboard.updateBoard",vo);
	}

	@Override
	public int deleteBoard(Map<String, String> params) throws Exception {
		return smc.delete("freeboard.deleteBoard",params);
	}

	@Override
	public List<Map<String, BoardVO>> getBoardList(Map<String, String> params)
			throws Exception {
		return smc.queryForList("freeboard.getBoardList",params);
	}

	@Override
	public Map<String, Object> boardInfo(Map<String, String> params)
			throws Exception {
		return  (Map<String, Object>) smc.queryForObject("freeboard.getBoardInfo",params);
	}

	@Override
	public int getTotalCount(Map<String, String> params) throws Exception {
		return (int) smc.queryForObject("freeboard.getTotalCount",params);
	}

	@Override
	public void updateHit(Map<String, String> params) throws Exception {
		smc.update("freeboard.updateHit",params);
	}

	@Override
	public int updateGoodHit(String bo_no) throws Exception {
		return smc.update("freeboard.updateGoodHit",bo_no);
	}

	@Override
	public Object insertBadHit(SttemntVO vo) throws Exception {
		return smc.insert("freeboard.insertBadHit",vo);
	}

	@Override
	public int getBlack(Map<String, String> params) throws Exception {
		return (int) smc.queryForObject("freeboard.getBlack",params);
	}

	@Override
	public List<Map<String, BoardVO>> getAdminWriteList() throws Exception {
		return smc.queryForList("freeboard.getAdminWriteList");
	}

	
}
