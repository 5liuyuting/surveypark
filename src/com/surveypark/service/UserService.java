package com.surveypark.service;

import com.surveypark.model.User;

public  interface UserService {

	/**
	 * 保存实体
	 * @param entity
	 */
	public abstract void add(User user);

	/**
	 * 删除实体
	 * @param id
	 */
	public abstract void delete(Long id);

	/**
	 * 更改实体
	 * @param id
	 */
	public abstract void update(User user);

	/**
	 * 登录验证
	 * @param email
	 * @param password
	 * @return
	 */
	public abstract User findEmailAndPassword(String email, String password);


}