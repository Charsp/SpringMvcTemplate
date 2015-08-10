package com.swz.mysql.WeiXinApp.model;

import java.util.Date;
public class Mapping{
	private long idmapping;
	private boolean deleted;
	private String openid;
	private String loginid;
	private String loginpwd;
	private Date binddate;
	public void setIdmapping(long idmapping){
		this.idmapping = idmapping;
	}
	public long getIdmapping(){
		return idmapping;
	}
	public void setDeleted(boolean deleted){
		this.deleted = deleted;
	}
	public boolean getDeleted(){
		return deleted;
	}
	public void setOpenid(String openid){
		this.openid = openid;
	}
	public String getOpenid(){
		return openid;
	}
	public void setLoginid(String loginid){
		this.loginid = loginid;
	}
	public String getLoginid(){
		return loginid;
	}
	public void setLoginpwd(String loginpwd){
		this.loginpwd = loginpwd;
	}
	public String getLoginpwd(){
		return loginpwd;
	}
	public void setBinddate(Date binddate){
		this.binddate = binddate;
	}
	public Date getBinddate(){
		return binddate;
	}
}

