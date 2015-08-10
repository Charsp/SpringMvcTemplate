package com.swz.mongo.dao.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.swz.mongo.dao.Gps_dataRepository;
import com.swz.mongo.model.Gps_data;
import com.swz.service.web.FindVehicleLocation;

@Repository
public class Gps_dataRepositoryImpl extends BaseRepositoryImpl implements
		Gps_dataRepository {
	private Logger log = LoggerFactory.getLogger(FindVehicleLocation.class);
 
	public Gps_data findOneByCar_object_id(String car_object_id) {
		Gps_data gps_data = null;
		// 查找数据一个最后一个
		Query query = new Query(Criteria.where("car_object_id").is(
				car_object_id)).limit(1);
		query.with(new Sort(Sort.Direction.DESC, "datetime"));
		try {
			gps_data = getMongoTemplate().findOne(query, Gps_data.class);
		} catch (Exception e) {
			log.error("查找最后一项失败！");
			throw new RuntimeException();
		}
		return gps_data;
	}
 
	public List<Gps_data> findByCar_object_id(String car_object_id,
			Date startDate, Date stopDate, int pageSize, int currPage) {
		List<Gps_data> result = null;
		Query query = new Query(Criteria.where("car_object_id")
				.is(car_object_id).and("updatetime").lt(stopDate).gt(startDate));
		query.skip((currPage - 1) * pageSize);// 当前页数减一*每页数量
		query.limit(pageSize);
		try {
			result = getMongoTemplate().find(query, Gps_data.class);
		} catch (Exception e) {
			log.error("查找数据失败！");
			throw new RuntimeException();
		}
		return result;
	}
 
	public Long findSumByQuery(String car_object_id) {
		Long result = null;
		Query query = new Query(Criteria.where("car_object_id").is(
				car_object_id));
		try {
			result = getMongoTemplate().count(query, Gps_data.class);
		} catch (Exception e) {
			log.error("查找车辆总数失败！");
			throw new RuntimeException();
		}
		return result;
	}
 
	public Long findSumByQuery(String car_object_id, Date startDate,
			Date stopDate) {
		Long result = null;
		Query query = new Query(Criteria.where("car_object_id")
				.is(car_object_id).and("updatetime").lt(stopDate).gt(startDate));
		try {
			result = getMongoTemplate().count(query, Gps_data.class);
		} catch (Exception e) {
			log.error("查询在" + startDate + "到" + stopDate + "时间内的数据时，数据异常！");
			throw new RuntimeException();
		}
		return result;
	}
}
