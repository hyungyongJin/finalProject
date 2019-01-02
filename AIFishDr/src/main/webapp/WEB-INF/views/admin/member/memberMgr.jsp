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
		$(location).attr('href','${pageContext.request.contextPath}/admin/member/memberMgr.do');
	});
	$('#btn2').click(function(){
		$(location).attr('href','${pageContext.request.contextPath}/admin/member/secMemberMgr.do');
	});
	$('#btn3').click(function(){
		$(location).attr('href','${pageContext.request.contextPath}/admin/member/blackMemberMgr.do');
	});
	
	$('#asc').click(function(){
		$(location).attr('href','${pageContext.request.contextPath}/admin/member/memberMgr.do?commentCurrentPage=${param.commentCurrentPage}&search=${param.search}&keyword=${param.keyword}&asc='+$(this).val());
	});
	$('#desc').click(function(){
		$(location).attr('href','${pageContext.request.contextPath}/admin/member/memberMgr.do?commentCurrentPage=${param.commentCurrentPage}&search=${param.search}&keyword=${param.keyword}&desc='+$(this).val());
	});
	
	if (eval('${empty param.cnt}')) {
		$('select[name=cnt]').val('0');
	}else{
		$('select[name=cnt]').val('${param.cnt}');
	}
	$('#searchform').submit(function(){
		if ($('select[name=search]').val() != '') {
			if ($('input[name=keyword]').val() == '') {
				alert("검색어를 입력해 주세요");
				return false;
			}
		}
	});
	
	$('#sendEmail').click(function(){
		
		var chk = $('input:checkbox[name=mail]:checked').length;
		if (chk== 0) {
			alert("메일을 보낼 회원을 선택해 주세요.");
			return;
		}
		$('#selectedMem').empty();
		$('#WriteEmail').modal({backdrop : 'static'});
		$('#content').summernote({
	   		 height: 400,                 // 썸머노트 높이
	   		  minHeight: null,             // set minimum height of editor
	   		  maxHeight: null,             // set maximum height of editor
	   		  focus: false,        // set focus to editable area after initializing summernote
	   		  lang: 'ko-KR',
	   		  toolbar: [
	   		            // [groupName, [list of button]]
	   		            ['style', ['bold', 'italic', 'underline', 'clear']],
	   		            ['font', ['strikethrough', 'superscript', 'subscript']],
	   		            ['fontsize', ['fontsize']],
	   		            ['color', ['color']],
	   		            ['para', ['ul', 'ol', 'paragraph']],
	   		            ['height', ['height']],
	   		            ['picture'],
	   		            ['table']
	   		          ]
	   		});
		$('input[name=email_title]').val('');
		$('#content').summernote('code','');
		
		var data  = $('#chkMail').serialize();
		$.ajax({
			url : '${pageContext.request.contextPath }/admin/member/chkMail.do',
			data : data,
			type : 'POST',
			success : function(data){
				console.log('data',data);
				var mailList = data.stringList;
				var code = '';
				var receiver ='';
				for (var i = 0; i < mailList.length; i++) {
				code += '"'+mailList[i]+'",\n';
				receiver+=mailList[i]+',';
				}
				
				$('input[name=receiver]').val(receiver);
				$('#selectedMem').append(code);
			},error : function(res){
				alert(res.alert);
			},
				
		});
	});
	
	changeCnt = function(value){
		$(location).attr('href','${pageContext.request.contextPath}/admin/member/memberMgr.do?commentCurrentPage='
			+'${param.commentCurrentPage}&search=${param.search}&keyword=${param.keyword}&desc=${param.desc}&asc=${param.asc}&cnt='+value);		
	};
	
	$('#send').click(function(){
		$('input[name=email_content]').val($('#content').summernote('code'));
		if ($('input[name=email_title]').val()=='') {
			alert("제목을 입력해 주세요");
			return;
		}
		if ($('#content').summernote('code')=='') {
			alert("내용을 입력해 주세요");
			return;
		}
		var data = $('#mailForm').serialize();
		$.ajax({
			url : '${pageContext.request.contextPath }/admin/member/sendEmail.do',
			type : 'POST',
			data : data,
			success : function(data){
				alert(data.cnt.length+"명의 회원에게 메일 발송을 완료 했습니다.");
				$('#WriteEmail').modal('hide');
			},error : function(res){
				alert(res.status);
			}
		});
		
	});
	$('.makeExcel').click(function(){
		var chk = $(this).val();
		if (chk=='all') {
			$(location).attr('href','${pageContext.request.contextPath}/admin/member/downloadExcel.do?chk=all');
		}else{
			$(location).attr('href','${pageContext.request.contextPath}/admin/member/downloadExcel.do?commentCurrentPage='
					+'${param.commentCurrentPage}&search=${param.search}&keyword=${param.keyword}&desc=${param.desc}&asc=${param.asc}&cnt=${param.cnt}');
		}
		
 	});
	
	$('.detail').click(function(){
		$('#test').empty();
		$('#prsTable').empty();
		var mem_id = $(this).val();
		$('#mem_idc').val(mem_id);
		$('#chkPrs').modal({backdrop : 'static'});
		ajaxReq(1);
	})
	
	pdfInfo = function(value){
	    $('#test').html( '<button type="button" class="btn btn-danger pull-right" onclick="closePdf();">닫기</button><br>'
	    +'<embed src="/image/'+value+'.pdf" width="100%;" height="1000px;" type="application/pdf">'
	   );
	}
	closePdf= function(){
		 $('#test').empty();
	}
});




