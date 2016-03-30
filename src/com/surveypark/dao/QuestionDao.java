package com.surveypark.dao;

import java.util.List;

import com.surveypark.base.BaseDao;
import com.surveypark.model.Question;

public interface QuestionDao extends BaseDao<Question>{

	List<Question> getQuestionList(Long surveyId);

	void moveUp(Long id);

	void moveDown(Long id);

}
