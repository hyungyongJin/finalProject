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
									<div class="col-sm-6">
										<div class="dataTables_length" id="example1_length">
											<form
												action="${pageContext.request.contextPath }/admin/hospital/hospitalList.do"
												method="post">
												<div class="dropdown">
													<select name="search" class="form-control">
														<option value="TOTAL">전체</option>
														<option value="NAME">관리원명</option>
														<option value="ADDR">주소</option>
													</select> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input name="keyword"
														type="search" class="form-control input-md"
														style="width: 300px;" placeholder="검색어를 입력하세요.."
														aria-controls="example1">
													&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
													<button id="searchBtn" class="btn btn-primary btn-md"
														type="submit">검색</button>
												</div>
											</form>
										</div>
										<hr>
									</div>
									<div class="col-sm-6"></div>
								</div>
								<div class="row">
									<div class="col-sm-12">
										<div id="example1_filter" class="dataTables_filter"></div>
										<form id="delete" method="post"
											action="${pageContext.request.contextPath }/admin/hospital/deleteHospital.do">
											<table id="example1"
												class="table table-bordered table-striped dataTable"
												role="grid" aria-describedby="example1_info">
												<thead>
													<tr role="row">
														<th class="sorting_asc" tabindex="0" rowspan="1"
															colspan="1" style="width: 50px;"><button
																class="btn btn-primary" type="button" id="btnCheck">선택</button></th>
														<th class="sorting" tabindex="0" rowspan="1" colspan="1"
															style="width: 361px;">관리원 명</th>
														<th class="sorting" tabindex="0" rowspan="1" colspan="1"
															style="width: 322px;">주소</th>
														<th class="sorting" tabindex="0" rowspan="1" colspan="1"
															style="width: 257px;">연락처</th>
														<th class="sorting" tabindex="0" rowspan="1" colspan="1"
															style="width: 190px;">상세보기</th>
													</tr>
												</thead>
												<tbody id="hospitalTable">
													<c:forEach items="${ hospitalList}" var="list">
														<tr role="row" class="odd">
															<td class="sorting_1"><input type="checkbox"
																value="${list.hospital_code}" name="hospital_code"></td>
															<td>${list.hospital_name}</td>
															<td>${list.hospital_addr}</td>
															<td>${list.hospital_phone}</td>
															<td><button type="button"
																	value="${list.hospital_code }"
																	class="hospitalInfo btn btn-primary">
																	<span class="glyphicon glyphicon-search"></span>
																</button></td>
														</tr>
													</c:forEach>

												</tbody>
											</table>
											<button id="deleteBtn" type="button" style="width: 140px;"
												class="btn btn-danger btn-md pull-right">삭제</button>
											<button id="genBtn" type="button"
												style="width: 140px; margin-right: 10px;"
												class="btn btn-info btn-md pull-right">관리원 신규등록</button>
										</form>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-5"></div>
									${paging }
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- /.box-body -->
		
		<!--모달  -->
		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog modal-lg">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h3 class="modal-title" style="text-align: center;">질병관리원 정보
							수정</h3>
					</div>
					<div class="modal-body">
						<div class="box box-info">
							<div class="box-header with-border"></div>
							<!-- /.box-header -->
							<!-- form start -->
							<form id="updateForm" class="form-horizontal" action="${pageContext.request.contextPath }/admin/hospital/updateHospital.do" method="post">
								<div class="box-body">
									<div class="form-group">
										<label for="hospital_code" class="col-sm-2 control-label">관리원
											코드</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name="hospital_code"
												disabled="disabled" style="background-color: transparent;">
											<input type="hidden" class="form-control"
												name="hospital_code">
										</div>
									</div>
									<div class="form-group">
										<label for="hospital_name" class="col-sm-2 control-label">관리원
											명</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name="hospital_name">
										</div>
									</div>
									<div class="form-group">
										<label for="hospital_addr" class="col-sm-2 control-label">주소</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name="hospital_addr">
										</div>
									</div>
									<div class="form-group">
										<label for="hospital_phone" class="col-sm-2 control-label">전화번호</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name="hospital_phone">
										</div>
									</div>
									<div class="form-group">
										<label for="hospital_fax" class="col-sm-2 control-label">Fax</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name="hospital_fax">
										</div>
									</div>
									<div class="form-group">
										<label for="hospital_mail" class="col-sm-2 control-label">메일주소</label>
										<div class="col-sm-10">
											<input type="text" class="form-control" name="hospital_mail">
										</div>
									</div>
									<div class="form-group">
										<label for="hospital_dr_name" class="col-sm-2 control-label">원장</label>
										<div class="col-sm-10">
											<input type="text" id="hdn" class="form-control"
												name="hospital_dr_name"> <input
												id="hospital_agp_code1" type="hidden" class="form-control"
												name="hospital_agp_code">
										</div>
									</div>
									<div class="form-group">
										<label for="hospital_license" class="col-sm-2 control-label">License
											No.</label>
										<div class="col-sm-10">
											<input type="text" class="form-control"
												name="hospital_license">
										</div>
									</div>


								</div>
								<!-- /.box-body -->
								<div class="box-footer">
									<button type="button" class="btn btn-default pull-right"
										data-dismiss="modal">닫기</button>
									<button type="submit" class="btn btn-info pull-right"
										style="margin-right: 10px;">수정</button>
								</div>
								<!-- /.box-footer -->
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="modal fade" id="createModal" role="dialog">
			<div class="modal-dialog modal-md">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h3 class="modal-title" style="text-align: center;">질병관리원 정보
							등록</h3>
					</div>
					<div class="modal-body">
						<div class="box box-info">
							<div class="box-header with-border"></div>
							<!-- /.box-header -->
							<!-- form start -->
							<form id="insForm" class="form-horizontal" method="post">
								<div class="box-body">
									<div class="form-group">
										<label for="hospital_name" class="col-sm-2 control-label">관리원
											명</label>
										<div class="col-sm-6">
											<input id="hospital_name" type="text" class="form-control" name="hospital_name">
										</div>
									</div>
									<div class="form-group">
										<label for="hospital_addr" class="col-sm-2 control-label">주소</label>
										<div class="col-sm-6">
											<select class="form-control" name="addr1"
												style="width: 200px;">
												<option value="서울">서울특별시</option>
												<option value="부산">부산광역시</option>
												<option value="대구">대구광역시</option>
												<option value="인천">인천광역시</option>
												<option value="광주">광주광역시</option>
												<option value="대전">대전광역시</option>
												<option value="울산">울산광역시</option>
												<option value="경기">경기도</option>
												<option value="강원">강원도</option>
												<option value="충북">충청북도</option>
												<option value="충남">충청남도</option>
												<option value="전북">전라북도</option>
												<option value="전남">전라남도</option>
												<option value="경북">경상북도</option>
												<option value="경남">경상남도</option>
												<option value="제주">제주도</option>
											</select> <br> <input type="text" class="form-control"
												name="addr2" placeholder="상세주소 입력"> <input
												id="hospital_addr" type="hidden" class="form-control"
												name="hospital_addr">
										</div>
									</div>
									<div class="form-group">
										<label for="hospital_phone" class="col-sm-2 control-label">전화번호</label>
										<div class="col-sm-2">
											<select name="phone1" class="form-control"
												style="width: 100px;">
												<option value="02">02</option>
												<option value="031">031</option>
												<option value="032">032</option>
												<option value="033">033</option>
												<option value="041">041</option>
												<option value="042">042</option>
												<option value="043">043</option>
												<option value="044">044</option>
												<option value="051">051</option>
												<option value="052">052</option>
												<option value="053">053</option>
												<option value="054">054</option>
												<option value="055">055</option>
												<option value="061">061</option>
												<option value="062">062</option>
												<option value="063">063</option>
												<option value="064">064</option>
											</select>
										</div>
										<div class="col-sm-2">
											<input type="text" class="numberOnly form-control"
												style="width: 100px;" name="phone2">
										</div>
										<div class="col-sm-2">
											<input type="text" class="numberOnly form-control"
												style="width: 100px;" name="phone3"> <input
												id="hospital_phone" type="hidden" class="form-control"
												style="width: 100px;" name="hospital_phone">
										</div>
									</div>

									<div class="form-group">
										<label for="hospital_fax" class="col-sm-2 control-label">Fax</label>
										<div class="col-sm-2">
											<select class="form-control" name="fax1"
												style="width: 100px;">
												<option value="02">02</option>
												<option value="031">031</option>
												<option value="032">032</option>
												<option value="033">033</option>
												<option value="041">041</option>
												<option value="042">042</option>
												<option value="043">043</option>
												<option value="044">044</option>
												<option value="051">051</option>
												<option value="052">052</option>
												<option value="053">053</option>
												<option value="054">054</option>
												<option value="055">055</option>
												<option value="061">061</option>
												<option value="062">062</option>
												<option value="063">063</option>
												<option value="064">064</option>
											</select>
										</div>
										<div class="col-sm-2">
											<input type="text" class="numberOnly form-control"
												style="width: 100px;" name="fax2">
										</div>
										<div class="col-sm-2">
											<input type="text" class="numberOnly form-control"
												style="width: 100px;" name="fax3"> <input
												id="hospital_fax" type="hidden" class=" form-control"
												style="width: 100px;" name="hospital_fax">
										</div>
									</div>
									<div class="form-group">
										<label for="hospital_mail" class="col-sm-2 control-label">메일주소</label>
										<div class="col-sm-6">
											<input type="email" class="form-control" name="hospital_mail">
										</div>
									</div>
									<div class="form-group">
										<label for="hospital_dr_name" class="col-sm-2 control-label">원장</label>
										<div class="col-sm-6">
											<input id="hospital_dr_name" type="text" class="form-control"
												name="hospital_dr_name"> <input
												id="hospital_agp_code" type="hidden" class="form-control"
												name="hospital_agp_code">
										</div>
									</div>
									<div class="form-group">
										<label for="hospital_license" class="col-sm-2 control-label">License
											No.</label>
										<div class="col-sm-6">
											<input type="text" id="hospital_license" class="form-control"
												name="hospital_license">
										</div>
									</div>


								</div>
								<!-- /.box-body -->
								<div class="box-footer">
									<button type="button" class="btn btn-default pull-right"
										data-dismiss="modal">닫기</button>
									<button id="fBtn" type="button" class="btn btn-info pull-right"
										style="margin-right: 10px;">등록</button>
								</div>
								<!-- /.box-footer -->
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>

		<div class="modal" id="completeModal" tabindex="-1" role="dialog">
			<div class="modal-dialog modal-md">
				<div class="modal-content">
					<div class="modal-body">
						<span id="showWait" style="color: green; font-size: 15pt;"></span>
									<button type="button" onclick="goToList();" class="btn btn-default pull-right"
										data-dismiss="modal">닫기</button>
					</div>
				</div>
			</div>
		</div>
