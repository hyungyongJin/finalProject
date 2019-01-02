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

	<!-- 질병사진 파일 영역 -->
	<div style = "float:left; height:340px; width:30%; ">
	
		<c:if test="${params.fish_disease_file_save_name != null}">
		<img class="profile-user-img img-responsive img-circle" src="/image/${params.fish_disease_file_save_name}" alt="User profile picture" style = "cursor:pointer; height:340px; width:auto;">
		</c:if>
		
		<c:if test="${params.fish_disease_file_save_name == null}">
		<img class="profile-user-img img-responsive img-circle" src="${pageContext.request.contextPath }/dist/img/aiDoctor.png" alt="User profile picture" style = "cursor:pointer; height:340px; width:auto;">
		</c:if>
		
	
	</div>
			
	<!-- 처방내역관리 상세내역 박스 -->
	<div class="box box-solid box-info" style = "float:left; width:1095px; height:340px; margin-left:45px;">
		
		<div class="box-body" style = "width:1095px;">
			
			<!-- 회원 정보 + 수산질병관리원장 정보 테이블 영역 -->
			<div style = "float:left;">
			
				<!-- 수산질병관리원장 정보 관련 테이블을 포함하고 있는 영역 -->
				<div style = "float:left;">
				
					<!-- 수산질병관리원장 정보 관련 테이블 -->
					<table class="table table-bordered table-striped dataTable" style = "width:450px;">
					
						<tr>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center; background-color:skyblue; width:150px;">수산질병관리사</th>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center; width:300px;">${hv.hospital_dr_name }</th>
						</tr>
						
						<tr>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center; background-color:skyblue; width:150px;">연락처</th>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center; width:300px;">${hv.hospital_phone }</th>
						</tr>
						
						<tr>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center; background-color:skyblue; width:150px;">면허번호</th>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center; width:300px;">제 ${hv.hospital_license } 호</th>
						</tr>
						
					</table>
				
				</div>
				
				
				<!-- 회원 정보 관련 테이블을 포함하고 있는 영역 -->
				<div style = "float:left;">
				
					<!-- 회원 정보 관련 테이블 -->
					<table class="table table-bordered table-striped dataTable" style = "width:620px;">
				
						<tr>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center; background-color:skyblue; width:100px;">성명</th>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center; width:520px;">${mv.mem_name }</th>
						</tr>
						
						<tr>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center; background-color:skyblue; width:100px;">연락처</th>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center; width:520px;">${mv.mem_phone }</th>
						</tr>
						
						<tr>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center; background-color:skyblue; width:100px;">이메일</th>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center; width:520px;">${mv.mem_mail }</th>
						</tr>
						
					</table>
									
				</div>
				
			</div>
			
			
			<!-- 질병 감염 수산생물 정보 + 수산질병관리원 정보 영역 -->
			<div style = "float:left;">
				
				<!-- 수산질병관리원 정보 관련 테이블을 포함하고 있는 영역 -->
				<div style = "float:left;">
				
					<!-- 수산질병관리원 정보 관련 테이블 -->
					<table class="table table-bordered table-striped dataTable" style = "width:450px;">
					
						<tr>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center; background-color:skyblue; width:150px;">관리원명</th>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center; width:300px;">${params.hospital_name }</th>
						</tr>
						
						<tr>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center; background-color:skyblue; width:150px;">주소</th>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center; width:300px;">${hv.hospital_addr }</th>
						</tr>
						
						<tr>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center; background-color:skyblue; width:150px;">연락처</th>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center; width:300px;">${hv.hospital_phone }</th>
						</tr>
								
						<tr>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center; background-color:skyblue; width:150px;">팩스</th>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center; width:300px;">${hv.hospital_fax }</th>
						</tr>
						
						<tr>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center; background-color:skyblue; width:150px;">이메일</th>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center; width:300px;">${hv.hospital_mail }</th>
						</tr>
								
					</table>
									
				</div>
						
						
				<!-- 질병 감염 수산생물 정보 관련 테이블을 포함하고 있는 영역 -->
				<div style = "float:left;">
				
					<!-- 질병 감염 수산생물 정보 관련 테이블 -->
					<table class="table table-bordered table-striped dataTable" style = "width:620px;">
					
						<tr>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center; background-color:skyblue; width:100px;">품종</th>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center; width:520px;">${params.fish_name }</th>
						</tr>
						
						<tr>
						
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center; background-color:skyblue; width:100px;">병명</th>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center; width:520px;">
							
								<c:forEach items="${saveDiseaseNameList}" var="list" varStatus="stat">
								
									<c:if test = "${!(stat.last) }">
									
										${list},&nbsp;
										
									</c:if>
									
									<c:if test = "${stat.last }">
									
										${list}
									
									</c:if>
									
								</c:forEach>
														
							</th>
							
						</tr>
						
						<tr>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center; background-color:skyblue; width:100px;">중량</th>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center; width:520px;">${params.fish_weight }</th>
						</tr>
						
						<tr>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center; background-color:skyblue; width:100px;">미수</th>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center; width:520px;">${params.fish_number }</th>
						</tr>
						
						<tr>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center; background-color:skyblue; width:100px;">증상</th>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center; width:520px;">${params.representSymptms } 외 ${params.representSymptmsCount }건</th>
						</tr>
												
					</table>
									
				</div>
									
			</div>
							
		</div>

	</div>
	
	<!-- 처방 가능한 의약품 목록 관련 박스 -->
	<div class="box box-solid box-info" style = "float:left; width:100%; height:290px;">
		
		<div class = "box-header">
		
			처방 가능한 의약품 목록
		
		</div>
		
		<div class="box-body">
			
			<!-- 의약품 관련 테이블을 포함하고 있는 영역 -->
			<div style = "width:100%; height:230px; overflow:auto;">

				<!-- 처방 가능한 의약품 목록 관련 테이블 -->
				<table id = "medicinePossibleTable" class="table table-bordered table-striped dataTable">
			
					<thead>
							
						<tr>
