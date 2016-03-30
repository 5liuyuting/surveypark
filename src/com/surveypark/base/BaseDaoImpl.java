package com.surveypark.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("unchecked")
@Transactional
public abstract class BaseDaoImpl<T> implements BaseDao<T> {

	
	private SessionFactory sessionFactory;
	private Class<T> clazz;

	public BaseDaoImpl() {
		// 用反射得到T的类型
		ParameterizedType pt = (ParameterizedType) this.getClass()
				.getGenericSuperclass();// 获取当前newde对象的泛型的父类类型
		clazz = (Class<T>) pt.getActualTypeArguments()[0];// 获取第一个参数的真实类型
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void add(T entity) {
		if(entity!=null){
			getSession().save(entity);
		}
	}

	public void delete(Long id) {
		Object entity = getById(id);
		if (entity != null)
			getSession().delete(entity);
	}

	public void update(T entity) {
		if(entity!=null){
			getSession().update(entity);
		}	
	}

	public T getById(Long id) {
		//System.out.println(sessionFactory.getCurrentSession());
		return (T) getSession().get(clazz, id);
	}

	public List<T> getByIds(Long[] ids) {
		return (List<T>) getSession()
				.createQuery(
						"from " + clazz.getSimpleName() + "where id in(:ids)")
				.setParameterList("ids", ids).list();
	}

	public List<T> findAll() {
		return (List<T>) getSession().createQuery(
				"from " + clazz.getSimpleName()).list();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
