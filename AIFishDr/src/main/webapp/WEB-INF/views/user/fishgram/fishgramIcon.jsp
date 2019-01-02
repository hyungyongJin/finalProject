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
	
	<div class="row">
		<div class="col-md-3 col-sm-6 col-xs-12">
			<div class="info-box">
				<span class="info-box-icon bg-aqua"><i
					class="fa fa-envelope-o"></i></span>

				<div class="info-box-content">
					<span class="info-box-text">Messages</span> <span
						class="info-box-number">1,410</span>
				</div>
				<!-- /.info-box-content -->
			</div>
			<!-- /.info-box -->
		</div>
		<!-- /.col -->
		<div class="col-md-3 col-sm-6 col-xs-12">
			<div class="info-box">
				<span class="info-box-icon bg-green"><i class="fa fa-flag-o"></i></span>

				<div class="info-box-content">
					<span class="info-box-text">Bookmarks</span> <span
						class="info-box-number">410</span>
				</div>
				<!-- /.info-box-content -->
			</div>
			<!-- /.info-box -->
		</div>
		<!-- /.col -->
		<div class="col-md-3 col-sm-6 col-xs-12">
			<div class="info-box">
				<span class="info-box-icon bg-yellow"><i
					class="fa fa-files-o"></i></span>

				<div class="info-box-content">
					<span class="info-box-text">Uploads</span> <span
						class="info-box-number">13,648</span>
				</div>
				<!-- /.info-box-content -->
			</div>
			<!-- /.info-box -->
		</div>
		<!-- /.col -->
		<div class="col-md-3 col-sm-6 col-xs-12">
			<div class="info-box">
				<span class="info-box-icon bg-red"><i class="fa fa-star-o"></i></span>

				<div class="info-box-content">
					<span class="info-box-text">Likes</span> <span
						class="info-box-number">93,139</span>
				</div>
				<!-- /.info-box-content -->
			</div>
			<!-- /.info-box -->
		</div>
		<!-- /.col -->
	</div>
	<!-- /.row --> <!-- =========================================================== -->

	<div class="row">
		<div class="col-md-3 col-sm-6 col-xs-12">
			<div class="info-box bg-aqua">
				<span class="info-box-icon"><i class="fa fa-bookmark-o"></i></span>

				<div class="info-box-content">
					<span class="info-box-text">Bookmarks</span> <span
						class="info-box-number">41,410</span>

					<div class="progress">
						<div class="progress-bar" style="width: 70%"></div>
					</div>
					<span class="progress-description"> 70% Increase in 30 Days
					</span>
				</div>
				<!-- /.info-box-content -->
			</div>
			<!-- /.info-box -->
		</div>
		<!-- /.col -->
		<div class="col-md-3 col-sm-6 col-xs-12">
			<div class="info-box bg-green">
				<span class="info-box-icon"><i class="fa fa-thumbs-o-up"></i></span>

				<div class="info-box-content">
					<span class="info-box-text">Likes</span> <span
						class="info-box-number">41,410</span>

					<div class="progress">
						<div class="progress-bar" style="width: 70%"></div>
					</div>
					<span class="progress-description"> 70% Increase in 30 Days
					</span>
				</div>
				<!-- /.info-box-content -->
			</div>
			<!-- /.info-box -->
		</div>
		<!-- /.col -->
		<div class="col-md-3 col-sm-6 col-xs-12">
			<div class="info-box bg-yellow">
				<span class="info-box-icon"><i class="fa fa-calendar"></i></span>

				<div class="info-box-content">
					<span class="info-box-text">Events</span> <span
						class="info-box-number">41,410</span>

					<div class="progress">
						<div class="progress-bar" style="width: 70%"></div>
					</div>
					<span class="progress-description"> 70% Increase in 30 Days
					</span>
				</div>
				<!-- /.info-box-content -->
			</div>
			<!-- /.info-box -->
		</div>
		<!-- /.col -->
		<div class="col-md-3 col-sm-6 col-xs-12">
			<div class="info-box bg-red">
				<span class="info-box-icon"><i class="fa fa-comments-o"></i></span>

				<div class="info-box-content">
					<span class="info-box-text">Comments</span> <span
						class="info-box-number">41,410</span>

					<div class="progress">
						<div class="progress-bar" style="width: 70%"></div>
					</div>
					<span class="progress-description"> 70% Increase in 30 Days
					</span>
				</div>
				<!-- /.info-box-content -->
			</div>
			<!-- /.info-box -->
		</div>
		<!-- /.col -->
	</div>
	<!-- /.row --> <!-- =========================================================== -->

	<!-- Small boxes (Stat box) -->
	<div class="row">
		<div class="col-lg-3 col-xs-6">
			<!-- small box -->
			<div class="small-box bg-aqua">
				<div class="inner">
					<h3>150</h3>

					<p>New Orders</p>
				</div>
				<div class="icon">
					<i class="fa fa-shopping-cart"></i>
				</div>
				<a href="#" class="small-box-footer"> More info <i
					class="fa fa-arrow-circle-right"></i>
				</a>
			</div>
		</div>
		<!-- ./col -->
		<div class="col-lg-3 col-xs-6">
			<!-- small box -->
			<div class="small-box bg-green">
				<div class="inner">
					<h3>
						53<sup style="font-size: 20px">%</sup>
					</h3>

					<p>Bounce Rate</p>
				</div>
				<div class="icon">
					<i class="ion ion-stats-bars"></i>
				</div>
				<a href="#" class="small-box-footer"> More info <i
					class="fa fa-arrow-circle-right"></i>
				</a>
			</div>
		</div>
		<!-- ./col -->
		<div class="col-lg-3 col-xs-6">
			<!-- small box -->
			<div class="small-box bg-yellow">
				<div class="inner">
					<h3>44</h3>

					<p>User Registrations</p>
				</div>
				<div class="icon">
					<i class="ion ion-person-add"></i>
				</div>
				<a href="#" class="small-box-footer"> More info <i
					class="fa fa-arrow-circle-right"></i>
				</a>
			</div>
		</div>
		<!-- ./col -->
		<div class="col-lg-3 col-xs-6">
			<!-- small box -->
			<div class="small-box bg-red">
				<div class="inner">
					<h3>65</h3>

					<p>Unique Visitors</p>
				</div>
				<div class="icon">
					<i class="ion ion-pie-graph"></i>
				</div>
				<a href="#" class="small-box-footer"> More info <i
					class="fa fa-arrow-circle-right"></i>
				</a>
			</div>
		</div>
		<!-- ./col -->
	</div>
	<!-- /.row --> <!-- =========================================================== -->

	<div class="row">
		<div class="col-md-3">
			<div class="box box-default collapsed-box">
				<div class="box-header with-border">
					<h3 class="box-title">Expandable</h3>

					<div class="box-tools pull-right">
						<button type="button" class="btn btn-box-tool"
							data-widget="collapse">
							<i class="fa fa-plus"></i>
						</button>
					</div>
					<!-- /.box-tools -->
				</div>
				<!-- /.box-header -->
				<div class="box-body">The body of the box</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->
		</div>
		<!-- /.col -->
		<div class="col-md-3">
			<div class="box box-success">
				<div class="box-header with-border">
					<h3 class="box-title">Removable</h3>

					<div class="box-tools pull-right">
						<button type="button" class="btn btn-box-tool"
							data-widget="remove">
							<i class="fa fa-times"></i>
						</button>
					</div>
					<!-- /.box-tools -->
				</div>
				<!-- /.box-header -->
				<div class="box-body">The body of the box</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->
		</div>
		<!-- /.col -->
		<div class="col-md-3">
			<div class="box box-warning">
				<div class="box-header with-border">
					<h3 class="box-title">Collapsable</h3>

					<div class="box-tools pull-right">
						<button type="button" class="btn btn-box-tool"
							data-widget="collapse">
							<i class="fa fa-minus"></i>
						</button>
					</div>
					<!-- /.box-tools -->
				</div>
				<!-- /.box-header -->
				<div class="box-body">The body of the box</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->
		</div>
		<!-- /.col -->
		<div class="col-md-3">
			<div class="box box-danger">
				<div class="box-header">
					<h3 class="box-title">Loading state</h3>
				</div>
				<div class="box-body">The body of the box</div>
				<!-- /.box-body -->
				<!-- Loading (remove the following to stop the loading)-->
				<div class="overlay">
					<i class="fa fa-refresh fa-spin"></i>
				</div>
				<!-- end loading -->
			</div>
			<!-- /.box -->
		</div>
		<!-- /.col -->
	</div>
	<!-- /.row --> <!-- =========================================================== -->

	<div class="row">
		<div class="col-md-3">
			<div class="box box-default collapsed-box box-solid">
				<div class="box-header with-border">
					<h3 class="box-title">Expandable</h3>

					<div class="box-tools pull-right">
						<button type="button" class="btn btn-box-tool"
							data-widget="collapse">
							<i class="fa fa-plus"></i>
						</button>
					</div>
					<!-- /.box-tools -->
				</div>
				<!-- /.box-header -->
				<div class="box-body">The body of the box</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->
		</div>
		<!-- /.col -->
		<div class="col-md-3">
			<div class="box box-success box-solid">
				<div class="box-header with-border">
					<h3 class="box-title">Removable</h3>

					<div class="box-tools pull-right">
						<button type="button" class="btn btn-box-tool"
							data-widget="remove">
							<i class="fa fa-times"></i>
						</button>
					</div>
					<!-- /.box-tools -->
				</div>
				<!-- /.box-header -->
				<div class="box-body">The body of the box</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->
		</div>
		<!-- /.col -->
		<div class="col-md-3">
			<div class="box box-warning box-solid">
				<div class="box-header with-border">
					<h3 class="box-title">Collapsable</h3>

					<div class="box-tools pull-right">
						<button type="button" class="btn btn-box-tool"
							data-widget="collapse">
							<i class="fa fa-minus"></i>
						</button>
					</div>
					<!-- /.box-tools -->
				</div>
				<!-- /.box-header -->
				<div class="box-body">The body of the box</div>
				<!-- /.box-body -->
			</div>
			<!-- /.box -->
		</div>
		<!-- /.col -->
		<div class="col-md-3">
			<div class="box box-danger box-solid">
				<div class="box-header">
					<h3 class="box-title">Loading state</h3>
				</div>
				<div class="box-body">The body of the box</div>
				<!-- /.box-body -->
				<!-- Loading (remove the following to stop the loading)-->
				<div class="overlay">
					<i class="fa fa-refresh fa-spin"></i>
				</div>
				<!-- end loading -->
			</div>
			<!-- /.box -->
		</div>
		<!-- /.col -->
	</div>
	<!-- /.row --> <!-- =========================================================== -->
	
	</section>
	
</body>

</html>