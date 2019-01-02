<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
$(function(){
	var sPath = window.location.pathname;
	if (sPath.indexOf('mdcin')>0) {
		$('#name').text("의약품 데이터 관리");
    }
	if (sPath.indexOf('hospital')>0) {
		$('#name').text("질병정보 관리원");
    }
	
	if (sPath.indexOf('withDrawal')>0) {
		$('#name').text("휴약기간 관리");
    }
	
	if (sPath.indexOf('capacity')>0) {
		$('#name').text("의약품 용법/용량 관리");
    }
	if (sPath.indexOf('disease')>0) {
		$('#name').text("질병정보 관리");
    }
	if (sPath.indexOf('fish')>0) {
		$('#name').text("어류정보 관리");
    }
	if (sPath.indexOf('mdcin_diss')>0) {
		$('#name').text("의약품별 질병 관리");
    }
	if (sPath.indexOf('diss_fish')>0) {
		$('#name').text("어류 질병 관리");
    }
	if (sPath.indexOf('symptms_diss')>0) {
		$('#name').text("질병증상 관리");
    }
	if (sPath.indexOf('symptms')>0) {
		$('#name').text("증상 관리");
    }
	
	if (sPath.indexOf('board')>0) {
		$('#name').text("게시판 통합관리");
    }
	if (sPath.indexOf('member')>0) {
		$('#name').text("회원 관리");
    }
	
});
</script>
</head>
<body>
    <!-- Content Header (Page header) -->
    <section class="content-header">
      <ol class="breadcrumb">
        <li><a href="${pageContext.request.contextPath }/main.do"><i class="fa fa-dashboard"></i> Home</a></li>
        <li class="active"><a href="#"><span id="name">통계관리</span></a></li>
      </ol>
    </section>
    <br>
</body>
</html>