package com.BatDongSan.Model;

public class NewsModel extends AbstractModel{
	private String title;
	private String thumNail;
	private String shortDescription;
	private String content;
	private long categoryId;
	
	
	public long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getThumNail() {
		return thumNail;
	}
	public void setThumNail(String thumNail) {
		this.thumNail = thumNail;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	
	
}	
