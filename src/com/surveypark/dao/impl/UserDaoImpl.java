package com.surveypark.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.surveypark.base.BaseDaoImpl;
import com.surveypark.dao.UserDao;
import com.surveypark.model.User;

@Repository
@Transactional
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {

	@Override
	public User getByEmail(String email) {
		return (User) getSession()
				.createQuery("From User u where u.email = :email")
				.setParameter("email", email)
				.uniqueResult();
	}
	
}
