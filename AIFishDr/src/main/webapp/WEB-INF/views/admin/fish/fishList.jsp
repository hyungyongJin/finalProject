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

		$('#insertFish').click(function() {
			$('#insertModal').modal();
		});
		
		$('.insertbtn').click(function(){
			if ($('input[name=fishInsert]').val() != "") {
				$('.insertbtn').attr('data-dissmiss','modal');
				fish_name = $('input[name=fishInsert]').val();
				name = encodeURI(encodeURIComponent(fish_name));
				$(location).attr('href','${pageContext.request.contextPath}/admin/fish/insertFish.do?name='+name);
			}else {
				alert("어종을 입력해 주세요.");
			}
		});
		
		var value = $('#fish_code').html(); 
		$('.detail').click(function(){
			var fish_code = $(this).val();
			$.ajax({
				url : '${pageContext.request.contextPath}/admin/fish/fishView.do?code='+fish_code,
				success : function(data){
					$('#fish_code').html(value + data.fishInfo.fish_code);
					$('#fish_name').val(data.fishInfo.fish_name);
				},
				error : function(res){
					alert(res.status);
				}
			});
			
			$('#updateModal').modal();
		});

		$('#deleteFish').click(function() {
			if ($('.checkboxes:checked').val() != null) {
				$('form[name=deleteForm]').submit();
			}else {
				alert("삭제할 대상을 선택해주세요.");
			}
		});
		
		$('.updatebtn').click(function(){
			if ($('#fish_name').val() != "") {
				code = $('#fish_code').html().substring(6);
				name = $('#fish_name').val();
				$(location).attr('href','${pageContext.request.contextPath}/admin/fish/updateFish.do?code='+code+'&name='+name);
			}else {
				alert("수정 할 어종명을 입력 해주세요.");
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
				action="${pageContext.request.contextPath }/admin/fish/fishList.do"
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
									action='${pageContext.request.contextPath}/admin/fish/deleteFish.do'
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
													style="width: 20%;">어종코드</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="Engine version: activate to sort column ascending"
													style="width: 60%;">어종명</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="CSS grade: activate to sort column ascending"
													style="width: 15%;">상세</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${fishList }" var="fishList">
												<tr role="row" class="odd">
													<td><input type="checkbox" name="code"
														class="checkboxes" value="${fishList.fish_code }"></td>
													<td>${fishList.fish_code }</td>
													<td>${fishList.fish_name }</td>

													<td>
														<button value="${fishList.fish_code }" type="button"
															 class="detail btn btn-primary btn-sm">
															<span class="glyphicon glyphicon-search"></span>
															</button>
													</td>
												</tr>
											</c:forEach>
											<!--  어류 상세모달 -->

										</tbody>
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
						class="btn btn-info btn-sm pull-right" id="insertFish">등록</button>
					<button type="button" style="width: 140px; margin-right: 20px;"
						class="btn btn-info btn-sm pull-right" id="deleteFish">삭제</button>

				</div>
				<!-- /.box-body -->
			</div>
		</div>
	</div>
	</section>



	<div class="modal-header modal fade" id="insertModal" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content" style="width: 60%;">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h3 class="modal-title" style="text-align: center;">어종등록</h3>
				</div>
				<div class="modal-body">

					<div class="box box-info">
						<label
							style="float: left; margin-right: 10px; margin-top: 18px; margin-bottom: 15px; margin-left: 10px;">어종명:</label>
						<input name="fishInsert"
							style="width: 70%; margin-top: 15px; margin-bottom: 15px;">


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
					<h3 class="modal-title" style="text-align: center;">상세보기</h3>
				</div>
				<div class="modal-body">
					<div class="box box-info">
						<br> <label id="fish_code" style="margin-left: 10px;">어종코드: </label> <br>
						 <label style="float: left; margin-right: 10px; margin-top: 18px; margin-bottom: 15px; margin-left: 10px;">어종명
							:</label> 
							<input id="fish_name"
							style="width: 70%; margin-top: 15px; margin-bottom: 15px;"
							placeholder="(어종명)">


					</div>
					<div class="modal-footer">
						<button type="button" class="updatebtn btn btn-default"
							data-dismiss="modal">수정</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					</div>
				</div>
			</div>
		</div>
	</div>