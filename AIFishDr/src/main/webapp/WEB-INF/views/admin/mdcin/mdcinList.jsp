<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
	$(function() {
		
		if (eval('${!empty param.message}')) {
			alert('${param.message}');
		};
		
		$('#allCheck').click(function() {
			if ($('#allCheck').prop("checked")) {
				$('input[class=checkboxes]').prop("checked", true);
			} else {
				$('input[class=checkboxes]').prop("checked", false);
			}
		});
		
		$('.insertbtn').click(function(){
			$('#insertModal').modal();
		});
		
		$('.detail').click(function(){
			mdcin_code = $(this).val();
			$.ajax({
				url : '${pageContext.request.contextPath}/admin/mdcin/mdcinView.do?code='+mdcin_code,
				success : function(data){
					$('#mdcin_entrps_name').val(data.mdcinInfo.mdcin_entrps_name);
					$('#mdcin_prduct_name').val(data.mdcinInfo.mdcin_prduct_name);
					$('#mdcin_atpn').val(data.mdcinInfo.mdcin_atpn);
					$('#mdcin_pack').val(data.mdcinInfo.mdcin_pack);
					$('#mdcin_efcy_effect').val(data.mdcinInfo.mdcin_efcy_effect);
					$('#mdcin_material').val(data.mdcinInfo.mdcin_material);
					$('#ctgry_name').val(data.mdcinCateInfo.ctgry_name);
					$('input[name=ctgry_code]').val(data.mdcinCateInfo.ctgry_code);
					$('input[name=mdcin_code]').val(data.mdcinInfo.mdcin_code);
				},
				error : function(res){
					alert(res.status);
				}
			});
			$('#updateModal').modal();
		});
		
		$('#mdcin_update').click(function(){
			if ($('.mdcin_entrps_name').val() == null || $('.mdcin_entrps_name').val() == "") {
				alert('업체명을 입력해주세요.');
				return false;
			}else if ($('.mdcin_prduct_name').val() == null || $('.mdcin_prduct_name').val() == "") {
				alert('제품명을 입력해주세요');
				return false;
			}else if ($('.mdcin_atpn').val() == null || $('.mdcin_atpn').val() == "") {
				alert('주의사항을 입력해주세요');
				return false;
			}else if ($('.mdcin_pack').val() == null || $('.mdcin_pack').val() == "") {
				alert('포장단위를 입력해주세요');
				return false;
			}else if ($('.mdcin_efcy_effect').val() == null || $('.mdcin_efcy_effect').val() == "") {
				alert('효능 및 효과를 입력해주세요.');
				return false;
			}else if ($('.mdcin_material').val() == null || $('.mdcin_material').val() == "") {
				alert('원료 및 성분분량을 입력해주세요');
				return false;
			}else if ($('.ctgry_name').val() == null || $('.ctgry_name').val() == "") {
				alert('카테고리를 선택해주세요.');
				return false;
			}else {
				$('form[name=updateMdcin]').submit();
				return true;
			}
		});
		
		$('.deletebtn').click(function(){
			var checkRow = "";
			  $( "input[class='checkboxes']:checked" ).each (function (){
			    checkRow = checkRow + $(this).val()+"," ;
			  });
			  checkRow = checkRow.substring(0,checkRow.lastIndexOf( ","));
			
			if(checkRow == ''){
				alert('삭제할 대상을 선택해주세요');
				return;
			}
			
			$('form[name=deleteForm]').submit();
		});
		
		$('#mdcin_insert').click(function(){
			if ($('input[name=mdcin_entrps_name]').val() == null || $('input[name=mdcin_entrps_name]').val() == "") {
				alert('업체명을 입력해주세요.');
				return false;
			}else if ($('input[name=mdcin_prduct_name]').val() == null || $('input[name=mdcin_prduct_name]').val() == "") {
				alert('제품명을 입력해주세요');
				return false;
			}else if ($('textarea[name=mdcin_atpn]').val() == null || $('textarea[name=mdcin_atpn]').val() == "") {
				alert('주의사항을 입력해주세요');
				return false;
			}else if ($('textarea[name=mdcin_pack]').val() == null || $('textarea[name=mdcin_pack]').val() == "") {
				alert('포장단위를 입력해주세요');
				return false;
			}else if ($('textarea[name=mdcin_efcy_effect]').val() == null || $('textarea[name=mdcin_efcy_effect]').val() == "") {
				alert('효능 및 효과를 입력해주세요.');
				return false;
			}else if ($('textarea[name=mdcin_material]').val() == null || $('textarea[name=mdcin_material]').val() == "") {
				alert('원료 및 성분분량을 입력해주세요');
				return false;
			}else if ($('select[name=mdcinCate]').val() == '카테고리선택') {
				alert('카테고리를 선택해주세요.');
				return false;
			}else {
				$('form[name=insertForm]').submit();
				return true;
			}
			
		});
		
	});
