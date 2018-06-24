package com.ifly.travel.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.ifly.travel.util.DBUtil;

public class PassangerDao {
	DBUtil dbUtil=DBUtil.getInstance();
	UserDao userDao=new UserDao();
	
	public List<String> getPassanger(String userName){
		List<String> npassangers=new ArrayList<String>();
		int userId=userDao.getUserId(userName);
		System.out.println("userid--"+userId);
		CachedRowSet crs=dbUtil.query("select * from NPASSANGER where userid=?", userId);
		try {
			while(crs.next()){
				npassangers.add(crs.getString("passangername"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return npassangers;
		
	}
	
}	
