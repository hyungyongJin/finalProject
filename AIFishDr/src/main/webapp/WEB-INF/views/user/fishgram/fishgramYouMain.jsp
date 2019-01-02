<%--==============================================================
 * jsp 개요 : 타인의 피쉬그램 메인화면
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
			display : flax;
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
								
									<form action = "${pageContext.request.contextPath }/user/fishgram/fishgramYouMain.do" method = "get">
									
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
														
					<div id = "idPicViewDiv" style = "height:210px; background-size:contain; margin-bottom:20px;">
						
						<!-- 프로필 사진이 등록되어 있지 않은 경우 -->
						<c:if test="${yourParams.profile_status eq 'n'}">
						
						<img class="profile-user-img img-responsive img-circle" src="${pageContext.request.contextPath }/dist/img/person_icon.png" alt="User profile picture" style = "height:210px; width:auto; align:center; cursor:pointer">
						
						</c:if>
							

						<!-- 프로필 사진이 등록되어 있는 경우 -->
						<c:if test="${yourParams.profile_status eq 'y'}">
									
						<img class="profile-user-img img-responsive img-circle" src="/image/${yourParams.yourfp_file_save_name}" alt="User profile picture" style = "height:210px; width:auto; align:center; cursor:pointer">
						
						</c:if>

					</div>
										
					<div style = "margin-bottom:30px;">
					
						<h3 class="profile-username text-center" style="cursor:pointer">${yourParams.mem_nickname }</h3>
					
					</div>
					
					
	
