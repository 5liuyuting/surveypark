package com.surveypark.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.surveypark.base.BaseDaoImpl;
import com.surveypark.dao.OptionDao;
import com.surveypark.model.Option;

@Repository
@Transactional
public class OptionDaoImpl extends BaseDaoImpl<Option> implements OptionDao {

	@Override
	public void verticalSort(Long questionId) {
		getSession().createQuery("update Option o set type=1 where o.question.id="+questionId).executeUpdate();
	}

	@Override
	public void horizontalSort(Long questionId) {
		getSession().createQuery("update Option o set type=0 where o.question.id="+questionId).executeUpdate();	
	}

}