</script>
<style>
	th, td{
		text-align:center;
	}
</style>
<div class="content-wrapper" style="margin-left: 10px;">
	<!-- Main content -->
	<section class="content">
	<div class="row">
		<div class="col-md-12">
			<form
				action="${pageContext.request.contextPath }/admin/mdcin/mdcinList.do"
				method="get">
				<div class="form-group"
					style="float: left; margin-left: 50px; width: 200px;">
					<select name="search_L_keycode"
						class="form-control select2 select2-hidden-accessible"
						style="width: 100%;" tabindex="-1" aria-hidden="true">
						<option selected="selected">대분류</option>
						<c:forEach items="${mdcincate }" var="mdcincate">
							<option value="${mdcincate.ctgry_name}">${mdcincate.ctgry_name}</option>
						</c:forEach>
					</select>

				</div>
				<div class="form-group"
					style="float: left; margin-left: 20px; width: 300px;">
					<select name="search_M_keycode"
						class="form-control select2 select2-hidden-accessible"
						style="width: 100%;" tabindex="-1" aria-hidden="true">
						<option selected="selected">중분류</option>
						<option value="업체명">업체명</option>
						<option value="제품명">제품명</option>
					</select>

				</div>

				<div class="form-group" style="width: 1500px;">
					<input style="width: 500px; float: left; margin-left: 20px;"
						type="text" class="form-control" name="search_keyword"
						placeholder="검색어를  입력하세요.." /> <input type="hidden" name="role"
						value="select" />
					<button style="margin-left: 20px; font-size: 15px; height:36px;" type="submit"
						class="btn btn-info btn-lg">검색</button>
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
							<div class="col-sm-12">
								<form name=deleteForm
									action='${pageContext.request.contextPath}/admin/mdcin/deleteMdcin.do'
									method="post">
									<table id="example1"
										class="table table-bordered table-striped dataTable"
										role="grid" aria-describedby="example1_info">
										<thead>
											<tr role="row">
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="Browser: activate to sort column ascending"
													style="width: 5%;"><input id="allCheck"
													type="checkbox"></th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="Platform(s): activate to sort column ascending"
													style="width: 20%;">업체명</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="Engine version: activate to sort column ascending"
													style="width: 40%;">제품명</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="Platform(s): activate to sort column ascending"
													style="width: 10%;">의약품 점수</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="CSS grade: activate to sort column ascending"
													style="width: 15%;">상세</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${mdcinList }" var="list" varStatus="status">
												<tr role="row" class="odd">
													<td><input type="checkbox" name="code"
														class="checkboxes" value="${list.mdcin_code }" /></td>
													<td>${list.mdcin_entrps_name}</td>
													<td>${list.mdcin_prduct_name}</td>
													
													<!-- 의약품점수 -->
													<c:if test="${medicineScoreList[status.index] eq '0' }">
												
													<td>점수미등록</td>
													
													</c:if>
													
													<c:if test="${!(medicineScoreList[status.index] eq '0') }">
													
													<td>${medicineScoreList[status.index]}&nbsp;/&nbsp; 5.0</td>
													
													</c:if>
													
													
													<td>
														<button value="${list.mdcin_code }" type="button"
															 class="detail btn btn-primary btn-sm"
															data-toggle="modal" data-backdrop="static"
															data-target="#myModal">
															<span class="glyphicon glyphicon-search"></span>
															</button>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</form>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-5"></div>
							<div class="col-sm-7">${paging }</div>
						</div>
						<button type="button" style="width: 140px; margin-right: 20px;"
							class="insertbtn btn btn-info btn-sm pull-right">등록</button>
						<button type="button" style="width: 140px; margin-right: 20px;"
							class="deletebtn btn btn-info btn-sm pull-right">삭제</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	</section>
	
