package com.ifly.travel.entity;


import java.util.Date;

public class MyCollect {
	private int collectid;
	private int userid;
	private int shareid;
	private Date collecttime;
	
	public MyCollect() {
		// TODO Auto-generated constructor stub
	}
	public MyCollect( int userid, int shareid, Date collecttime) {
		super();
		this.userid = userid;
		this.shareid = shareid;
		this.collecttime = collecttime;
	}

	public MyCollect(int collectid, int userid, int shareid, Date collecttime) {
		super();
		this.collectid = collectid;
		this.userid = userid;
		this.shareid = shareid;
		this.collecttime = collecttime;
	}

	public int getCollectid() {
		return collectid;
	}

	public void setCollectid(int collectid) {
		this.collectid = collectid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getShareid() {
		return shareid;
	}

	public void setShareid(int shareid) {
		this.shareid = shareid;
	}

	public Date getCollecttime() {
		return collecttime;
	}

	public void setCollecttime(Date collecttime) {
		this.collecttime = collecttime;
	}
	

}
