package com.swz.mysql.gps.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.swz.mysql.gps.dao.Log4jRepository;
import com.swz.mysql.gps.model.Log4j;

@Repository
public class Log4jRepositoryImpl extends BaseGpsImpl implements Log4jRepository {

	@SuppressWarnings("unchecked")
	public List<Log4j> queryLog() {
		Session session = getSessionFactory().getCurrentSession();
		Query sql = session.createQuery("from Log4j ");
		return sql.list();
	}
}