<!-- 							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center;">No.</th> -->
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center;">의약품명</th>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center;">처방 가능 질병</th>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center;">처방 조건</th>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center;">용법 및 용량</th>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center;">휴약기간</th>
						</tr>
						
					</thead>
					
					<tbody>

						<c:forEach items="${rpl}" var="lista" varStatus="stat">
							
							<c:if test="${(stat.count % 2) eq 1 }">
							<tr class="odd" onmouseover="this.style.background='#ECCEF5'" onmouseout="this.style.background='#FAFAFA'" style="cursor:pointer">
							</c:if>
							
							<c:if test="${(stat.count % 2) eq 0 }">
							<tr class="odd" onmouseover="this.style.background='#ECCEF5'" onmouseout="this.style.background='white'" style="cursor:pointer">
							</c:if>

<%-- 								<td style = "text-align : center;">${lista.RNUM}</td>																		 --%>
								<td style = "text-align : center;">${lista.MDCIN_PRDUCT_NAME}</td>
								<td style = "text-align : center;">${lista.DISS_NAME}</td>
								<td style = "text-align : center;">${lista.SYMPTMS_CONTENT}</td>
								<td style = "text-align : center;">${lista.USCP_CONTENT}</td>
								<td style = "text-align : center;">${lista.WITHDRAWAL_PERIOD}</td>
								
							</tr>
							
						</c:forEach>

					</tbody>
					
				</table>
								
			</div>
			
<!-- 			<div class="row"> -->
						
<!-- 				<div class="col-sm-5"></div> -->
				
<%-- 				${paging } --%>
				
