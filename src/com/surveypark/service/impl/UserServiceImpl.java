package com.surveypark.service.impl;

import org.apache.commons.codec.digest.DigestUtils;
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
		if (user != null) {
			userDao.update(user);
		}
	}

	@Override
	public User findEmailAndPassword(String email, String password) {
		User user = userDao.getByEmail(email);
		if (user != null) {
			if (user.getPassword().equals(DigestUtils.md5Hex(password))) {
				return user;
			}
		}
		return null;
	}

	

}
