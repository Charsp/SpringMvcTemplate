package com.swz.mysql.gps.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vehiclegroup")
public class Vehiclegroup {
	@Id
	private int id;
	private String vehicleTeam_name;
	private String vehicleTeam_contactPerson;
	private String vehTeam_phoneNum1;
	private String vehTeam_phoneNum2;
	private String comment;
	private byte isdelete;
	private String userMains;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setVehicleTeam_name(String vehicleTeam_name) {
		this.vehicleTeam_name = vehicleTeam_name;
	}

	public String getVehicleTeam_name() {
		return vehicleTeam_name;
	}

	public void setVehicleTeam_contactPerson(String vehicleTeam_contactPerson) {
		this.vehicleTeam_contactPerson = vehicleTeam_contactPerson;
	}

	public String getVehicleTeam_contactPerson() {
		return vehicleTeam_contactPerson;
	}

	public void setVehTeam_phoneNum1(String vehTeam_phoneNum1) {
		this.vehTeam_phoneNum1 = vehTeam_phoneNum1;
	}

	public String getVehTeam_phoneNum1() {
		return vehTeam_phoneNum1;
	}

	public void setVehTeam_phoneNum2(String vehTeam_phoneNum2) {
		this.vehTeam_phoneNum2 = vehTeam_phoneNum2;
	}

	public String getVehTeam_phoneNum2() {
		return vehTeam_phoneNum2;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getComment() {
		return comment;
	}

	public void setIsdelete(byte isdelete) {
		this.isdelete = isdelete;
	}

	public byte getIsdelete() {
		return isdelete;
	}

	public void setUserMains(String userMains) {
		this.userMains = userMains;
	}

	public String getUserMains() {
		return userMains;
	}
}
