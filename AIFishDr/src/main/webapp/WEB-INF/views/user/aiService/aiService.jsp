<%--==============================================================
 * jsp 개요 : 
 * @author : 
 * @since : 2018. 11. 13.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일                          수정자                       수정내용
 *    -------      -------     -------------------
 *    2018. 11. 13.        진형용                      최초작성
 * Copyright (c) 2018 AI Fish Dr. All right reserved
 * </pre>
===============================================================--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AI 응답서비스</title>
<style type="text/css">
#messageView{height: 500px;}
.con{margin-left: 100px;}


*{font-family: 'Roboto', sans-serif;}

@keyframes click-wave {
  0% {
    height: 25px;
    width: 25px;
    opacity: 0.35;
    position: relative;
  }
  100% {
    height: 200px;
    width: 200px;
    margin-left: -80px;
    margin-top: -80px;
    opacity: 0;
  }
}

.option-input {
  -webkit-appearance: none;
  -moz-appearance: none;
  -ms-appearance: none;
  -o-appearance: none;
  appearance: none;
  position: relative;
  top: 10px;
  right: 0;
  bottom: 0;
  left: 0;
  height: 25px;
  width: 25px;
  transition: all 0.15s ease-out 0s;
  background: #cbd1d8;
  border: none;
  color: #fff;
  cursor: pointer;
  display: inline-block;
  margin-right: 0.5rem;
  outline: none;
  position: relative;
  z-index: 1000;
}
.option-input:hover {
  background: #9faab7;
}
.option-input:checked {
  background: #40e0d0;
}
.option-input:checked::before {
  height: 25px;
  width: 25px;
  position: absolute;
  content: '✔';
  display: inline-block;
  font-size: 20px;
  text-align: center;
  line-height: 15px;
}

</style>
</head>
<body>
<br>
<div id="img" class="content-wrapper" style="margin-left:0px;">
<section class="content">
	<div class="con col-md-10">
          <!-- DIRECT CHAT PRIMARY -->
          <div class="box box-primary direct-chat direct-chat-primary">
            <div class="box-header with-border">
              <h3 class="box-title" style="color: blue; ">AI 자동응답 서비스</h3>

            </div>
            <!-- /.box-header -->
            <div class="box-body">
              <!-- Conversations are loaded here -->
              <div id="messageView"  class="direct-chat-messages">
                <!-- Message. Default to the left -->
                <div class="direct-chat-msg">
                  <div class="direct-chat-info clearfix">
                    <span class="direct-chat-name pull-left"></span>
                    <span class="direct-chat-timestamp pull-right"></span>
                  </div>
                  <!-- /.direct-chat-info -->
                  <img class="direct-chat-img" width="128" height="128" src="${pageContext.request.contextPath }/dist/img/aiDoctor.png" alt="Message User Image"><!-- /.direct-chat-img -->
                  <div class="direct-chat-text">
                    안녕하세요 자동응답 서비스 입니다. 궁금하신 것을 물어보세요!
                  </div>
                  <div class="direct-chat-text">
                    뉴스로 검색원하시면 [뉴스]에 체크해 주세요!
                  </div>
                  <!-- /.direct-chat-text -->
                </div>
                <!-- /.direct-chat-msg -->

              </div>
              <!--/.direct-chat-messages-->
              
            </div>
            <!-- /.box-body -->
            <div>
			  <label>
			    &nbsp;&nbsp;<input id="chkBox" type="checkbox" value="1" class="option-input checkbox"  />
			    <span style="color: blue;">[뉴스]</span>
			  </label>
            </div>
            <div class="box-footer">
                <div class="input-group">
                  <input id="message" onkeyup="enterkey();" type="text" name="message" placeholder="메세지를 입력해 주세요" class="form-control">
                      <span class="input-group-btn">
                        <button id="askBtn" type="button" class="btn btn-primary btn-flat">보내기</button>
                      </span>
                </div>
            </div>
        
        <div class="wrap" style="display: none;">
    <div id="result">
      <span class="final" id="final_span"></span>
      <span class="interim" id="interim_span"></span>
    </div>
    <button id="btn-mic" class="off">마이크 <span></span></button>
    <button id="btn-tts">Text to speech</button>
  </div>
            <!-- /.box-footer-->
          </div>
          <!--/.direct-chat -->
        </div>
        
        </section>
      
</body>


