package com.swz.vo.model;

import java.util.List;

public class VehicleInfo {
	
	private String groupName;
	private List<Integer> vehicleId, vehicleNum;

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<Integer> getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(List<Integer> vehicleId) {
		this.vehicleId = vehicleId;
	}

	public List<Integer> getVehicleNum() {
		return vehicleNum;
	}

	public void setVehicleNum(List<Integer> vehicleNum) {
		this.vehicleNum = vehicleNum;
	}
}
