package com.pro.manager;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pro.entity.Project;
import com.pro.entity.Result;
import com.sys.common.IBaseDAO;
import com.sys.common.util.CommonUtil;
import com.sys.web.fenye.util.DefaultQueryCondition;
import com.sys.web.fenye.util.Page;

@Service
public class ProjectManager {
	@Resource private IBaseDAO projectDAOImpl;
	
	public void insert(Project pro) throws Exception {
		try {
			this.projectDAOImpl.add(pro);
		}catch(Exception e) {
			throw new Exception("添加失败");
		}
	}
	
	public List<Project> queryAll() {
		return this.projectDAOImpl.getAll();
	}
	
	public void deleteViaId(Integer id){
		this.projectDAOImpl.delete(id);
	}
	
	public Project getById(Integer id) {
		return (Project) this.projectDAOImpl.getById(id);
	}
	
	public void update(Project meet) {
		this.projectDAOImpl.update(meet);
	}
	
	public Project getTopMeeting() {
		List<Project> lsNotes = this.projectDAOImpl.getViaHql("from Project where 1=1 and isPost='Y' order by id desc");
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
	
	public Page<Project> getRecords(DefaultQueryCondition condition) {
		return projectDAOImpl.getRecord(condition);
	}
	
	public Result getReportResult(int year, String proType) {
		String hql = null;
		if(CommonUtil.isNotEmpty(proType)) {
			hql = "select count(*) as ttlRecord,proMonth from Project where 1=1 and proYear="+year+" and proType='"+proType+"' group by proMonth";
		}else {
			hql = "select count(*) as ttlRecord,proMonth from Project where 1=1 and proYear="+year+" group by proMonth";
		}
		List<Object[]> list = this.projectDAOImpl.getViaHql(hql);
		Result result = new Result();
		for(Object[] objs : list) {
			if(objs[1] != null) {
				switch (Integer.parseInt(objs[1].toString())) {
				case 1:
					result.setMonth1(Integer.parseInt(objs[0].toString()));
					break;
				case 2:
					result.setMonth2(Integer.parseInt(objs[0].toString()));
					break;
				case 3:
					result.setMonth3(Integer.parseInt(objs[0].toString()));
					break;
				case 4:
					result.setMonth4(Integer.parseInt(objs[0].toString()));
					break;
				case 5:
					result.setMonth5(Integer.parseInt(objs[0].toString()));
					break;
				case 6:
					result.setMonth6(Integer.parseInt(objs[0].toString()));
					break;
				case 7:
					result.setMonth7(Integer.parseInt(objs[0].toString()));
					break;
				case 8:
					result.setMonth8(Integer.parseInt(objs[0].toString()));
					break;
				case 9:
					result.setMonth9(Integer.parseInt(objs[0].toString()));
					break;
				case 10:
					result.setMonth10(Integer.parseInt(objs[0].toString()));
					break;
				case 11:
					result.setMonth11(Integer.parseInt(objs[0].toString()));
					break;
				case 12:
					result.setMonth12(Integer.parseInt(objs[0].toString()));
					break;	

				default:
					break;
				}
			}
		}
		return result;
	}
	
}
