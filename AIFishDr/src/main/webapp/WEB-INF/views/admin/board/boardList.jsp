<%--==============================================================
 * jsp 개요 : 
 * @author : 
 * @since : 2018. 11. 12.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일                          수정자                       수정내용
 *    -------      -------     -------------------
 *    2018. 11. 12.        진형용                      최초작성
 * Copyright (c) 2018 AI Fish Dr. All right reserved
 * </pre>
===============================================================--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<head>
<style type="text/css">
 table, th{text-align: center;} 
 .sorting{text-align: center;} 






.container {
  margin: 0 auto;
  padding: 90px 0;
  width: 400px;
  background-image: -webkit-radial-gradient(center, farthest-side, rgba(255, 255, 255, 0.1), rgba(255, 255, 255, 0));
  background-image: -moz-radial-gradient(center, farthest-side, rgba(255, 255, 255, 0.1), rgba(255, 255, 255, 0));
  background-image: -o-radial-gradient(center, farthest-side, rgba(255, 255, 255, 0.1), rgba(255, 255, 255, 0));
  background-image: radial-gradient(center, farthest-side, rgba(255, 255, 255, 0.1), rgba(255, 255, 255, 0));
}

.switch {
  position: relative;
  margin: 20px auto;
  height: 26px;
  width: 120px;
  background: rgba(0, 0, 0, 0.25);
  border-radius: 3px;
  -webkit-box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.3), 0 1px rgba(255, 255, 255, 0.1);
  box-shadow: inset 0 1px 3px rgba(0, 0, 0, 0.3), 0 1px rgba(255, 255, 255, 0.1);
}

.switch-label {
  position: relative;
  z-index: 2;
  float: left;
  width: 58px;
  line-height: 26px;
  font-size: 11px;
  color: rgba(255, 255, 255, 0.35);
  text-align: center;
  text-shadow: 0 1px 1px rgba(0, 0, 0, 0.45);
  cursor: pointer;
}
.switch-label:active {
  font-weight: bold;
}

.switch-label-off {
  padding-left: 2px;
}

.switch-label-on {
  padding-right: 2px;
}


.switch-input {
  display: none;
}
.switch-input:checked + .switch-label {
  font-weight: bold;
  color: rgba(0, 0, 0, 0.65);
  text-shadow: 0 1px rgba(255, 255, 255, 0.25);
  -webkit-transition: 0.15s ease-out;
  -moz-transition: 0.15s ease-out;
  -o-transition: 0.15s ease-out;
  transition: 0.15s ease-out;
}
.switch-input:checked + .switch-label-on ~ .switch-selection {
  left: 60px;
  /* Note: left: 50% doesn't transition in WebKit */
}

