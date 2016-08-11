package com.pro.action;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pro.entity.Note;
import com.pro.manager.NoteManager;
import com.sys.common.util.CommonUtil;
import com.sys.common.util.Const;
import com.sys.common.util.DateUtil;
import com.sys.web.fenye.util.DefaultQueryCondition;
import com.sys.web.fenye.util.Page;

@Controller
public class NoteAction {
	@Resource private NoteManager noteManager;
	
	private String title;
	private String content;
	private String id;
	
	private DefaultQueryCondition condition;
	private Page page;
	
	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Note note = new Note();
		note.setTitle(this.title);
		note.setContent(this.content);
		note.setPostDate(DateUtil.dateToStrByPattern(new Date(), "yyyy-MM-dd HH:mm:ss"));
		try {
			this.noteManager.insert(note);
		} catch (Exception e) {
			request.setAttribute(Const.ACTION_PUT_ERROR_MSG, e.getMessage());
			return ActionSupport.ERROR;
		}
		ActionContext.getContext().put(Const.PAGE_FORWARD_LOCATION, CommonUtil.getRootPath(request)+"pro_jsp/note/note_add.jsp");
		return ActionSupport.SUCCESS;
	}
	
	public String query() {
		Note note = new Note();
		condition = new DefaultQueryCondition<Note>(note);
		HttpServletRequest request = ServletActionContext.getRequest();
		String curPage = request.getParameter("curPage");
		String pageSize = request.getParameter("pageSize");
		if (CommonUtil.isNotEmpty(curPage)) {
			condition.setPageIndex(Integer.parseInt(curPage));
		}
		if (CommonUtil.isNotEmpty(pageSize)) {
			condition.setPageSize(Integer.parseInt(pageSize));
		}
		Page<Note> page = this.noteManager.getRecords(condition);
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, page.getList());
		ActionContext.getContext().put(Const.ACTION_PUT_PAGE_INFO,
				page.getNavigation());
		ActionContext.getContext().put(Const.ACTION_PUT_CUR_PAGE, page.getCurrentPage());
		return Const.ACTION_RETURN_QUERY;
	}
	
	public String del() {
		this.noteManager.deleteViaId(Integer.parseInt(this.id));
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute(Const.PAGE_FORWARD_LOCATION, CommonUtil.getRootPath(request)+"pro_jsp/note/note_query.jsp");
		return ActionSupport.SUCCESS;
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
