<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style>
	th, td{
		text-align:center;
	}
</style>
<script type="text/javascript">
$(function() {
	if (eval('${!empty param.message}')) {
		alert('${param.message}');
	};

	$('#allCheck').click(function() {
		if ($('#allCheck').prop("checked")) {
			$('input[class=checkboxes]').prop("checked", true);
		} else {
			$('input[class=checkboxes]').prop("checked", false);
		}
	});

	$('#insertSymptms').click(function() {
		$('#insertModal').modal();
	});
	
	$('.insertbtn').click(function(){
		if ($('textarea[name=symptmsInsert]').val() != "") {
			$('.insertbtn').attr('data-dissmiss','modal');
			symptms_content = $('textarea[name=symptmsInsert]').val();
			content = encodeURI(encodeURIComponent(symptms_content));
			$(location).attr('href','${pageContext.request.contextPath}/admin/symptms/insertSymptms.do?content='+content);
		}else {
			alert("증상을 입력해주세요.");
		}
	});
	
	var value = $('#symptms_code').html(); 
	$('.detail').click(function(){
		var symptms_code = $(this).val();
		$.ajax({
			url : '${pageContext.request.contextPath}/admin/symptms/symptmsView.do?code='+symptms_code,
			success : function(data){
				$('#symptms_code').html(value + data.symptmsInfo.symptms_code);
				$('#symptms_content').val(data.symptmsInfo.symptms_content);
			},
			error : function(res){
				alert(res.status);
			}
		});
		
		$('#updateModal').modal();
	});

	$('#deleteSymptms').click(function() {
		if ($('.checkboxes:checked').val() != null) {
			$('form[name=deleteForm]').submit();
		}else {
			alert("삭제할 대상을 선택해주세요.");
		}
	});
	
	$('.updatebtn').click(function(){
		if ($('#symptms_content').val() != "") {
			$('.updatebtn').attr('data-dissmiss','modal');
			code = $('#symptms_code').html().substring(5);
			content = $('#symptms_content').val();
			$(location).attr('href','${pageContext.request.contextPath}/admin/symptms/updateSymptms.do?code='+code+'&content='+content);
		}else {
			alert("수정 할 증상을 입력해주세요.");
		}
	});

});
</script>
<div class="content-wrapper" style="margin-left: 10px;">
	<!-- Main content -->
	<section class="content">
	<div class="row">
		<div class="col-md-12">
			<form
				action="${pageContext.request.contextPath }/admin/symptms/symptmsList.do"
				method="get">
				<div class="form-group" style="width: 1500px;">
					<input style="width: 500px; float: left; margin-left: 20px;"
						type="text" class="form-control" name="search_keyword"
						placeholder="검색어를  입력하세요.." /> <input type="hidden" name="role"
						value="select" />
					<button style="margin-left: 20px; font-size: 15px;" type="submit"
						class="btn btn-info btn-lg">검색</button>
				</div>
			</form>

			<div class="box">
				<div class="box-header">
					<!-- 		<h3 class="box-title">Data Table With Full Features</h3> -->
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<div id="example1_wrapper"
						class="dataTables_wrapper form-inline dt-bootstrap">
						<div class="row">
							<div class="col-sm-6"></div>
							<div class="col-sm-6">
								<div id="example1_filter" class="dataTables_filter"></div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12">
								<form name=deleteForm
									action='${pageContext.request.contextPath}/admin/symptms/deleteSymptms.do'
									method="post">
									<table id="example1"
										class="table table-bordered table-striped dataTable"
										role="grid" aria-describedby="example1_info">
										<thead>
											<tr role="row">
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="Browser: activate to sort column ascending"
													style="width: 5%;"><input type="checkbox"
													id="allCheck"></th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="Platform(s): activate to sort column ascending"
													style="width: 20%;">증상코드</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="Engine version: activate to sort column ascending"
													style="width: 60%;">증상</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="CSS grade: activate to sort column ascending"
													style="width: 15%;">상세</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${symptmsList }" var="symptmsList">
												<tr role="row" class="odd">
													<td><input type="checkbox" name="code"
														class="checkboxes" value="${symptmsList.symptms_code }"></td>
													<td>${symptmsList.symptms_code }</td>
													<td>${symptmsList.symptms_content }</td>

													<td>
														<button value="${symptmsList.symptms_code }" type="button"
															 class="detail btn btn-primary btn-sm">
															<span class="glyphicon glyphicon-search"></span>
															</button>
													</td>
												</tr>
											</c:forEach>

											</td>
										</tfoot>
									</table>
								</form>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-5"></div>
							<div class="col-sm-7">${paging }</div>
						</div>
					</div>
					<button type="button" style="width: 140px; margin-right: 20px;"
						class="btn btn-info btn-sm pull-right" id="insertSymptms">등록</button>
					<button type="button" style="width: 140px; margin-right: 20px;"
						class="btn btn-info btn-sm pull-right" id="deleteSymptms">삭제</button>

				</div>
				<!-- /.box-body -->
			</div>
		</div>
	</div>
	</section>



	<div class="modal fade" id="insertModal" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content" style="width: 60%;">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h3 class="modal-title" style="text-align: center;">증상등록</h3>
				</div>
				<div class="modal-body">
					<div class="box box-info">
						<br> <label
							style="float: left; margin-right: 10px; margin-top: 18px; margin-bottom: 15px; margin-left: 10px;">증상</label>
						<textarea name=symptmsInsert
							style="width: 70%; height: 100px; margin-top: 15px; margin-bottom: 15px;"
							placeholder="(증상)"></textarea>


					</div>
					<div class="modal-footer">
						<button type="button" class="insertbtn btn btn-default">등록</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="modal fade" id="updateModal" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content" style="width: 60%;">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h3 class="modal-title" style="text-align: center;">상세화면</h3>
				</div>
				<div class="modal-body">
					<div class="box box-info">
						<br> <label style="margin-left: 10px;" id="symptms_code">증상코드:</label> <br> 
						<label
							style="float: left; margin-right: 10px; margin-top: 18px; margin-bottom: 15px; margin-left: 10px;">증상
							:</label>
						<textarea id="symptms_content"
							style="width: 70%; height: 100px; margin-top: 15px; margin-bottom: 15px;"
							placeholder="(증상)"></textarea>


					</div>
					<div class="modal-footer">
						<button type="button" class="updatebtn btn btn-default">수정</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					</div>
				</div>
			</div>
		</div>
	</div>