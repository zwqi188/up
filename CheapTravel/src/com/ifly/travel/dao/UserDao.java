package com.ifly.travel.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;

import com.ifly.travel.entity.User;
import com.ifly.travel.util.DBUtil;

public class UserDao {
	DBUtil dbUtil = DBUtil.getInstance();
	
	public int getUserId(String userName){
		int userid=0;
		CachedRowSet crs=dbUtil.query("select userid from users where username=?", userName);
		try {
			while(crs.next()){
				userid=crs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userid;
	}
	
	public User getUserByName(String userName){
		User user = null;
		CachedRowSet crs=dbUtil.query("select * from users where username=?", userName);
		try {
			while(crs.next()){
				user=new User(crs.getInt("userid"),crs.getString("username"), crs.getString("userpassword"), crs.getString("realname"), crs.getString("telephone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public User getUser(String userName){
		User user=null;
		CachedRowSet crs=dbUtil.query("select * from users where username=?", userName);
		try {
			while(crs.next()){
				user=new User(crs.getInt("userid"),crs.getString("username"), crs.getString("userpassword"), crs.getString("realname"), crs.getString("telephone"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
    
	
	public List<User> getAllUser(){
		List<User> users=new ArrayList<User>();
		String strsql="select * from users";
		ResultSet rs=null;
		try {
			Statement statement=DBUtil.getInstance().getConnection().createStatement();
			rs=statement.executeQuery(strsql);
			while(rs.next()){
				User user=new User(rs.getInt("userid"), rs.getString("username"), rs.getString("userpassword"), rs.getString("realname"), rs.getString("telephone"));
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return users;
	}
	
	public void addUser(User user) {
		dbUtil.insert("insert into users values(?,?,?,?,?)", "",
				user.getUserName(), user.getRealName(), user.getUserPassword(),
				user.getTelphone());
	}

	public void updateUser(User user) {
		dbUtil.update("update users set userpassword=?,realname=?,telephone=? where userid=?",
				user.getUserPassword(), user.getRealName(), user.getTelphone(),user.getUserId());
	}
	
	public boolean isExists(String userName, String userPassword){
		CachedRowSet crs=dbUtil.query("select count(*) from users where username=? and userpassword=?", userName,userPassword);
		try {
			while(crs.next()){
				if(crs.getInt(1)>0){
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
}
