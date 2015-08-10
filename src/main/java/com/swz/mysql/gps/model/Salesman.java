package com.swz.mysql.gps.model;

public class Salesman{
	private int salesid;
	private String username;
	private String tel;
	public void setSalesid(int salesid){
		this.salesid = salesid;
	}
	public int getSalesid(){
		return salesid;
	}
	public void setUsername(String username){
		this.username = username;
	}
	public String getUsername(){
		return username;
	}
	public void setTel(String tel){
		this.tel = tel;
	}
	public String getTel(){
		return tel;
	}
}

