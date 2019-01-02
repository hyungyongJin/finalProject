<%--==============================================================
 * jsp 개요 : 
 * @author : 
 * @since : 2018. 11. 13.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일                          수정자                       수정내용
 *    -------      -------     -------------------
 *    2018. 11. 13.        임범학
형용                      최초작성
 * Copyright (c) 2018 AI Fish Dr. All right reserved
 * </pre>
===============================================================--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<body>
<div class="content-wrapper" style="margin-left:10px;">
	<!-- Main content -->
	<section class="content" style="width:100%;">
		<div class="row">
			<div class="col-md-12">

				<!-- 위 html 지우지 말 것  -->






				<div class="box">
					<div class="box-header">
						<h3 class="box-title">
							이미지게시판 
						</h3>

					</div>
					<!-- /.box-header -->

					<!-- Post -->
					<div class="post">

						<!-- /.user-block -->
						<div class="row margin-bottom">
							<c:set var="i" value="0" />
							<c:set var="j" value="5" />
							<table  style="margin-left: 100px; ">
								<c:choose>
									<c:when
										test="${imageboardList !=null && fn:length(imageboardList) >0 }">
										<c:forEach items="${imageboardList }" var="list">
											<c:if test="{i%j == 0}">
												<tr>
											</c:if>
											<td style="width:350px"><img class="imageUP" onerror="this.src='${pageContext.request.contextPath }/images/noimage.png'"
												src="/image/${list.FILE_SAVE_NAME}" 
												style="width:80%; margin-right: 10px;  height:150px;"><br> <br> 
												<input type="hidden" value="${list.BO_NO}">
												<input type="hidden" value="${list.FILE_SAVE_NAME}">
												제목 : 
												<a href="${pageContext.request.contextPath}/user/imageboard/imageboardView.do?bo_no=${list.BO_NO }&currentPage=${currentPage}
													&search=${search}&keyword=${keyword}"><span style="color: red">
													${list.BO_TITLE }</span></a>
<!-- 												제목 : -->
<%-- 												${list.BO_TITLE }  --%>
												<br>
												작성자 : ${list.MEM_NICKNAME } 
												<br>
												조회수:
												${list.BO_HIT } 
												<br>
												${list.BO_REG_DATE }
											</td>

											<c:if test="${i%j == j-1}">
												</tr>
											</c:if>
											<c:set var="i" value="${i+1 }"></c:set>
										</c:forEach>
									</c:when>
								</c:choose>
							</table>
						</div>
						<!-- /.row -->
					</div>
					
					<div style="margin-left:42%">
						${pagingHtmls }
					</div>
								 
						
					<!-- /.post -->

					<form
						action="${pageContext.request.contextPath }/user/imageboard/imageboardList.do"
						method="post">
						<select name="search" class="form-control" 
							style="width: 20%; float: left; margin-left:12%; margin-right: 15px;">
							<option value="TOTAL">전체</option>
							<option value="TITLE">제목</option>
							<option value="CONTENT">내용</option>
							<option value="WRITER">작성자</option>
						</select>
						<input name="keyword" type="search"
							style="width: 30%; float: left; margin-right: 15px;"
							class="form-control input-md" placeholder="검색어를 입력하세요..">
						<button id="searchBtn" class="btn btn-primary btn-md" style="float: left; margin-bottom:3%;"
							type="submit">검색</button>
					</form>

					<button type="button" id="insertBtn" style="width: 140px; margin-bottom:3%; margin-left:15%;"
						class="btn btn-info btn-sm" 
						>게시글 등록</button>


					<!--           <button type="button"  style="width:140px;" class="btn btn-info btn-sm" data-toggle="modal" data-target="#myModal">삭제</button> -->
					<!--           <button type="button"  style="width:140px;" class="btn btn-info btn-sm" data-toggle="modal" data-target="#myModal">목록</button> -->



				</div>

				<!-- 아래 html 건들지 말것 -->
			</div>
			<!-- /.col-->

		</div>
		<!-- ./row -->
	</section>
	<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->
</body>
<script type="text/javascript">
$(function(){	
	
	
	//자바스크립트 코딩
// 	$('table tr td')
// 			.click(
// 					function() {
// 						if (eval('${!empty LOGIN_MEMBER }')) {
// 							var bo_no = $(this).find('input:eq(0)').val();
// 							var search = '${param.search}';
// 							var keyword = encodeURIComponent('${param.keyword}');
// 							$(location).attr(
// 									'href',
// 									'${pageContext.request.contextPath}/user/imageboard/imageboardView.do?bo_no='
// 											+ bo_no + '&search='
// 											+ search + '&keyword='
// 											+ keyword 
// 											+ '&currentPage=${currentPage}');
// 						} else {
// 							BootstrapDialog.show({
// 								title : '알림!',
// 								message : '로그인 후에 이용해주세요!'
// 							});
// 						}
// 					});
	
	
	

	$('#insertBtn').on(
			'click',
			function() {
				if (eval('${!empty LOGIN_MEMBER }')) {
					var bo_no = $(this).find('input:eq()').val();
					$(location).attr(
							'href',
							'${pageContext.request.contextPath}/user/imageboard/imageboardForm.do?currentPage=${currentPage}'+'&board_code=board003');
				} else {
					BootstrapDialog.show({
						title : '알림!',
						message : '로그인 후에 이용해주세요!'
					});
				}
			});
});	
</script>