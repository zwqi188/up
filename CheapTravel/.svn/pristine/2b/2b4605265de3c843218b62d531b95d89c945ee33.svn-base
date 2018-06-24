package com.ifly.travel.dao;

import com.ifly.travel.util.DBUtil;

public class CollectDao {
	DBUtil dbUtil=DBUtil.getInstance();
	
	public void addCollect(int userid, int shareid){
		dbUtil.insert("insert into MYCOLLECT(userid,shareid,collecttime) values(?,?,sysdate)", userid,shareid);
	}
	
}
