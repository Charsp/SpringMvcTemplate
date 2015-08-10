package com.swz.mysql.gps.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usermain_vehiclegroup")
public class Usermain_vehiclegroup {
	@Id
	private int UserMain_Veh_ID;
	private int UserID;
	private int VehicleGroupID;

//	@OneToMany
//	@JoinColumn(name = "VehicleGroupID")
//	private Set<Vehicle> vehicles = new HashSet<Vehicle>();

	public void setUserMain_Veh_ID(int UserMain_Veh_ID) {
		this.UserMain_Veh_ID = UserMain_Veh_ID;
	}

	public int getUserMain_Veh_ID() {
		return UserMain_Veh_ID;
	}

	public void setUserID(int UserID) {
		this.UserID = UserID;
	}

	public int getUserID() {
		return UserID;
	}

	public void setVehicleGroupID(int VehicleGroupID) {
		this.VehicleGroupID = VehicleGroupID;
	}

	public int getVehicleGroupID() {
		return VehicleGroupID;
	}
}
