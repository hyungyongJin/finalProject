package com.ai.fishdr.utils;


import javax.servlet.http.HttpServletRequest;
/**
 * @Class Name :RoleCommentPagingUtil.java
 * @Description : 게시글 내 댓글 페이징 처리 유틸
 * @Modification Information
 * @author 진형용
 * @since  2018. 12. 3.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일             수정자             수정내용
 *    -------        -------     -------------------
 *    2018. 12. 3.     진형용             최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
public class RoleCommentPagingUtil {

	private int commentPage; //현재 페이지 번호
	private int totalCount; //전체 게시글 갯수
	private int totalPage;  
	private int blockCount = 30; //한페이징 출력할 게시글 갯수
	private int blockPage = 5;  //페이지별 출력될 페이지네이션 메뉴 갯수
	private int startPage;	  //출력되는 페이지네이션 메뉴의 시작페이지번호
	private int endPage;	  //출력되는 페이지네이션 메뉴의 마지막페이지번호
	private int startCount;  //해당 페이지에 출력되는 게시글의 시작번호
	private int endCount;  //해당 페이지에 출력되는 게시글의 마지막번호
	private StringBuffer pagingHtmls;  //작성된 페이지네이션 컨텐츠 저장소
	private HttpServletRequest request;
	private String bo_no;
	private String currentPage;
	private String keyword;
	private String search;
	public RoleCommentPagingUtil(int commentPage, int totalCount,
			HttpServletRequest request, String bo_no,String currnetPage, String keyword,String search) {
		this.commentPage = commentPage;
		this.totalCount = totalCount;
		this.request = request;
		this.bo_no=bo_no;
		this.currentPage=currnetPage;
		this.keyword=keyword;
		this.search=search;
		pagingHtmls = new StringBuffer();
		
		makePagingHtmls();
	}

	

	private void makePagingHtmls() {
		//총 페이지의 갯수
//		this.totalPage = (int)Math.ceil(this.totalCount/(double)this.blockCount);
//		if (this.totalPage==0) {
//			this.totalPage=1;
//		}
		this.totalPage = totalCount/blockCount;
		if (totalCount% blockCount >0) {
			totalPage++;
		}
		//페이지당 출력될 게시글의 시작 글번호, 마지막 글번호
	//	startCount = totalCount - (commentPage-1)*blockCount;
	//	endCount = startCount-blockCount+1;
		startCount = (commentPage-1)*blockCount+1;
		endCount = startCount+blockCount-1;
		if (endCount> totalCount) {
			endCount = totalCount;
		}
		//이전 |1|2|3|4|5| 다음
		//시작페이지네이션 메뉴의 시작 페이지번호, 마지막 페이지 번호
		startPage = ((commentPage -1)/blockPage*blockPage)+1;
		endPage = startPage+blockPage -1;
		if (endPage> totalPage) {
			endPage = totalPage;
		}
		pagingHtmls.append("<div class='dataTables_paginate paging_simple_numbers' id='example1_paginate'>");
		pagingHtmls.append("<ul class='pagination'>");
		
		String requestURI = request.getRequestURI();
		
		//이전 <-만들기
		if ((commentPage-1)!=0) {
			pagingHtmls.append("<li><a href='"+requestURI+"?commentPage="+(commentPage-1)+"&bo_no="+bo_no+"&currentPage="+currentPage+"&search="+search+"&keyword="+keyword+"'>이전</a></li>");
		}
		
		//|1|2|3|4|5|
		for (int i = startPage; i <= endPage; i++) {
			if(commentPage == i ){
				pagingHtmls.append("<li class='active'><a href='#'>"+ i +"</a></li>");
			}else{
				pagingHtmls.append("<li><a href='"+requestURI+"?commentPage="+i+"&bo_no="+bo_no+"&currentPage="+currentPage+"&search="+search+"&keyword="+keyword+"'>"+i+"</a></li>");
			}
		}
		//다음
		if (commentPage<totalPage) {
			pagingHtmls.append("<li><a href='"+requestURI+"?commentPage="+(commentPage+1)+"&bo_no="+bo_no+"&currentPage="+currentPage+"&search="+search+"&keyword="+keyword+"'>다음</a></li>");
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
