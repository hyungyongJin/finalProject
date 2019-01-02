<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<style>
.box {
	margin-left: 50px;
	width: 80%;
}

th {
	text-align: center;
}

textarea {
	resize: none;
}
</style>
</head>
<body>
<div class="content-wrapper" style="margin-left:10px;">
	<!-- Main content -->
	<section class="content">
		<div class="row">
			<div class="col-md-12">
				<form id="updateForm" method="post">
					<div class="box">
							<!-- /.box-header -->
							<div class="box-body pad">
								<input type="text" class="form-control"
									onkeyup="auto_size(this,this.size)" name="bo_title"
									style="background-color: white; font-size: 15pt; color: green; border: none;"
									value="${viewInfo[0].BO_TITLE }">
								<hr>
								<input type="hidden" name="bo_writer"
									value="${viewInfo[0].BO_WRITER}"> <input type="hidden"
									name="bo_no" value="${viewInfo[0].BO_NO }">
								<div class="dropdown">
									<a href="#" class=" dropdown-toggle" data-toggle="dropdown">
										&nbsp;&nbsp;&nbsp; ${viewInfo[0].MEM_NICKNAME }(${fn:substring(viewInfo[0].BO_WRITER,0 ,2) }***)
									</a><img src="https://cafe.pstatic.net/levelicon/1/1_1.gif"
										width="11" height="11"> |&nbsp; <span
										style="font-size: 10pt; color: blue;">
										${viewInfo[0].BOARD_NAME}</span>
								</div>
								<hr>
								<!-- 						<textarea id="note" class="textarea" name="bo_content"  -->
								<!-- 							style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"> -->
								<!-- 							</textarea> -->
								<div id="note">${content }</div>
								<input id="hidden" name="bo_content" type="text" value=""
									style="display: none;">

								<hr>
								<hr>
							</div>
							<hr>
						</div>
					</form>
						<div class="box">
							<div class="dataTables_wrapper form-inline dt-bootstrap">
								<button id="return" type="button"
									style="width: 140px; margin-right: 10px;"
									class="btn btn-info btn-sm bg-purple pull-right">목록</button>
							</div>
						</div>
					</div>
					</div>
				</section>
			</div>
</body>
<script type="text/javascript">
$(function(){
	$('#return').click(function(){
		$(location).attr('href','${pageContext.request.contextPath}/user/noticeboard/noticeboardList.do?currentPage=${currentPage}&search=${search}&keyword=${keyword}');
	});
	
});
</script>
</html>
