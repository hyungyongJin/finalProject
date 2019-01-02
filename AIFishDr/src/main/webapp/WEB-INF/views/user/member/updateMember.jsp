<%--==============================================================
 * jsp 개요 : 
 * @author : 
 * @since : 2018. 11. 22.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일                          수정자                       수정내용
 *    -------      -------     -------------------
 *    2018. 11. 22.        임범학                     최초작성
 * Copyright (c) 2018 AI Fish Dr. All right reserved
 * </pre>
===============================================================--%>

<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<style>
.layer{ position:relative; top:50%; left:40%; width:300px; height:100px; margin:-50px 0 0 -50px; }
input{background-color:transparent;border:0}
.sorting{text-align: center;}
</style>
<body>
<div class="content-wrapper" style="margin-left:10px;">
	<!-- Main content -->
	<section class="content">
		<div class="row">
			<div class="col-md-12">

	<input type="hidden" id="checkCode" value="">
	<br/><br/><br/>
	<div class="box box-info" style="width: 70%; margin-left:15%; margin-right:15%;">
		<div class="box-header with-border" style="margin-left: 15%;">
			<h1 class="box-title"
				style="margin-top: 40px; margin-bottom: 30px; margin-left: 245px; font-size: 50px;">회원정보수정</h1>
		</div>
		<!-- /.box-header -->
		<!-- form start -->
		<form action="${pageContext.request.contextPath }/user/member/memberUpdate.do" method="post"
			class="form-horizontal" id="frm" name="updateForm">
			<div class="box-body" style="margin-left: 20%;">
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label"
						style="margin-left: 40px;">아이디:</label>

					<div class="col-sm-3">
						<input name="id" style="margin-bottom: 10px;" type="text" value="${memberInfo.mem_id }" disabled="disabled"
							class="form-control" id="mem_id" >
						<input type="hidden" value="${memberInfo.mem_id }" name="mem_id">	
					</div>
					
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label"
						style="margin-left: 40px;">비밀번호:</label>

					<div class="col-sm-3">
						<input name="mem_pwd" style="margin-bottom: 10px;" type="password" 
							class="form-control" id="mem_pwd" value="${memberInfo.mem_pwd }">
					</div>
					<label id="pwd" style="color:red;"></label>
				</div>
				
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label" 
						style="margin-left: 40px;">비밀번호 확인:</label>

					<div class="col-sm-3">
						<input name="mem_pass" style="margin-bottom: 10px;"
							type="password" class="form-control" id="mem_pwdCheck" 
							value="${memberInfo.mem_pwd }">
					</div>
					<label id="pwdCheck"></label>
				</div>
				
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label"
						style="margin-left: 40px;">이름:</label>

					<div class="col-sm-3">
						<input name="mem_name" style="margin-bottom: 10px;" type="text"
							class="form-control" id="mem_name" value="${memberInfo.mem_name }">
					</div>
				</div>
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label"
						style="margin-left: 40px;">닉네임:</label>

					<div class="col-sm-3">
						<input style="margin-bottom: 10px;" type="text" value="${memberInfo.mem_nickname }"
							name="mem_nickname" class="form-control" id="mem_nickname"
							>
					</div>
					<button id="nick" class="btn btn-primary" type="button">닉네임중복검사</button>
				</div>
				
				
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label"
						style="margin-left: 40px;">전화번호:</label>

					<div class="col-sm-3">
						<input name="mem_phone" style="margin-bottom: 10px;" type="text" 
							class="form-control" id="mem_phone" value="${memberInfo.mem_phone }">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label"
						style="margin-left: 40px;">이메일:</label>

					<div class="col-sm-3">
						<input name="mem_mail" style="margin-bottom: 10px;" type="Email"
							class="form-control" id="emailtext" value="${memberInfo.mem_mail }">
					</div>
					<button id="emailCheck" class="btn btn-primary" type="button">이메일 중복검사</button>
				</div>
				

			</div>
			<!-- /.box-body -->
			<div style="margin-right: 40%;" class="box-footer" style="width:70%;">
				<button type="button" class="btn btn-info pull-right"  id="updateBtn"
					style="margin-right: 10px;">회원수정</button>
				<button id="cancel" type="reset" class="btn btn-default pull-right"
					style="margin-right: 10px; margin-bottom: 20px;">취소</button>
				<button type="button" class="btn btn-info pull-right"  id="outBtn" 
					style="margin-right: 10px; background: red;">탈퇴신청</button>
					
			</div>
			<!-- /.box-footer -->
		</form>
		
		<!-- 회원 탈퇴 모달창 -->
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
	</div>
	</div>
	</div>
	</section>
	
