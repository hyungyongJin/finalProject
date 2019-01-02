package com.ai.fishdr.admin.serivce.stats;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ai.fishdr.admin.dao.stats.IStatsDao;
import com.ai.fishdr.vo.BoardVO;
import com.ai.fishdr.vo.MedicineVO;
import com.ai.fishdr.vo.SecessionVO;
import com.ai.fishdr.vo.StatsVO;

@Service
public class IStatsServiceImpl implements IStatsService {
	@Autowired
	private IStatsDao dao;
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public void insertVisitorCount(StatsVO vo) throws Exception {
		dao.insertVisitorCount(vo);
	}
	@Override
	public Map<String, StatsVO> getVisitorCount() throws Exception {
		return dao.getVisitorCount();
	}
	@Override
	public List<Object> getEachBoardCount(List<String> board_code)
			throws Exception {
		List<Object> countList = new ArrayList<Object>();
		for (int i = 0; i < board_code.size(); i++) {
			countList.add(dao.getEachBoardCount(board_code.get(i)));
		}
		return countList;
	}
	@Override
	public Map<String, Object> getMemberIncreaseRatio() throws Exception {
		return dao.getMemberIncreaseRatio();
	}
	@Override
	public List<Map<String, BoardVO>> getFamousWriteList() throws Exception {
		return dao.getFamousWriteList();
	}
	@Override
	public List<MedicineVO> getFamouseMdcin() throws Exception {
		return dao.getFamouseMdcin();
	}
	@Override
	public Map<String, SecessionVO> getSecReason() throws Exception {
		return dao.getSecReason();
	}
	@Override
	public int getMdcinCnt() throws Exception {
		return dao.getMdcinCnt();
	}
	@Override
	public String getTotalStorage() throws Exception {
		return dao.getTotalStorage();
	}
	@Override
	public int getTotalPrsCnt() throws Exception {
		return dao.getTotalPrsCnt();
	}
	@Override
	public List<Map<String, String>> getFishInfo() throws Exception {
		return dao.getFishInfo();
	}

}
