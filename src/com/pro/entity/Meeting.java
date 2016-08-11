package com.pro.entity;

import com.sys.common.BaseEntity;

public class Meeting extends BaseEntity<Meeting> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private String remark;
	private String beginDate;
	private String postDate;
	private String beginHour;
	private String beginMiniute;
	private String postUser;
	private String isPost;
	private String address;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostUser() {
		return postUser;
	}
	public void setPostUser(String postUser) {
		this.postUser = postUser;
	}
	public String getIsPost() {
		return isPost;
	}
	public void setIsPost(String isPost) {
		this.isPost = isPost;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
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

}
