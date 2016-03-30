package com.surveypark.service;

import java.util.List;

import com.surveypark.model.Answer;
import com.surveypark.model.Data;

public interface AnswerService {

	void save(Answer answer);

	List<Data> countData(Long questionId);

	List<Data> countDataOther(Long questionId);


}
