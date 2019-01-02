package com.ai.fishdr.mail;

import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.fishdr.nouser.service.member.IMemberService;
import com.ai.fishdr.vo.MemberVO;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/* 

 <dependency>
 <groupId>javax.mail</groupId>
 <artifactId>mail</artifactId>
 <version>1.4.7</version>
 </dependency>
 */
@Controller
@RequestMapping("/mail/")
public class MailController {
	@Autowired
	private IMemberService memberService;

	@RequestMapping("send")
	public ModelAndView send(HttpSession sessionMail, String emailtext,
			ModelAndView model, Map<String, String> params, String nametext,
			String idtext) throws Exception {
		String host = "smtp.naver.com";
		final String user = "limbh070@naver.com";
		final String password = "goaqjrj";
		String to = emailtext;
		String c = "";
		if (emailtext != null) {
			params.put("mem_mail", emailtext);
		}
		if (nametext != null) {
			params.put("mem_name", nametext);
		}
		if (idtext != null) {
			params.put("mem_id", idtext);
		}

		MemberVO memInfo = memberService.memberInfo(params);

		if (memInfo != null) {
			// Get the session object
			Properties props = new Properties();
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.auth", "true");

			Session session = Session.getDefaultInstance(props,
					new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(user, password);
						}
					});

			// Compose the message
			try {
				MimeMessage message = new MimeMessage(session);
				message.setFrom(new InternetAddress(user));
				message.addRecipient(Message.RecipientType.TO,
						new InternetAddress(to));

				// 메일제목
				message.setSubject("이메일로 인증번호가 발송되었습니다. 인증번호 입력창에 입력해주세요. ");

				Random r = new Random();
				int[] arr = new int[2];
				for (int i = 0; i < 2; i++) {
					arr[i] += r.nextInt(10);
				}
				String d = arr.toString();
				c = d.substring(3, 9);

				// 메일 내용
				// sessionMail.setAttribute("sendMail", arr);
				message.setText("인증코드 : " + c);

				// send the message
				Transport.send(message);

			} catch (MessagingException e) {
				e.printStackTrace();
			}
		}

		model.addObject("memInfo", memInfo);
		model.addObject("code", c);
		model.setViewName("jsonConvertView");
		return model;

	}

	@RequestMapping("insertMail")
	public ModelAndView insertMail(HttpSession sessionMail, String emailtext,
			ModelAndView model, Map<String, String> params) throws Exception {
		String host = "smtp.naver.com";
		final String user = "limbh070@naver.com";
		final String password = "goaqjrj";
		String to = emailtext;
		String c = "";

		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(user, password);
					}
				});

		// Compose the message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));


			// 메일제목
			message.setSubject("이메일로 인증번호가 발송되었습니다. 인증번호를 입력창에 입력해주세요. ");

			Random r = new Random();
			int[] arr = new int[2];
			for (int i = 0; i < 2; i++) {
				arr[i] += r.nextInt(10);
			}
			String d = arr.toString();
			c = d.substring(3, 9);

			// 메일 내용
			// sessionMail.setAttribute("sendMail", arr);
			message.setText("인증코드 : " + c);

			// send the message
			Transport.send(message);

		} catch (MessagingException e) {
			e.printStackTrace();
		}

		model.addObject("code", c);
		model.setViewName("jsonConvertView");
		return model;
	}

	@RequestMapping("IDconfirm")
	public ModelAndView IDconfirm(String emailtext, String nametext,
			ModelAndView model, Map<String, String> params) throws Exception {
		params.put("mem_mail", emailtext);
		if (nametext != null) {
			params.put("mem_name", nametext);
		}
		MemberVO mem = memberService.getMemid(params);
		String memid = null;
		if (mem != null) {
			memid = mem.getMem_id();
		}
		model.addObject("mem", memid);

		model.setViewName("jsonConvertView");

		return model;

	}

	@RequestMapping("PWDconfirm")
	public ModelAndView PWDconfirm(String emailtext, String nametext,
			String idtext, ModelAndView model, Map<String, String> params)
			throws Exception {
		if (nametext != null) {
			params.put("mem_name", nametext);
		}
		if (emailtext != null) {
			params.put("mem_mail", emailtext);
		}
		params.put("mem_id", idtext);
		MemberVO mem = memberService.getMempwd(params);
		String mempwd = mem.getMem_pwd();
		model.addObject("mem", mempwd);

		model.setViewName("jsonConvertView");

		return model;

	}

}