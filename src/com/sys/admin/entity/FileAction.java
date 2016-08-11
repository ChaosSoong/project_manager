package com.sys.admin.entity;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sys.common.util.CommonUtil;
import com.sys.common.util.Const;
import com.sys.common.util.UUIDGenerator;
import com.sys.web.download.DownloadUtil;
import com.sys.web.fenye.util.DefaultQueryCondition;

@Controller
public class FileAction {
	private File attach;
	private String attachFileName;
	private String attachContentType;
	
	@Resource private FileManager fileManager;
	
	private String id;
	private String name;
	private DefaultQueryCondition condition;
	private String area;

	public String download() {
		String fileName = this.id;
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		DownloadUtil.getInstance().download(fileName, request, response);
		return null;
	}

	public String upload() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String filePath = request.getSession().getServletContext().getRealPath(
				"")
				+ "\\attachment\\";
		String newFileName = UUIDGenerator.genFileName().concat(this.getFileSuffix(this.attachFileName));
		File saveFile = new File(filePath+newFileName);
		
		FileEntity file = new FileEntity();
		file.setName(this.attachFileName);
		file.setType(this.attachContentType);
		file.setId(newFileName);
		file.setArea(this.area);
		file.setDate(new Date());
		file.setPath(filePath);
		PrintWriter out = null;
		try {
			FileUtils.copyFile(this.attach, saveFile);
			this.fileManager.addFile(file);
//			out = response.getWriter();
//			out.print("<script>alert('Upload Success');location.href='../sys_jsp/template/upload.jsp'</script>");
			request.setAttribute(Const.PAGE_FORWARD_LOCATION, CommonUtil.getRootPath(request)+"pro_jsp/file/upload_normal.jsp");
			return ActionSupport.SUCCESS;
		} catch (Exception e) {
			ActionContext.getContext().put(Const.ACTION_PUT_ERROR_MSG, e.getMessage());
			return Const.ACTION_RETURN_ERROR;
		} finally {
			if(out != null) {
				out.close();
			}
		}
		
	}
	
	public String query() {
		String userType = (String)ActionContext.getContext().getSession().get(Const.ACTION_PUT_SESSION_USRE_TYPE);
		FileEntity file = new FileEntity();
		file.setName(this.name);
		file.setArea(this.area);
		this.condition = new DefaultQueryCondition(file);
		List list = this.fileManager.query(condition);
		ActionContext.getContext().put(Const.ACTION_PUT_RESULT, list);
		ActionContext.getContext().put("uType", userType);
		return Const.ACTION_RETURN_QUERY;
	}
	
	public String del() {
		HttpServletRequest request = ServletActionContext.getRequest();
		try {
			this.fileManager.deleteFile(this.id);
			request.setAttribute(Const.PAGE_FORWARD_LOCATION, CommonUtil.getRootPath(request)+"sys_jsp/file/file_query.jsp");
			return Const.ACTION_RETURN_SUCCESS;
		}catch(Exception e) {
			ActionContext.getContext().put(Const.ACTION_PUT_ERROR_MSG, e.getMessage());
			return Const.ACTION_RETURN_ERROR;
		}
	}

	private String getFileSuffix(String fileName) {
		String suffix = "";
		int index = fileName.lastIndexOf(".");
		if (index != -1) {
			suffix = fileName.substring(index, fileName.length());
		}
		return suffix;
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
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DefaultQueryCondition getCondition() {
		return condition;
	}

	public void setCondition(DefaultQueryCondition condition) {
		this.condition = condition;
	}


	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

}
