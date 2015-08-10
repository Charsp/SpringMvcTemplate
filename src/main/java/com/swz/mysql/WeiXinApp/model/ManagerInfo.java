package com.swz.mysql.WeiXinApp.model;

import java.util.Date;
public class ManagerInfo{
	private int idmanagerInfo;
	private String province;
	private String city;
	private String department;
	private String idstaff;
	private String name;
	private String password;
	private String permission;
	private Date datetime;
	public void setIdmanagerInfo(int idmanagerInfo){
		this.idmanagerInfo = idmanagerInfo;
	}
	public int getIdmanagerInfo(){
		return idmanagerInfo;
	}
	public void setProvince(String province){
		this.province = province;
	}
	public String getProvince(){
		return province;
	}
	public void setCity(String city){
		this.city = city;
	}
	public String getCity(){
		return city;
	}
	public void setDepartment(String department){
		this.department = department;
	}
	public String getDepartment(){
		return department;
	}
	public void setIdstaff(String idstaff){
		this.idstaff = idstaff;
	}
	public String getIdstaff(){
		return idstaff;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public String getPassword(){
		return password;
	}
	public void setPermission(String permission){
		this.permission = permission;
	}
	public String getPermission(){
		return permission;
	}
	public void setDatetime(Date datetime){
		this.datetime = datetime;
	}
	public Date getDatetime(){
		return datetime;
	}
}

