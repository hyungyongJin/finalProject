<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form action="${pageContext.request.contextPath }/user/mdcin/mdcinList.do" method="get">
	<div class="form-group" style="float:left; margin-left:50px; width:200px;">
		<select name="search_L_keycode" class="form-control select2 select2-hidden-accessible" style="width: 100%;" tabindex="-1" aria-hidden="true">
			<option selected="selected">대분류</option>
			<c:forEach items="${mdcincate }" var="mdcincate">
				<option value="${mdcincate.ctgry_name}">${mdcincate.ctgry_name}</option>
			</c:forEach>
		</select> 
		
	</div>
	<div class="form-group" style="float:left; margin-left:20px; width:300px;">
		<select name="search_M_keycode" class="form-control select2 select2-hidden-accessible" style="width: 100%;" tabindex="-1" aria-hidden="true">
			<option selected="selected">중분류</option>
				<option value="업체명">업체명</option>
				<option value="제품명">제품명</option>
		</select>
		
	</div>
	
	<div class="form-group" style="width:1500px; ">
		<input style="width:500px; float:left; margin-left:20px;" type="text" class="form-control" name="search_keyword" placeholder="검색어를  입력하세요.."/>
		<button style="margin-left:20px; font-size:15px;" type="submit" class="btn btn-info btn-lg">검색</button>
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
			<div class="row">
				<div class="col-sm-12">
					<table id="example1"
						class="table table-bordered table-striped dataTable" role="grid"
						aria-describedby="example1_info">
						<thead>
							<tr role="row">
								<th>
										<input type="checkbox">
								</th>
								<th class="sorting" tabindex="0" aria-controls="example1"
									rowspan="1" colspan="1"
									aria-label="Browser: activate to sort column ascending"
									style="width: 100px;">번호</th>
								<th class="sorting" tabindex="0" aria-controls="example1"
									rowspan="1" colspan="1"
									aria-label="Platform(s): activate to sort column ascending"
									style="width: 500px;">업체명</th>
								<th class="sorting" tabindex="0" aria-controls="example1"
									rowspan="1" colspan="1"
									aria-label="Engine version: activate to sort column ascending"
									style="width: 200px;">제품명</th>
								<th class="sorting" tabindex="0" aria-controls="example1"
									rowspan="1" colspan="1"
									aria-label="Platform(s): activate to sort column ascending"
									style="width: 50px;">의약품 점수</th>
								<th class="sorting" tabindex="0" aria-controls="example1"
									rowspan="1" colspan="1"
									aria-label="CSS grade: activate to sort column ascending"
									style="width: 400px;">상세</th>
							</tr>
						</thead>
						<tbody>
								<tr role="row" class="odd">
									<td>
										<input type="checkbox">
									</td>
									<td>1</td>
									<td>1</td>
									<td>A</td>
									<td>
									<button type="button" style="width: 100px; "
											class="btn btn-info btn-sm" data-toggle="modal" data-backdrop="static"
											data-target="#myModal">1</button>
									</td>
									

								<!--                         의약품 상세모달 -->
							<div class="modal col-md-7" id="myModal"
								style="margin-left: 700px; width: 500px; height: 2000px; background:none;">
								<!-- Horizontal Form -->
								<div class="box box-info">
									<div class="box-header with-border">
										<h3 class="box-title"
											style="margin-top: 30px; margin-bottom: 30px; margin-left: 80px; font-size: 25px;">의약품
											상세 정보</h3>
									</div>
									<!-- /.box-header -->
									<!-- form start -->
									<form class="form-horizontal">
										<div class="box-body">
											<div class="form-group" style="margin-bottom: 20px;">
												<label for="inputEmail3" style="float: left;  margin-right:10px;">업체명:</label> <input type="text"
													class="form-control" id="inputEmail3" placeholder="(업체명)">
											</div>
											<div class="form-group" style="margin-bottom: 20px;">
												<label for="inputEmail3" style="float: left;  margin-right:10px;">제품명:</label> <input type="text"
													class="form-control" id="inputEmail3" placeholder="(제품명)">
											</div>
											<div class="form-group" style="margin-bottom: 20px;">
												<label for="inputEmail3" style="float: left;  margin-right:10px;">주의사항:</label>

												<div class="form-group">
													<textarea class="form-control" rows="5"
														style="resize: none; width: 400px;" placeholder="(주의사항)"></textarea>
												</div>
											</div>
											<div class="form-group" style="margin-bottom: 20px;">
												<label for="inputEmail3" style="float:left; margin-right:10px;">포장단위:</label>
												
												<div class="form-group">
													<textarea class="form-control" rows="5"
														style="resize: none; width: 300px;"
														placeholder="(포장단위)"></textarea>
												</div>
											</div>
											<div class="form-group" style="margin-bottom: 20px;">
												<label for="inputPassword3" style="float: left;">효능
													및 효과 :</label>
												<div class="form-group">
													<textarea class="form-control" rows="5"
														style="resize: none; width: 400px;"
														placeholder="(효능 및 효과)"></textarea>
												</div>
											</div>
											<div class="form-group" style="margin-bottom: 20px;">
												<label for="inputPassword3" style="float: left;">원료
													및 성분분량 :</label>
												<div class="form-group">
													<textarea class="form-control" rows="5"
														style="resize: none; width: 380px;"
														placeholder="(원료 및 성분분량)"></textarea>
												</div>
											</div>
											<div class="form-group" style="margin-bottom: 20px;">
												<label for="inputPassword3" style="float:left; margin-right:10px;">카테고리
													:</label> <input type="text" class="form-control"
													id="inputPassword3" placeholder="(카테고리)">
											</div>

										</div>
										<!-- /.box-body -->
										<div class="box-footer">
											<button type="submit" class="btn btn-default pull-right">취소</button>
										</div>
										<!-- /.box-footer -->
									</form>
								</div>
							</div>
							<!-- /.box -->
								</td>
								</tfoot>
					</table>
				</div>
			</div>
			
			<div class="row">
				<div class="col-sm-5">
				</div>
				<div class="col-sm-7">
<%-- 				${paging } --%>
				</div>
			</div>
		</div>
				<button type="button"  style="width:140px; margin-right:20px;" class="btn btn-info btn-sm pull-right" data-toggle="modal" data-target="#myModal">등록</button>
				<button type="button"  style="width:140px; margin-right:20px;" class="btn btn-info btn-sm pull-right" data-toggle="modal" data-target="#myModal">삭제</button>
	</div>
	<!-- /.box-body -->
</div>
<script type="text/javascript">
$(function(){
	
	
});
</script>