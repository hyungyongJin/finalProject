<%@ page language="JAVA" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
/* .content-wrapper{background-image:url("${pageContext.request.contextPath}/dist/img/photo2.png"); } */

#aside{
/*  	background-color:red;  */

}
</style>
</head>
<script type = "text/javascript">

	$(function() {
		
		$('#goFishgram').click(function() {
		
			$(location).attr('href','${pageContext.request.contextPath}/user/fishgram/fishgramMeMain.do');
			
		});
		
	});
	function goModal(value){
		var x = (screen.availWidth - 500) / 2;
		var y = (screen.availHeight - 400) / 2;
		var info = encodeURIComponent(value);
		var url = "${pageContext.request.contextPath }/user/freeboard/messageModal.do?id="+info;
		var options = "width = 500, height = 400, scrollbars = no left="+x+", top="+y;
		window.open(url, "쪽지보내기", options);
			
	}
	var num =0;
	function goChatModal(value){
		num += 1;
		var x = (screen.availWidth - 500) / 2;
		var y = (screen.availHeight - 650) / 2;
		var info = encodeURIComponent(value);
		var id = value.substring(value.indexOf('(')+1, value.lastIndexOf(')'));
		var array = new Array();
		array.push('/call/'+id);
		array.push('${LOGIN_MEMBER.mem_id}');
		ws.send(array);
		var url = "${pageContext.request.contextPath }/user/freeboard/chatModal.do?id="+info;
		var options = "width = 500, height = 650,  scrollbars = no left="+x+", top="+y;
		window.open(url, "채팅하기"+num, options);
		
	}
</script>
<body>
	<!-- Left side column. contains the logo and sidebar -->
	<div class="content-wrapper" >
		<aside  id="aside" class="main-sidebar">
			<!-- sidebar: style can be found in sidebar.less -->
			<section class="sidebar">
				<!-- Sidebar user panel -->
				<div   class="user-panel">
					<div class="pull-left image">
						

						<!-- 프로필 사진이 등록되어 있지 않은 경우 -->
<%-- 						<c:if test="${params.profile_status eq 'n'}"> --%>
						<c:if test="${LOGIN_MEMBER.profile_status eq 'n'}">

							<img
								src="${pageContext.request.contextPath }/dist/img/person_icon.png"
								class="img-circle" alt="User Image" id="goFishgram"
								style="width: 45px; height: 45px;">

						</c:if>


						<!-- 프로필 사진이 등록되어 있는 경우 -->
<%-- 						<c:if test="${params.profile_status eq 'y'}"> --%>
						<c:if test="${LOGIN_MEMBER.profile_status eq 'y'}">

							<img src="/image/${FILE_SAVE_NAME}"
								alt="User profile picture" class="img-circle" alt="User Image"
								id="goFishgram" style="width: 45px; height: 45px;">
						</c:if>









					</div>
					<div class="pull-left info">
						<p>${LOGIN_MEMBER.mem_nickname }</p>
						<a
							href="${pageContext.request.contextPath}/user/fishgram/fishgramMeMain.do"><i
							class="fa fa-circle text-success"></i>피쉬그램 방문</a>
					</div>
				</div>

				<!-- /.search form -->
				<!-- sidebar menu: : style can be found in sidebar.less -->
				<ul class="sidebar-menu" data-widget="tree">
					<c:if test="${empty LOGIN_MEMBER}">
						<li>
							<a href="${pageContext.request.contextPath }/user/noticeboard/noticeboardList.do">
								<i class="fa fa-info"></i> <span>공지사항</span>
							</a>
						</li>
					</c:if>
					<c:if test="${!empty LOGIN_MEMBER}">
						<li><a
							href="${pageContext.request.contextPath }/user/noticeboard/noticeboardList.do">
								<i class="fa fa-info"></i> <span>공지사항</span>
						</a></li>
						<li class="treeview"><a href="#"> <i
								class="fa fa-newspaper-o"></i> <span>게시판</span> <span
								class="pull-right-container"> <i
									class="fa fa-angle-left pull-right"></i>
							</span>
						</a>
							<ul class="treeview-menu">
									<c:forEach items="${BOARD_INFO }" var="list" begin="1">
										<c:if test="${list.board_code != 'board004'}">
											<li><a
												href="${pageContext.request.contextPath }/user/${list.board_eng_name }/${list.board_eng_name }List.do?board_code=${list.board_code}"><i
													class="fa fa-circle-o"></i>${list.board_name }</a></li>
										</c:if>
									</c:forEach>
							</ul></li>
						<!--         이거쓰기 -->
						<li class="treeview"><a href="#"> <i class="fa fa-user"></i>
								<span>회원전용페이지</span> <span class="pull-right-container">
									<i class="fa fa-angle-left pull-right"></i>
							</span>
						</a>
							<ul class="treeview-menu">
								<%--           	<c:forEach items="${게시판 디비 정보 a }" var="a"> --%>
								<li><a
									href="${pageContext.request.contextPath }/user/member/memberUpdateView.do"><i
										class="fa fa-circle-o"></i>회원정보수정</a></li>
