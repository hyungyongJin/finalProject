<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style>
	th, td{
		text-align:center;
	}
</style>
<div class="content-wrapper" style="margin-left: 10px;">
	<!-- Main content -->
	<section class="content">
	<div class="row">
		<div class="col-md-12">
			<form
				action="${pageContext.request.contextPath }/admin/withDrawal/withDrawalList.do"
				method="post">
				<div class="form-group"
					style="float: left; margin-left: 50px; width: 200px;">
					<select name="search"
						class="form-control select2 select2-hidden-accessible"
						style="width: 100%;" tabindex="-1" aria-hidden="true">
						<option value="TOTAL">전체</option>
						<option value="FISH_NAME">어종명</option>
						<option value="MDCIN_PRDUCT_NAME">의약품명</option>

					</select>

				</div>


				<div class="form-group" style="width: 1500px;">
					<input style="width: 500px; float: left; margin-left: 20px;"
						type="text" class="form-control" name="keyword"
						placeholder="검색어를  입력하세요.." />
					<input type="hidden" name="role" value="select" />
					<button style="margin-left: 20px; font-size: 15px; height: 35px;"
						type="submit" class="btn btn-info btn-lg">검색</button>
				</div>
			</form>

			<div class="box" style=" width: 100%;">
				<div class="box-header">
					<!-- 		<h3 class="box-title">Data Table With Full Features</h3> -->
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<div id="example1_wrapper"
						class="dataTables_wrapper form-inline dt-bootstrap">
						<div class="row">
							<div class="col-sm-6">
								<!-- 					<div class="dataTables_length" id="example1_length"> -->
								<!-- 						<label>Show <select name="example1_length" -->
								<!-- 							aria-controls="example1" class="form-control input-sm"><option -->
								<!-- 									value="10">10</option> -->
								<!-- 								<option value="25">25</option> -->
								<!-- 								<option value="50">50</option> -->
								<!-- 								<option value="100">100</option></select> entries -->
								<!-- 						</label> -->
								<!-- 					</div> -->
							</div>
							<div class="col-sm-6">
								<div id="example1_filter" class="dataTables_filter"></div>
							</div>
						</div>
						<form
							action="${pageContext.request.contextPath }/admin/withDrawal/withDrawalDelete.do"
							method="POST" name="deleteForm">
							<div class="row">
								<div class="col-sm-12">
									<table id="example1"
										class="table table-bordered table-striped dataTable"
										role="grid" aria-describedby="example1_info">
										<thead>
											<tr role="row">
												<th style="width: 5%;"><input
													 id="allCheck" type="checkbox"></th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="Platform(s): activate to sort column ascending"
													style="width: 25%; text-align: center;">어종명</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="Engine version: activate to sort column ascending"
													style="width: 40%; text-align: center;">의약품명</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="Engine version: activate to sort column ascending"
													style="width: 15%; text-align: center;">휴약기간</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="CSS grade: activate to sort column ascending"
													style="width: 20%; text-align: center;">상세</th>
											</tr>
										</thead>

										<tbody>

											<c:forEach items="${withList }" var="list">
												<tr role="row" class="odd">
													<td><input style="margin-left: 20px;"
														class="checkboxes" type="checkbox" name="withdrawal_code"
														value="${list.withdrawal_code }"></td>

