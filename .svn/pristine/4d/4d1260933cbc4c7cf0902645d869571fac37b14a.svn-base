package com.swz.service.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.swz.mongo.dao.impl.Car_infoRepositoryImpl;
import com.swz.mongo.dao.impl.Gps_dataRepositoryImpl;
import com.swz.mongo.model.Gps_data;

/**
 * 查询车辆位置(当前位置和历史轨迹)
 * 
 * @author Charsp
 *
 * @date 2014年11月5日
 */

@Repository
public class FindVehicleLocation {
	private Car_infoRepositoryImpl car_infoRepositoryImpl;
	private Gps_dataRepositoryImpl gps_dataRepositoryImpl;

	public Car_infoRepositoryImpl getCar_infoRepositoryImpl() {
		return car_infoRepositoryImpl;
	}

	@Resource
	public void setCar_infoRepositoryImpl(
			Car_infoRepositoryImpl car_infoRepositoryImpl) {
		this.car_infoRepositoryImpl = car_infoRepositoryImpl;
	}

	public Gps_dataRepositoryImpl getGps_dataRepositoryImpl() {
		return gps_dataRepositoryImpl;
	}

	@Resource
	public void setGps_dataRepositoryImpl(
			Gps_dataRepositoryImpl gps_dataRepositoryImpl) {
		this.gps_dataRepositoryImpl = gps_dataRepositoryImpl;
	}

	// 输出当前位置
	public Gps_data findLocation(int vehideid) {
		Gps_data gps_data = null;
		// 得到车辆状态中的id
		String car_object_id = car_infoRepositoryImpl
				.findOneByVehideid(vehideid); 
		// 得到车辆车辆状态类gps_data
		if (car_object_id != null)
			gps_data = gps_dataRepositoryImpl
					.findOneByCar_object_id(car_object_id);
		return gps_data;
	}

	// 查询车辆位置信息总数
	public Long findSum(int vehideid) {
		// // 得到车辆状态中的id
		String car_object_id = car_infoRepositoryImpl
				.findOneByVehideid(vehideid);
		return gps_dataRepositoryImpl.findSumByQuery(car_object_id);
	}
}
