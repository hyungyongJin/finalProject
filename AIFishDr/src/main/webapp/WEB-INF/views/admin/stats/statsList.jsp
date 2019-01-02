<%--==============================================================
 * jsp 개요 : 
 * @author : 
 * @since : 2018. 11. 12.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일                          수정자                       수정내용
 *    -------      -------     -------------------
 *    2018. 11. 12.        진형용                      최초작성
 * Copyright (c) 2018 AI Fish Dr. All right reserved
 * </pre>
===============================================================--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>통계관리</title>
<style type="text/css">
.row{margin: 10px 100px 10px 100px;}
th,td{text-align: center;}
</style>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
</head>
<body>


	<br>
      <div class="box">
      <section class="content">
      <div class="row">
      	<div class="col-md-12">
      	
      	<div class="col-md-3 col-sm-6 col-xs-12">
          <div class="info-box"  style="background-color: #EFFBEF;">
            <span class="info-box-icon bg-aqua"><span class="glyphicon glyphicon-user"></span></span>

            <div class="info-box-content">
              <span class="info-box-text">가입한 회원 수</span>
              <span class="info-box-number">${memCount }명</span>
            </div>
          </div>
        </div>
        
      	<div class="col-md-3 col-sm-6 col-xs-12">
          <div class="info-box"  style="background-color: #EFFBEF;">
            <span class="info-box-icon bg-green"><span class="glyphicon glyphicon-leaf"></span></span>

            <div class="info-box-content">
              <span class="info-box-text">등록된 의약품 수량</span>
              <span class="info-box-number">${mdcineCnt}</span>
            </div>
          </div>
        </div>
      	
        
		<div class="col-md-3 col-sm-6 col-xs-12">
          <div class="info-box" style="background-color: #EFFBEF;">
            <span class="info-box-icon bg-yellow"><i class="fa fa-files-o"></i></span>

            <div class="info-box-content" >
              <span class="info-box-text">게시판에 등록된 총 파일 크기</span>
              <span class="info-box-number">${storage }</span>
            </div>
          </div>
        </div>
      
 		<div class="col-md-3 col-sm-6 col-xs-12">
          <div class="info-box"  style="background-color: #EFFBEF;">
            <span class="info-box-icon bg-red"><span class="glyphicon glyphicon-file"></span></span>

            <div class="info-box-content">
              <span class="info-box-text">AI를 통해 발행된 처방전 수</span>
              <span class="info-box-number">${prsCnt }건</span>
            </div>
          </div>
        </div>
      	</div>
      	
     	 <div class="col-md-6">
     	 	<div style="min-height: 250px;">
      		<table class="table">
      			<tr style="background-color: lightblue;">
      				<th colspan="5">의약품 검색 상위 10</th>
      			</tr>
      			<tr style="background-color: lightblue;">
      				<th style="width: 100px;">약품회사</th>
      				<th style="width: 200px;">약품명</th>
      			</tr>
      			<tbody>
      				<c:forEach items="${mdcinList }" var="list">
      				<tr>
      					<td>${list.mdcin_entrps_name }</td>
      					<td>${list.mdcin_prduct_name }</td>
      				</tr>
      				</c:forEach>
      			</tbody>
      		</table>
      		</div>
      		 <div class="box box-info">
            <div class="box-header with-border">
              <h3 class="box-title">주간 회원 증가 추세</h3>

              <div class="box-tools pull-right">
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
              </div>
            </div>
            <div class="box-body">
              <div class="chart">
                <canvas id="lineChart" style="height: 250px; width: 386px;" width="386" height="250"></canvas>
              </div>
            </div>
            <!-- /.box-body -->
          </div>
          <!-- /.box -->
          <!-- BAR CHART -->
          <div class="box box-success">
            <div class="box-header with-border">
              <h3 class="box-title">주간 사이트 방문자 수</h3>

              <div class="box-tools">
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
              </div>
            </div>
            <div class="box-body">
              <div class="chart">
                <canvas id="barChart" style="height: 230px; width: 386px;" width="386" height="230"></canvas>
              </div>
            </div>
          </div>
      		
      		
      		
      	</div>
      	<div class="col-md-6" >
     	 	<div style="min-height: 250px;">
      		<table class="table">
      			<tr style="background-color: lightblue;">
      				<th colspan="5">추천글 상위 10</th>
      			</tr>
      			<tr style="background-color: lightblue;">
      				<th style="width: 100px;">게시판</th>
      				<th style="width: 200px;">제목</th>
      				<th style="width: 60px;">작성자</th>
      				<th style="width: 100px;">작성일</th>
      				<th style="width: 70px;">추천횟수</th>
      			</tr>
      			<tbody>
      				<c:forEach items="${famousList }" var="list">
      				<tr>
      					<td>${list.BOARD_NAME }</td>
      					<td>${list.BO_TITLE }</td>
      					<td>${list.MEM_NICKNAME }</td>
      					<td>${list.BO_REG_DATE }</td>
      					<td>${list.BO_GOOD_HIT }</td>
      				</tr>
      				</c:forEach>
      			</tbody>
      		</table>
      		</div>
      	</div>
        <div class="col-md-6">
          
                
     <div class="box box-danger">
            <div class="box-header with-border">
              <h3 class="box-title">각 게시판 작성글 수</h3>

              <div class="box-tools pull-right">
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
              </div>
            </div>
            <div class="box-body chart-responsive">
              <div class="chart" id="writeRatio" style="height: 255px;"></div>
            </div>
       </div>
       
     <div class="box box-danger">
            <div class="box-header with-border">
              <h3 class="box-title">AI처방된 어류비율</h3>

              <div class="box-tools pull-right">
                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                </button>
                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
              </div>
            </div>
            <div class="box-body chart-responsive">
           	 <div id="fishRatio" style="width:300; height: 255px;"></div>
            </div>
       </div>
          <!-- /.box -->

	                <canvas id="areaChart"  style="height: 250px; width: 386px;" width="386" height="250"></canvas>
       
        <!-- /.col (LEFT) -->
        <div class="col-md-6" >
          <!-- LINE CHART -->
         
          <!-- /.box -->
        </div>
        <!-- /.col (RIGHT) -->
      </div>
      <!-- /.row -->
      

      
      
      
      
      
      
      
      </div>
    </section>
      </div>
    
    
