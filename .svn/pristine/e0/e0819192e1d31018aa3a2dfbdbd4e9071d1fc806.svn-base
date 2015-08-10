package com.swz.mongo.dao.impl;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.swz.mongo.dao.UserRepository;
import com.swz.mongo.model.User;

@Repository
public class UserRepositoryImpl extends BaseRepositoryImpl implements
		UserRepository {

	public List<User> findByName(String username) {
		return getMongoTemplate().find(
				new Query(Criteria.where("username").is(username)), User.class);
	}

	public User findOneByUserId(String userId) {
		return getMongoTemplate().findOne(
				new Query(Criteria.where("id").is(userId)), User.class);
	}

	public void saveUser(User user) {
		getMongoTemplate().save(user);

	}

	public void removeOne(User user) {
		// 目前不涉及此类业务！
	}

}