<%-- 													<td>${list.rnum }</td> --%>

													<td>${list.fish_name }</td>

													<td>${list.mdcin_prduct_name }</td>
													<td>${list.withdrawal_period }</td>
													<td>
														<button value="${list.withdrawal_code }" type="button"
															 class="viewBtn btn btn-primary btn-sm"
															data-toggle="modal" data-backdrop="static"
															data-target="#myModal">
															<span class="glyphicon glyphicon-search"></span>
															</button>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>

								</div>
							</div>
						</form>
						<div class="row">
							<div class="col-sm-5"></div>
							<div class="col-sm-7">${pagingUtil }</div>
						</div>
					</div>
					<button type="button" style="width: 140px; margin-right: 20px;"
						class="insertbbb btn btn-info btn-sm pull-right"
						data-toggle="modal" data-target="#myModal2">등록</button>
					<button type="button" style="width: 140px; margin-right: 20px;"
						class="btn btn-info btn-sm pull-right" id="deleteBtn">삭제</button>

				</div>
			</div>
		</div>
	</div>
	</section>
	<!-- /.box-body -->


	<!-- 							수정모달 -->
	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content" style="width: 100%;">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h3 class="modal-title" style="text-align: center;">휴약기간 수정</h3>
				</div>
				<div class="modal-body">

					<form name="updateForm"
						action="${pageContext.request.contextPath }/admin/withDrawal/withDrawalUpdate.do"
						method="post">
						<input id="withdrawal_code" type="hidden" value=""
							name="withdrawal_code">
						<div class="box box-info" style="height: 380px;">
							<br> <br> <br>


							<div class="box" style="width: 81%; margin-left: 55px;">
								<!-- box-header -->
								<div class="box-body">
									<div id="example1_wrapper"
										class="dataTables_wrapper form-inline dt-bootstrap">
										<div class="row">
											<div class="col-sm-6">
												<div id="example1_filter" class="dataTables_filter"></div>
											</div>
										</div>
										<div class="row">
											<div class="col-sm-12">
												<label id="fish_name">어종명 : </label> <br> <select
													id="fishNameSelect"
													class="form-control select2 select2-hidden-accessible"
													name="fish_code" style="width: 90%; margin-bottom: 20px;"
													tabindex="-1" aria-hidden="true">
													<option selected="selected">선택하세요</option>
													<c:forEach items="${fishList }" var="list">
														<option value="${list.fish_code }">${list.fish_name }</option>
													</c:forEach>

												</select> <label id="mdcin_name">의약품명 :</label> <select
													id="proSelect"
													class="form-control select2 select2-hidden-accessible"
													name="mdcin_code" style="width: 90%;" tabindex="-1"
													aria-hidden="true">
													<option selected="selected">선택하세요</option>
													<c:forEach items="${mdcinList }" var="list">
														<option value="${list.mdcin_code }">${list.mdcin_prduct_name }</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>
								</div>
								<!-- /.box-body -->
							</div>
							<label style="float: left; margin-left: 55px;">휴약기간 :</label> <input
								id="updateText" name="withdrawal_period"
								class="withdrawal_period1" type="text"
								style="width: 57%; margin-left: 20px; margin-bottom: 10px; float: left;">
						</div>

						<div class="modal-footer">
							<button id="updateBtn" type="button" class="btn btn-default"
								data-dismiss="modal">수정</button>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">취소</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>




	<!-- 등록 모달 -->
	<div class="modal fade" id="myModal2" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content -->
			<div class="modal-content" style="width: 100%;">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h3 class="modal-title" style="text-align: center;">휴약기간 등록화면</h3>
				</div>
				<div class="modal-body">

					<form name="insertForm"
						action="${pageContext.request.contextPath }/admin/withDrawal/withDrawalInsert.do"
						method="post">
						<input id="withdrawal_code" type="hidden" value=""
							name="withdrawal_code">
						<div class="box box-info" style="height: 380px;">
							<br> <br> <br>
							<div class="box" style="width: 81%; margin-left: 55px;">
								<div class="box-body">
									<div id="example1_wrapper"
										class="dataTables_wrapper form-inline dt-bootstrap">
										<div class="row">
											<div class="col-sm-6">
												<div id="example1_filter" class="dataTables_filter"></div>
											</div>
										</div>
										<div class="row">
											<div class="col-sm-12">
												<label id="fish_name">어종명 : </label> <br> <select
													id="fishNameSelect2"
													class="form-control select2 select2-hidden-accessible"
													name="fish_code" style="width: 90%; margin-bottom: 20px;"
													tabindex="-1" aria-hidden="true">
													<option selected="selected">선택하세요</option>
													<c:forEach items="${fishList }" var="list">
														<option value="${list.fish_code }">${list.fish_name }</option>
													</c:forEach>


												</select> <label id="mdcin_name">의약품명 :</label> <select
													id="proSelect2"
													class="form-control select2 select2-hidden-accessible"
													name="mdcin_code" style="width: 90%;" tabindex="-1"
													aria-hidden="true">
													<option selected="selected">선택하세요</option>
													<c:forEach items="${mdcinList }" var="list">
														<option value="${list.mdcin_code }">${list.mdcin_prduct_name }</option>
													</c:forEach>

												</select>
											</div>
										</div>
									</div>
								</div>
								<!-- 						box-body -->
							</div>
							<label style="float: left; margin-left: 55px;">휴약기간 :</label> <input
								type="text" id="insertText" name="withdrawal_period"
								style="width: 57%; margin-left: 20px; margin-bottom: 10px; float: left;">
						</div>
						<div class="modal-footer">
							<button id="insertBtn" type="button" class="btn btn-default"
								data-dismiss="modal">등록</button>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">취소</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>



	<script type="text/javascript">
