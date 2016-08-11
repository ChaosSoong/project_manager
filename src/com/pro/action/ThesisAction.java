package com.pro.action;

import java.io.File;
import java.io.PrintWriter;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pro.entity.Result;
import com.pro.entity.Thesis;
import com.pro.entity.Note;
import com.pro.manager.ThesisManager;
import com.sys.admin.entity.FileEntity;
import com.sys.admin.entity.FileManager;
import com.sys.common.util.CommonUtil;
import com.sys.common.util.Const;
import com.sys.common.util.DateUtil;
import com.sys.common.util.UUIDGenerator;
import com.sys.web.fenye.util.DefaultQueryCondition;
import com.sys.web.fenye.util.Page;

@Controller
public class ThesisAction {
	@Resource private ThesisManager thesisManager;
	@Resource private FileManager fileManager;
	
	private int id;
	private int postYear;
	private int postMonth;
	private int postDay;
	private String postDate;
	private String title;
	private String company;
	private String isPost;
	private String author;
	private String content;
	private String juan;
	private String qi;
	private String fileId;
	private String username;
	
	private File attach;
	private String attachFileName;
	private String attachContentType;
	
	private DefaultQueryCondition condition;
	private Page page;
	
	public String add() {
		HttpServletRequest request = ServletActionContext.getRequest();
		
		HttpServletResponse response = ServletActionContext.getResponse();
		String filePath = request.getSession().getServletContext().getRealPath(
				"")
				+ "\\attachment\\";
		String newFileName = UUIDGenerator.genFileName().concat(CommonUtil.getFileSuffix(this.attachFileName));
		File saveFile = new File(filePath+newFileName);
		
		FileEntity file = new FileEntity();
		file.setName(this.attachFileName);
		file.setType(this.attachContentType);
		file.setId(newFileName);
		file.setArea("thesis");
		file.setDate(new Date());
		file.setPath(filePath);
		try {
			FileUtils.copyFile(this.attach, saveFile);
			this.fileManager.addFile(file);
		} catch (Exception e) {
			ActionContext.getContext().put(Const.ACTION_PUT_ERROR_MSG, e.getMessage());
			return Const.ACTION_RETURN_ERROR;
		}		
		Thesis sis = new Thesis();
		sis.setAuthor(this.author);
		sis.setCompany(this.company);
		sis.setFileId(newFileName);
		sis.setIsPost("Y");
		sis.setJuan(this.juan);
		sis.setPostDate(DateUtil.dateToStrByPattern(new Date(), DateUtil.PATTERN_TIME));
		sis.setPostDay(this.postDay);
		sis.setPostMonth(this.postMonth);
		sis.setPostYear(this.postYear);
		sis.setUsername(this.username);
		sis.setQi(this.qi);
		sis.setTitle(this.title);
		try {
			this.thesisManager.insert(sis);
		}catch(Exception e) {
			ActionContext.getContext().put(Const.ACTION_PUT_ERROR_MSG, e.getMessage());
			return ActionSupport.ERROR;
		}
		return ActionSupport.SUCCESS;
	}
	
	
	public String query() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Thesis thesis = new Thesis();
		thesis.setIsPost(this.isPost);
		thesis.setUsername(this.username);
		thesis.setTitle(this.title);
		condition = new DefaultQueryCondition<Thesis>(thesis);
		
		String curPage = request.getParameter("curPage");
		String pageSize = request.getParameter("pageSize");
		if (CommonUtil.isNotEmpty(curPage)) {
			condition.setPageIndex(Integer.parseInt(curPage));
		}
		if (CommonUtil.isNotEmpty(pageSize)) {
			condition.setPageSize(Integer.parseInt(pageSize));
		}
		
		Page<Thesis> page = this.thesisManager.getRecords(condition);
		
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, page.getList());
		ActionContext.getContext().put(Const.ACTION_PUT_PAGE_INFO,
				page.getNavigation());
		ActionContext.getContext().put(Const.ACTION_PUT_CUR_PAGE, page.getCurrentPage());
		return "toAdd";
	}
	
	public String report(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int year = Integer.parseInt(request.getParameter("year"));
		String author = request.getParameter("author");
		Result result = this.thesisManager.getReportResult(year, author);
		request.setAttribute(Const.ACTION_PUT_RESULT, result);
		return "toAdd";
	}
	
	public String del() {
		HttpServletRequest request = ServletActionContext.getRequest();
		this.thesisManager.deleteViaId(this.id);
		try {
			this.fileManager.deleteFile(this.fileId);
		} catch (Exception e) {
			request.setAttribute(Const.ACTION_PUT_ERROR_MSG, e.getMessage());
			return ActionSupport.ERROR;
		}
		request.setAttribute(Const.PAGE_FORWARD_LOCATION, CommonUtil.getRootPath(request)+"pro_jsp/thesis/thesis_query.jsp");
		return ActionSupport.SUCCESS;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public String getJuan() {
		return juan;
	}
	public void setJuan(String juan) {
		this.juan = juan;
	}
	public String getQi() {
		return qi;
	}
	public void setQi(String qi) {
		this.qi = qi;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPostYear() {
		return postYear;
	}
	public void setPostYear(int postYear) {
		this.postYear = postYear;
	}
	public int getPostMonth() {
		return postMonth;
	}
	public void setPostMonth(int postMonth) {
		this.postMonth = postMonth;
	}
	public int getPostDay() {
		return postDay;
	}
	public void setPostDay(int postDay) {
		this.postDay = postDay;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getIsPost() {
		return isPost;
	}
	public void setIsPost(String isPost) {
		this.isPost = isPost;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public File getAttach() {
		return attach;
	}


	public void setAttach(File attach) {
		this.attach = attach;
	}


	public String getAttachFileName() {
		return attachFileName;
	}


	public void setAttachFileName(String attachFileName) {
		this.attachFileName = attachFileName;
	}


	public String getAttachContentType() {
		return attachContentType;
	}


	public void setAttachContentType(String attachContentType) {
		this.attachContentType = attachContentType;
	}
}
