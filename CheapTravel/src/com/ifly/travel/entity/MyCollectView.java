package com.ifly.travel.entity;

import java.util.Date;

public class MyCollectView {
	private int collectid;
	

	private Date collecttime;

	private String themename;
	private String content;
	private String shareimg;
	private int likecount;

	public MyCollectView() {
		// TODO Auto-generated constructor stub
	}

	public MyCollectView(int collectid,Date collecttime, String themename, String content,
			String shareimg, int likecount) {
		super();
		this.collectid = collectid;
		this.collecttime = collecttime;
		this.themename = themename;
		this.content = content;
		this.shareimg = shareimg;
		this.likecount = likecount;
	}

	public int getCollectid() {
		return collectid;
	}

	public void setCollectid(int collectid) {
		this.collectid = collectid;
	}
	public Date getCollecttime() {
		return collecttime;
	}

	public void setCollecttime(Date collecttime) {
		this.collecttime = collecttime;
	}

	public String getThemename() {
		return themename;
	}

	public void setThemename(String themename) {
		this.themename = themename;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getShareimg() {
		return shareimg;
	}

	public void setShareimg(String shareimg) {
		this.shareimg = shareimg;
	}

	public int getLikecount() {
		return likecount;
	}

	public void setLikecount(int likecount) {
		this.likecount = likecount;
	}

}
