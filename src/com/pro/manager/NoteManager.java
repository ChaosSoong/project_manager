package com.pro.manager;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pro.entity.Note;
import com.sys.common.IBaseDAO;
import com.sys.web.fenye.util.DefaultQueryCondition;
import com.sys.web.fenye.util.Page;

@Service
public class NoteManager {
	@Resource private IBaseDAO noteDAOImpl;
	
	public void insert(Note note) throws Exception {
		try {
			this.noteDAOImpl.add(note);
		}catch(Exception e) {
			throw new Exception("添加公告失败");
		}
	}
	
	public List<Note> queryAll() {
		return this.noteDAOImpl.getAll();
	}
	
	public void deleteViaId(Integer id){
		this.noteDAOImpl.delete(id);
	}
	
	public List<Note> getTop5Notes() {
		List<Note> lsNotes = this.noteDAOImpl.getViaHql("from Note where 1=1 order by id desc");
		if(lsNotes != null) {
			int size = lsNotes.size();
			if(size >=5) {
				return lsNotes.subList(0, 5);
			}else {
				return lsNotes;
			}
		}
		return lsNotes;
	}
	
	public Page<Note> getRecords(DefaultQueryCondition condition) {
		return noteDAOImpl.getRecord(condition);
	}
	
}
