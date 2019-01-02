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
	if (eval('${empty param.cnt}')) {
		$('select[name=cnt]').val('0');
	}else{
		$('select[name=cnt]').val('${param.cnt}');
	}
	
	changeCnt = function(value){
		$(location).attr('href','${pageContext.request.contextPath}/user/fishDiss/fishDiss.do?commentCurrentPage='
			+'${param.commentCurrentPage}&cnt='+value);		
	};
	
	$('.viewBtn').click(function(){
		$('#viewPics').modal({backdrop : 'static'});
		var reason = '<span>'+$(this).parent().siblings('td:eq(0)').find('input').val()+'</span>';
		var data = $(this).val();
		var diss_code = data.split(',')[0];
		var diss_name =data.split(',')[1];
		$('#showName').text(diss_name);
		$.ajax({
			url : '${pageContext.request.contextPath}/user/fishDiss/fileInfo.do?diss_code='+diss_code,
			success : function(data){
				var info = data.info;
				var code= '';
				for (var i = 0; i < info.length; i++) {
					 code += '<img id="'+info[i].file_no+'" src="/image/'+info[i].file_save_name +'" width="170" height="170">';
				}
				$('#reasonTxt').html(reason);
				$('#imageDiv').html(code);
			},error : function(res){
				alert(res.stauts);
			}		
		})
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
   
         <div class="box-header">
            <h3 class="box-title" >어류 질병정보</h3>
         </div>
         
         <!-- /.box-header -->
         <div class="box-body">
  <img src="${pageContext.request.contextPath }/images/subimg_dinfo.jpg" alt="안전한 수산식품공급을 위한 체계적인 시스템, 질병정보를 알려드립니다">
         	
            <div id="example1_wrapper"
               class="dataTables_wrapper form-inline dt-bootstrap">
               <div class="row">
                  <div class="col-sm-12">
					<form id="form" action="${pageContext.request.contextPath }/user/fishDiss/fishDiss.do" method="post">
					<div class="dropdown">
					    <select name="cnt" class="form-control" onchange="changeCnt(this.value);">
						  <option value="0">15개씩 보기</option>
						  <option value="-1">50개씩 보기</option>
						</select>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
						<select name="search" class="form-control">
							<option value="">검색조건</option>
							<option value="FISH">어류명</option>
							<option value="DISS">질병명</option>
						</select> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
						<input name="keyword" type="search" class="form-control input-md" style="width: 300px;" placeholder="검색어를 입력하세요">
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<button id="searchBtn" class="btn btn-primary btn-md" type="submit">검색</button>
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						</div>
					</form>
               
					<br>
					<form id="delForm"  method="post">
                <table id="example1" class="table table-bordered table-striped dataTable" role="grid" aria-describedby="example1_info">
                <thead>
                <tr role="row">
	                <th class="sorting" tabindex="0"  rowspan="1" colspan="1" >감염어종</th>
	                <th class="sorting" tabindex="0"  rowspan="1" colspan="1" >질병명</th>
	                <th class="sorting" tabindex="0"  rowspan="1" colspan="1" >내용보기</th>
                </tr>
                </thead>
                <tbody id="dissContent">
                <c:forEach items="${dissList }" var="list">
                	<tr>
                		<td class="sorting"><input type="hidden" value="${list.DISS_REASON }">${list.FISH_NAME }</td>
                		<td class="sorting">${list.DISS_NAME }</td>
                		<td class="sorting"><button type="button" value="${list.DISS_CODE },${list.DISS_NAME }" class="viewBtn btn btn-primary">
						    <span class="glyphicon glyphicon-search"></span></button></td>
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
                  
                  
                  
                  </div>
               </div>
               <br>
               <div class="row">

                  
               </div>
               
            </div>
         </div>
         
         
         
<!-- /.box-body -->
      </div>
             
             
             
<div class="modal fade" id="viewPics" role="dialog">
		<div class="modal-dialog modal-lg">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-body">
					<span id="showName"
						style="color: green; font-size: 15pt; margin: 10px;"></span>
					<hr>
					<div class="box">
						<div id="reasonTxt" class="box-header">
						

						</div>
						<!-- /.box-header -->
						<div class="box-body pad">
							<div id="imageDiv" class="form-group"></div>
						</div>
					</div>
					<div class="modal-footer">
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
</html>

  
  