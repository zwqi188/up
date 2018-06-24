package com.ifly.travel.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.ifly.travel.entity.Signspot;
import com.ifly.travel.util.DBUtil;

public class SignSpotDao {
	DBUtil dbUtil=DBUtil.getInstance();
	
	public List<Signspot> getSignspots(){
		List<Signspot> signspots=new ArrayList<Signspot>();
		CachedRowSet crs=dbUtil.query("select * from signspot", null);
		try {
			while(crs.next()){
				signspots.add(new Signspot(crs.getString("spotname"), crs.getString("city"), crs.getInt("price"), crs.getString("spotimg")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return signspots;
	}
	
	public List<String> getAllCitys() {
		List<String> citys = new ArrayList<String>();
		String sqlStr = "select distinct(city) from signspot";
		ResultSet rs=dbUtil.query(sqlStr, null);
		try {
			while(rs.next()){
				citys.add(rs.getString("city"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return citys;
	}
	
	public Signspot getSignspot(String spotname){
		Signspot signspot=null;
		CachedRowSet crs=dbUtil.query("select * from signspot where spotname=?", spotname);
		try {
			while(crs.next()){
				signspot=new Signspot(crs.getString("spotname"), crs.getString("city"), crs.getInt("price"), crs.getString("spotimg"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return signspot;
	}
	public int getSignspotId(String spotname){
		int spotId=0;
		ResultSet rs=dbUtil.query("select spotid from signspot where spotname=?", spotname);
		try {
			if (rs.next()) {
				spotId = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return spotId;
	}
	public List<Signspot> getSignspotBySpotid(int spotid){
		List<Signspot> signspots = new ArrayList<Signspot>();
		CachedRowSet crs=dbUtil.query("select * from signspot where spotid=?", spotid);
		try {
			while(crs.next()){
				signspots.add(new Signspot(spotid,crs.getString("spotname"), crs.getString("city"), crs.getInt("price"), crs.getString("spotimg")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return signspots;
	}
	public List<Signspot> getSignspotByCityName(String cityName){
		List<Signspot> signspots = new ArrayList<Signspot>();
		CachedRowSet crs=dbUtil.query("select * from signspot where city=?", cityName);
		try {
			while(crs.next()){
				signspots.add(new Signspot(crs.getString("spotname"), crs.getString("city"), crs.getInt("price"), crs.getString("spotimg")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return signspots;
	}
	public List<Signspot> getSignspotByUserId(int userid){
		List<Signspot> signspots = new ArrayList<Signspot>();
		ResultSet rs=dbUtil.query("select spotid,spotname from shareview where userid=?", userid);
		try {
			while(rs.next()){
				signspots.add(new Signspot(rs.getInt("spotid"),rs.getString("spotname")));
			}
		} catch (SQLException e) {
			
		}
		return signspots;
	}
	
	public int getSpotId(String spotName) {
		int spotid = 0;
		CachedRowSet crs = dbUtil.query(
				"select spotid from signspot where spotname=?", spotName);
		try {
			while (crs.next()) {
				spotid = crs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return spotid;
	}
	public String getSpotName(int spotid) {
		String spotName = null;
		CachedRowSet crs = dbUtil.query(
				"select spotname from signspot where spotid=?", spotid);
		try {
			while (crs.next()) {
				spotName = crs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return spotName;
	}
}
