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
<link href='https://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
<style>
.layer{ position:relative; top:50%; left:40%; width:300px; height:100px; margin:-50px 0 0 -50px; }
.sorting{text-align: center;}
textarea {resize: none;}
.imgStyle{
width : 35px;
height : 35px;
border: 1px solid lightgrey;
border-radius: 7px;
-moz-border-radius: 7px;
-khtml-border-radius: 7px;
-webkit-border-radius: 7px;
}
ul.mylist, ol.mylist {
    list-style: none;
    margin: 0px 0px 0px 0px;
    padding: 0px;
}
ul.mylist li, ol.mylist li {
    padding: 0px 0px 5px 0px;
    margin-bottom: 0px;
    border-bottom: 1px solid #efefef;
    font-size: 12px;
}
ul.mylist li:last-child,
ol.mylist li:last-child {
    border-bottom: 0px;
}


 .cb { 
 	display: inline-block; 
 	width: 20px; 
 	height: 20px; 
 	border: 2px solid #bcbcbc; 
 	cursor: pointer; 
 } 

</style>
<script type="text/javascript">
window.onunload = function() { alert('ㅂㅂ');};
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
	$('#chkAll').click(function(){
		if ($('input[type=checkbox]').prop('checked')) {
			$('input[type=checkbox]').prop('checked',false);
		}else if ($('input[type=checkbox]').prop('checked',true)) {
			$('input[type=checkbox]').prop('checked',true);
		}
	});	
	
	$('#sendBtn').click(function(){
		var my_id = $(this).val();
		var cnt = $('input[type=checkbox]:checked').length;
		$('textarea[name=ms_content]').val($('#writeNote').val());
		if (cnt>0) {
			var data = $('form').serialize();
			
			$.ajax({
				url : '${pageContext.request.contextPath}/user/message/msgSend.do?my_id='+my_id,
				data : data,
				type : 'POST',
				success : function(data){
					if (eval(data.result)) {
						if (cnt==1) {
							alert("쪽지 발송완료.");
						}else{
							alert(cnt+"명의 친구에게 쪽지발송 완료.");
						}
					}else{
						alert("쪽지 발송 실패");
					}
				},error : function(res){
					alert(res.status);
				},complete : function(){
					$('textarea[name=ms_content]').val('');
					ws.send('#msg#');
				}
				
			});
			
		}else{
			alert("쪽지를 보낼 친구를 선택해 주세요.");
		}		
	});
	
	$('#copy').hide();
    $('#writeNote').keyup(function (e){
        var content = $(this).val();
        if (content.length > 300){
    	    alert("최대 300자까지 입력 가능합니다.");
    	    $(this).val(content.substring(0, 300));
    	    return;
    	}
        $('#content').html(content.length + '/300');
    });
    $('#writeNote').keyup();
});
var num =0;
function goChatModal(value){
	num += 1;
	var x = (screen.availWidth - 500) / 2;
	var y = (screen.availHeight - 650) / 2;
	var info = encodeURIComponent(value);
	var id = value.substring(value.indexOf('(')+1, value.lastIndexOf(')'));
	var array = new Array();
	array.push('/call/'+id);
	array.push('${LOGIN_MEMBER.mem_id}');
	ws.send(array);
	var url = "${pageContext.request.contextPath }/user/freeboard/chatModal.do?id="+info;
	var options = "width = 500, height = 650, scrollbars = no left="+x+", top="+y;
	window.open(url, "채팅하기"+num, options);
	
}
</script>
<body>
<div class="content-wrapper" style="margin-left:10px;">
 <!-- Main content -->
    <section class="content">
   <div class="row">
      <div class="col-md-12">

   <!-- 위 html 지우지 말 것  -->


	

   <div class="box">
   <hr>
      <div class="box-body pad">
            	<button id="btn1" type="button" style="width:200px;" class="btn btn-info btn-sm bg-maroon" >받은 쪽지함</button>
            	<button id="btn2" type="button" style="width:200px;" class="btn btn-info btn-sm" >보낸 쪽지함</button>
            	<button id="btn3" type="button" style="width:200px;" class="btn bg-purple btn-sm" >쪽지 쓰기</button>
            </div>
            <hr>
   
         <div class="box-header">
            <h3 class="box-title" >친구목록</h3>
            <hr>
            <a href="#"><button  id="chkAll" class="btn btn-info"  type="button">전체선택</button></a>
         </div>
         
         <!-- /.box-header -->
         <div class="box-body">
  
         	
            <div id="example1_wrapper"
               class="dataTables_wrapper form-inline dt-bootstrap">
               <div class="row">
                  <div class="col-sm-4" style="margin-left:50px; height: 500px; overflow-y: auto;">
                  <form>
					<ul class="mylist">
					<c:forEach items="${ friendList}" var="list">
	             	<li>
	                 	<div class="dropdown">
                 		<input class="cb" type="checkbox" value="${list.MEM_ID }" name="me_get_id"> &nbsp;&nbsp;
	             		<a href="#" class=" dropdown-toggle" data-toggle="dropdown">
                 		<img class="imgStyle" onerror="this.src='${pageContext.request.contextPath }/dist/img/person_icon.png'" src="/image/${list.FP_FILE_SAVE_NAME }">
                 		&nbsp;&nbsp;&nbsp;<span style="font-size: 1.5em;">${list.MEM_NICKNAME }</span></a>
						<ul class="dropdown-menu">
							<li><a href="#"><span onclick="goChatModal('${list.MEM_NICKNAME }(${list.MEM_ID})');">1:1 채팅하기</span></a></li>
							<li><a href="${pageContext.request.contextPath }/user/fishgram/fishgramYouList.do?mem_id=${list.MEM_ID}">블로그가기</a></li>
						</ul>
						</div>
                 	</li>
                 	
                 	
                 	
                 	<br>
                </c:forEach> 
					</ul>
						<textarea name="ms_content" id="copy"></textarea>
                  </form>

		<br>
         <div class="layer">
       	  <br>
         	 ${paging }
		</div>
                  
                  
                  
                  </div>
                  <div class="col-sm-6" style="margin-left: 100px; " >
                  <div class="send_window">
				<div class="toady_sent">
				</div>
				<div id="replyMode" style="display: block;">
					<span class="tf_tit">
						<span class="recipient">쪽지 쓰기 </span>
					</span>
						<span class="tf_cont">
					</span>
				</div>
				<br>
				<div class="writing_area" >
					<textarea id="writeNote" name="ms_content" style=" resize:none;"  rows="10" cols="70" title="쪽지 내용을 입력해 주세요."></textarea>
				</div>
				<div class="writing_option">
					<div class="character">
						<span id="content"></span> 
				</div>
			</div>
				
			<div class="btns">				
				<a href="#"><button  id="sendBtn" class="btn btn-info" 
				value="${LOGIN_MEMBER.mem_id }" style="margin-left: 35%;" type="button">보내기</button></a>
			</div>
		</div>   
                  
                  </div>
                  
               </div>
               <br>
               <div class="row">
               
                  
               </div>
               
            </div>
         </div>
         
         
         
<!-- /.box-body -->
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

  
  