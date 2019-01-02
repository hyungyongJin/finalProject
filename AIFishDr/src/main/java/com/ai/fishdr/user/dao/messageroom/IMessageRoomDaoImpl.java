package com.ai.fishdr.user.dao.messageroom;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ai.fishdr.vo.MessageVO;
import com.ibatis.sqlmap.client.SqlMapClient;


@Repository
public class IMessageRoomDaoImpl implements IMessageRoomDao{

	@Autowired
	private SqlMapClient smc;

	@Override
	public String insertMsg(MessageVO vo) throws Exception {
		return (String) smc.insert("message.insertMsg",vo);
	}

	@Override
	public List<Map<String,MessageVO>> receiveMessageList(Map<String,String>params) throws Exception {
		return smc.queryForList("message.receiveMessageList",params);
	}

	@Override
	public int totalReceiveMsgCount(String mem_id) throws Exception {
		return (int) smc.queryForObject("message.totalReceiveMsgCount",mem_id);
	}

	@Override
	public int delMsg(List<String> delList) throws Exception {
		return smc.delete("message.delMsg",delList);
	}
	@Override
	public int delSendMsg(List<String> delList) throws Exception {
		return smc.delete("message.delSendMsg",delList);
	}

	@Override
	public int checkReadMsg(String ms_no) throws Exception {
		return smc.update("message.checkReadMsg",ms_no);
	}

	@Override
	public List<Map<String, MessageVO>> sendMessageList(
			Map<String, String> params) throws Exception {
		return smc.queryForList("message.sendMessageList",params);
	}

	@Override
	public int totalSendMsgCount(String mem_id) throws Exception {
		return (int) smc.queryForObject("message.totalSendMsgCount",mem_id);
	}
}
