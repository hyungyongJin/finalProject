<%--==============================================================
 * jsp 개요 : 자신의 피쉬그램 메인화면
 * @author : 
 * @since : 2018. 11. 13.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일             수정자     수정내용
 *    --------------     ------		------------
 *    2018. 11. 13.      심재형     최초작성
 * Copyright (c) 2018 AI Fish Dr. All right reserved
 * </pre>
===============================================================--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>

	<style>
	
		@font-face { font-family: 'NanumGothic'; src: url(NanumFont_TTF_ALL/NanumGothic.ttf) format('truetype'); }
		
		.wrap {
		
			position : relative;
			display : -webkit-flex;
			display : flex;
			-webkit-justify-content : center;
			justify-content : center;
			-webkit-align-items : center;
			align-items : center;
		
		}
		
		#receiveFriendApplyTable th {
		
			vertical-align : middle !important;
		
		}
		
		#receiveFriendApplyTable td {
		
			vertical-align : middle !important;
		
		}
		
		#sendFriendApplyTable th {
		
			vertical-align : middle !important;
		
		}
		
		#sendFriendApplyTable td {
		
			vertical-align : middle !important;
		
		}
		
		#searchFriendTable th {
		
			vertical-align : middle !important;
		
		}
		
		#searchFriendTable td {
		
			vertical-align : middle !important;
		
		}
		
	</style>

<body>

<div class="content-wrapper" style="margin-left:10px;">

<!-- Main content -->
<section class="content" style = "height:822px;">

	<div class="row">
	
		<!-- 피쉬그램 게시판 영역 -->
		<div class = "col-md-12" style = "float:left; width:80%; height:822px; overflow-x:hidden; overflox-y:hidden;">
			
			<!-- 피쉬그램 게시판 박스 -->
			<div class="box box-solid box-info" id = "fishgramDiary" style = "height:802px;">
			
				<div class="box-header"></div>
				
				<div class="box-body">
				
					<div id="example1_wrapper" class="dataTables_wrapper form-inline dt-bootstrap">
					
						<div class="row">
						
							<div class="col-sm-6">
								<div class="dataTables_length" id="example1_length"></div>
							</div>
							
							<div class="col-sm-6"></div>
							
						</div>
						
						<div class="row">
						
							<div class="col-sm-12">
							
								<div id="example1_filter" class="dataTables_filter"></div>
								
								<table id="fishgramTable" class="table table-bordered table-striped dataTable" role="grid" aria-describedby="example1_info">
								
									<thead>
									
										<tr role="row">
											
											<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="width:80px; text-align:center;">No.</th>
											<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center;">제목</th>
											<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="width:150px; text-align:center;">등록일</th>
											<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="width:80px; text-align:center;">조회수</th>
											<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="width:80px; text-align:center;">좋아요</th>
											
										</tr>
										
									</thead>
									
									<tbody>
		
										<c:forEach items="${fdl}" var="list" varStatus="stat">
											
											<c:if test="${(stat.count % 2) eq 1 }">
											<tr role="row" class="odd" onmouseover="this.style.background='#ECCEF5'" onmouseout="this.style.background='#FAFAFA'" style="cursor:pointer">
											</c:if>
											
											<c:if test="${(stat.count % 2) eq 0 }">
											<tr role="row" class="odd" onmouseover="this.style.background='#ECCEF5'" onmouseout="this.style.background='white'" style="cursor:pointer">
											</c:if>
																						
												<td style = "text-align : center;">${list.rnum}<input type="hidden" value="${list.bo_no }"></td>
												<td>${list.bo_title}</td>
												<td style = "text-align : center;">${list.bo_reg_date}</td>
												<td style = "text-align : center;">${list.bo_hit}</td>
												<td style = "text-align : center;">${list.bo_good_hit}</td>
												
											</tr>
											
										</c:forEach>
		
									</tbody>
									
								</table>
		
								<div>
								
									<form action = "${pageContext.request.contextPath }/user/fishgram/fishgramMeMain.do" method = "get">
									
										<div style = "float:left">
										
											<select name ="search_keycode" class="form-control">
												<option value = "TOTAL">전체</option>
												<option value = "TITLE">제목</option>
												<option value = "CONTENT">내용</option>
											</select>
											
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											
											<input id = "search_keyword" name = "search_keyword" type="text" class="form-control" style="width: 300px;" placeholder="검색어를 입력하세요..">
											
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											
											<button class="btn btn-primary" type="submit">검색</button>
																				
										</div>
										
									</form>
									
										<button type="button" style="width: 80px;" class="btn btn-info btn-md pull-right" id = insertFishgramDiary>등록</button>
										
								</div>
																				
							</div>
							
						</div>
						
						<div class="row">
						
							<div class="col-sm-5"></div>
							
							${paging }
							
						</div>
		
					</div>
					
				</div>
		
			</div>
	
		</div>
			
	
		<!-- 프로필 및 기타 메뉴 영역 -->
		<div class="col-md-12" style = "float:right; width:20%; height:822px; overflow-x:hidden; overflow-y:hidden;">
				
			<!-- 프로필 박스 -->
			<div class="box box-primary" style = "height:483px;">
				<div class="box-body box-profile" style = "height:480px;">
														
					<div id = "idPicViewDiv" style = "height:210px; background-size:contain; margin-bottom: 20px;">
						
						<!-- 프로필 사진이 등록되어 있지 않은 경우 -->
						<c:if test="${params.profile_status eq 'n'}">
						
						<img class="profile-user-img img-responsive img-circle" src="${pageContext.request.contextPath }/dist/img/person_icon.png" alt="User profile picture" onclick = "pictureChange();" style = "height:210px; width:auto; align:center; cursor:pointer" onmouseover="this.style.background='#ECCEF5'" onmouseout="this.style.background='#FAFAFA'">
						
						</c:if>
							

						<!-- 프로필 사진이 등록되어 있는 경우 -->
						<c:if test="${params.profile_status eq 'y'}">
									
						<img class="profile-user-img img-responsive img-circle" src="/image/${params.fp_file_save_name}" alt="User profile picture" onclick = "pictureChange();" style = "height:210px; width:auto; align:center; cursor:pointer" onmouseover="this.style.background='#ECCEF5'" onmouseout="this.style.background='#FAFAFA'">
						
						</c:if>

					</div>
					
					<div style = "margin-bottom:30px;">
					
						<h3 class="profile-username text-center">${LOGIN_MEMBER.mem_nickname }</h3>
					
					</div>					
					
	
