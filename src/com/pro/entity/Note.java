package com.pro.entity;

import com.sys.common.BaseEntity;

public class Note extends BaseEntity<Note> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	private String title;
	private String content;
	private String postDate;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
}
