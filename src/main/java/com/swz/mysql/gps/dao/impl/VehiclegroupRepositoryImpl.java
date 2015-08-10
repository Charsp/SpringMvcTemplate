package com.swz.mysql.gps.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.swz.mysql.gps.dao.VehiclegroupRepository;
import com.swz.mysql.gps.model.Vehiclegroup;

@Repository
public class VehiclegroupRepositoryImpl extends BaseGpsImpl implements
		VehiclegroupRepository {
	private Logger logger = LoggerFactory
			.getLogger(UsermainRepositoryImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<Vehiclegroup> queryVehiclegroups(List<Integer> groupList) {
		List<Vehiclegroup> Vehiclegroup = null;
		Query sql = getSessionFactory().getCurrentSession().createQuery(
				"from Vehiclegroup group where group.id in :groupid ");
		sql.setParameterList("groupid", groupList);
		try {
			Vehiclegroup = sql.list();
		} catch (Exception e) {
			logger.error("获取车辆信息列表失败！\n\t" + "没有 vehicleids 数组 的信息");
			throw new RuntimeException();
		}
		return Vehiclegroup;
	}

}
