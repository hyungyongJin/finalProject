package com.ai.fishdr.user.service.mesageroom;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ai.fishdr.user.dao.messageroom.IMessageRoomDao;
import com.ai.fishdr.vo.MessageVO;

@Service
public class IMessageRoomServiceImpl implements IMessageRoomService{

	@Autowired
	private IMessageRoomDao dao;
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public boolean insertMsg(MessageVO vo) throws Exception {
		boolean result = true;
		String chk = dao.insertMsg(vo);
		if (chk!=null) {
			result = true;
		}
		return result;
	}
	@Override
	public List<Map<String,MessageVO>> receiveMessageList(Map<String,String> params) throws Exception {
		return dao.receiveMessageList(params);
	}
	@Override
	public int totalReceiveMsgCount(String mem_id) throws Exception {
		return dao.totalReceiveMsgCount(mem_id);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public boolean delMsg(List<String> delList) throws Exception {
		boolean result = false;
		int cnt = dao.delMsg(delList);
		if (cnt>0) {
			result = true;
		}
		return result;
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public boolean delSendMsg(List<String> delList) throws Exception {
		boolean result = false;
		int cnt = dao.delSendMsg(delList);
		if (cnt>0) {
			result = true;
		}
		return result;
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public boolean checkReadMsg(String ms_no) throws Exception {
		boolean result = false;
		int cnt = dao.checkReadMsg(ms_no);
		if (cnt>0) {
			result  = true;
		}
		return result;
	}
	@Override
	public List<Map<String, MessageVO>> sendMessageList(
			Map<String, String> params) throws Exception {
		return dao.sendMessageList(params);
	}
	@Override
	public int totalSendMsgCount(String mem_id) throws Exception {
		return dao.totalSendMsgCount(mem_id);
	}
	
}
