package com.surveypark.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.surveypark.base.BaseDaoImpl;
import com.surveypark.dao.SurveyDao;
import com.surveypark.model.Survey;
import com.surveypark.model.User;

@Repository
@Transactional
public class SurveyDaoImpl extends BaseDaoImpl<Survey> implements SurveyDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Survey> findByUser(User user) {
		return getSession().createQuery("From Survey s Where s.user.id=:id")
				.setParameter("id", user.getId())
				.list();
	}


}
