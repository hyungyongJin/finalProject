<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html>
<html>
<head>
</head>
<style>
.box{margin-left:50px; width: 80%;}
th{text-align: center;}
textarea {
  resize: none;
}
</style>
<body>
	<div class="content-wrapper" style="margin-left: 10px;">
		<!-- Main content -->
		<section class="content">
			<div class="row">
				<div class="col-md-12">
					<form id="updateForm" method="post">
						<div class="box">
							<div class="box-body pad">
								<input type="text" class="form-control"
									onkeyup="auto_size(this,this.size)" name="bo_title"
									style="background-color: white; font-size: 15pt; color: green; border: none;"
									value="${viewInfo.BO_TITLE }">
								<hr>
								<input type="hidden" name="bo_writer"
									value="${viewInfo.BO_WRITER}"> <input type="hidden"
									name="bo_no" value="${viewInfo.BO_NO }">
								<div class="dropdown">
									<a href="#" class=" dropdown-toggle" data-toggle="dropdown">
										&nbsp;&nbsp;&nbsp; ${viewInfo.MEM_NICKNAME }(${fn:substring(viewInfo.BO_WRITER,0 ,2) }***)
									</a><img src="https://cafe.pstatic.net/levelicon/1/1_1.gif"
										width="11" height="11"> |&nbsp; <span
										style="font-size: 10pt; color: blue;">
										${bmVO.board_name}</span>
									<ul class="dropdown-menu">
										<c:if test="${LOGIN_MEMBER.mem_id !=viewInfo.BO_WRITER }">
											<li><a href="#"><span
													onclick="goChatModal('${viewInfo.MEM_NICKNAME }(${viewInfo.BO_WRITER})');">1:1
														채팅하기</span></a></li>
											<li><a href="#"><span
													onclick="goModal('${viewInfo.MEM_NICKNAME }(${viewInfo.BO_WRITER})');">쪽지보내기</span></a></li>
										</c:if>
										<li><a
											href="${pageContext.request.contextPath }/user/fishgram/fishgramYouList.do?mem_id=${viewInfo.BO_WRITER}">블로그가기</a></li>
									</ul>
								</div>
								<div id="note">${bo_content}</div>
								<input id="hidden" name="bo_content" type="text" value=""
									style="display: none;">
	
								<hr>
								<div id="beforeContent"
									style="padding: 20px 30px 20px 30px; height: auto; min-height: 300px; overflow: auto;">
									${bo_content }</div>
								<hr>
								<c:if test="${viewInfo.bo_writer != 'admin'}">
									<button id="recommend" type="button" style="margin-right: 20px"
										class="btn btn-info btn-sm">추천하기</button>
									<button id="black" type="button" class="btn btn-danger btn-sm">신고하기</button>
								</c:if>
							</div>
							<hr>
						</div>
					</form>
					<div class="box">
						<div class="dataTables_wrapper form-inline dt-bootstrap">
							<c:if test="${bmVO.board_function eq '0'}">
								<form id="insForm" method="post"
									action="${pageContext.request.contextPath }/user/imageboard/insertComment.do?commentPage=${commentPage}&currentPage=${currentPage}&search=${search}&keyword=${keyword}">
									<div class="input-group input-group-sm"
										style="margin: 40px 20px 0px 50px; width: 100%;">
										<textarea name="comment_content" class="form-control"
											style="margin-left: 10%; width: 60%; height: 80px;"></textarea>
										<input type="hidden" name="mem_id"
											value="${LOGIN_MEMBER.mem_id }"> <input type="hidden"
											name="bo_no" value="${viewInfo.BO_NO } "> <br>
										<button id="insCBtn" type="button"
											class="btn btn-info btn-flat pull-right"
											style="margin-right: 250px;">댓글등록</button>
									</div>
								</form>
								<div class="row">
									<div class="col-sm-12">
										<br>
										<table id="example1"
											class="table table-bordered table-striped dataTable">
											<thead>
												<tr role="row">
													<th class="sorting_asc" tabindex="0" rowspan="1"
														colspan="1" style="width: 70px; text-align: center;"></th>
													<th class="sorting" tabindex="0" rowspan="1" colspan="1"
														style="width: 500px;"></th>
													<th class="sorting" tabindex="0" rowspan="1" colspan="1"
														style="width: 20px;"></th>
													<th class="sorting" tabindex="0" rowspan="1" colspan="1"
														style="width: 20px;"></th>
												</tr>
											</thead>
											<tbody id="CommentBody">
												<c:forEach items="${imageboardCommentList }" var="comment">
													<tr role="row" class="odd">
														<td style="text-align: center;" class="sorting_1">
															<div class="dropdown">
																<a href="#" class=" dropdown-toggle"
																	data-toggle="dropdown"> <span
																	style="font-size: 10pt; color: blue;">
																		${comment.MEM_NICKNAME}</span></a>
																<ul class="dropdown-menu">
																	<c:if test="${LOGIN_MEMBER.mem_id !=comment.MEM_ID }">
																		<li><a href="#"><span
																				onclick="goChatModal('${comment.MEM_NICKNAME }(${comment.MEM_ID})');">1:1
																					채팅하기</span></a></li>
																		<li><a href="#"><span
																				onclick="goModal('${comment.MEM_NICKNAME }(${comment.MEM_ID})');">쪽지보내기</span></a></li>
																	</c:if>
																	<li><a
																		href="${pageContext.request.contextPath }/user/fishgram/fishgramYouList.do?mem_id=${comment.MEM_ID}">블로그가기</a></li>
																</ul>
															</div>
														</td>
														<td><input type="hidden" name="comment_no"
															value="${comment.COMMENT_NO}"> <textarea
																name="comment_content"
																style="width: 60%; border: none; background: transparent;"
																disabled="disabled">${comment.COMMENT_CONTENT}</textarea></td>
														<td style="text-align: center;"><p class="text-green">${comment.COMMENT_REG_DATE}</p></td>
														<td style="text-align: center;"><c:if
																test="${comment.MEM_ID == LOGIN_MEMBER.mem_id }">
																<button type="button" value="${comment.COMMENT_NO}"
																	class="bfCBtn btn btn-primary btn-sm ">
																	<span class="glyphicon glyphicon-pencil"></span>
																</button>
																<button type="button" value="${comment.COMMENT_NO}"
																	class="afCBtn btn btn-primary btn-sm ">
																	<span class="glyphicon glyphicon-pencil"></span>
																</button>
																<button type="button" onclick="delComment(this.value);"
																	value="${comment.COMMENT_NO}"
																	class="boardInfo btn btn-danger btn-sm">
																	<span class="glyphicon glyphicon-trash"></span>
																</button>
															</c:if></td>
													</tr>
												</c:forEach>
											</tbody>
											<tfoot>
												<tr>
													<td style="text-align: center;" class="sorting"
														tabindex="0" rowspan="1" colspan="4">
														<div class="form-group" style="width: 100%">
															${paging }</div>
													</td>
												</tr>
											</tfoot>
										</table>
									</div>
								</div>
								<br>
							</c:if>
							<button id="return" type="button"
								style="width: 140px; margin-right: 10px;"
								class="btn btn-info btn-sm bg-purple pull-right">목록</button>
							<button id="delBtn" type="button" value="${viewInfo.BO_NO }"
								style="width: 140px; margin-right: 10px;"
								class="btn btn-danger btn-sm pull-right">삭제</button>
							<button id="updateBtn" type="button"
								style="width: 140px; margin-right: 10px;"
								class="btn btn-info btn-sm pull-right">수정</button>
							<button id="finalUpdate" type="button"
								style="width: 140px; margin-right: 10px;"
								class="btn btn-info btn-sm pull-right">수정</button>
							<div class="row"></div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
