<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
	$(function() {
		if (typeof webkitSpeechRecognition !== 'function') {
			alert("크롬에서만 동작 합니다.");
		}

		/**
		 * 문자를 음성으로 읽어 줍니다.
		 * 지원: 크롬, 사파리, 오페라, 엣지
		 */
		function textToSpeech(text) {
				var msg = new SpeechSynthesisUtterance(text);
				console.log('msg',msg);
				msg.voice = speechSynthesis.getVoices().filter(function(voice) { return voice.name == 'Whisper'; })[0];
				speechSynthesis.speak(msg);
		}
		/**
		 * 초기 바인딩
		 */
		$('.sounding').click(function() {
			mdcin_effect = $(this).val();
			textToSpeech(mdcin_effect);
		});

		$('.goModal')
				.click(
						function() {
							var mdcin_code = $(this).val();
							$
									.ajax({
										url : '${pageContext.request.contextPath}/user/mdcin/mdcinView.do?code='
												+ mdcin_code,
										success : function(data) {
											$('#mdcin_entrps_name')
													.val(
															data.mdcinInfo.mdcin_entrps_name);
											$('#mdcin_prduct_name')
													.val(
															data.mdcinInfo.mdcin_prduct_name);
											$('#mdcin_atpn').val(
													data.mdcinInfo.mdcin_atpn);
											$('#mdcin_pack').val(
													data.mdcinInfo.mdcin_pack);
											$('#mdcin_efcy_effect')
													.val(
															data.mdcinInfo.mdcin_efcy_effect);
											$('#mdcin_material')
													.val(
															data.mdcinInfo.mdcin_material);
											$('#ctgry_name')
													.val(
															data.mdcinCateInfo.ctgry_name);
										},
										error : function(res) {
											alert(res.status);
										}

									});

							$('#myModal').modal();
						});

	});