<!-- 					<p class="text-muted text-center" style="cursor:pointer"></p> -->
	
					<ul class="list-group list-group-unbordered">
					
						<li class="list-group-item">
							<b>작성글 수</b>
							<a class="pull-right">${totalAllDiary}</a>
						</li>
						
						<li class="list-group-item">
							<b>좋아요 수</b>
							<a	class="pull-right">${totalAllLike }</a>
						</li>
						
						<li class="list-group-item">
							<b>친구 수</b>
							<a class="pull-right">${totalAllFriend}</a>
						</li>
						
					</ul>
	
					<div id = "pictureButton">
					
						<button type="button" class="btn btn-primary btn-block">프로필 사진 변경 : 사진을 눌러주세요</button>	
					
					</div>
					
				</div>
				
			</div>
	
	
			<!-- 닉네임 검색 박스 -->
			<div class="info-box" style = "height:90px; overflow-x:hidden; overflow-y:hidden;">
			
				<span class="info-box-icon bg-aqua">
					<i class="fa fa-search"></i>
				</span>
	
				<div class = "wrap" style = "height:90px; overflow-x:hidden; overflow-y:hidden;">
				
					<button type="button" class="btn btn-info" id = "searchNicknameButton" style = "height:100%; width:100%; font-size:30px; font-family:나눔고딕;">닉네임검색</button>
					
				</div>
				
			</div>

			<!-- 닉네임 검색 모달창 -->
			<div class="modal modal-info fade" id = "searchNickname" >
			
				<div class="modal-dialog">
				
					<div class="modal-content" >
					
						<div class="modal-header" style="background-color: #4E8DF5 !important;" >
						
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							
							<h4 class="modal-title">닉네임검색</h4>
							
						</div>
						
						<div class="modal-body" style="background-color: white !important;">
							
							<button type="button" class="btn btn-info pull-right" id = "searchFishgram" style = "margin-left:5px; font-weight:bold; background-color: #8FCEFF !important; " >피쉬그램 검색</button>
							
							<input type="text" id = "inputNickname" class = "pull-right" name="inputNickname" style = "color:black; width:38%; height:34px;" placeholder="찾고자하는 닉네임을 입력하세요."/>
							
							<br>
							<hr>
							<br>
				
							<div id = "viewTable"></div>
							
							<div id = "viewPaging" class = "wrap" ></div>
							
						</div>
						
						<div class="modal-footer" style="background-color: white !important;">
						
							<button type="button" class="btn btn-info" data-dismiss="modal" style="background-color: #8FCEFF  !important;  ">닫기</button>
														
						</div>
						
					</div>
					
				</div>
				
			</div>

			
			<!-- 친구 관리 박스 -->
			<div class="info-box" style = "height:90px; overflow-x:hidden; overflow-y:hidden;">
			
				<span class="info-box-icon bg-aqua">
					<i class="fa fa-users"></i>
				</span>
	
				<div class = "wrap" style = "height:90px; overflow-x:hidden; overflow-y:hidden;">
				
