<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>           
<!doctype html>
<html lang="ko">
<head>
<script type="text/javascript"
  src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.2.js"
  charset="utf-8"></script>
<script type="text/javascript"
  src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<style type="text/css">
html, div, body, h3 {
  margin: 0;
  padding: 0;
}

h3 {
  display: inline-block;
  padding: 0.6em;
}
</style>
<script type="text/javascript">
  $(document).ready(function() {
//     var name = ${result}.response.name;
//     var email = ${result}.response.email;
//     var id = ${result}.response.id;
//     var nickname = ${result}.response.nickname;
//     $("#name").html("환영합니다. "+name+"님");
//     $("#email").html(email);
//     $("#id").html(id);
    });
//   location.href = "${pageContext.request.contextPath}/naver/loginForm.do";
</script>

<style type="text/css">
#img{
	background-image: url("${pageContext.request.contextPath}/images/tt.jpg");
	background-size: 100%; 

}


</style>
</head>
<body>
<!--   <div -->
<!--     style="background-color: #15a181; width: 100%; height: 50px; text-align: center; color: white;"> -->
<!--   </div> -->
  <br>
  <h2 style="text-align: center" id="name"></h2>
  <h4 style="text-align: center" id="email"></h4>
  <script>
    $(function () {
      $("body").show();

	      $('#nick').click(function() {$.ajax({
	  		type : 'POST',
	  		url : '${pageContext.request.contextPath}/nouser/nickNameCheck.do',
	  		dataType : 'json',
	  		data : {
	  		mem_nickname : $('input[name=mem_nickname]').val()},
	  			success : function(result) {if (result.message == 1) {
	  												alert("사용 가능한 닉네임입니다.");
	  												frm.mem_pwd.focus();
	  											} else {
	  												alert("이미 사용중인 닉네임입니다.");
	  												frm.mem_nickname.focus();
	  											}
	  										}
	  		});
	  	});
      
      
      $('#success').click(function(){
    	  
    	  var mem_nickname= $('#mem_nickname').val();
    	  var mem_phone = $('#mem_phone').val();
    	  
    	  if (!$('input[name=mem_nickname]').val().validationNICK()) {
  			alert('닉네임을 바르게 입력해 주세요 ex)한글 영문포함 2~8글자(숫자X)');
  			return;
  		  }
    	  
    	  if (!$('input[name=mem_phone]').val().validationHP()) {
  			alert('휴대폰을 바르게 입력해주세요. ex)0|1|6|7|9 - 숫자 3글자이상 4글자이하 - 숫자 4글자');
  			return;
  		  }
    	  
    	  
    	  $(location).
	  			attr('href','${pageContext.request.contextPath}/naver/naverLoginCheck.do?id='+ ${result}.response.id
	  					+'&name='+${result}.response.name+'&email='+ ${result}.response.email
	  				    +'&mem_nickname=' + mem_nickname + '&mem_hp='+mem_phone
           );
      });
      
//       $("body").fadeIn(1000);  
      // 1초 뒤에 사라 지자 
      
      
//       var inputString = prompt('회원님의 핸드폰 번호를 입력해주세요', 'ex(000-0000-0000)');
     

//       setTimeout(function(){$("body").fadeOut(1000);},1000);
//       setTimeout(function()
//     		  {$(location).
//     	  			attr('href','${pageContext.request.contextPath}/naver/naverLoginCheck.do?id='+ ${result}.response.id
//     	  					+'&name='+${result}.response.name+'&email='+ ${result}.response.email
//      	  				    +'&mem_hp='+ inputString
//     	  			)},0);
      
// 2초 뒤에 메인 화면 으로 가자  

	
    
  });
  </script>
<div class="content-wrapper" id="img" style="margin-left: 0px;">

	<!-- Main content -->
	<section class="content">
		<div class="row">
			<div class="col-md-12">

	<br/><br/><br/>
	<div class="box box-info" style="width: 63%; margin-left:15%; margin-right:15%; " >
		<div class="box-header with-border" style="margin-left: 15%;">
			<h1 class="box-title"
				style="margin-top: 40px; margin-bottom: 30px; margin-left: 10%; font-size: 35px;">네이버 로그인 세부 입력</h1>
		</div>
		<!-- /.box-header -->
		<!-- form start -->
		<form  method="post"
			class="form-horizontal" id="frm" name="updateForm" >
			<div class="box-body" style="margin-left: 20%;">
				
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label"
						style="margin-left: 40px;">닉네임:</label>

					<div class="col-sm-3">
						<input style="margin-bottom: 10px;" type="text" 
							name="mem_nickname" class="form-control" id="mem_nickname"
							>
					</div>
					
					<button id="nick" class="btn btn-primary" type="button">닉네임중복검사</button>
				</div>
				
				
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-2 control-label"
						style="margin-left: 40px;">휴대번호:</label>

					<div class="col-sm-3">
						<input name="mem_phone" style="margin-bottom: 10px;" type="text" 
							class="form-control" id="mem_phone" >
					</div>
				</div>
				

			</div>
			<!-- /.box-body -->
			<div style="margin-right: 40%;" class="box-footer" style="width:70%;">
				<button type="button" class="btn btn-info pull-right"  id="success"
					style="margin-right: 15%; background: red;">입력 완료</button>
					
			</div>
			<!-- /.box-footer -->
		</form>
	</div>
	</div>
	</div>
	</div>
<!-- 	 <div -->
<!--     style="background-color: #15a181; width: 100%; height: 50px; text-align: center; color: white;"> -->
<!--   </div> -->
	</section>
	
	

</div>

</body>
</html>