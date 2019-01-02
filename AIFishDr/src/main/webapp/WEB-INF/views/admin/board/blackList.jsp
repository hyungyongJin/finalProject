<%--==============================================================
 * jsp 개요 : 
 * @author : 
 * @since : 2018. 11. 12.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일                    수정자                 수정내용
 *    -------             -------     -------------------
 *    2018. 11. 12.        진형용                 최초작성
 * Copyright (c) 2018 AI Fish Dr. All right reserved
 * </pre>
===============================================================--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<title>AI Fish Dr.</title>
<style type="text/css">
.layer{ position:relative; top:50%; left:40%; width:300px; height:100px; margin:-50px 0 0 -50px; }
input{background-color:transparent;border:0}
.sorting{text-align: center;}
textarea {resize: none;}
</style>
</head>
<body>
 <!-- Main content -->
    <section class="content">
   <div class="row">
      <div class="col-md-12">

   <!-- 위 html 지우지 말 것  -->


   <div class="box" id="boardMgr">
     <hr>
      <div class="box-body pad">
            	<button id="btn1" type="button" style="width:200px;" class="btn btn-info btn-sm" >게시글 관리</button>
            	<button id="btn2" type="button" style="width:200px;" class="btn btn-danger btn-sm" >신고 게시글 관리</button>
            </div>
            <hr>
         <div class="box-header">
            <h3 class="box-title" >전체 신고 게시글</h3>
         </div>
         
         <!-- /.box-header -->
         <div class="box-body">
  
         	
            <div id="example1_wrapper"
               class="dataTables_wrapper form-inline dt-bootstrap">
               <div class="row">
                  <div class="col-sm-12">
				<form action="${pageContext.request.contextPath }/admin/board/blackList.do?currentPage=${searchInfo.currentPage}&search=${searchInfo.search}&keyword=${searchInfo.keyword}&boardCategory=${searchInfo.boardCategory}" method="get">
                   <div class="dropdown">
					    <select name="search" class="form-control">
						  <option value="TOTAL">전체</option>
						  <option value="TITLE">제목</option>
						  <option value="CONTENT">내용</option>
						  <option value="WRITER">작성자</option>
						</select>
					     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					        <input name="keyword" type="search" class="form-control input-md" style="width:300px;" placeholder="검색어를 입력하세요.." aria-controls="example1">
					        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					        <button id="searchBtn" class="btn btn-primary btn-md" type="submit">검색</button>
					</div>
				</form>
					<br>
					<form id="delForm" method="post" action="${pageContext.request.contextPath }/admin/board/deleteWrite.do?type=1" >
                     <table id="example1" class="table table-bordered table-striped dataTable" role="grid" aria-describedby="example1_info">
                <thead>
                <tr role="row">
	                <th class="sorting_asc" tabindex="0"  rowspan="1" colspan="1" style="width: 50px;"><button class="btn btn-primary btn-sm" type="button" id="btnCheck">선택</button></th>
	                <th class="sorting" tabindex="0"  rowspan="1" colspan="1" style="width: 100px;">게시판 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
	                <select class="form-control" name="boardCategory" onchange="selectBoard(this.value);">
		         		<option>게시판명</option>
		         		<c:forEach items="${boardName }" var="list">
		         		<c:if test="${list.board_code != 'board004' }">
		         		<option value="${list.board_code }">${list.board_name }</option>
		         		</c:if>
		         		</c:forEach>
		         	</select>
         			</th>
	                <th class="sorting" tabindex="0"  rowspan="1" colspan="1" style="width: 500px;">제목</th>
	                <th class="sorting" tabindex="0"  rowspan="1" colspan="1" style="width: 60px;">신고횟수</th>
	                <th class="sorting" tabindex="0"  rowspan="1" colspan="1" style="width: 100px;">글쓴이</th>
	                <th class="sorting" tabindex="0"  rowspan="1" colspan="1" style="width: 120px;">작성일자</th>
	                <th class="sorting" tabindex="0"  rowspan="1" colspan="1" style="width: 100px;">상세보기</th>
                </tr>
                </thead>
                <tbody id="boardTable">
                 <c:forEach items="${ blackList}" var="list"> 
	                <tr role="row" class="odd">
	                  <td class="sorting"><input type="checkbox" value="${list.BO_NO}" name="bo_no"></td>
	                  <td class="sorting">${list.BOARD_NAME}</td>
	                  <td>${list.BO_TITLE}</td>
	                  <td class="sorting">${list.REASON}</td>
	                  <td class="sorting">${list.MEM_NAME}</td>
	                  <td class="sorting">${list.BO_REG_DATE}</td>
	                  <td class="sorting"><button type="button" value="${list.BO_NO}" class="boardInfo btn-primary btn-sm"><span class="glyphicon glyphicon-search"></span></button></td>
	                </tr>  
                </c:forEach> 
  				</tbody>
                </table>
                </form>
		<br>
         <div class="layer">
         	          ${paging }
		</div>
                  </div>
               </div>
               <br>
          <button id="delBtn"type="button"  style="width:140px; margin-right:50px;" class="btn btn-danger btn-sm pull-right">삭제</button>
               <div class="row">
               

                  
               </div>
               
            </div>
         </div>
         
         
         
