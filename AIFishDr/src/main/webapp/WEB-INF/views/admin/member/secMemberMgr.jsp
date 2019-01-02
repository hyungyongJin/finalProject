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
		$(location).attr('href','${pageContext.request.contextPath}/admin/member/secMemberMgr.do?commentCurrentPage=${param.commentCurrentPage}&search=${param.search}&keyword=${param.keyword}&asc='+$(this).val());
	});
	$('#desc').click(function(){
		$(location).attr('href','${pageContext.request.contextPath}/admin/member/secMemberMgr.do?commentCurrentPage=${param.commentCurrentPage}&search=${param.search}&keyword=${param.keyword}&desc='+$(this).val());
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
	
	$('#secBtn').click(function(){
		
		var chk = $('input:checkbox[name=mem_id]:checked').length;
		if (chk== 0) {
			alert("탈퇴할 회원을 선택해 주세요.");
			return;
		}
		var data = $("#delMem").serialize();
		$.ajax({
			url : '${pageContext.request.contextPath}/admin/member/delSecMember.do',
			data : data,
			type : 'POST',
			success : function(data){
				if (data.result) {
					alert(chk+"명의 회원이 탈퇴승인 되었습니다.");
					$(location).attr('href','${pageContext.request.contextPath}/admin/member/secMemberMgr.do?'
							+'commentCurrentPage=${param.commentCurrentPage}&search=${param.search}&keyword=${param.keyword}&desc=${param.desc}&asc=${param.asc}');
				}else{
					alert("탈퇴 승인 실패. 다시 시도해 주세요");
				}
			},error : function(res){
				alert(res.status);
			}
		});
		
	});
	
	changeCnt = function(value){
		$(location).attr('href','${pageContext.request.contextPath}/admin/member/secMemberMgr.do?commentCurrentPage='
			+'${param.commentCurrentPage}&search=${param.search}&keyword=${param.keyword}&desc=${param.desc}&asc=${param.asc}&cnt='+value);		
	};
	

	
	//탈퇴 사유 통계
	var list = new Array();
	
	list.push(new data('정보 부족','${secStat.REASON1}'));
	list.push(new data('서비스기능 불편','${secStat.REASON2}'));
	list.push(new data('개인정보 및 보안 우려','${secStat.REASON3}'));
	list.push(new data('기타','${secStat.REASON4}'));
		
		
	var donut = new Morris.Donut({
	      element: 'writeRatio',
	      resize: true,
	      colors: ["#3c8dbc", "#f56954", "#00a65a", "#DA81F5"],
	      data: list,
	      hideHover: 'auto'
	    });
	 
});
function data(reason , cnt){
	this.label = reason;
	this.value = cnt;
	return this.boardName +","+this.writeCount;
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
            <h3 class="box-title" >탈퇴 신청회원</h3>
         </div>
         
         <!-- /.box-header -->
         <div class="box-body">
  
         	
            <div id="example1_wrapper"
               class="dataTables_wrapper form-inline dt-bootstrap">
               <div class="row">
                  <div class="col-sm-12">
				<form id="searchform" action="${pageContext.request.contextPath }/admin/member/secMemberMgr.do" method="post">
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
					<form id="delMem"  method="post">
                <table id="example1" class="table table-bordered table-striped dataTable" role="grid" aria-describedby="example1_info">
                <thead>
                <tr role="row">
	                <th class="sorting" tabindex="0"  rowspan="1" colspan="1" style="width: 50px;"><button class="btn btn-primary btn-sm" type="button" id="btnCheck">선택</button></th>
	                <th class="sorting" tabindex="0"  rowspan="1" colspan="1" style="width: 100px;">회원ID</th>
	                <th class="sorting" tabindex="0"  rowspan="1" colspan="1" style="width: 100px;">회원명</th>
	                <th class="sorting" tabindex="0"  rowspan="1" colspan="1" style="width: 100px;">닉네임</th>
	                <th class="sorting" tabindex="0"  rowspan="1" colspan="1" style="width: 150px;">핸드폰</th>
	                <th class="sorting" tabindex="0"  rowspan="1" colspan="1" style="width: 150px;">메일주소</th>
	                <th class="sorting" tabindex="0"  rowspan="1" colspan="1" style="width: 150px;">탈퇴사유</th>
	                <th class="sorting" tabindex="0"  rowspan="1" colspan="1" style="width: 150px;">가입일
	                <button id="asc" type="button" value="dateAsc" style="border: none; background-color: transparent;"><i class="fa fa-fw fa-toggle-down"></i></button>
	                <button id="desc" type="button" value="dateDesc" style="border: none; background-color: transparent;"><i class="fa fa-fw fa-toggle-up"></i></button> </th>
                </tr>
                </thead>
                <tbody>
                 <c:forEach items="${ memList}" var="list"> 
	                <tr role="row" class="odd">
	                  <td class="sorting"><input type="checkbox" value="${list.MEM_ID}" name="mem_id"></td>
	                  <td class="sorting">${list.MEM_ID }</td>
	                  <td class="sorting">${list.MEM_NAME }</td>
	                  <td class="sorting">${list.MEM_NICKNAME }</td>
	                  <td class="sorting">${list.MEM_PHONE }</td>
	                  <td class="sorting">${list.MEM_MAIL }</td>
	                  <td class="sorting">${list.SECSN_REASON }</td>
	                  <td class="sorting">${list.MEM_REG_DATE }</td>
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
               	<button id="secBtn" type="button" class="btn btn-info pull-right" style="margin: -20px 80px 0px 0px;">탈퇴 승인</button>
                  </div>
               </div>
               <br>
               <div class="row">

                  
               </div>
               
            </div>
         </div>
         
              <div class="box box-danger">
            <div class="box-header with-border">
              <h3 class="box-title">탈퇴 사유별 집계</h3>

              <div class="box-tools pull-right">
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
              </div>
            </div>
            <div class="box-body chart-responsive">
              <div class="chart" id="writeRatio" style="width :50%; height: 255px;"></div>
            </div>
            
            <!-- /.box-body -->
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

  
  