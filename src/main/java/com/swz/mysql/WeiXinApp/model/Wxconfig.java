package com.swz.mysql.WeiXinApp.model;

import java.util.Date;

public class Wxconfig{
	private int idsysconfig;
	private String dataname;
	private String type;
	private String value;
	private Date datetime;
	public void setIdsysconfig(int idsysconfig){
		this.idsysconfig = idsysconfig;
	}
	public int getIdsysconfig(){
		return idsysconfig;
	}
	public void setDataname(String dataname){
		this.dataname = dataname;
	}
	public String getDataname(){
		return dataname;
	}
	public void setType(String type){
		this.type = type;
	}
	public String getType(){
		return type;
	}
	public void setValue(String value){
		this.value = value;
	}
	public String getValue(){
		return value;
	}
	public void setDatetime(Date datetime){
		this.datetime = datetime;
	}
	public Date getDatetime(){
		return datetime;
	}
}

