package com.ifly.travel.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.ifly.travel.entity.Npassanger;
import com.ifly.travel.util.DBUtil;

public class NpassangerDao {
	private DBUtil dbUtil = new DBUtil();
	private UserDao userDao=new UserDao();
	
	public List<Npassanger> getAllNpassanger(){
		List<Npassanger> passangers=new ArrayList<Npassanger>();
		String strsql="select * from npassanger";
		ResultSet rs= dbUtil.query(strsql, null);
		try {
			while(rs.next()){
				Npassanger passanger=new Npassanger(rs.getInt("passangerid"),rs.getInt("userid"), rs.getString("passangername"), rs.getString("passangerphone"), rs.getString("papertype"), rs.getString("papernumber"));
				passangers.add(passanger);
			}
		} catch (SQLException e) {
			
		}
		return passangers;
	}
	
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
	
	public List<Npassanger> getNpassangerBypage(int userid,int page, int pagesize) {
		List<Npassanger> passangers = new ArrayList<Npassanger>();
		String strSql = "select * from "
				+ "(select a.* ,rownum as rowno  from (select * from npassanger where userid=? order by passangerid desc ) a)"
				+ " where rowno between ? and ?  order by passangerid desc";
		ResultSet rs = dbUtil.query(strSql,userid,pagesize*(page-1)+1 ,pagesize*page);
		try {
			while (rs.next()) {
				Npassanger passanger=new Npassanger(rs.getInt("passangerid"),rs.getInt("userid"), rs.getString("passangername"), rs.getString("passangerphone"), rs.getString("papertype"), rs.getString("papernumber"));
				passangers.add(passanger);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return passangers;
	}
	public int getNpassangerCount() {
		int count = 0;
		String strSql = "select count(*) from npassanger ";
		ResultSet rs = dbUtil.query(strSql, null);
		try {
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public void delNpassanger(int checksno) {
		String strSql = "delete from npassanger where passangerid=?";
		dbUtil.update(strSql, checksno);
	}
	
	public void addNpassanger(Npassanger p) {
		String strSql = "insert into npassanger(passangerid,userid,passangername,passangerphone,papertype,papernumber) values(?,?,?,?,?,?)";
		dbUtil.insert(strSql, p.getPassangerid(),p.getUserid(),p.getPassangername(),p.getPassangerphone(),p.getPapertype(),p.getPapernumber());
	}
	
	public Npassanger lookNpassanger(int lookid) {
		String strSql = "select * from npassanger where passangerid=?";
		ResultSet rs = dbUtil.query(strSql, lookid);
		Npassanger passanger = null;
		try {
			while (rs.next()) {
				passanger=new Npassanger(rs.getInt("passangerid"),rs.getInt("userid"), rs.getString("passangername"), rs.getString("passangerphone"), rs.getString("papertype"), rs.getString("papernumber"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return passanger;
	}
	public void updatePassanger(Npassanger p) {
		String strSql = "update  npassanger set  passangername=?, passangerphone=?, papertype=?, papernumber=? where passangerid=?";
		dbUtil.update(strSql, p.getPassangername(),p.getPassangerphone(),p.getPapertype(),p.getPapernumber(), p.getPassangerid());
	}
}
