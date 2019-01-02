<%--==============================================================
 * jsp 개요 : 
 * @author : 
 * @since : 2018. 11. 17.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일                          수정자                       수정내용
 *    -------      -------     -------------------
 *    2018. 11. 17.        진형용                      최초작성
 * Copyright (c) 2018 AI Fish Dr. All right reserved
 * </pre>
===============================================================--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko"><head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쪽지 쓰기 </title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/bower_components/morris.js/morris.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/bower_components/bootstrap/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/bower_components/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/bower_components/Ionicons/css/ionicons.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/dist/css/AdminLTE.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/dist/css/skins/_all-skins.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.css" rel="stylesheet">
<script src="${pageContext.request.contextPath }/bower_components/chart.js/Chart.js"></script>
<script src="${pageContext.request.contextPath }/bower_components/raphael/raphael.min.js"></script>
<script src="${pageContext.request.contextPath }/bower_components/jquery/dist/jquery.min.js"></script>
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.js"></script>
<script src="${pageContext.request.contextPath }/bower_components/morris.js/morris.min.js"></script>
<script src="${pageContext.request.contextPath }/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/bower_components/fastclick/lib/fastclick.js"></script>
<script src="${pageContext.request.contextPath }/dist/js/adminlte.min.js"></script>
<style type="text/css">
.pop_header,.pop_content{margin-left: 70px;}
</style>
</head>
<body>
<!-- [D]쪽지쓰기 팝업 390px 윈도우의 크기를 390으로 띄워주세요. -->
	<div class="pop_header">
		<h1>쪽지 쓰기 </h1>
	</div>
	<div class="pop_content">
		<div class="note_write">			
			<div class="send_window">
				<div class="toady_sent">
				</div>
				<div id="replyMode" style="display: block;">
					<span class="tf_tit">
						<span class="recipient">받는사람</span>
					</span>
						<span class="tf_cont">
						<a id="reply_id" href="#" class="">${id }</a>
					</span>
				</div>
				<br>
				<form method="post">
				<div class="writing_area">
					<textarea id="writeNote" name="ms_content" style="resize:none;"  rows="10" cols="55" title="쪽지 내용을 입력해 주세요."></textarea>
				</div>
				<div class="writing_option">
					<div class="character">
						<span id="content"></span> 
				</div>
			</div>
				<input type="hidden" value="${fn:substring(id, fn:indexOf(id,'(')+1,fn:length(id)-1)  }" name="me_get_id">
				<input type="hidden" value="${LOGIN_MEMBER.mem_id }" name="ms_send_id">
				</form>
				
			<div class="btns">				
				<a href="#"><button id="closeBtn" class="btn btn-info pull-right" style="margin-right: 80px;" type="button">닫기</button></a>
				<a href="#"><button  id="sendBtn" class="btn btn-info pull-right" 
				value="${fn:substring(id, fn:indexOf(id,'(')+1,fn:length(id)-1)  }" style="margin-right: 30px;" type="button">보내기</button></a>
			</div>
		</div>   
</div>

</body>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
$(function(){
	//쪽지 글자 수 제한
    $('#writeNote').keyup(function (e){
        var content = $(this).val();
        if (content.length > 300){
    	    alert("최대 300자까지 입력 가능합니다.");
    	    $(this).val(content.substring(0, 300));
    	    return;
    	}
        $('#content').html(content.length + '/300');
    });
    $('#writeNote').keyup();
    
    
	ws = new WebSocket("ws://211.194.156.81/AIFishDr/wsMsg");
	
// 	ws.onopen = function(){
// 	};
// 	ws.onmessage = function(message){
// 	};
	
	$('#sendBtn').click(function(){
		var chk = $('#writeNote').val();
		if (chk=='') {
			alert("내용을 입력해 주세요.");
			return;
		}
		var data = $('form').serialize();
		$.ajax({
			url : '${pageContext.request.contextPath}/user/message/sendMsg.do',
			data : data,
			type : 'POST',
			success : function(data){
				if (eval(data.result)) {
					alert("쪽지 전송 완료");
					ws.send('#msg#');
				}
			},error : function(res){
				alert(res.status);
			},complete : function(){
				$('#closeBtn').click();
			}
		})
		
		
	})
    
	$('#closeBtn').click(function(){
		window.opener.location.reload();  
		self.close(); 
	})
});
// function postToServer(msg) {
// 	var ss =$('#msg1').val();
// 	ws.send(ss);
// }
// function closeConnection() {
// 	ws.close();
// }
</script>
</html>