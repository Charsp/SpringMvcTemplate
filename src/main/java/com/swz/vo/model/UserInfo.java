package com.swz.vo.model;

import java.util.List;

public class UserInfo {
	private String username;
	private String password;
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private List<Integer> car_object_id;
	private List<Integer> groupid;
	private List<String> car_no;

	public List<String> getCar_no() {
		return car_no;
	}

	public void setCar_no(List<String> car_no) {
		this.car_no = car_no;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Integer> getCar_object_id() {
		return car_object_id;
	}

	public void setCar_object_id(List<Integer> car_object_id) {
		this.car_object_id = car_object_id;
	}

	public List<Integer> getGroupid() {
		return groupid;
	}

	public void setGroupid(List<Integer> groupid) {
		this.groupid = groupid;
	}
}
