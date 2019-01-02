package com.ai.fishdr.user.service.mesageroom;

import java.util.List;
import java.util.Map;

import com.ai.fishdr.vo.MessageVO;
/**
 * @Class Name :IMessageRoomService.java
 * @Description : 쪽지 관련 service
 * @Modification Information
 * @author 진형용
 * @since  2018. 11. 29.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일             수정자             수정내용
 *    -------        -------     -------------------
 *    2018. 11. 29.     진형용             최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
public interface IMessageRoomService {
	/**
	 *  개요 : 쪽지 내용 등록
	 * @Method Name : insertMsg
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : boolean
	 * @throws :
	 */
	public boolean insertMsg(MessageVO vo) throws Exception;
	/**
	 *  개요 : 회원이 받은 쪽지리스트
	 * @Method Name : receiveMessageList
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : List<MessageVO>
	 * @throws :
	 */
	public List<Map<String,MessageVO>> receiveMessageList(Map<String,String> params) throws Exception;
	/**
	 *  개요 : 받은메세지 총 카운트 수
	 * @Method Name : totalReceiveMsgCount
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : int
	 * @throws :
	 */
	public int totalReceiveMsgCount(String mem_id) throws Exception;
	/**
	 *  개요 : 받은쪽지 다중 삭제
	 * @Method Name : delMsg
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : boolean
	 * @throws :
	 */
	public boolean delMsg(List<String> delList)throws Exception;
	/**
	 *  개요 : 보낸쪽지 다중 삭제
	 * @Method Name : delMsg
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : boolean
	 * @throws :
	 */
	public boolean delSendMsg(List<String> delList)throws Exception;
	/**
	 *  개요 : 쪽지 읽은 상태로 업데이트
	 * @Method Name : checkReadMsg
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : boolean
	 * @throws :
	 */
	public boolean checkReadMsg(String ms_no) throws Exception;
	/**
	 *  개요 : 회원이 보낸 쪽지리스트
	 * @Method Name : receiveMessageList
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : List<MessageVO>
	 * @throws :
	 */
	public List<Map<String,MessageVO>> sendMessageList(Map<String,String> params) throws Exception;
	/**
	 *  개요 : 보낸메세지 총 카운트 수
	 * @Method Name : totalReceiveMsgCount
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : int
	 * @throws :
	 */
	public int totalSendMsgCount(String mem_id) throws Exception;

}
