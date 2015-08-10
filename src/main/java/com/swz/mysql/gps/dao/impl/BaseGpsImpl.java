package com.swz.mysql.gps.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

public class BaseGpsImpl {
	@Resource
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
