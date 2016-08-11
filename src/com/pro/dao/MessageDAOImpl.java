package com.pro.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pro.entity.Message;
import com.sys.common.BaseDAO;
import com.sys.common.util.CommonUtil;
import com.sys.web.fenye.util.DefaultQueryCondition;
import com.sys.web.fenye.util.Page;
import com.sys.web.fenye.util.QueryConditionSQL;
@Service
@Transactional
public class MessageDAOImpl extends BaseDAO<Message, Integer> {
	@Resource private SessionFactory sessionFactory;
	@Override
	protected Class<Message> getReferenceClass() {
		return Message.class;
	}

	@Override
	protected SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	@Override
	public Page<Message> getRecord(DefaultQueryCondition condition) {
		StringBuffer sb = new StringBuffer();
		QueryConditionSQL qcSQL = new QueryConditionSQL(sb);
		StringBuffer where = new StringBuffer();
		sb.append("select meet from Message meet where 1=1 ");
		where.append("1=1 ");
		boolean temp = false;
		
		Message msg = (Message)condition.getCondition();
		String isRead = msg.getIsRead();
		String toUser = msg.getToUser();
		if(CommonUtil.isNotEmpty(isRead)) {
			sb.append(" and meet.isRead = :isRead");
			temp = true;
			qcSQL.setParameter("isRead", isRead);
			where.append(" and isRead='").append(isRead).append("'");
		}
		if(CommonUtil.isNotEmpty(toUser)) {
			sb.append(" and meet.toUser = :toUser");
			temp = true;
			qcSQL.setParameter("toUser", toUser);
			where.append(" and toUser='").append(toUser).append("'");
		}
		Query query = this.sessionFactory.getCurrentSession().createQuery(qcSQL.getSQL().toString());
		query.setFirstResult(condition.getFirstResult());
		query.setMaxResults(condition.getPageSize());
		qcSQL.parameterToQuery(query);
		List<Message> list = query.list();
		int curPage = condition.getPageIndex();
		Page<Message> page = null;
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
