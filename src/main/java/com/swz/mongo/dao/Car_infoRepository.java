package com.swz.mongo.dao;

import java.util.List;

import com.swz.mongo.model.Car_info;

public interface Car_infoRepository {
	/**
	 * 通过车牌号码查询车辆信息
	 * 
	 * @param car_no
	 * @return
	 */
	public List<Car_info> findByCar_no(String car_no);

	/**
	 * 通过mysql对应车辆id查询车辆信息
	 * 
	 * @param vehideid
	 * @return
	 */
	public String findOneByVehideid(int vehideid);

	/**
	 * 保存(更新)车辆信息
	 * 
	 * @param car_info
	 */
	public void saveCar_info(Car_info car_info);
}