<!-- 					<button type="button" class="btn btn-info" data-toggle="modal" data-target="#manageFriend" style = "height:100%; width:100%; font-size:30px; font-family:나눔고딕;">친구 관리</button> -->
					<button type="button" class="btn btn-info" id = "manageFriendButton" style = "height:100%; width:100%; font-size:30px; font-family:나눔고딕;">친구 관리</button>
					
				</div>
				
			</div>
			
			
			<!-- 친구 관리 모달창 -->
			<div class="modal modal-info fade" id = "manageFriend">
			
				<div class="modal-dialog">
				
					<div class="modal-content">
					
						<div class="modal-header" style="background-color: #4E8DF5 !important;">
						
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							
							<h4 class="modal-title">친구관리</h4>
							
						</div>
						
						<div class="modal-body" style="background-color: white !important;">

							<button type="button" class="btn btn-success" id = "receiveFriendApplyAjax">받은 요청</button>
							<button type="button" class="btn btn-warning" id = "sendFriendApplyAjax">보낸 요청</button>
							
							<button type="button" class="btn btn-info pull-right" id = "searchFriend" style = "margin-left:5px; background-color: #8FCEFF  !important;">친구 검색</button>
							<input type="text" id = "inputFriendNickname" name="inputFriendNickname" style = "color:black; width:30%; height:34px;" class = "pull-right" placeholder="친구 닉네임을 입력하세요."/>
							
							<br>
							<hr>
							
							<div id = "viewFriendTable" style = "margin-top: 10px;">
							
							
							</div>
							<div id = "viewFriendPaging" class = "wrap" ></div>
										
						</div>
											
						<div class="modal-footer" style="background-color: white !important;">
						
							<button type="button" class="btn btn-info" data-dismiss="modal" style = "background-color: #8FCEFF  !important;">닫기</button>
														
						</div>

					</div>
					
				</div>
				
			</div>
			
			
			<!-- 알림 관리 박스 -->
<!-- 			<div class="info-box" style = "height:90px; overflow-x:hidden; overflow-y:hidden;"> -->
			
<!-- 				<span class="info-box-icon bg-aqua"> -->
<!-- 					<i class="fa fa-bell"></i> -->
<!-- 				</span> -->
	
<!-- 				<div class = "wrap" style = "height:90px; overflow-x:hidden; overflow-y:hidden;"> -->
				
<!-- 					<button type="button" class="btn btn-info" data-toggle="modal" data-target="" style = "height:100%; width:100%; font-size:30px; font-family:나눔고딕;">알림 관리</button> -->
					
<!-- 				</div> -->
				
<!-- 			</div> -->
			
		</div>
	</div>

<!-- 아래 html 건들지 말것 -->

