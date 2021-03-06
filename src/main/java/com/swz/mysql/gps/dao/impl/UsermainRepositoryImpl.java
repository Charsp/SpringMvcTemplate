package com.swz.mysql.gps.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.swz.mysql.gps.dao.UsermainRepository;
import com.swz.mysql.gps.model.Usermain;

@Repository
public class UsermainRepositoryImpl extends BaseGpsImpl implements
		UsermainRepository {
	private Logger logger = LoggerFactory
			.getLogger(UsermainRepositoryImpl.class);

	public Usermain queryUsermain(String username, String password) {

		Query sql = getSessionFactory()
				.getCurrentSession()
				.createQuery(
						"from Usermain user where user.UserNum = :username and user.Password = :password");
		sql.setString("username", username);
		sql.setString("password", password);
		Usermain usermain = (Usermain) sql.uniqueResult();
		sql = null;
		return usermain;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<Map> queryVehicleList(int userid) {
		Session session = getSessionFactory().getCurrentSession();
		List<Map> list = null;
		Query sql = null;
		List<Integer> groupid = getVehicleGroups(userid);
		// 有分组
		if (groupid != null && groupid.size() > 0) {
			// 获取组列表
			sql = session
					.createQuery("select new map(vehicle.id,vehicle.car_license_num) from Vehicle vehicle,Usermain_veh usermain_veh where "
							+ "vehicle.vehTeam_ID not in(:groupid) and vehicle.isdelete =0 and vehicle.id =usermain_veh.VehicleID and usermain_veh.UserID =:userid ");
			sql.setParameterList("groupid", groupid);

		}
		// 没有分组(单台车用户)
		else {
			sql = session
					.createQuery("select new map(vehicle.id,vehicle.car_license_num) from Vehicle vehicle,Usermain_veh usermain_veh where "
							+ " vehicle.isdelete =0 and vehicle.id =usermain_veh.VehicleID and usermain_veh.UserID =:userid ");
		}
		sql.setInteger("userid", userid);
		list = sql.list();
		// if (list != null) {
		// System.out.println("未分组车辆数量为：" + list.size());
		// }
		return list;
	}

	// 用户车辆分组
	@SuppressWarnings("unchecked")
	public List<Integer> getVehicleGroups(int userid) {
		Session session = getSessionFactory().getCurrentSession();
		List<Integer> groupid = null;
		Query sql = session
				.createQuery("select VehicleGroupID from Usermain_vehiclegroup group where "
						+ "group.UserID = :userid ");
		sql.setInteger("userid", userid);
		groupid = sql.list();
		return groupid;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<String, List<Map>> queryGroupVehicleList(int userid) {
		Session session = getSessionFactory().getCurrentSession();
		Map<String, List<Map>> map = new HashMap<String, List<Map>>();
		Query sql = null;
		// 获取组列表
		List<Integer> groupid = getVehicleGroups(userid);
		if (groupid != null && groupid.size() > 0) {
			map = new HashMap<String, List<Map>>();

			for (int i = 0; i < groupid.size(); i++) {
				sql = session
						.createQuery("select vehicleTeam_name from Vehiclegroup group where "
								+ "group.id = :groupid ");
				// 获得组名称
				sql.setInteger("groupid", groupid.get(i));
				String userGroupName = (String) sql.uniqueResult();
				if (userGroupName != null) {
					sql = session
							.createQuery("select new map(id,car_license_num) from Vehicle vehicle where "
									+ "vehicle.vehTeam_ID = :groupid and vehicle.isdelete =0");
					sql.setInteger("groupid", groupid.get(i));
					// 获得组下车辆列表
					List carList = sql.list();
					if (carList != null && carList.size() > 0)
						// 组下没有车辆列表
						map.put(userGroupName, carList);
				}
				// System.out.println(userGroupName + "组数量为：" +
				// vehicleList.size()
				// + "台车");
			}
		}
		sql = null;
		return map;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Integer> queryVehicleMap(int userid) {
		List<Integer> result = null;
		Query sql = getSessionFactory()
				.getCurrentSession()
				.createQuery(
						"select VehicleID from Usermain_veh user where user.UserID= :userid ");
		sql.setInteger("userid", userid);
		try {
			result = sql.list();
			if (result != null) {
			}
		} catch (Exception e) {
			logger.error("程序出错在获取用户车辆列表时：" + userid);
		}
		return null;
	}

	@Override
	public Integer queryUser(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> queryVehicleGroup(int userid) {
		List<Integer> groupList = null;
		Query sql = getSessionFactory()
				.getCurrentSession()
				.createQuery(
						"select VehicleGroupID from Usermain_vehiclegroup user where user.UserID= :userid ");
		sql.setInteger("userid", userid);
		try {
			groupList = sql.list();
			if (groupList != null) {
			}
		} catch (Exception e) {
			logger.error("程序出错在获取用户车辆组列表时：" + userid);
		}
		return null;
	}
}
