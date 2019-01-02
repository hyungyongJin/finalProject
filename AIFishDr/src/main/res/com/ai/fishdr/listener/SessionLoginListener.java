package com.ai.fishdr.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.ai.fishdr.vo.MemberVO;

/**
 * @Class Name :SessionLoginListener.java
 * @Description : 회원 접속시 활용할 세션리스너
 * @Modification Information
 * @author 진형용
 * @since  2018. 11. 30.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일             수정자             수정내용
 *    -------        -------     -------------------
 *    2018. 11. 30.     진형용             최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
public class SessionLoginListener implements HttpSessionAttributeListener {

	public static List<MemberVO> memList = new ArrayList<MemberVO>();
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		HttpSession session =  event.getSession();
		MemberVO mem =(MemberVO) session.getAttribute("LOGIN_MEMBER");
		if (mem != null) {
			if (memList.size()!=0) {
				for (int i = 0; i < memList.size(); i++) {
					String mem_id = memList.get(i).getMem_id();
					if (mem_id.intern() == mem.getMem_id().intern()) {
						memList.remove(i);
					}
				}
				memList.add(mem);
				return;
			}
			memList.add(mem);
		}
		session.setAttribute("ON_MEMBER", memList);
		System.out.println(memList.size());
		System.out.println(event.getName()+" : session added :"+session.getId());
	}
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		HttpSession session = event.getSession();
		System.out.println(event.getName()+ ":  session removed : "+session.getId());
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		HttpSession session = event.getSession();
		System.out.println(event.getName()+ " : session replaced : "+session.getId());
	}

}
