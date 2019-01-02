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
$(function(){
	
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
	
	$('.detail').click(function(){
		md_code = $(this).val();
		$.ajax({
			url : '${pageContext.request.contextPath}/admin/mdcin_diss/mdcin_diss_View.do?md_code='+md_code,
			success : function(data){
				$('input[name=mdcinName]').val(data.mdcinDissInfo.mdcin_code + "-" + data.mdcinDissInfo.mdcin_prduct_name);
				$('input[name=dissName]').val(data.mdcinDissInfo.diss_code + "-" + data.mdcinDissInfo.diss_name);
			},
			error : function(res){
				alert(res.status);
			}
		});
		$('#updateModal').modal();
	});
	
	$('.insertbtn').click(function(){
		$('#insertModal').modal();
	});
	
	$('#mdcin_diss_insert').click(function(){
		if ($('select[name=insertMdcin]').val() != "의약품코드 - 의약품" && $('select[name=insertDiss]').val() != "질병코드 - 질병명") {
			$('#mdcin_diss_insert').attr('data-dissmiss','modal');
			mdcin_code = $('select[name=insertMdcin]').val().split("-");
			diss_code = $('select[name=insertDiss]').val().split("-");
			$(location).attr('href','${pageContext.request.contextPath}/admin/mdcin_diss/mdcin_diss_Insert.do?m_code='+mdcin_code[0] +'&d_code='+diss_code[0]);
		}else {
			alert("등록 사항을 선택 후 클릭하세요.");
		}
	});
	
	$('.deletebtn').click(function(){
		if ($('.checkboxes:checked').val() != null) {
			$('form[name=deleteForm]').submit();
		}else {
			alert("삭제할 대상을 선택해주세요.");
		}
	});
	
	$('.updatebtn').click(function(){
		if ($('select[name=updateMdcin]').val() != "의약품코드 - 의약품" && $('select[name=updateDiss]').val() != "질병코드 - 질병명") {
			$('.updatebtn').attr('data-dissmiss','modal');
			m_code = $('input[name=mdcinName]').val().split("-");
			d_code = $('input[name=dissName]').val().split("-");
			mdcin_code = $('select[name=updateMdcin]').val().split("-");
			diss_code = $('select[name=updateDiss]').val().split("-");
	 		$(location).attr('href','${pageContext.request.contextPath}/admin/mdcin_diss/mdcin_diss_Update.do?m_code='+mdcin_code[0] +'&d_code='+diss_code[0] + '&om_code='+m_code[0] + '&od_code='+d_code[0]);
			
		}else {
			alert("수정 사항을 선택 후 클릭하세요.");
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
				action="${pageContext.request.contextPath }/admin/mdcin_diss/mdcin_diss_List.do"
				method="get">
				<div class="form-group"
					style="float: left; margin-left: 50px; width: 200px;">
					<select name="search_keycode"
						class="form-control select2 select2-hidden-accessible"
						style="width: 100%;" tabindex="-1" aria-hidden="true">
						<option selected="selected" value="TOTAL">전체</option>
						<option value="MDCIN_NAME">의약품</option>
						<option value="DISS_NAME">질병명</option>
					</select>

				</div>
				<div class="form-group" style="width: 1500px;">
					<input style="width: 500px; float: left; margin-left: 20px;"
						type="text" class="form-control" name="search_keyword"
						placeholder="검색어를  입력하세요.." /> <input type="hidden" name="role"
						value="select" />
					<button style="margin-left: 20px; font-size: 15px;" type="submit"
						class="btn btn-info btn-lg">검색</button>
				</div>
			</form>

			<div class="box" style="width: 100%;">
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
								<form name="deleteForm"
									action="${pageContext.request.contextPath }/admin/mdcin_diss/mdcin_diss_Delete.do"
									method="post">
									<table class="table table-bordered table-striped dataTable"
										role="grid" aria-describedby="example1_info">
										<thead>
											<tr role="row">
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="Browser: activate to sort column ascending"
													style="width: 5%;"><input id="allCheck"
													type="checkbox"></th>
<!-- 												<th class="sorting" tabindex="0" aria-controls="example1" -->
<!-- 													rowspan="1" colspan="1" -->
<!-- 													aria-label="Browser: activate to sort column ascending" -->
<!-- 													style="width: 10%;">번호</th> -->
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="Platform(s): activate to sort column ascending"
													style="width: 30%;">의약품</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="Engine version: activate to sort column ascending"
													style="width: 40%;">질병명</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="CSS grade: activate to sort column ascending"
													style="width: 15%;">상세</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${mdcinDissList }" var="list">
												<tr role="row" class="odd">
													<td><input name="md_code" type="checkbox"
														class="checkboxes" value="${list.md_code }"></td>
<%-- 													<td>${list.rnum}</td> --%>
													<td>${list.mdcin_prduct_name}</td>
													<td>${list.diss_name}</td>
													<td>
														<button value="${list.md_code }" type="button"
															 class="detail btn btn-primary btn-sm"
															data-toggle="modal">
															<span class="glyphicon glyphicon-search"></span>
															</button>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</form>
							</div>
							<div class="row">
								<div class="col-sm-5"></div>
								<div class="col-sm-7">${paging }</div>
							</div>
							<button type="button" style="width: 140px; margin-right: 20px;"
								class="insertbtn btn btn-info btn-sm pull-right">등록</button>
							<button type="button" style="width: 140px; margin-right: 20px;"
								class="deletebtn btn btn-info btn-sm pull-right">삭제</button>
						</div>

					</div>
				</div>
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
							<h3 class="modal-title" style="text-align: center;">의약품-질병
								등록</h3>
						</div>
						<div class="modal-body">
							<div class="box box-info" style="height: 180px;">
								<br> <label
									style="margin-left: 10px; margin-right: 10px; float: left;">의약품
									:</label>
								<div class="form-group" style="width: 75%;">
									<select name="insertMdcin"
										class="form-control select2 select2-hidden-accessible"
										style="width: 70%; margin-botton: 40px;" tabindex="-1"
										aria-hidden="true">
										<option selected="selected">의약품코드 - 의약품</option>
										<c:forEach items="${mdcinList }" var="list">
											<option>${list.mdcin_code }-
												${list.mdcin_prduct_name }</option>
										</c:forEach>
									</select>
								</div>
								<br> <label
									style="float: left; margin-right: 10px; margin-bottom: 15px; margin-left: 21px; margin-top: 40px;">질병
									:</label>
								<div class="form-group" style="width: 80%;">
									<select name="insertDiss"
										class="form-control select2 select2-hidden-accessible"
										style="width: 70%; margin-bottom: 10px; margin-top: 30px;"
										tabindex="-1" aria-hidden="true">
										<option selected="selected">질병코드 - 질병명</option>
										<c:forEach items="${dissList }" var="list">
											<option>${list.diss_code }- ${list.diss_name }</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									id="mdcin_diss_insert">등록</button>
								<button type="button" class="btn btn-default"
									data-dismiss="modal">취소</button>
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
							<h3 class="modal-title" style="text-align: center;">의약품-질병
								상세보기</h3>
						</div>
						<div class="modal-body">
							<div class="box box-info" style="height: 210px;">
								<br> <label
									style="float: left; margin-right: 10px; margin-bottom: 15px; margin-left: 10px;">의약품
									:</label> <input name="mdcinName"
									style="width: 70%; margin-bottom: 10px;" disabled="true">
								<br>
								<div class="form-group" style="margin-left: 55px; width: 80%;">
									<select name="updateMdcin"
										class="form-control select2 select2-hidden-accessible"
										style="margin-left: 13px; width: 88%; margin-bottom: 20px;"
										tabindex="-1" aria-hidden="true">
										<option selected="selected">의약품코드 - 의약품</option>
										<c:forEach items="${mdcinList }" var="list">
											<option>${list.mdcin_code }-
												${list.mdcin_prduct_name }</option>
										</c:forEach>
									</select>
								</div>
								<br> <label
									style="float: left; margin-right: 22px; margin-bottom: 15px; margin-left: 10px;">질병
									:</label> <input name="dissName"
									style="width: 70%; margin-bottom: 10px;" disabled="true">
								<br>
								<div class="form-group" style="margin-left: 66px; width: 100%;">
									<select name="updateDiss"
										class="form-control select2 select2-hidden-accessible"
										style="width: 70%; margin-bottom: 10px;" tabindex="-1"
										aria-hidden="true">
										<option selected="selected">질병코드 - 질병명</option>
										<c:forEach items="${dissList }" var="list">
											<option>${list.diss_code }- ${list.diss_name }</option>
										</c:forEach>
									</select>
								</div>


							</div>
							<div class="modal-footer">
								<button type="button" class="updatebtn btn btn-default">수정</button>
								<button type="button" class="btn btn-default"
									data-dismiss="modal">취소</button>
							</div>
						</div>
					</div>
				</div>
			</div>

