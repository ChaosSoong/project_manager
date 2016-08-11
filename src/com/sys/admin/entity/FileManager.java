package com.sys.admin.entity;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sys.common.IBaseDAO;
import com.sys.web.fenye.util.DefaultQueryCondition;

@Service
public class FileManager {
	@Resource
	IBaseDAO fileDAOImpl;
	
	public void addFile(FileEntity file) throws Exception {
		try {
		this.fileDAOImpl.add(file);
		}catch(Exception e) {
			throw new Exception("上传文件失败");
		}
	}
	
	public List<FileEntity> query(DefaultQueryCondition condition) {
		condition.setPageSize(1000);
		return this.fileDAOImpl.search(condition);
	}
	
	public FileEntity getFileById(String id) throws Exception {
		try {
			return (FileEntity)this.fileDAOImpl.getById(id);
		}catch(Exception e) {
			throw new Exception("该文件不存在");
		}
	}
	
	public void deleteFile(String id) throws Exception {
		try {
			FileEntity file =  (FileEntity) this.fileDAOImpl.getById(id);
			if(file != null) {
				String filePath = file.getPath();
				File f = new File(filePath+File.separator+file.getId());
				if(f.exists()) {
					f.delete();
				}
			}
		}catch(Throwable ee) {
			ee.printStackTrace();
		}
		try {
			this.fileDAOImpl.delete(id);
		}catch(Exception e) {
			throw new Exception("删除失败，请检查相关设置");
		}
	}
}
