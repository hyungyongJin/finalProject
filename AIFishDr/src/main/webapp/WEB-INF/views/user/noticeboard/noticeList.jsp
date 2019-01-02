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

.sqarei{
	width: 100px;
    height: 100px;
    background-color: none;
    animation-name: fadeOut;
	animation-duration: 5s;
}

@keyframes fadeOut {
  0% {
    opacity: 0;
  }
  50% {
    opacity: 0;
  }
  100% {
    opacity: 1;
  }
}
.sqare {
    position: absolute;
    width: 100px;
    height: 100px;
    background-color: none;
    animation-name: move;
    animation-duration: 3s;
    animation-iteration-count: 1;
    ​animation-delay: 0s;
	animation-direction:normal ;
	animation-timing-function : ease;
	animation-fill-mode : both;
	transform-origin: 100% 100%; 
	​transform-origin:  right bottom; 
	​transform-origin:  left bottom;
	​transform-origin:  right top;
	​transform-origin:  left top;
     
/*      infinite */
}
/* @keyframes rule */
@keyframes move {
    /* keyframe */
    0% {
      left: 0;
    }
    /* keyframe */
    100% {
      left: 700px;
    }
    
}

#main{ 
	background-image:url("${pageContext.request.contextPath}/images/3ship.jpg") !important; 
	background-size: 100% 100% !important;

}     
   
</style>


<body>


<div  id="main" class="content-wrapper" style="margin-left:0.1px;">
	<section class="content">
		<!-- Small boxes (Stat box) -->
		<div class="row" >
			<div id="row" class="row" style="width:100%;">
				<div id="logo" >
					<span class="sqarei" style="font-size:120px; width:10%; margin-left:530px; "><b>AI Fish</b> Dr</span>
					<img class="sqare" alt="" src="${pageContext.request.contextPath}/images/gg.png" style=" width:10%; margin-left:750px; height:16%;">
				</div>
				<br>
				<br>
				<br>
				<br>
				<div class="box" style="height: 100%;">
				<div  class="col-lg-4 col-xs-6" style="margin-top:20px; ">
					<!-- small box -->
					<div onclick="main1()" class="small-box bg-aqua" style="width:100%; height:100px; cursor:pointer;">
						<div class="inner" >
							<h3 >의약품 검색</h3>
						</div>
						<div class="icon">
							<i class="fa fa-medkit"></i>
						</div>



					</div>
				</div>
				<!-- ./col -->
				<div onclick="main2()" class="col-lg-4 col-xs-6" style="margin-top:20px; float:left;">
					<!-- small box -->
					<div class="small-box bg-green" style="width:100%;height:100px; cursor:pointer;">
						<div class="inner" >
							<h3 >A.I 처방</h3>
						</div>
						<div class="icon">
							<i class="fa fa-stethoscope"></i>
						</div>
					</div>
				</div>
				<!-- ./col -->
				<div onclick="main3()" class="col-lg-4 col-xs-6" style="margin-top:20px;">
					<!-- small box -->
					<div class="small-box bg-yellow" style="width:100%;height:100px; cursor:pointer;">
						<div class="inner" >
							<h3 >A.I응답서비스</h3>
						</div>
						<div class="icon">
							<i class="fa fa-user-md"></i> 
						</div>


					</div>
				</div>
				<!-- ./col -->
			
			<!-- /.row -->
					
						<section class="content">
							<div class="row">
								<div class="col-md-6" >
									<table class="table" >
										<tr style="background-color: lightblue;">
											<th colspan="5">의약품 검색 상위 5</th>
										</tr>
										<tr style="background-color: lightblue;">
											<th style="width: 100px;">약품회사</th>
											<th style="width: 200px;">약품명</th>
										</tr>
										<tbody>
											<c:forEach items="${mdcinList }" var="list" end="4">
												<tr>
													<td>${list.mdcin_entrps_name }</td>
													<td>${list.mdcin_prduct_name }</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<div class="col-md-6" >
									<table class="table">
										<tr style="background-color: lightblue;">
											<th colspan="5">추천글 상위 5</th>
										</tr>
										<tr style="background-color: lightblue;">
											<th style="width: 80px;">게시판</th>
											<th style="width: 200px;">제목</th>
											<th style="width: 70px;">작성자</th>
											<th style="width: 100px;">작성일</th>
											<th style="width: 40px;">추천</th>
										</tr>
										<tbody>
											<c:forEach items="${famousList }" var="list" end="4">
												<tr>
													<td>${list.BOARD_NAME }</td>
													<c:if test="${!empty LOGIN_MEMBER }">
														<td><a
															href="${pageContext.request.contextPath }/user/${list.BOARD_ENG_NAME}/${list.BOARD_ENG_NAME}View.do?bo_no=${list.BO_NO}">${list.BO_TITLE }</a></td>
													</c:if>
													<c:if test="${empty LOGIN_MEMBER }">
														<td><a href="#" onclick="doLogin();">${list.BO_TITLE }</a></td>
													</c:if>
													<td>${list.MEM_NICKNAME }</td>
													<td>${list.BO_REG_DATE }</td>
													<td>${list.BO_GOOD_HIT }</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</section>
					</div>
				</div>
			<div class="box" id="boardMgr" style="margin-left:134px;">
					<div class="box-header" style="margin-left:100px;">
						<h3 style="font-size:30px;" class="box-title text-green">공지사항</h3>
					</div>

					<!-- /.box-header -->
					<div class="box-body">


						<div id="example1_wrapper"
							class="dataTables_wrapper form-inline dt-bootstrap">
							<div class="row">
								<div class="col-sm-12">
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

			<!-- /.box-body -->
		</div>
	</section>
</div>
</body>
<script type="text/javascript">
$(function(){
	history.replaceState({}, null, location.pathname);
	
	if (eval('${!empty param.message}')) {
		alert('${param.message}');
	}
	doLogin = function(){
		alert("로그인 후 이용이 가능합니다.");
	}
	main1 = function(){
		if (eval('${empty LOGIN_MEMBER}')) {
			alert("로그인 후 이용이 가능합니다.");
			return false;
		}
		$(location).attr('href', '${pageContext.request.contextPath}/user/mdcin/mdcinList.do');
	}
	main2 = function(){
		if (eval('${empty LOGIN_MEMBER}')) {
			alert("로그인 후 이용이 가능합니다.");
			return false;
		}
		$(location).attr('href', '${pageContext.request.contextPath}/user/aiDoctor/aiDoctor.do');
	}
	main3 = function(){
		if (eval('${empty LOGIN_MEMBER}')) {
			alert("로그인 후 이용이 가능합니다.");
			return false;
		}
		$(location).attr('href', '${pageContext.request.contextPath}/user/aiService/aiService.do');
	}
	
	
});

</script>
</html>



<!-- /.content -->

