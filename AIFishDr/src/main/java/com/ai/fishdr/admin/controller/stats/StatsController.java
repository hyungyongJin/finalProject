package com.ai.fishdr.admin.controller.stats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.fishdr.admin.serivce.board.IBoardService;
import com.ai.fishdr.admin.serivce.member.IMemberMgrService;
import com.ai.fishdr.admin.serivce.stats.IStatsService;
import com.ai.fishdr.vo.BoardManageVO;
import com.ai.fishdr.vo.BoardVO;
import com.ai.fishdr.vo.MedicineVO;
import com.ai.fishdr.vo.StatsVO;
/**
 * @Class Name :StatsController.java
 * @Description : 통계관리 컨트롤러
 * @Modification Information
 * @author 진형용
 * @since  2018. 11. 20.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일             수정자             수정내용
 *    -------        -------     -------------------
 *    2018. 11. 20.     진형용             최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
@Controller
@RequestMapping("/admin/stats/")
public class StatsController {
	@Autowired
	private IStatsService service;
	@Autowired
	private IBoardService boService;
	@Autowired
	private IMemberMgrService memService;
	/**
	 *  개요 : 통계 리스트 불러오는 메서드
	 * @Method Name : getStatsList
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping("statsList")
	private ModelAndView getStatsList(ModelAndView model) throws Exception{
		//방문자수
		Map<String,StatsVO> count = service.getVisitorCount();
		model.addObject("count",count);
		//게시판 이용비율
		List<BoardManageVO> boardList =  boService.getBoardList();
		List<String> board_code = new ArrayList<String>();
		for (int i = 0; i < boardList.size(); i++) {
			String fish_code = boardList.get(i).getBoard_code();
			if (fish_code.intern()!="board004".intern()) {
				board_code.add(boardList.get(i).getBoard_code());
			}
		}
		List<Object> eachCount = service.getEachBoardCount(board_code);
		model.addObject("eachBoardcount",eachCount);
		//각 주별 회원 수 증가추이
		Map<String,Object> memIncrease = service.getMemberIncreaseRatio();
		model.addObject("member",memIncrease);
		//추천받은 글중 상위10개 리스트
		List<Map<String,BoardVO>> famousList = service.getFamousWriteList();
		model.addObject("famousList",famousList);
		//의약품 검색 상위10리스트
		List<MedicineVO> mdcinList = service.getFamouseMdcin();
		model.addObject("mdcinList",mdcinList);
		//회원 수 카운트
		int memCount = memService.getMemberCnt(new HashMap<String,String>());
		model.addObject("memCount",memCount);
		//등록된 의약품 수
		int mdcineCnt = service.getMdcinCnt();
		model.addObject("mdcineCnt",mdcineCnt);
		//등록된 파일의 합계
		String storage = service.getTotalStorage();
		model.addObject("storage",storage);
		//AI를 통해 발행된 처방전 수
		int prsCnt = service.getTotalPrsCnt();
		model.addObject("prsCnt",prsCnt);
		//AI처방받은 어류의 비율
		List<Map<String,String>>fishInfo=service.getFishInfo();
		model.addObject("fishInfo",fishInfo);
		return model;
	}
	
	
}
