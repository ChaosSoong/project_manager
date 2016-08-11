package com.pro.entity;

import com.sys.common.BaseEntity;

public class Project extends BaseEntity<Project> {
	
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
	public String getPostUsername() {
		return postUsername;
	}
	public void setPostUsername(String postUsername) {
		this.postUsername = postUsername;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getIsPost() {
		return isPost;
	}
	public void setIsPost(String isPost) {
		this.isPost = isPost;
	}
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
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
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
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
