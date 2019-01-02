<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.box{margin-left:50px; width: 80%;}
</style>
</head>
<body>
 <div class="content-wrapper" style="margin-left:10px;">
 <!-- Main content -->
<section class="content">
	<div class="row">
		<div class="col-md-12" >
		
			<form id="insertForm" action="${pageContext.request.contextPath }/user/freeboard/insertfreeboard.do" method="post" enctype="multipart/form-data">
			<div class="form-group" style="margin-left: 60px;">
			<div class="box">
			<hr>
				<label style="float:left; margin: 5px 5px 5px 10px; color: green;">게시판 :</label>
				<label style="float:left; margin: 5px 5px 5px 10px;">${boardInfo.board_name}</label>
				<br>
				<br>
				<br>
				<label style="float:left; margin: 5px 5px 5px 10px; color: green;">제목 :</label>
				<input type="text" class="form-control" name="bo_title"
					 style="width: 50%; margin-left: 70px;">
				<input type="hidden" class="form-control" name="bo_writer" value="${LOGIN_MEMBER.mem_id }">
				<br>
				<br>
				<!-- /.box-header -->
				<div class="box-body pad" >
						<textarea id="note" class="textarea" name="bo_content"
							style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>
				 <span id="counter"></span>
				</div>

			<div id="form" class="form-group" style="margin-left: 60px; ">
			<c:if test="${boardInfo.board_function2 eq '2' }">
					<button type="button" id="createFile" class="btn btn-info" style="width:10%; height:30px;">첨부파일 등록</button>
					<br>
					<br>
					<table id="list">
					</table>
				
			</c:if>
			</div>
			<button type="button" id="return" style="margin-right:20px; font-size:15px;" class="btn btn-info btn-flat bg-purple pull-right" >목록 </button>
			<button type="button" id="insertBtn" style="margin-right:20px; font-size:15px;" class="btn btn-info btn-flat pull-right">등록 </button>
			
			</div>
			</div>
					</form>
			
			

			



		</div>
	</div>
</section>
</div>
<!-- /.content-wrapper -->
</body>
<script type="text/javascript">
$(function(){
	
	$('#createFile').click(function(){
		var cnt = $('input[type=file]').length;
		if (cnt==6) {
			alert("더 이상 파일을 추가할 수 없습니다.");			
		}else{
			var html = '<tr>';
			html += '<td height="45"><input type="file" class="fileCheck" name="files" style="float:left;"><button class="btnDel btn-sm btn-danger" type="button">취소</button></button>';
			html += '</td></tr>';
			$("#list").append(html); 
		}
	});
			  
		$("#list").on("click", ".btnDel", function() { 
			    $(this).parent().parent().remove();
			  });  

	 $('input[name=bo_title]').focus();	
     $('#note').summernote({
       height: 500,               
        minHeight: null,           
        maxHeight: null,           
        focus: false,       
        toolbar: [
                  // [groupName, [list of button]]
                  ['style', ['bold', 'italic', 'underline', 'clear']],
                  ['font', ['strikethrough', 'superscript', 'subscript']],
                  ['fontsize', ['fontsize']],
                  ['color', ['color']],
                  ['para', ['ul', 'ol', 'paragraph']],
                  ['height', ['height']],
                  ['picture']
                ]
   });
   $('#return').click(function(){
	  $(location).attr('href','${pageContext.request.contextPath}/user/freeboard/freeboardList.do') ;
   }); 
   $('#insertBtn').click(function(){
		var checkImage = $('.fileCheck').val();
		if (checkImage!=null) {
			checkImage = checkImage.slice(checkImage.indexOf('.')+1).toLowerCase();
		}else{
			checkImage='';
		}
		if (checkImage=="jpg"||checkImage=="png"||checkImage=="gif"||checkImage=="bmp") {
			alert('파일만 등록이 가능합니다.');
			return;
		}
		if ($('input[name=bo_title]').val() == '') {
			alert('제목을 입력해 주세요');
				return;
			}
		if ($('textarea[name=bo_content]').val() == '') {
			alert('내용을 입력해 주세요');
				return;
			}
	   //정규식 체크
	   $('#insertForm').submit();
   });
   
   
});

</script>
</html>
