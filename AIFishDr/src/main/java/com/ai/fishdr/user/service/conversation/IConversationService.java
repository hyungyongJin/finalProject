package com.ai.fishdr.user.service.conversation;

import com.ai.fishdr.vo.ConversationVO;

/**
 * 
 * @Class Name :IConversationService.java
 * @Description : 진료 대화 관리 service
 * @Modification Information
 * @author 
 * @since  2018. 11. 19.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일             수정자             수정내용
 *    -------        -------     -------------------
 *    2018. 11. 19.     조성광             최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
public interface IConversationService {
	
	/**
	 * 
	 *  개요 : 진료 대화 정보 출력
	 * @Method Name : conversationInfo
	 * @author : 조성광
	 * -----------------------------------
	 * @param : params
	 * @return : ConversationVO
	 * @throws :
	 */
	public ConversationVO conversationInfo(String con_code) throws Exception;

}
