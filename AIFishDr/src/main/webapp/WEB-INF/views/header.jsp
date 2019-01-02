
<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>AI Fish Dr.</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/bower_components/morris.js/morris.css">
<!-- Bootstrap 3.3.7 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/bower_components/bootstrap/dist/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/bower_components/font-awesome/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/bower_components/Ionicons/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/dist/css/skins/_all-skins.min.css">
<!-- bootstrap wysihtml5 - text editor -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
<script
	src="${pageContext.request.contextPath }/bower_components/chart.js/Chart.js"></script>
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
<script
	src="${pageContext.request.contextPath }/bower_components/raphael/raphael.min.js"></script>
<!-- Google Font -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
<!-- jQuery 3 -->
<script
	src="${pageContext.request.contextPath }/bower_components/jquery/dist/jquery.min.js"></script>
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.9/summernote.js"></script>
<script
	src="${pageContext.request.contextPath }/bower_components/morris.js/morris.min.js"></script>
<!-- 순서 바뀌면 안됨  -->
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jsbn.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/rsa.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/prng4.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/rng.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/validation.js"></script>
<style type="text/css">
.head_ul {
    list-style:none;
    margin:0;
    padding:0;
}
.head_li {
    margin: 0 0 0 0;
    padding: 0 0 0 0;
    border : 0;
    float: left;
}</style>
</head>
<body class="hold-transition skin-blue sidebar-mini" >
	<div class="wrapper">
		<header class="main-header">
			<!-- Logo -->
			<a href="#" class="logo">
				<span class="logo-mini" id = "logoMiniClick"><img width="30" height="30" src="${pageContext.request.contextPath }/dist/img/aiDoctor.png"></span>
				
				<!-- mini logo for sidebar mini 50x50 pixels --> <!-- logo for regular state and mobile devices -->
				<span class="logo-lg" id = "logoLgClick"> <img width="30" height="30" src="${pageContext.request.contextPath }/dist/img/aiDoctor.png">
					<b>AI Fish</b> Dr
				</span>
			</a>
			
			<!-- Header Navbar: style can be found in header.less -->
			<nav class="navbar navbar-static-top">
				<!-- Sidebar toggle button-->
				<a href="#" class="sidebar-toggle" data-toggle="push-menu"
					role="button"> <span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
				</a>
				<span id="on" class="nav navbar-nav" style="padding-top: 10px;">
				
				<button id="btn-micOn" class="off" style="background-color: transparent; border: none;">
				<i class="fa fa-fw fa-microphone"></i>
				<button id="btn-micOff" class="off" style="background-color: transparent; border: none;">
				<i class="fa fa-fw fa-microphone-slash"></i>
				
				</button></span>
				
				
<!-- 				<button id="btn-mic" class="off" ></button> -->
				


				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
						<div class="topbar-main">
							<c:if test="${!empty LOGIN_MEMBER }">
								<div class="logoutForm">
									<ul class="head_ul nav navbar navbar-top-links navbar-right mbn">
										<li class="head_li"><a href="${pageContext.request.contextPath }/user/message/messageList.do"
											class="dropdown-toggle"> <i class="fa fa-bell-o" style="margin-top: 8px;">
											<span id="msgCnt" class="label label-warning" ></span></i>
											<span id="showMessage"></span>
											
											</a>
										</li>
										<li class="head_li">
										<button type="button" id="logout"
													class="btn btn-warning btn-sm" style="margin: 10px 30px 10px 10px;">로그아웃</button>
										</li>

									</ul>
								</div>
							</c:if>
							<c:if test="${empty LOGIN_MEMBER }">
								<div class="loginForm nav navbar navbar-top-links navbar-right"
									style="padding: 10px;">
									<div style="margin-right: 20px;">
										<button id="logingBtn" type="button"
											class="btn btn-warning btn-sm">로그인</button>
										<button id="insertMember" type="button"
											class="btn btn-info btn-sm">회원가입</button>
									</div>
								</div>
							</c:if>
						</div>
					</ul>
				</div>
			</nav>
		</header>