<!-- 								<li><a -->
<%-- 									href="${pageContext.request.contextPath }/pages/tables/data.html"><i --%>
<!-- 										class="fa fa-circle-o"></i> 회원탈퇴</a></li> -->
								<li><a
									href="${pageContext.request.contextPath }/user/prescriptionManagement/prescriptionManagementList.do"><i
										class="fa fa-circle-o"></i> 처방내역관리</a></li>
								<li><a
									href="${pageContext.request.contextPath }/user/message/messageList.do"><i
										class="fa fa-circle-o"></i> 쪽지함</a></li>
								<%--           	</c:forEach> --%>
							</ul></li>

						<li class="treeview"><a href="#"> <i class="fa fa-medkit"></i>
								<span>의약품 서비스</span> <span class="pull-right-container">
									<i class="fa fa-angle-left pull-right"></i>
							</span>
						</a>
							<ul class="treeview-menu">
								<li><a
									href="${pageContext.request.contextPath }/user/mdcin/mdcinList.do"><i
										class="fa fa-circle-o"></i> 의약품 검색</a></li>
								<li><a
									href="${pageContext.request.contextPath }/user/aiDoctor/aiDoctor.do"><i
										class="fa fa-circle-o"></i> A.I 처방</a></li>
							</ul></li>

						<li><a
							href="${pageContext.request.contextPath }/user/aiService/aiService.do">
								<i class="fa fa-user-md"></i> <span>A.I 응답 서비스</span>
						</a></li>
						<li><a
							href="${pageContext.request.contextPath }/user/fishDiss/fishDiss.do">
								<i class="fa fa-fw fa-plus-square"></i> <span>어류 질병 정보</span>
						</a></li>
						
						<li><a
							href="${pageContext.request.contextPath }/user/hospital/hospitalService.do">
								<i class="fa fa-fw fa-map"></i> <span>질병관리원 위치 확인</span>
						</a></li>
					
					<br><br><br><br><br><br><br><br><br><br>
					<div style=" height: 250px; overflow-y: auto;">
						<table>
						<thead>
							<tr>
								<td><a style="text-decoration: underline;">접속중인 회원</a>
								</td>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${ON_MEMBER}" var="list">
							<tr>
								<td>
								<div class="dropdown">
								&nbsp;&nbsp;<a href="#" class="dropdown-toggle" data-toggle="dropdown">${list.mem_nickname }&nbsp;<img src="https://cafe.pstatic.net/levelicon/1/1_1.gif" width="11" height="11"></a>
									<ul class="dropdown-menu">
										<c:if test="${LOGIN_MEMBER.mem_id != list.mem_id }">
										<li><a href="#"><span onclick="goChatModal('${list.mem_nickname }(${list.mem_id})');">1:1 채팅하기</span></a></li>
										<li><a href="#"><span onclick="goModal('${list.mem_nickname }(${list.mem_id})');">쪽지보내기</span></a></li>
										</c:if>
										<li><a href="${pageContext.request.contextPath }/user/fishgram/fishgramYouList.do?mem_id=${list.mem_id}">블로그가기</a></li>
									</ul>
								</div>
								</td>
							</tr>
						</c:forEach>
						
						</tbody>
						</table>
						
					</div>
					</c:if>
					
				</ul>
			</section>
			<!-- /.sidebar -->
			
		</aside>
</body>
</html>  	
    	