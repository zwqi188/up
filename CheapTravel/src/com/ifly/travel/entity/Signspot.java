package com.ifly.travel.entity;

public class Signspot {
    public Signspot(int spotid, String spotname) {
		super();
		this.spotid = spotid;
		this.spotname = spotname;
	}
	private int spotid;
    private String spotname;
    private String city;
    private int price;
    private String spotimg;
	public int getSpotid() {
		return spotid;
	}
	public void setSpotid(int spotid) {
		this.spotid = spotid;
	}
	public String getSpotname() {
		return spotname;
	}
	public void setSpotname(String spotname) {
		this.spotname = spotname;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getSpotimg() {
		return spotimg;
	}
	public void setSpotimg(String spotimg) {
		this.spotimg = spotimg;
	}
	public Signspot(int spotid, String spotname,  String city,
			int price, String spotimg) {
		super();
		this.spotid = spotid;
		this.spotname = spotname;
		
		this.city = city;
		this.price = price;
		this.spotimg = spotimg;
	}
	public Signspot(String spotname,  String city,
			int price, String spotimg) {
		super();
		this.spotname = spotname;
		
		this.city = city;
		this.price = price;
		this.spotimg = spotimg;
	}
	public Signspot() {
		super();
	}
    
    
}
