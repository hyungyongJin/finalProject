<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>AdminLTE 2 | Editors</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.7 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/bower_components/bootstrap/dist/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/bower_components/font-awesome/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/bower_components/Ionicons/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/dist/css/AdminLTE.min.css">
<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/dist/css/skins/_all-skins.min.css">
<!-- bootstrap wysihtml5 - text editor -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

<!-- Google Font -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
	
<!-- jQuery 3 -->
<script src="${pageContext.request.contextPath }/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="${pageContext.request.contextPath }/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="${pageContext.request.contextPath }/bower_components/fastclick/lib/fastclick.js"></script>
<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath }/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="${pageContext.request.contextPath }/dist/js/demo.js"></script>
<!-- CK Editor -->
<script src="${pageContext.request.contextPath }/bower_components/ckeditor/ckeditor.js"></script>
<!-- Bootstrap WYSIHTML5 -->
<script src="${pageContext.request.contextPath }/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
<script>
  $(function () {
    // Replace the <textarea id="editor1"> with a CKEditor
    // instance, using default configuration.
    CKEDITOR.replace('editor1')
    //bootstrap WYSIHTML5 - text editor
    $('.textarea').wysihtml5()
  })
</script>

</head>

<body class="hold-transition skin-blue sidebar-mini">

	<section class="content">
	
	<!-- Direct Chat -->
	<div class="row">
		<div class="col-md-3">
			<!-- DIRECT CHAT PRIMARY -->
			<div class="box box-primary direct-chat direct-chat-primary">
				<div class="box-header with-border">
					<h3 class="box-title">Direct Chat</h3>

					<div class="box-tools pull-right">
						<span data-toggle="tooltip" title="3 New Messages"
							class="badge bg-light-blue">3</span>
						<button type="button" class="btn btn-box-tool"
							data-widget="collapse">
							<i class="fa fa-minus"></i>
						</button>
						<button type="button" class="btn btn-box-tool"
							data-toggle="tooltip" title="Contacts"
							data-widget="chat-pane-toggle">
							<i class="fa fa-comments"></i>
						</button>
						<button type="button" class="btn btn-box-tool"
							data-widget="remove">
							<i class="fa fa-times"></i>
						</button>
					</div>
				</div>
				<!-- /.box-header -->
				<div class="box-body">
					<!-- Conversations are loaded here -->
					<div class="direct-chat-messages">
						<!-- Message. Default to the left -->
						<div class="direct-chat-msg">
							<div class="direct-chat-info clearfix">
								<span class="direct-chat-name pull-left">Alexander Pierce</span>
								<span class="direct-chat-timestamp pull-right">23 Jan
									2:00 pm</span>
							</div>
							<!-- /.direct-chat-info -->
							<img class="direct-chat-img" src="${pageContext.request.contextPath }/dist/img/user1-128x128.jpg"
								alt="Message User Image">
							<!-- /.direct-chat-img -->
							<div class="direct-chat-text">Is this template really for
								free? That's unbelievable!</div>
							<!-- /.direct-chat-text -->
						</div>
						<!-- /.direct-chat-msg -->

						<!-- Message to the right -->
						<div class="direct-chat-msg right">
							<div class="direct-chat-info clearfix">
								<span class="direct-chat-name pull-right">Sarah Bullock</span> <span
									class="direct-chat-timestamp pull-left">23 Jan 2:05 pm</span>
							</div>
							<!-- /.direct-chat-info -->
							<img class="direct-chat-img" src="${pageContext.request.contextPath }/dist/img/user3-128x128.jpg"
								alt="Message User Image">
							<!-- /.direct-chat-img -->
							<div class="direct-chat-text">You better believe it!</div>
							<!-- /.direct-chat-text -->
						</div>
						<!-- /.direct-chat-msg -->
					</div>
					<!--/.direct-chat-messages-->

					<!-- Contacts are loaded here -->
					<div class="direct-chat-contacts">
						<ul class="contacts-list">
							<li><a href="#"> <img class="contacts-list-img"
									src="${pageContext.request.contextPath }/dist/img/user1-128x128.jpg" alt="User Image">

									<div class="contacts-list-info">
										<span class="contacts-list-name"> Count Dracula <small
											class="contacts-list-date pull-right">2/28/2015</small>
										</span> <span class="contacts-list-msg">How have you been? I
											was...</span>
									</div> <!-- /.contacts-list-info -->
							</a></li>
							<!-- End Contact Item -->
						</ul>
						<!-- /.contatcts-list -->
					</div>
					<!-- /.direct-chat-pane -->
				</div>
				<!-- /.box-body -->
				<div class="box-footer">
					<form action="#" method="post">
						<div class="input-group">
							<input type="text" name="message" placeholder="Type Message ..."
								class="form-control"> <span class="input-group-btn">
								<button type="submit" class="btn btn-primary btn-flat">Send</button>
							</span>
						</div>
					</form>
				</div>
				<!-- /.box-footer-->
			</div>
			<!--/.direct-chat -->
		</div>
		<!-- /.col -->
	</div>
	
	</section>
	
</body>

</html>