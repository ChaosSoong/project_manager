package com.sys.admin.entity;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pro.entity.Message;
import com.pro.manager.MeetingManager;
import com.pro.manager.MessageManager;
import com.pro.manager.NoteManager;
import com.sun.xml.internal.ws.addressing.model.ActionNotSupportedException;
import com.sys.common.util.CommonUtil;
import com.sys.common.util.Const;
import com.sys.common.util.DateUtil;
import com.sys.common.util.UUIDGenerator;
import com.sys.log.LogFactory;
import com.sys.web.fenye.util.DefaultQueryCondition;
import com.sys.web.fenye.util.Page;

@Controller
public class AdminAction {
	@Resource
	private SysAdminManager sysAdminManager;
	@Resource private FileManager fileManager;
	@Resource private NoteManager noteManager;
	@Resource private MeetingManager meetingManager;
	@Resource private MessageManager messageManager;
	private String username;
	private String password;
	private String userType;
	private String isLock;
	private String address;
	private String qq;
	private String phone;
	private String gender;
	private String email;
	private String name;
	private String loginType;
	private String power;
	
	private File attach;
	private String attachFileName;
	private String attachContentType;


	private DefaultQueryCondition condition;
	private Page page;

	private static Logger logger = LogFactory.getLogger();

	/**
	 * 添加管理员或者用户
	 * 
	 * @return
	 */
	public String add() {
		if (CommonUtil.isEmpty(this.username)) {
			ActionContext.getContext().put(Const.ACTION_PUT_ERROR_MSG,
					"用户名不能为空");
			return Const.ACTION_RETURN_ERROR;
		}
		if (CommonUtil.isEmpty(this.password)) {
			ActionContext.getContext()
					.put(Const.ACTION_PUT_ERROR_MSG, "密码不能为空");
			return Const.ACTION_RETURN_ERROR;

		}
		SysAdmin user = new SysAdmin();
		user.setCreateTime(new Date());
		user.setUsername(this.username);
		user.setPassword(this.password);
		user.setAddress(this.address);
		user.setEmail(this.email);
		user.setGender(this.gender);
		user.setPower(this.power);
		user.setName(this.name);
		user.setQq(this.qq);
		user.setPhone(this.phone);
		user.setUserType(Integer.parseInt(this.userType));
		try {
			sysAdminManager.addUser(user);
		} catch (Exception e) {
			ActionContext.getContext().put(Const.ACTION_PUT_ERROR_MSG,
					e.getMessage());
			return Const.ACTION_RETURN_ERROR;
		}
		return Const.ACTION_RETURN_SUCCESS;
	}
	
