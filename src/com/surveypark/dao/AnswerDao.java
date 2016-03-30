package com.surveypark.dao;

import com.surveypark.base.BaseDao;
import com.surveypark.model.Answer;
import com.surveypark.model.Option;

public interface AnswerDao extends BaseDao<Answer>{

	/**
	 * 统计
	 * @param questionId
	 * @param id
	 * @param questionType
	 * @return
	 */

	Long countData(Long questionId, Option option, int questionType);

	Long countDataOther(Long questionId, String conditions,int questionType);

}
