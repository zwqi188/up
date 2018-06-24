package com.ifly.travel.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.ifly.travel.entity.MyShare;
import com.ifly.travel.util.DBUtil;

public class ShareDao {
	DBUtil dbUtil=DBUtil.getInstance();
	
	public int getShareId(String shareimg){
		int shareid=0;
		CachedRowSet crs=dbUtil.query("select shareid from myshare where shareimg=?",shareimg);
		try {
			while(crs.next()){
				shareid=crs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shareid;
	}
	
	public MyShare getShareById(int shareId){
		MyShare myShare = null;
		ResultSet rs=dbUtil.query("select * from myshare where shareid=?",shareId);
		try {
			while(rs.next()){
				String dateStr = rs.getString("sharetime");
				Date sharetime = new Date(dateStr.replace("-", "/"));
				myShare = new MyShare(rs.getInt("shareid"), rs.getInt("userid"), rs.getString("themename"), rs.getInt("spotid"), rs.getString("content"), rs.getString("shareimg"), rs.getInt("likecount"), sharetime);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myShare;
	}
	
	public List<MyShare> getMySharesByDate(int start, int end){
		List<MyShare> myShares=new ArrayList<MyShare>();
		CachedRowSet crs=dbUtil.query("select shareid,shareimg,likecount,to_char(sharetime,'yyyy-mm-dd') from (select s.*,rownum rowno from (select * from myshare order by sharetime desc)s) where rowno between ? and ?", start,end);
		try {
			while(crs.next()){
				myShares.add(new MyShare(crs.getInt("shareid"),crs.getString("shareimg"), crs.getInt("likecount"), crs.getString(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myShares;
	}
	
	public List<MyShare> getMySharesByNum(int start, int end){
		List<MyShare> myShares=new ArrayList<MyShare>();
		CachedRowSet crs=dbUtil.query("select shareid,shareimg,likecount,to_char(sharetime,'yyyy-mm-dd') from (select s.*,rownum rowno from (select * from myshare order by likecount desc)s) where rowno between ? and ?", start,end);
		try {
			while(crs.next()){
				myShares.add(new MyShare(crs.getInt("shareid"),crs.getString("shareimg"), crs.getInt("likecount"), crs.getString(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return myShares;
	}
	
	public List<MyShare> getAllMyShares() {
		List<MyShare> allMyShares = new ArrayList<MyShare>();
		String strSql = "select * from myshare";
		ResultSet rs = dbUtil.query(strSql, null);
		try {
			while(rs.next()){
				String dateStr = rs.getString("sharetime");
				Date sharetime = new Date(dateStr.replace("-", "/"));
				allMyShares.add(new MyShare(rs.getInt("shareid"), rs.getInt("userid"), rs.getString("themename"), rs.getInt("spotid"), rs.getString("content"), rs.getString("shareimg"), rs.getInt("likecount"), sharetime));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allMyShares;
	}
	
	public void addShare(Object...params) {
		String strSql = "insert into myshare(userid,themename,spotid,content,shareimg,likecount,sharetime) values(?,?,?,?,?,?,to_date(?,'yyyy-mi-dd'))";
		dbUtil.insert(strSql, params);
	}
	
	public void delMyShareById(int shareId) {
		String strSql = "delete from myshare where shareid=?";
		dbUtil.update(strSql, shareId);
	}
	
	public void updateShare(String imgpath,int likecount){
		dbUtil.update("update myshare set likecount=? where shareimg=?",likecount+1,imgpath);
		System.out.println("likecount add success");
	}
	
}
