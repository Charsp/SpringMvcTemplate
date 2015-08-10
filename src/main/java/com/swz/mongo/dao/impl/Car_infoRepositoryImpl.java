package com.swz.mongo.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.swz.mongo.dao.Car_infoRepository;
import com.swz.mongo.model.Car_info;

@Repository
public class Car_infoRepositoryImpl extends BaseRepositoryImpl implements
		Car_infoRepository {
	private Logger log = LoggerFactory.getLogger(Car_infoRepositoryImpl.class);

	public List<Car_info> findByCar_no(String car_no) {
		// TODO Auto-generated method stub
		return getMongoTemplate().find(
				new Query(Criteria.where("car_no").is(car_no)), Car_info.class);
	}

	public String findOneByVehideid(int vehideid) {
		String result = null;
		try {
			result = getMongoTemplate().findOne(
					new Query(Criteria.where("vehideid").is(vehideid)),
					Car_info.class).getId();
		} catch (Exception e) {
			log.error("car_info中没有找到车辆！");
			throw new RuntimeException();
		}
		return result;
	}

	public void saveCar_info(Car_info car_info) {
		// TODO Auto-generated method stub
		getMongoTemplate().save(car_info);
	}

}
