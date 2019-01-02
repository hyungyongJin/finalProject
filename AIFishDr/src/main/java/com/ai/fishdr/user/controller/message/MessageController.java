package com.ai.fishdr.user.controller.message;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.fishdr.listener.SessionLoginListener;
import com.ai.fishdr.user.service.facepicture.IFacePictureService;
import com.ai.fishdr.user.service.friend.IFriendService;
import com.ai.fishdr.user.service.mesageroom.IMessageRoomService;
import com.ai.fishdr.utils.RolePagingUtilFishgramComment;
import com.ai.fishdr.vo.FriendVO;
import com.ai.fishdr.vo.MemberVO;
import com.ai.fishdr.vo.MessageVO;
/**
 * @Class Name :MessageController.java
 * @Description : 쪽지 컨트롤러
 * @Modification Information
 * @author 진형용
 * @since  2018. 11. 28.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일             수정자             수정내용
 *    -------        -------     -------------------
 *    2018. 11. 28.     진형용             최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
@Controller
@RequestMapping("/user/message/")
public class MessageController {
	@Autowired
	private IMessageRoomService service;
	@Autowired
	private IFriendService frService;
	
	@Autowired
	private IFacePictureService facePictureService;
	
	/**
	 *  개요 : 받은쪽지 리스트
	 * @Method Name : messageList
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping("messageList")
	public ModelAndView	receiveMessageList(ModelAndView model,HttpSession session,Map<String,String>params,
			String commentCurrentPage,String asc, String desc,HttpServletRequest request,String cnt) throws Exception{
		
		
		String mem_id = ((MemberVO)session.getAttribute("LOGIN_MEMBER")).getMem_id();
		params.put("mem_id", mem_id);
		
		if (commentCurrentPage == null || commentCurrentPage == "".intern()) {
			commentCurrentPage = "1";
		}
		request.setAttribute("cnt", cnt);
		int totalCount = service.totalReceiveMsgCount(mem_id);
		RolePagingUtilFishgramComment page = new RolePagingUtilFishgramComment(
				Integer.parseInt(commentCurrentPage), totalCount, request);
		params.put("endCount", String.valueOf(page.getEndCount()));
		params.put("startCount", String.valueOf(page.getStartCount()));
		
		List<Map<String,MessageVO>> msgList = service.receiveMessageList(params);
		model.addObject("msgList", msgList);
		model.addObject("paging", page.getPagingHtmls());
		
		return model;
	}
	/**
	 *  개요 : 보낸 쪽지 리스트
	 * @Method Name : sendMessageList
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping("sendMessageList")
	public ModelAndView	sendMessageList(ModelAndView model,HttpSession session,Map<String,String>params,
			String commentCurrentPage,String asc, String desc,HttpServletRequest request,String cnt) throws Exception{
		
		String mem_id = ((MemberVO)session.getAttribute("LOGIN_MEMBER")).getMem_id();
		params.put("mem_id", mem_id);
		
		if (commentCurrentPage == null || commentCurrentPage == "".intern()) {
			commentCurrentPage = "1";
		}
		request.setAttribute("cnt", cnt);
		int totalCount = service.totalSendMsgCount(mem_id);
		RolePagingUtilFishgramComment page = new RolePagingUtilFishgramComment(
				Integer.parseInt(commentCurrentPage), totalCount, request);
		params.put("endCount", String.valueOf(page.getEndCount()));
		params.put("startCount", String.valueOf(page.getStartCount()));
		
		List<Map<String,MessageVO>> msgList = service.sendMessageList(params);
		model.addObject("msgList", msgList);
		model.addObject("paging", page.getPagingHtmls());
		
		return model;
	}
	/**
	 *  개요 : 쪽지보내기
	 * @Method Name : insertMsg
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping("sendMsg")
	public ModelAndView insertMsg (ModelAndView model, MessageVO vo) throws Exception{
		boolean result = service.insertMsg(vo);
		model.addObject("result",result);
		model.setViewName("jsonConvertView");
		return model;
	}
	/**
	 *  개요 : 받은쪽지 삭제
	 * @Method Name : delMsg
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws :
	 */
	@RequestMapping("delMsg")
	public ModelAndView delMsg(ModelAndView model,String ms_no) throws Exception{
		List<String> delList = new ArrayList<String>();
		String[] no = ms_no.split(",");
		for (String string : no) {
			delList.add(string);
		}
		boolean result =service.delMsg(delList);
		model.addObject("result",result);
		model.setViewName("jsonConvertView");
		return model;
	}
	/**
	 *  개요 : 보낸쪽지 삭제
	 * @Method Name : delSendMsg
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws :
	 */
	@RequestMapping("delSendMsg")
	public ModelAndView delSendMsg(ModelAndView model,String ms_no) throws Exception{
		List<String> delList = new ArrayList<String>();
		String[] no = ms_no.split(",");
		for (String string : no) {
			delList.add(string);
		}
		boolean result =service.delSendMsg(delList);
		model.addObject("result",result);
		model.setViewName("jsonConvertView");
		return model;
	}
	/**
	 *  개요 : 쪽지 읽은 상태로 업데이트
	 * @Method Name : checkReadMsg
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws :
	 */
	@RequestMapping("checkReadMsg")
	public ModelAndView checkReadMsg(ModelAndView model, String ms_no) throws Exception{
		boolean result = service.checkReadMsg(ms_no);
		model.addObject("result",result);
		model.setViewName("jsonConvertView");
		return model;
	}
	/**
	 *  개요 : 쪽지쓰기 / 현재 접속중인친구/ 서로 친구맺은 친구 리스트 불러오기
	 * @Method Name : sendMessage
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping("sendMessage")
	public ModelAndView sendMessage(HttpSession session, ModelAndView model,Map<String,String>params) throws Exception{
		String mem_id = ((MemberVO)session.getAttribute("LOGIN_MEMBER")).getMem_id();
		params.put("mem_id", mem_id);
		params.put("startCount", "0");
		params.put("endCount", "50");
		List<Map<String,FriendVO>> memList =  frService.searchFriend(params);
		int cnt = frService.totalSearchFriendCount(params);
		
		
		model.addObject("friendList",memList);
		return model;
	}
	/**
	 *  개요 : 친구에게 쪽지 보내기
	 * @Method Name : msgSend
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws :
	 */
	@RequestMapping("msgSend")
	public ModelAndView msgSend(ModelAndView model,String[]me_get_id,String my_id,String ms_content) throws Exception{
		MessageVO msVO;
		boolean result = false;
		for (int i = 0; i < me_get_id.length; i++) {
			msVO = new MessageVO();
			msVO.setMe_get_id(me_get_id[i]);
			msVO.setMs_content(ms_content);
			msVO.setMs_send_id(my_id);
			result = service.insertMsg(msVO);
		}
		model.addObject("result",result);
		model.setViewName("jsonConvertView");
		return model;
		
	}
}