function ajaxReq(currentPage){
		var mem_id=$('#mem_idc').val();
		$.ajax({
			url : '${pageContext.request.contextPath}/admin/member/chkPrscrptn.do?mem_id='+mem_id+'&currentPage='+currentPage,
			success : function(data){
				var array= data.result;
				code = '';
				for (var i = 0; i < array.length; i++) {
					code +='<tr>';
					code +='<td class="sorting">'+array[i].PRSCRPTN_CODE+'</td>';
					code +='<td class="sorting">'+array[i].PRSCRPTN_REG_DATE+'</td>';
					code +='<td class="sorting">'+array[i].HOSPITAL_NAME+'</td>';
					code +='<td class="sorting">'+array[i].HOSPITAL_DR_NAME+'</td>';
					code +='<td class="sorting"><button type="button" onclick="pdfInfo(this.value);" value="'+array[i].PRSCRPTN_NAME+'" class="pdfInfo btn-primary btn-sm"><span class="glyphicon glyphicon-search"></span></button></td>';
					code +='</tr>';
				}
				$('#prsTable').html(code);
				$('#paging').html(data.pagenation);
			},
			error : function(res){
				alert(res.status);
			}
		})
}

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
            	<button id="btn1" type="button" style="width:200px;" class="btn btn-info btn-sm bg-maroon" >일반회원 관리</button>
            	<button id="btn2" type="button" style="width:200px;" class="btn btn-info btn-sm" >탈퇴신청회원 관리</button>
            	<button id="btn3" type="button" style="width:200px;" class="btn btn-danger btn-sm" >블랙리스트 회원관리</button>
            </div>
            <hr>
   
         <div class="box-header">
            <h3 class="box-title" >일반회원</h3>
         </div>
         
         <!-- /.box-header -->
         <div class="box-body">
  			<input type="hidden" id="mem_idc" value="">
         	
            <div id="example1_wrapper"
               class="dataTables_wrapper form-inline dt-bootstrap">
               <div class="row">
                  <div class="col-sm-12">
				<form id="searchform" action="${pageContext.request.contextPath }/admin/member/memberMgr.do" method="post">
                   <div class="dropdown">
					    <select name="cnt" class="form-control" onchange="changeCnt(this.value);">
						  <option value="0">15명씩 보기</option>
						  <option value="-1">50명씩 보기</option>
						</select>
						   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					    <select name="search" class="form-control">
						  <option value="">검색조건</option>
						  <option value="MEMBER">회원명</option>
						  <option value="NICK">닉네임</option>
						  <option value="PHONE">번호</option>
						</select>
					     &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					        <input name="keyword" type="search" class="form-control input-md" style="width:300px;" placeholder="검색어를 입력하세요.." aria-controls="example1">
					        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					        <button id="searchBtn" class="btn btn-primary btn-md" type="submit">검색</button>
					</div>
				</form>
					<br>
					<form id="chkMail"  method="post">
                <table id="example1" class="table table-bordered table-striped dataTable" role="grid" aria-describedby="example1_info">
                <thead>
                <tr role="row">
	                <th class="sorting" tabindex="0"  rowspan="1" colspan="1" style="width: 50px;"><button class="btn btn-primary btn-sm" type="button" id="btnCheck">선택</button></th>
	                <th class="sorting" tabindex="0"  rowspan="1" colspan="1" style="width: 100px;">회원ID</th>
	                <th class="sorting" tabindex="0"  rowspan="1" colspan="1" style="width: 100px;">회원명</th>
	                <th class="sorting" tabindex="0"  rowspan="1" colspan="1" style="width: 100px;">닉네임</th>
	                <th class="sorting" tabindex="0"  rowspan="1" colspan="1" style="width: 150px;">핸드폰</th>
	                <th class="sorting" tabindex="0"  rowspan="1" colspan="1" style="width: 150px;">메일주소</th>
	                <th class="sorting" tabindex="0"  rowspan="1" colspan="1" style="width: 150px;">가입일
	                <button id="asc" type="button" value="dateAsc" style="border: none; background-color: transparent;"><i class="fa fa-fw fa-toggle-down"></i></button>
	                <button id="desc" type="button" value="dateDesc" style="border: none; background-color: transparent;"><i class="fa fa-fw fa-toggle-up"></i></button> </th>
	                <th class="sorting" tabindex="0"  rowspan="1" colspan="1" style="width: 70px;">처방내역 확인</th>
                </tr>
                </thead>
                <tbody>
                 <c:forEach items="${ memList}" var="list"> 
	                <tr role="row" class="odd">
	                  <td class="sorting"><input type="checkbox" value="${list.mem_nickname }/${list.mem_mail }" name="mail"></td>
	                  <td class="sorting">${list.mem_id }</td>
	                  <td class="sorting">${list.mem_name }</td>
	                  <td class="sorting">${list.mem_nickname }</td>
	                  <td class="sorting">${list.mem_phone }</td>
	                  <td class="sorting">${list.mem_mail }</td>
	                  <td class="sorting">${list.mem_reg_date }</td>
	                  <td class="sorting"><button type="button" value="${list.mem_id}" class="detail btn btn-primary btn-sm"><span class="glyphicon glyphicon-search"></span></button></td>
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
               	<button id="sendEmail" type="button" class="btn btn-info pull-right" style="margin: -20px 80px 0px 0px;">메일 보내기</button>
                <div class="dropdown pull-right">
			  		<a href="#" class=" dropdown-toggle" data-toggle="dropdown"><button id="makeExcel" type="button" class="btn btn-info pull-right" style="margin: -20px 20px 0px 0px;">엑셀출력</button></a>
			  		<ul class="dropdown-menu">
			  			<li><a href="#"><button type="button" value="all" class="makeExcel btn" style="background: transparent;">전 체</button></a></li>
			  			<li><a href="#"><button type="button" value="part" class="makeExcel btn" style="background: transparent;">검색된 회원</button></a></li>
				  	</ul>
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
             
             
             
              <!--게시글 뷰 모달창  -->

  <div class="modal fade" id="WriteEmail" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
        <h4>메일발송</h4>
        </div>
        <form id="mailForm"  method="post">
        <div class="modal-body">
            <div class="box-header">
            	<label style="color: green;">받는회원 : </label><p id="selectedMem" ></p>
            	<hr>
               	<label style="color: green;" for="email_title">제목 :  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>
                 <input type="text" size="55%" name="email_title" value="">  
                 <br><br>
                 <div id="content">
                 </div>
                 <input  type="hidden" name="email_content" value="">  
                 <input  type="hidden" name="receiver" value="">  
            </div>

      </div>
     </form>
        <div class="modal-footer">
               <button id="send" type="button" class="btn btn-default">보내기</button>             
          <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
   </div>
      </div>
    </div>
  </div>

	<!-- 회원 처방내역 확인 -->
  <div class="modal fade" id="chkPrs" role="dialog">
    <div class="modal-dialog modal-lg">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
        <h4>회원 의약품 처방 내역</h4>
        </div>
        <div class="modal-body">
            <div class="box-header">
            <div id="test"></div>
            	<table class="table">
            		<thead>
            			<tr>
							<th class="sorting">처방코드</th>
							<th class="sorting">처방날짜</th>
							<th class="sorting">관리원명</th>
							<th class="sorting">처방 관리원장</th>
							<th class="sorting">상세보기</th>
            			</tr>
            		</thead>
            		<tbody id="prsTable">
            		</tbody>
            		<tfoot>
            			<tr>
            				<td id="paging" class="sorting" colspan="4"></td>
            			</tr>
            		</tfoot>
            	</table>
            </div>

      </div>
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

  
  