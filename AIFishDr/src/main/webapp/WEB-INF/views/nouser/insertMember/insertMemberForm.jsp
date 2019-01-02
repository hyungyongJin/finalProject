<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<script type="text/javascript">
	$(function() {
		$('#btn2').attr('disabled',true);
		var codeclick = 0;
		var nickclick = 0;
		var idclick = 0;
		var	mailclick = 0;
		$('#sendMail').click(function() {
			emailtext = $('#mem_mail1').val()+'@'+$('#mem_mail2').val();
			$('input[name=mem_mail]').val(emailtext);
			
			if ($('input[name=mem_mail1]').val()=="") {
				alert('이메일을 입력해주세요. ex)[영어 대소문자 ,숫자]6이상 12이하 @ naver.com');
				return ;
			}
			if(!$('input[name=mem_mail]').val().validationMAIL()){
				alert('이메일을 바르게 입력해주세요 .');
				return ;
			} 
			
			$.ajax({
					url : '${pageContext.request.contextPath}/mail/insertMail.do',
					type: 'POST',
					data : "emailtext="+emailtext,
					success : function(data) {
						$('#checkCode').val(data.code);
						mailclick =1;
						alert("메일이 전송되었습니다.");
						$('#btn2').attr('disabled',false);
					},
					error : function(res) {
						alert(res.status);
					}
				});
			
		});

		$('#btn2').click(function() {
			var check = $('#checkCode').val();
			if ($('input[name=mem_code]').val()=="") {
				alert('인증번호를 입력해주세요.');
				return false;
			}
			if ($('input[name=mem_code]').val() != check) {
				alert('인증코드가 틀립니다.');
			} else {
				var phone = $('#mem_phone1').val()+'-'+$('#mem_phone2').val()+'-'+$('#mem_phone3').val();
				$('input[name=mem_phone]').val(phone);
				alert('인증완료 되었습니다.');
				codeclick =1;
			}

		});
		$('input[value=아이디중복검사]').click(function() {
			if (!$('input[name=mem_id]').val().validationID()) {
				alert('아이디를 바르게 입력해주세요.(ex 영어, 한글 8이상 12이하로 입력해주세요.');
				return;
			}
			var mem_id = $('input[name=mem_id]').val();
			
			$.ajax({
				type : 'POST',
				url : '${pageContext.request.contextPath}/nouser/idCheck.do',
				data :  "mem_id="+  mem_id,
				success : function(result) {
					if (result.message == 1) {
						idclick =1;
						alert("사용 가능한 아이디입니다.");
						frm.mem_name.focus();
					} else {
						alert("이미 사용중인 아이디입니다.");
						frm.mem_id.focus();
					}
				}
			});

		});

		$('#nick').click(function() {
			if (!$('input[name=mem_nickname]').val()
					.validationNICK()) {
				alert('닉네임을 바르게 입력해주세요.(ex 영어, 한글 2이상 8이하로 입력해주세요.');
				return false;
			}
			$.ajax({
				type : 'POST',
				url : '${pageContext.request.contextPath}/nouser/nickNameCheck.do',
				dataType : 'json',
				data : {
					mem_nickname : $(
							'input[name=mem_nickname]')
							.val()
				},
				success : function(result) {
					if (result.message == 1) {
						nickclick = 1;
						alert("사용 가능한 닉네임입니다.");
						frm.mem_pwd.focus();
					} else {
						alert("이미 사용중인 닉네임입니다.");
						frm.mem_nickname.focus();
					}
				}
			});
		});

		$('#mem_pwdCheck').keydown(function() {
			$('#pwdCheck').text('');
			// 			$('#pwdCheck').html('비밀번호를 제대로 입력해주세요.');
		}); //#user_pass.keyup

		$('#mem_pwdCheck').keyup(function() {
			if ($('#mem_pwd').val() != $('#mem_pwdCheck').val()) {
				$('#pwdCheck').text('');
				$('#pwdCheck').html('불일치');
				$('#pwd').html('※패스워드를 바르게 입력해주세요. ex)영어,한글  8글자이상 12글자이하');
			} else {
				if ($('input[name=mem_pwd]').val().validationPWD()) {
					$('#pwd').text('');
					$('#pwdCheck').text('');
					$('#pwdCheck').html('일치');
				}
			}
		}); //#chpass.keyup
		
		
		
		
		$('#cancel').click(function() {
			$(location).attr('href','${pageContext.request.contextPath }/user/noticeboard/noticeList.do');
		});

		$('form').submit(function() {
			if(idclick==0){
				alert('아이디중복체크를 해주세요.');
				idclick =0;
				return false;
			}
			if(nickclick==0){
				alert('닉네임중복체크를 해주세요.');
				nickclick =0;
				return false;
			}
			if(mailclick==0){
				alert('메일전송 버튼을 눌러주세요 눌러주세요.');
				mailclick =0;
				return false;
			}
			if(codeclick==0){
				alert('인증버튼을 눌러주세요.');
				codeclick =0;
				return false;
			}
			if ($('#mem_pwd').val() != $('#mem_pwdCheck').val()) {
				alert('비밀번호를 일치 시켜주세요.');
				return false;
			}
			if (!$('input[name=mem_id]').val().validationID()) {
				alert('아이디를 바르게 입력해주세요.');
				return false;
			}
			if (!$('input[name=mem_pwd]').val().validationPWD()) {
				alert('패스워드를 바르게 입력해주세요. ex)영어,한글  8글자이상 12글자이하');
				return false;
			}
			if (!$('input[name=mem_name]').val().validationNM()) {
				alert('성명을 바르게 입력해주세요. ex)한글 2글자이상 4글자이하');
				return false;
			}
// 			if (!$('input[name=mem_mail]').val().validationMAIL()) {
// 				alert('이메일을 바르게 입력해주세요 .');
// 				return false;
// 			}
			if (!$('input[name=mem_phone]').val().validationHP()) {
				alert('휴대폰을 바르게 입력해주세요. ex)0|1|6|7|9 - 숫자 3글자이상 4글자이하 - 숫자 4글자');
				return false;
			}
			
			return true;
		});

	});
