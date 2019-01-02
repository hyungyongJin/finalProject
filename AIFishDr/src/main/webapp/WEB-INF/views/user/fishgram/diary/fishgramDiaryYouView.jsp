<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html">

<head>

<!-- 	<meta charset="utf-8"> -->
<!-- 	<meta http-equiv="X-UA-Compatible" content="IE=edge"> -->
	
<!-- 	<title> 피쉬그램 글 보기 </title> -->
	
	<!-- Tell the browser to be responsive to screen width -->
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
	
	<!-- Bootstrap 3.3.7 -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/bower_components/bootstrap/dist/css/bootstrap.min.css">
	
	<!-- Font Awesome -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/bower_components/font-awesome/css/font-awesome.min.css">
	
	<!-- Ionicons -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/bower_components/Ionicons/css/ionicons.min.css">
	
	<!-- Theme style -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/dist/css/AdminLTE.min.css">
	
	<!-- AdminLTE Skins. Choose a skin from the css/skins folder instead of downloading all of them to reduce the load. -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/dist/css/skins/_all-skins.min.css">
	
	<!-- bootstrap wysihtml5 - text editor -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

	<!-- Google Font -->
	<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
		
	<!-- jQuery 3 -->
	<script src="${pageContext.request.contextPath }/bower_components/jquery/dist/jquery.min.js"></script>
	
	<!-- Bootstrap 3.3.7 -->
	<script src="${pageContext.request.contextPath }/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	
	<!-- FastClick -->
	<script src="${pageContext.request.contextPath }/bower_components/fastclick/lib/fastclick.js"></script>
	
	<!-- AdminLTE App -->
	<script src="${pageContext.request.contextPath }/dist/js/adminlte.min.js"></script>
	
	<!-- AdminLTE for demo purposes -->
	<script src="${pageContext.request.contextPath }/dist/js/demo.js"></script>
	
	<!-- CK Editor -->
	<script src="${pageContext.request.contextPath }/bower_components/ckeditor/ckeditor.js"></script>
	
	<!-- Bootstrap WYSIHTML5 -->
	<script src="${pageContext.request.contextPath }/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
	
	<script>
	
		$(function () {
  
  			CKEDITOR.replace('editor1');
  
  			$('.textarea').wysihtml5();
  
		});
	  
	</script>
	
	<style>

		.wrap {
		
			position : relative;
			display : -webkit-flex;
			display : flax;
			-webkit-justify-content : center;
			justify-content : center;
			-webkit-align-items : center;
			align-items : center;
		
		}
		
		
		#searchLikeTable th {
		
			vertical-align : middle !important;
		
		}
		
		#searchLikeTable td {
		
			vertical-align : middle !important;
		
		}
			
	</style>

</head>