<!-- 					<p class="text-muted text-center" style="cursor:pointer">타인</p> -->
	
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
							<a class="pull-right">${totalAllFriend }</a>
						</li>
						
					</ul>
	
					
					<!-- 내가 상대방에게 친구 신청을 하였을 때 변하는 버튼 -->
					<c:if test="${friendSendParams.sendApplyStatus eq 'w' and friendReceiveParams.receiveEmptyStatus eq 'empty'}">
					
						<button type="button" class="btn btn-danger btn-block" style = "cursor:pointer" data-toggle = "modal" data-target = "#noFishgramFriendApply">친구 신청 취소하기</button>
						
					</c:if>
					
					
					<!-- 상대방이 나에게 친구 신청을 하였을 때 변하는 버튼 -->
					<c:if test="${friendReceiveParams.receiveApplyStatus eq 'w' and friendSendParams.sendEmptyStatus eq 'empty'}">

						<div style = "width:49%; float:left; margin-right:5px;">
						
							<button type="button" class="btn btn-success btn-block" style = "cursor:pointer" data-toggle = "modal" data-target = "#yesFishgramFriendApply">친구 수락하기</button>
						
						</div>
						
						<div style = "width:49%; float:left;">
						
							<button type="button" class="btn btn-warning btn-block" style = "cursor:pointer" data-toggle = "modal" data-target = "#noFishgramFriendApply">친구 거절하기</button>
						
						</div>					
						
						
					</c:if>
					
					
					<!-- 나와 상대방이 이미 친구 관계일 경우 변하는 버튼 -->
					<c:if test="${friendSendParams.sendApplyStatus eq 'friend' or friendReceiveParams.receiveApplyStatus eq 'friend'}">
					
						<button type="button" class="btn btn-success btn-block" style = "cursor:pointer" data-toggle = "modal" data-target = "#noFishgramFriendApply">친구 삭제하기</button>
						
					</c:if>
					
					
					<!-- 나와 상대방이 아직 친구 신청 관계가 없을 경우 변하는 버튼 (기본값) -->
					<c:if test="${friendSendParams.sendApplyStatus eq 'noFriend' or friendReceiveParams.receiveApplyStatus eq 'noFriend'}">
					
						<button type="button" class="btn btn-primary btn-block" style = "cursor:pointer" id = "applyFishgramFriend">친구 신청하기</button>
						
					</c:if>
					
				</div>
				
			</div>
			
			
			<!-- 친구 신청 취소하기, 거절하기 및 친구 삭제하기 버튼을 눌렀을 때 뜨는 모달창 -->
			<div class="modal modal-danger fade" id="noFishgramFriendApply">
			
				<div class="modal-dialog">
				
					<div class="modal-content">
					
						<div class="modal-header" style="background-color: #4E8DF5 !important;">
						
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							
								<span aria-hidden="true">&times;</span>
								
							</button>
							
							<!-- 친구 신청 취소하기 -->
							<c:if test="${friendSendParams.sendApplyStatus eq 'w' and friendReceiveParams.receiveEmptyStatus eq 'empty'}">
							
								<h4 class="modal-title">친구 신청 취소하기</h4>
								
							</c:if>
							
							
							<!-- 친구 신청 거절하기 -->
							<c:if test="${friendReceiveParams.receiveApplyStatus eq 'w' and friendSendParams.sendEmptyStatus eq 'empty'}">
							
								<h4 class="modal-title">친구 신청 거절하기</h4>
								
							</c:if>
							
							
							<!-- 친구 삭제하기 -->
							<c:if test="${friendSendParams.sendApplyStatus eq 'friend' or friendReceiveParams.receiveApplyStatus eq 'friend'}">
							
								<h4 class="modal-title">친구 삭제하기</h4>
								
							</c:if>
							
						</div>
						
						<div class="modal-body" style="background-color: white !important;">
						
							<!-- 친구 신청 취소하기 -->
							<c:if test="${friendSendParams.sendApplyStatus eq 'w' and friendReceiveParams.receiveEmptyStatus eq 'empty'}">
							
								<p style="color:black;">정말 친구 신청을 취소하시겠습니까?</p>
								
							</c:if>
							
							
							<!-- 친구 신청 거절하기 -->
							<c:if test="${friendReceiveParams.receiveApplyStatus eq 'w' and friendSendParams.sendEmptyStatus eq 'empty'}">
							
								<p style="color:black;">정말 친구 신청을 거절하시겠습니까?</p>
								
							</c:if>
							
							
							<!-- 친구 삭제하기 -->
							<c:if test="${friendSendParams.sendApplyStatus eq 'friend' or friendReceiveParams.receiveApplyStatus eq 'friend'}">
							
								<p style="color:black;">정말 친구 관계를 삭제하시겠습니까?</p>
								
							</c:if>
							
						</div>
						
						<div class="modal-footer" style="background-color: white !important;">
						
							<button type="button" class="btn btn-outline pull-left" data-dismiss="modal">닫기</button>
							
							<!-- 친구 신청 취소하기 -->
							<c:if test="${friendSendParams.sendApplyStatus eq 'w' and friendReceiveParams.receiveEmptyStatus eq 'empty'}">
							
								<button type="button" class="btn btn-outline" id = "cancelFishgramFriendApply" style="color:black; background-color: #8FCEFF !important;">취소하기</button>
								
							</c:if>
							
							
							<!-- 친구 신청 거절하기 -->
							<c:if test="${friendReceiveParams.receiveApplyStatus eq 'w' and friendSendParams.sendEmptyStatus eq 'empty'}">
							
								<button type="button" class="btn btn-outline" id = "refuseFishgramFriendApply" style="color:black; background-color: #8FCEFF !important;">거절하기</button>
								
							</c:if>
							
							
							<!-- 친구 삭제하기 -->
							<c:if test="${friendSendParams.sendApplyStatus eq 'friend' or friendReceiveParams.receiveApplyStatus eq 'friend'}">
							
								<button type="button" class="btn btn-outline" id = "deleteFishgramFriendApply" style="color:black; background-color: #8FCEFF !important;">삭제하기</button>
								
							</c:if>
														
						</div>
						
					</div>
					
				</div>
				
			</div>
			
			
			<!-- 친구 수락하기 버튼을 눌렀을 때 뜨는 모달창 -->
			<div class="modal modal-success fade" id="yesFishgramFriendApply">
			
				<div class="modal-dialog">
				
					<div class="modal-content">
					
						<div class="modal-header" style="background-color: #4E8DF5 !important;">
						
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							
								<span aria-hidden="true">&times;</span>
								
							</button>
														
							<h4 class="modal-title" >친구 수락하기</h4>
							
						</div>
						
						<div class="modal-body" style="background-color: white !important;">
							
							<p style="color:black;">정말 친구 신청을 수락하시겠습니까?</p>
							
						</div>
						
						<div class="modal-footer" style="background-color: white !important;">
						
							<button type="button" class="btn btn-outline pull-left" data-dismiss="modal" style="color:black; background-color: #8FCEFF !important;">닫기</button>
							
							<button type="button" class="btn btn-outline" id = "acceptFishgramFriendApply" style="color:black; background-color: #8FCEFF !important;">수락하기</button>
																					
						</div>
						
					</div>
					
				</div>
				
			</div>


			<!-- 쪽지보내기 박스 -->
			<div class="info-box" style = "height:90px; overflow-x:hidden; overflow-y:hidden;">
			
				<span class="info-box-icon bg-aqua">
					<i class="fa fa-paper-plane"></i>
				</span>
	
				<div class = "wrap" style = "height:90px; overflow-x:hidden; overflow-y:hidden;">
				
					<button type="button" value="${yourParams.mem_nickname }(${params.your_mem_id })" onclick="goModal(this.value);"   class="btn btn-info" style = "height:100%; width:100%; font-size:30px; font-family:나눔고딕;">쪽지보내기</button>
					
				</div>
				
			</div>
			
			<!-- 채팅신청 박스 -->
			<div class="info-box" style = "height:90px; overflow-x:hidden; overflow-y:hidden;">
			
				<span class="info-box-icon bg-aqua">
					<i class="fa fa-wechat"></i>
				</span>
	
				<div class = "wrap" style = "height:90px; overflow-x:hidden; overflow-y:hidden;">
				
					<button type="button"  value="${yourParams.mem_nickname }(${params.your_mem_id })" onclick="goChatModal(this.value);" class="btn btn-info"  style = "height:100%; width:100%; font-size:30px; font-family:나눔고딕;">채팅신청</button>
					
				</div>
				
			</div>

		</div>
	</div>