<script type="text/javascript">
function enterkey() {
	//엔터키 누를시 반응
	if (window.event.keyCode == 13) {
        $('#askBtn').click();
   }
}
$(function(){
	$('#message').focus();
	$('#askBtn').click(function(){
		var data = $('#message').val();
		if (data=='') {
			alert('질문을 입력해 주세요');
			return;
		}
		if ($('#chkBox').prop('checked')) {
			var date = new Date(); 
			var year = date.getFullYear(); 
			var month = new String(date.getMonth()+1); 
			var day = new String(date.getDate()); 
			if(month.length == 1){ 
			  month = "0" + month; 
			} 
			if(day.length == 1){ 
			  day = "0" + day; 
			} 
			var info = year + "" + month + "" + day;
			var dataEn = encodeURIComponent(data);
			$.ajax({
				url : 'http://api.adams.ai/datamixiApi/search?key=3145707988585906817&target=news&from='+info+'&count=3&keyword='+dataEn,
				type : 'get',
				success : function(datas){
					var info = datas.return_object;
					console.log(info);
					var code ='';
		        	code += '<div class="direct-chat-msg right">';
 		        	code +=   ' <div class="direct-chat-info clearfix">';
 		        	code +=   '  <span class="direct-chat-name pull-right">${LOGIN_MEMBER.mem_nickname}</span>';
 		        	code +=   '  <span class="direct-chat-timestamp pull-left"></span>'; 
 		        	code +=   '</div>';
 		        	code +=  '<img class="direct-chat-img" width="128" height="128" src="/image/${FILE_SAVE_NAME}" onerror="this.src=\'${pageContext.request.contextPath }/dist/img/person_icon.png\'" >';
 		        	code +=  '<div class="direct-chat-text">';
 		        	code +=  data;
 		        	code += ' </div>';
 		        	code +='</div>';
		        	 code += '<div class="direct-chat-msg">';
		        	 code += '<div class="direct-chat-info clearfix">';
		        	 code +=   '<span class="direct-chat-name pull-left">피돌이</span>';
		        	 code +=  '<span class="direct-chat-timestamp pull-right"></span>';
		        	 code += '</div>';
		        	 code += '<img class="direct-chat-img" src="${pageContext.request.contextPath }/dist/img/aiDoctor.png" alt="Message User Image">';
		        	 code += '<div class="direct-chat-text">';
					if (info[0].documents.length==0) {
						var notification = data+'에 대한 뉴스가 검색되지 않았습니다. 다른 주제로 검색해 주세요!';
						 code += notification;
						 code += '</div>';
	 		        	 code +='</div>';
			        	textToSpeech(notification);
					}else{
					
 		        	 console.log('ss',info[0].documents);
 		        	 var news = info[0].documents;
 		        	 for (var i = 0; i < news.length; i++) {
 		        		 var newsTitle = news[i].fields.title;
 		        		 var uri = news[i].fields.source_uri;
 		        		 var writeDate = news[i].fields.published_date;
 		        		 var author = news[i].fields.author;
 		        		 if (author==null) {
 		        			author = '#';
						}
			 		      code +=  "#\""+ newsTitle+"\" - ["+author +"] "+writeDate[0].substring(0,10) +"<br>";
			 		      code +=  '       &nbsp;&nbsp;&nbsp;&nbsp;<a target="_blank" href='+uri+'>뉴스보기</a><br><br>';
					}
 		        	 code += '</div>';
 		        	 code +='</div>';
		        	textToSpeech(data+'에 대한 뉴스를 검색했습니다. 뉴스를 보려면 뉴스보기를 클릭해주세요!');
					}
 		        	$('#messageView').append(code);
		        	$('#message').val('');
		        	$("#messageView").scrollTop($("#messageView")[0].scrollHeight);
		        	$('#message').focus();
					
				},error: function(res){
					alert(res.status);
				}

			});
			
		}else{
 			$.ajax({        
 		         url: 'http://api.adams.ai/datamixiApi/deepqa?key=3145707988585906817&answerType=0&question='+data,
 		         type: 'get',
 		         success: function(res){
 		        	 console.log(res);
 		        	 var answer = res.return_object.answer;
 		        	 if (res.result == '2005') {
						answer = '죄송해요 질문을 이해하지 못했어요!';
 		        	 }
 		        	answer = answer.replace('아담', '피돌이');
 		        	 var code="";
 		        	 	code += '<br>';
 		        	 	code += '<div class="direct-chat-msg right">';
 		        	 	code +=   ' <div class="direct-chat-info clearfix">';
 		        	 	code +=   '  <span class="direct-chat-name pull-right">${LOGIN_MEMBER.mem_nickname}</span>';
 		        	 	code +=   '  <span class="direct-chat-timestamp pull-left"></span>';
 		        	 	code +=   '</div>';
 		        	 	code +=  '<img class="direct-chat-img" width="128" height="128" src="/image/${FILE_SAVE_NAME}" onerror="this.src=\'${pageContext.request.contextPath }/dist/img/person_icon.png\'">';
 		        	 	code +=  '<div class="direct-chat-text">';
 		        	 	code +=  data;
 		        	 	code += ' </div>';
 		        	 	code +='</div>';
 		        	 	code += '<br>';
 		        	 code += '<div class="direct-chat-msg">';
 		        	 code += '<div class="direct-chat-info clearfix">';
 		        	 code +=   '<span class="direct-chat-name pull-left">피돌이</span>';
 		        	 code +=  '<span class="direct-chat-timestamp pull-right"></span>';
 		        	 code += '</div>';
 		        	 code += '<img class="direct-chat-img" src="${pageContext.request.contextPath }/dist/img/aiDoctor.png" alt="Message User Image">';
 		        	 code += '<div class="direct-chat-text">';
 		        	 code +=   answer;
 		        	 code += '</div>';
 		        	 code +='</div>';
 		        	 $('#messageView').append(code);
		        	textToSpeech(answer);
		        	$('#message').val('');
		        	$("#messageView").scrollTop($("#messageView")[0].scrollHeight);
		        	$('#message').focus();
		         }
			});
		}
	});
	
	if (typeof webkitSpeechRecognition !== 'function') {
	    alert('크롬에서만 동작 합니다.');
	    return false;
	  }
	  /**
	   * 문자를 음성으로 읽어 줍니다.
	   * 지원: 크롬, 사파리, 오페라, 엣지
	   */
	  function textToSpeech(text) {
// 	    console.log('textToSpeech', arguments);
// 	    speechSynthesis.speak(new SpeechSynthesisUtterance(text));

		var msg = new SpeechSynthesisUtterance(text);
		console.log('msg',msg);
		msg.voice = speechSynthesis.getVoices().filter(function(voice) { return voice.name == 'Whisper'; })[0];
		speechSynthesis.speak(msg);
	  }
	  /**
	   * 초기 바인딩
	   */
	  function initialize(value) {
	    var param = '';
	    param = value;
	    $('#btn-tts').click(function() {
		   const text = param;
	      textToSpeech(text);
	    });
	  }

	  initialize('${welcome}');
 	$('#btn-tts').click();
	
	
	
	
	
});
</script>
</html>
