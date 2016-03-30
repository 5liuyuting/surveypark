package com.surveypark.service;

import java.util.List;

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
	 * 按id查询
	 * @param id
	 * @return
	 */
	public abstract User getById(Long id);

	/**
	 * 按id查询多个实体
	 * @param ids
	 * @return
	 */
	public abstract List<User> getByIds(Long[] ids);

	/**
	 * 查询所有
	 * @return
	 */
	public abstract List<User> findAll();

}