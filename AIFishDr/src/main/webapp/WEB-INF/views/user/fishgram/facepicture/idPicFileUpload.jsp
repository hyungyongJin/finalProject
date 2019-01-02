<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
td {f on t-family:"돋움";
	font-size: 9pt;
	line-height: 16px;
	color: #818181;
	letter-spacing: 0px;
}

td a {
	font-family: "돋움";
	font-size: 9pt;
	line-height: 16px;
	color: #818181;
	letter-spacing: 0px;
	text-decoration: none;
}

td a:hover {
	font-family: "돋움";
	font-size: 9pt;
	line-height: 16px;
	color: #818181;
	letter-spacing: 0px;
	text-decoration: underline;
}

#hiddenFileInput{
	position : relative;
	width : 80px; 
	height:30px; 
	overflow:hidden; 
	cursor:pointer; 
	background-image:url('${pageContext.request.contextPath}/images/bt_search.gif');
	background-repeat: no-repeat;
}

#idPic{
	width:80px; 
	height:30px; 
	filter:alpha(opacity=0); 
	opacity:0; 
	-moz-opacity:0; 
	cursor:pointer;
	vertical-align: middle;
}
.bar {
    height: 18px;
    background: green;
}

</style>

<script type = "text/javascript" src = "http://code.jquery.com/jquery-latest.js"></script>

<!-- 

	★ ajax form 기반 파일 전송 ★
	1. http://malsup.com/jquery/form/#download 접속
	2. jquery.form.js 눌러서 D:\C_Lib\ajaxform 에 다운로드
	3. js 폴더에 import 시키기

 -->
 
<script type = "text/javascript" src = "${ pageContext.request.contextPath }/js/jquery.form.js"></script>
<script type = "text/javascript">
 
var idPicFileName;
 
function idPicInputChange(fileName) {
 
	// D:\temp\images\a.png
	var fileInfoArray = fileName.split('\\');
	fileName = fileInfoArray[fileInfoArray.length - 1];

	$('#fileName').val(fileName);

	if (!/\.(jpg|jpeg|gif|png)$/.test(fileName.toLowerCase())) {
		
		alert ('이미지 파일을 선택해주세요.');
		
		return;
		
	}

	$('#idPicForm').ajaxForm({
		
		dataType : 'json',
		
		url : '${pageContext.request.contextPath}/user/fishgram/facepicture/imageAjax.do',
				
		error : function(request, status, error) {
		         
		             alert("code : " + request.status + "\r\nmessage : " + request.reponseText);
		             
		},
		
		success : function(result) {
			
			idPicFileName = result.encodingName;
			$('#viewTable').html('<img src="/image/' + idPicFileName + '" width="auto" height="210px" align="center" cursor="pointer" onclick="popupClose();"/>');
						
		}	
	});
	
	$('#idPicForm').submit();
 
}
 
function popupClose() {

// 	$(opener.document).find('#idPicViewDiv').html('<img class="profile-user-img img-responsive img-circle" src="${pageContext.request.contextPath }/imageFolder/dog.jpg" align="center"></img>');
	$(opener.document).find('#idPicViewDiv').html('<img class="profile-user-img img-responsive img-circle" src="/image/' + idPicFileName + '" alt="User profile picture" onclick="pictureChange();" style = "height:210px; width:auto; align:center; cursor:pointer;"></img>');
	
	$(opener.document).find('#pictureButton').html('<button type="button" class="btn btn-primary btn-block" style = "cursor:pointer" onclick="profileModifyComplete();">프로필 수정하기</button>');
	
	self.close();
	 
}
 
</script>
 
</head>
<body>
	<table width="354" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td height="30" style="text-align: center;"><font color="red" size="5">프로필 사진 업로드</font></td>
		</tr>
		<tr>
			<td><img src="${pageContext.request.contextPath }/images/open_table01.gif" width="354" height="10"></td>
		</tr>
		<tr>
			<td height="10" background="${pageContext.request.contextPath }/images/open_table02.gif" align="center">&nbsp;</td>
		</tr>
		<tr>
			<td height="300" align="center" valign="top"
				background="${pageContext.request.contextPath }/images/open_table02.gif">
				<table width="300" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td height="25">
							<div align="center">등록하려는 사진(gif | jpg | jpeg | png)를 선택해주세요.</div>
						</td>
					</tr>
					<tr>
						<td height="38" background="${pageContext.request.contextPath }/images/open_tt.gif" align="center">
							<form id="idPicForm" action="${ pageContext.request.contextPath }/user/fishgram/facepicture/idFileUpload.do" method = "post" enctype = "multipart/form-data">
								<input type="text" id="fileName" name="fileName"/>
								<span id="hiddenFileInput">
	    							<input type="file" id="idPic" name="idPic" onchange = "idPicInputChange(this.value)"/>
								</span>
							</form>
						</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
					</tr>
					<tr>
						<td>
							<div style="overflow: auto; white-space: nowrap; overflow-X: hidden; height: 200px;" id="viewTable"></div>
						</td>
					</tr>
				</table>
			</td>
		</tr>

		<tr>
			<td><img src="${pageContext.request.contextPath }/images/open_table03.gif" width="354" height="10"></td>
		</tr>
	</table>
</body>
</html>