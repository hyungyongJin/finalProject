package com.ai.fishdr.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ai.fishdr.vo.MemberVO;

public class LoginFilter implements Filter {
	private List<String> list = null;

	public LoginFilter() {
		list = new ArrayList<String>();
		list.add("/AIFishDr/main.do");
		list.add("/AIFishDr/nouser/join/loginForm.do");
		list.add("/AIFishDr/nouser/join/loginCheck.do");
		list.add("/AIFishDr/nouser/insertMember/insertMemberForm.do");
		list.add("/AIFishDr/naver/login.do");
		list.add("/AIFishDr/user/noticeboard/noticeboardList.do");
		list.add("/AIFishDr/user/noticeboard/noticeboardView.do");
		list.add("/AIFishDr/nouser/noticeboard/noticeList.do");
		list.add("/AIFishDr/user/noticeboard/noticeList.do");
		list.add("/AIFishDr/naver/callback.do");
		list.add("/AIFishDr/naver/naverLoginCheck.do");
		list.add("/AIFishDr/nouser/idCheck.do");
		list.add("/AIFishDr/nouser/nickNameCheck.do");
		list.add("/AIFishDr/mail/send.do");
		list.add("/AIFishDr/mail/IDconfirm.do");
		list.add("/AIFishDr/mail/PWDconfirm.do");
		list.add("/AIFishDr/nouser/join/insertMember.do");
		list.add("/AIFishDr/nouser/join/logOut.do");
		list.add("/AIFishDr/admin/board/insertBoard.do");
		list.add("/AIFishDr/admin/board/boardList.do");
		list.add("/AIFishDr/admin/board/insertBoard.do");
		list.add("/AIFishDr/admin/board/boardCheck.do");
		list.add("/AIFishDr/mail/insertMail.do");
	}

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String uri = request.getRequestURI();
		HttpSession session = request.getSession(true);
		if (!list.contains(uri)) {
			MemberVO member = (MemberVO) session.getAttribute("LOGIN_MEMBER");
			if (member == null) {
				PrintWriter out = response.getWriter();
				response.setContentType("text/html; charset=UTF-8");
				out.println("<script>alert('로그인이 필요한 서비스입니다.'); location.href='/AIFishDr/main.do';</script>");
				out.flush();
				return;
			}

		}
		chain.doFilter(servletRequest, servletResponse);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
