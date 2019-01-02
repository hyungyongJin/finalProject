<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<button type="button" style="width: 140px;" class="btn btn-info btn-lg"
	data-toggle="modal" data-target="#myModal">등록</button>

<div class="modal fade" id="myModal" role="dialog">
	<div class="modal-dialog">
		<!-- Modal content-->
		<div class="modal-content" style="width: 100%;">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h3 class="modal-title" style="text-align: center;">휴약기간 등록</h3>
			</div>
			<div class="modal-body">
				<div class="box box-info" style="height: 350px;">
					<br>
					<div class="form-group" style="margin-left: 55px;">
						<select class="form-control select2 select2-hidden-accessible"
							style="width: 90%;" tabindex="-1" aria-hidden="true">
							<option selected="selected">어종코드 - 어종명</option>
							<option>Alaska</option>
							<option>California</option>
							<option>Delaware</option>
							<option>Tennessee</option>
							<option>Texas</option>
							<option>Washington</option>
						</select>
					</div>
					<input
						style="width: 71%; margin-left: 55px; margin-bottom: 10px; float: left;">
					<button style="height: 28px; margin-left: 5px;" type="button"
						class="btn ">검색</button>

					<br> <br>
					

					<div class="box" style="width:81%; margin-left:55px;">
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
								<div class="row" >
									<div class="col-sm-12">
										<table id="example1"
											class="table table-bordered table-striped dataTable"
											role="grid" aria-describedby="example1_info">
											<thead>
												<tr role="row">
													<th style="text-align:center;">선택</th>
													<th class="sorting" tabindex="0" aria-controls="example1"
														rowspan="1" colspan="1"
														aria-label="Browser: activate to sort column ascending"
														style="width: 80%; text-align:center;">의약품명</th>
												</tr>
											</thead>
											<tbody>
												<tr role="row" class="odd">
													<td><input style="margin-left:30px;" type="radio"></td>
													<td style=" text-align:center;">1</td>
											</tfoot>
										</table>
									</div>
								</div>

								<div class="row">
									<div class="col-sm-5"></div>
									<div class="col-sm-7">
										<%-- 				${paging } --%>
									</div>
								</div>
							</div>
							
						</div>
						<!-- /.box-body -->
					</div>
					<label style="float:left; margin-left: 55px;">휴약기간 :</label>
					<input style="width: 66%; margin-left: 20px; margin-bottom: 10px; float: left;">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">등록</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
				</div>

			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	$(function() {

	});
</script>