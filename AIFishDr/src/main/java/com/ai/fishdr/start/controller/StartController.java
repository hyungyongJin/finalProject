package com.ai.fishdr.start.controller;


import java.io.Serializable;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.fishdr.admin.serivce.board.IBoardService;
import com.ai.fishdr.admin.serivce.stats.IStatsService;
import com.ai.fishdr.user.service.facepicture.IFacePictureService;
import com.ai.fishdr.vo.BoardManageVO;
import com.ai.fishdr.vo.MemberVO;
import com.ai.fishdr.vo.StatsVO;

@Controller
public class StartController implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private IStatsService statsService;
	@Autowired
	private IBoardService boardService;//layout left에 뿌려줄 게시판 서비스
	
	@Autowired
	private IFacePictureService facePictureService;
	
	@RequestMapping("main")
	public ModelAndView main(ModelAndView mav, HttpSession session, String message, String profileStatus, String fp_file_save_name, Map<String, String> params, String loginStatus) throws Exception {
		
		// 로그인을 하지 않았을 경우 (비회원)는 위 과정을 거치지 않는다.
		
		
		List<BoardManageVO> boardList = boardService.getBoardList();
		
		session.setAttribute("BOARD_INFO", boardList);
		
		StatsVO vo =  (StatsVO) session.getAttribute("visitorInfo");
		
		if (vo!=null) {
			
			statsService.insertVisitorCount(vo);
			
		}
		
		if(message!=null){
			
			message = URLEncoder.encode(message,"UTF-8");
			
			params.put("message", message);
			
		}
		
//		RedirectView redirectView = new RedirectView();
//		
//		redirectView.setUrl("http://localhost/AIFishDr/user/noticeboard/noticeList.do?params=" + params);
//		
//		redirectView.setExposeModelAttributes(false);
//		
//		mav.setView(redirectView);
		
		mav.setViewName("forward:/user/noticeboard/noticeList.do");
		
		return mav;
		
//		if (message != null) {
//		
//			return "forward:/user/noticeboard/noticeList.do?message="+message + "&profileStatus=" + profileStatus + "&fp_file_save_name=" + fp_file_save_name;
//			
//		} else {
//			
//			
//			return "forward:/user/noticeboard/noticeList.do?profileStatus=" + profileStatus + "&fp_file_save_name=" + fp_file_save_name;
			
	}
	
}