<body class="hold-transition skin-blue sidebar-mini">
	
	<div class="content-wrapper" style="margin-left: 10px;">
	
		<section class = "content">
		
			<div class="row">
			
				<div class="col-md-6" style = "width:100%;">
				
					<div class="box box-widget">
					
						<div class="box-header with-border" style = "width:90%; height:192px; background-color:white; border-radius: 10px; margin-left:100px;">
						
							<div class="user-block" style = "width:100%; height:172px;background-color:white; border-radius: 10px;">
								
								<div class = "fishgramDiaryViewBackground" style = "float:left; margin-right:10px; height:172px; background-color:white; border-radius: 10px;">
																		
									<!-- 프로필 사진이 등록되어 있지 않은 경우 -->
									<c:if test="${yourParams.profile_status eq 'n'}">
									
									<img class="profile-user-img img-responsive img-circle" src="${pageContext.request.contextPath }/dist/img/person_icon.png" alt="User profile picture" style = "height:172px;">
									
									</c:if>
									
		
									<!-- 프로필 사진이 등록되어 있는 경우 -->
									<c:if test="${yourParams.profile_status eq 'y'}">
												
									<img class="profile-user-img img-responsive img-circle" src="/image/${yourParams.yourfp_file_save_name}" alt="User profile picture" style = "width:132px; height:172px;">
									
									</c:if>
														
								</div>
																
								<div style = "float:left; width:70%; height:172px; background-color:white; border-radius: 10px;">
								
									<blockquote style = "width:100%; height:172px; background-color:white; border-radius: 10px;">
									
										<div class = "input-group" style = "width:100%; background-color:grey;">
										
											<span class = "input-group-addon" style = "width:39px; height:34px;">
												<i class="fa fa-bullhorn"></i>
											</span>
											
											<input type = "text" class = "form-control" value = "&nbsp;&nbsp;${yourParams.bo_title }" style = "width:100%; height:34px; background-color:white; color:black;">
										
										</div>
										
										<br>
										
										<div class = "input-group" style = "width:100%;">
										
											<span class = "input-group-addon" style = "width:39px; height:34px;">
												<i class="fa fa-child"></i>
											</span>
											
											<input type = "text" class = "form-control" value = "&nbsp;&nbsp;${yourParams.mem_nickname }" style = "width:100%; height:34px; background-color:white; color:black;">
										
										</div>
										
										<br>
										
										<div class = "input-group" style = "width:100%;">
										
											<span class = "input-group-addon" style = "width:39px; height:34px;">
												<i class="fa fa-calendar"></i>
											</span>
												
											<input type = "text" class = "form-control" value = "&nbsp;&nbsp;${yourParams.bo_reg_date }" style = "width:100%; height:34px; background-color:white; color:black;">
										
										</div>
									
									</blockquote>
																									
								</div>
																
							</div>
							
							<div class="box-tools">
							
								<button type="button" class="btn btn-box-tool" data-toggle="tooltip" title="Mark as read">
									<i class="fa fa-circle-o"></i>
								</button>
								
								<button type="button" class="btn btn-box-tool" data-widget="collapse">
									<i class="fa fa-minus"></i>
								</button>
								
								<button type="button" class="btn btn-box-tool" data-widget="remove">
									<i class="fa fa-times"></i>
								</button>
								
							</div>
							
						</div>

						<div class="box-body" style = "width:90%; background-color:white; border-radius:10px; margin-left:100px;">
						
							<div style = "color:black; width:100%;">
							
								${yourParams.bo_content}
																
							</div>
							
						</div>
						
						<div class = "box-footer wrap" style = "width:100%; background-color:white; border-radius:10px;">
		
							<!-- 좋아요 아이콘 및 좋아요 수 -->
							<div class = "wrap" style = "float:left; height:40px; margin-left:45%; margin-right:20%;">
								
								<img id = "toggleFishgramDiaryLike" src = "${pageContext.request.contextPath }/dist/img/whalelike.png" width = "auto" height = "40px;" style = "margin-right:15px; float:left; vertical-align:middle; cursor:pointer;">
								
								<c:if test="${likeStatus != 'y'}">
								
									<div style = "height:40px; color:black; font-weight:bold; font-size:25px; float:right;">${totalLike}</div>
									
								</c:if>
								
								<c:if test="${likeStatus eq 'y'}">
								
									<div style = "height:40px; color:red; font-weight:bold; font-size:25px; float:right;">${totalLike}</div>
									
								</c:if>
														
							</div>
							
							<div class = "wrap pull-right" style = "width:30%; height:40px;">
								
								<div style = "float:left; width:45%; height:40px; margin-right:10px;">
								
									<button type = "button" class = "btn bg-maroon btn-block" id="likeButton">좋아요 리스트</button>
									
								</div>
								
								<div style = "float:left; width:45%; height:40px;">
								
									<button type = "button" class = "btn bg-maroon btn-block" id = "returnFishgramYouMain">피쉬그램 메인이동</button>
								
								</div>
							
							</div>
							
							
							<!-- 좋아요 리스트 모달창 -->
							<div class="modal modal-info fade" id = "fishgramLikeList">
							
								<div class="modal-dialog">
								
									<div class="modal-content">
									
										<div class="modal-header" style="background-color: #4E8DF5 !important;">
										
											<button type="button" class="close" data-dismiss="modal" aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
											
											<h4 class="modal-title">좋아요 리스트</h4>
											
										</div>
										
										<div class="modal-body" style="background-color: white !important;">
										
											<input type="text" id = "inputLikeNickname" name="inputLikeNickname" style = "color:black;"/>
											
											<button type="button" class="btn btn-info" id = "searchLike" style = "margin-left:5px; font-weight:bold; background-color: #8FCEFF !important; ">닉네임 검색</button>
								
											<div id = "viewFishgramLikeTable" style = "margin-top: 10px;"></div>
											
											<div id = "viewFishgramLikePaging" class = "wrap"></div>
											
										</div>
										
										<div class="modal-footer" style="background-color: white !important;">
										
											<button type="button" class="btn btn-outline" data-dismiss="modal" style = "margin-left:5px; font-weight:bold; background-color: #8FCEFF !important; ">닫기</button>
																		
										</div>
										
									</div>
									
								</div>
								
							</div>
							
						</div>
					
						
						<div class="box-footer box-comments" style = "width:100%; border-rqdius:10px;" id = "viewComments">
						
							<c:forEach items = "${fgcl}" var = "list">
							
								<div class = "box box-info" style = "height:100px;">
								
									<div style = "width:69.2px; height:90px; float:left; margin : 5px;">
									
										<!-- 프로필 사진이 등록되어 있지 않은 경우 -->
										<c:if test="${list.PROFILE_STATUS eq 'n'}">
										
										<img class="profile-user-img img-responsive img-circle" src="${pageContext.request.contextPath }/dist/img/person_icon.png" alt="User profile picture" style = "width:69.2px; height:90px;">
										
										</c:if>
											
				
										<!-- 프로필 사진이 등록되어 있는 경우 -->
										<c:if test="${list.PROFILE_STATUS eq 'y'}">
													
										<img class="profile-user-img img-responsive img-circle" src="/image/${list.FP_FILE_SAVE_NAME}" alt="User profile picture" style = "width:69.2px; height:90px;">
									
										</c:if>
										
									</div>
									
									<c:if test="${list.MEM_ID != LOGIN_MEMBER.mem_id }">	
										<div class="comment-text" style = "height:90px; width:93%; margin-left:5px; float:left;">
										
											<span class="username" style = "weight:100%; font-size:20px; font-weight:bold;"> ${list.MEM_NICKNAME }
											
												<span class="text-muted pull-right"> ${list.COMMENT_REG_DATE } </span>
												
											</span>
											
											<div style = "background:white; width:95%; margin-top:4px;">
											
												${list.COMMENT_CONTENT }
												
											</div>
											
										</div>
									</c:if>
									
									<c:if test="${list.MEM_ID eq LOGIN_MEMBER.mem_id }">
									
										<div class="comment-text" style = "height:90px; width:93%; margin-left:5px; float:left;">
										
											<span class="username" style = "weight:100%; font-size:20px; font-weight:bold;"> ${list.MEM_NICKNAME }
											
												<span class="text-muted pull-right"> ${list.COMMENT_REG_DATE } </span>
												
											</span>
											
											<div class="findComment" style = "width:100%;">
											
												<div style = "width:94%; float:left; margin-right:10px;">
												
													<textarea onmouseover="this.style.background='#ECCEF5'" onmouseout="this.style.background='white'" style = "width:100%; height:60px; float:left; margin-top:4px;">${list.COMMENT_CONTENT}</textarea>
													
												</div>
																								
												<div style = "width:5%; float:left; margin-top:4px;">
											
													<button type="button" class="sendMessage btn btn-primary btn-flat" style = "width:100%; height:29px; margin-bottom:1px;" value="${list.COMMENT_NO}" onclick="modifyFishgramDiaryComment(this.value);">수정</button>
													<button type="button" class="sendMessage btn btn-primary btn-flat" style = "width:100%; height:29px; margin-top:1px;" value="${list.COMMENT_NO}" onclick="deleteFishgramDiaryComment(this.value);">삭제</button>
											
												</div>
																							
											</div>
																						
										</div>
																		
									</c:if>
																
								</div>
														
							</c:forEach>
							
							<div class = "wrap">
													
								${paging }
								
							</div>
							
						</div>
						
						
						<div class="box-footer" style = "width:100%; background-color:white; border-radius: 10px;">
							
							<!-- 프로필 사진이 등록되어 있지 않은 경우 -->
							<c:if test="${params.profile_status eq 'n'}">
							
							<img class="img-responsive img-circle" src="${pageContext.request.contextPath }/dist/img/person_icon.png" alt="User profile picture" style = "height:74px; float:left; margin-right:10px;">
							
							</c:if>
							

							<!-- 프로필 사진이 등록되어 있는 경우 -->
							<c:if test="${params.profile_status eq 'y'}">
										
							<img class="img-responsive img-circle" src="/image/${params.fp_file_save_name}" alt="User profile picture" style = "width:57px; height:74px; float:left; margin-right:10px;">
							
							</c:if>
							
							<div class="img-push">
							
								<textarea class = "form-control" rows = "3" placeholder = "댓글을 입력해주세요." id = "inputComment" style = "width:90%; float:left; margin-right:10px;"></textarea>
								<button type="button" class="sendMessage btn btn-primary btn-flat" style = "width:5%; height:74px;" id = "addFishgramDiaryComment">댓글<br>등록</button>
																	
							</div>
							
						</div>

					</div>

				</div>
				
			</div>
		
		</section>
		
	</div>
	