<!-- 			</div> -->
						
		</div>

	</div>
	
		<!-- 처방 받은 의약품 관련 박스 -->
	<div class="box box-solid box-info" style = "float:left; width:100%; height:140px;">
		
		<div class = "box-header">
		
			처방 받은 의약품
		
		</div>
		
		<div class="box-body">
						
			<div>
			
				<!-- 이미 점수를 준 의약품이라면 붉은색으로 처리 -->
				<c:if test="${!(totalCountTreatCode eq '0') and !(totalCountPrscrptnCode eq '0') }">
				
				<!-- 처방 받은 의약품 목록 관련 테이블 -->
				<table id = "medicineTableComplete" class="table table-bordered table-striped dataTable">
			
					<thead>
							
						<tr>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center;">의약품명</th>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center;">처방 가능 질병</th>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center;">처방 조건</th>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center;">용법 및 용량</th>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center;">휴약기간</th>
						</tr>
						
					</thead>
					
					<tbody>

						<tr class="odd" style = "background:coral;">
												
							<td style = "text-align : center;">${params.MDCIN_PRDUCT_NAME}</td>
							<td style = "text-align : center;">${params.DISS_NAME}</td>
							<td style = "text-align : center;">${params.SYMPTMS_CONTENT_CHOICE}</td>
							<td style = "text-align : center;">${params.USCP_CONTENT}</td>
							<td style = "text-align : center;">${params.WITHDRAWAL_PERIOD}</td>
							
						</tr>
						
					</tbody>
					
				</table>
				
				</c:if>
				
				
				<!-- 아직 점수를 주지 않은 의약품이라면 노란색으로 처리 -->
				<c:if test="${(totalCountTreatCode eq '0') or (totalCountPrscrptnCode eq '0')}">
				
 				<!-- 처방 받은 의약품 목록 관련 테이블 -->
				<table id = "medicineTable" class="table table-bordered table-striped dataTable">
			
					<thead>
							
						<tr>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center;">의약품명</th>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center;">처방 가능 질병</th>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center;">처방 조건</th>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center;">용법 및 용량</th>
							<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center;">휴약기간</th>
						</tr>
						
					</thead>
					
					<tbody>

						<tr class="odd" style = "background:gold;">
												
							<td style = "text-align : center;">${params.MDCIN_PRDUCT_NAME}</td>
							<td style = "text-align : center;">${params.DISS_NAME}</td>
							<td style = "text-align : center;">${params.SYMPTMS_CONTENT_CHOICE}</td>
							<td style = "text-align : center;">${params.USCP_CONTENT}</td>
							<td style = "text-align : center;">${params.WITHDRAWAL_PERIOD}</td>
							
						</tr>
						
					</tbody>
					
				</table>
				
				</c:if>
								
			</div>
			
			
			<!-- 의약품 점수 모달창 (이미 점수를 준 경우) -->
			<div class="modal modal-info fade" id = "completeMedicineScore" >
			
				<div class="modal-dialog">
				
					<div class="modal-content" >
					
						<div class="modal-header" style="background-color: #4E8DF5 !important;" >
						
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							
							<h4 class="modal-title">점수등록완료된 의약품</h4>
							
						</div>
						
						<div class="modal-body" style="background-color: white !important;">
						
							<h4 style = "color:black; font-weight:bold;">이미 점수를 준 의약품이므로 점수 등록을 할 수 없습니다.</h5>
												
						</div>
						
						<div class="modal-footer" style="background-color: white !important;">
									
							<button type="button" class="btn btn-info" data-dismiss="modal" style="background-color: #8FCEFF  !important;  ">닫기</button>
													
						</div>
						
					</div>
					
				</div>
				
			</div>
			
			
			<!-- 의약품 점수 모달창 (아직 점수를 주지 않은 경우) -->
			<div class="modal modal-info fade" id = "inputMedicineScore" >
			
				<div class="modal-dialog">
				
					<div class="modal-content" >
					
						<div class="modal-header" style="background-color: #4E8DF5 !important;" >
						
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							
							<h4 class="modal-title">의약품점수 등록</h4>
							
						</div>
						
						<div class="modal-body" style="background-color: white !important;">
						
							<!-- 의약품점수 등록 테이블 -->
							<table class="table table-bordered table-striped dataTable" style = "width:570px;">
							
								<tr>
									<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center; background-color:skyblue; width:150px;">의약품명</th>
									<td class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center; width:420px; color:black; font-weight:bold;">${params.MDCIN_PRDUCT_NAME }</td>
								</tr>
								
								<tr>
									<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center; background-color:skyblue; width:150px;">증상</th>
									<td class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center; width:420px; color:black; font-weight:bold;">${params.representSymptms } 외 ${params.representSymptmsCount }건</td>
								</tr>
								
								<tr>
									<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center; background-color:skyblue; width:150px;">용법 및 용량</th>
									<td class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center; width:420px; color:black; font-weight:bold;">${params.USCP_CONTENT }</td>
								</tr>
										
								<tr>
									<th class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center; background-color:skyblue; width:150px;">휴약기간</th>
									<td class="sorting" tabindex="0" rowspan="1" colspan="1" style="text-align:center; width:420px; color:black; font-weight:bold;">${params.WITHDRAWAL_PERIOD }</td>
								</tr>
										
							</table>
							
							<div style = "margin-left: 240px;">
							
								<button type="button" id = "viewPdf" class="btn btn-info" style="background-color: #8FCEFF  !important;  ">PDF확인</button>
							
							</div>
							
												
						</div>
						
						<div class="modal-footer" style="background-color: white !important;">
						
							<div style = "float:left; margin-top:7px;">
							
								<input type="radio" name="scoreRadio" value="1" style = "color:black; font-weight:bold; float:left; margin-left:20px; margin-right:2px;"><p style = "color:black; font-weight:bold; float:left; margin-right:47px;">1점</p>
								<input type="radio" name="scoreRadio" value="2" style = "color:black; font-weight:bold; float:left; margin-right:2px;"><p style = "color:black; font-weight:bold; float:left; margin-right:47px;">2점</p>
								<input type="radio" name="scoreRadio" value="3" style = "color:black; font-weight:bold; float:left; margin-right:2px;"><p style = "color:black; font-weight:bold; float:left; margin-right:47px;">3점</p>
								<input type="radio" name="scoreRadio" value="4" style = "color:black; font-weight:bold; float:left; margin-right:2px;"><p style = "color:black; font-weight:bold; float:left; margin-right:47px;">4점</p>
								<input type="radio" name="scoreRadio" value="5" style = "color:black; font-weight:bold; float:left; margin-right:2px;"><p style = "color:black; font-weight:bold; float:left;">5점</p>
							
							</div>
							
							<div style = "height:34px; float:right;">
							
								<button type="button" id = "insertMedicineScore" class="btn btn-info" style="background-color: #8FCEFF  !important;  ">점수등록</button>
								<button type="button" class="btn btn-info" data-dismiss="modal" style="background-color: #8FCEFF  !important;  ">닫기</button>
							
							</div>
							
														
						</div>
						
					</div>
					
				</div>
				
			</div>
			
			
			<!-- PDF 뷰어 모달창 -->
			<div class="modal modal-info fade" id = "seePdf" >
			
				<div class="modal-dialog">
				
					<div class="modal-content" >
					
						<div class="modal-header" style="background-color: #4E8DF5 !important;" >
						
							<button type="button" class="close" data-dismiss="modal" aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							
							<h4 class="modal-title">처방전 PDF 정보</h4>
							
						</div>
						
						<div class="modal-body" style="background-color: white !important; color:black;">
						
							<p>테스트</p>
							<embed src="/image/${params.prscrptn_name}.pdf" width="100%;" height="1000px;" type="application/pdf">
												
						</div>
						
						<div class="modal-footer" style="background-color: white !important;">
						
							<button type="button" class="btn btn-info" data-dismiss="modal" style="background-color: #8FCEFF  !important;  ">닫기</button>
											
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
	
		$('#medicineTableComplete tbody tr').click(function() {
			
			$('#completeMedicineScore').modal({backdrop: 'static'});
			
			if (currentPage == null) {
				
				currentPage = 1;
				
			}
				
		});
		
		
		$('#medicineTable tbody tr').click(function() {
			
			$('#inputMedicineScore').modal({backdrop: 'static'});
			
			if (currentPage == null) {
				
				currentPage = 1;
				
			}
				
		});
		
		
		$('#insertMedicineScore').click(function() {
		
			var treat_code = '${params.treat_code}';
			
			var prscrptn_code = '${params.prscrptn_code}';
			
			var mdcin_code = '${params.MDCIN_CODE}';
			
			var mdcin_score = $("input[type=radio][name=scoreRadio]:checked").val();
			
			var query = '?mdcin_code=' + mdcin_code + '&treat_code=' + treat_code + '&prscrptn_code=' + prscrptn_code + '&mdcin_score=' + mdcin_score;
			
			if ((mdcin_score != null) && (mdcin_score != '')) {
				
				$.ajax({
					
					url : '${pageContext.request.contextPath}/user/prescriptionManagement/insertMedicineScore.do' + query,
					
					error : function(request, status, error) {
				         
			             alert("code : " + request.status + "\r\nmessage : " + request.reponseText);
			             
					},
					
					success : function(result) {
						
						alert("점수가 성공적으로 등록되었습니다.");
						
					}
					
				});	
				
			} else {
				
				alert("점수를 선택해주세요");
				
			}
			
			
			
// 			$(location).attr('href', '${pageContext.request.contextPath}/user/prescriptionManagement/insertMedicineScore.do' + query);
			
		});
		
		
		$('#viewPdf').click(function() {
			
			$('#seePdf').modal({backdrop: 'static'});
			
			if (currentPage == null) {
				
				currentPage = 1;
				
			}
				
		});
		
		
		// PDF 파일
		pdfInfo = function(value) {
			
		    $('#test').html( '<button type="button" class="btn btn-danger pull-right" onclick="closePdf();">닫기</button><br>'
		    
		    				+'<embed src="/image/'+value+'.pdf" width="100%;" height="1000px;" type="application/pdf">'
		    				
			);
		}
		
		closePdf= function(){
			
			 $('#test').empty();
			 
		}
		
	});
	
</script>