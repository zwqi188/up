package com.ifly.travel.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ifly.travel.entity.IndentView;
import com.ifly.travel.util.DBUtil;

public class IndentViewDao {
	DBUtil dbUtil = DBUtil.getInstance();
	
	public List<IndentView> getIndentsBypage(String realName, int page, int pagesize) {
		List<IndentView> indents = new ArrayList<IndentView>();
		String strSql = "select * from "
				+ "(select a.* ,rownum as rowno  from (select * from showindent where realname=? order by indentid desc) a)"
				+ " where rowno between ? and ? ";
		ResultSet rs=dbUtil.query(strSql,realName,(page-1)*pagesize+1,page*pagesize);
		try {
			while(rs.next()){
				String dateStr = rs.getString("buyDate").toString();
				Date buyDate = new Date(dateStr.replace("-", "/"));
				indents.add(new IndentView(rs.getInt("indentid"), rs.getString("realname"),
						rs.getString("telephone"), rs.getString("spotname"),rs.getString("passangername") , rs.getInt("price"), rs.getInt("allprice"), buyDate, rs.getInt("travelnum")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return indents;
	}
	
	public void createQueryView(String passangerName) {
		String strSql = "create or replace view queryindent as select * from showindent where passangername=? order by indentid desc";
		dbUtil.update(strSql, passangerName);
	}
	
	public List<IndentView> getQueryIndentsBypage(String realName,int page, int pagesize,String passangerName) {
		List<IndentView> indents = new ArrayList<IndentView>();
		String strSql = "select * from "
				+ "(select a.* ,rownum as rowno  from (select * from showindent where realname=? and passangername=? order by indentid desc) a)"
				+ " where rowno between ? and ? ";
		ResultSet rs=dbUtil.query(strSql,realName,passangerName,pagesize*(page-1)+1,page*pagesize);
		try {
			while(rs.next()){
				String dateStr = rs.getString("buyDate").toString();
				Date buyDate = new Date(dateStr.replace("-", "/"));
				indents.add(new IndentView(rs.getInt("indentid"), rs.getString("realname"),
						rs.getString("telephone"), rs.getString("spotname"),rs.getString("passangername") , rs.getInt("price"), rs.getInt("allprice"), buyDate, rs.getInt("travelnum")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return indents;
	}
	
	public List<IndentView> queryIndents(String passangerName) {
		List<IndentView> indents = new ArrayList<IndentView>();
		String strSql = "select * from showindent where passangername=?";
		ResultSet rs=dbUtil.query(strSql, passangerName);
		try {
			while(rs.next()){
				String dateStr = rs.getString("buyDate").toString();
				Date buyDate = new Date(dateStr.replace("-", "/"));
				indents.add(new IndentView(rs.getInt("indentid"), rs.getString("realname"),
						rs.getString("telephone"), rs.getString("spotname"),rs.getString("passangername") , rs.getInt("price"), rs.getInt("allprice"), buyDate, rs.getInt("travelnum")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return indents;
	}
	
	public List<IndentView> queryIndentsById(String passangerName) {
		List<IndentView> indents = new ArrayList<IndentView>();
		String strSql = "select * from (select i.*,rownum as rowno from (select * from showindent where passangername=? order by indentid desc)i) where rowno=1";
		ResultSet rs=dbUtil.query(strSql, passangerName);
		try {
			while(rs.next()){
				String dateStr = rs.getString("buyDate").toString();
				Date buyDate = new Date(dateStr.replace("-", "/"));
				indents.add(new IndentView(rs.getInt("indentid"), rs.getString("realname"),
						rs.getString("telephone"), rs.getString("spotname"),rs.getString("passangername") , rs.getInt("price"), rs.getInt("allprice"), buyDate, rs.getInt("travelnum")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return indents;
	}
	
	public int getAllIndents() {
		String strSql = ("select count(*) from showindent where 1=?");
		ResultSet rs=dbUtil.query(strSql,1);
		int count = 0;
		try {
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	public int getQueryAllIndents(String passangerName) {
		String strSql = ("select count(*) from showindent where passangername=? and 1=?");
		ResultSet rs=dbUtil.query(strSql,passangerName,1);
		int count = 0;
		try {
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}
