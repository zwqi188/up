package com.ifly.travel.entity;

import java.io.Serializable;
import java.util.Date;

public class MyShare implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int shareid;
	private int userid;
	private String themename;
	private int spotid;
	private String content;
	private String shareimg;
	private int likecount;
	private Date sharetime;
	private String mydate;
	
	public int getShareid() {
		return shareid;
	}
	public void setShareid(int shareid) {
		this.shareid = shareid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getThemename() {
		return themename;
	}
	public void setThemename(String themename) {
		this.themename = themename;
	}
	public int getSpotid() {
		return spotid;
	}
	public void setSpotid(int spotid) {
		this.spotid = spotid;
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
	public Date getSharetime() {
		return sharetime;
	}
	public void setSharetime(Date sharetime) {
		this.sharetime = sharetime;
	}
	public MyShare(int shareid, int userid, String themename, int spotid,
			String content, String shareimg, int likecount, Date sharetime) {
		super();
		this.shareid = shareid;
		this.userid = userid;
		this.themename = themename;
		this.spotid = spotid;
		this.content = content;
		this.shareimg = shareimg;
		this.likecount = likecount;
		this.sharetime = sharetime;
	}

	public MyShare(String themename, String content, String shareimg,
			int likecount) {
		super();
		this.themename = themename;
		this.content = content;
		this.shareimg = shareimg;
		this.likecount = likecount;
	}

	public MyShare(int shareid,String shareimg, int likecount, String mydate) {

		super();
		this.shareid=shareid;
		this.shareimg = shareimg;
		this.likecount = likecount;
		this.mydate=mydate;
	}
	public MyShare(int userid, String themename, int spotid, String content,
			String shareimg, int likecount, Date sharetime) {
		super();
		this.userid = userid;
		this.themename = themename;
		this.spotid = spotid;
		this.content = content;
		this.shareimg = shareimg;
		this.likecount = likecount;
		this.sharetime = sharetime;
	}
	public MyShare() {
		super();
	}
	public String getMydate() {
		return mydate;
	}
	public void setMydate(String mydate) {
		this.mydate = mydate;
	}
	
	

}
