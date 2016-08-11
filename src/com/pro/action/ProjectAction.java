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
import com.pro.entity.Project;
import com.pro.entity.Result;
import com.pro.manager.ProjectManager;
import com.sys.admin.entity.FileEntity;
import com.sys.admin.entity.FileManager;
import com.sys.common.util.CommonUtil;
import com.sys.common.util.Const;
import com.sys.common.util.DateUtil;
import com.sys.common.util.UUIDGenerator;
import com.sys.web.fenye.util.DefaultQueryCondition;
import com.sys.web.fenye.util.Page;

@Controller
public class ProjectAction {
	@Resource private ProjectManager projectManager;
	@Resource private FileManager fileManager;
	private int id;
	private int proYear;
	private int proMonth;
	private int proDay;
	private String proId;//项目编码
	private String proName;//项目名称
	private String isPost;
	private String fileId;
	private String postDate;
	private String proType;
	private String lixiangInfo;//立项信息
	private String proLevel;//项目级别
	private String proOri;//项目来源
	private int proPrice;//项目经费
	private String startDate;
	private String endDate;
	private int alreadyPrice;//到账经费
	private String joinType;//	负责或参与
	private String company;
	private String proCategory; //科技服务，委托开发
	private String postUsername;
	
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
		file.setArea("project");
		file.setDate(new Date());
		file.setPath(filePath);
		try {
			FileUtils.copyFile(this.attach, saveFile);
			this.fileManager.addFile(file);
		} catch (Exception e) {
			ActionContext.getContext().put(Const.ACTION_PUT_ERROR_MSG, e.getMessage());
			return Const.ACTION_RETURN_ERROR;
		}		
		Project pro = new Project();
		pro.setFileId(newFileName);
		pro.setAlreadyPrice(this.alreadyPrice);
		pro.setCompany(this.company);
		pro.setEndDate(this.endDate);
		pro.setIsPost(this.isPost);
		pro.setJoinType(this.joinType);
		pro.setLixiangInfo(this.lixiangInfo);
		pro.setPostDate(DateUtil.dateToStrByPattern(new Date(), DateUtil.PATTERN_TIME));
		pro.setPostUsername(this.postUsername);
		pro.setProCategory(this.proCategory);
		pro.setProYear(this.proYear);
		pro.setProMonth(this.proMonth);
		pro.setProDay(this.proDay);
		pro.setProLevel(this.proLevel);
		pro.setProOri(this.proOri);
		pro.setProPrice(this.proPrice);
		pro.setProType(this.proType);
		pro.setStartDate(this.startDate);
		pro.setProId(this.proId);
		pro.setProName(this.proName);
		try {
			this.projectManager.insert(pro);
		}catch(Exception e) {
			ActionContext.getContext().put(Const.ACTION_PUT_ERROR_MSG, e.getMessage());
			return ActionSupport.ERROR;
		}
		return ActionSupport.SUCCESS;
	}
	
	public String mdyCommit() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String newFileName = null;
		String fileId = request.getParameter("fileId");
		if(CommonUtil.isNotEmpty(this.attachFileName)) {
			String filePath = request.getSession().getServletContext().getRealPath(
					"")
					+ "\\attachment\\";
			newFileName = UUIDGenerator.genFileName().concat(CommonUtil.getFileSuffix(this.attachFileName));
			File saveFile = new File(filePath+newFileName);
			
			FileEntity file = new FileEntity();
			file.setName(this.attachFileName);
			file.setType(this.attachContentType);
			file.setId(newFileName);
			file.setArea("project");
			file.setDate(new Date());
			file.setPath(filePath);
			try {
				FileUtils.copyFile(this.attach, saveFile);
				this.fileManager.addFile(file);
				this.fileManager.deleteFile(fileId);
			} catch (Exception e) {
				ActionContext.getContext().put(Const.ACTION_PUT_ERROR_MSG, e.getMessage());
				return Const.ACTION_RETURN_ERROR;
			}
		}
		Project pro = this.projectManager.getById(this.id);
		if(CommonUtil.isNotEmpty(newFileName))  {
			pro.setFileId(newFileName);
		}
		pro.setAlreadyPrice(this.alreadyPrice);
		pro.setCompany(this.company);
		pro.setEndDate(this.endDate);
		pro.setIsPost(this.isPost);
		pro.setJoinType(this.joinType);
		pro.setLixiangInfo(this.lixiangInfo);
		pro.setPostUsername(this.postUsername);
		pro.setProCategory(this.proCategory);
		pro.setProYear(this.proYear);
		pro.setProMonth(this.proMonth);
		pro.setProDay(this.proDay);
		pro.setProLevel(this.proLevel);
		pro.setProOri(this.proOri);
		pro.setProPrice(this.proPrice);
		pro.setProType(this.proType);
		pro.setStartDate(this.startDate);
		pro.setProId(this.proId);
		pro.setProName(this.proName);
		try {
			this.projectManager.update(pro);
		}catch(Exception e) {
			ActionContext.getContext().put(Const.ACTION_PUT_ERROR_MSG, e.getMessage());
			return ActionSupport.ERROR;
		}
		return Const.ACTION_RETURN_CLOSE;
	}
	
	public String query() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Project pro = new Project();
		pro.setIsPost(this.isPost);
		pro.setPostUsername(this.postUsername);
		pro.setProName(this.proName);
		condition = new DefaultQueryCondition<Project>(pro);
		
		String curPage = request.getParameter("curPage");
		String pageSize = request.getParameter("pageSize");
		if (CommonUtil.isNotEmpty(curPage)) {
			condition.setPageIndex(Integer.parseInt(curPage));
		}
		if (CommonUtil.isNotEmpty(pageSize)) {
			condition.setPageSize(Integer.parseInt(pageSize));
		}
		
		Page<Project> page = this.projectManager.getRecords(condition);
		
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, page.getList());
		ActionContext.getContext().put(Const.ACTION_PUT_PAGE_INFO,
				page.getNavigation());
		ActionContext.getContext().put(Const.ACTION_PUT_CUR_PAGE, page.getCurrentPage());
		return "toAdd";
	}
	
	public String del() {
		HttpServletRequest request = ServletActionContext.getRequest();
		this.projectManager.deleteViaId(this.id);
		try {
			this.fileManager.deleteFile(this.fileId);
		} catch (Exception e) {
			request.setAttribute(Const.ACTION_PUT_ERROR_MSG, e.getMessage());
			return ActionSupport.ERROR;
		}
		request.setAttribute(Const.PAGE_FORWARD_LOCATION, CommonUtil.getRootPath(request)+"pro_jsp/pro/pro_query.jsp");
		return ActionSupport.SUCCESS;
	}
	
	public String post() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Project pro = this.projectManager.getById(this.id);
		pro.setIsPost("Y");
		this.projectManager.update(pro);
		request.setAttribute(Const.PAGE_FORWARD_LOCATION, CommonUtil.getRootPath(request)+"pro/pro_query.do");
		return ActionSupport.SUCCESS;
	}
	
	public String detail() {
		Project pro = this.projectManager.getById(this.id);
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, pro);
		return "toAdd";
	}
	
	public String mdy() {
		Project pro = this.projectManager.getById(this.id);
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, pro);
		return "toAdd";
	}
	
	public String report(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int year = Integer.parseInt(request.getParameter("year"));
		String proType = request.getParameter("proType");
		Result result = this.projectManager.getReportResult(year, proType);
		request.setAttribute(Const.ACTION_PUT_RESULT, result);
		return "toAdd";
	}
	
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
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
	public String getPostUsername() {
		return postUsername;
	}
	public void setPostUsername(String postUsername) {
		this.postUsername = postUsername;
	}
	public int getProYear() {
		return proYear;
	}
	public void setProYear(int proYear) {
		this.proYear = proYear;
	}
	public int getProMonth() {
		return proMonth;
	}
	public void setProMonth(int proMonth) {
		this.proMonth = proMonth;
	}
	public int getProDay() {
		return proDay;
	}
	public void setProDay(int proDay) {
		this.proDay = proDay;
	}
	public String getProId() {
		return proId;
	}
	public void setProId(String proId) {
		this.proId = proId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getProType() {
		return proType;
	}
	public void setProType(String proType) {
		this.proType = proType;
	}
	public String getLixiangInfo() {
		return lixiangInfo;
	}
	public void setLixiangInfo(String lixiangInfo) {
		this.lixiangInfo = lixiangInfo;
	}
	public String getProLevel() {
		return proLevel;
	}
	public void setProLevel(String proLevel) {
		this.proLevel = proLevel;
	}
	public String getProOri() {
		return proOri;
	}
	public void setProOri(String proOri) {
		this.proOri = proOri;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getJoinType() {
		return joinType;
	}
	public void setJoinType(String joinType) {
		this.joinType = joinType;
	}
	public String getProCategory() {
		return proCategory;
	}
	public void setProCategory(String proCategory) {
		this.proCategory = proCategory;
	}
	public int getProPrice() {
		return proPrice;
	}
	public void setProPrice(int proPrice) {
		this.proPrice = proPrice;
	}
	public int getAlreadyPrice() {
		return alreadyPrice;
	}
	public void setAlreadyPrice(int alreadyPrice) {
		this.alreadyPrice = alreadyPrice;
	}

}
