package com.pro.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pro.entity.Project;
import com.sys.common.BaseDAO;
import com.sys.common.util.CommonUtil;
import com.sys.web.fenye.util.DefaultQueryCondition;
import com.sys.web.fenye.util.Page;
import com.sys.web.fenye.util.QueryConditionSQL;
@Service
@Transactional
public class ProjectDAOImpl extends BaseDAO<Project, Integer> {
	@Resource private SessionFactory sessionFactory;
	@Override
	protected Class<Project> getReferenceClass() {
		return Project.class;
	}

	@Override
	protected SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	@Override
	public Page<Project> getRecord(DefaultQueryCondition condition) {
		StringBuffer sb = new StringBuffer();
		QueryConditionSQL qcSQL = new QueryConditionSQL(sb);
		StringBuffer where = new StringBuffer();
		sb.append("select meet from Project meet where 1=1 ");
		where.append("1=1 ");
		boolean temp = false;
		
		Project meet = (Project)condition.getCondition();
		String isPost = meet.getIsPost();
		String proName = meet.getProName();
		String username = meet.getPostUsername();
		if(CommonUtil.isNotEmpty(isPost)) {
			sb.append(" and meet.isPost = :isPost");
			temp = true;
			qcSQL.setParameter("isPost", isPost);
			where.append(" and isPost='").append(isPost).append("'");
		}
		if(CommonUtil.isNotEmpty(username)) {
			sb.append(" and meet.postUsername = :username");
			temp = true;
			qcSQL.setParameter("username", username);
			where.append(" and postUsername='").append(username).append("'");
		}
		if(CommonUtil.isNotEmpty(proName)) {
			sb.append(" and meet.proName LIKE :title");
			temp = true;
			qcSQL.setLikeParameter("title", proName);
			where.append(" and proName like '%").append(proName).append("%'");
		}
		
		Query query = this.sessionFactory.getCurrentSession().createQuery(qcSQL.getSQL().toString());
		query.setFirstResult(condition.getFirstResult());
		query.setMaxResults(condition.getPageSize());
		qcSQL.parameterToQuery(query);
		List<Project> list = query.list();
		int curPage = condition.getPageIndex();
		Page<Project> page = null;
		if(temp) {
			page = new Page(list,this.getRevoedsNum(where.toString()),curPage,condition.getPageSize());
		}else {
			page = new Page(list,this.getRecordsNum(),curPage,condition.getPageSize());
		}
		return page;
	}

	@Override
	public List search(DefaultQueryCondition condition) {
		return null;
	}


}