</script>
<style>
td, th{
	text-align:center;
}
</style>
<div class="content-wrapper" style="margin-left: 10px;">
	<section class="content">
	<div class="row">
		<div class="col-md-12">
			<form
				action="${pageContext.request.contextPath }/user/mdcin/mdcinList.do"
				method="get">
				<div class="form-group" style="float: left; margin-left: 50px; width: 200px;">
					<select name="search_L_keycode"
						class="form-control select2 select2-hidden-accessible"
						style="width: 100%;" tabindex="-1" aria-hidden="true">
						<option selected="selected">대분류</option>
						<c:forEach items="${mdcincate }" var="mdcincate">
							<option value="${mdcincate.ctgry_name}">${mdcincate.ctgry_name}</option>
						</c:forEach>
					</select>

				</div>
				<div class="form-group" style="float: left; margin-left: 20px; width: 300px;">
					<select name="search_M_keycode"
						class="form-control select2 select2-hidden-accessible"
						style="width: 100%;" tabindex="-1" aria-hidden="true">
						<option selected="selected">중분류</option>
						<option value="업체명">업체명</option>
						<option value="제품명">제품명</option>
					</select>

				</div>

				<div class="form-group" style="width: 1500px;">
					<input  style="width: 500px; float: left; margin-left: 20px;" type="text" class="form-control" name="search_keyword"
						placeholder="검색어를  입력하세요.." />
					<button  style="margin-left: 20px; font-size: 15px; height:36px;" type="submit" class="btn btn-info btn-lg">검색</button>
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
							<div class="col-sm-6"></div>
							<div class="col-sm-6">
								<div id="example1_filter" class="dataTables_filter"></div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-12">
								<table id="example1"
									class="table table-bordered table-striped dataTable"
									role="grid" aria-describedby="example1_info">
									<thead>
										<tr role="row" style="width:100%; ">
											<th class="sorting" tabindex="0" aria-controls="example1"
												rowspan="1" colspan="1"
												aria-label="Browser: activate to sort column ascending"
												style="width: 5%; ">번호</th>
											<th class="sorting" tabindex="0" aria-controls="example1"
												rowspan="1" colspan="1"
												aria-label="Platform(s): activate to sort column ascending"
												style="width: 20%;">업체명</th>
											<th class="sorting" tabindex="0" aria-controls="example1"
												rowspan="1" colspan="1"
												aria-label="Engine version: activate to sort column ascending"
												style="width: 45%;">제품명</th>
											<th class="sorting" tabindex="0" aria-controls="example1"
												rowspan="1" colspan="1"
												aria-label="Platform(s): activate to sort column ascending"
												style="width: 10%;">효능 및 효과</th>
											<th class="sorting" tabindex="0" aria-controls="example1"
												rowspan="1" colspan="1"
												aria-label="Platform(s): activate to sort column ascending"
												style="width: 10%;">점수</th>
											<th class="sorting" tabindex="0" aria-controls="example1"
												rowspan="1" colspan="1"
												aria-label="CSS grade: activate to sort column ascending"
												style="width: 10%;">상세</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${mdcinList }" var="mdcinList" varStatus="status">
											<tr role="row" class="odd">
												<td>${mdcinList.rnum }</td>
												<td>${mdcinList.mdcin_entrps_name }</td>
												<td>${mdcinList.mdcin_prduct_name }</td>
												<td>
													<button class="sounding" type="button"
														value="${mdcinList.mdcin_efcy_effect }">
														<img class="sounding"
															src="${pageContext.request.contextPath }/dist/img/sound.png" />
													</button>
												</td>
												
												<!-- 의약품점수 -->
												<c:if test="${medicineScoreList[status.index] eq '0' }">
												
												<td>점수미등록</td>
												
												</c:if>
												
												<c:if test="${!(medicineScoreList[status.index] eq '0') }">
												
												<td>${medicineScoreList[status.index]}&nbsp;/&nbsp; 5.0</td>
												
												</c:if>
												
												<td>
													<button value="${mdcinList.mdcin_code }" type="button"
														 class="goModal btn btn-primary btn-sm">
														<span class="glyphicon glyphicon-search"></span>
													</button>
												</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>

						</div>
						<div class="row">
							<div class="col-sm-5"></div>
							<div class="col-sm-7">${paging }</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /.box-body -->
		</div>
	</div>
	</section>
	<!-- 의약품 상세모달 -->
	<div class="modal col-md-7" id="myModal"
		style="margin-top: 55px; background: none; margin-left: 700px; width: 30%; height: 1000px;">
		<!-- Horizontal Form -->
		<div class="box box-info" style="width: 100%; height:85%;"> 
			<div class="box-header with-border">
				<h3 class="box-title"
					style=" margin-left: 80px; font-size: 25px;">의약품상세
					정보</h3>
			</div>
			<!-- /.box-header -->
			<!-- form start -->
			<form class="form-horizontal" style="margin-left:40px; width:80%;">
				<div class="box-body">
					<div class="form-group" style="margin-bottom: 20px;">
						<label for="inputEmail3" style="float: left; margin-right: 10px;">업체명:</label>
						<input type="text" class="form-control" id="mdcin_entrps_name"
							placeholder="(업체명)" disabled="true">
					</div>
					<div class="form-group" >
						<label for="inputEmail3" style="float: left; margin-right: 10px;">제품명:</label>
						<input type="text" class="form-control" id="mdcin_prduct_name"
							placeholder="(제품명)" disabled="true">
					</div>
					<div class="form-group" >
						<label for="inputEmail3" style="float: left; margin-right: 10px;">주의사항:</label>

						<div class="form-group">
							<textarea class="form-control" rows="3"
								style="margin-left:13px; resize: none; width: 94%;" placeholder="(주의사항)"
								id="mdcin_atpn" disabled="true"></textarea>
						</div>
					</div>
					<div class="form-group" >
						<label for="inputEmail3" style="float: left; margin-right: 10px;">포장단위:</label>
						<br>
						<br>
						<div class="form-group">
							<textarea class="form-control" rows="1"
								style="margin-left:13px; resize: none; width: 94%;" placeholder="(포장단위)"
								id="mdcin_pack" disabled="true"></textarea>
						</div>
					</div>
					<div class="form-group" >
						<label for="inputPassword3" style="float: left;">효능 및 효과 :</label>
						<div class="form-group">
							<textarea class="form-control" rows="3"
								style="margin-left:13px; resize: none; width: 94%;" placeholder="(효능 및 효과)"
								id="mdcin_efcy_effect" disabled="true"></textarea>
						</div>
					</div>
					<div class="form-group" >
						<label for="inputPassword3" style="float: left;">원료 및 성분분량
							:</label>
						<div class="form-group">
							<textarea class="form-control" rows="3"
								style="margin-left:13px; resize: none; width: 94%;" placeholder="(원료 및 성분분량)"
								id="mdcin_material" disabled="true"></textarea>
						</div>
					</div>
					<div class="form-group" >
						<label for="inputPassword3"
							style="float: left; margin-right: 10px;">카테고리 :</label> <input
							type="text" class="form-control" id="ctgry_name"
							placeholder="(카테고리)" disabled="true">
					</div>

				</div>
				<!-- /.box-body -->
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
				</div>
				<!-- /.box-footer -->
			</form>
		</div>
	</div>
	<!-- /.box -->