<!-- /.box-body -->
      </div>
             
             
             
              <!--게시글 뷰 모달창  -->

  <div class="modal fade" id="viewWrite" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        <form id="updateWriteForm" action="${pageContext.request.contextPath }/admin/board/updateWrite.do" method="post">
        <div class="modal-body">
             <div class="box">
            <div class="box-header">
        <p class="text-blue"><input type="text" class="" name="board_name" value="" disabled="disabled"> </p>
        <p class="text-green">등록일 : <input type="text" class="" name="bo_reg_date" value="" disabled="disabled"> </p>
               <h3 class="box-title">
                 <input type="text" name="bo_title" value="제목">  
                 <input type="hidden" name="bo_writer" value="">  
                 <input type="hidden" name="board_code" value="">  
                 <input class="boardNum" type="hidden" name="bo_no" value="">  
               </h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body pad">
            <div id="bo_content" style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; 
				border: 1px solid #dddddd; padding: 10px;"></div>
            </div>
         </div>

      </div>
     </form>
   </div>
   <div class="box">
         <h4 style="text-align: center;">신고사유</h4>
         <hr>
         <div id="reason" class="box-header">
         
         </div>
         <!-- /.box-header -->
         <div class="box-body">
            
        <div class="modal-footer">
          <button id="warn" value="" type="button" class="btn btn-danger">경고</button>
          <button id="ban" value="" type="button" class="btn btn-danger">탈퇴처리</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
        </div>
      </div>
      </div>
    </div>
  </div>

 <div class="modal fade" id="chkChoice" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-body">
        	<h4>게시글을 삭제하시겠습니까 ? </h4>
        <div class="modal-footer">
          <button id="delBoard" value="" type="button" class="btn btn-danger">삭제</button>
          <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
        </div>
      </div>
   </div>
    </div>
  </div>


  <!-- 아래 html 건들지 말것 -->
      </div>
            <!-- /.col-->

         </div>
         <!-- ./row --></section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
  </body>
