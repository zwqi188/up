package com.ifly.travel.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.ifly.travel.entity.Indent;
import com.ifly.travel.util.DBUtil;

public class IndentDao {
	DBUtil dbUtil = DBUtil.getInstance();

	public void addIndent(String spotName, int userId) {
		List<Integer> ticketids = getTicketId(spotName);
		for (int i = 0; i < ticketids.size(); i++) {
			if(!isExists(ticketids.get(i))){
				dbUtil.insert("insert into indent(userid,ticketid) values(?,?)",
						userId, ticketids.get(i));
			}
		}
	}
	
	public List<Indent> getIndentsBypage(int page, int pagesize) {
		List<Indent> orders = new ArrayList<Indent>();
		String strSql = "select * from "
				+ "(select a.* ,rownum as rowno  from (select * from indent order by indentid desc) a)"
				+ " where rowno between ? and ? ";
		ResultSet rs=dbUtil.query(strSql, page,pagesize);
		try {
			while(rs.next()){
				orders.add(new Indent(rs.getInt("indentid"), rs.getInt("userid"), rs.getInt("ticketid")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders;
	}
	
	public void delIndent(int indentId) {
		String strSql = ("delete from indent where indentid = ?");
		dbUtil.delete(strSql, indentId);
	}
	
	public int getAllIndents() {
		String strSql = ("select count(*) from indent where 1=?");
		ResultSet rs=dbUtil.query(strSql,1);
		int count = 0;
		try {
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	private boolean isExists(int ticketid){
		CachedRowSet crs = dbUtil.query("select count(*) from indent where ticketid=?",ticketid);
		try {
			if(crs.next()&&crs.getInt(1)>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	private List<Integer> getTicketId(String spotName) {
		List<Integer> ticketids = new ArrayList<Integer>();
		CachedRowSet crs = dbUtil
				.query("select ticketid from ticket,signspot where ticket.spotid=signspot.spotid and signspot.spotname=?",
						spotName);
		try {
			while (crs.next()) {
				ticketids.add(crs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ticketids;

	}

}
