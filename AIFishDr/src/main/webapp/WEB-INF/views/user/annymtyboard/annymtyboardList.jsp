<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.sorting {
	text-align: center;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
$(function(){
	$('#insertBtn').click(function(){
		$(location).attr('href','${pageContext.request.contextPath}/user/annymtyboard/annymtyboardForm.do?board_code=board005');
	});
});
</script>
<body>
	<div class="content-wrapper" style="margin-left: 10px;">
	<!-- Main content -->
		<section class="content">
		<div class="row">
			<div class="col-md-12">
				<br>
				<hr>
				<div class="box" id="boardMgr">
					<div class="box-header">
						<h3 class="box-title text-green">${writeList[0].BOARD_NAME}</h3>
					</div>
					<!-- /.box-header -->
					<div class="box-body">
						<div id="example1_wrapper"
							class="dataTables_wrapper form-inline dt-bootstrap">
							<div class="row">
								<div class="col-sm-12">
								<!-- 검색 폼에 있는 search 와 keyword를 submit POST방식으로 넘겨준다. -->
									<form action="${pageContext.request.contextPath }/user/annymtyboard/annymtyList.do" method="post"> 
										<div class="dropdown">
											<select name="search" class="form-control">
												<option value="TOTAL">전체</option>
												<option value="TITLE">제목</option>
												<option value="CONTENT">내용</option>
											</select> 
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
											<input name="keyword" type="search" class="form-control input-md"
												style="width: 300px;" placeholder="검색어를 입력하세요.."
												aria-controls="example1">
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<button id="searchBtn" class="btn btn-primary btn-md"
												type="submit">검색</button>
										</div>
									</form>
								<!-- 검색 폼 끝  -->
									<br>
									<!-- 테이블 폼 시작  -->
									<form>
										<table class="table table-bordered table-striped dataTable"
											role="grid" aria-describedby="example1_info">
											<thead>
												<tr role="row">
													<th class="sorting" tabindex="0" rowspan="1" colspan="1"
														style="width: 40px;"><p class="text-green">No.</p></th>
													<th class="sorting" tabindex="0" rowspan="1" colspan="1"
														style="width: 500px;"><p class="text-green">제목</p></th>
													<th class="sorting" tabindex="0" rowspan="1" colspan="1"
														style="width: 55px;"><p class="text-green">글쓴이</p></th>
													<th class="sorting" tabindex="0" rowspan="1" colspan="1"
														style="width: 70px;"><p class="text-green">작성일</p></th>
													<th class="sorting" tabindex="0" rowspan="1" colspan="1"
														style="width: 30px;"><p class="text-green">조회</p></th>
													<th class="sorting" tabindex="0" rowspan="1" colspan="1"
														style="width: 30px;"><p class="text-green">추천</p></th>
												
												</tr>
												<c:forEach items="${noticeList}" var="list">
												<tr style="background-color: lightgrey;" role="row" class="odd">
													<td class="sorting"><p class="text-red">공지</p></td>
													<td><a  href="${pageContext.request.contextPath}/user/annymtyboard/annymtyboardView.do?bo_no=${list.BO_NO }&currentPage=${currentPage}
													&search=${search}&keyword=${keyword}"><span style="color: red">
													${list.BO_TITLE }</span></a></td>
													<td class="sorting"><p class="text-red">관리자</p></td>
													<td class="sorting">${list.BO_REG_DATE }</td>
													<td class="sorting">${list.BO_HIT }</td>
													<td class="sorting">${list.BO_GOOD_HIT }</td>
												</tr>
												</c:forEach>
											</thead>
											<tbody id="boardTable">
											<c:forEach items="${writeList}" var="list">
												<c:if test="${list.MEM_ID != 'admin' }">
												<tr role="row" class="odd">
													<td class="sorting">${list.RNUM }</td>
													<td><a  href="${pageContext.request.contextPath}/user/annymtyboard/annymtyboardView.do?bo_no=${list.BO_NO }&currentPage=${currentPage}
													&search=${search}&keyword=${keyword}">
													${list.BO_TITLE }</a></td>
													<td class="sorting">${list.MEM_NICKNAME }</td>
													<td class="sorting">${list.BO_REG_DATE }</td>
													<td class="sorting">${list.BO_HIT }</td>
													<td class="sorting">${list.BO_GOOD_HIT }</td>
												</tr>
												</c:if>
											</c:forEach>
											</tbody>
										</table>
									</form>
									<br>
									<div class="layer" style="margin-left:600px;">${paging }</div>
									<button id="insertBtn" type="button"
										style="width: 140px; margin-right: 10px;"
										class="btn btn-info btn-sm pull-right">글쓰기</button>
									</div>
								</div>	
							<br>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</div>
</body>
</html>