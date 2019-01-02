package com.ai.fishdr.user.dao.conversation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ai.fishdr.vo.ConversationVO;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class IConversationDaoImpl implements IConversationDao {
	
	@Autowired
	private SqlMapClient smc;

	@Override
	public ConversationVO conversationInfo(String con_code) throws Exception {
		return (ConversationVO) smc.queryForObject("conversation.conversationInfo", con_code);
	}
}
