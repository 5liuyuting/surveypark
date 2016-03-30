package com.surveypark.service;

import com.surveypark.model.Option;

public interface OptionService {

	void save(Option option);

	Option getById(Long id);

	void update(Option option);

	void delete(Long id);

	void verticalSort(Long questionId);

	void horizontalSort(Long questionId);

}
