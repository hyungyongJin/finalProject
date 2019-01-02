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
<style>
.layer{ position:relative; top:50%; left:40%; width:300px; height:100px; margin:-50px 0 0 -50px; }
.sorting{text-align: center;}
textarea {resize: none;}
</style>
<script type="text/javascript">
$(function(){
	//자바스크립트 코딩
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
		$(location).attr('href','${pageContext.request.contextPath}/user/message/messageList.do');
	});
	$('#btn2').click(function(){
		$(location).attr('href','${pageContext.request.contextPath}/user/message/sendMessageList.do');
	});
	$('#btn3').click(function(){
		$(location).attr('href','${pageContext.request.contextPath}/user/message/sendMessage.do');
	});
	if (eval('${empty param.cnt}')) {
		$('select[name=cnt]').val('0');
	}else{
		$('select[name=cnt]').val('${param.cnt}');
	}
	changeCnt = function(value){
		$(location).attr('href','${pageContext.request.contextPath}/user/message/sendMessageList.do?commentCurrentPage='
			+'${param.commentCurrentPage}&cnt='+value);		
	};

	$('.viewMsg').click(function(){
		var msgInfo = $(this).val();
		msgInfo = msgInfo.split("/*-");
		if (msgInfo.length == 6) {
			showView(msgInfo);
		}else{
			$.ajax({
				url : '${pageContext.request.contextPath}/user/message/checkReadMsg.do',
				data : "ms_no="+msgInfo[4],
				type : 'POST',
				success : function(data){
					if (eval(data.result)) {
						showView(msgInfo);
					}
				},error : function(res){
					alert(res.status);
				}
			})
		}
		
	})
	showView = function(msgInfo){
		$('#detailView').modal({backdrop : 'static'});
		$('#send_mem').text(msgInfo[0]);
		$('#send_date').text(msgInfo[1]);
		var content = replaceAll(msgInfo[2],'\'','\"')
		$('#content').val(content);
		$('#goBlog').attr('href','${pageContext.request.contextPath }/user/fishgram/fishgramYouList.do?mem_id='+msgInfo[3]);
		$('#send').val(msgInfo[0]);
	}
	replaceAll = function(str, searchStr, replaceStr){
		return str.split(searchStr).join(replaceStr);
	}
	
	
	$('#delMsg').click(function(){
		var cnt = $('input[name=ms_no]:checked').length;
		if (cnt > 0) {
			var data = $('#delForm').serialize();
			$.ajax({
				url : '${pageContext.request.contextPath}/user/message/delSendMsg.do',
				data : data,
				type : 'POST',
				success : function(data){
					if (eval(data.result)) {
						alert(cnt+"건의 쪽지 삭제 완료");
					}
				},error : function(res){
					alert(res.status);
				},complete : function(){
					$(location).attr('href','${pageContext.request.contextPath}/user/message/sendMessageList.do?cnt=${param.cnt}');
				}
			})
		}else{
			alert("삭제할 쪽지를 선택해주세요.");
		}
	})
	
});
</script>
<body>
<div class="content-wrapper" style="margin-left:10px;">
 <!-- Main content -->
    <section class="content">
   <div class="row">
      <div class="col-md-12">

   <!-- 위 html 지우지 말 것  -->


	

   <div class="box" id="boardMgr">
   <hr>
      <div class="box-body pad">
            	<button id="btn1" type="button" style="width:200px;" class="btn btn-info btn-sm bg-maroon" >받은 쪽지함</button>
            	<button id="btn2" type="button" style="width:200px;" class="btn btn-info btn-sm" >보낸 쪽지함</button>
            	<button id="btn3" type="button" style="width:200px;" class="btn bg-purple btn-sm" >쪽지 쓰기</button>
            </div>
            <hr>
   
         <div class="box-header">
            <h3 class="box-title" >보낸 쪽지함</h3>
         </div>
         
         <!-- /.box-header -->
         <div class="box-body">
  
         	
            <div id="example1_wrapper"
               class="dataTables_wrapper form-inline dt-bootstrap">
               <div class="row">
                  <div class="col-sm-12">
                   <div class="dropdown">
					    <select name="cnt" class="form-control" onchange="changeCnt(this.value);">
						  <option value="0">15개씩 보기</option>
						  <option value="-1">50개씩 보기</option>
						</select>
					</div>
					<br>
					<form id="delForm"  method="post">
                <table id="example1" class="table table-bordered table-striped dataTable" role="grid" aria-describedby="example1_info">
                <thead>
                <tr role="row">
	                <th class="sorting" tabindex="0"  rowspan="1" colspan="1" style="width: 10%;"><button class="btn btn-primary btn-sm" type="button" id="btnCheck">선택</button></th>
	                <th class="sorting" tabindex="0"  rowspan="1" colspan="1" style="width: 10%;">받는사람</th>
	                <th class="sorting" tabindex="0"  rowspan="1" colspan="1" style="width: 60%;">내용</th>
	                <th class="sorting" tabindex="0"  rowspan="1" colspan="1" style="width: 10%;">보낸날짜</th>
	                <th class="sorting" tabindex="0"  rowspan="1" colspan="1" style="width: 10%;">받은날짜</th>
                </tr>
                </thead>
                <tbody id="msgListBody">
                 <c:forEach items="${ msgList}" var="list"> 
	                <tr role="row" class="odd">
	                  <td class="sorting"><input type="checkbox" value="${list.MS_NO }" name="ms_no"></td>
	                  <td class="sorting"><a style="color: red;" href="#">${list.MEM_NICKNAME }</a></td>
	                  <c:if test="${fn:length(list.MS_CONTENT)>30 }">
		                  <td ><a href="#"><button type="button" value="${list.MEM_NICKNAME }(${list.MS_SEND_ID})/*-${list.MS_SEND_DATE }/*-${fn:replace(list.MS_CONTENT,'\"','\'')  }/*-${list.MS_SEND_ID}/*-${list.MS_NO }" class="viewMsg" style="background-color: transparent; border: none;"> ${fn:substring(list.MS_CONTENT,0, 30) }...</button></a></td>
	                  	</c:if>
	                  	<c:if test="${fn:length(list.MS_CONTENT)<30 }">
		                  <td><a href="#"><button type="button" value="${list.MEM_NICKNAME }(${list.MS_SEND_ID})/*-${list.MS_SEND_DATE }/*-${fn:replace(list.MS_CONTENT,'\"','\'') }/*-${list.MS_SEND_ID}/*-${list.MS_NO }" class="viewMsg" style="background-color: transparent; border: none;"> ${list.MS_CONTENT }</button></a></td>
	                  	</c:if>
	                  <td class="sorting">${list.MS_SEND_DATE }</td>
	                  <td class="sorting">${list.MS_GET_DATE }</td>
	                </tr>  
                </c:forEach> 
  				</tbody>
                </table>
                </form>
		<br>
         <div class="layer">
       	  <br>
         	 ${paging }
		</div>
               	<button id="delMsg" type="button" class="btn btn-danger pull-right" style="margin: -20px 80px 0px 0px;">삭제</button>
                  
                  
                  
                  </div>
               </div>
               <br>
               <div class="row">

                  
               </div>
               
            </div>
         </div>
         
         
         
<!-- /.box-body -->
      </div>
             
             
             
              <!--게시글 뷰 모달창  -->

  <div class="modal fade" id="detailView" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <form id="mailForm"  method="post">
        <div class="modal-body">
            <div class="box-header">
            	<label style="font: bold;">보낸사람: &nbsp;&nbsp; &nbsp;&nbsp; </label><a id="goBlog"><span id="send_mem" ></span></a><br>
            	<label style="font: bold;">보낸날짜: &nbsp;&nbsp; &nbsp;&nbsp; </label><span id="send_date" ></span>
            	<hr>
                 <textarea id="content" rows="10"  readonly="readonly" style="border:none; width:100%; resize:none;"></textarea>
            </div>

      </div>
     </form>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
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
</html>

  
  