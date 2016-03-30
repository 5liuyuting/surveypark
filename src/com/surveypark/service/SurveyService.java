package com.surveypark.service;

import java.util.List;

import com.surveypark.model.Survey;
import com.surveypark.model.User;


public interface SurveyService {

	void save(Survey survey);

	List<Survey> list();

	Survey getById(Long surveyId);

	void delete(Long id);

	List<Survey> findByUser(User user);

}