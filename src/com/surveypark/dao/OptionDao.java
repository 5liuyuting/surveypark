package com.surveypark.dao;

import com.surveypark.base.BaseDao;
import com.surveypark.model.Option;

public interface OptionDao extends BaseDao<Option>{

	void verticalSort(Long questionId);

	void horizontalSort(Long questionId);

}
