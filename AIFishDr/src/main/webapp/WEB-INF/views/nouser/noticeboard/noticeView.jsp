<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<body>
 <!-- Main content -->
<section class="content">
	<div class="row">
		<div class="col-md-12" style="width:100%;">
		
		
			<div class="form-group" style="margin-left: 60px; ">
				<label style="float:left; margin-right:5px; margin-top:7px;">제목 :</label>
				<input type="email" class="form-control" id="exampleInputEmail1"
					 style="width: 200px; margin-right: 50px;">
			</div>
			<div class="box" style="margin-left: 60px; width: 1000px;">
				
				<!-- /.box-header -->
				<div class="box-body pad">
					<form>
						<textarea id="note" class="textarea" placeholder="Place some text here"
							style="width: 100%; height: 200px; font-size: 14px; line-height: 18px; border: 1px solid #dddddd; padding: 10px;"></textarea>
					</form>
				</div>
			</div>


			<div class="form-group" style="margin-left: 60px;">
				<input type="image" class="form-control" id="exampleInputPassword1" style="width:30%; height:300px; float:left;">
				<input type="image" class="form-control" id="exampleInputPassword1" style=" width:30%; height:300px; float:left;"> 
					<input type="file" id="exampleInputFile" style="padding-left:10px;">

				<p class="help-block" >10byte이하 파일만 가능.</p>
			</div>




			
			<button type="button"
						style="width: 120px; margin-left:900px; height: 35px; margin-top: 10px; font-size:15px;"
						class="btn btn-info btn-lg" data-toggle="modal"
						data-target="#myModal">목록 </button>
			



		</div>
	</div>
</section>
</div>

<!-- /.content-wrapper -->
</div>
</body>
<script type="text/javascript">
$(function(){
	

     $('#note').summernote({
       height: 300,                 // 썸머노트 높이
        minHeight: null,             // set minimum height of editor
        maxHeight: null,             // set maximum height of editor
        focus: true,        // set focus to editable area after initializing summernote
       
        toolbar: [
                  // [groupName, [list of button]]
                  ['style', ['bold', 'italic', 'underline', 'clear']],
                  ['font', ['strikethrough', 'superscript', 'subscript']],
                  ['fontsize', ['fontsize']],
                  ['color', ['color']],
                  ['para', ['ul', 'ol', 'paragraph']],
                  ['height', ['height']],
                  ['picture']
                  
                ]
   });
})
     </script>
</html>