<!-- 아래 html 건들지 말것 -->

</section>
</div>

</body>

<script type="text/javascript">

	// '친구 신청하기' 버튼을 눌렀을 때
	$('#applyFishgramFriend').click(function() {
		
		var mem_id = '${LOGIN_MEMBER.mem_id}';
		var fr_id =  '${yourParams.bo_writer}';
		
		$(location).attr('href', '${pageContext.request.contextPath}/user/fishgram/friend/applyFishgramFriend.do?mem_id=' + mem_id + '&fr_id=' + fr_id);
		
	});
	
	
	// '친구 신청 취소하기' 버튼을 눌렀을 때
	$('#cancelFishgramFriendApply').click(function() {
	
		var mem_id = '${LOGIN_MEMBER.mem_id}';
		var fr_id =  '${yourParams.bo_writer}';
		
		$(location).attr('href', '${pageContext.request.contextPath}/user/fishgram/friend/cancelFishgramFriendApply.do?mem_id=' + mem_id + '&fr_id=' + fr_id);
		
	});
	
	
	// '친구 수락하기' 버튼을 눌렀을 때
	$('#acceptFishgramFriendApply').click(function() {
	
		var mem_id = '${LOGIN_MEMBER.mem_id}';
		var fr_id =  '${yourParams.bo_writer}';
		
		$(location).attr('href', '${pageContext.request.contextPath}/user/fishgram/friend/acceptFishgramFriendApply.do?mem_id=' + mem_id + '&fr_id=' + fr_id);
		
		
	});
	
	
	// '친구 거절하기' 버튼을 눌렀을 때
	$('#refuseFishgramFriendApply').click(function() {
		
		var mem_id = '${LOGIN_MEMBER.mem_id}';
		var fr_id = '${yourParams.bo_writer}';
		
		$(location).attr('href', '${pageContext.request.contextPath}/user/fishgram/friend/refuseFishgramFriendApply.do?mem_id=' + mem_id + '&fr_id=' + fr_id);
		
	});
	
	
	// '친구 삭제하기' 버튼을 눌렀을 때
	$('#deleteFishgramFriendApply').click(function() {
		
		var mem_id = '${LOGIN_MEMBER.mem_id}';
		var fr_id = '${yourParams.bo_writer}';
		
		$(location).attr('href', '${pageContext.request.contextPath}/user/fishgram/friend/deleteFishgramFriendApply.do?mem_id=' + mem_id + '&fr_id=' + fr_id);
		
	});
	

	$('#fishgramTable tr:gt(0)').click(function() {
		
		var bo_no = $(this).find('td:eq(0) input').val();
		var rnum = $(this).find('td:eq(0)').text();
		var bo_hit = $(this).find('td:eq(3)').text();

		var yourId = '${yourParams.bo_writer}'; 
						
		var currentPage = '${yourParams.currentPage}';
		var search_keyword = '${yourParams.search_keyword}';
		var search_keycode = '${yourParams.search_keycode}';
		
		var hitCount = 'ok';
		
		var query = '';
		
		if(search_keyword != null && search_keyword != '' ){
			
			query = '?bo_no=' + bo_no + '&rnum=' + rnum + '&currentPage=' + currentPage + '&search_keyword=' + search_keyword + '&search_keycode=' + search_keycode + '&bo_hit=' + bo_hit + '&hitCount=' + hitCount + '&yourId=' + yourId;
			
			$(location).attr('href', '${pageContext.request.contextPath}/user/fishgram/diary/fishgramDiaryYouView.do' + query);
			
		} else {
			
			query = '?bo_no=' + bo_no + '&currentPage=' + currentPage + '&rnum=' + rnum + '&bo_hit=' + bo_hit + '&hitCount=' + hitCount + '&yourId=' + yourId;
			
			$(location).attr('href','${pageContext.request.contextPath}/user/fishgram/diary/fishgramDiaryYouView.do' + query);
			
		}
			
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
	var options = "width = 500, height = 650, scrollbars = no left="+x+", top="+y;
	window.open(url, "채팅하기"+num, options);
}		
</script>