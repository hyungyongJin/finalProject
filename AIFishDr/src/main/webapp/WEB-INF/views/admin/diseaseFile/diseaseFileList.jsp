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
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<head>
<style type="text/css">
table, th{text-align: center;}
</style>
</head>
<body>
	<div class="content-wrapper" style="margin-left: 10px;">
		<!-- Main content -->
		<section class="content">
			<div class="row">
				<div class="col-md-12">

					<!-- 위 html 지우지 말 것  -->

					<div class="box">
						<div class="box-header"></div>
						<!-- /.box-header -->
						<div class="box-body">
							<div id="example1_wrapper"
								class="dataTables_wrapper form-inline dt-bootstrap">
								<div class="row">
									<div class="col-sm-10">
										<div class="dataTables_length" id="example1_length">
											<form id="form"
												action="${pageContext.request.contextPath }/admin/diseaseFile/diseaseFileList.do"
												method="post">
												<div class="dropdown">
													<select name="search" class="form-control">
														<option value="TOTAL">전체</option>
														<option value="CODE">코드</option>
														<option value="NAME">질병명</option>
													</select> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input name="keyword"
														type="search" class="form-control input-md"
														style="width: 300px;" placeholder="검색어를 입력하세요.."
														aria-controls="example1">
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													<button id="searchBtn" class="btn btn-primary btn-md"
														type="submit">검색</button>
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													<button id="searchBtn" value="2" name="noPics"
														class="btn btn-primary bg-purple btn-md" type="submit">등록완료</button>
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													<button id="searchBtn" value="1" name="noPics"
														class="btn btn-primary bg-purple btn-md" type="submit">등록미완료</button>
												</div>
											</form>
											<hr>
										</div>
									</div>
									<div class="col-sm-6"></div>
								</div>
								<div class="row">
									<div class="col-sm-12">
										<div id="example1_filter" class="dataTables_filter"></div>
										<form id="deleteBoard" method="post"
											action="${pageContext.request.contextPath }/admin/board/deleteBoard.do">
											<table id="example1"
												class="table table-bordered table-striped dataTable"
												role="grid" aria-describedby="example1_info">
												<thead>
													<tr style="background-color: lightblue;" role="row">
														<th class="sorting" tabindex="0" rowspan="1" colspan="1"
															style="width: 361px;">질병명</th>
														<th class="sorting" tabindex="0" rowspan="1" colspan="1"
															style="width: 50px;">등록된 사진 수</th>
														<th class="sorting" tabindex="0" rowspan="1" colspan="1"
															style="width: 50px;">사진 추가</th>
														<th class="sorting" tabindex="0" rowspan="1" colspan="1"
															style="width: 50px;">사진 보기</th>
													</tr>
												</thead>
												<tbody id="boardTable">

													<c:forEach items="${ dissList}" var="list">
														<tr role="row" class="odd">
															<td>${list.DISS_NAME}</td>
															<td>${list.COUNT}개</td>
															<td>
																<button type="button" value="${list.DISS_CODE }"
																	class="insertBtn btn btn-info">
																	<span class="glyphicon glyphicon-plus"></span>
																</button>
															</td>
															<td><button type="button" value="${list.DISS_CODE }"
																	class="viewBtn btn btn-primary">
																	<span class="glyphicon glyphicon-search"></span>
																</button></td>
														</tr>
													</c:forEach>
												</tbody>
												<tfoot style="border-style: none;">
													<tr>
														<td colspan="5">${paging }</td>
													</tr>
												</tfoot>
											</table>
										</form>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-5"></div>
								</div>



							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
			<!-- /.box-body -->
	</div>




	<!-- 게시판 생성시 나타날 모달 -->
	<div class="modal" id="waitModal" tabindex="-1" role="dialog">
		<div class="modal-dialog modal-md">
			<div class="modal-content">
				<div class="modal-body">
					<span id="showWait" style="color: green; font-size: 15pt;">
					</span>
					<p>
						<br> <img style="margin-left: 35%;"
							src="${pageContext.request.contextPath }/images/waitingIcon.gif">
				</div>
			</div>
		</div>
	</div>

	<div class="modal" id="insertModal" tabindex="-1" role="dialog">
		<div class="modal-dialog modal-md">
			<form id="insertForm" method="post">
				<div class="modal-content">
					<div class="modal-body">
						<span id="showWait" style="color: green; font-size: 15pt;">사진
							등록</span>
						<hr>
						<table class="table table-bordered table-striped dataTable">
							<tr style="background-color: lightblue;">
								<th><label class="diCode"></label> <input type="hidden"
									id="diCode1" name="diss_code" value=""></th>
								<th><label class="diName"></label></th>
							</tr>
							<tr>
								<th colspan="2">
									<button type="button" id="createFile" class="btn btn-info">파일추가</button>
								</th>
							</tr>
							<tbody id="list">
							</tbody>
						</table>
					</div>

					<div class="modal-footer">
						<button type="button" class="btn btn-primary pull-right"
							data-dismiss="modal">닫기</button>
						<button id="finalInsBtn" type="button"
							class="btn btn-info pull-right" style="margin-right: 10px;">등록</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	<!--뷰 모달창  -->

	<div class="modal fade" id="viewPics" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-body">
					<span id="showWait"
						style="color: green; font-size: 15pt; margin: 10px;">등록된 사진</span>
					<hr>
					<div class="box">
						<div class="box-header">
							<table class="table table-bordered table-striped dataTable">
								<tr style="background-color: lightblue;">
									<th>질병코드</th>
									<th>질병명칭</th>
								</tr>
								<tr>
									<th><label class="diCode"></label></th>
									<th><label class="diName"></label></th>
								</tr>
							</table>

						</div>
						<!-- /.box-header -->
						<div class="box-body pad">
							<div id="imageDiv" class="form-group"></div>
						</div>
					</div>
					<div id="fileShow"
						style="padding-left: 100px; overflow: auto; height: 200px;">
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
					</div>

				</div>
			</div>
		</div>
	</div>


	
  </body>
