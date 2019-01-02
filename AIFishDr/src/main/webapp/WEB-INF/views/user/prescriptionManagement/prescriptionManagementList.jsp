<%--==============================================================
 * jsp 개요 : 회원전용페이지 내에 있는 처방내역관리
 * @author : 
 * @since : 2018. 12. 04.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일             수정자     수정내용
 *    --------------     ------		------------
 *    2018. 12. 04.      심재형     최초작성
 * Copyright (c) 2018 AI Fish Dr. All right reserved
 * </pre>
===============================================================--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>

	<style>
	
		@font-face { font-family: 'NanumGothic'; src: url(NanumFont_TTF_ALL/NanumGothic.ttf) format('truetype'); }
		
		.wrap {
		
			position : relative;
			display : -webkit-flex;
			display : flex;
			-webkit-justify-content : center;
			justify-content : center;
			-webkit-align-items : center;
			align-items : center;
		
		}
		
	</style>

<body>

<div class="content-wrapper" style="margin-left:10px;">

<!-- Main content -->
<section class="content" style = "height:822px;">

	<div>
	
		<h1>		</h1>
		
	</div>
	
	<div class="row">
	
		<!-- 처방내역관리 게시판 영역 -->
		<div class = "col-md-12">
			
			<!-- 처방내역관리 게시판 박스 -->
			<div class="box box-solid box-info">
			
				<div class="box-header">
				
					회원 처방 내역
				
				</div>
				
				<div class="box-body">
				
					<div id="example1_wrapper" class="dataTables_wrapper form-inline dt-bootstrap">
					
						<div class="row">
						
							<div class="col-sm-6">
								<div class="dataTables_length" id="example1_length"></div>
							</div>
							
							<div class="col-sm-6"></div>
							
						</div>
						
						<div class="row">
						
							<div class="col-sm-12">
							
								<div id="example1_filter" class="dataTables_filter"></div>
								
								<table id="prescriptionListTable" class="table table-bordered table-striped dataTable">
								
									<thead>
									
										<tr>
											
											<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center;">No.</th>
<!-- 											<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center;">의사코드</th> -->
<!-- 											<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center;">처방코드</th> -->
											<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center;">어종</th>
											<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center;">중량</th>
											<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center;">마리수</th>
											<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center;">증상</th>
											<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center;">관리원명</th>
											<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center;">처방날짜</th>
<!-- 											<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center;">파일명</th> -->
											
										</tr>
										
									</thead>
									
									<tbody>
		
										<c:forEach items="${pml}" var="pml" varStatus="stat">
																					
											<c:forEach items="${compareList}" var="compareList" varStatus="status">
																							
												<c:if test="${(pml.PRSCRPTN_CODE eq compareList.PRSCRPTN_CODE) and (pml.HOSPITAL_NAME eq compareList.HOSPITAL_NAME) and (pml.FISH_NAME eq compareList.FISH_NAME)}">
													
													<c:if test="${(stat.count % 2) eq 1 }">
													<tr class="odd" onmouseover="this.style.background='#ECCEF5'" onmouseout="this.style.background='#FAFAFA'" style="cursor:pointer">
													</c:if>
													
													<c:if test="${(stat.count % 2) eq 0 }">
													<tr class="odd" onmouseover="this.style.background='#ECCEF5'" onmouseout="this.style.background='white'" style="cursor:pointer">
													</c:if>
																								
														<td style = "text-align : center;">${pml.RNUM}</td>
		<%-- 												<td style = "text-align : center;">${list.TREAT_CODE}</td> --%>
		<%-- 												<td style = "text-align : center;">${list.PRSCRPTN_CODE}</td> --%>
														<td style = "text-align : center;">${pml.FISH_NAME}<input name = "treat_code" type = "hidden" value = "${pml.TREAT_CODE}"></td>
														<td style = "text-align : center;">${pml.FISH_WEIGHT}<input name = "prscrptn_code" type = "hidden" value = "${pml.PRSCRPTN_CODE}"></td>
														<td style = "text-align : center;">${pml.FISH_NUMBER}<input name = "prscrptn_name" type = "hidden" value = "${pml.PRSCRPTN_NAME}"></td>
														<td style = "text-align : center;">${pml.FISH_SYMPTMS}</td>
														<td style = "text-align : center;">${pml.HOSPITAL_NAME}</td>
														<td style = "text-align : center;">${pml.TREAT_REG_DATE}</td>
		<%-- 												<td style = "text-align : center;">${list.PRSCRPTN_NAME}</td> --%>
														
													</tr>
												
												</c:if>
											
											</c:forEach>
											
										</c:forEach>
		
									</tbody>
									
								</table>
		
								<div>
								
<%-- 									<form action = "${pageContext.request.contextPath }/user/prescriptionManagement/prescriptionManagementList.do" method = "get"> --%>
									
										<div style = "float:left">
										
											<select name ="search_keycode" class="form-control">
												<option value = "TOTAL">전체</option>