<script type="text/javascript">
$(function(){
	if(eval('${!empty param.message}')){
		alert('${param.message}');
	};
	$('#btnCheck').click(function(){
		if ($('input[type=checkbox]').prop('checked')) {
			$('input[type=checkbox]').prop('checked',false);
		}else if ($('input[type=checkbox]').prop('checked',true)) {
			$('input[type=checkbox]').prop('checked',true);
		}
	});

	$('#btn1').click(function(){
		$(location).attr('href','${pageContext.request.contextPath}/admin/board/writeList.do');
	});
	$('#btn2').click(function(){
		$(location).attr('href','${pageContext.request.contextPath}/admin/board/blackList.do');
	});
	
	$(".boardInfo").click(function(){
        $("#viewWrite").modal({backdrop : 'static'});
    });
	$('.boardInfo').click(function(){
		var bo_no = $(this).val();
		$('textarea[name=comment_content]').val('');
    	$('#imageDiv').empty();
    	$('#bo_content').empty();
    	$('#reason').empty();
    	$('#bo_content').summernote({
      		 height: 300,                 // 썸머노트 높이
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
    	$.ajax({
    		url : '${pageContext.request.contextPath}/admin/board/writeView.do?bo_no='+bo_no,
    		success : function(data){
    			$('input[name=bo_title]').val(data.BO_TITLE);
    			$('.boardNum').val(data.BO_NO);
    			$('input[name=bo_writer]').val(data.BO_WRITER);
    			$('input[name=board_name]').val(data.BOARD_NAME);
    			$('input[name=bo_reg_date]').val(data.BO_REG_DATE);
    			$('input[name=board_code]').val(data.BOARD_CODE);
    			$('#bo_content').summernote('code',data.BO_CONTENT);
    			$('#bo_content').attr('readonly',true);
    			$('#warn').val(data.BO_WRITER+","+data.BO_NO);
    			$('#ban').val(data.BO_WRITER);
    			$('#delBoard').val(data.BO_NO);
    			var reason = data.reason;
    			for (var j = 0;  j< reason.length; ++j) {
	    			$('#reason').append("<p>"+reason[j].REASON +" &nbsp;&nbsp;&nbsp; : &nbsp;&nbsp;&nbsp;<span style='color:red;'>"+reason[j].COUNT+"건</span></p><br>");
				}
    			
		        $("#viewWrite").modal();
    			
    		},
    		error : function(res){
    			alert(res.status);
    		}
    	});
		
		
	});
	$('#delBtn').click(function(){
		var cnt = $('input:checkbox[name=bo_no]:checked').length;
		if (cnt>0) {
			$('#delForm').submit();
		}else{
			alert('삭제할 게시글을 선택해주세요.');
		}
	
	});
	$('#warn').click(function(){
		var id_bo_no = $(this).val();
		$.ajax({
			url : '${pageContext.request.contextPath}/admin/board/warnMember.do',
			data : "id_bo_no="+id_bo_no,
			type : 'POST',
			success : function(data){
				console.log(data);
				if (eval(data.result)&&eval(data.res)) {
					alert("경고 메세지 발송완료");
					ws.send('#msg#');
				}
			},
			error : function(res){
				alert(res.status);
			},complete :function(){
				$('#chkChoice').modal({backdrop : 'static'});
				
			}
		})
		
	});
	$('#ban').click(function(){
		var mem_id = $(this).val();
		$.ajax({
			url : '${pageContext.request.contextPath}/admin/member/delSecMember.do',
			data : "mem_id="+mem_id,
			type :'POST',
			success : function(data){
				if (eval(data.result)) {
					alert("탈퇴처리 완료");
				}
			},error : function(res){
				alert(res.status);
			},complete :function(){
				$('#chkChoice').modal({backdrop : 'static'});
			}
		})
	});
	$('#delBoard').click(function(){
		var bo_no = $(this).val();
		$.ajax({
			url : '${pageContext.request.contextPath}/admin/board/deleteboardWrite.do?bo_no='+bo_no,
			success : function(data){
				if (eval(data.result)) {
					$("#viewWrite").modal('hide');
					$('#chkChoice').modal('hide');
					alert("게시글 삭제완료");
					$(location).attr('href','${pageContext.request.contextPath}/admin/board/blackList.do?currentPage=${searchInfo.currentPage}&search=${searchInfo.search}&keyword=${searchInfo.keyword}&boardCategory=${param.boardCategory}');
				}
			},error : function(res){
				alert(res.status);
			}
		})
	});
	
});
function selectBoard(value){
	$(location).attr('href','${pageContext.request.contextPath}/admin/board/blackList.do?currentPage=${searchInfo.currentPage}&search=${searchInfo.search}&keyword=${searchInfo.keyword}&boardCategory='+value);
	
};
</script>
</html> 
  