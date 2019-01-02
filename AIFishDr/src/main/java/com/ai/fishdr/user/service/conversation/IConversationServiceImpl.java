package com.ai.fishdr.user.service.conversation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ai.fishdr.user.dao.conversation.IConversationDao;
import com.ai.fishdr.vo.ConversationVO;

@Repository
public class IConversationServiceImpl implements IConversationService{
	
	@Autowired
	private IConversationDao dao;
	
	@Transactional(readOnly=true)
	@Override
	public ConversationVO conversationInfo(String con_code) throws Exception {
		return dao.conversationInfo(con_code);
	}
}
