<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>AI Fish Dr | Log in</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
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
	href="${pageContext.request.contextPath }/dist/css/AdminLTE.css">
<!-- iCheck -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/plugins/iCheck/square/blue.css">

<script type="text/javascript"
	src="http://code.jquery.com/jquery-latest.js"></script>
<!-- 암복호화   -->
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

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

<!-- Google Font -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">

<script type="text/javascript"
	src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.2.js"
	charset="utf-8"></script>
<!--   <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script> -->
<style type="text/css">
html,div,body,h3 {
	margin: 0;
	padding: 0;
}

h3 {
	display: inline-block;
	padding: 0.6em;
}
body{
/* 	background-image:url("../../images/rr.jpg") !important; */
	background-image:url("../../images/tt.jpg") !important;
	background-size: 1900px 1200px !important;
}  
#loginF1{
	background-color:#58D3F7;
	border-radius: 10px;
}
#loginF2{
	background-color:#58D3F7;
	border-radius: 10px; 
}
</style>
</head>
<body  class="hold-transition login-page">
<input type="hidden" id="checkCode" value="">
<input type="hidden" id="idSearch" value="">
	<div id="loginF1" class="login-box"  >
		<div class="login-logo" style="width:100%;" >
			<a href="${pageContext.request.contextPath }/main.do">
					<label  style="cursor:pointer; font-size:40px; margin-top:20px;">A.I Fish Dr</label>
			</a>
		</div>
		<!-- /.login-logo -->
		<div id="loginF2" class="login-box-body" style=" height: 340px; width:100%;">
		
			<form
				action="${pageContext.request.contextPath }/nouser/join/loginCheck.do" name="loginForm"
				method="post">

				<div class="form-group has-feedback">
					<input name="mem_id" type="text" class="form-control" id="iiiiid"
						placeholder="ID" onkeyup="enterkey();"> <span
						class="glyphicon glyphicon-envelope form-control-feedback"></span>
				</div>


				<div class="form-group has-feedback">
					<input name="mem_pwd" type="password" class="form-control" id="pppppw"
						placeholder="Password" onkeyup="enterkey();"> <span
						class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="row" style="margin-left:3px;">
					<div class="col-xs-8" style="float:left;">
						<div class="checkbox icheck" style="background-color:white; width:10%; float:left;">
								<input type="checkbox" > 
						</div>
						<label style="margin-top:10px; margin-left:5px;">아이디 저장</label>
						<!-- /.col -->
					</div>
					<div class="col-xs-4"  >
						<button id="loginBtn22"  type="button" class="btn btn-primary btn-block btn-flat">로그인</button>
					</div>
				</div>
				<!-- /.col -->
			</form>
		
			<div class="social-auth-links text-center" style="float:left; width:100%;">
				<!--       <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i> 네이버 소셜 로그인</a> -->
				<!-- 	  <div id="naver_id_login" style="text-align:center"> -->
				<a href="${pageContext.request.contextPath }/naver/login.do"> <img
					width="90%;" 
					src="https://developers.naver.com/doc/review_201802/CK_bEFnWMeEBjXpQ5o8N_20180202_7aot50.png" /></a>
			</div>

			<div class="container" style="width:100%;">
				<!-- Trigger the modal with a button -->
				<button type="button" style="width: 46%;"
					class="btn btn-info btn-lg" data-toggle="modal"
					data-target="#myModal">ID 찾기</button>
				<button type="button" style="margin-left: 17px; width: 46%;"
					class="btn btn-info btn-lg" data-toggle="modal"
					data-target="#myModal1" ><b>PW 찾기</b></button>
			</div>
		</div>
	</div>
	<!-- /.social-auth-links -->


	<!-- ID찾기 Modal -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h3 class="modal-title" style="text-align: center;">ID 찾기</h3>
				</div>
				<div class="modal-body">



					<div class="box box-info">
						<div class="box-header with-border">
							<h4 class="box-title">이름과 이메일을 입력해주세요.</h4>
						</div>
						<!-- /.box-header -->
						<!-- form start -->
						<form class="form-horizontal">
							<div class="box-body">
								<div class="form-group">
									<label for="inputPassword3" class="col-sm-2 control-label">이름 :</label>

									<div class="col-sm-4">
										<input type="text" class="form-control" id="IDName"
											placeholder="이름을 입력하세요..">
									</div>
								</div>
								<div class="form-group">
									<label for="inputEmail3" class="col-sm-2 control-label">Mail :</label>

									<div class="col-sm-6">
										<input name="IDmem_mail" style="margin-bottom: 10px;"
											type="hidden" class="form-control" id="IDemailtext"
											placeholder="Email">
										<input placeholder="이메일.." id="IDmem_mail1" name="IDmem_mail1"  value="" style="width:35%; float:left; margin-bottom: 10px;"  >
										<label style="width:3%;  float:left; margin-left:10px; margin-right:10px;">@</label>
										<select id="IDmem_mail2" name="IDmem_mail2" style="width:40%; height:26px; ">
											<option selected="selected">naver.com</option>
											<option>google.com</option>
											<option>daum.net</option>
										</select>
									</div>
									<button style="width: 20%;" id="IDConfirm" type="button"
										class="btn btn-info btn-sm">아아디 찾기</button>
								</div>
										<label id="mem_id_out" style="margin-left:100px; color:red;"></label>
										
							</div>
						</form>

					</div>
					<div class="modal-footer">
						<button id="IDyes" type="button" class="btn btn-default"
							data-dismiss="modal">확인</button>
						<button id="IDno" type="button" class="btn btn-default"
							data-dismiss="modal">취소</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- PW찾기 Modal -->
	<div class="modal fade" id="myModal1" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h3 class="modal-title" style="text-align: center;">PW 찾기</h3>
				</div>
				<div class="modal-body">



					<div class="box box-info">
						<div class="box-header with-border">
							<h4 class="box-title">아이디와 이메일을 입력해주세요.</h4>
						</div>
						<!-- /.box-header -->
						<!-- form start -->
						<form class="form-horizontal">
							<div class="box-body">
								<div class="form-group">
									<label for="inputPassword3" class="col-sm-2 control-label">Id
										:</label>

									<div class="col-sm-4">
										<input type="text" class="form-control" id="PWDId"
											placeholder="아이디를 입력하세요..">
									</div>
								</div>
								<div class="form-group">
									<label for="inputPassword3" class="col-sm-2 control-label">이름 :</label>

									<div class="col-sm-4">
										<input type="text" class="form-control" id="PWDName"
											placeholder="이름을 입력하세요..">
									</div>
								</div>
								<div class="form-group">
									<label for="inputEmail3" class="col-sm-2 control-label">Mail:</label>

									<div class="col-sm-6">
										<input name="PWDmem_mail" style="margin-bottom: 10px;"
											type="hidden" class="form-control" id="PWDemailtext"
											placeholder="Email">
										<input placeholder="이메일.." id="PWDmem_mail1" name="PWDmem_mail1"  value="" style="width:35%; float:left; margin-bottom: 10px;"  >
										<label style="width:3%;  float:left; margin-left:10px; margin-right:10px;">@</label>
										<select id="PWDmem_mail2" name="PWDmem_mail2" style="width:40%; height:26px; ">
											<option selected="selected">naver.com</option>
											<option>google.com</option>
											<option>daum.net</option>
										</select>
									</div>
									<button id="PWDSend" type="button" class="btn btn-info btn-sm">이메일
										전송</button>
								</div>
								<div class="form-group">
									<label style="float: left;" for="inputEmail3"
										class="col-sm-2 control-label">인증번호 :</label>
									<div class="col-sm-3" >
										<input name="mem_code1" style="float: left;" type="text"
											class="form-control" id="PWDCode" placeholder="인증번호">
									</div>
									<button id="PWDConfirm" type="button"
										class="btn btn-info btn-sm">인증확인</button>
								</div>
								<label id="mem_pwd_out" style="margin-left:100px; color:red;"></label>
							</div>
						</form>

					</div>
					<div class="modal-footer">
						<button id="PWDyes" type="button" class="btn btn-default"
							data-dismiss="modal">확인</button>
						<button id="PWDno" type="button" class="btn btn-default"
							data-dismiss="modal">취소</button>
					</div>
				</div>
			</div>
		</div>
	</div>




	</div>

	<!-- jQuery 3 -->
	<script
		src="${pageContext.request.contextPath }/bower_components/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap 3.3.7 -->
	<script
		src="${pageContext.request.contextPath }/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- iCheck -->
	<script
		src="${pageContext.request.contextPath }/plugins/iCheck/icheck.min.js"></script>
	<script type='text/javascript'
		src='${pageContext.request.contextPath }/js/cookieControl.js'></script>
	<script>
	
		$(function() {
			$('#PWDConfirm').attr('disabled',true);
		    if(Get_Cookie('mem_id') != null){
			       $('input[name=mem_id]').val(Get_Cookie('mem_id'));
			       $('input[type=checkbox]').attr('checked',true);
		    }   
		    
			
			
			if (eval('${!empty param.message}')) {
				alert('${param.message}');
			}
			
			$('input').iCheck({
				checkboxClass : 'icheckbox_square-blue',
				radioClass : 'iradio_square-blue',
				increaseArea : '20%' /* optional */
			});
			
			$('#IDyes').click(function(){
				
			});
			$('#PWDyes').click(function(){
				$(location).attr('href', '${pageContext.request.contextPath}/nouser/join/loginForm.do');
			});
			$('#IDno').click(function(){
				$(location).attr('href', '${pageContext.request.contextPath}/nouser/join/loginForm.do');
			});
			$('#PWDno').click(function(){
				$(location).attr('href', '${pageContext.request.contextPath}/nouser/join/loginForm.do');
			});
			
			$('#PWDConfirm').click(function() {
				emailtext = $('#PWDmem_mail1').val()+'@'+$('#PWDmem_mail2').val();
				$('#PWDemailtext').val(emailtext);
				nametext = $('#PWDName').val();
				idtext = $('#PWDId').val();
				if (!nametext.validationNM()) {
					alert('성명을 제대로 입력해주세요. ex)한글 2글자이상 4글자이하');
					return false;
				}
				if (!idtext.validationID()) {
					alert('아이디를 제대로 입력해주세요. (ex 영어, 한글 8이상 12이하로 입력해주세요.');
					return false;
				}
				if(!$('input[name=PWDmem_mail]').val().validationMAIL()){
					alert('이메일을 바르게 입력해주세요 .');
					return false;
				}
					$.ajax({
						url : '${pageContext.request.contextPath}/mail/PWDconfirm.do?emailtext='+ emailtext
																				+'&nametext='+ nametext
																				+'&idtext='+ idtext,
						success :function(data) {
							if ($('#PWDCode').val() == $('#checkCode').val()) {
								$('#mem_pwd_out').text("회원 비밀번호 : "+data.mem);
								alert('인증완료 되었습니다.');
								return;
							}else{
								alert('인증코드가 틀립니다.');
								$('#mem_pwd_out').text("");
								return;
							}
						},
						error : function(res) {
							alert(res.status);
						}
					});
				
			});
			$('#IDConfirm').click(function() {
		   		nametext = $('#IDName').val();
		   		IDemailtext = $('#IDmem_mail1').val()+'@'+$('#IDmem_mail2').val();
				$('input[name=IDmem_mail]').val(IDemailtext);
		   		if(!$('input[name=IDmem_mail]').val().validationMAIL()){
					alert('이메일을 바르게 입력해주세요 .');
					return false;
				}
		   		if(!nametext.validationNM()){
					alert('성명을 바르게 입력해주세요. ex)한글 2글자이상 4글자이하');
					return false;
				}
					$.ajax({
						url : '${pageContext.request.contextPath}/mail/IDconfirm.do?emailtext='+ IDemailtext 
																				+'&nametext='+nametext,
						success : function(data) {
							if (data.mem!=null) {
								$('#mem_id_out').text("회원 아이디 : "+data.mem);
								alert('회원 아이디를 찾았습니다.');
							}else{
								$('#mem_id_out').text("");
								alert('일치하는 회원정보가 없습니다.');
							}
						},
						error : function(res) {
							alert(res.status);
						}
					});
				

			});
			$('#PWDSend').click(function() {
				
				idtext =$('#PWDId').val();
				nametext = $('#PWDName').val();
				PWDemailtext = $('#PWDmem_mail1').val()+'@'+$('#PWDmem_mail2').val();
				$('input[name=PWDmem_mail]').val(PWDemailtext);
				if(!idtext.validationID()){
					alert('아이디를 바르게 입력해주세요 .');
					return false;
				}
				if(!$('input[name=PWDmem_mail]').val().validationMAIL()){
					alert('이메일을 바르게 입력해주세요 .');
					return false;
				}
				if(!nametext.validationNM()){
					alert('성명을 바르게 입력해주세요. ex)한글 2글자이상 4글자이하');
					return false;
				}
					$.ajax({
					  	url : '${pageContext.request.contextPath}/mail/send.do?emailtext='+ PWDemailtext+'&nametext=' +nametext +'&idtext='+idtext,
						success : function(data) {
							if (data.memInfo != null) {
								$('#checkCode').val(data.code);
								alert("메일이 전송되었습니다.");
								$('#PWDConfirm').attr('disabled',false);
								
							}else{
								alert("회원정보가 일치하지 않습니다.");
							}
						
						},
						error : function(res) {
							alert(res.status);
						}
					});
				
			});
			$('#loginBtn22').click(function() {
				
				if($('input[type=checkbox]').is(':checked')){
				       // 체크박스 체크
				       Set_Cookie('mem_id',$('input[name=mem_id]').val(),1,'/');
				    }else{
				       Delete_Cookie('mem_id', '/');
			    }
				
				if($('#pppppw').val() == '' & $('#iiiiid').val() == ''){
					alert('아이디와 비밀번호를 입력해주세요');
					return;
				}
				if($('#iiiiid').val() == ''){
					alert('아이디를 입력 해주세요');
					return;
				}
				if ($('#pppppw').val() == '') {
					alert('비밀번호를 입력 해주세요');
					return;
				}
				
				
				var modulus = '${publicKeyMap["publicModulus"]}';
				var exponent = '${publicKeyMap["publicExponent"]}';
				// 공개키 설정
				var rsaObj = new RSAKey();
				rsaObj.setPublic(modulus, exponent);

				var encryptMEMID = rsaObj.encrypt($(
						'input[name=mem_id]').val());
				var encryptMEMPWD = rsaObj.encrypt($(
						'input[name=mem_pwd]').val());
				$('input[name=mem_id]').val(encryptMEMID);
				$('input[name=mem_pwd]').val(encryptMEMPWD);
				
				$('form[name=loginForm]').submit();
			});
			
		
		
});
function enterkey() {
       if (window.event.keyCode == 13) {
            // 엔터키가 눌렸을 때 실행할 내용
       	$('#loginBtn22').click();
       }
}	
	</script>
</body>
</html>