package com.pro.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pro.entity.Note;
import com.sys.common.BaseDAO;
import com.sys.web.fenye.util.DefaultQueryCondition;
import com.sys.web.fenye.util.Page;
import com.sys.web.fenye.util.QueryConditionSQL;
@Service
@Transactional
public class NoteDAOImpl extends BaseDAO<Note, Integer> {
	@Resource private SessionFactory sessionFactory;
	@Override
	protected Class<Note> getReferenceClass() {
		return Note.class;
	}

	@Override
	protected SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	@Override
	public Page<Note> getRecord(DefaultQueryCondition condition) {
		StringBuffer sb = new StringBuffer();
		QueryConditionSQL qcSQL = new QueryConditionSQL(sb);
		sb.append("SELECT note FROM Note note WHERE 1=1 order by id desc");
		Query query = this.sessionFactory.getCurrentSession().createQuery(qcSQL.getSQL().toString());
		query.setFirstResult(condition.getFirstResult());
		query.setMaxResults(condition.getPageSize());
		qcSQL.parameterToQuery(query);
		List<Note> list = query.list();
		int curPage = condition.getPageIndex();
		Page<Note> page = null;
		page = new Page(list,this.getRecordsNum(),curPage,condition.getPageSize());
		return page;
	}

	@Override
	public List search(DefaultQueryCondition condition) {
		// TODO Auto-generated method stub
		return null;
	}


}
