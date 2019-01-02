package com.ai.fishdr.admin.dao.stats;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ai.fishdr.vo.BoardVO;
import com.ai.fishdr.vo.MedicineVO;
import com.ai.fishdr.vo.SecessionVO;
import com.ai.fishdr.vo.StatsVO;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class IStatsDaoImpl implements IStatsDao {
	@Autowired
	private SqlMapClient smc;

	@Override
	public void insertVisitorCount(StatsVO vo) throws Exception {
		smc.insert("stats.insertVisitorCount",vo);
	}
	
	public Map<String,StatsVO> getVisitorCount() throws Exception{
		return (Map<String, StatsVO>) smc.queryForObject("stats.getVisitorCount");
		
	}
	@Override
	public Map<String, Object> getEachBoardCount(String board_code)
			throws Exception {
		return (Map<String, Object>) smc.queryForObject("stats.getEachBoardCount",board_code);
	}

	@Override
	public Map<String, Object> getMemberIncreaseRatio() throws Exception {
		return (Map<String, Object>) smc.queryForObject("stats.getMemberIncreaseRatio");
	}

	@Override
	public List<Map<String, BoardVO>> getFamousWriteList() throws Exception {
		return smc.queryForList("stats.getFamousWriteList");
	}

	@Override
	public List<MedicineVO> getFamouseMdcin() throws Exception {
		return smc.queryForList("stats.getFamouseMdcin");
	}

	@Override
	public Map<String, SecessionVO> getSecReason() throws Exception {
		return (Map<String, SecessionVO>) smc.queryForObject("stats.getSecReason");
	}

	@Override
	public int getMdcinCnt() throws Exception {
		return (int) smc.queryForObject("stats.getMdcinCnt");
	}

	@Override
	public String getTotalStorage() throws Exception {
		return (String) smc.queryForObject("stats.getTotalStorage");
	}

	@Override
	public int getTotalPrsCnt() throws Exception {
		return (int) smc.queryForObject("stats.getTotalPrsCnt");
	}

	@Override
	public List<Map<String, String>> getFishInfo() throws Exception {
		return smc.queryForList("stats.getFishInfo");
	}
}
