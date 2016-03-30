package com.surveypark.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.surveypark.dao.UserDao;
import com.surveypark.model.User;
import com.surveypark.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	public void add(User user) {
		userDao.add(user);
	}

	public void delete(Long id) {
		userDao.delete(id);
	}

	public void update(User user) {
		userDao.update(user);
	}

	public User getById(Long id) {
		return userDao.getById(id);
	}

	public List<User> getByIds(Long[] ids) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
