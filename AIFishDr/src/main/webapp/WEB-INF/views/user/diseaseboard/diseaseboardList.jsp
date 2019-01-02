<%@ page language="JAVA" contentType="text/html; charset=UTF-8"                                                    
pageEncoding="UTF-8"%>                                                                                               
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>                                                    
<!DOCTYPE html>                                                                                                        
<html>                                                                                                                 
<style>                                                                                                                
.layer{ position:relative; top:50%; left:40%; width:300px; height:100px; margin:-50px 0 0 -50px; }                     
input{background-color:transparent;border:0}                                                                           
.sorting{text-align: center;}                                                                                          
</style>                                                                                                               
<script type="text/javascript">                                                                                      
$(function(){                                                                                                          
	if (eval('${!empty param.message}')) {                                                                               
		alert('${param.message}');                                                                                       
	}                                                                                                                    
	                                                                                                                     
	$('#insertBtn').click(function(){                                                                                    
		$(location).attr('href','${pageContext.request.contextPath}/user/diseaseboard/diseaseboardForm.do?board_code=board006'); 
	});                                                                                                                                      
	                                                                                                                                         
	                                                                                                                                         
});                                                                                                                                        
function goModal(value){                                                                                                                   
	var x = (screen.availWidth - 500) / 2;                                                                                                   
	var y = (screen.availHeight - 400) / 2;                                                                                                  
	var info = encodeURIComponent(value);                                                                                                    
	var url = "${pageContext.request.contextPath }/user/diseaseboard/messageModal.do?id="+info;                                               
	var options = "width = 500, height = 400, scrollbars = no left="+x+", top="+y;                                                       
	                                                                                                                                         
	window.open(url, "쪽지보내기", options);                                                                                               
		                                                                                                                                     
}                                                                                                                                          
function goChatModal(value){                                                                                                               
	var x = (screen.availWidth - 500) / 2;                                                                                                   
	var y = (screen.availHeight - 650) / 2;                                                                                                  
	var info = encodeURIComponent(value);                                                                                                    
	var url = "${pageContext.request.contextPath }/user/diseaseboard/chatModal.do?id="+info;                                                  
	var options = "width = 500, height = 650, scrollbars = no left="+x+", top="+y;                                                       
	window.open(url, "채팅하기", options);                                                                                                 
}                                                                                                                                          
</script>                                                                                                                                  
<body>                                                                                                                                     
 <!-- Main content -->                                                                                                                     
	<section class="content">                                                                                                              
		<div class="row">                                                                                                                  
			<div class="col-md-12">                                                                                                        
                                                                                                                                           
				<br>                                                                                                                         
				<hr>                                                                                                                         
				<div class="box" id="boardMgr">                                                                                          
					<div class="box-header">                                                                                               
						<h3 class="box-title text-green">질병게시판</h3>                                                   
					</div>                                                                                                                   
                                                                                                                                           
					<!-- /.box-header -->                                                                                                    
					<div class="box-body">                                                                                                 
                                                                                                                                           
                                                                                                                                           
						<div id="example1_wrapper"                                                                                         
							class="dataTables_wrapper form-inline dt-bootstrap">                                                           
							<div class="row">                                                                                              
								<div class="col-sm-12">                                                                                    
									<form action="${pageContext.request.contextPath }/user/diseaseboard/diseaseboardList.do" method="post">    
										<div class="dropdown">                                                                             
											<select name="search" class="form-control">                                                  
												<option value="TOTAL">전체</option>                                                        
												<option value="TITLE">제목</option>                                                        
												<option value="CONTENT">내용</option>                                                      
												<option value="WRITER">작성자</option>                                                     
											</select> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input name="keyword"                                 
												type="search" class="form-control input-md"                                              
												style="width: 300px;" placeholder="검색어를 입력하세요.."                                
												aria-controls="example1">                                                                  
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;                                                                   
											<button id="searchBtn" class="btn btn-primary btn-md"                                        
												type="submit">검색</button>                                                                
										</div>                                                                                               
									</form>                                                                                                  
									<br>                                                                                                     
									<form id="delForm" method="post"                                                                     
										action="/AIFishDr/admin/board/deleteWrite.do">                                                     
										<table id="example1"                                                                               
											class="table table-bordered table-striped dataTable"                                           
											role="grid" aria-describedby="example1_info">                                                
											<thead>                                                                                          
												<tr role="row">                                                                             
													<th class="sorting" tabindex="0" rowspan="1"                                        
														colspan="1" style="width: 40px;"><p class="text-green">No.</p></th>             
													<th class="sorting" tabindex="0" rowspan="1" colspan="1"                          
														style="width: 500px;"><p class="text-green">제목</p>                              
														</th>                                                                                 
													<th class="sorting" tabindex="0" rowspan="1" colspan="1"                          
														style="width: 50px;"><p class="text-green">글쓴이</p></th>                        
													<th class="sorting" tabindex="0" rowspan="1" colspan="1"                          
														style="width: 70px;"><p class="text-green">작성일</p></th>                        
													<th class="sorting" tabindex="0" rowspan="1" colspan="1"                          
														style="width: 30px;"><p class="text-green">조회</p></th>                          
													<th class="sorting" tabindex="0" rowspan="1" colspan="1"                          
														style="width: 30px;"><p class="text-green">추천</p></th>                          
												</tr>                                                                                         
											<c:forEach items="${noticeList}" var="list">
											<c:if test="${list.MEM_ID == 'admin' }">
											<tr style="background-color: lightgrey;" role="row" class="odd">
												<td class="sorting"><p class="text-red">공지</p></td>
												<td><a href="${pageContext.request.contextPath}/user/diseaseboard/diseaseboardView.do?bo_no=${list.BO_NO }&currentPage=${currentPage}												&search=${search}&keyword=${keyword}"><span style="color: red">												${list.BO_TITLE }</span></a></td>
												<td class="sorting">
												<div class="dropdown">
													<a href="#" class=" dropdown-toggle" data-toggle="dropdown">
													${list.MEM_NICKNAME }	</a><img src="https://cafe.pstatic.net/levelicon/1/1_1.gif" width="11" height="11">
													<ul class="dropdown-menu">   
													<c:if test="${LOGIN_MEMBER.mem_id !=list.MEM_ID }">
														<li><a href="#"><span onclick="goChatModal('${list.MEM_NICKNAME }(${list.MEM_ID})');">1:1 채팅하기</span></a></li>
														<li><a href="#"><span onclick="goModal('${list.MEM_NICKNAME }(${list.MEM_ID})');">쪽지보내기</span></a></li>
													</c:if>	 
														<li><a href="${pageContext.request.contextPath }/user/fishgram/fishgramYouList.do?mem_id=${list.MEM_ID}">블로그가기</a></li>
													</ul>
												</div>
												</td>
												<td class="sorting">${list.BO_REG_DATE }</td>
												<td class="sorting">${list.BO_HIT }</td>
												<td class="sorting">${list.BO_GOOD_HIT }</td>
											</tr>
											</c:if>
											</c:forEach>
											</thead>                                                                                          
											<tbody id="boardTable">                                                                         
											<c:forEach items="${writeList}" var="list">                                                   
												<tr role="row" class="odd">                                                               
													<td class="sorting">${list.RNUM }</td>                                                  
													<td><a  href="${pageContext.request.contextPath}/user/diseaseboard/diseaseboardView.do?bo_no=${list.BO_NO }&currentPage=${currentPage}													&search=${search}&keyword=${keyword}">                                                                                              
													${list.BO_TITLE }</a></td>                                                                                                           
													<td class="sorting">                                                                                                               
													<div class="dropdown">                                                                                                             
														<a href="#" class=" dropdown-toggle" data-toggle="dropdown">                                                               
														${list.MEM_NICKNAME }	</a><img src="https://cafe.pstatic.net/levelicon/1/1_1.gif" width="11" height="11">                
														<ul class="dropdown-menu">                                                                                                     
														<c:if test="${LOGIN_MEMBER.mem_id !=list.MEM_ID }">                                                                            
															<li><a href="#"><span onclick="goChatModal('${list.MEM_NICKNAME }(${list.MEM_ID})');">1:1 채팅하기</span></a></li>       
															<li><a href="#"><span onclick="goModal('${list.MEM_NICKNAME }(${list.MEM_ID})');">쪽지보내기</span></a></li>             
														</c:if>	                                                                                                                         
															<li><a href="${pageContext.request.contextPath }/user/fishgram/fishgramYouList.do?mem_id=${list.MEM_ID}">블로그가기</a></li> 
														</ul>                                                                                                                            
													</div>                                                                            
													</td>                                                                             
													<td class="sorting">${list.BO_REG_DATE }</td>                                   
													<td class="sorting">${list.BO_HIT }</td>                                        
													<td class="sorting">${list.BO_GOOD_HIT }</td>                                   
												</tr>                                                                                 
											</c:forEach>                                                                              
											</tbody>                                                                                  
										</table>                                                                                      
									</form>                                                                                           
									<br>                                                                                              
									<div class="layer">                                                                             
										${paging }                                                                                    
									</div>                                                                                            
							<button id="insertBtn" type="button"                                                                  
								style="width: 140px; margin-right: 10px;"                                                           
								class="btn btn-info btn-sm pull-right">글쓰기</button>                                              
				</div>                           
			</div>                               
			<br>                                 
		</div>                                   
	</div>                                       
	</div>                                       
	</div>                                       
	</div>                                       
	</section>                                   
	</div>                                       
</body>                                                                                                                             
</html>		