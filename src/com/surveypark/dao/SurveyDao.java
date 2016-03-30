package com.surveypark.dao;

import java.util.List;

import com.surveypark.base.BaseDao;
import com.surveypark.model.Survey;
import com.surveypark.model.User;

public interface SurveyDao extends BaseDao<Survey>{

	List<Survey> findByUser(User user);

}
