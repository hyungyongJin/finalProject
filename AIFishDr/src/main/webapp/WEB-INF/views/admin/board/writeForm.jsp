<%--==============================================================
 * jsp 개요 : 
 * @author : 
 * @since : 2018. 11. 14.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일                          수정자                       수정내용
 *    -------      -------     -------------------
 *    2018. 11. 14.        진형용                      최초작성
 * Copyright (c) 2018 AI Fish Dr. All right reserved
 * </pre>
===============================================================--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<style>
input{background-color:#E8F5FF;border:0} 
</style>
<body>
<div class="content-wrapper" style="margin-left:10px;">
 <!-- Main content -->
    <section class="content">
   <div class="row">
      <div class="col-md-12">

   <!-- 위 html 지우지 말 것  -->




         <div class="box">
            <div class="box-header">
            </div>
            <!-- /.box-header -->
            <div class="box-body pad">
                <select class="form-control" name="boardCategory" >
		         		<option value="">게시판을 선택해 주세요</option>
		         		<c:forEach items="${boardName }" var="list">
		         		<option value="${list.board_code }">${list.board_name }</option>
		         		</c:forEach>
		         	</select>
		         	<br>
		         	
               <form id="insertForm" action="${pageContext.request.contextPath }/admin/board/insertWrite.do" method="post" enctype="multipart/form-data" >
		       <input type="hidden" name="board_code" value="">  	
              <label class="text-green">제목 :</label>&nbsp;&nbsp;&nbsp;&nbsp;
               <input size="100" type="text" name="bo_title" value="">
               <br>
               <br>
               <input  type="hidden" name="bo_writer" value="${LOGIN_MEMBER.mem_id }">
               <textarea id="note" name="bo_content"  style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>
			<input type="file" name="files" value="파일등록">

          <button id="return" type="button"  style="width:140px;" class="btn btn-info btn-sm pull-right">목록</button>&nbsp;&nbsp;
          <button id="insert" type="button"  style="width:140px;" class="btn btn-info btn-sm pull-right">등록</button>
               </form>
            </div>
         </div>
   



			<div class="box">
				<div class="box-header"></div>
				<!-- /.box-header -->
				<div class="box-body">
					<div id="example1_wrapper"
						class="dataTables_wrapper form-inline dt-bootstrap">


						<div class="row"></div>

					</div>
				</div>
				<!-- /.box-body -->
			</div>
			<!-- 아래 html 건들지 말것 -->
      </div>
            <!-- /.col-->

      </div>                             
   </div>
		
         <!-- ./row --></section>
    <!-- /.content -->
  
  <!-- /.content-wrapper -->
  </body>
<script type="text/javascript">
$(function(){
	$('#note').summernote({
		 height: 500,                 // 썸머노트 높이
		  minHeight: null,             // set minimum height of editor
		  maxHeight: null,             // set maximum height of editor
		  focus: false,        // set focus to editable area after initializing summernote
		 
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
		$(location).attr('href','${pageContext.request.contextPath}/admin/board/writeList.do');
	})	
	
	$('#insert').click(function(){
		//정규식 적용
		var code = $('select[name=boardCategory] option:selected').val();
		if (code=='') {
			alert('등록할 게시판을 선택해 주세요');
			return;
		}
		if ($('input[name=bo_title]').val()=='') {
			alert('제목을 입력해 주세요.');
			return;
		}
		$('input[name=board_code]').val(code);
		$('#insertForm').submit();
		
	})
	
	
	
})
</script>
</html>  
  