</section>
</div>

</body>

<script type="text/javascript">
	
	var nickname;
	
	var currentPage;
	
	var pagingCreate;
	
	$(function() {
		
		$('#insertFishgramDiary').click(function() {

			$(location).attr('href','${pageContext.request.contextPath}/user/fishgram/diary/fishgramDiaryForm.do');
			
		});
		
		
		$('#idPicFileUpload').click(function() {
			
			var url = "${pageContext.request.contextPath }/user/fishgram/facepicture/idPicFileUpload.do";
			var options = "width = 375, height = 400, scrollbars = no";
		
			window.open(url, "프로필사진업로드", options);
			
			
		});
		
		
		$('#profileModifyComplete').click(function() {
			
			$(location).attr('href','${pageContext.request.contextPath}/user/fishgram/facepicture/profileModifyComplete.do');
			
		});
				
		
		
		// 닉네임검색 모달창 띄우기
		$('#searchNicknameButton').click(function() {
			
			$('#searchNickname').modal({backdrop: 'static'});
			
			if (currentPage == null) {
				
				currentPage = 1;
				
			}
			
			ajaxReq(currentPage);
			
		});
		
		// 닉네임검색 모달창 내에 있는 닉네임검색 눌렀을 때
		$('#searchFishgram').on('click', function() {
			
			if (currentPage == null) {
				
				currentPage = 1;
				
			}
			
			ajaxReq(currentPage);
				
		});
		
		
		// 친구 관리 모달창 띄우기
		$('#manageFriendButton').click(function() {
			
			$('#manageFriend').modal({backdrop: 'static'});
			
			if (currentPage == null) {
				
				currentPage = 1;
				
			}
			
			ajaxSearchFriend(currentPage);
			
		});
		
		
		// 친구 관리 모달창 내에 있는 친구 검색 눌렀을 때
		$('#searchFriend').on('click', function() {
			
			if (currentPage == null) {
				
				currentPage = 1;
				
			}
			
			ajaxSearchFriend(currentPage);
			
			
		});
		
		
		$('#fishgramTable tr:gt(0)').click(function() {
			
			var bo_no = $(this).find('td:eq(0) input').val();
			var rnum = $(this).find('td:eq(0)').text();
			var bo_hit = $(this).find('td:eq(3)').text();
							
			var currentPage = '${params.currentPage}';
	    	var search_keyword = '${params.search_keyword}';
	    	var search_keycode = '${params.search_keycode}';
	    	
	    	var hitCount = 'ok';
	    	
	    	var query = '';
			
			if(search_keyword != null && search_keyword != '' ){
				
				query = '?bo_no=' + bo_no + '&rnum=' + rnum + '&currentPage=' + currentPage + '&search_keyword=' + search_keyword + '&search_keycode=' + search_keycode + '&bo_hit=' + bo_hit + '&hitCount=' + hitCount;
				
				$(location).attr('href', '${pageContext.request.contextPath}/user/fishgram/diary/fishgramDiaryMeView.do' + query);
	    		
	    	} else {
	    		
	    		query = '?bo_no=' + bo_no + '&currentPage=' + currentPage + '&rnum=' + rnum + '&bo_hit=' + bo_hit + '&hitCount=' + hitCount;
	    		
	    		$(location).attr('href','${pageContext.request.contextPath}/user/fishgram/diary/fishgramDiaryMeView.do' + query);
	    		
	    	}
			
		});
		
		
		$('#receiveFriendApplyAjax').click(function() {
			
			if (currentPage == null) {
				
				currentPage = 1;
				
			}
			
			ajaxReceiveFriendApply(currentPage);
			
		});
		
		
		$('#sendFriendApplyAjax').click(function() {
			
			if (currentPage == null) {
				
				currentPage = 1;
				
			}
			
			ajaxSendFriendApply(currentPage);
			
		});
			
	});
	
	
	// 프로필 사진 변경
	function pictureChange() {
		
		var url = "${pageContext.request.contextPath }/user/fishgram/facepicture/idPicFileUpload.do";
		var options = "width = 375, height = 400, scrollbars = no";
	
		window.open(url, "프로필사진업로드", options);
		
	};
	
	
	// 프로필 수정 완료
	function profileModifyComplete() {
			
		$(location).attr('href','${pageContext.request.contextPath}/user/fishgram/facepicture/profileModifyComplete.do');
		
	}
	
	
	// 닉네임검색 모달 창 (페이징 처리 포함)
	function ajaxReq(pageNo) {
		
		$('#viewTable').empty();
		
		$('#viewPaging').empty();
		
		nickname = $('#inputNickname').val();
		
		if (pageNo == null) {
			
			pageNo = 1;
			
		}
		
		$.ajax({
			
			url : '${pageContext.request.contextPath}/user/fishgram/nickname/searchNickname.do?nickname=' + encodeURIComponent(nickname) + '&pageNo=' + encodeURIComponent(pageNo),
					
			error : function(request, status, error) {
		         
	             alert("code : " + request.status + "\r\nmessage : " + request.reponseText);
	             
			},
			
			success : function(result) {
				
				var htmls = '<table id="nickNameList" class="table table-bordered table-striped dataTable" role="grid" aria-describedby="example1_info" style = "color:black; font-weight:bold;">' +
							'	<thead>' +
							'		<tr role="row">' +
							'			<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align: center;">No.</th>' +
							'			<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align: center;">닉네임</th>' +
							'			<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align: center;">가입날짜</th>' +
							'		</tr>' +
							'	</thead>' +
							'	<tbody>';
							
				for (var i = 0 ; i < result.mv.length ; i++) {
					
					htmls += '		<tr role="row" class="odd" style = "cursor:pointer">' +
							 '			<td style="text-align: center;">' + result.mv[i].rnum + '</td>' +
							 '			<td style="text-align: center;">' + result.mv[i].mem_nickname + '</td>' +
							 '			<td style="text-align: center;">' + result.mv[i].mem_reg_date + '</td>' +
							 '		</tr>';
					
				}
						
				htmls += '</tbody></table>';
				
				pagingCreate = result.pagingNickname;
				
				$('#viewTable').empty().append(htmls);
				
				$('#viewPaging').empty().append(pagingCreate);
				
				currentPage = result.currentPage;
				
				$('#nickNameList tr:gt(0)').click(function() {
					
					var selectNickname = $(this).find('td:eq(1)').text();
				
					$(location).attr('href','${pageContext.request.contextPath}/user/fishgram/fishgramYouMain.do?selectNickname=' + selectNickname);
								
				});
					 
			}
			
		});
		
	};
	
	
	// 입력받은 닉네임 조건에 맞는 친구 리스트 출력 (페이징 처리 포함)
	function ajaxSearchFriend(pageNo) {
		
		$('#viewFriendTable').empty();
		
		$('#viewFriendPaging').empty();
		
		friendNickname = $('#inputFriendNickname').val();
		
		if (pageNo == null) {
			
			pageNo = 1;
			
		}
		
		$.ajax({
			
			url : '${pageContext.request.contextPath}/user/fishgram/friend/searchFriend.do?pageNo=' + encodeURIComponent(pageNo) + '&friendNickname=' + encodeURIComponent(friendNickname),
					
			error : function(request, status, error) {
		         
	             alert("code : " + request.status + "\r\nmessage : " + request.reponseText);
	             
			},
			
			success : function(result) {
				
				var htmls = '<div style = "text-align:center;">' +
							'	<p style = "color:blue; font-weight:bold;"> 나와 친구를 맺은 회원 리스트 </p>' +
							'</div>' +
			    			'<br>' +
							'<table id = "searchFriendTable" class="table table-bordered table-striped dataTable" style = "color:black; font-weight:bold;">' +
							'	<thead>' +
							'		<tr role="row">' +
							'			<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align: center;">No.</th>' +
							'			<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align: center;">프로필사진</th>' +
							'			<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align: center;">닉네임</th>' +
							'			<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align: center;">친구신청날짜</th>' +
							'		</tr>' +
							'	</thead>' +
							'	<tbody>';
							
				for (var i = 0 ; i < result.searchFal.length ; i++) {
					
					htmls += '		<tr role="row" class="odd" style = "cursor:pointer;">' +
							 '			<td style="text-align:center">' + result.searchFal[i].RNUM + '</td>' +
							 '			<td>';

					if (result.searchFal[i].PROFILE_STATUS == 'n') {
						
						htmls += '			<img class="profile-user-img img-responsive img-circle" src="${pageContext.request.contextPath }/dist/img/person_icon.png" alt="User profile picture" style = "width:69.2px; height:90px;">';
						
					} else if (result.searchFal[i].PROFILE_STATUS == 'y') {
						
						htmls += '			<img class="profile-user-img img-responsive img-circle" src="/image/' + result.searchFal[i].FP_FILE_SAVE_NAME + '" alt="User profile picture" style = "width:69.2px; height:90px;">';
						
					}
					
					htmls += '			</td>' +
							 '			<td style="text-align:center;">' + result.searchFal[i].MEM_NICKNAME + '</td>' +
							 '			<td style="text-align:center;">' + result.searchFal[i].FR_ACCEPT_DATE + '</td>' +
							 '		</tr>';
					
				}
						
				htmls += '</tbody></table>';
				
				pagingCreate = result.searchFriendPaging;
				
				$('#viewFriendTable').empty().append(htmls);
				
				$('#viewFriendPaging').empty().append(pagingCreate);
				
				currentPage = result.currentPage;
				
				$('#searchFriendTable tr:gt(0)').click(function() {
					
					var selectNickname = $(this).find('td:eq(2)').text();
					
					$(location).attr('href','${pageContext.request.contextPath}/user/fishgram/fishgramYouMain.do?selectNickname=' + selectNickname);
								
				});
					 
			}
			
		});
		
	};
	
	
	// 받은 요청 관련 모달 창 (페이징 처리 포함)
	function ajaxReceiveFriendApply(pageNo) {
		
		$('#viewFriendTable').empty();
		
		$('#viewFriendPaging').empty();
		
		if (pageNo == null) {
			
			pageNo = 1;
			
		}
		
		$.ajax({
			
			url : '${pageContext.request.contextPath}/user/fishgram/friend/receiveFriendApplyList.do?pageNo=' + encodeURIComponent(pageNo),
					
			error : function(request, status, error) {
		         
	             alert("code : " + request.status + "\r\nmessage : " + request.reponseText);
	             
			},
			
			success : function(result) {
				
				var htmls = '<div style = "text-align:center;">' +
							'	<p style = "color:coral; font-weight:bold;"> 나에게 친구신청을 한 회원 리스트 </p>' +
							'</div>' +
						    '<br>' +
						    '<table id = "receiveFriendApplyTable" class="table table-bordered table-striped dataTable" style = "color:black; font-weight:bold;">' +
							'	<thead>' +
							'		<tr role="row">' +
							'			<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align: center;">No.</th>' +
							'			<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align: center;">프로필사진</th>' +
							'			<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align: center;">닉네임</th>' +
							'			<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align: center;">친구신청날짜</th>' +
							'		</tr>' +
							'	</thead>' +
							'	<tbody>';
							
				for (var i = 0 ; i < result.receiveFal.length ; i++) {
					
					htmls += '		<tr role="row" class="odd" style = "cursor:pointer;">' +
							 '			<td style="text-align:center">' + result.receiveFal[i].RNUM + '</td>' +
							 '			<td>';

					if (result.receiveFal[i].PROFILE_STATUS == 'n') {
						
						htmls += '			<img class="profile-user-img img-responsive img-circle" src="${pageContext.request.contextPath }/dist/img/person_icon.png" alt="User profile picture" style = "width:69.2px; height:90px;">';
						
					} else if (result.receiveFal[i].PROFILE_STATUS == 'y') {
						
						htmls += '			<img class="profile-user-img img-responsive img-circle" src="/image/' + result.receiveFal[i].FP_FILE_SAVE_NAME + '" alt="User profile picture" style = "width:69.2px; height:90px;">';
						
					}
					
					htmls += '			</td>' +
							 '			<td style="text-align:center;">' + result.receiveFal[i].MEM_NICKNAME + '</td>' +
							 '			<td style="text-align:center;">' + result.receiveFal[i].FR_APPLY_DATE + '</td>' +
							 '		</tr>';
					
				}
						
				htmls += '</tbody></table>';
				
				pagingCreate = result.friendReceivePaging;
				
				$('#viewFriendTable').empty().append(htmls);
				
				$('#viewFriendPaging').empty().append(pagingCreate);
				
				currentPage = result.currentPage;
				
				$('#receiveFriendApplyTable tr:gt(0)').click(function() {
					
					var selectNickname = $(this).find('td:eq(2)').text();
				
					$(location).attr('href','${pageContext.request.contextPath}/user/fishgram/fishgramYouMain.do?selectNickname=' + selectNickname);
								
				});
					 
			}
			
		});
		
	};
	
	
	// 보낸 요청 관련 모달 창 (페이징 처리 포함)
	function ajaxSendFriendApply(pageNo) {
		
		$('#viewFriendTable').empty();
		
		$('#viewFriendPaging').empty();
		
		if (pageNo == null) {
			
			pageNo = 1;
			
		}
		
		$.ajax({
			
			url : '${pageContext.request.contextPath}/user/fishgram/friend/sendFriendApplyList.do?pageNo=' + encodeURIComponent(pageNo),
					
			error : function(request, status, error) {
		         
	             alert("code : " + request.status + "\r\nmessage : " + request.reponseText);
	             
			},
			
			success : function(result) {
				
				var htmls = '<div style = "text-align:center;">' +
							'	<p style = "color:green; font-weight:bold;"> 내가 친구신청을 한 회원 리스트 </p>' +
							'</div>' +
			    			'<br>' +
							'<table id = "sendFriendApplyTable" class="table table-bordered table-striped dataTable" style = "color:black; font-weight:bold;">' +
							'	<thead>' +
							'		<tr role="row">' +
							'			<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align: center;">No.</th>' +
							'			<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align: center;">프로필사진</th>' +
							'			<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align: center;">닉네임</th>' +
							'			<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align: center;">친구신청날짜</th>' +
							'		</tr>' +
							'	</thead>' +
							'	<tbody>';
							
				for (var i = 0 ; i < result.sendFal.length ; i++) {
					
					htmls += '		<tr role="row" class="odd" style = "cursor:pointer;">' +
							 '			<td style="text-align:center">' + result.sendFal[i].RNUM + '</td>' +
							 '			<td>';

					if (result.sendFal[i].PROFILE_STATUS == 'n') {
						
						htmls += '			<img class="profile-user-img img-responsive img-circle" src="${pageContext.request.contextPath }/dist/img/person_icon.png" alt="User profile picture" style = "width:69.2px; height:90px;">';
						
					} else if (result.sendFal[i].PROFILE_STATUS == 'y') {
						
						htmls += '			<img class="profile-user-img img-responsive img-circle" src="/image/' + result.sendFal[i].FP_FILE_SAVE_NAME + '" alt="User profile picture" style = "width:69.2px; height:90px;">';
						
					}
					
					htmls += '			</td>' +
							 '			<td style="text-align:center;">' + result.sendFal[i].MEM_NICKNAME + '</td>' +
							 '			<td style="text-align:center;">' + result.sendFal[i].FR_APPLY_DATE + '</td>' +
							 '		</tr>';
					
				}
						
				htmls += '</tbody></table>';
				
				pagingCreate = result.friendSendPaging;
				
				$('#viewFriendTable').empty().append(htmls);
				
				$('#viewFriendPaging').empty().append(pagingCreate);
				
				currentPage = result.currentPage;
				
				$('#sendFriendApplyTable tr:gt(0)').click(function() {
					
					var selectNickname = $(this).find('td:eq(2)').text();
				
					$(location).attr('href','${pageContext.request.contextPath}/user/fishgram/fishgramYouMain.do?selectNickname=' + selectNickname);
								
				});
					 
			}
			
		});
		
	};

</script>