</body>
<script type="text/javascript">

$(function(){
	if(eval('${!empty param.message}')){
		alert('${param.message}');
	};
	$('#btnCheck').click(function(){
		if ($('input[type=checkbox]').prop('checked')) {
			$('input[type=checkbox]').prop('checked',false);
		}else if ($('input[type=checkbox]').prop('checked',true)) {
			$('input[type=checkbox]').prop('checked',true);
		}
	});
	$('#deleteBtn').click(function(){
		//체크박스 선택된 갯수
		var cnt = $('input:checkbox[name=hospital_code]:checked').length;
		if (cnt>0) {
			$('#delete').submit();
		}else{
			alert('삭제할 질병관리원을 선택해주세요.');
		}
	});
	$('.hospitalInfo').click(function(){
		var code = $(this).val();
		$('#myModal').modal({backdrop : 'static'});
		$.ajax({
			url : '${pageContext.request.contextPath}/admin/hospital/hospitalView.do?hospital_code='+code,
			type: 'POST',
			success : function(data){
				var vo = data.info;
				$('input[name=hospital_code]').val(vo.hospital_code);
				$('input[name=hospital_name]').val(vo.hospital_name);
				$('input[name=hospital_addr]').val(vo.hospital_addr);
				$('input[name=hospital_phone]').val(vo.hospital_phone);
				$('input[name=hospital_fax]').val(vo.hospital_fax);
				$('input[name=hospital_mail]').val(vo.hospital_mail);
				$('input[name=hospital_dr_name]').val(vo.hospital_dr_name);
				$('input[name=hospital_license]').val(vo.hospital_license);
			},
			error : function(res){
				alert(res.status);
			}
		});
		
	});
	
	$('#genBtn').click(function(){
		$('#createModal').children().find('input').val('');
		$('#createModal').modal({backdrop:'static'});
	
	});
	$('#updateForm').submit(function(){
		var name= $('#hdn').val();
		$('#hospital_agp_code1').val(name);
	})
	
	$('#fBtn').click(function(){
		var name= $('#hospital_dr_name').val();
		$('#hospital_agp_code').val(name);
		var addr = $('select[name=addr1]').val();
		addr +=" "+$('input[name=addr2]').val();
		var phone = $('select[name=phone1]').val();
		phone += "-"+$('input[name=phone2]').val();
		phone += "-"+$('input[name=phone3]').val();
		var fax =$('select[name=fax1]').val();
		fax += "-"+$('input[name=fax2]').val();
		fax += "-"+$('input[name=fax3]').val();
		$('#hospital_addr').val(addr);
		$('#hospital_phone').val(phone);
		$('#hospital_fax').val(fax);
		
		if ($('#hospital_name').val()=='') {
			alert("관리원을 입력해 주세요");
			return;
		}
		if ($('input[name=addr2]').val()=='') {
			alert("상세주소를 입력해 주세요");
			return;
		}
		if ($('input[name=phone2]').val()=='') {
			alert("전화번호를 입력해 주세요");
			return;
		}
		if ($('input[name=phone3]').val()=='') {
			alert("전화번호를 입력해 주세요");
			return;
		}
		if ($('input[name=fax2]').val()=='') {
			alert("fax번호를 입력해 주세요");
			return;
		}
		if ($('input[name=fax3]').val()=='') {
			alert("fax번호를 입력해 주세요");
			return;
		}
		if ($('#hospital_dr_name').val()=='') {
			alert("이름을 입력해 주세요");
			return;
		}
		if ($('#hospital_license').val()=='') {
			alert("라이센스번호를 입력해 주세요");
			return;
		}
		var data = $('#insForm').serialize();
		$.ajax({
			url : '${pageContext.request.contextPath}/admin/hospital/insertHospital.do',
			type : 'POST',
			data : data,
			dataType : 'json',
			success : function(data){
				$('#createModal').modal('hide');
				$('#showWait').text("\""+data.hospitalVO.hospital_name+'" 정보 등록 완료.');
				$('#completeModal').modal();
			},
			error : function(res){
				alert(res.status);
			}
		});
	});
	$(".numberOnly").on("keyup", function() {
	    $(this).val($(this).val().replace(/[^0-9]/g,""));
	});
goToList = function(){
	$(location).attr('href','${pageContext.request.contextPath}/admin/hospital/hospitalList.do');
}
	
});
</script>