<script type="text/javascript">

$(function(){
	$('input[name=keyword]').val('${keyword}');
	if (eval('${!empty search}')) {
		$('select[name=search]').val('${search}');
	}
	
	$('#createFile').click(function(){
		var cnt = $('input[type=file]').length;
		if (cnt==6) {
			alert("더 이상 파일을 추가할 수 없습니다.");			
		}else{
			var html = '<tr>';
			html += '<td colspan="2" height="45"><input type="file" name="files" style="float:left;"><button class="btnDel btn btn-sm btn-danger" type="button">취소</button></button>';
			html += '</td></tr>';
			$("#list").append(html); 
		}
	});
			  
	$("#list").on("click", ".btnDel", function() { 
		$(this).parent().parent().remove();
	}); 
	
	
	
	if(eval('${!empty message}')){
		alert('${message}');
	};
	
	$('.insertBtn').click(function(){
		var code =  $(this).val();
		var name = $(this).parent().siblings('td:eq(0)').text();
		$('#diCode1').val(code);
		$('.diCode').text(code);
		$('.diName').text(name);
		$("#list").empty();
		$('#insertModal').modal({backdrop : 'static'});
	});
	$('#finalInsBtn').click(function(){
		var checkImage = $('input[type=file]').val();
		checkImage = checkImage.slice(checkImage.indexOf(".")+1).toLowerCase();
		if (checkImage!="jpg"&&checkImage!="png"&&checkImage!="gif"&&checkImage!="bmp") {
			alert('이미지 파일만 등록이 가능합니다.');
			return;
		}		
		if ($('input[type=file]').val()==''||$('input[type=file]').length==0) {
			alert('사진이 선택되지 않았습니다.');
			return;
		}else{
			var form = $('form')[2];
			var formData = new FormData(form);
			$.ajax({
				url :'${pageContext.request.contextPath}/admin/diseaseFile/insertDissFile.do',
				data : formData,
				processData: false,
				contentType: false,
				type : 'POST',
				success : function(data){
				},
				error : function(res){
					alert(res.status);
				},
				complete : function(data){
					var keyword = $('input[name=keyword]').val();
					var search = $('select[name=search]').val();
					alert("사진이 등록 되었습니다.");
					$('#insertModal').modal('hide');
					$(location).attr('href','${pageContext.request.contextPath}/admin/diseaseFile/diseaseFileList.do?search='+search+'&keyword='+encodeURIComponent(keyword));
				}
			});
		};		
	});
	$('.viewBtn').click(function(){
		$('#imageDiv').empty();
		$('#fileShow').empty();
		var code =  $(this).val();
		var name = $(this).parent().siblings('td:eq(0)').text();
		$('.diCode').text(code);
		$('.diName').text(name);
		$.ajax({
			url :'${pageContext.request.contextPath}/admin/diseaseFile/dissFileView.do?diss_code='+code,
			success : function(data){
				var list = data.fileList;
				var code ='';
				var html ='';
				for (var i = 0; i < list.length; i++) {
					 code += '<img id="'+list[i].file_no+'" src="/image/'+list[i].file_save_name +'" width="183" height="180">';
					 html += '<p><input type="text" value="'+list[i].file_name+'" disabled="disabled">';
					 html += '<button type="button" value="'+list[i].file_no+'" onclick="delDissFile(this.value);" class="btn btn-sm btn-danger">삭제</button></p>';
				}	
				
				$('#imageDiv').append(code);
				$('#fileShow').append(html);
			},
			error : function(res){
				alert(res.status);
			},
			complete : function(data){
				$('#viewPics').modal({backdrop : 'static'});
			}
		});
		
		
	});
	
	delDissFile = function(value){
		$.ajax({
			url : '${pageContext.request.contextPath}/admin/diseaseFile/delDissFile.do?file_no='+value,
			success : function(data){
				if (data.boolean) {
					$('#fileShow').children().find('button[value='+value+']').parent().empty();
					$('#'+value+'').remove();
					alert('삭제성공');
				}
				
			},error : function(res){
				alert(res.status);
			}		
		});
	};
	
});
</script>