	public String changePwd() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		String username = (String)session.getAttribute("userName");
		SysAdmin user = this.sysAdminManager.getSysAdminById(username);
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, user);
		return Const.ACTION_RETURN_QUERY;
	}

	public String query() {
		SysAdmin adm = new SysAdmin();
		adm.setUsername(username);
		condition = new DefaultQueryCondition(adm);
		HttpServletRequest request = ServletActionContext.getRequest();
		String curPage = request.getParameter("curPage");
		String pageSize = request.getParameter("pageSize");
		if (CommonUtil.isNotEmpty(curPage)) {
			condition.setPageIndex(Integer.parseInt(curPage));
		}
		if (CommonUtil.isNotEmpty(pageSize)) {
			condition.setPageSize(Integer.parseInt(pageSize));
		}
		Page<SysAdmin> page = sysAdminManager.getRecords(condition);
		List<SysAdmin> user = page.getList();
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, user);
		ActionContext.getContext().put(Const.ACTION_PUT_PAGE_INFO,
				page.getNavigation());
		ActionContext.getContext().put(Const.ACTION_PUT_CUR_PAGE, page.getCurrentPage());
		ActionContext.getContext().put("username", username);
		return Const.ACTION_RETURN_QUERY;
	}

	public String query2() {
		SysAdmin adm = new SysAdmin();
		adm.setUsername(username);
		adm.setUserType(2);
		condition = new DefaultQueryCondition(adm);
		HttpServletRequest request = ServletActionContext.getRequest();
		String curPage = request.getParameter("curPage");
		String pageSize = request.getParameter("pageSize");
		if (CommonUtil.isNotEmpty(curPage)) {
			condition.setPageIndex(Integer.parseInt(curPage));
		}
		if (CommonUtil.isNotEmpty(pageSize)) {
			condition.setPageSize(Integer.parseInt(pageSize));
		}
		Page<SysAdmin> page = sysAdminManager.getRecords(condition);
		List<SysAdmin> user = page.getList();
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, user);
		ActionContext.getContext().put(Const.ACTION_PUT_PAGE_INFO,
				page.getNavigation());
		ActionContext.getContext().put("curPage", page.getCurrentPage());
		ActionContext.getContext().put("username", username);
		return Const.ACTION_RETURN_QUERY;
	}

	public String login() {
		String username = this.getUsername();
		String password = this.getPassword();
		if ("admin".equalsIgnoreCase(username)
				&& "admin".equalsIgnoreCase(password)
				&& this.loginType.equals("0")) {
			ActionContext.getContext().getSession().put(
					Const.ACTION_PUT_SESSION_USRE_TYPE, "0");
			ActionContext.getContext().getSession().put(
					Const.ACTION_PUT_SESSION_USRE_NAME, "admin");
			return Const.ACTION_ADMIN_LOGIN_SUCCESS;
		} else if (!loginType.equals("0")) {
			boolean hasUser = this.sysAdminManager.isUserExit(username);
			if (hasUser) {
				boolean isPwdCorrect = this.sysAdminManager.checkPassword(
						username, password);
				if (isPwdCorrect) {
					SysAdmin adm = this.sysAdminManager
							.getSysAdminById(username);
					adm.setLoginTime(new Date());
					try {
						this.sysAdminManager.updateUser(adm);
					} catch (Exception e) {
						ActionContext.getContext().put(
								Const.ACTION_PUT_ERROR_MSG,
								e.getMessage() + "/更具体信息请查看日志");
						LogFactory.getLogger().error(
								"更新用户登录时间的时候出错了，可能原因是数据连接不存在，请检查数据库状态");
						return Const.ACTION_RETURN_ERROR;
					}
					String type = String.valueOf(adm.getUserType());
					if(!type.equals(this.loginType)) {
						ActionContext.getContext().put(Const.ACTION_PUT_ERROR_MSG, "用户帐户和用户类型不匹配");
						return Const.ACTION_RETURN_ERROR;
					}
					if ("1".equals(type) || "2".equals(type)) {
						ActionContext.getContext().getSession().put(
								Const.ACTION_PUT_SESSION_USRE_TYPE, type);
						ActionContext.getContext().getSession().put(
								Const.ACTION_PUT_SESSION_USRE_NAME,
								this.username);
						HttpServletRequest request = ServletActionContext.getRequest();
						request.getSession().setAttribute("indexNormalDownload", queryNormalFile());
						request.getSession().setAttribute("indexNote",this.noteManager.getTop5Notes());
						request.getSession().setAttribute("indexMeeting", this.meetingManager.getTopMeeting());
						return Const.ACTION_ADMIN_LOGIN_SUCCESS;
					}else {
						ActionContext.getContext().put(Const.ACTION_PUT_ERROR_MSG, "非法登录");
						return Const.ACTION_RETURN_ERROR;
					}
				} else {
					ActionContext.getContext().put(Const.ACTION_PUT_ERROR_MSG,
							"密码错误");
					return Const.ACTION_RETURN_ERROR;
				}
			} else {
				ActionContext.getContext().put(Const.ACTION_PUT_ERROR_MSG,
						"用户不存在");
				return Const.ACTION_RETURN_ERROR;
			}
		}else {
			ActionContext.getContext().put(Const.ACTION_PUT_ERROR_MSG, "非法登录");
			return ActionSupport.ERROR;
		}
	}
	
	private List<FileEntity> queryNormalFile() {
		String userType = (String)ActionContext.getContext().getSession().get(Const.ACTION_PUT_SESSION_USRE_TYPE);
		FileEntity file = new FileEntity();
		file.setArea("normal");
		this.condition = new DefaultQueryCondition(file);
		List list = this.fileManager.query(condition);
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, list);
		ActionContext.getContext().put("uType", userType);
		return list;
	}

	public String logout() {
//		HttpServletRequest request = ServletActionContext.getRequest();
//		String type = request.getParameter("type");
//		if (CommonUtil.isEmpty(type)) {
//			ActionContext.getContext().getSession().clear();
//			return Const.ACTION_RETURN_ADMIN_LOGIN;
//		} else {
//			if ("2".equals(type)) {
//				ActionContext.getContext().getSession().clear();
//				return Const.ACTION_RETURN_USER_LOGIN;
//			} else {
//				ActionContext.getContext().getSession().clear();
//				return Const.ACTION_RETURN_ADMIN_LOGIN;
//			}
//		}
		ActionContext.getContext().getSession().clear();
		return Const.ACTION_RETURN_ADMIN_LOGIN;
	}

	public String del() {
		try {
			this.sysAdminManager.deleteUser(CommonUtil
					.genUTF8String(this.username));
			return Const.ACTION_RETURN_SUCCESS;
		} catch (Exception e) {
			ActionContext.getContext().put(Const.ACTION_PUT_ERROR_MSG,
					e.getMessage());
			return Const.ACTION_RETURN_ERROR;
		}
	}

	public String modify() {
		HttpServletRequest request = ServletActionContext.getRequest();
		if("2".equals(request.getParameter("type"))) {
			String userId = (String)request.getSession().getAttribute(Const.ACTION_PUT_SESSION_USRE_NAME);
			SysAdmin adm = this.sysAdminManager.getSysAdminById(userId);
			ActionContext.getContext().put(Const.ACTION_PUT_RESULT, adm);
			return Const.ACTION_RETURN_QUERY;
		}else  {
			String userId = CommonUtil.genUTF8String(this.username);
			SysAdmin adm = this.sysAdminManager.getSysAdminById(userId);
			ActionContext.getContext().put(Const.ACTION_PUT_RESULT, adm);
			return Const.ACTION_RETURN_QUERY;
		}
	}

	public String update() {
		String userId = this.username;
		SysAdmin adm = this.sysAdminManager.getSysAdminById(userId);
		HttpServletRequest request = ServletActionContext.getRequest();
		if("changePwd".equals(request.getParameter("type"))) {
			String pwd = adm.getPassword();
			if(pwd.equals(request.getParameter("oldPwd"))) {
				adm.setPassword(request.getParameter("newPwd"));
				this.sysAdminManager.updateUser(adm);
				return ActionSupport.SUCCESS;
			}else {
				ActionContext.getContext().put(Const.ACTION_PUT_ERROR_MSG, "原始密码错误");
				return Const.ACTION_RETURN_ERROR;
			}
		} else  {
			adm.setAddress(this.address);
			adm.setEmail(this.email);
			adm.setGender(this.gender);
			adm.setName(this.name);
			adm.setQq(this.qq);
			adm.setPhone(this.phone);
			this.sysAdminManager.updateUser(adm);
			return ActionSupport.SUCCESS;
		}
	}
	
	public String sendMsg() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String filePath = request.getSession().getServletContext().getRealPath(
				"")
				+ "\\attachment\\";
		String newFileName = UUIDGenerator.genFileName().concat(CommonUtil.getFileSuffix(this.attachFileName));
		File saveFile = new File(filePath+newFileName);
		
		FileEntity file = new FileEntity();
		file.setName(this.attachFileName);
		file.setType(this.attachContentType);
		file.setId(newFileName);
		file.setArea("message");
		file.setDate(new Date());
		file.setPath(filePath);
		try {
			FileUtils.copyFile(this.attach, saveFile);
			this.fileManager.addFile(file);
		} catch (Exception e) {
			ActionContext.getContext().put(Const.ACTION_PUT_ERROR_MSG, e.getMessage());
			return Const.ACTION_RETURN_ERROR;
		}
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String fromUser = (String)request.getSession().getAttribute(Const.ACTION_PUT_SESSION_USRE_NAME);
		List<SysAdmin> users = this.sysAdminManager.getAllUsers();
		try {
			for(SysAdmin user : users) {
				Message msg = new Message();
				msg.setContent(content);
				msg.setTitle(title);
				msg.setFileId(newFileName);
				msg.setFromUser(fromUser);
				msg.setToUser(user.getUsername());
				msg.setIsRead("N");
				msg.setPostDate(DateUtil.dateToStrByPattern(new Date(),DateUtil.PATTERN_TIME));
				this.messageManager.insert(msg);
			}
		}catch(Exception e) {
			request.setAttribute(Const.ACTION_PUT_ERROR_MSG, e.getMessage());
		}
		return ActionSupport.SUCCESS;
	}
	
	public String queryMsg() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Message msg = new Message();
		msg.setIsRead(request.getParameter("isRead"));
		msg.setToUser((String)request.getSession().getAttribute(Const.ACTION_PUT_SESSION_USRE_NAME));
		condition = new DefaultQueryCondition(msg);
		
		String curPage = request.getParameter("curPage");
		String pageSize = request.getParameter("pageSize");
		if (CommonUtil.isNotEmpty(curPage)) {
			condition.setPageIndex(Integer.parseInt(curPage));
		}
		if (CommonUtil.isNotEmpty(pageSize)) {
			condition.setPageSize(Integer.parseInt(pageSize));
		}
		Page<Message> page = this.messageManager.getRecords(condition); 
		List<Message> user = page.getList();
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, user);
		ActionContext.getContext().put(Const.ACTION_PUT_PAGE_INFO,
				page.getNavigation());
		ActionContext.getContext().put(Const.ACTION_PUT_CUR_PAGE, page.getCurrentPage());
		return Const.ACTION_RETURN_QUERY;
	}
	
	public String delMsg() {
		HttpServletRequest request = ServletActionContext.getRequest();
		this.messageManager.deleteViaId(Integer.parseInt(request.getParameter("id")));
		request.setAttribute(Const.PAGE_FORWARD_LOCATION,CommonUtil.getRootPath(request)+"sys_jsp/admin/admin_queryMsg.jsp");
		return "success2";
	}
	
	public String doReadMsg() {
		HttpServletRequest request = ServletActionContext.getRequest();
		Message msg = this.messageManager.getById(Integer.parseInt(request.getParameter("id")));
		msg.setIsRead("Y");
		this.messageManager.update(msg);
		request.setAttribute(Const.PAGE_FORWARD_LOCATION,CommonUtil.getRootPath(request)+"sys_jsp/admin/admin_queryMsg.jsp");
		return "success2";
	}

	// later
	public String viewDetail() {
		// HttpServletRequest request = ServletActionContext.getRequest();
		String userId = (String) ActionContext.getContext().getSession().get(
				Const.ACTION_PUT_SESSION_USRE_NAME);
		SysAdmin adm = this.sysAdminManager.getSysAdminById(userId);
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, adm);
		return Const.ACTION_RETURN_QUERY;
	}

	/************** getters and setters **************************/
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public DefaultQueryCondition getCondition() {
		return condition;
	}

	public void setCondition(DefaultQueryCondition condition) {
		this.condition = condition;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getIsLock() {
		return isLock;
	}

	public void setIsLock(String isLock) {
		this.isLock = isLock;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
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
