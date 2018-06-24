package com.ifly.travel.entity;


public class Npassanger {
     private int passangerid;
     private int userid;
     private String passangername;
     private String passangerphone;
     private String papertype;
     private String papernumber;
	public int getPassangerid() {
		return passangerid;
	}
	public void setPassangerid(int passangerid) {
		this.passangerid = passangerid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getPassangername() {
		return passangername;
	}
	public void setPassangername(String passangername) {
		this.passangername = passangername;
	}
	public String getPassangerphone() {
		return passangerphone;
	}
	public void setPassangerphone(String passangerphone) {
		this.passangerphone = passangerphone;
	}
	public String getPapertype() {
		return papertype;
	}
	public void setPapertype(String papgertype) {
		this.papertype = papgertype;
	}
	public String getPapernumber() {
		return papernumber;
	}
	public void setPapernumber(String papernumber) {
		this.papernumber = papernumber;
	}
	public Npassanger(int passangerid, int userid, String passangername,
			String passangerphone, String papertype, String papernumber) {
		super();
		this.passangerid = passangerid;
		this.userid = userid;
		this.passangername = passangername;
		this.passangerphone = passangerphone;
		this.papertype = papertype;
		this.papernumber = papernumber;
	}
	public Npassanger(int userid, String passangername, String passangerphone,
			String papertype, String papernumber) {
		super();
		this.userid = userid;
		this.passangername = passangername;
		this.passangerphone = passangerphone;
		this.papertype = papertype;
		this.papernumber = papernumber;
	}
	
	public Npassanger() {
		super();
	}
     
     
     
	
}
