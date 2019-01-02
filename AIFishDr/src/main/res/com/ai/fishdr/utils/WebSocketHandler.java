package com.ai.fishdr.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.ai.fishdr.vo.MemberVO;




@ServerEndpoint("/wsMsg")
public class WebSocketHandler {
	//Peer 맵
	//private static ArrayList<Session> sessionList = new ArrayList<Session>();
	private static Map<String,Session> memList = new HashMap<String, Session>();
	private HttpSession httpSession;
	
	//peer가 웹소켓 앤드포인트 정상 접근 완료 콜백
	@OnOpen
	public void onOpen(Session webSocketSession){
		httpSession = ((PrincipalWithSession)webSocketSession.getUserPrincipal()).getSession();
		//sessionList.add(webSocketSession);
		MemberVO member = (MemberVO) httpSession.getAttribute("LOGIN_MEMBER");
		if (member!=null) {
			memList.put(member.getMem_id(), webSocketSession);
		}
	}

	@OnClose
	public void onClose(Session webSocketSession){
//		MemberVO member = (MemberVO) httpSession.getAttribute("LOGIN_MEMBER");
//		memList.remove(member.getMem_id());
	}

	@OnMessage
	public void onMessage(String message){
		boolean result = false;
		String mem_id = message.split(",")[0];
		if (message.contains("/call/")) {
			mem_id = mem_id.substring(6);
			for (String key : memList.keySet()) {
				if (key.intern() == mem_id.intern()) {
					Session webSocketSession = memList.get(key);
					Basic peerBasic = webSocketSession.getBasicRemote();
					try {
						peerBasic.sendText(message.substring(6));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			result = true;
		}
		
		if (!result) {
			if (mem_id.intern() != "#msg#".intern()) {
				String my_id = message.split(",")[1];
				for (String key : memList.keySet()) {
					Session webSocketSession = memList.get(key);
					if (key.intern() == mem_id.intern()
							|| key.intern() == my_id.intern()) {
						Basic peerBasic = webSocketSession.getBasicRemote();
						try {
							peerBasic.sendText(message);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			} else {
				for (String key : memList.keySet()) {
					Session webSocketSession = memList.get(key);
					Basic peerBasic = webSocketSession.getBasicRemote();
					try {
						peerBasic.sendText(message);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}	
	}
		//브로드 캐스팅
//		for (Session webSocketSession : sessionList) {
//			Basic peerBasic = webSocketSession.getBasicRemote();
//			System.out.println("WebSocketSession ID : " + webSocketSession.getId());
//			try {
//				peerBasic.sendText(message);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	JSONObject json = new JSONObject(msg);
//	
//	for(String key : userList.keySet()){
//		Session webSocketSession = userList.get(key);
//		Basic peerBasic;
//		if(json.getString("id").equals(key)){
//			peerBasic = webSocketSession.getBasicRemote();
//			
//			try {
//				peerBasic.sendText(msg);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		
		
//	}

	@OnError
	public void onError(Throwable exception){
		System.out.println("WSChat 에러  : "+exception.toString());
	}


}
