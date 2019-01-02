<%--==============================================================
 * jsp 개요 : 
 * @author : 
 * @since : 2018. 11. 13.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일             수정자     수정내용
 *    --------------     ------		------------
 *    2018. 11. 13.      심재형     최초작성
 * Copyright (c) 2018 AI Fish Dr. All right reserved
 * </pre>
===============================================================--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>

<body>
<!-- Main content -->
<section class="content">

		<div class="row">

			<div class="col-md-12">

				<!-- 위 html 지우지 말 것  -->

				<div class="box-header with-border">
					<h3 class="box-title">Quick Example</h3>
				</div>


				<div class="form-group">
					<label for="exampleInputEmail1">Email address</label>
					<button type="button" style="width: 140px; margin-left: 800px;"
						class="btn btn-info btn-sm" data-toggle="modal"
						data-target="#myModal">추천하기</button>
					<button type="button" style="width: 140px;"
						class="btn btn-info btn-sm" data-toggle="modal"
						data-target="#myModal">신고하기</button>
					<input type="email" class="form-control" id="exampleInputEmail1"
						placeholder="Enter email" style="width: 200px;">
				</div>


				<div class="box">
					<div class="box-header">
						<h3 class="box-title">
							Bootstrap WYSIHTML5 <small>Simple and fast</small>
						</h3>

					</div>
					<!-- /.box-header -->
					<div class="box-body pad">
						<form>
							<textarea class="textarea" placeholder="Place some text here"
								style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>
						</form>
					</div>
				</div>
				<div class="form-group">
					<label for="exampleInputFile">File input</label> <input
						type="password" class="form-control" id="exampleInputPassword1"
						placeholder="Password" style="width: 200px;"> <input
						type="file" id="exampleInputFile">

					<p class="help-block">Example block-level help text here.</p>
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Password</label> <input
						type="password" class="form-control" id="exampleInputPassword1"
						placeholder="Password" style="width: 200px;">
					<button type="button" style="width: 140px;"
						class="btn btn-info btn-sm" data-toggle="modal"
						data-target="#myModal">ID 찾기</button>
				</div>

			</div>
		</div>


		<div class="box">
			<div class="box-header">
				<h3 class="box-title">Data Table With Full Features</h3>
			</div>
			<!-- /.box-header -->
			<div class="box-body">
				<div id="example1_wrapper"
					class="dataTables_wrapper form-inline dt-bootstrap">

					<div class="row">
						<div class="col-sm-12">
							<table id="example1"
								class="table table-bordered table-striped dataTable" role="grid"
								aria-describedby="example1_info">
								<thead>
									<tr role="row">
										<th class="sorting_asc" tabindex="0" aria-controls="example1"
											rowspan="1" colspan="1" aria-sort="ascending"
											aria-label="Rendering engine: activate to sort column descending"
											style="width: 102.6px;">Rendering engine</th>
										<th class="sorting" tabindex="0" aria-controls="example1"
											rowspan="1" colspan="1"
											aria-label="CSS grade: activate to sort column ascending"
											style="width: 58px;">CSS grade</th>
										<th class="sorting" tabindex="0" aria-controls="example1"
											rowspan="1" colspan="1"
											aria-label="CSS grade: activate to sort column ascending"
											style="width: 58px;">CSS grade</th>
									</tr>

								</thead>
								<tbody>
									<tr role="row" class="odd">
										<td class="sorting_1">Gecko</td>
										<td>Firefox 1.0</td>
										<td>
											<div class="checkbox">
												<label> <input type="checkbox">수정
												</label>
											</div>
											<div class="checkbox">
												<label> <input type="checkbox">삭제
												</label>
											</div>
										</td>
									</tr>
								</tbody>
								<tfoot>
									<tr>
										<th rowspan="1" colspan="1">Rendering engine</th>
										<th rowspan="1" colspan="1">Browser</th>
										<th rowspan="1" colspan="1">
											<div class="checkbox">
												<label> <input type="checkbox"> 수정
												</label>
											</div>
											<div class="checkbox">
												<label> <input type="checkbox"> 삭제
												</label>
											</div>

										</th>
									</tr>
								</tfoot>
							</table>
						</div>
					</div>
					<div class="row"></div>

				</div>
			</div>
			<!-- /.box-body -->
			<button type="button" style="width: 140px;"
				class="btn btn-info btn-sm" data-toggle="modal"
				data-target="#myModal">수정</button>
			<button type="button" style="width: 140px;"
				class="btn btn-info btn-sm" data-toggle="modal"
				data-target="#myModal">삭제</button>
			<button type="button" style="width: 140px;"
				class="btn btn-info btn-sm" data-toggle="modal"
				data-target="#myModal">목록</button>
		</div>

		<!-- 아래 html 건들지 말것 -->
		</div>
        
	</div>
	
</section>

</body>

<script type="text/javascript">

	


</script>