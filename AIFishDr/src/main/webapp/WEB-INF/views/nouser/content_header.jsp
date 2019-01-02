<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script>
$(function(){
	var sPath = window.location.pathname;
	if (sPath.indexOf('naver')>0) {
		$('#name').text("네이버 로그인");
    }
	if (sPath.indexOf('insertMember')>0) {
		$('#name').text("회원가입");
    }
});	
</script>	
</head>
<body>
    <!-- Content Header (Page header) -->
      <div id="topic" class="move">
      </div>
    <section  class="content-header">
      <ol id="sectionHeader" class="breadcrumb">
        <li><a href="${pageContext.request.contextPath }/main.do"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active"><span id="name">AI Fish Dr</span></li>
      </ol>
    </section>
    <br>
</body>
</html>