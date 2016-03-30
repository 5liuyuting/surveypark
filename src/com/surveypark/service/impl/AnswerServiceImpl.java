package com.surveypark.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.surveypark.dao.AnswerDao;
import com.surveypark.dao.QuestionDao;
import com.surveypark.model.Answer;
import com.surveypark.model.Data;
import com.surveypark.model.Option;
import com.surveypark.model.Question;
import com.surveypark.service.AnswerService;

@Service
@Transactional
public class AnswerServiceImpl implements AnswerService {

	@Resource
	private AnswerDao answerDao;
	@Resource
	private QuestionDao questionDao;

	@Override
	public void save(Answer answer) {
		if (answer != null) {
			answerDao.add(answer);
		}
	}

	@Override
	public List<Data> countData(Long questionId) {
		Long count = 0L;
		List<Data> dataList = new ArrayList<Data>();
		if (questionId != null) {
			Question question = questionDao.getById(questionId);
			Set<Option> optionSet = question.getOptions();

			for (Iterator<Option> iterator = optionSet.iterator(); iterator
					.hasNext();) {
				Option option = (Option) iterator.next();
				count = answerDao.countData(questionId, option,
						question.getQuestionType());
				dataList.add(new Data(option.getText(), count.intValue()));
			}
		}
		return dataList;
	}

	@Override
	public List<Data> countDataOther(Long questionId) {
		Long count = 0L;
		List<Data> dataList = new ArrayList<Data>();
		if (questionId != null) {
			Question question = questionDao.getById(questionId);
			Set<Option> optionSet = question.getOptions();
			for (Option row : optionSet) {
				if (row.getType() == 0) {
					for (Option col : optionSet) {
						if (col.getType() == 1) {
							System.out.println(row.getId() + "_" + col.getId());
							count = answerDao.countDataOther(questionId,
									row.getId() + "_" + col.getId(),question.getQuestionType());
							dataList.add(new Data(count.intValue(), col
									.getText(), row.getText()));
						}
					}
				}
			}
		}
		return dataList;
	}
}