</body>

<script type="text/javascript">

	var nickname;
	
	var currentPage;
	
	var pagingCreate;

	$(function() {
			
		$('#toggleFishgramDiaryLike').click(function() {
		
			var bo_no = '${yourParams.bo_no}';
			var yourId = '${yourParams.fp_mem_id}';
			
			var hitCount = "no";
			
			var likeStatus = '${likeStatus}';
			
			// 이미 좋아요를 누른 상태에서 아이콘을 눌렀을 경우 좋아요가 취소됨
			if (likeStatus == 'y') {
				
				$(location).attr('href', '${pageContext.request.contextPath}/user/fishgram/like/deleteFishgramDiaryLike.do?bo_no=' + bo_no + '&yourId=' + yourId + '&hitCount=' + hitCount);
				
			// 해당 글에 좋아요를 추가하고 싶은 경우 (취소한 좋아요를 다시 복구할 때 포함)
			} else {
				
				$(location).attr('href', '${pageContext.request.contextPath}/user/fishgram/like/insertFishgramDiaryLike.do?bo_no=' + bo_no + '&yourId=' + yourId + '&hitCount=' + hitCount);
				
			}
			
		});
		
		
		$('#returnFishgramYouMain').click(function() {
		
			var search_keyword = '${params.search_keyword}';
			var search_keycode = '${params.search_keycode}';
			
			var yourId = '${yourParams.fp_mem_id}';
			
			var hitCount = "no";
						
			$(location).attr('href', '${pageContext.request.contextPath}/user/fishgram/fishgramYouMain.do?search_keyword=' + search_keyword + '&search_keycode=' + search_keycode + '&hitCount=' + hitCount + '&yourId=' + yourId);
			
		});
		
		
		$('#searchLike').on('click', function() {
			
			if (currentPage == null) {
				
				currentPage = 1;
				
			}
			
			ajaxSearchLike(currentPage);
			
			
		});
		
		
		$('#addFishgramDiaryComment').click(function() {
			
			var bo_no = '${yourParams.bo_no}';
			var mem_id = '${LOGIN_MEMBER.mem_id}';
			var yourId = '${yourParams.fp_mem_id}';
			var inputComment = $('#inputComment').val();
			
			var hitCount = "no";
			
			$(location).attr('href', '${pageContext.request.contextPath}/user/fishgram/comment/insertFishgramDiaryComment.do?bo_no=' + bo_no + '&mem_id=' + mem_id + '&inputComment=' + inputComment + '&hitCount=' + hitCount + '&yourId=' + yourId);
			
		});
		

		modifyFishgramDiaryComment = function(value){
			
			var hiddenCommentNo = value;
			var modifyComment = $('.findComment').children().find('button[value='+value+']').parent().siblings('div').children().val();
			var bo_no = '${params.bo_no}';
			
			var yourId = '${yourParams.fp_mem_id}'; 
			
			$(location).attr('href', '${pageContext.request.contextPath}/user/fishgram/comment/modifyFishgramDiaryComment.do?hiddenCommentNo=' + hiddenCommentNo + '&modifyComment=' + modifyComment + '&bo_no=' + bo_no + '&yourId=' + yourId);
			
		};
		
		
		deleteFishgramDiaryComment = function(value){
			
			var hiddenCommentNo = value;
			var bo_no = '${params.bo_no}';
			
			var yourId = '${yourParams.fp_mem_id}';
			
			$(location).attr('href', '${pageContext.request.contextPath}/user/fishgram/comment/deleteFishgramDiaryComment.do?hiddenCommentNo=' + hiddenCommentNo + '&bo_no=' + bo_no + '&yourId=' + yourId);
			
		};
				
		$('#likeButton').click(function() {
			
			$('#fishgramLikeList').modal({backdrop: 'static'});
			
			if (currentPage == null) {
				
				currentPage = 1;
				
			}
			
			ajaxSearchLike(currentPage);
			
		});
		
	});
	
	
	// 입력받은 닉네임 조건에 맞는 좋아요 누른 회원 리스트 출력 (페이징 처리 포함)
	function ajaxSearchLike(pageNo) {
		
		$('#viewFishgramLikeTable').empty();
		
		$('#viewFishgramLikePaging').empty();
		
		likeNickname = $('#inputLikeNickname').val();
		
		bo_no = '${params.bo_no}';
		
		if (pageNo == null) {
			
			pageNo = 1;
			
		}
		
		$.ajax({
			
			url : '${pageContext.request.contextPath}/user/fishgram/like/searchLike.do?pageNo=' + encodeURIComponent(pageNo) + '&likeNickname=' + encodeURIComponent(likeNickname) + '&bo_no=' + encodeURIComponent(bo_no),
					
			error : function(request, status, error) {
		         
	             alert("code : " + request.status + "\r\nmessage : " + request.reponseText);
	             
			},
			
			success : function(result) {
				
				var htmls = '<table id = "searchLikeTable" class="table table-bordered table-striped dataTable" style = "color:black; font-weight:bold;">' +
							'	<thead>' +
							'		<tr role="row">' +
							'			<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align: center; font-weight:bold; background-color: #8FCEFF;">No.</th>' +
							'			<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align: center; font-weight:bold; background-color: #8FCEFF;">프로필사진</th>' +
							'			<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align: center; font-weight:bold; background-color: #8FCEFF; ">닉네임</th>' +
							'		</tr>' +
							'	</thead>' +
							'	<tbody>';
							
				for (var i = 0 ; i < result.searchLikelist.length ; i++) {
					
					htmls += '		<tr role="row" class="odd" style = "cursor:pointer;">' +
							 '			<td style="text-align:center">' + result.searchLikelist[i].RNUM + '</td>' +
							 '			<td>';

					if (result.searchLikelist[i].PROFILE_STATUS == 'n') {
						
						htmls += '			<img class="profile-user-img img-responsive img-circle" src="${pageContext.request.contextPath }/dist/img/person_icon.png" alt="User profile picture" style = "width:69.2px; height:90px;">';
						
					} else if (result.searchLikelist[i].PROFILE_STATUS == 'y') {
						
						htmls += '			<img class="profile-user-img img-responsive img-circle" src="/image/' + result.searchLikelist[i].FP_FILE_SAVE_NAME + '" alt="User profile picture" style = "width:69.2px; height:90px;">';
						
					}
					
					htmls += '			</td>' +
							 '			<td style="text-align:center;">' + result.searchLikelist[i].MEM_NICKNAME + '</td>' +
							 '		</tr>';
					
				}
						
				htmls += '</tbody></table>';
				
				pagingCreate = result.searchLikePaging;
				
				$('#viewFishgramLikeTable').empty().append(htmls);
				
				$('#viewFishgramLikePaging').empty().append(pagingCreate);
				
				currentPage = result.currentPage;
				
				$('#searchLikeTable tr:gt(0)').click(function() {
					
					var selectNickname = $(this).find('td:eq(2)').text();
				
					$(location).attr('href','${pageContext.request.contextPath}/user/fishgram/fishgramYouMain.do?selectNickname=' + selectNickname);
								
				});
					 
			}
			
		});
		
	};
	
</script>