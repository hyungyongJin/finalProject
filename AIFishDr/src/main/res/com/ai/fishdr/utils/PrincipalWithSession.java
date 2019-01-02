package com.ai.fishdr.utils;

import java.security.Principal;

import javax.servlet.http.HttpSession;

public class PrincipalWithSession implements Principal {
	private final HttpSession session;
	
	public  PrincipalWithSession(HttpSession session){
		this.session = session;
	}

	public HttpSession getSession() {
		return session;
	}
	
	@Override
	public String getName() {
		//세션의 아이디
		return this.session.getId();
	}

}
