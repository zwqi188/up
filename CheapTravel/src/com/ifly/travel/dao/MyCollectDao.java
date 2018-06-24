package com.ifly.travel.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ifly.travel.entity.MyCollect;
import com.ifly.travel.entity.MyCollectView;
import com.ifly.travel.entity.MyShare;
import com.ifly.travel.entity.Npassanger;
import com.ifly.travel.util.DBUtil;



public class MyCollectDao {
private DBUtil dbUtil = new DBUtil();
public List<MyCollectView> getAllMyCollectView(){
	List<MyCollectView> collectsview=new ArrayList<MyCollectView>();
	String strsql="select * from mycollectview";
	ResultSet rs= dbUtil.query(strsql, null);
	try {
		while(rs.next()){
			MyCollectView collectview=new MyCollectView(rs.getInt("collectid"),rs.getDate("collecttime"),rs.getString("themename"),rs.getString("content"),rs.getString("shareimg"),rs.getInt("likecount"));
			collectsview.add(collectview);
		}
	} catch (SQLException e) {
		
	}
	return collectsview;
}
	
	public List<MyCollect> getAllMyCollect(){
		List<MyCollect> collects=new ArrayList<MyCollect>();
		String strsql="select * from mycollect";
		ResultSet rs= dbUtil.query(strsql, null);
		try {
			while(rs.next()){
				MyCollect collect=new MyCollect(rs.getInt("collectid"),rs.getInt("userid"), rs.getInt("shareid"), rs.getDate("collecttime"));
				collects.add(collect);
			}
		} catch (SQLException e) {
			
		}
		return collects;
	}


	public MyShare getMyShare(int shareid) {
		String strsql="select * from myshare where shareid=?";
		ResultSet rs = dbUtil.query(strsql, shareid);
		MyShare share = null;
		try {
			while (rs.next()) {
				share=new MyShare(rs.getString("themename"),rs.getString("content"),rs.getString("shareimg"),rs.getInt("likecount"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return share;
	}
	public void delMyCollect(int checksno) {
		String strSql = "delete from mycollect where collectid=?";
		dbUtil.update(strSql, checksno);
	}

}