<div class="modal" id="callChat" tabindex="-1" role="dialog">
	<div class="modal-dialog modal-md">
		<div class="modal-content">
			<div class="modal-body">
			<span style="color: green; font-size: 15pt;">채팅 신청이 도착하였습니다. 수락하시겠습니까? </span>
			</div>
	    <div class="modal-footer">
               <button id="confirm" value="" onclick="confirmChat(this.value);" type="button" class="btn btn-info">수락</button>             
          <button type="button" class="btn btn-danger" data-dismiss="modal">닫기</button>
        </div>
		</div>
	</div>
</div>
      
</body>
<script type="text/javascript">
var ws;
$(function() {
	
	goToMainPage = function(){
		
		var profileStatus = '${params.myProfileStatus}';
		var fp_file_save_name = '${params.fp_file_save_name}';
		var loginStatus = "y";
			
		if (eval("${LOGIN_MEMBER.mem_position eq 'mem'}")||eval('${empty LOGIN_MEMBER}')) {
			
			$(location).attr('href', '${pageContext.request.contextPath}/main.do?profileStatus=' + profileStatus + '&fp_file_save_name=' + fp_file_save_name + '&loginStatus=' + loginStatus);
			
		} else {
			
			$(location).attr('href', '${pageContext.request.contextPath}/admin/stats/statsList.do');
			
		}
		
	};
	
	
	$('#logoLgClick').click(function() {
		
		goToMainPage();
				
	});
	
	
	$('#logoMiniClick').click(function(){
		
		goToMainPage();
		
	});
	
	
	$('#logingBtn').click(function() {
		$(location).attr('href','${pageContext.request.contextPath}/nouser/join/loginForm.do');
	});
	$('#logout').click(function() {
		$(location).attr('href','${pageContext.request.contextPath}/nouser/join/logOut.do');
	});
	$('#insertMember').click(function() {
		$(location).attr('href','${pageContext.request.contextPath}/nouser/insertMember/insertMemberForm.do');
	});
	////웹알티씨 음성인식
	if (typeof webkitSpeechRecognition !== 'function') {
	    alert('크롬에서만 동작 합니다.');
	    return false;
	  }

	  let isRecognizing = false;
	  let ignoreEndProcess = true;
	  
	  const recognition = new webkitSpeechRecognition();
	  const language = 'ko-KR';
	  const $btnMic = $('#btn-micOn');
// 	  const $btnmicOff = $('#btn-micOff');
	  
	  recognition.continuous = true;
	  recognition.interimResults = true;

	  /**
	   * 음성 인식 시작 처리
	   */
	  recognition.onstart = function() {
	    console.log('onstart', arguments);
	    isRecognizing = true;
	    
	    
	  };
	  /**
	   * 음성 인식 종료 처리
	   * @returns {boolean}
	   */
	  recognition.onend = function() {
	    console.log('onend', arguments);
	    
	    if(ignoreEndProcess == true){
	    	$('#btn-micOn').click();
		    $btnMic.attr('class', 'on');
		    
	    }else{
	    	$btnMic.attr('class', 'off');
	    	ignoreEndProcess = true;  
	    }
	    
	    isRecognizing = false;
	    
	  };
	  
	  /**
	   * 마이크 끄기 버튼 클릭 이벤트
	   * @returns {boolean}
	   */
	  $('#btn-micOff').click(function(){
		  if (isRecognizing) {
			  recognition.stop();
			  $('#btn-micOn').show();
			  $('#btn-micOff').hide();
			  ignoreEndProcess =false;
		  }else{ 
			    $('#btn-micOn').show();
			    $('#btn-micOff').hide();
			    
			    ignoreEndProcess =false;
			  
		  }
	  });

	  /**
	   * 음성 인식 결과 처리
	   * @param event
	   */
	    var finalTranscript = '';
	    var interimTranscript = '';
	  recognition.onresult = function(event) {
	    console.log('onresult', event);
	    

	    for (var i = event.resultIndex; i < event.results.length; ++i) {
	      if (event.results[i].isFinal) {
		     finalTranscript += event.results[i][0].transcript;
	      } else {
		     interimTranscript += event.results[i][0].transcript;
	      }
	    }
 		//포커스된  객체!
	   fireCommand(interimTranscript);
	    console.log('interimTranscript',interimTranscript);
	    console.log('finalTranscript',finalTranscript);
	    var $focused = $(':focus');
	    if (interimTranscript.endsWith('지워')||finalTranscript.endsWith('지워')) {
		    interimTranscript = '';
	    	finalTranscript = '';
	    	$focused.val('');
	    	if ($focused.attr('name') != 'bo_title') {
				$('#note').summernote('code', '');
			};
		}
	    var title = '';
	    var content = '';
	    if (interimTranscript.endsWith('제목')||finalTranscript.endsWith('제목')) {
	    	interimTranscript = '';
	    	finalTranscript='';
			title = '';
		}else{
			
			title = finalTranscript;
		}
	   
	    if (interimTranscript.endsWith('내용')||finalTranscript.endsWith('내용')) {
	    	interimTranscript = '';
	    	finalTranscript='';
			content = '';
		}else{
			
		    content = finalTranscript;
		}
	    
	    resultText(finalTranscript,title,content);
		
	  };
	  resultText = function(finalTranscript,title,content){
		interimTranscript='';
	 	var $focused = $(':focus');
		console.log('title',title);
	 	if($focused.attr('name') == 'bo_title'){
				$('input[name=bo_title]').val(finalTranscript);
// 			if (finalTranscript =='') {
// 				var t = $('input[name=bo_title]').val();
// 				finalTranscript = t;
				return;
// 			else{
// 				$('input[name=bo_title]').val(title);
// 			}
		}else{
			//var c = $('textarea[name=bo_content]').val();
				$('#note').summernote('code',finalTranscript);
// 			if (finalTranscript =='') {
// 				finalTranscript = c;
// 				return;
// 			}else{
// 				$('#note').summernote('code',content);
// 			}
// 			$focused.val(finalTranscript);
		};
		 
	  }
	  
	  /**
	   * 명령어 처리
	   * @param string
	   */
	  function fireCommand(string) {
// 		 string = string.replace(/' '/gi, "") ;
		 string = string.replace(/(\s*)/g,"");
		<c:forEach var="list" items="${BOARD_INFO }">
			if (string.endsWith('${list.board_name}')){
				$(location).attr('href','${pageContext.request.contextPath}/user/${list.board_eng_name}/${list.board_eng_name}List.do');
				return;
			}	
		</c:forEach>		
		
			if (string.endsWith('글쓰기')) {
				$('#insertBtn').click();
			}else if (string.endsWith('제목')) {
				$('input[name=bo_title]').focus();
			}else if (string.endsWith('내용')) {
				$('#note').summernote( {focus: true} );
			}else if (string.endsWith('지워')) {
			 	finalTranscript = '';
				interimTranscript = '';
			}else if(string.endsWith('등록')){
				$('#insertBtn').click();
			}else if(string.endsWith('목록')){
				$('#return').click();
			}else if(string.endsWith('사진')){
				$('.note-picture').children().children().click();
			}else if(string.endsWith('마이크꺼라')){
				$('#btn-micOff').click();
			}
			
			
		//==========================회원전용 페이지======================================
		   
			
			
			else if(string.endsWith('로그아웃')){
				$(location).attr('href','${pageContext.request.contextPath}/nouser/join/logOut.do');
			}
			
			else if(string.endsWith('회원정보수정')){
				$(location).attr('href','${pageContext.request.contextPath}/user/member/memberUpdateView.do');
			}
			else if(string.endsWith('탈퇴')){
				$('#outBtn').click();
			}
			else if(string.endsWith('회원수정')){
				$('#updateBtn').click();
			}
			else if(string.endsWith('쪽지')){
				$(location).attr('href','${pageContext.request.contextPath}/user/message/messageList.do');
			}
			else if(string.endsWith('받은쪽지')){
				$(location).attr('href','${pageContext.request.contextPath}/user/message/messageList.do');
			}
			else if(string.endsWith('보낸쪽지')){
				$(location).attr('href','${pageContext.request.contextPath}/user/message/sendMessageList.do');
			}
			else if(string.endsWith('쪽지쓰기')){
				$(location).attr('href','${pageContext.request.contextPath}/user/message/sendMessage.do');
			}
		//==========================의약품 서비스=============================================
			
			else if(string.endsWith('검색')){
				$(location).attr('href','${pageContext.request.contextPath}/user/mdcin/mdcinList.do');
			}
			else if(string.endsWith('처방')){
				$(location).attr('href','${pageContext.request.contextPath}/user/aiDoctor/aiDoctor.do');
			}
			
		//===========================AI응답 서비스====================================================
			else if(string.endsWith('응답서비스')){
				$(location).attr('href','${pageContext.request.contextPath}/user/aiService/aiService.do');
			}
		//===========================어류 질병 정보======================================================
			else if(string.endsWith('어류질병정보')){
				$(location).attr('href','${pageContext.request.contextPath}/user/fishDiss/fishDiss.do');
			}
		//===============================위치정보서비스=====================================================
			else if(string.endsWith('위치')){
				$(location).attr('href','${pageContext.request.contextPath}/user/hospital/hospitalService.do');
			}
	  }

	  /**
	   * 음성 인식 트리거
	   * @param event
	   */
	  function start(event) {
		
		  
	    $('#btn-micOff').show();
	    $('#btn-micOn').hide();
		recognition.lang = language;
	    recognition.start();
	  }

	  /**
	   * 초기 바인딩
	   */
	  function initialize() {
	    $btnMic.click(start);
	  }
		
	  initialize();
		
	  $('#btn-micOff').hide();
	  
 //	$('#btn-micOn').click();
// 	$('#btn-mic').show();
// 	  /**
// 	   * 음성 인식 에러 처리
// 	   * @param event
// 	   */
// 	  recognition.onerror = function(event) {
// 	    console.log('onerror', event);

// 	    if (event.error.match(/no-speech|audio-capture|not-allowed/)) {
// 	      ignoreEndProcess = true;
// 	    }
// 	    $btnMic.attr('class', 'off');
// 	  };
	

	ws = new WebSocket("ws://211.194.156.81/AIFishDr/wsMsg");
	
	ws.onopen = function(){
		notify();
	}
	ws.onmessage = function(message){
		console.log('message',message);
		if (message.data=='#msg#') {
			notify();
		}else{
			var data = message.data.split(',');
			console.log(data);
			if (data[0]=='${LOGIN_MEMBER.mem_id}') {
				$('#callChat').modal({backdrop : 'static'});
				$('#confirm').val('${LOGIN_MEMBER.mem_nickname}('+data[1]+')');
			};
		}
	}
	
	notify = function(){
		var currentMsgCnt = $('#msgCnt').text();
		currentMsgCnt = parseInt(currentMsgCnt);
		if (eval('${!empty LOGIN_MEMBER}')) {
			$.ajax({
				url : '${pageContext.request.contextPath}/admin/member/checkMsg.do',
				data : 'mem_id=${LOGIN_MEMBER.mem_id}',
				success : function(data){
					$('#msgCnt').text(data.cnt);
					if (data.cnt > currentMsgCnt) {
						$('#msgCnt').text(data.cnt);
						textToSpeech("새로운 쪽지가 도착했습니다. 확인해 주세요.");
						$('#showMessage').text('쪽지가 도착했습니다!');
						console.log('succcess');
					}
				},error : function(res){
					alert(res.status);
				}
			});
		};
	}
	
	ws.onerror = function(){
		ws.open();
	};
	
});
function confirmChat(value){
	$('#callChat').modal('hide');
	var x = (screen.availWidth - 500) / 2;
	var y = (screen.availHeight - 650) / 2;
	var info = encodeURIComponent(value);
	var url = "${pageContext.request.contextPath }/user/freeboard/chatModal.do?id="+info;
	var options = "width = 500, height = 650, scrollbars = no left="+x+", top="+y;
	window.open(url, "채팅하기", options);
}
function textToSpeech(text) {
	 console.log('textToSpeech', arguments);
	 speechSynthesis.speak(new SpeechSynthesisUtterance(text));
}
function postToServer(msg) {
	ws.send('#msg#');
}
function closeConnection() {
	ws.close();
	ws.open();
}
</script>
</html>



