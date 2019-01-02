<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
$(function() {
	$('form').submit(function() {
		var flag = true;
		$('input[type=file]').each(function(index, tag) {
			if (!/\.(jpeg|jpg|png|gif)$/.test($(tag).val().toLowerCase())) {
				alert('이미지 파일만 업로드 가능합니다.');
				flag = false;
			}
		});
	});
	return flag;
})

function fileDownload() {
	var fileName = encodeURIComponent('${param.fileName }');
	location.href='${pageContext.request.contextPath}/file/fileDownload.do?fileName=' + fileName;
}
</script>
</head>
<body>
<!-- 
	브라우저 보안 정책(공통)
	: 브라우저는 클라이언트의 파일 시스템에 접근으로 파일 또는 디렉토리를 작성, 수정할 수 없음
	: IE → ActiveX 예외
	
	브라우저 파일 업로드
	: Form, ajax 파일 업로드 가능
	: 서버 파일 전송시 공통적으로 content-type="multipart/form-data"
							 전송방식 : POST
							 
	컨텐츠 타입 : request.getContentType();
				서버단 컨텐츠 타입 null
				   location.href
				   location.replace()
				   <a href/>
				    직접 브라우저 주소창에 주소 입력
				서버단 컨텐츠 타입 application/x-www-form-urlencoded
				   <form enctype="application/x-www-form-urlencoded" />
				   ajax : content - "application/x-www-form-urlencoded"
				서버단 컨텐츠 타입 multipart/form-data(파일 업로드)
				   <form enctype="multipart/form-data" />
				   ajax : content - "multipart/form-data"
 -->
<form action="${pageContext.request.contextPath }/file/fileUpload.do" 
		enctype="multipart/form-data" method="post">
	<table>
		<tr>
			<td>아이디</td>
			<td><input type="text" name="mem_id" /></td>
		</tr>
		<tr>
			<td>패스워드</td>
			<td><input type="text" name="mem_pass" /></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="mem_name" /></td>
		</tr>
		<tr>
			<td>파일1</td>
			<td><input type="file" name="files" /></td>
		</tr>
		<tr>
			<td>파일2</td>
			<td><input type="file" name="files" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="파일전송" /></td>
		</tr>
	</table>
</form>
<img alt="" src="/image/${param.fileName }" width="200" height="250" onclick="fileDownload();" />
</body>
</html>