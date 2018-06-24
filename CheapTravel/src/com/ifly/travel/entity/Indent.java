package com.ifly.travel.entity;

public class Indent {
	
	private int indentid;
	private int userid;
	private int ticketid;
	public int getIndentid() {
		return indentid;
	}
	public void setIndentid(int indentid) {
		this.indentid = indentid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getTicketid() {
		return ticketid;
	}
	public void setTicketid(int ticketid) {
		this.ticketid = ticketid;
	}
	public Indent(int indentid, int userid, int ticketid) {
		super();
		this.indentid = indentid;
		this.userid = userid;
		this.ticketid = ticketid;
	}
	public Indent(int userid, int ticketid) {
		super();
		this.userid = userid;
		this.ticketid = ticketid;
	}
	public Indent() {
		super();
	}
   
	
	
}
