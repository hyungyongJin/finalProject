<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>


<head>
    <meta charset="utf-8">
    <title>키워드로 장소검색하고 목록으로 표출하기</title>
<style>
	.map_wrap, .map_wrap * {margin:0;padding:0;font-family:'Malgun Gothic',dotum,'돋움',sans-serif;font-size:12px;}
	.map_wrap a, .map_wrap a:hover, .map_wrap a:active{color:#000;text-decoration: none;}
	.map_wrap {position:relative;width:100%;height:500px;}
	#menu_wrap {position:absolute;top:0;left:0;bottom:0;width:250px;margin:10px 0 30px 10px;padding:5px;overflow-y:auto;background:rgba(255, 255, 255, 0.7);z-index: 1;font-size:12px;border-radius: 10px;}
	.bg_white {background:#fff;}
	#menu_wrap hr {display: block; height: 1px;border: 0; border-top: 2px solid #5F5F5F;margin:3px 0;}
	#menu_wrap .option{text-align: center;}
	#menu_wrap .option p {margin:10px 0;}  
	#menu_wrap .option button {margin-left:5px;}
	#placesList li {list-style: none;}
	#placesList .item {position:relative;border-bottom:1px solid #888;overflow: hidden;cursor: pointer;min-height: 65px;}
	#placesList .item span {display: block;margin-top:4px;}
	#placesList .item h5, #placesList .item .info {text-overflow: ellipsis;overflow: hidden;white-space: nowrap;}
	#placesList .item .info{padding:10px 0 10px 55px;}
	#placesList .info .gray {color:#8a8a8a;}
	#placesList .info .jibun {padding-left:26px;background:url(http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_jibun.png) no-repeat;}
	#placesList .info .tel {color:#009900;}
	#placesList .item .markerbg {float:left;position:absolute;width:36px; height:37px;margin:10px 0 0 10px;background:url(http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png) no-repeat;}
	#placesList .item .marker_1 {background-position: 0 -10px;}
	#placesList .item .marker_2 {background-position: 0 -56px;}
	#placesList .item .marker_3 {background-position: 0 -102px}
	#placesList .item .marker_4 {background-position: 0 -148px;}
	#placesList .item .marker_5 {background-position: 0 -194px;}
	#placesList .item .marker_6 {background-position: 0 -240px;}
	#placesList .item .marker_7 {background-position: 0 -286px;}
	#placesList .item .marker_8 {background-position: 0 -332px;}
	#placesList .item .marker_9 {background-position: 0 -378px;}
	#placesList .item .marker_10 {background-position: 0 -423px;}
	#placesList .item .marker_11 {background-position: 0 -470px;}
	#placesList .item .marker_12 {background-position: 0 -516px;}
	#placesList .item .marker_13 {background-position: 0 -562px;}
	#placesList .item .marker_14 {background-position: 0 -608px;}
	#placesList .item .marker_15 {background-position: 0 -654px;}
	#pagination {margin:10px auto;text-align: center;}
	#pagination a {display:inline-block;margin-right:10px;}
	#pagination .on {font-weight: bold; cursor: default;color:#777;}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="content-wrapper" style="margin-left: 10px;" id="downloadFormInsert">
		<!-- Main content -->
		<section class="content">
		<div class="row">
			<div class="col-md-14">
				<!-- DIRECT CHAT PRIMARY -->
				<div class="box box-primary direct-chat direct-chat-primary"
					style="margin-left: 150px; margin-top: 40px; height: 90%; width:80%;">
					<div class="box-body">
						<input type="hidden" name="dataSum" />
						<!-- Conversations are loaded here -->
						<div class=" insertTag direct-chat-messages" id="entryController"
							style="height: 660px;">
							<div class="direct-chat-msg">
								<div class="direct-chat-info clearfix">
									<span class="direct-chat-name pull-left">AI피쉬닥터</span>
								</div>
								<!-- /.direct-chat-info -->
								<img class="direct-chat-img"
									src="${pageContext.request.contextPath }/dist/img/aiDoctor.png"
									alt="Message User Image">
								<div class="direct-chat-text">
									안녕하세요 AI피쉬 닥터입니다.<br />
								</div>
							</div>
						</div>
					</div>
					<!-- /.box-body -->
					<div class="box-footer" style="margin-top: 10px;">
						<div class="input-group">
							<input type="text" name="sendText" placeholder="메시지를 입력해주세요..."
								class="form-control"> <span class="input-group-btn" />
							<button type="button"
								class="sendMessage btn btn-primary btn-flat">보내기</button>
						</div>
					</div>
					<!-- /.box-footer-->
				</div>
			</div>
		</div>
		</section>

<script type="text/javascript"
	src="//dapi.kakao.com/v2/maps/sdk.js?appkey=99569db9383187ced1293980f76e2503&libraries=services"></script>
<script type="text/javascript">

	$(function(){
		
		setTimeout(function(){
			$('.insertTag').append("<div class='direct-chat-msg'><div class='direct-chat-info clearfix'> <span class='direct-chat-name pull-left'>AI피쉬닥터</span></div>"
								+"<img class='direct-chat-img' src='${pageContext.request.contextPath }/dist/img/aiDoctor.png' alt='Message User Image'>"
								+"<div class='direct-chat-text'>아래 지도에서 질병관리원 위치를 선택해주세요.</div></div>");
			$("#entryController").scrollTop($("#entryController")[0].scrollHeight);
		}, 3000);
		
		$('input[name=sendText]').on("keypress",function(event){
			if (event.keyCode == 13) {
				$('.sendMessage').click();
			}
			
		});
		
		$('.sendMessage').click(function(){
			mem_id = '${LOGIN_MEMBER.mem_id}';
			sendText = $('input[name=sendText]').val();
			var symptoms = $('form[name=insertSymptms]').serialize();
			if (sendText != null) {
				$.ajax({
					url : "${pageContext.request.contextPath}/user/aiDoctor/sendText.do?sendText=" + sendText + "&mem_id=" + mem_id,
					data : symptoms,
					success : function(data){
						if (data.message != null) {
							
							var result = "<div class='direct-chat-msg right'>";
							result +="<div class='direct-chat-info clearfix'>";
							result +="<span class='direct-chat-name pull-right'>" + data.mem_nickname + "</span>";
							result +="</div>" ;
							
							if (data.profile_status == 'n') {
								result += "<img class='direct-chat-img' src='${pageContext.request.contextPath }/dist/img/person_icon.png' alt='Message User Image'>";
							} else if (data.profile_status == 'y') {
								result += "<img class='direct-chat-img' src='" + "/image/" + data.yourfp_file_save_name + "' alt='Message User Image'>";
							}
							result += "<div class='direct-chat-text'>" + data.message + "</div>";
							result +="</div>";
							$('.insertTag').append(result);
							$('input[name=sendText]').val("");
							
						}
						
						if (data.aiText != null) {
							if (data.aiText == '중량을 입력해주세요. (ex)중량: 100g') {
								textToSpeech("어류의 중량을 입력해주세요");
								$('input[name=sendText]').val('중량:');
								$('input[name=sendText]').focus();
							}
							if (data.aiText == '마리수를 입력해주세요. (ex)미수: 1000') {
								textToSpeech("사육하는 어류의 마리수를 입력해주세요");
								$('input[name=sendText]').val('미수:');
								$('input[name=sendText]').focus();
							}
							if (data.aiText == '다른 어종을 입력해주세요.') {
								textToSpeech("다른 어류의 종류를 입력해주세요.");
								$('input[name=sendText]').val('어종:');
								$('input[name=sendText]').focus();
							}
							var finalText = '';
							if (data.aiText == '처방전 작성 중 입니다. 잠시만 기다려 주세요.....') {
								finalText = "<span style='color:blue;'>${LOGIN_MEMBER.mem_nickname}</span>님께서 진료받은 <span style='color:red;'>"+data.fish_name+"</span> 은/는 <br>"
								+"선택하신 증상으로 볼 때 <span style='color:red;'>"+data.diss_name+"</span>의 질병을 가지고 있는 것으로 판단됩니다.<br><br>"
								+"처방전을 작성중이니 잠시만 기다려 주세요!";
								textToSpeech("${LOGIN_MEMBER.mem_nickname}님께서 진료받은 "+data.fish_name+"은/는 "
										+"선택하신 증상으로 볼 때 "+data.diss_name+"의 질병을 가지고 있는 것으로 판단됩니다."
										+"처방전을 작성중이니 잠시만 기다려 주세요!");
							}
							var showTxt ="<div class='direct-chat-msg'><div class='direct-chat-info clearfix'>"+
							"<span class='direct-chat-name pull-left'>AI피쉬닥터</span></div><img class='direct-chat-img'" +
							"src='${pageContext.request.contextPath }/dist/img/aiDoctor.png' alt='Message User Image'>";
							if (finalText!='') {
								showTxt +="<div class='direct-chat-text'>"+finalText+"</div>";
							}else{
								showTxt +="<div class='direct-chat-text'>"+data.aiText+"</div>";
							}
							$('.insertTag').append(showTxt);
						}
						
						
						if (data.symptmsList != null ) {
							textToSpeech("아래에 나오는 증상 중 해당하는 내용이 있다면 선택해 주세요.");
							symptms_content = "<div class='direct-chat-msg'><form class='symptms' name='insertSymptms'><div class='direct-chat-info clearfix'>"+
												"<span class='direct-chat-name pull-left'>AI피쉬닥터</span></div><img class='direct-chat-img'" +
												"src='${pageContext.request.contextPath }/dist/img/aiDoctor.png' alt='Message User Image'>"+
												"<div class='direct-chat-text' style='overflow:scroll; weight:100%; height:100%;'>"+
												"<table border='3'><thead><tr role='row'><th><input type='checkbox' id='allCheck'/></th><th>증상</th></tr></thead><tbody>";
							
							for (var i = 0; i < data.symptmsList.length; i++) {
								symptms_content += "<tr><td><input type='checkbox' name='symptoms' class='checkboxes' value='"+data.symptmsList[i].symptms_content+"' /></td><td>"+data.symptmsList[i].symptms_content+"</td></tr>";
							}
												
							symptms_content += "</tbody></table></div></form></div>";
							
							$('.insertTag').append(symptms_content);
							
							$('#allCheck').click(function() {
								if ($('#allCheck').prop("checked")) {
									$('input[class=checkboxes]').prop("checked", true);
								} else {
									$('input[class=checkboxes]').prop("checked", false);
								}
							});
						}
						
						
						if (data.aiText == '처방전 작성 중 입니다. 잠시만 기다려 주세요.....') {
						
							$('.insertTag').append('<img id="waitImg" style="margin-left: 35%;" src="${pageContext.request.contextPath }/images/waitingIcon.gif">');
							
							
							pdfName = data.pdfName;
							setTimeout(function(){
								textToSpeech('처방전이 작성되었습니다. 감사합니다.');
								$('.insertTag').append("<div class='direct-chat-msg'><div class='direct-chat-info clearfix'> <span class='direct-chat-name pull-left'>AI피쉬닥터</span></div>"
													+"<img class='direct-chat-img' src='${pageContext.request.contextPath }/dist/img/aiDoctor.png' alt='Message User Image'>"
													+"<div class='direct-chat-text'><embed src='/image/"+pdfName+"' width='100%'; height='1000px;' type='application/pdf'></div></div>");
								$("#entryController").scrollTop($("#entryController")[0].scrollHeight);
								$('#downloadFormInsert').append("<form name='downForm' method='post'"+
										" action='${pageContext.request.contextPath}/user/aiDoctor/pdfDownload.do'>"
										+"<input type='hidden' name='pdfName' value='"+pdfName+"'/> </form>");
								$('#waitImg').remove();
								$('form[name=downForm]').submit();
								
							}, 12000);
						}
						
						dataSum = $('input[name=dataSum]').val();
						$('input[name=dataSum]').val(dataSum + data.dataInfo + ",");
						
						$("#entryController").scrollTop($("#entryController")[0].scrollHeight);
					},
					
					error : function(res){
						alert(res.status);
					}
					
				});
			}
		});
	});
	

	
	// 마커를 담을 배열입니다
	setTimeout(function(){
		$('.insertTag').append("<div class='direct-chat-msg'><div class='direct-chat-info clearfix'><span class='direct-chat-name pull-left'>AI피쉬닥터</span></div>"
							+"<img class='direct-chat-img' src='${pageContext.request.contextPath }/dist/img/aiDoctor.png' alt='Message User Image'>"
							+"<div class='direct-chat-text'><div id='map' style='width: 700px; height: 500px;'><div class='map_wrap'"
							+"<div id='map' style='width: 50%; height: 100%; position: relative; overflow: hidden;'></div>"
							+"<div id='menu_wrap' class='bg_white'><div class='option'><div><form onsubmit='searchPlaces(); return false;'>키워드 : <input type='text' value='수산질병관리원' id='keyword'"
							+" size='15'><button type='submit'>검색하기</button></form></div></div><hr><ul id='placesList'></ul><div id='pagination'></div>");
		
		
		
		var markers = [];
		$('#menu_wrap').hide();
		var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
		    mapOption = {
		        center: new daum.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
		        level: 3 // 지도의 확대 레벨
		    };  
		
		// 지도를 생성합니다    
		var map = new daum.maps.Map(mapContainer, mapOption); 
	
		// 장소 검색 객체를 생성합니다
		var ps = new daum.maps.services.Places();  
	
	
		// 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
		var infowindow = new daum.maps.InfoWindow({
				zIndex:1
			
			
			});
	
	
	
		// 키워드로 장소를 검색합니다
		searchPlaces();
	
		// 키워드 검색을 요청하는 함수입니다
		function searchPlaces() {
	
		    var keyword = document.getElementById('keyword').value;
	
		    if (!keyword.replace(/^\s+|\s+$/g, '')) {
		        alert('키워드를 입력해주세요!');
		        return false;
		    }
	
		    // 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
		    ps.keywordSearch( keyword, placesSearchCB); 
		}
	
		// 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
		function placesSearchCB(data, status, pagination) {
		    if (status === daum.maps.services.Status.OK) {
	
		        // 정상적으로 검색이 완료됐으면
		        // 검색 목록과 마커를 표출합니다
	
		        displayPlaces(data);
		        // 페이지 번호를 표출합니다
		        displayPagination(pagination);
	
		    } else if (status === daum.maps.services.Status.ZERO_RESULT) {
	
		        alert('검색 결과가 존재하지 않습니다.');
		        return;
	
		    } else if (status === daum.maps.services.Status.ERROR) {
	
		        alert('검색 결과 중 오류가 발생했습니다.');
		        return;
	
		    }
		}
	
		// 검색 결과 목록과 마커를 표출하는 함수입니다
		function displayPlaces(places) {
	
		    var listEl = document.getElementById('placesList'), 
		    menuEl = document.getElementById('menu_wrap'),
		    fragment = document.createDocumentFragment(), 
		    bounds = new daum.maps.LatLngBounds(), 
		    listStr = '';
		    
		    // 검색 결과 목록에 추가된 항목들을 제거합니다
		    removeAllChildNods(listEl);
	
		    // 지도에 표시되고 있는 마커를 제거합니다
		    removeMarker();
		    
		    for ( var i=0; i<places.length; i++ ) {
	
		        // 마커를 생성하고 지도에 표시합니다
		        var placePosition = new daum.maps.LatLng(places[i].y, places[i].x),
		            marker = addMarker(placePosition, i), 
		            itemEl = getListItem(i, places[i]); // 검색 결과 항목 Element를 생성합니다
	
		        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
		        // LatLngBounds 객체에 좌표를 추가합니다
		        bounds.extend(placePosition);
	
		        // 마커와 검색결과 항목에 mouseover 했을때
		        // 해당 장소에 인포윈도우에 장소명을 표시합니다
		        // mouseout 했을 때는 인포윈도우를 닫습니다
		        (function(marker, title, places) {
		            daum.maps.event.addListener(marker, 'mouseover', function() {
		            	
		                displayInfowindow(marker, title, places);
		            });
	
		            daum.maps.event.addListener(marker, 'mouseout', function() {
		                infowindow.close();
		            });
	
		            itemEl.onmouseover =  function () {
		                displayInfowindow(marker, title, places);
		            };
	
		            itemEl.onmouseout =  function () {
		                infowindow.close();
		            };
		            
		            daum.maps.event.addListener(marker, 'click', function() { 
		            	alert(title);
		            	mem_id = '${LOGIN_MEMBER.mem_id}';
		            	$.ajax({
		        			url : '${pageContext.request.contextPath}/user/aiDoctor/sendText.do?hospitalName='+title+'&mem_id='+mem_id,
		        			success : function(data){
		        				var code = '';
		        				if (data.hospital != null) {
		        					code += "<div class='direct-chat-msg'><div class='direct-chat-info clearfix'>"+
			    							"<span class='direct-chat-name pull-left'>AI피쉬닥터</span></div><img class='direct-chat-img'" +
			    							"src='${pageContext.request.contextPath }/dist/img/aiDoctor.png' alt='Message User Image'>"+
			    							"<div class='direct-chat-text'>"+data.hospital + "을 선택하셨습니다. <br><br>";
									textToSpeech(data.hospital + '을 선택하셨습니다.');
		        					//alert(data.hospital + '을 선택하셨습니다.');
								}
		        				if (data.aiText != null) {
		        					textToSpeech('어류의 종류를 입력해 주세요');
		        					if (data.aiText == '어종을 입력해주세요. (ex) 어종: 넙치') {
		    							$('input[name=sendText]').val('어종:');
		    							$('input[name=sendText]').focus();
		    						}
		    						$('.insertTag').append(code+"<p>"+data.aiText+"</p></div>");
		    					}
		        				
		        				
		        				$("#entryController").scrollTop($("#entryController")[0].scrollHeight);
		        			},
		        			error : function(res){
		        				alert(res.status);
		        			}
		        		});
		            });
		            
		        })(marker,places[i].place_name,'<br/> 주소='+ places[i].road_address_name);
	
		        fragment.appendChild(itemEl);
		    }
	
		    // 검색결과 항목들을 검색결과 목록 Elemnet에 추가합니다
		    listEl.appendChild(fragment);
		    menuEl.scrollTop = 0;
	
		    // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
		    map.setBounds(bounds);
		}
	
		// 검색결과 항목을 Element로 반환하는 함수입니다
		function getListItem(index, places) {
	
		    var el = document.createElement('li'),
		    itemStr = '<span class="markerbg marker_' + (index+1) + '"></span>' +
		                '<div class="info">' +
		                '   <h5>' + places.place_name + '</h5>';
	
		    if (places.road_address_name) {
		        itemStr += '    <span>' + places.road_address_name + '</span>' +
		                    '   <span class="jibun gray">' +  places.address_name  + '</span>';
		    } else {
		        itemStr += '    <span>' +  places.address_name  + '</span>'; 
		    }
		                 
		      itemStr += '  <span class="tel">' + places.phone  + '</span>' +
		                '</div>';           
	
		    el.innerHTML = itemStr;
		    el.className = 'item';
			
		    
		    
		    return el;
		}
	
		// 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
		function addMarker(position, idx, title) {
			
		    
		    var imageSrc = 'http://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
		        imageSize = new daum.maps.Size(36, 37),  // 마커 이미지의 크기
		        imgOptions =  {
		            spriteSize : new daum.maps.Size(36, 691), // 스프라이트 이미지의 크기
		            spriteOrigin : new daum.maps.Point(0, (idx*46)+10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
		            offset: new daum.maps.Point(13, 37) // 마커 좌표에 일치시킬 이미지 내에서의 좌표
		        },
		        markerImage = new daum.maps.MarkerImage(imageSrc, imageSize, imgOptions),
		            marker = new daum.maps.Marker({
		            position: position, // 마커의 위치
		            image: markerImage 
		        });
	
		    marker.setMap(map); // 지도 위에 마커를 표출합니다
		    markers.push(marker);  // 배열에 생성된 마커를 추가합니다
	
		    return marker;
		}
	
		// 지도 위에 표시되고 있는 마커를 모두 제거합니다
		function removeMarker() {
		    for ( var i = 0; i < markers.length; i++ ) {
		        markers[i].setMap(null);
		    }   
		    markers = [];
		}
	
		// 검색결과 목록 하단에 페이지번호를 표시는 함수입니다
		function displayPagination(pagination) {
		    var paginationEl = document.getElementById('pagination'),
		        fragment = document.createDocumentFragment(),
		        i; 
	
		    // 기존에 추가된 페이지번호를 삭제합니다
		    while (paginationEl.hasChildNodes()) {
		        paginationEl.removeChild (paginationEl.lastChild);
		    }
	
		    for (i=1; i<=pagination.last; i++) {
		        var el = document.createElement('a');
		        el.href = "#";
		        el.innerHTML = i;
	
		        if (i===pagination.current) {
		            el.className = 'on';
		        } else {
		            el.onclick = (function(i) {
		                return function() {
		                    pagination.gotoPage(i);
		                };
		            })(i);
		        }
	
		        fragment.appendChild(el);
		    }
		    paginationEl.appendChild(fragment);
		}
	
		// 검색결과 목록 또는 마커를 클릭했을 때 호출되는 함수입니다
		// 인포윈도우에 장소명을 표시합니다
		function displayInfowindow(marker, title, places) {
		    var content = '<div style="padding:5px;z-index:1;">' + title + '</div>'+
		      				'<div style="padding:5px;z-index:1;">'+places +'</div>'
		      				;
		    
		     
	//	     infowindow.getContent();
	//	     infowindow.getPosition();
		    infowindow.setContent(content);
		    
		    infowindow.open(map, marker);
		    
	// 	    // 마커에 클릭이벤트를 등록합니다
	// 	    daum.maps.event.addListener(marker, 'click', function() {
	// 	        // 마커를 클릭하면 장소명이 인포윈도우에 표출됩니다
	// 	        infowindow.setContent('<div style="padding:5px;font-size:12px;">' + place.place_name+ + '</div>');
	// 	        infowindow.open(map, marker);
	// 	    });
		  
		}
	
		 // 검색결과 목록의 자식 Element를 제거하는 함수입니다
		function removeAllChildNods(el) {   
		    while (el.hasChildNodes()) {
		        el.removeChild (el.lastChild);
		    }
		}
	},4000);
function textToSpeech(text) {
	 speechSynthesis.speak(new SpeechSynthesisUtterance(text));
}	
</script>
</body>
<script type="text/javascript">
$(function(){
	var welcomeMsg = '안녕하세요 AI피쉬 닥터입니다. 아래 지도에서 질병관리원 위치를 선택해주세요.';
	textToSpeech(welcomeMsg);
})
</script>
</html>