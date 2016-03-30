package com.surveypark.service;

import java.util.List;

import com.surveypark.model.Question;


public interface QuestionService {

	void save(Question question);

	List<Question> findAll(Long surveyId);

	Question getById(Long id);

	void update(Question question);

	void delete(Long id);

	void moveUp(Long id);

	void moveDown(Long id);

}