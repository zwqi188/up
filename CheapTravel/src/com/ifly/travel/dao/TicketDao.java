package com.ifly.travel.dao;

import com.ifly.travel.util.DBUtil;

public class TicketDao {
	DBUtil dbUtil = DBUtil.getInstance();
	SignSpotDao signSpotDao=new SignSpotDao();

	/*public void addTicket(String spotName, int price,String date,int number,String passangername) {
		dbUtil.insert(
				"insert into ticket(spotid,price,buydate,travelnum,passangername) values(?,?,to_date(?,'yyyy/MM/dd'),?,?)",
				signSpotDao.getSpotId(spotName), price, date,number,passangername);
		System.out.println("add success");
	}*/
	
	public void addTicket(Object...params) {
		String strSql = "insert into ticket(spotid,price,buydate,travelnum,passangername) values(?,?,to_date(?,'yyyy/MM/dd'),?,?)";
		dbUtil.insert(strSql, params);
	}

	public void deleteTicket(int ticketid){
		dbUtil.delete("delete from ticket where ticketid=?", ticketid);
	}

}