$(function() {
	if(eval('${!empty message}')){
		alert('${message}');
	};
	
	
	$('.viewBtn').click(function(){
		$('#fishNameSelect').val('선택하세요');
		$('#proSelect').val('선택하세요');
		
		
		var withdrawal_code = $(this).val();
		$('#fish_name').text('');
		$('#mdcin_name').text('');
		$('input[name=withdrawal_period]').val('');
		$('#withdrawal_code').val(withdrawal_code);
		
		$.ajax({
			url : '${pageContext.request.contextPath}/admin/withDrawal/withDrawalInfo.do?withdrawal_code='+withdrawal_code,
			success : function(data){
				fish_name = $('#fish_name').text();
				mdcin_name = $('#mdcin_name').text();
				$('#fish_name').text(data.info.fish_code + "-" +data.info.fish_name);
				$('#mdcin_name').text(data.info.mdcin_code + "-" +data.info.mdcin_prduct_name);
				$('#updateText').val(data.info.withdrawal_period);
				
			},
			error : function(res){
				alert(res.status);
			}
		});
		
	});
	
	$('#updateBtn').click(function(){
// 		if($('input[class=withdrawal_period1]').val() != null &&
// 				$('input[class=withdrawal_period1]').val() != ''
// 				&& $('#fishIn').val() != '' && $('#fishIn').val() != null
// 				&& $('#proIn').val() != '' && $('#proin').val() != null){
// 			$('form[name=updateForm]').submit();
// 		}else{
// 			$('#updateBtn').attr('data-dismiss','');
// 			alert('수정할 데이터를 선택및 입력 해주세요');
// 		}
		
		if ($('#fishNameSelect').val() != '선택하세요' && $('#proSelect').val() != '선택하세요'
			&& $('#updateText').val() != null && $('#updateText').val() != ''	
			) {
			$('form[name=updateForm]').submit();
		}else {
			$('#updateBtn').attr('data-dismiss','');
			alert("수정 할 데이터를 모두 선택및 입력 해주세요.");
		}
	});
		
	$('#insertBtn').click(function(){
		
		
		if ($('#fishNameSelect2').val() != '선택하세요' && $('#proSelect2').val() != '선택하세요'
			&& $('#insertText').val() != null && $('#insertText').val() != '') {
			$('form[name=insertForm]').submit();
		}else {
			$('#insertBtn').attr('data-dismiss','');
			alert("등록할 할 데이터를 모두 입력 및 선택해 주세요.");
		}
		
	});
		
	$('#allCheck').click(function(){
		
		if($('#allCheck').prop('checked')){
			$('input[class=checkboxes]').prop('checked', true);
		}else{
			$('input[class=checkboxes]').prop('checked', false);
		}
		
	});
	
	
	$('#deleteBtn').click(function(){
		
		
		var checkRow = "";
		  $( "input[class='checkboxes']:checked" ).each (function (){
		    checkRow = checkRow + $(this).val()+"," ;
		  });
		  checkRow = checkRow.substring(0,checkRow.lastIndexOf( ","));
		  
	  	if (checkRow == '') {
			alert('삭제할 항목을 선택해 주세요');
		}else{
			$(location).attr('href','${pageContext.request.contextPath }/admin/withDrawal/withDrawalDelete.do?withdrawal_code='+checkRow);
		}

				
	});
	
});
</script>