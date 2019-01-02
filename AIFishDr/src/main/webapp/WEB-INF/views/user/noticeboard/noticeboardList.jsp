<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<style>
.layer {
	position: relative;
	top: 50%;
	left: 40%;
	width: 300px;
	height: 100px;
	margin: -50px 0 0 -50px;
}

input {
	background-color: transparent;
	border: 0
}

.sorting {
	text-align: center;
}
</style>
</head>
<body>
<div class="content-wrapper" style="margin-left:10px;">
	<!-- Main content -->
	<section class="content">
		<div class="row">
			<div class="col-md-12">
				<br>
				<hr>
				<div class="box" id="boardMgr">
					<div class="box-header">
						<h3 class="box-title text-green">공지사항</h3>
					</div>

					<!-- /.box-header -->
					<div class="box-body">


						<div id="example1_wrapper"
							class="dataTables_wrapper form-inline dt-bootstrap">
							<div class="row">
								<div class="col-sm-12">
									<form
										action="${pageContext.request.contextPath }/user/noticeboard/noticeboardList.do"
										method="post">
										<div class="dropdown">
											<select name="search" class="form-control">
												<option value="TOTAL">전체</option>
												<option value="TITLE">제목</option>
												<option value="CONTENT">내용</option>
												<option value="WRITER">작성자</option>
											</select> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input name="keyword"
												type="search" class="form-control input-md"
												style="width: 300px;" placeholder="검색어를 입력하세요.."
												aria-controls="example1">
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<button id="searchBtn" class="btn btn-primary btn-md"
												type="submit">검색</button>
										</div>
									</form>
									<br>
									<form id="delForm" method="post"
										action="/AIFishDr/admin/board/deleteWrite.do">
										<table id="example1"
											class="table table-bordered table-striped dataTable"
											role="grid" aria-describedby="example1_info">
											<thead>
												<tr role="row">
													<th class="sorting" tabindex="0" rowspan="1" colspan="1"
														style="width: 40px;"><p class="text-green">No.</p></th>
													<th class="sorting" tabindex="0" rowspan="1" colspan="1"
														style="width: 500px;"><p class="text-green">제목</p></th>
													<th class="sorting" tabindex="0" rowspan="1" colspan="1"
														style="width: 50px;"><p class="text-green">글쓴이</p></th>
													<th class="sorting" tabindex="0" rowspan="1" colspan="1"
														style="width: 70px;"><p class="text-green">작성일</p></th>
													<th class="sorting" tabindex="0" rowspan="1" colspan="1"
														style="width: 30px;"><p class="text-green">조회</p></th>

												</tr>
											</thead>
											<tbody id="boardTable">
												<c:forEach items="${noticeList}" var="list">
													<tr role="row" class="odd">
														<td class="sorting">${list.RNUM }</td>
														<td><a
															href="${pageContext.request.contextPath}/user/noticeboard/noticeboardView.do?bo_no=${list.BO_NO }&currentPage=${currentPage}
													&search=${search}&keyword=${keyword}">
																${list.BO_TITLE }</a></td>
														<td class="sorting">${list.MEM_NICKNAME }</td>
														<td class="sorting">${list.BO_REG_DATE }</td>
														<td class="sorting">${list.BO_HIT }</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</form>
									<br>
									<div class="layer">${paging }</div>
								</div>
							</div>
							<br>
							<div class="row"></div>

						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
</body>
</html>
