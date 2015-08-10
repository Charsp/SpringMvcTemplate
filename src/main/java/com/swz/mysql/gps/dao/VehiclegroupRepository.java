package com.swz.mysql.gps.dao;

import java.util.List;

import com.swz.mysql.gps.model.Vehiclegroup;

public interface VehiclegroupRepository {
	/**
	 * 查询用户组信息
	 * 
	 * @param groupList
	 * @return
	 */

	public List<Vehiclegroup> queryVehiclegroups(List<Integer> groupList);
}