</script>
<body>
	<div class="content-wrapper" style="margin-left: 10px;">
		<section class="content">
			<div class="row">
				<div class="col-md-12">
					<input type="hidden" id="checkCode" value="">
					<div class="box box-info" style="width: 95%;">
						<div class="box-header with-border" style="margin-left: 150px;">
							<h1 class="box-title"
								style="margin-top: 40px; margin-bottom: 30px; margin-left: 245px; font-size: 50px;">회원가입</h1>
						</div>
						<!-- /.box-header -->
						<!-- form start -->
						<form
							action="${pageContext.request.contextPath }/nouser/join/insertMember.do"
							class="form-horizontal" id="frm">
							<div class="box-body" style="margin-left: 200px;">
								<div class="form-group">
									<label for="inputEmail3" class="col-sm-2 control-label"
										style="margin-left: 40px;">아이디:</label>

									<div class="col-sm-3">
										<input name="mem_id" style="margin-bottom: 10px;" type="text"
											class="form-control" id="mem_id" placeholder="id">
									</div>
									<input style="width: 125px;" class="btn btn-primary"
										value="아이디중복검사" type="button">
								</div>
								<div class="form-group">
									<label for="inputEmail3" class="col-sm-2 control-label"
										style="margin-left: 40px;">이름:</label>

									<div class="col-sm-3">
										<input name="mem_name" style="margin-bottom: 10px;"
											type="text" class="form-control" id="mem_name"
											placeholder="name">
									</div>
								</div>
								<div class="form-group">
									<label for="inputEmail3" class="col-sm-2 control-label"
										style="margin-left: 40px;">닉네임:</label>

									<div class="col-sm-3">
										<input style="margin-bottom: 10px;" type="text"
											name="mem_nickname" class="form-control" id="mem_nickname"
											placeholder="nickname">
									</div>
									<button id="nick" class="btn btn-primary" type="button">닉네임중복검사</button>
								</div>
								<div class="form-group">
									<label for="inputEmail3" class="col-sm-2 control-label"
										style="margin-left: 40px;">비밀번호:</label>

									<div class="col-sm-3">
										<input name="mem_pwd" style="margin-bottom: 10px;"
											type="password" class="form-control" id="mem_pwd"
											placeholder="password">
									</div>
									<label id="pwd" style="color:red;"></label>
								</div>
								<div class="form-group">
									<label for="inputPassword3" class="col-sm-2 control-label"
										style="margin-left: 40px;">비밀번호 확인:</label>

									<div class="col-sm-3">
										<input name="mem_pass" style="margin-bottom: 10px;"
											type="password" class="form-control" id="mem_pwdCheck"
											placeholder="Password확인">
									</div>
									<label id="pwdCheck"></label>
								</div>
								<div class="form-group">
									<label for="inputEmail3" class="col-sm-2 control-label"
										style="margin-left: 40px;">전화번호:</label>
									<div class="col-sm-4">
										<input  name="mem_phone" style="margin-bottom: 10px;"
											type="hidden" class="form-control" id="mem_phone">
										<select style="float:left; width:17%; height:32px;" id="mem_phone1" name="mem_phone1">
											<option selected="selected">010</option>
											<option>011</option>
											<option>014</option>
											<option>015</option>
											<option>017</option>
											<option>019</option>
										</select>
										<label style="font-size:25px; float:left; margin-left:10px; margin-right:10px;">-</label>
										<input style="float:left; width:22%;" placeholder="  XXXX" type="text" class="form-control" name="mem_phone2" id="mem_phone2">
										<label style="font-size:25px; float:left; margin-left:10px; margin-right:10px;">-</label>
										<input style="width:22%;" placeholder="  XXXX" type="text" class="form-control" name="mem_phone3" id="mem_phone3">
									</div>
								</div>
								<div class="form-group">
									<label for="inputPassword3" class="col-sm-2 control-label"
										style="margin-left: 40px;">이메일:</label>

									<div class="col-sm-5">
										<input name="mem_mail" style="margin-bottom: 10px;"
											type="hidden" class="form-control" id="emailtext"
											placeholder="Email">
										<input id="mem_mail1" class="form-control" name="mem_mail1"  value="" style="width:35%; float:left; margin-bottom: 10px;"  >
										<label style="width:3%;  float:left; margin-left:10px; margin-right:10px;">@</label>
										<select id="mem_mail2" class="form-control" name="mem_mail2" style="width:40%;">
											<option selected="selected">naver.com</option>
											<option>gmail.com</option>
											<option>daum.net</option>
										</select>
									</div>
										
								</div>
								<button style="margin-left:300px;" type="button" id="sendMail" class="btn btn-primary">이메일전송</button>
								<div class="form-group">
									<br>
									<label for="inputPassword3" class="col-sm-2 control-label"
										style="margin-left: 40px;">인증코드:</label>

									<div class="col-sm-2">
										<input name="mem_code" style="margin-bottom: 10px;"
											type="text" class="form-control" id="code" placeholder="인증번호">
									</div>
									<button id="btn2" class="btn btn-primary" type="button">인증확인</button>
								</div>

							</div>
							<!-- /.box-body -->
							<div class="box-footer">
								<button id="cancel" type="button"
									class="btn btn-default pull-right"
									style="margin-right: 300px; margin-bottom: 20px;">취소</button>
								<button type="submit" class="btn btn-info pull-right"
									style="margin-right: 10px;">회원가입</button>
							</div>
							<!-- /.box-footer -->
						</form>
					</div>
				</div>
			</div>
		</section>
	</div>
</body>

</html>