<!-- 												<option value = "OPTION_TREAT_CODE">의사코드</option> -->
<!-- 												<option value = "OPTION_PRSCRPTN_CODE">처방코드</option> -->
												<option value = "OPTION_FISH_NAME">어종</option>
<!-- 												<option value = "OPTION_FISH_WEIGHT">중량</option> -->
<!-- 												<option value = "OPTION_FISH_NUMBER">마리수</option> -->
												<option value = "OPTION_FISH_SYMPTMS">증상</option>
												<option value = "OPTION_HOSPITAL_NAME">관리원명</option>
											</select>
											
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											
											<input id = "search_keyword" name = "search_keyword" type="text" class="form-control" style="width: 300px;" placeholder="검색어를 입력하세요.." value = "${params.search_keyword }">
											
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											
<!-- 											<button class="btn btn-primary" type="submit">검색</button> -->
											
											<button class="btn btn-primary" type="button" id = "searchPrescription">검색</button>
																				
										</div>
										
<!-- 									</form> -->
										
								</div>
																				
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

<!-- 아래 html 건들지 말것 -->

</section>
</div>

</body>

<script type="text/javascript">
	
	$(function() {
		
		$('#searchPrescription').click(function() {
			
			var currentPage = '${params.currentPage}';
			var search_keyword = $('input[name=search_keyword]').val();
			var search_keycode = $('select[name=search_keycode]').val();
			
			var query = '';
			
			if (currentPage == null) {
				
				currentPage = 1;
				
			}
			
			if (search_keyword != null && search_keyword != '') {
				
				query = '?currentPage=' + currentPage + '&search_keyword=' + search_keyword + '&search_keycode=' + search_keycode;
				
				$(location).attr('href', '${pageContext.request.contextPath}/user/prescriptionManagement/prescriptionManagementList.do' + query);
				
			} else {
				
				query = '?currentPage=' + currentPage;
				
				$(location).attr('href', '${pageContext.request.contextPath}/user/prescriptionManagement/prescriptionManagementList.do' + query);
				
			}
			
		});
		
				
		$('#prescriptionListTable tr:gt(0)').click(function() {
		
			
			
			var fish_name = $(this).find('td:eq(1)').text();
			var treat_code = $(this).find('td:eq(1) input').val();
			
			var fish_weight = $(this).find('td:eq(2)').text();
			var prscrptn_code = $(this).find('td:eq(2) input').val();
			
			var fish_number = $(this).find('td:eq(3)').text();
			var prscrptn_name = $(this).find('td:eq(3) input').val();
			
			var fish_symptms = $(this).find('td:eq(4)').text();
			var hospital_name = $(this).find('td:eq(5)').text();
			var treat_reg_date = $(this).find('td:eq(6)').text();
			
			
			var currentPage = '${params.currentPage}';
	    	var search_keyword = '${params.search_keyword}';
	    	var search_keycode = '${params.search_keycode}';
	    	
	    	var query = '';
			
			if (currentPage == null) {
				
				currentPage = 1;
				
			}
			
			if (search_keyword != null && search_keyword != '') {
				
				query = '?currentPage=' + encodeURIComponent(currentPage) + '&search_keyword=' + encodeURIComponent(search_keyword) + '&search_keycode=' + encodeURIComponent(search_keycode) +
						'&treat_code='  + encodeURIComponent(treat_code)  + '&prscrptn_code='  + encodeURIComponent(prscrptn_code)  + '&fish_name=' 	 + encodeURIComponent(fish_name) +
						'&fish_weight=' + encodeURIComponent(fish_weight) + '&fish_number='    + encodeURIComponent(fish_number)    + '&fish_symptms='   + encodeURIComponent(fish_symptms) +
						'&treat_reg_date=' + encodeURIComponent(treat_reg_date) + '&hospital_name=' + encodeURIComponent(hospital_name) + '&prscrptn_name=' + encodeURIComponent(prscrptn_name);
				
				$(location).attr('href', '${pageContext.request.contextPath}/user/prescriptionManagement/prescriptionManagementView.do' + query);
				
			} else {
				
				query = '?currentPage=' + encodeURIComponent(currentPage) +
						'&treat_code='  + encodeURIComponent(treat_code)  + '&prscrptn_code='  + encodeURIComponent(prscrptn_code)  + '&fish_name=' 	 + encodeURIComponent(fish_name) +
						'&fish_weight=' + encodeURIComponent(fish_weight) + '&fish_number='    + encodeURIComponent(fish_number)    + '&fish_symptms='   + encodeURIComponent(fish_symptms) +
						'&treat_reg_date=' + encodeURIComponent(treat_reg_date) + '&hospital_name=' + encodeURIComponent(hospital_name) + '&prscrptn_name=' + encodeURIComponent(prscrptn_name);
				
				$(location).attr('href', '${pageContext.request.contextPath}/user/prescriptionManagement/prescriptionManagementView.do' + query);
				
			}
			
		});
				
	});
	
</script>