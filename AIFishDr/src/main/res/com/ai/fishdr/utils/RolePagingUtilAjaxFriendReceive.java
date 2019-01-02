package com.ai.fishdr.utils;


import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

public class RolePagingUtilAjaxFriendReceive {

	private int currentPage; //현재 페이지 번호
	private int totalCount; //전체 게시글 갯수
	private int totalPage;  
	private int blockCount = 5; //한페이징 출력할 게시글 갯수
	private int blockPage = 5;  //페이지별 출력될 페이지네이션 메뉴 갯수
	private int startPage;	  //출력되는 페이지네이션 메뉴의 시작페이지번호
	private int endPage;	  //출력되는 페이지네이션 메뉴의 마지막페이지번호
	private int startCount;  //해당 페이지에 출력되는 게시글의 시작번호
	private int endCount;  //해당 페이지에 출력되는 게시글의 마지막번호
	private StringBuffer pagingHtmls;  //작성된 페이지네이션 컨텐츠 저장소
	private HttpServletRequest request;
	
	
	public RolePagingUtilAjaxFriendReceive(int currentPage, int totalCount,
			HttpServletRequest request) {
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.request = request;
		
		pagingHtmls = new StringBuffer();
		
		makePagingHtmls();
	}

	

	private void makePagingHtmls() {
		//총 페이지의 갯수
		this.totalPage = (int)Math.ceil(this.totalCount/(double)this.blockCount);
		if (this.totalPage==0) {
			this.totalPage=1;
		}
		//페이지당 출력될 게시글의 시작 글번호, 마지막 글번호
		startCount = ((currentPage - 1) * blockCount) + 1;
		endCount = ((currentPage - 1) * blockCount) + blockCount;
		
		if (startCount < 0) {
			
			startCount = 1;
			
		}
	
		
		//이전 |1|2|3|4|5| 다음
		//시작페이지네이션 메뉴의 시작 페이지번호, 마지막 페이지 번호
		startPage = ((currentPage -1)/blockPage*blockPage)+1;
		endPage = startPage+blockPage -1;
		if (endPage> totalPage) {
			endPage = totalPage;
		}
		//currentPage, search_keycode, search_keyworkd
		String params = "";
		Enumeration<String> paramKeys = request.getParameterNames();
		while (paramKeys.hasMoreElements()) {
			String key = (String) paramKeys.nextElement();
			if ("currentPage".intern() !=key.intern()) {
				String value = request.getParameter(key);
				if ("keyword".intern() == key.intern()) {
					try {
						value = URLEncoder.encode(value, "UTF-8");
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
				params +=key+"="+value +"&";
			}
		} 
		
		pagingHtmls.append("<div class='dataTables_paginate paging_simple_numbers' id='example2_paginate'>");
		pagingHtmls.append("<ul class='pagination'>");
		
		String requestURI = request.getRequestURI();
		
		//이전 <-만들기
		if ((currentPage-1)!=0) {
			pagingHtmls.append("<li><a href='javascript:ajaxReceiveFriendApply(" + (currentPage - 1) + ");'>이전</a></li>");
		}
		
		//|1|2|3|4|5|
		for (int i = startPage; i <= endPage; i++) {
			if(currentPage == i ){
				pagingHtmls.append("<li class='active'><a href='#'>"+ i +"</a></li>");
			}else{
				pagingHtmls.append("<li><a href='javascript:ajaxReceiveFriendApply(" + i + ");'>" + i + "</a></li>");
			}
		}
		//다음
		if (currentPage<totalPage) {
			pagingHtmls.append("<li><a href='javascript:ajaxReceiveFriendApply(" + (currentPage + 1) + ");'>다음</a></li>");
		}else{
		}
		pagingHtmls.append("</div></ul>");
		
		
	}

	public int getStartCount() {
		return startCount;
	}


	public int getEndCount() {
		return endCount;
	}


	public StringBuffer getPagingHtmls() {
		return pagingHtmls;
	}


	
	
	
	
}
