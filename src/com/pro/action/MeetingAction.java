package com.pro.action;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pro.entity.Meeting;
import com.pro.entity.Note;
import com.pro.manager.MeetingManager;
import com.sys.common.util.CommonUtil;
import com.sys.common.util.Const;
import com.sys.common.util.DateUtil;
import com.sys.web.fenye.util.DefaultQueryCondition;
import com.sys.web.fenye.util.Page;

@Controller
public class MeetingAction {
	@Resource private MeetingManager meetingManager;
	
	private String title;
	private String remark;
	private String id;
	private String beginDate;
	private String beginHour;
	private String beginMiniute;
	private String isPost;
	private String address;

	private DefaultQueryCondition condition;
	private Page page;
	
	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Meeting meet = new Meeting();
		meet.setBeginDate(this.beginDate);
		meet.setBeginHour(this.beginHour);
		meet.setBeginMiniute(this.beginMiniute);
		meet.setTitle(this.title);
		meet.setRemark(this.remark);
		meet.setAddress(this.address);
		meet.setPostDate(DateUtil.dateToStrByPattern(new Date(), DateUtil.PATTERN_TIME));
		meet.setIsPost("N");
		meet.setPostUser((String)request.getSession().getAttribute(Const.ACTION_PUT_SESSION_USRE_NAME));
		try {
			this.meetingManager.insert(meet);
		}catch(Exception e) {
			ActionContext.getContext().put(Const.ACTION_PUT_ERROR_MSG, e.getMessage());
			return ActionSupport.ERROR;
		}
		return ActionSupport.SUCCESS;
	}
	
	public String queryNoPost() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Meeting meet = new Meeting();
		meet.setIsPost(this.isPost);
		condition = new DefaultQueryCondition<Meeting>(meet);
		
		String curPage = request.getParameter("curPage");
		String pageSize = request.getParameter("pageSize");
		if (CommonUtil.isNotEmpty(curPage)) {
			condition.setPageIndex(Integer.parseInt(curPage));
		}
		if (CommonUtil.isNotEmpty(pageSize)) {
			condition.setPageSize(Integer.parseInt(pageSize));
		}
		
		Page<Meeting> page = this.meetingManager.getRecords(condition);
		
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, page.getList());
		ActionContext.getContext().put(Const.ACTION_PUT_PAGE_INFO,
				page.getNavigation());
		ActionContext.getContext().put(Const.ACTION_PUT_CUR_PAGE, page.getCurrentPage());
		return "toAdd";
	}
	
	public String queryPost() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Meeting meet = new Meeting();
		meet.setIsPost(this.isPost);
		condition = new DefaultQueryCondition<Meeting>(meet);
		
		String curPage = request.getParameter("curPage");
		String pageSize = request.getParameter("pageSize");
		if (CommonUtil.isNotEmpty(curPage)) {
			condition.setPageIndex(Integer.parseInt(curPage));
		}
		if (CommonUtil.isNotEmpty(pageSize)) {
			condition.setPageSize(Integer.parseInt(pageSize));
		}
		
		Page<Meeting> page = this.meetingManager.getRecords(condition);
		
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, page.getList());
		ActionContext.getContext().put(Const.ACTION_PUT_PAGE_INFO,
				page.getNavigation());
		ActionContext.getContext().put(Const.ACTION_PUT_CUR_PAGE, page.getCurrentPage());
		return "toAdd";
	}
	
	public String query() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Meeting meet = new Meeting();
		meet.setIsPost(this.isPost);
		condition = new DefaultQueryCondition<Meeting>(meet);
		
		String curPage = request.getParameter("curPage");
		String pageSize = request.getParameter("pageSize");
		if (CommonUtil.isNotEmpty(curPage)) {
			condition.setPageIndex(Integer.parseInt(curPage));
		}
		if (CommonUtil.isNotEmpty(pageSize)) {
			condition.setPageSize(Integer.parseInt(pageSize));
		}
		
		Page<Meeting> page = this.meetingManager.getRecords(condition);
		
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, page.getList());
		ActionContext.getContext().put(Const.ACTION_PUT_PAGE_INFO,
				page.getNavigation());
		ActionContext.getContext().put(Const.ACTION_PUT_CUR_PAGE, page.getCurrentPage());
		return "toAdd";
	}
	
	public String del() {
		HttpServletRequest request = ServletActionContext.getRequest();
		this.meetingManager.deleteViaId(Integer.parseInt(this.id));
		request.setAttribute(Const.PAGE_FORWARD_LOCATION, CommonUtil.getRootPath(request)+"pro_jsp/meet/meet_query.jsp");
		return ActionSupport.SUCCESS;
	}
	
	public String postMeeting() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Meeting meet = this.meetingManager.getById(Integer.parseInt(this.id));
		meet.setIsPost("Y");
		this.meetingManager.update(meet);
		request.setAttribute(Const.PAGE_FORWARD_LOCATION, CommonUtil.getRootPath(request)+"pro_jsp/meet/meet_queryNoPost.jsp");
		return ActionSupport.SUCCESS;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getBeginHour() {
		return beginHour;
	}
	public void setBeginHour(String beginHour) {
		this.beginHour = beginHour;
	}
	public String getBeginMiniute() {
		return beginMiniute;
	}
	public void setBeginMiniute(String beginMiniute) {
		this.beginMiniute = beginMiniute;
	}

	public String getIsPost() {
		return isPost;
	}

	public void setIsPost(String isPost) {
		this.isPost = isPost;
	}
	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
