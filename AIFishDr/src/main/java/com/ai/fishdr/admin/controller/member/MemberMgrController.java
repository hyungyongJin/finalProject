package com.ai.fishdr.admin.controller.member;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.fishdr.admin.serivce.member.IMemberMgrService;
import com.ai.fishdr.admin.serivce.stats.IStatsService;
import com.ai.fishdr.user.service.prescription.IPrescriptionService;
import com.ai.fishdr.utils.RolePagingUtilAjax;
import com.ai.fishdr.utils.RolePagingUtilFishgramComment;
import com.ai.fishdr.vo.MemberVO;
import com.ai.fishdr.vo.SecessionVO;

/**
 * @Class Name :MemberMgrController.java
 * @Description : 관리자 회원관리 컨트롤러
 * @Modification Information
 * @author 진형용
 * @since 2018. 11. 26.
 * @version 1.0
 * @see <pre>
 * << 개정이력(Modification Information) >>
 *    수정일             수정자             수정내용
 *    -------        -------     -------------------
 *    2018. 11. 26.     진형용             최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
@Controller
@RequestMapping("/admin/member/")
public class MemberMgrController {
	@Autowired
	private IMemberMgrService service;
	@Autowired
	private IStatsService statService;
	@Autowired
	private IPrescriptionService prService;
	/**
	 * 개요 : 일반회원 정보관리
	 * 
	 * @Method Name : getMemberList
	 * @author : 진형용 -----------------------------------
	 * @param :
	 * @return : ModelAndView
	 * @throws Exception
	 * @throws :
	 */
	@RequestMapping("memberMgr")
	public ModelAndView getMemberList(ModelAndView model,
			Map<String, String> params, String commentCurrentPage,
			String search, String keyword, HttpServletRequest request,
			String asc, String desc, String cnt) throws Exception {
		if (commentCurrentPage == null || commentCurrentPage == "".intern()) {
			commentCurrentPage = "1";
		}
		params.put("search", search);
		params.put("keyword", keyword);
		params.put("asc", asc);
		params.put("desc", desc);
		int totalCount = service.getMemberCnt(params);
		request.setAttribute("cnt", cnt);
		RolePagingUtilFishgramComment page = new RolePagingUtilFishgramComment(
				Integer.parseInt(commentCurrentPage), totalCount, request);
		params.put("endCount", String.valueOf(page.getEndCount()));
		params.put("startCount", String.valueOf(page.getStartCount()));
		List<MemberVO> memList = service.getMemberList(params);

		model.addObject("memList", memList);
		model.addObject("paging", page.getPagingHtmls());
		return model;
	}

	/**
	 * 개요 : 메일받을 회원들 체크하여 정리
	 * 
	 * @Method Name : chkMail
	 * @author : 진형용 -----------------------------------
	 * @param :
	 * @return : ModelAndView
	 * @throws :
	 */
	@RequestMapping("chkMail")
	public ModelAndView chkMail(ModelAndView model, String mail) {
		String[] nick = mail.split(",");
		List<String> receiver = new ArrayList<String>();
		for (int i = 0; i < nick.length; i++) {
			receiver.add(nick[i].split("/")[1]);
		}
		model.addObject(receiver);
		model.setViewName("jsonConvertView");
		return model;
	}

	/**
	 * 개요 : 회원에게 이메일 전송메서드
	 * 
	 * @Method Name : sendEmail
	 * @author : 진형용 -----------------------------------
	 * @param :
	 * @return : ModelAndView
	 * @throws MessagingException
	 * @throws :
	 */
	@RequestMapping("sendEmail")
	public ModelAndView sendEmail(ModelAndView model, String email_title,
			String email_content, String receiver) throws MessagingException {
		String host = "smtp.naver.com";
		final String user = "limbh070@naver.com";
		final String password = "goaqjrj";
		String[] to = receiver.split(",");
		for (String string : to) {
			String toWhom = string;

			Properties props = new Properties();
			props.setProperty("mail.transport.protocol", "smtp");
			props.setProperty("mail.host", host);
			props.setProperty("mail.user", user);
			props.setProperty("mail.password", password);
			props.setProperty("mail.smtp.auth", "true");

			Session mailSession = Session.getDefaultInstance(props,
					new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(user, password);
						}
					});
			mailSession.setDebug(true);
			Transport transport = mailSession.getTransport();
		    MimeMessage message = new MimeMessage(mailSession);
			message.setSubject(email_title);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					toWhom));

			MimeMultipart multipart = new MimeMultipart("related");

			BodyPart messageBodyPart = new MimeBodyPart();
			//String htmlText = "<img src=\"cid:my-image\">";
			messageBodyPart.setContent(email_content, "text/html; charset=UTF-8");

			multipart.addBodyPart(messageBodyPart);
			messageBodyPart = new MimeBodyPart();
			
			DataSource fds = new FileDataSource("D:\\temp\\car1.jpg");
			messageBodyPart.setDataHandler(new DataHandler(fds));
			messageBodyPart.setHeader("Content-ID", "<my-image>");

			multipart.addBodyPart(messageBodyPart);

			// put everything together
			message.setContent(multipart);

			transport.connect();
			transport.sendMessage(message,
					message.getRecipients(Message.RecipientType.TO));
			transport.close();
		}
		model.addObject("cnt",to);
		model.setViewName("jsonConvertView");
		return model;
	}

	/**
	 * 개요 : 탈퇴신청회원관리
	 * 
	 * @Method Name : getSecMemberList
	 * @author : 진형용 -----------------------------------
	 * @param :
	 * @return : ModelAndView
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping("secMemberMgr")
	public ModelAndView getSecMemberList(ModelAndView model,
			Map<String, String> params, String commentCurrentPage,
			String search, String keyword, HttpServletRequest request,
			String asc, String desc, String cnt) throws Exception {
		if (commentCurrentPage == null || commentCurrentPage == "".intern()) {
			commentCurrentPage = "1";
		}
		params.put("search", search);
		params.put("keyword", keyword);
		params.put("asc", asc);
		params.put("desc", desc);
		int totalCount = service.getSecMemberCnt(params);
		request.setAttribute("cnt", cnt);
		RolePagingUtilFishgramComment page = new RolePagingUtilFishgramComment(
				Integer.parseInt(commentCurrentPage), totalCount, request);
		params.put("endCount", String.valueOf(page.getEndCount()));
		params.put("startCount", String.valueOf(page.getStartCount()));
		List<Map<String, MemberVO>> memList = service.getSecMemberList(params);
		Map<String,SecessionVO> secStat =  statService.getSecReason();
		model.addObject("secStat",secStat);
		model.addObject("memList", memList);
		model.addObject("paging", page.getPagingHtmls());
		return model;
	}
	/**
	 *  개요 : 회원 탈퇴처리
	 * @Method Name : delSecMember
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws :
	 */
	@RequestMapping("delSecMember")
	public ModelAndView delSecMember(ModelAndView model, String mem_id) throws Exception{
		String[] id = mem_id.split(",");
		boolean result = service.deleteMember(id);
		model.addObject("result",result);
		model.setViewName("jsonConvertView");
		return model;
	}

	/**
	 * 개요 : 블랙리스트 회원관리
	 * 
	 * @Method Name : getBlackMemberList
	 * @author : 진형용 -----------------------------------
	 * @param :
	 * @return : ModelAndView
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping("blackMemberMgr")
	public ModelAndView getBlackMemberList(ModelAndView model,
			Map<String, String> params, String commentCurrentPage,
			String search, String keyword, HttpServletRequest request,
			String asc, String desc, String cnt,String sttAsc,String sttDesc) throws Exception {
		if (commentCurrentPage == null || commentCurrentPage == "".intern()) {
			commentCurrentPage = "1";
		}
		params.put("search", search);
		params.put("keyword", keyword);
		params.put("asc", asc);
		params.put("desc", desc);
		params.put("sttAsc", sttAsc);
		params.put("sttDesc", sttDesc);
		int totalCount = service.getBlackMemberCnt(params);
		request.setAttribute("cnt", cnt);
		RolePagingUtilFishgramComment page = new RolePagingUtilFishgramComment(
				Integer.parseInt(commentCurrentPage), totalCount, request);
		params.put("endCount", String.valueOf(page.getEndCount()));
		params.put("startCount", String.valueOf(page.getStartCount()));
		List<Map<String, MemberVO>> memList = service.getBlackMemberList(params);

		model.addObject("memList", memList);
		model.addObject("paging", page.getPagingHtmls());
		return model;
	}
	/**
	 *  개요 : 회원리스트 엑셀다운로드
	 * @Method Name : downloadExcel
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping("downloadExcel")
	public ModelAndView downloadExcel(ModelAndView model,
			Map<String, String> params, String commentCurrentPage,
			String search, String keyword, HttpServletRequest request,
			String asc, String desc, String cnt,String chk) throws Exception{
		if (chk!=null) {
			List<MemberVO> memList = service.allMemberForExcel();
			model.addObject("list", memList);
		}else{
			if (commentCurrentPage == null || commentCurrentPage == "".intern()) {
				commentCurrentPage = "1";
			}
			params.put("search", search);
			params.put("keyword", keyword);
			params.put("asc", asc);
			params.put("desc", desc);
			int totalCount = service.getMemberCnt(params);
			request.setAttribute("cnt", cnt);
			RolePagingUtilFishgramComment page = new RolePagingUtilFishgramComment(
					Integer.parseInt(commentCurrentPage), totalCount, request);
			params.put("endCount", String.valueOf(page.getEndCount()));
			params.put("startCount", String.valueOf(page.getStartCount()));
			List<MemberVO> memList = service.getMemberList(params);
			model.addObject("list", memList);
		}
		model.setViewName("downloadExcel");
		return model;
	}
	/**
	 *  개요 : 블랙리스트 회원이 작성, 신고받은 게시글리스트
	 * @Method Name : getblackSttList
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping("getblackSttList")
	public ModelAndView getblackSttList(ModelAndView model, String mem_id) throws Exception{
		List<Map<String,Object>> sttList = service.getMemsSttBoard(mem_id);
		model.addObject("sttList", sttList);
		model.setViewName("jsonConvertView");
		return model;
	}
	/**
	 *  개요 : 블랙리스트 회원 초기화
	 * @Method Name : changeMemStt
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping("changeMemStt")
	public ModelAndView changeMemStt(ModelAndView model, String mem_id) throws Exception{
		List<String>forStt = new ArrayList<String>();
		String[] Stt = mem_id.split(",");
		for (int i = 0; i < Stt.length; i++) {
			forStt.add(Stt[i]);
		}
		boolean result = service.backMemStt(forStt);
		model.addObject("result",result);
		model.setViewName("jsonConvertView");
		return model;
		
	}
	/**
	 *  개요 : 쪽지 수 카운트하여 쪽지 알림기능
	 * @Method Name : checkMsg
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws :
	 */
	@RequestMapping("checkMsg")
	public ModelAndView checkMsg(ModelAndView model, String mem_id) throws Exception{
		int cnt = service.getMsgCheck(mem_id);
		model.addObject("cnt",cnt);
		model.setViewName("jsonConvertView");
		
		return model;
	}
	/**
	 *  개요 : 회원의 의약품 처방내역 가져오는 메서드
	 * @Method Name : chkPrscrptn
	 * @author : 진형용
	 * -----------------------------------
	 * @param : params
	 * @return : ModelAndView
	 * @throws :
	 */
	@RequestMapping("chkPrscrptn")
	public ModelAndView chkPrscrptn(String currentPage ,ModelAndView model, Map<String,String>params,String mem_id
			,HttpServletRequest request) throws Exception{
		params.put("mem_id", mem_id);
		if (currentPage==null) {
			currentPage="1";
		}
		int totalCount = prService.totalMemsPrsCnt(params);
		RolePagingUtilAjax page = new RolePagingUtilAjax(Integer.parseInt(currentPage), totalCount, request);
		params.put("startCount", String.valueOf(page.getStartCount()));
		params.put("endCount", String.valueOf(page.getEndCount()));
		List<Map<String, Object>> data = prService.getMemsPrscrptnInfo(params);
		model.addObject("pagenation",page.getPagingHtmls());
		model.addObject("result",data);
		model.setViewName("jsonConvertView");
		
		return model;
	}
	
	
	
	
	
	
}
