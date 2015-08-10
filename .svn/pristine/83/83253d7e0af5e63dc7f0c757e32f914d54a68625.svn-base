package com.swz.mysql.gps.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.swz.mysql.gps.dao.VehcleRepository;
import com.swz.mysql.gps.model.Vehicle;

@Repository
public class VehcleRepositoryImpl extends BaseGpsImpl implements
		VehcleRepository {

	private Logger logger = LoggerFactory
			.getLogger(UsermainRepositoryImpl.class);

	public String findVehcleName(int vehicleid) {
		String vehcleNum = null;
		Query sql = getSessionFactory()
				.getCurrentSession()
				.createQuery(
						"select car_license_num from Vehicle car where car.id=:vehicleid ");
		sql.setInteger("vehicleid", vehicleid);
		try {
			vehcleNum = (String) sql.uniqueResult();
		} catch (Exception e) {
			logger.error("没有 Vehicleid为" + vehicleid + "的信息");
			throw new RuntimeException();
		}
		return vehcleNum;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> findVehclesName(List<Integer> vehicleids) {

		List<String> vehcleNum;
		Query sql = getSessionFactory()
				.getCurrentSession()
				.createQuery(
						"select car_license_num from Vehicle car where car.id in :vehicleid ");
		sql.setParameterList("vehicleid", vehicleids);
		try {
			vehcleNum = sql.list();
		} catch (Exception e) {
			logger.error("获取车辆名称失败！\n\t" + "没有 Vehicleid 数组 的信息");
			throw new RuntimeException();
		}
		return vehcleNum;
	}

	@SuppressWarnings("unchecked")
	public List<Vehicle> findVehcles(List<Integer> vehicleids) {
		List<Vehicle> vehicles = null;
		Query sql = getSessionFactory().getCurrentSession().createQuery(
				"from Vehicle car where car.id in :vehicleid ");
		sql.setParameterList("vehicleid", vehicleids);
		try {
			vehicles = sql.list();
		} catch (Exception e) {
			logger.error("获取车辆信息列表失败！\n\t" + "没有 vehicleids 数组 的信息");
			throw new RuntimeException();
		}
		return vehicles;
	}

}
