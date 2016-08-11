package com.pro.manager;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pro.entity.Message;
import com.sys.common.IBaseDAO;
import com.sys.web.fenye.util.DefaultQueryCondition;
import com.sys.web.fenye.util.Page;

@Service
public class MessageManager {
	@Resource private IBaseDAO messageDAOImpl;
	
	public void insert(Message msg) throws Exception {
		try {
			this.messageDAOImpl.add(msg);
		}catch(Exception e) {
			throw new Exception("发送失败");
		}
	}
	
	public List<Message> queryAll() {
		return this.messageDAOImpl.getAll();
	}
	
	public void deleteViaId(Integer id){
		this.messageDAOImpl.delete(id);
	}
	
	public Message getById(Integer id) {
		return (Message) this.messageDAOImpl.getById(id);
	}
	
	public void update(Message meet) {
		this.messageDAOImpl.update(meet);
	}
	
	public Page<Message> getRecords(DefaultQueryCondition condition) {
		return messageDAOImpl.getRecord(condition);
	}
	
}
