package com.swz.mongo.dao;

import java.util.Date;
import java.util.List;

import com.swz.mongo.model.Gps_data;

public interface Gps_dataRepository extends BaseRepository {

	/**
	 * 通过车信息的车辆id，查询该车的Gps信息(必须有日期限制)
	 * 
	 * @param car_object_id
	 * @return
	 */
	public Gps_data findOneByCar_object_id(String car_object_id);

	/**
	 * 通过开始日期，结束日期查询车辆数据
	 * 
	 * @param car_object_id
	 * @param startDate
	 * @param stopDate
	 * @param pageSize
	 * @param currPage
	 * @return
	 */
	public List<Gps_data> findByCar_object_id(String car_object_id,
			Date startDate, Date stopDate, int pageSize, int currPage);

	/**
	 * 查询数据总数量
	 * 
	 * @param car_object_id
	 * @return
	 */
	public Long findSumByQuery(String car_object_id);

	/**
	 * 通过时间段查询数据总数
	 * 
	 * @param car_object_id
	 * @param startDate
	 * @param stopDate
	 * @return
	 */
	public Long findSumByQuery(String car_object_id, Date startDate,
			Date stopDate);
}
