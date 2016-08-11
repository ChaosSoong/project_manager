package com.pro.entity;

import com.sys.common.BaseEntity;

public class Thesis extends BaseEntity<Thesis> {
	
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

}
