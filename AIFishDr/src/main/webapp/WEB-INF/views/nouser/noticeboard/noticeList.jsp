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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<!-- Main content -->
<html>
<style>

.box{
	width: 88%;
	 margin-left: 75px;
	  height: 730px;
}
#row{
	width: 90%;
	margin-left: 60px;
	margin-top: 100px;
}
#notice{
	margin-left: 43%; 
	margin-top: 20px;
	font-size: 30px; 
}
#head{
	margin-left: 32%;
}
.inner{
	margin-left: 5%;
	height: 200px;
}
</style>
<body>
<div class="content-wrapper" style="margin-left:10px;">
	<section class="content">
		<!-- Small boxes (Stat box) -->
		<div class="row" id="main">
			<div id="head" class="col-lg-6 col-xs-6"
				>
				<!-- logo -->
				<h1  style="font-size: 100px;">A.I Fish Dr</h1>
			</div>



			<div id="row" class="row"
				>
				<div class="col-lg-4 col-xs-6">
					<!-- small box -->
					<div class="small-box bg-aqua" style="width:100%;">
						<div class="inner" >
							<h3 >의약품 서비스</h3>
							<p>New Orders</p>
						</div>
						<div class="icon">
							<i class="fa fa-medkit"></i>
						</div>



					</div>
				</div>
				<!-- ./col -->
				<div class="col-lg-4 col-xs-6">
					<!-- small box -->
					<div class="small-box bg-green" style="width:100%;">
						<div class="inner" >
							<h3 >A.I 처방</h3>

							<p>Bounce Rate</p>
						</div>
						<div class="icon">
							<i class="fa fa-stethoscope"></i>
						</div>
					</div>
				</div>
				<!-- ./col -->
				<div class="col-lg-4 col-xs-6">
					<!-- small box -->
					<div class="small-box bg-yellow" style="width:100%;">
						<div class="inner" >
							<h3 >A.I응답서비스</h3>

							<p>User Registrations</p>
						</div>
						<div class="icon">
							<i class="fa fa-user-md"></i>
						</div>


					</div>
				</div>
				<!-- ./col -->
			</div>
			<!-- /.row -->



			<div class="box"
				>
				<div class="box-header" style="width: 100%;">
					<h3 id="notice" class="box-title" >공지사항</h3>
				</div>
				<!-- /.box-header -->
				<div class="box-body" style="width: 100%;">
					<div id="example1_wrapper"
						class="dataTables_wrapper form-inline dt-bootstrap">
						<div class="row">
							<div class="col-sm-6">
								<div class="dataTables_length" id="example1_length">
									<label>Show <select name="example1_length"
										aria-controls="example1" class="form-control input-sm"><option
												value="10">10</option>
											<option value="25">25</option>
											<option value="50">50</option>
											<option value="100">100</option></select> entries
									</label>
								</div>
							</div>
							<div class="col-sm-6"></div>
						</div>
						<div class="row">
							<div class="col-sm-12">
								<table id="example1"
									class="table table-bordered table-striped dataTable"
									role="grid" aria-describedby="example1_info">
									<thead>
										<tr role="row">
											<th class="sorting_asc" tabindex="0" aria-controls="example1"
												rowspan="1" colspan="1" aria-sort="ascending"
												aria-label="Rendering engine: activate to sort column descending"
												style="width: 297px;">Rendering engine</th>
											<th class="sorting" tabindex="0" aria-controls="example1"
												rowspan="1" colspan="1"
												aria-label="Browser: activate to sort column ascending"
												style="width: 361px;">Browser</th>
											<th class="sorting" tabindex="0" aria-controls="example1"
												rowspan="1" colspan="1"
												aria-label="Platform(s): activate to sort column ascending"
												style="width: 322px;">Platform(s)</th>
											<th class="sorting" tabindex="0" aria-controls="example1"
												rowspan="1" colspan="1"
												aria-label="Engine version: activate to sort column ascending"
												style="width: 257px;">Engine version</th>
											<th class="sorting" tabindex="0" aria-controls="example1"
												rowspan="1" colspan="1"
												aria-label="CSS grade: activate to sort column ascending"
												style="width: 190px;">CSS grade</th>
										</tr>
									</thead>
									<tbody>
										<tr role="row" class="odd">
											<td class="sorting_1">Gecko</td>
											<td>Firefox 1.0</td>
											<td>Win 98+ / OSX.2+</td>
											<td>1.7</td>
											<td>A</td>
										</tr>
										<tr role="row" class="even">
											<td class="sorting_1">Gecko</td>
											<td>Firefox 1.5</td>
											<td>Win 98+ / OSX.2+</td>
											<td>1.8</td>
											<td>A</td>
										</tr>
										<tr role="row" class="odd">
											<td class="sorting_1">Gecko</td>
											<td>Firefox 2.0</td>
											<td>Win 98+ / OSX.2+</td>
											<td>1.8</td>
											<td>A</td>
										</tr>
										<tr role="row" class="even">
											<td class="sorting_1">Gecko</td>
											<td>Firefox 3.0</td>
											<td>Win 2k+ / OSX.3+</td>
											<td>1.9</td>
											<td>A</td>
										</tr>
										<tr role="row" class="odd">
											<td class="sorting_1">Gecko</td>
											<td>Camino 1.0</td>
											<td>OSX.2+</td>
											<td>1.8</td>
											<td>A</td>
										</tr>
										<tr role="row" class="even">
											<td class="sorting_1">Gecko</td>
											<td>Camino 1.5</td>
											<td>OSX.3+</td>
											<td>1.8</td>
											<td>A</td>
										</tr>
										<tr role="row" class="odd">
											<td class="sorting_1">Gecko</td>
											<td>Netscape 7.2</td>
											<td>Win 95+ / Mac OS 8.6-9.2</td>
											<td>1.7</td>
											<td>A</td>
										</tr>
										<tr role="row" class="even">
											<td class="sorting_1">Gecko</td>
											<td>Netscape Browser 8</td>
											<td>Win 98SE+</td>
											<td>1.7</td>
											<td>A</td>
										</tr>
										<tr role="row" class="odd">
											<td class="sorting_1">Gecko</td>
											<td>Netscape Navigator 9</td>
											<td>Win 98+ / OSX.2+</td>
											<td>1.8</td>
											<td>A</td>
										</tr>
										<tr role="row" class="even">
											<td class="sorting_1">Gecko</td>
											<td>Mozilla 1.0</td>
											<td>Win 95+ / OSX.1+</td>
											<td>1</td>
											<td>A</td>
										</tr>
									</tbody>
									<tfoot>
										<tr>
											<th rowspan="1" colspan="1">Rendering engine</th>
											<th rowspan="1" colspan="1">Browser</th>
											<th rowspan="1" colspan="1">Platform(s)</th>
											<th rowspan="1" colspan="1">Engine version</th>
											<th rowspan="1" colspan="1">CSS grade</th>
										</tr>
									</tfoot>
									<div id="example1_filter" class="dataTables_filter">
								</table>
							</div>
						</div>
						<div class="row" >
							<div class="col-sm-5">
								<div class="dataTables_info" id="example1_info" role="status"
									aria-live="polite">Showing 1 to 10 of 57 entries</div>
							</div>
							<div class="col-sm-7">
								<div class="dataTables_paginate paging_simple_numbers"
									id="example1_paginate">
									<ul class="pagination">
										<li class="paginate_button previous disabled"
											id="example1_previous"><a href="#"
											aria-controls="example1" data-dt-idx="0" tabindex="0">Previous</a>
										</li>
										<li class="paginate_button active"><a href="#"
											aria-controls="example1" data-dt-idx="1" tabindex="0">1</a></li>
										<li class="paginate_button "><a href="#"
											aria-controls="example1" data-dt-idx="2" tabindex="0">2</a></li>
										<li class="paginate_button "><a href="#"
											aria-controls="example1" data-dt-idx="3" tabindex="0">3</a></li>
										<li class="paginate_button "><a href="#"
											aria-controls="example1" data-dt-idx="4" tabindex="0">4</a></li>
										<li class="paginate_button "><a href="#"
											aria-controls="example1" data-dt-idx="5" tabindex="0">5</a></li>
										<li class="paginate_button "><a href="#"
											aria-controls="example1" data-dt-idx="6" tabindex="0">6</a></li>
										<li class="paginate_button next" id="example1_next"><a
											href="#" aria-controls="example1" data-dt-idx="7"
											tabindex="0">Next</a></li>
									</ul>
								</div>
								<div class="dropdown">
									<button class="btn btn-primary dropdown-toggle" type="button"
										data-toggle="dropdown">
										검색조건 <span class="caret"></span>
									</button>
									<ul class="dropdown-menu">
										<li><a href="#">전체</a></li>
										<li><a href="#">제목</a></li>
										<li><a href="#">작성자</a></li>
									</ul>
									<input type="search" class="form-control input-sm"
										style="width: 300px;" placeholder="검색어를 입력하세요.."
										aria-controls="example1">
									<button class="btn btn-primary" type="button">검색</button>

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- /.box-body -->
		</div>
	</section>
	
</body>
<script type="text/javascript">
$(function(){
	if (eval('${!empty param.message}')) {
		alert('${param.message}');
	}
})
</script>
</html>


<!-- /.content -->