<!-- /.content-wrapper -->
	
<!-- 추천하기 모달 -->
<div class="modal" id="recModal" tabindex="-1" role="dialog">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-body">
			<span style="color: green;">추천하시겠습니까 ? </span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button id="yes" type="button" class="btn btn-info">네</button>
				<button type="button" class="btn" data-dismiss="modal">닫기</button>
			</div>
		</div>
	</div>
</div>
	<!--추천하기 모달 끝  -->
<!-- 신고하기 모달 -->
<div class="modal" id="blModal" tabindex="-1" role="dialog">
	<div class="modal-dialog modal-md">
		<div class="modal-content">
			<div class="modal-header">
				<h2>신고하기</h2>
			</div>
			<div class="modal-body">
			<div id="pop_content" style="border: thin;">
            <dl>
			<dt>제&nbsp;&nbsp;&nbsp;목 :</dt>
            <dd style="color: blue;">${viewInfo.BO_TITLE }</dd>
            <dt>작성자 :</dt>
            <dd style="color: blue;">${viewInfo.MEM_NICKNAME }(${fn:substring(viewInfo.BO_WRITER,0 ,2) }***)</dd>
            <hr>
            <dt><span>사유선택</span> :</dt>
            <dd class="dd_type">
                <p class="desc5">여러 사유에 해당되는 경우, 대표적인 사유 1개를 선택해 주세요
                </p>
                <form id="sttemnt" method="post">
                <input type="hidden" name="mem_id" value="${LOGIN_MEMBER.mem_id }">
                <input type="hidden" name="bo_no" value="${viewInfo.BO_NO }">
                <ul class="list_type">
                    <li>
                        <input type="radio" name="reason" value="부적절한 홍보 게시글" class="input_rdo"><label for="rdo_illegal">&nbsp;부적절한 홍보 게시글</label>
                    </li>
                    <li>
                        <input type="radio" name="reason" value="음란성 또는 청소년에게 부적합한 내용" class="input_rdo"> <label for="rdo_obscenity">음란성 또는 청소년에게 부적합한 내용</label>
                    </li>
                    <li>
                        <input type="radio" name="reason"  value="명예훼손/사생활 침해 및 저작권침해등" class="input_rdo"> <label for="rdo_libel">명예훼손/사생활 침해 및 저작권침해등</label>
                    </li>
                    <li>
                        <input type="radio" name="reason" value="기타" class="input_rdo"> <label for="rdo_etc">기타</label>
                    </li>
                </ul>
                <hr>
                	해당 신고는 AIFishDr 운영자에게 전달됩니다.<br><br>
					우리 홈페이지 규정을 위반한 경우 관리자에게 문의해주세요.
					<hr>
                </form>
            </dd>
        </dl>
        </div>
			<span style="color: green;">신고하시겠습니까 ? </span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<button id="yes1" type="button" class="btn btn-info">네</button>
				<button type="button" class="btn" data-dismiss="modal">닫기</button>
			</div>
		</div>
	</div>
