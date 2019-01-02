<%@ page language="JAVA" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<body>
<div class="content-wrapper">
<!-- Left side column. contains the logo and sidebar -->
  <aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
      <!-- Sidebar user panel -->
      <div class="user-panel">
        <div class="pull-left image">
          <img src="${pageContext.request.contextPath }/dist/img/person_icon.png" class="img-circle" alt="User Image">
        </div>
        <div class="pull-left info">
          <p>관리자</p>
        </div>
      </div>
      
      <!-- /.search form -->
      <!-- sidebar menu: : style can be found in sidebar.less -->
      <ul class="sidebar-menu" data-widget="tree">
        
        <li class="treeview">
          <a href="#">
            <i class="fa fa-newspaper-o"></i> <span>게시판 통합관리</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="${pageContext.request.contextPath }/admin/board/boardList.do"><i class="fa fa-circle-o"></i>게시판 관리</a></li>
            <li><a href="${pageContext.request.contextPath }/admin/board/writeList.do"><i class="fa fa-circle-o"></i>게시글 관리</a></li>
          </ul>
        </li>
        
        
        
        
<!--         이거쓰기 -->
   <li>
     	  <a href="${pageContext.request.contextPath }/admin/member/memberMgr.do">
            <i class="fa fa-user-md"></i> <span>회원관리</span>
          </a>
        </li>
        
        <li class="treeview">
          <a href="#">
            <i class="fa fa-medkit"></i> <span>의약품 데이터 관리</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="${pageContext.request.contextPath }/admin/mdcin/mdcinList.do?role=select"><i class="fa fa-circle-o"></i>의약품 정보</a></li>
            <li><a href="${pageContext.request.contextPath }/admin/withDrawal/withDrawalList.do?role=select"><i class="fa fa-circle-o"></i>휴약기간 관리</a></li>
            <li><a href="${pageContext.request.contextPath }/admin/capacity/capacityList.do?role=select"><i class="fa fa-circle-o"></i>용법/용량 관리</a></li>
            <li><a href="${pageContext.request.contextPath }/admin/mdcin_diss/mdcin_diss_List.do?role=select"><i class="fa fa-circle-o"></i>의약품별 질병 관리</a></li>
          </ul>
        </li>
        <li class="treeview">
          <a href="#">
            <i class="fa fa-medkit"></i> <span>어류 정보 데이터 관리</span>
            <span class="pull-right-container">
              <i class="fa fa-angle-left pull-right"></i>
            </span>
          </a>
          <ul class="treeview-menu">
            <li><a href="${pageContext.request.contextPath }/admin/disease/diseaseList.do?role=select"><i class="fa fa-circle-o"></i>질병정보 관리</a></li>
            <li><a href="${pageContext.request.contextPath }/admin/diseaseFile/diseaseFileList.do"><i class="fa fa-circle-o"></i>질병별 사진관리</a></li>
            <li><a href="${pageContext.request.contextPath }/admin/fish/fishList.do?role=select"><i class="fa fa-circle-o"></i>어류 정보관리</a></li>
            <li><a href="${pageContext.request.contextPath }/admin/symptms/symptmsList.do?role=select"><i class="fa fa-circle-o"></i>증상 정보관리</a></li>
            <li><a href="${pageContext.request.contextPath }/admin/diss_fish/diss_fish_List.do?role=select"><i class="fa fa-circle-o"></i>어류별 질병관리</a></li>
            <li><a href="${pageContext.request.contextPath }/admin/symptms_diss/symptms_diss_List.do?role=select"><i class="fa fa-circle-o"></i>증상별 질병관리</a></li>
          </ul>
        </li>
            <li>
     	  <a href="${pageContext.request.contextPath }/admin/hospital/hospitalList.do">
            <i class="fa fa-fw fa-plus-square"></i> <span>질병정보 관리원</span>
          </a>
        </li>
         <li>
     	  <a href="${pageContext.request.contextPath }/admin/stats/statsList.do">
            <i class="fa fa-fw fa-pie-chart"></i> <span>통계관리</span>
          </a>
        </li>
        
        
        
       
      </ul>
    </section>
    <!-- /.sidebar -->
  </aside>
</body>
</html>  