</body>
<script type="text/javascript">
function data(boardName , writeCount){
	this.label = boardName;
	this.value = writeCount;
	return this.boardName +","+this.writeCount;
}

$(function () {
   $('#areaChart').hide();
	
    var areaChartCanvas = $('#areaChart').get(0).getContext('2d')
    var areaChart       = new Chart(areaChartCanvas);

    var date = new Date();
    var day = date.getDate();
    var month = date.getMonth()+1;
    
    var areaChartData = {
      labels  : [ month+"/"+(day-6), month+"/"+(day-5), month+"/"+(day-4), month+"/"+(day-3), month+"/"+(day-2), month+"/"+(day-1), month+"/"+day],
      datasets: [
        {
          label               : '',
          fillColor           : '#4d88b6',
          strokeColor         : '#4d88b6',
          pointColor          : '#008fff',
          pointStrokeColor    : '#736f9f',
          pointHighlightFill  : '#fff',
          pointHighlightStroke: 'rgba(220,220,220,1)',
          data                : ['${count.DAY6}', '${count.DAY5}', '${count.DAY4}', '${count.DAY3}', '${count.DAY2}', '${count.DAY1}', '${count.TODAY}']
        }]
      
    };

    var areaChartOptions = {
      //Boolean - If we should show the scale at all
      showScale               : true,
      //Boolean - Whether grid lines are shown across the chart
      scaleShowGridLines      : false,
      //String - Colour of the grid lines
      scaleGridLineColor      : '#95aacc',
      //Number - Width of the grid lines
      scaleGridLineWidth      : 1,
      //Boolean - Whether to show horizontal lines (except X axis)
      scaleShowHorizontalLines: true,
      //Boolean - Whether to show vertical lines (except Y axis)
      scaleShowVerticalLines  : true,
      //Boolean - Whether the line is curved between points
      bezierCurve             : true,
      //Number - Tension of the bezier curve between points
      bezierCurveTension      : 0.3,
      //Boolean - Whether to show a dot for each point
      pointDot                : false,
      //Number - Radius of each point dot in pixels
      pointDotRadius          : 4,
      //Number - Pixel width of point dot stroke
      pointDotStrokeWidth     : 1,
      //Number - amount extra to add to the radius to cater for hit detection outside the drawn point
      pointHitDetectionRadius : 20,
      //Boolean - Whether to show a stroke for datasets
      datasetStroke           : true,
      //Number - Pixel width of dataset stroke
      datasetStrokeWidth      : 2,
      //Boolean - Whether to fill the dataset with a color
      datasetFill             : true,
      //String - A legend template
      legendTemplate          : 1,
      //Boolean - whether to maintain the starting aspect ratio or not when responsive, if set to false, will take up entire container
      maintainAspectRatio     : true,
      //Boolean - whether to make the chart responsive to window resizing
      responsive              : true
    }

    //Create the line chart
    areaChart.Line(areaChartData)

    



	 var date1 = new Date();
     date1.setDate(date1.getDate()-6);
	 var date2 = new Date();
	 date2.setDate(date2.getDate()-14);
	 var week1 = (date2.getMonth()+1)+"/"+date2.getDate();
	 var date3 = new Date();
	 date3.setDate(date3.getDate()-21);
	 var week2= (date3.getMonth()+1)+"/"+date3.getDate();
	 var date4 = new Date();
	 date4.setDate(date4.getDate()-28);
	 var week3 =(date4.getMonth()+1)+"/"+date4.getDate();
    
    //-------------
    //- LINE CHART -
    //--------------
       var lineChartData = {
      labels  : [ week3+"~"+(date3.getMonth()+1)+"/"+(date3.getDate()-1), week2+"~"+(date2.getMonth()+1)+"/"+(date2.getDate()-1),week1+"~"+(date1.getMonth()+1)+"/"+(date1.getDate()-1), (date1.getMonth()+1)+"/"+date1.getDate()+"~"+month+"/"+day],
      datasets: [
        {
          label               : '회원 증가 추이',
          fillColor           : '#345489',
          strokeColor         : 'rgba(210, 214, 222, 1)',
          pointColor          : 'rgba(210, 214, 222, 1)',
          pointStrokeColor    : '#c1c7d1',
          pointHighlightFill  : '#fff',
          pointHighlightStroke: '#4d88b6',
          data                : ['${member.WEEK3}','${member.WEEK2}', '${member.WEEK1}', '${member.WEEK}']
        }]
      
    };
    var lineChartCanvas          = $('#lineChart').get(0).getContext('2d')
    var lineChart                = new Chart(lineChartCanvas)
    var lineChartOptions         = areaChartOptions
    lineChartOptions.datasetFill = false
    lineChart.Line(lineChartData);

    
    var list = new Array();
	<c:forEach items="${eachBoardcount}" var="count">
		list.push(new data('${count.BOARD_NAME}','${count.WRITE_COUNT}'));
	</c:forEach>
	
		
		//-------------
		//- BAR CHART -
		//-------------
		var barChartCanvas = $('#barChart').get(0).getContext('2d')
		var barChart = new Chart(barChartCanvas)
		var barChartData = areaChartData
		barChartData.datasets.fillColor = '#4d88b6'
		barChartData.datasets.strokeColor = '#4d88b6'
		barChartData.datasets.pointColor = '#4d88b6'
		var barChartOptions = {
			//Boolean - Whether the scale should start at zero, or an order of magnitude down from the lowest value
			scaleBeginAtZero : true,
			//Boolean - Whether grid lines are shown across the chart
			scaleShowGridLines : true,
			//String - Colour of the grid lines
			scaleGridLineColor : 'rgba(0,0,0,.05)',
			//Number - Width of the grid lines
			scaleGridLineWidth : 1,
			//Boolean - Whether to show horizontal lines (except X axis)
			scaleShowHorizontalLines : true,
			//Boolean - Whether to show vertical lines (except Y axis)
			scaleShowVerticalLines : true,
			//Boolean - If there is a stroke on each bar
			barShowStroke : true,
			//Number - Pixel width of the bar stroke
			barStrokeWidth : 2,
			//Number - Spacing between each of the X value sets
			barValueSpacing : 5,
			//Number - Spacing between data sets within X values
			barDatasetSpacing : 1,
			//String - A legend template
			legendTemplate : 1,
			//Boolean - whether to make the chart responsive
			responsive : true,
			maintainAspectRatio : true
		}

		barChartOptions.datasetFill = false
		barChart.Bar(barChartData, barChartOptions);
		
		
		
		
		var donut = new Morris.Donut({
		      element: 'writeRatio',
		      resize: true,
		      colors: ["#3c8dbc", "#f56954", "#00a65a","#BEF781","#173B0B","#FF0080"],
		      data: list,
		      hideHover: 'auto'
		    });
	
		google.charts.load('current', {packages: ['corechart']});
		
		//AI처방받는 어류의 비율
		google.charts.setOnLoadCallback(drawChart);

		
		function drawChart() {
		

	    var data = google.visualization.arrayToDataTable([
	   	  ['어류', '진료 수'],
		<c:forEach items="${fishInfo}" var="list">
	   	  ['${list.FISH_NAME}',parseInt('${list.CNT}')],
		</c:forEach>
	  	 ]);

	   var options = {
	     title: '진료 받은 어류 비율',
	     is3D: true,
	   };

	   var chart = new google.visualization.PieChart(document.getElementById('fishRatio'));

	   chart.draw(data, options);
	 }
		
		
		
	});


</script>
</html>