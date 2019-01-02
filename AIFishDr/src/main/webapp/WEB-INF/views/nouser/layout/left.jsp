<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<body>
<div class="content-wrapper">
	<!-- Left side column. contains the logo and sidebar -->
	<aside class="main-sidebar" >
		<!-- sidebar: style can be found in sidebar.less -->
		<section class="sidebar">

			<!-- /.search form -->
			<!-- sidebar menu: : style can be found in sidebar.less -->
			<ul class="sidebar-menu" data-widget="tree">

				<li id="noticeli"><a
					href="${pageContext.request.contextPath }/user/noticeboard/noticeboardList.do">
						<i class="fa fa-info"></i> <span>공지사항</span>
				</a></li>

			</ul>
		</section>
		<!-- /.sidebar -->
	</aside>
</body>
</html>