</div>
<!--추천하기 모달 끝  -->
</body>
<script type="text/javascript">
$(function(){
// 	var imgfileName = '${imgfileName}'.substring(17,34);
// 	if (imgfileName == 'noimage.png') {
// 	    $('#beforeContent > p > img').attr('src','');
// 	}
// 	var ss = $('#beforeContent').children().children().attr('src','');
// 	var ss = $('#beforeContent img').attr('src','');

	//본인 게시물 아닐 시 버튼 하이드
	if (eval('${LOGIN_MEMBER.mem_id != viewInfo.BO_WRITER }')) {
		$('#delBtn').hide(); //글 삭제버튼
		$('#updateBtn').hide();//글 수정버튼
		$('input[name=bo_title]').attr('readonly',true);
		$('#note').attr('readonly',true);
	}else{
		$('#recommend').hide();//추천버튼
		$('#black').hide();//신고
	}
	if (eval('${checkBlack}')) {
		$('#black').attr('disabled','disabled').text('이미 신고완료한 게시물입니다.');
	};
	
	$('#createFile').hide();
	$('.fileDelBtn').hide(); //파일 삭제버튼
	$('.afCBtn').hide();
	$('#return').click(function(){
		$(location).attr('href','${pageContext.request.contextPath}/user/imageboard/imageboardList.do?currentPage=${currentPage}&search=${search}&keyword=${keyword}');
	});
	
	$('#updateBtn').click(function(){
		$('#note').show();
	     $('#note').summernote({
	       height: 300,                 // 썸머노트 높이
	        minHeight: null,             // set minimum height of editor
	        maxHeight: null,             // set maximum height of editor
	        focus: false,        // set focus to editable area after initializing summernote
	        toolbar: [
	                  // [groupName, [list of button]]
	                  ['style', ['bold', 'italic', 'underline', 'clear']],
	                  ['font', ['strikethrough', 'superscript', 'subscript']],
	                  ['fontsize', ['fontsize']],
	                  ['color', ['color']],
	                  ['para', ['ul', 'ol', 'paragraph']],
	                  ['height', ['height']],
	                  ['picture']
	                ]
	  	 });
	    $('input[name=bo_title]').attr('style',''); 
	    $('#beforeContent').remove();
	    $('#finalUpdate').show();
	    $('.fileDelBtn').show(); 
	    $('#createFile').show();
	    $(this).hide(); 
	});
	$('#finalUpdate').hide(); 
	$('#note').hide();
	$('#insCBtn').click(function(){
		//정규식 적용
		if ($('textarea[name=comment_content]').val() == '') {
		alert('내용을 입력해 주세요');
			return;
		}
		$('#insForm').submit();
		
	});
	
	$('#delBtn').click(function(){
		var bo_no = $(this).val();
		$(location).attr('href','${pageContext.request.contextPath}/user/imageboard/deleteBoard.do?bo_no='+bo_no);
	});
	
	if (eval("${viewInfo[1].fileInfo eq '[]'}") ) {
		$('.show').remove();
	}
	$('input[name=bo_title]').attr('size', $('input[name=bo_title]').val().length);
	
	
	
	$('#finalUpdate').click(function(){
// 		var checkImage = $('.fileCheck').val();
// 		checkImage = checkImage.slice(checkImage.indexOf(".")+1).toLowerCase();
// 		console.log(checkImage);
// 		if (checkImage=="jpg"||checkImage=="png"||checkImage=="gif"||checkImage=="bmp") {
// 			alert('파일만 등록이 가능합니다.');
// 			return;
// 		}
		
		if ($('input[name=bo_title]').val() == '') {
			alert('제목을 입력해 주세요');
				return;
		}
		$('input[name=bo_content]').val($('#note').summernote('code'));
		var form = $('form')[0];
		var formData = new FormData(form);
		$.ajax({
			url: '${pageContext.request.contextPath}/user/imageboard/updateBoard.do',
			processData: false,
			contentType: false,
			data: formData,
			type: 'POST',
			success: function(result){
			    alert("수정 완료되었습니다.");
   	 			$(location).attr('href','${pageContext.request.contextPath}/user/imageboard/imageboardList.do?currentPage=${currentPage}&search=${search}&keyword=${keyword}');
			 }
		});
		
	});
	$('#createFile').click(function(){
		var cnt = $('.downBtn').length;
		var fileCnt = $('.btnDel').length;
		if (cnt+fileCnt==5) {
			alert("더 이상 파일을 추가할 수 없습니다.");			
		}else{
			var html = '<tr>';
			html += '<td height="45"><input type="file" class="fileCheck" name="files" style="float:left;"><button class="btnDel btn-sm btn-danger" type="button">삭제</button></button>';
			html += '</td></tr>';
			$("#list").append(html); 
		}
	});
			  
	$("#list").on("click", ".btnDel", function() { 
		 $(this).parent().parent().remove();
	});  
	$('.bfCBtn').click(function(){
		var num = $(this).val();
		$('#CommentBody').children().find('button[value='+num+']').parents('tr').children().find('textarea').attr('disabled',false).css('background','#F9E5EE');
		$(this).hide();
		$(this).siblings(".afCBtn").show();
	});
	$('.afCBtn').click(function(){
		var num = $(this).val();
		var content = $('#CommentBody').children().find('button[value='+num+']').parents('tr').children().find('textarea').val();
		$('#CommentBody').children().find('button[value='+num+']').parents('tr').children().find('textarea').attr('disabled',true).css('background','transparent');
		$.ajax({
			url: '${pageContext.request.contextPath}/user/imageboard/updateComment.do',
			data: "comment_no="+num+"&comment_content="+content,
			type: 'POST',
			success: function(result){
				$('#CommentBody').children().find('button[value='+num+']').parents('tr').children().find('textarea').attr('disabled',true).css('background','transparent');
				alert('댓글 수정 성공');
			 },
			 error : function(res){
				 alert(res.status);
			 }
		});
		$(this).hide();
		$(this).siblings('.bfCBtn').show();
		
	});
	
	$('#recommend').click(function(){
		$('#recModal').modal();
		$('#yes').click(function(){
			$.ajax({
				url : '${pageContext.request.contextPath}/user/imageboard/imageboardrecommend.do?bo_no=${viewInfo.BO_NO }',
				type : 'POST',
				dataType : 'json',
				success : function(data){
					alert("게시글을 추천하였습니다.");
					$('#recommend').attr('disabled','disabled');
					$('#recModal').modal('hide');
				},error : function(res){
					alert(res.status);
				}
			});
		});
	   	
	});
	$('#black').click(function(){
		$('#blModal').modal();
		$('#yes1').click(function(){
			if ($('input:radio[name=reason]').is(':checked')) {
				
				var data = $('#sttemnt').serialize();
				$.ajax({
					url : '${pageContext.request.contextPath}/user/imageboard/imageboardblack.do',
					data : data,
					success : function(result){
						alert("신고가 완료되었습니다.");
						$('#black').attr('disabled','disabled').text('이미 신고완료한 게시물입니다.');
						$('#blModal').modal('hide');
					},
					error : function(res){
						alert(res.status);
					}
				});
			}else{
				alert('신고사유를 선택 해주세요');
				return;
			}
			
		});
	   	
	});
	
});
function goModal(value){
	var x = (screen.availWidth - 500) / 2;
	var y = (screen.availHeight - 400) / 2;
	var info = encodeURIComponent(value);
	var url = "${pageContext.request.contextPath }/user/imageboard/messageModal.do?id="+info;
	var options = "width = 500, height = 400, scrollbars = no left="+x+", top="+y;
	window.open(url, "쪽지보내기", options);
}
function goChatModal(value){
	var x = (screen.availWidth - 500) / 2;
	var y = (screen.availHeight - 650) / 2;
	var info = encodeURIComponent(value);
	var url = "${pageContext.request.contextPath }/user/freeboard/chatModal.do?id="+info;
	var options = "width = 500, height = 650, scrollbars = no left="+x+", top="+y;
	window.open(url, "채팅하기", options);
}
function auto_size(fname,fsize){
	if (fsize == 100) {
		return;		
	}
	fname.size = fname.size+1;
}
function delComment(comment_no){
	$.ajax({
		url : '${pageContext.request.contextPath}/user/imageboard/deleteComment.do?comment_no='+comment_no,
		success : function(data){
			$('#CommentBody').children().find('button[value='+comment_no+']').parents('tr').empty();
			alert('댓글 삭제 성공');
		},
		error : function(res){
			alert(res.status);
		}
	});
	
};
// function deleteFile(value){
// 	$.ajax({
// 		url : '${pageContext.request.contextPath}/user/freeboard/deleteFile.do?file_no='+value,
// 		success : function(data){
// 		 	$('.show').children().find('button[value='+value+']').parents('tr').empty();
// 		 	$('div[id='+value+']').remove();
// 			alert("해당 사진이 삭제되었습니다.");
// 		},
// 		error : function(res){
// 			alert(res.status);
// 		}
// 	});
// };
     </script>
</html>
