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
	<c:forEach var="list" items="${BOARD_INFO }">
		if (sPath.indexOf('${list.board_eng_name}')>0) {
			$('#name').text('${list.board_name}');
    }
	</c:forEach>
	if (sPath.indexOf('member')>0) {
		$('#name').text("회원 정보수정");
    }
	if (sPath.indexOf('message')>0) {
		$('#name').text("쪽지함");
    }
	if (sPath.indexOf('aiService')>0) {
		$('#name').text("AI 응답서비스");
    }
	if (sPath.indexOf('mdcinList')>0) {
		$('#name').text("의약품 검색");
    }
	if (sPath.indexOf('aiDoctor')>0) {
		$('#name').text("AI Fish DR");
    }
	if (sPath.indexOf('fishDiss')>0) {
		$('#name').text("어류 질병정보");
    }
	if (sPath.indexOf('prescriptionManagement')>0) {
		$('#name').text("처방내역확인");
    }
	if (sPath.indexOf('hospital')>0) {
		$('#name').text("질병관리원 위치확인");
    }
	
	$('#topic').hide();
	if (sPath.indexOf('main')>0||sPath.indexOf('noticeList')>0) {
		$('#sectionHeader').hide();
		$.ajax({
			url : 'http://api.adams.ai/datamixiApi/topictoday?key=2967355678906044062&count=3&&category=all',
			success : function(data){
				var topic= data.document;
				code = '';
				for (var i = 0; i < topic.length; i++) {
					code +=' <a target="_blank" href='+topic[i].orgUrl+'  style="font-size: large; color:#9A2EFE;">#'+topic[i].title+'#</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				};
				code+='<span style="font-size: large;"> : 오늘의 토픽</span>';
				$('#topic').html(code);
			},error : function(res){
				alert(res.status);
			}		
		})
		$('#topic').show();
    }
});
</script>
<style type="text/css">
.move {
    position: absolute;
    width: 120%;
    height: 50px;
    background-color: none;
    animation-name: move1;
    animation-duration: 20s;
    animation-iteration-count: infinite;
	animation-direction:alternate ;
	animation-fill-mode : both;
	transform-origin: 100% 100%; 
	​transform-origin:  right bottom; 
	​transform-origin:  left bottom;
	​transform-origin:  right top;
	​transform-origin:  left top;
}
@keyframes move1 {
    0% {
      left: 0px;
    }
    100% {
      left: 20%;
    }
}

</style>
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