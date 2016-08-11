package com.pro.manager;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.pro.entity.Result;
import com.pro.entity.Thesis;
import com.sys.common.IBaseDAO;
import com.sys.common.util.CommonUtil;
import com.sys.web.fenye.util.DefaultQueryCondition;
import com.sys.web.fenye.util.Page;

@Service
public class ThesisManager {
	@Resource private IBaseDAO thesisDAOImpl;
	
	public void insert(Thesis thesis) throws Exception {
		try {
			this.thesisDAOImpl.add(thesis);
		}catch(Exception e) {
			throw new Exception("添加失败");
		}
	}
	
	public List<Thesis> queryAll() {
		return this.thesisDAOImpl.getAll();
	}
	
	public void deleteViaId(Integer id){
		this.thesisDAOImpl.delete(id);
	}
	
	public Thesis getById(Integer id) {
		return (Thesis) this.thesisDAOImpl.getById(id);
	}
	
	public void update(Thesis meet) {
		this.thesisDAOImpl.update(meet);
	}
	
	public Thesis getTopMeeting() {
		List<Thesis> lsNotes = this.thesisDAOImpl.getViaHql("from Thesis where 1=1 and isPost='Y' order by id desc");
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
	
	public Result getReportResult(int year, String username) {
		String hql = null;
		if(CommonUtil.isNotEmpty(username)) {
			hql = "select count(*) as ttlRecord,postMonth from Thesis where 1=1 and postYear="+year+" and author='"+username+"' group by postMonth";
		}else {
			hql = "select count(*) as ttlRecord,postMonth from Thesis where 1=1 and postYear="+year+" group by postMonth";
		}
		List<Object[]> list = this.thesisDAOImpl.getViaHql(hql);
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
	
	public Page<Thesis> getRecords(DefaultQueryCondition condition) {
		return thesisDAOImpl.getRecord(condition);
	}
	
}