<!-- 탈퇴하기 모달 -->
	<div class="modal" id="outModal" tabindex="-1" role="dialog">
		<div class="modal-dialog modal-md">
			<div class="modal-content">
				<div class="modal-header">
					<h2>탈퇴하기</h2>
				</div>
				<div class="modal-body">
				<div id="pop_content" style="border: thin;">
	            <dl>
	            <dt>회원 :</dt>
	            <dd style="color: blue;">${memberInfo.mem_nickname }(${memberInfo.mem_id})</dd>
	            <hr/>
	            <dt><span>사유선택</span> :</dt>
	            <dd class="dd_type">
	                <form id="sttemnt"  name="outForm" method="post" action="${pageContext.request.contextPath}/user/member/memberOut.do" >
	                <p class="desc5">여러 사유에 해당되는 경우, 대표적인 사유 1개를 선택해 주세요
	                </p>
	                <input type="hidden" name="mem_id" value="${memberInfo.mem_id }">
	                <ul class="list_type">
	                    <li>
	                        <input type="radio" name="secsn_reason" value="정보 부족" class="input_rdo"><label for="rdo_illegal">&nbsp; 정보부족</label>
	                    </li>
	                    <li>
	                        <input type="radio" name="secsn_reason" value="서비스기능 불편" class="input_rdo"> <label for="rdo_obscenity">서비스기능 불편</label>
	                    </li>
	                    <li>
	                        <input type="radio" name="secsn_reason"  value="개인정보 및 보안 우려" class="input_rdo"> <label for="rdo_libel">개인정보및 보안 우려</label>
	                    </li>
	                    <li>
	                        <input type="radio" name="secsn_reason" value="기타" class="input_rdo"> <label for="rdo_etc">기타</label>
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
				<span style="color: green;">탈퇴하시겠습니까 ? </span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<button id="yes1" type="button" class="btn btn-info">네</button>
					<button type="button" class="btn" data-dismiss="modal">닫기</button>
				</div>
			</div>
		</div>
   </div>
</div>

</body>
<script type="text/javascript">
$(function(){
	
	var nickclick = 0;
	
	$('#outBtn').click(function(){
		$('#outModal').modal();
		
		$('#yes1').click(function(){
			
			if ($('input:radio[name=secsn_reason]').is(':checked')) {
				$('form[name=outForm]').submit();
			}else{
				alert('탈퇴사유를 선택 해 주세요');
				return;
			}
			
			

		});
	});
	
	$('#emailCheck').click(function() {$.ajax({
		type : 'POST',
		url : '${pageContext.request.contextPath}/user/member/emailCheck.do',
		data : {mem_mail : $('input[name=mem_mail]').val()},
		success : function(result){
			if(result.boo == true){
				alert('사용 중인 이메일 입니다');
			}else{
				alert('사용 가능한  이메일 입니다');
			}
		}
		
		});
		
	});
	
	$('#nick').click(function() {$.ajax({
		type : 'POST',
		url : '${pageContext.request.contextPath}/nouser/nickNameCheck.do',
		dataType : 'json',
		data : {
		mem_nickname : $('input[name=mem_nickname]').val()},
			success : function(result) {if (result.message == 1) {
												alert("사용 가능한 닉네임입니다.");
												frm.mem_pwd.focus();
												nickclick = 1;
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

	$('#updateBtn').click(function() {
		
		if (!$('input[name=mem_name]').val().validationNM()) {
			alert('성명을 바르게 입력해주세요. ex)한글 2글자이상 4글자이하');
			return false;
		}
		if (!$('input[name=mem_phone]').val().validationHP()) {
			alert('휴대폰을 바르게 입력해주세요. ex)0|1|6|7|9 - 숫자 3글자이상 4글자이하 - 숫자 4글자');
			return false;
		}
		if (!$('input[name=mem_mail]').val().validationMAIL()) {
			alert('이메일을 바르게 입력해주세요. ex)영문,숫자포함 4~10글자이상 @ 영문 . 영문3글자');
			return false;
		}
		
		if (!$('input[name=mem_pwd]').val().validationPWD()) {
			alert('패스워드를 바르게 입력해주세요. ex)영어,한글  8글자이상 12글자이하');
			return false;
		}
		
		if (!$('input[name=mem_nickname]').val().validationNICK()) {
			alert('닉네임을 바르게 입력해 주세요 ex)한글 영문포함 2~8글자(숫자X)');
			return false;
		}
		
		alert('수정완료 되었습니다');
		$('form[name=updateForm]').submit();
		
	});
	
	
	
// 	$('#updateBtn').click(function(){
		
// 		mem_id = $('#mem_id').attr('disabled', 'disabled').val();
		
// 		$('form[name=updateForm]').submit();
// 	});
	
});

</script>

</html>
