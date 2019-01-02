package com.ai.fishdr.listener;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;











import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ai.fishdr.vo.MemberVO;
import com.ai.fishdr.vo.StatsVO;
public class SessionListener implements HttpSessionListener{
	
	@Override
	public void sessionCreated(HttpSessionEvent event) {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		HttpServletRequest request = attr.getRequest();
		StatsVO vo = new StatsVO();
		vo.setConect_ip(request.getRemoteAddr());
		vo.setConect_environment(request.getHeader("User-Agent"));
		HttpSession session = event.getSession();
		session.setAttribute("visitorInfo", vo);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		HttpSession session = event.getSession();
		MemberVO mem = (MemberVO) session.getAttribute("LOGIN_MEMBER");
		if (mem!=null) {
			String mem_id = mem.getMem_id();
			for (int i = 0; i < SessionLoginListener.memList.size(); i++) {
				if(SessionLoginListener.memList.get(i).getMem_id()==mem_id){
					SessionLoginListener.memList.remove(i);
				}
			}
		}
		System.out.println("session terminated"+event.getSession().getId()); 
	}

}
