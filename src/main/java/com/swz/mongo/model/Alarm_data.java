package com.swz.mongo.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Alarm_data {
	@Id
	private String id;
	private Date alarmtime;

	public Date getAlarmtime() {
		return alarmtime;
	}

	public void setAlarmtime(Date alarmtime) {
		this.alarmtime = alarmtime;
	}

	private int angle;

	public int getAngle() {
		return this.angle;
	}

	public void setAngle(int angle) {
		this.angle = angle;
	}

	private String area_0;

	public String getArea_0() {
		return this.area_0;
	}

	public void setArea_0(String area_0) {
		this.area_0 = area_0;
	}

	private String area_1;

	public String getArea_1() {
		return this.area_1;
	}

	public void setArea_1(String area_1) {
		this.area_1 = area_1;
	}

	private String area_2;

	public String getArea_2() {
		return this.area_2;
	}

	public void setArea_2(String area_2) {
		this.area_2 = area_2;
	}

	private String car_id;

	public String getCar_id() {
		return this.car_id;
	}

	public void setCar_id(String car_id) {
		this.car_id = car_id;
	}

	private String car_no;

	public String getCar_no() {
		return this.car_no;
	}

	public void setCar_no(String car_no) {
		this.car_no = car_no;
	}

	private String car_object_id;

	public String getCar_object_id() {
		return this.car_object_id;
	}

	public void setCar_object_id(String car_object_id) {
		this.car_object_id = car_object_id;
	}

	private int code;

	public int getCode() {
		return this.code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	private String handle_user;

	public String getHandle_user() {
		return this.handle_user;
	}

	public void setHandle_user(String handle_user) {
		this.handle_user = handle_user;
	}

	private String ip;

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	private int limitvalue;

	public int getLimitvalue() {
		return this.limitvalue;
	}

	public void setLimitvalue(int limitvalue) {
		this.limitvalue = limitvalue;
	}

	private int statue;

	public int getStatue() {
		return this.statue;
	}

	public void setStatue(int statue) {
		this.statue = statue;
	}

	private Date updatetime;

	private int vehideid;

	public int getVehideid() {
		return this.vehideid;
	}

	public void setVehideid(int vehideid) {
		this.vehideid = vehideid;
	}

	private int velocity;

	public int getVelocity() {
		return this.velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	private Double x;

	public Double getX() {
		return this.x;
	}

	public void setX(Double x) {
		this.x = x;
	}

	private Double y;

	public Double getY() {
		return this.y;
	}

	public void setY(Double y) {
		this.y = y;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
}