package com.pro.manager;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pro.entity.Meeting;
import com.sys.common.IBaseDAO;
import com.sys.web.fenye.util.DefaultQueryCondition;
import com.sys.web.fenye.util.Page;

@Service
public class MeetingManager {
	@Resource private IBaseDAO meetingDAOImpl;
	
	public void insert(Meeting meet) throws Exception {
		try {
			this.meetingDAOImpl.add(meet);
		}catch(Exception e) {
			throw new Exception("添加失败");
		}
	}
	
	public List<Meeting> queryAll() {
		return this.meetingDAOImpl.getAll();
	}
	
	public void deleteViaId(Integer id){
		this.meetingDAOImpl.delete(id);
	}
	
	public Meeting getById(Integer id) {
		return (Meeting) this.meetingDAOImpl.getById(id);
	}
	
	public void update(Meeting meet) {
		this.meetingDAOImpl.update(meet);
	}
	
	public Meeting getTopMeeting() {
		List<Meeting> lsNotes = this.meetingDAOImpl.getViaHql("from Meeting where 1=1 and isPost='Y' order by id desc");
		if(lsNotes != null) {
			int size = lsNotes.size();
			if(size >=1) {
				return lsNotes.subList(0, 1).get(0);
			}else {
				return null;
			}
		}
		return null;
	}
	
	public Page<Meeting> getRecords(DefaultQueryCondition condition) {
		return meetingDAOImpl.getRecord(condition);
	}
	
}
