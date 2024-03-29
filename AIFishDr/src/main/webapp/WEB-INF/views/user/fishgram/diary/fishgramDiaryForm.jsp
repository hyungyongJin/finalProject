<%--==============================================================
 * jsp 개요 : 피쉬그램 글 쓰기 폼
 * @author : 심재형
 * @since : 2018. 11. 20.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일             수정자     수정내용
 *    -------------      ------     -------------------
 *    2018. 11. 20.      심재형     최초작성
 * Copyright (c) 2018 AI Fish Dr. All right reserved
 * </pre>
===============================================================--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>

<html>

	<meta charset="UTF-8">
	
	<style>
	
		input{background-color:#E8F5FF;border:0}
		 
	</style>

<body>

	<div class="content-wrapper" style="margin-left: 10px;">

		<section class="content">
		
			<div class="row">
			
				<div class="col-md-12" style = "float:left; width:100%; height:822px; overflow-x:hidden; overflox-y:hidden;">

				<!-- 위 html 지우지 말 것  -->

					<div class="box box-solid box-info" style = "height:802px;">
					
						<div class="box-header"></div>
						
						<div class = "box-body">

							<form id="insertForm" action="#" method="post" enctype="multipart/form-data" style = "height:730px;">
								
								<label class="text-green">제목 : </label>
								
								&nbsp;&nbsp;&nbsp;&nbsp;
								
								<input size="100" type="text" name="bo_title" value="">
								
								<br>
								<br>
								
								<input type="hidden" name="bo_writer" value="${LOGIN_MEMBER.mem_id }">
								
								<textarea id="note" name="bo_content" style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>

								<button id="return" type="button" style="width: 140px;" class="btn btn-info btn-sm pull-right">목록</button>
								
								&nbsp;&nbsp;
								
								<button id="insert" type="submit" style="width: 140px;" class="btn btn-info btn-sm pull-right">등록</button>
								
							</form>
							
						</div>
						
					</div>

				</div>
				
			</div>

		</section>
		
	<!-- 아래 html 건들지 말것 -->
	
	</div>
	
</body>

<script type="text/javascript">

	$(function() {
		
		$('#note')
		
			.summernote(
							{
								height : 600, // 썸머노트 높이
								minHeight : null, // set minimum height of editor
								maxHeight : null, // set maximum height of editor
								focus : false, // set focus to editable area after initializing summernote
	
								toolbar : [				
											['style',		[ 'bold', 'italic', 'underline', 'clear' ] ],
											['font',		[ 'strikethrough', 'superscript','subscript' ] ],
											[ 'fontsize', 	[ 'fontsize' ] ],
											[ 'color', 		[ 'color' ] ],
											[ 'para',		[ 'ul', 'ol', 'paragraph' ] ],
											[ 'height', 	[ 'height' ] ], [ 'picture' ]
	
										  ]
							}
						);

		$('#return').click(function() {
			
			$(location).attr('href', '${pageContext.request.contextPath}/user/fishgram/fishgramMeMain.do');
			
		});
		
		
		$('#insert').click(function() {
			
			if ( ($('input[name=bo_title]').val() == '') || ($('input[name=bo_title]').val() == null) ) {
				
				alert("제목을 입력해야 글 등록이 가능합니다.");
				
			}
			
			if ( ($('textarea[name=bo_content]').val() == '') || ($('textarea[name=bo_content]').val() == null) ) {
				
				alert("내용을 입력해야 글 등록이 가능합니다.");
				
			}
			
			if ( ($('input[name=bo_title]').val() != '') && ($('input[name=bo_title]').val() != null) && ($('textarea[name=bo_content]').val() != '') && ($('textarea[name=bo_content]').val() != null) ) {
				
				$('#insertForm').attr('action','${pageContext.request.contextPath }/user/fishgram/diary/insertFishgramDiary.do');
				//$(location).attr('href', '${pageContext.request.contextPath }/user/fishgram/diary/insertFishgramDiary.do');
				$('#insertForm').submit();
				
			}
			
		});

	});
	
</script>

</html>  
  