.switch-selection {
  display: block;
  position: absolute;
  z-index: 1;
  top: 2px;
  left: 2px;
  width: 58px;
  height: 22px;
  background: #65bd63;
  border-radius: 3px;
  background-image: -webkit-linear-gradient(top, #9dd993, #65bd63);
  background-image: -moz-linear-gradient(top, #9dd993, #65bd63);
  background-image: -o-linear-gradient(top, #9dd993, #65bd63);
  background-image: linear-gradient(to bottom, #9dd993, #65bd63);
  -webkit-box-shadow: inset 0 1px rgba(255, 255, 255, 0.5), 0 0 2px rgba(0, 0, 0, 0.2);
  box-shadow: inset 0 1px rgba(255, 255, 255, 0.5), 0 0 2px rgba(0, 0, 0, 0.2);
  -webkit-transition: left 0.15s ease-out;
  -moz-transition: left 0.15s ease-out;
  -o-transition: left 0.15s ease-out;
   transition: left 0.15s ease-out;
  } 



</style>
</head>
<body>
<div class="content-wrapper" style="margin-left:10px;">
 <!-- Main content -->
    <section class="content">
   <div class="row">
      <div class="col-md-12">

   <!-- 위 html 지우지 말 것  -->

       
          
      <div class="box">
            <div class="box-header">
           	 <h3 class="box-title" >게시판 관리</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <div id="example1_wrapper" class="dataTables_wrapper form-inline dt-bootstrap">
              <div class="row">
              	<div class="col-sm-6">
              		<div class="dataTables_length" id="example1_length">
              		</div>
              	</div><div class="col-sm-6">
              </div></div><div class="row"><div class="col-sm-12"><div id="example1_filter" class="dataTables_filter">
              </div>
              <form id="deleteBoard" method="post" action="${pageContext.request.contextPath }/admin/board/deleteBoard.do">
              <table id="example1" class="table table-bordered table-striped dataTable" role="grid" aria-describedby="example1_info">
                <thead>
                <tr role="row">
	                <th class="sorting_asc" tabindex="0"  rowspan="1" colspan="1" style="width: 50px;"><button class="btn btn-primary" type="button" id="btnCheck">선택</button></th>
	                <th class="sorting" tabindex="0"  rowspan="1" colspan="1" style="width: 361px;">게시판명</th>
	                <th class="sorting" tabindex="0"  rowspan="1" colspan="1" style="width: 322px;">게시판영문테이블명</th>
	                <th class="sorting" tabindex="0"  rowspan="1" colspan="1" style="width: 257px;">게시판 댓글기능</th>
	                <th class="sorting" tabindex="0"  rowspan="1" colspan="1" style="width: 257px;">게시판 파일기능</th>
	                <th class="sorting" tabindex="0"  rowspan="1" colspan="1" style="width: 190px;">상세보기</th>
                </tr>
                </thead>
                <tbody id="boardTable">
                
                <c:forEach items="${ boardList}" var="list">
                <tr role="row" class="odd">
                  <td class="sorting_1"><input type="checkbox" value="${list.board_code }" name="board_code"></td>
                  <td>${list.board_name}</td>
                  <td>${list.board_eng_name}</td>
                  <td> 
                  <c:if test="${list.board_function =='1' }">
                  	댓글불가능
                  </c:if>
                  <c:if test="${list.board_function =='0' }">
                  	댓글가능
                  </c:if>
                  </td>
                  <td> 
                  <c:if test="${list.board_function2 =='3' }">
                  	파일 등록 불가능
                  </c:if>
                  <c:if test="${list.board_function2 =='2' }">
                  	파일 등록 가능
                  </c:if>
                  </td>
                  <td><button type="button" value="${list.board_code }" class="boardInfo btn btn-primary" data-toggle="modal" data-target="#myModal"><span class="glyphicon glyphicon-search"></span></button></td>
                </tr>  
                </c:forEach>
                
                
  				</tbody>
                </table>
                <button id="deleteBtn" type="button"  style="width:140px; margin-right: 50px;" class="btn btn-danger btn-md pull-right">게시판 삭제</button>
                  <button id="genBtn" type="button"  style="width:140px; margin-right: 50px;" class="btn btn-info btn-md pull-right" data-backdrop="static"  data-toggle="modal" data-target="#createModal" >게시판 생성</button>
                </form>
              
                </div>
                <div class="col-sm-12" style="height: 10px;"></div>
     
          <div class="col-sm-6">
       	   		  <form>
       	   <table id="example1" class="table table-bordered table-striped dataTable">
       	   	<tr style="background-color: lightblue;" >
       	   		<th>질병명</th>
       	   		<th>처방횟수&nbsp;&nbsp;&nbsp;
       	   		 <input id="cnt" onkeyup="this.value=this.value.replace(/[^0-9]/g,'')" type="text" name="cnt" value=""  placeholder="횟수" size="1" class="form-control">
       	   		  <button type="button" class="findDiss btn btn-flat btn-primary "><span class="glyphicon glyphicon-search"></span></button></th>
       	   	</tr>
       	   	<c:forEach items="${prs_cntList}" var="list">
       	   	<tr>
       	   		<td>${list.DISS_NAME }</td>
       	   		<td>${list.COUNT }</td>
       	   	</tr>
       	   	</c:forEach>
       	   	<tfoot>
       	   	<tr style="max-height: 25px;">
       	   		<td colspan="2">
       	   		${paging}
              <input id="search" type="text"  name="search" value="" placeholder="질병명 검색" class="form-control">
                <button class="findDiss btn bg-purple">검색</button>
       	   		</td>
       	   	</tr>
       	   	</tfoot>
       	   </table>
                </form>
          </div>     
           
                 <div class="col-sm-6">     
         <div class="box box-danger" style="background-color: #FBF8EF;">
            <div class="box-header with-border">
              <div class="box-tools pull-right">
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
              </div>
            </div>
            <div class="box-body chart-responsive">
           	 <div id="fishRatio" style="width:300; height: 350px; "></div>
            </div>
       </div>
         </div>    
                
                
                
                </div>
              <div class="row"><div class="col-sm-5">
              </div>
<%--      			  ${paging } --%>
              </div>
              </div>
              </div>
              
              
              
     
           <!-- 일정횟수 병명리스트 나올 테이블  -->
              
              </div>
              </div>
            </div>
            </section>
            <!-- /.box-body -->
          </div>
          
          
          
          
          
          <!--모달  -->

  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog modal-md">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h3 class="modal-title" style="text-align:center;">게시판 수정</h3>
        </div>
        <div class="modal-body">
          
          <div class="box box-info">
            <div class="box-header with-border">
            </div>
            <!-- /.box-header -->
            <!-- form start -->
            <form id="updateBoardForm" class="form-horizontal" method="post">
             <table  >
             	<tr>
             		<th style="width:15%; "><p>코드</p></th>
             		<th style="width:30%; "><p>게시판 명</p></th>
             		<th style="width:25%; "><p>댓글기능</p></th>
             		<th style="width:35%; "><p>파일기능</p></th>
             	</tr>
              <tr>
                  <td><input type="text" class="form-control"  name="board_code" value="" disabled="disabled">
                  <input type="hidden" name="board_code" value=""></td>
                  <td><input type="text" class="form-control"  name="board_name" value="${list.board_name}"></td>
                  <td>
                  <select class="form-control" name="board_function">
                  	<option value="0">댓글가능</option>
                  	<option value="1" >댓글불가능</option>
                  </select></td>
                  <td><select class="form-control" name="board_function2">
                  	<option value="2" >파일등록 가능</option>
                  	<option value="3" >파일등록 불가능</option>
                  </select></td>
                  </tr>
             </table>
          </form>
        </div>
        <div class="modal-footer">
               <button id="updateBoard" type="button" class="btn btn-default" data-dismiss="modal">수정</button>             
          <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
        </div>
      </div>
      </div>
    </div>
  </div>
  
  
                <!--게시판 생성 모달창  -->

  <div class="modal fade" id="createModal" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h3 class="modal-title" style="text-align:center;">게시판 생성</h3>
        </div>
        <div class="modal-body">
          
          <div class="box box-info">
            <div class="box-header with-border">
            </div>
            <!-- /.box-header -->
            <!-- form start -->
 		<form id="insertForm" action="${pageContext.request.contextPath }/admin/board/insertBoard.do"  class="form-horizontal" method="post">
             <table class="table table-bordered table-striped dataTable">
             	<tr>
             		<th>게시판 명</th>
             		<th>게시판 영문명</th>
             		<th colspan="2">기능 선택</th>
             	</tr>
             	<tr>
             		<td><input id="nm" class="form-control" type="text" name="board_name" value="">
             		<br><p class="text-green">ex) 자유게시판</p>
             		</td>
             		<td><input id="enm" class="form-control" type="text" name="board_eng_name" value="">
             		<br><p class="text-green">ex) freeboard</p>
             		</td>
             		<td >
             		    <p class="text-green">댓글</p>
             		    <div class="switch">
					      <input type="radio" class="switch-input" name="board_function" value="1" id="week" checked>
					      <label for="week" class="switch-label switch-label-off">불가</label>
					      <input type="radio" class="switch-input" name="board_function" value="0" id="month">
					      <label for="month" class="switch-label switch-label-on">가능</label>
					      <span class="switch-selection"></span>
					    </div>
             		</td>
             		<td >
             		    <p class="text-green">파일등록</p>
             		    <div class="switch">
					      <input type="radio" class="switch-input" name="board_function2" value="3" id="week1" checked>
					      <label for="week1" class="switch-label switch-label-off">불가</label>
					      <input type="radio" class="switch-input" name="board_function2" value="2" id="month1">
					      <label for="month1" class="switch-label switch-label-on">가능</label>
					      <span class="switch-selection"></span>
					    </div>
                  	</td>
             	</tr>
             </table>
          </form>
        </div>
        <div class="modal-footer">
               <button id="insertBoard" type="button" class="btn btn-default" data-dismiss="modal">등록</button>             
          <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
        </div>
      </div>
      </div>
    </div>
  </div>
      <!-- 게시판 생성시 나타날 모달 -->
      	<div class="modal" id="waitModal" tabindex="-1" role="dialog">
	<div class="modal-dialog modal-md">
		<div class="modal-content">
			<div class="modal-body">
			<span id="showWait" style="color: green; font-size: 15pt;"> </span>
			<p>
			<br>
			<img style="margin-left: 35%;" src="${pageContext.request.contextPath }/images/waitingIcon.gif">
			</div>
		</div>
	</div>
</div>
      	<div class="modal" id="completeModal" tabindex="-1" role="dialog">
	<div class="modal-dialog modal-md">
		<div class="modal-content">
			<div class="modal-body">
			<span id="showWait" style="color: green; font-size: 15pt;">게시판 생성이 완료되었습니다. </span>
			 <button id="refreshList" type="button" class="btn btn-default pull-right" style="margin-right: 30px;" data-dismiss="modal">닫기</button>
			</div>
		</div>
	</div>
</div>
      
          
          
 <!-- 아래 html 건들지 말것 -->
    
    
  </body>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">

$(function(){
	if(eval('${!empty message}')){
		alert('${message}');
	};

	
	
	//게시판 삭제
	$('#deleteBtn').click(function(){
		//체크박스 선택된 갯수
		var cnt = $('input:checkbox[name=board_code]:checked').length;
		
		if (cnt>0) {
			$('#deleteBoard').submit();
		}else{
			alert('삭제할 게시판을 선택해주세요.');
		}
	});
	
	$('#btnCheck').click(function(){
		if ($('input[type=checkbox]').prop('checked')) {
			$('input[type=checkbox]').prop('checked',false);
		}else if ($('input[type=checkbox]').prop('checked',true)) {
			$('input[type=checkbox]').prop('checked',true);
		}
	});
	
	$('.boardInfo').click(function(){
		var board_code = $(this).val();
		
		 $.ajax({
			url : '${pageContext.request.contextPath}/admin/board/boardView.do?board_code='+board_code,
			dataType : 'json',		
			success : function(result){
				console.log(result);
				$('input[name=board_code]').val(result.board_code);
				$('input[name=board_name]').val(result.board_name);
				$('input[name=board_eng_name]').val(result.board_eng_name);
				$('select[name=board_function]').val(result.board_function);
				$('select[name=board_function2] option').val(result.board_function2);
				
				
			},
			error : function(rs){
				alert(rs.status);
			}
			
		}); 
	});
	
	//게시판 생성 버튼
	$('#insertBoard').click(function(){

		//게시판 등록전 정규식
		if (!$('#nm').val().match(/[가-힣a-zA-Z0-9]{4,15}$/)) {
			alert('게시판명을 예시에 맞게 입력해 주세요.\n 4~15자리로 입력해 주세요)');
			return;
		}
		if (!$('#enm').val().match(/[a-zA-Z0-9]{4,15}/)) {
			alert('게시판 영문명을 입력해 주세요.\n 4~15자리로 입력해 주세요');
			return;
		}else{
			if ($('#enm').val().indexOf('board') == -1) {
				var board = $('#enm').val();
				board += 'board';
				$('#enm').val(board);
			}
		}

		
		
		var param = "board_name="+$('#nm').val()+"&board_eng_name="+$('#enm').val();
		$.ajax({
			url :  '${pageContext.request.contextPath }/admin/board/boardCheck.do',
			data : param,
			type : 'POST',
			success : function(data){
				if(eval(data.result)){
					alert("같은 이름으로 생성된 게시판이 존재합니다.");
				}else{
					generator();
				}
			},
			error : function(res){
				alert(res.status);
			}
		});
	});
		generator = function(){
			var data = $('#insertForm').serialize();
			$.ajax({
				url :  '${pageContext.request.contextPath }/admin/board/insertBoard.do',
				data : data,
				type : 'POST',
				success : function(result){
					$('#waitModal').modal({
						backdrop : 'static',
						keyboard : true
					});
					$('#showWait').text("\""+result.boardManageVO.board_name+"\" 게시판을 생성중입니다. 잠시만 기다려 주세요.");
					setTimeout(function() {
						$('#waitModal').modal('hide');
						$('#completeModal').modal();
						}, 30000);
					$('#nm').val('');
					$('#enm').val('');
					$('#week').prop('checked',true);
					$('#week1').prop('checked',true);
				
				},
				error : function(res){
					alert(res.status);
				}
			});
		}
	$('#genBtn').click(function(){
		$('#nm').val('');
		$('#enm').val('');
	})
	
	$('#updateBoard').click(function(){
		$('#updateBoardForm').attr('action','${pageContext.request.contextPath}/admin/board/updateBoard.do');
		$('#updateBoardForm').submit();
	});
	
	
	google.charts.load('current', {packages: ['corechart']});
	google.charts.setOnLoadCallback(drawChart);
	function drawChart() {
    var data = google.visualization.arrayToDataTable([
   	  ['게시판명', '글작성 수'],
	<c:forEach items="${eachBoardcount}" var="list">
   	  ['${list.BOARD_NAME}',parseInt('${list.WRITE_COUNT}')],
	</c:forEach>
  	 ]);
   var options = {
     title: '게시판 이용현황',
     is3D: true,
     backgroundColor : "#FBF8EF"
   };

   var chart = new google.visualization.PieChart(document.getElementById('fishRatio'));

   chart.draw(data, options);
 }
	
// 	$('#cnt').keypress(function (event) { 
// 		if ($(this).val().length > 4) {
// 			alert("ss")
// 		}
// 		if (event.which && (event.which <= 47 || event.which >= 58) && event.which != 8) { 
// 			event.preventDefault(); 
// 		} 
// 	});
	
	$('#refreshList').click(function(){
		$(location).attr('href','${pageContext.request.contextPath}/admin/board/boardList.do');
	})

	
	$('.findDiss').click(function(){
		var search = $('#search').val();
		var cnt = $('#cnt').val();
		$(location).attr('href','${pageContext.request.contextPath}/admin/board/boardList.do?currentPage=${param.currentPage}'
			+'&search='+ encodeURIComponent(search)+'&cnt='+cnt);
	});
	
	
	
});
</script>
