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
<title>1:1채팅 </title>
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
.chat{margin: 20px 30px 20px 30px;}
</style>
</head>
<body>

<div class="chat box box-success direct-chat direct-chat-success" style="width: 90%; height: 600px;">
            <div class="box-header with-border" >
              <h3 class="box-title"><i class="fa fa-fw fa-wechat"></i>1:1채팅</h3>
              <button type="button" class="btn btn-info btn-sm pull-right" onclick="closeModal();" >나가기</button>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <!-- Conversations are loaded here -->
              <div id="messageView" class="direct-chat-messages" style="height: 500px; background-color: #E0F8F7;">
              
              <!--왼쪽 상대방 메세지  -->
<!--                 <div class="direct-chat-msg"> -->
<!--                   <div class="direct-chat-info clearfix"> -->
<!--                     <span class="direct-chat-name pull-left">Alexander Pierce</span> -->
<!--                     <span class="direct-chat-timestamp pull-right">23 Jan 2:00 pm</span> -->
<!--                   </div> -->
<!--                   <img class="direct-chat-img" src="../dist/img/user1-128x128.jpg" alt="Message User Image">/.direct-chat-img -->
<!--                   <div class="direct-chat-text"> -->
<!--                     Is this template really for free? That's unbelievable! -->
<!--                   </div> -->
<!--                 </div> -->
                <!--왼쪽 상대방 메세지  끝 -->
                
                
                

                   <!--오른쪽 내 메세지   -->
<!--                 <div class="direct-chat-msg right"> -->
<!--                   <div class="direct-chat-info clearfix"> -->
<!--                     <span class="direct-chat-name pull-right">Sarah Bullock</span> -->
<!--                     <span class="direct-chat-timestamp pull-left">23 Jan 2:05 pm</span> -->
<!--                   </div> -->
<!--                   <img class="direct-chat-img" src="../dist/img/user3-128x128.jpg" alt="Message User Image">/.direct-chat-img -->
<!--                   <div class="direct-chat-text"> -->
<!--                     You better believe it! -->
<!--                   </div> -->
<!--                 </div> -->
             <!--오른쪽 내 메세지 끝   -->
                
                
              </div>
            </div>
            <!-- /.box-body -->
            <div class="box-footer" style="background-color: #FBFBEF;">
            <input type="hidden" id="member_id" value="${fn:substring(id, fn:indexOf(id,'(')+1,fn:length(id)-1)  }">
                <div class="input-group">
                  <input id="write" onkeypress="keypress();" type="text" name="message" placeholder="내용을 입력해주세요" class="form-control">
                      <span class="input-group-btn">
                        <button id="sendButton" type="button"  class="btn btn-success btn-flat">전송</button>
                      </span>
                </div>
            </div>
            <!-- /.box-footer-->
            
          </div>
<!-- </div> -->
<!-- </div> -->
		
</body>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
$(function(){
	keypress = function(){
		if (window.event.keyCode == 13) {
			  $('#sendButton').click();
	   }
	};
	
	
	 $('#messageView').empty();
	//시 분 구하기 
	var date = new Date();
	var hour = date.getHours();
	var min = date.getMinutes();
	if(hour < 12){ 
		hour = '오전' + hour;  
	} else{
		hour = '오후' + (hour-12);
	}
	
	if(min < 10){ 
		min = '0' + min; 
	} 
	
	
	
	
	var result = false;
	var memArray = new Array(); 
	var nickName = new Array(); 
	
	var member_id = $('#member_id').val();
	<c:forEach items="${ON_MEMBER}" var="list">
		memArray.push("${list.mem_id}");
		nickName.push("${list.mem_nickname}");
	</c:forEach>
	
	var nick = '';
	for (var i = 0; i < memArray.length; i++) {
		var chk_id = memArray[i];
		if (chk_id == member_id) {
			result = true;
			nick = nickName[i];
		}
	}

	
	if (!result) {
		var code = '';
           code+='  <div class="direct-chat-msg"> ';
           code+='    <div class="direct-chat-info clearfix"> ';
           code+='      <span class="direct-chat-timestamp pull-right">'+hour+ ':' +min+'</span> ';
           code+='     </div> ';
           code+='    <img class="direct-chat-img" src="${pageContext.request.contextPath}/dist/img/aiDoctor.png" >';
           code+='     <div class="direct-chat-text"> ';
           code+='       현재 사용자가  접속중이 아닙니다. ';
           code+='     </div> ';
           code+='  </div> '; 
           $('#messageView').append(code);
	}else{
		var code = '';
        code+='  <div class="direct-chat-msg"> ';
        code+='    <div class="direct-chat-info clearfix"> ';
        code+='      <span class="direct-chat-timestamp pull-right">'+hour+ ':' +min+'</span> ';
        code+='     </div> ';
        code+='    <img class="direct-chat-img" src="${pageContext.request.contextPath}/dist/img/aiDoctor.png" >';
        code+='     <div class="direct-chat-text"> ';
        code+='       대화를 시작합니다. ';
        code+='     </div> ';
        code+='  </div> '; 
        $('#messageView').append(code);
	}
    
	ws = new WebSocket("ws://211.194.156.81/AIFishDr/wsMsg");
	
	 ws.onopen = function(){
	}; 
	ws.onmessage = function(message){
		console.log('test',message);
		var id = message.data.split(',');
		var my_id = id[1];
		var finalMsg = id[2];
		
		var code = '';
		if (my_id == '${LOGIN_MEMBER.mem_id}') {
	        code+='  <div class="direct-chat-msg right"> ';
	        code+='    <div class="direct-chat-info clearfix"> ';
	        code+='      <span class="direct-chat-timestamp pull-right">'+hour+ ':' +min+'</span> ';
	        code+='     </div> ';
		}else{
			code+='  <div class="direct-chat-msg"> ';
			code+='    <div class="direct-chat-info clearfix"> ';
	        code+='      <span class="direct-chat-name pull-left">'+nick+'</span>';
		    code+='      <span class="direct-chat-timestamp pull-right">'+hour+ ':' +min+'</span> ';
		    code+='     </div> ';
		    code+='    <img class="direct-chat-img" src="${pageContext.request.contextPath}/dist/img/aiDoctor.png" >';
		}
        code+='     <div class="direct-chat-text"> ';
        code+=          finalMsg;
        code+='     </div> ';
        code+='  </div> '; 
        $('#messageView').append(code);
        $("#messageView").scrollTop($("#messageView")[0].scrollHeight);
        $('#write').val('');
	};
	
	$('#sendButton').click(function(){
		var chk = $('#write').val();
		if (chk=='') {
			alert("내용을 입력해 주세요.");
			return;
		}
		var mem_id = $('#member_id').val();
		var array = new Array();
		array.push(mem_id);
		array.push('${LOGIN_MEMBER.mem_id}');
		array.push(chk);
		ws.send(array);
	});
    
});

function closeModal(){
	window.opener.location.reload();  
	self.close();
}
</script>
</html>