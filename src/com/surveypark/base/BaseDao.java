package com.surveypark.base;

import java.util.List;

public interface BaseDao<T> {
	 
	/**
	 * 保存实体
	 * @param entity
	 */
	public void add(T entity);
	
	/**
	 * 删除实体
	 * @param id
	 */
	public void delete(Long id);
	
	/**
	 * 更改实体
	 * @param id
	 */
	public void update(T entity);

	/**
	 * 按id查询
	 * @param id
	 * @return
	 */
	public T getById(Long id);
	
	/**
	 * 按id查询多个实体
	 * @param ids
	 * @return
	 */
	public List<T> getByIds(Long[] ids);
	
	/**
	 * 查询所有
	 * @return
	 */
	public List<T> findAll();
	
}
