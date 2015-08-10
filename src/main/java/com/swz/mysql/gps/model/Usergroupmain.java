package com.swz.mysql.gps.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usergroupmain")
public class Usergroupmain {
	@Id
	private int UserGroupID;
	private String UserGroupName;
	private String UserGroupMemo;
	private byte DelFlag;
	private Date CreateTime;
	private Date UpdateTime;
	private String FuncMains;

	public void setUserGroupID(int UserGroupID) {
		this.UserGroupID = UserGroupID;
	}

	public int getUserGroupID() {
		return UserGroupID;
	}

	public void setUserGroupName(String UserGroupName) {
		this.UserGroupName = UserGroupName;
	}

	public String getUserGroupName() {
		return UserGroupName;
	}

	public void setUserGroupMemo(String UserGroupMemo) {
		this.UserGroupMemo = UserGroupMemo;
	}

	public String getUserGroupMemo() {
		return UserGroupMemo;
	}

	public void setDelFlag(byte DelFlag) {
		this.DelFlag = DelFlag;
	}

	public byte getDelFlag() {
		return DelFlag;
	}

	public void setCreateTime(Date CreateTime) {
		this.CreateTime = CreateTime;
	}

	public Date getCreateTime() {
		return CreateTime;
	}

	public void setUpdateTime(Date UpdateTime) {
		this.UpdateTime = UpdateTime;
	}

	public Date getUpdateTime() {
		return UpdateTime;
	}

	public void setFuncMains(String FuncMains) {
		this.FuncMains = FuncMains;
	}

	public String getFuncMains() {
		return FuncMains;
	}
}