</div>
<!-- /.box-body -->
			<!-- 의약품 등록모달 -->
			<div class="modal col-md-7" id="insertModal"
				style="margin-top: 55px; background: none; margin-left: 700px; width: 27%; height: 1000px;">
				<!-- Horizontal Form -->
				<div class="box box-info" style="width: 100%; height:85%;">
					<div class="box-header with-border">
						<h3 class="box-title"
							style=" margin-left: 80px; font-size: 25px;">의약품
							정보 등록</h3>
					</div>
					<!-- form start -->
					<form class="form-horizontal" style="margin-left:40px; width:80%;" name="insertForm" action="${pageContext.request.contextPath}/admin/mdcin/insertMdcin.do "
							method="post">
						<div class="box-body">
							<div class="form-group" style="margin-bottom: 20px;">
								<label for="inputEmail3"
									style="float: left; margin-right: 10px;">업체명:</label> <input
									type="text" class="form-control" name="mdcin_entrps_name"
									placeholder="(업체명)">
							</div>
							<div class="form-group" >
								<label for="inputEmail3"
									style="float: left; margin-right: 10px;">제품명:</label> <input
									type="text" class="form-control" name="mdcin_prduct_name"
									placeholder="(제품명)">
							</div>
							<div class="form-group" >
								<label for="inputEmail3"
									style="float: left; margin-right: 10px;">주의사항:</label>
								<br/>
								<div class="form-group">
									<textarea class="form-control" rows="3" name="mdcin_atpn"
										style="margin-left:13px; resize: none; width: 94%;" placeholder="(주의사항)"></textarea>
								</div>
							</div>
							<div class="form-group" >
								<label for="inputEmail3"
									style="float: left; margin-right: 10px;">포장단위:</label>
								<br/>
								<br/>
								<div class="form-group">
									<textarea class="form-control" rows="1" name="mdcin_pack"
										style="margin-left:13px; resize: none; width: 94%;" placeholder="(포장단위)"></textarea>
								</div>
							</div>
							<div class="form-group" >
								<label for="inputPassword3" style="float: left;">효능 및 효과
									:</label>
								<br/>
								<div class="form-group">
									<textarea class="form-control" rows="3" name="mdcin_efcy_effect"
										style="margin-left:13px; resize: none; width: 94%;" placeholder="(효능 및 효과)"></textarea>
								</div>
							</div>
							<div class="form-group" >
								<label for="inputPassword3" style="float: left; ">원료 및
									성분분량 :</label>
								<div class="form-group">
									<textarea class="form-control" rows="3" name="mdcin_material"
										style="margin-left:13px; resize: none; width: 94%;" placeholder="(원료 및 성분분량)"></textarea>
								</div>
							</div>
							<div class="form-group" >
								<label for="inputPassword3"
									style="float: left; margin-right: 10px;">카테고리 :</label> 
								<select name="mdcinCate"
									class="form-control select2 select2-hidden-accessible"
									style="width: 100%; float: left; margin-right: 10px; " tabindex="-1" aria-hidden="true">
									<option selected="selected">카테고리선택</option>
									<c:forEach items="${mdcincate }" var="mdcincate">
										<option value="${mdcincate.ctgry_name}">${mdcincate.ctgry_name}</option>
									</c:forEach>
								</select>
							</div>

						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
									data-dismiss="modal" id="mdcin_insert">등록</button>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">취소</button>
						</div>
					</form>
				</div>
			</div>
			
			<!--의약품 상세모달 -->
			<div class="modal col-md-7" id="updateModal"
				style="margin-top: 55px; background: none; margin-left: 700px; width: 27%; height: 1000px;">
				<!-- Horizontal Form -->
				<div class="box box-info" style="width: 100%; height:85%;"> 
					<div class="box-header with-border">
						<h3 class="box-title"
							style=" margin-left: 80px; font-size: 25px;">의약품
							상세 정보</h3>
					</div>
					<!-- form start -->
					<form class="form-horizontal" style="margin-left:40px; width:80%;" name="updateMdcin" action="${pageContext.request.contextPath}/admin/mdcin/updateMdcin.do" method="post">
						<div class="box-body">
							<div class="form-group" style="margin-bottom: 20px;">
								<label for="inputEmail3"
									style="float: left; margin-right: 10px;">업체명:</label> <input
									type="text" class="mdcin_entrps_name form-control" id="mdcin_entrps_name" name="mdcin_entrps_name"
									placeholder="(업체명)">
							</div>
							<div class="form-group" >
								<label for="inputEmail3"
									style="float: left; margin-right: 10px;">제품명:</label> <input
									type="text" class="mdcin_prduct_name form-control" id="mdcin_prduct_name" name="mdcin_prduct_name"
									placeholder="(제품명)">
							</div>
							<div class="form-group">
								<label for="inputEmail3"
									style="float: left; margin-right: 10px;">주의사항:</label>
								<div class="form-group">
									<textarea class="mdcin_atpn form-control" rows="3" id="mdcin_atpn" name="mdcin_atpn"
										style="margin-left:13px; resize: none; width: 94%;" placeholder="(주의사항)"></textarea>
								</div>
							</div>
							<div class="form-group" >
								<label for="inputEmail3"
									style="float: left; margin-right: 10px;">포장단위:</label>
								<div class="form-group">
									<textarea class="mdcin_pack form-control" rows="1" id="mdcin_pack" name="mdcin_pack"
										style=" margin-left:13px; resize: none; width: 94%;" placeholder="(포장단위)"></textarea>
								</div>
							</div>
							<div class="form-group" >
								<label for="inputPassword3" style="float: left;">효능 및 효과
									:</label>
								<div class="form-group">
									<textarea class="mdcin_efcy_effect form-control" rows="3" id="mdcin_efcy_effect" name="mdcin_efcy_effect"
										style="margin-left:13px; resize: none; width: 94%;" placeholder="(효능 및 효과)"></textarea>
								</div>
							</div>
							<div class="form-group" >
								<label for="inputPassword3" style="float: left; ">원료 및
									성분분량 :</label>
								<div class="form-group">
									<textarea class="mdcin_material form-control" rows="3" id="mdcin_material" name="mdcin_material"
										style="margin-left:13px; resize: none; width: 94%; " placeholder="(원료 및 성분분량)"></textarea>
								</div>
							</div>
							<div class="form-group" >
								<label for="inputPassword3"
									style="float: left; margin-right: 10px; ">카테고리 :</label> 
									<input type="text" class="ctgry_name form-control" id="ctgry_name" name="ctgry_name" placeholder="(카테고리)"/>
									<input type="hidden" name="mdcin_code"/>
							</div>
						</div>
							<div class="modal-footer" >
								<button type="button" class="btn btn-default"
										data-dismiss="modal" id="mdcin_update">수정</button>
								<button type="button" class="btn btn-default"
									data-dismiss="modal">취소</button>
							</div>
					</form>
				</div>
			</div>

			
	
