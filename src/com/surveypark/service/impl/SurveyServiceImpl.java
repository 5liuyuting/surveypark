package com.surveypark.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.surveypark.dao.SurveyDao;
import com.surveypark.model.Survey;
import com.surveypark.model.User;
import com.surveypark.service.SurveyService;

@Service
@Transactional
public class SurveyServiceImpl implements SurveyService{
	
	@Resource
	private SurveyDao surveyDao;

	@Override
	public void save(Survey survey) {
		if(survey!=null){
			surveyDao.add(survey);
		}
	}

	@Override
	public List<Survey> list() {
		return surveyDao.findAll();
	}

	@Override
	public Survey getById(Long surveyId) {
		if(surveyId!=null){
			return surveyDao.getById(surveyId);
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		if(id!=null){
			surveyDao.delete(id);
		}
	}

	@Override
	public List<Survey> findByUser(User user) {
		if(user!=null){
			return surveyDao.findByUser(user);
		}
		return new ArrayList<Survey>();
	}

}
