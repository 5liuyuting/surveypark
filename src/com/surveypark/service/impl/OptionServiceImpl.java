package com.surveypark.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.surveypark.dao.OptionDao;
import com.surveypark.model.Option;
import com.surveypark.service.OptionService;

@Service
@Transactional
public class OptionServiceImpl implements OptionService {

	@Resource
	private OptionDao optionDao;
	
	@Override
	public void save(Option option) {
		if(option!=null){
			
			optionDao.add(option);
			option.setPosition(option.getId().intValue());
		}
	}

	@Override
	public Option getById(Long id) {
		if(id!=null){
			return optionDao.getById(id);
		}
		return null;
	}

	@Override
	public void update(Option option) {
		optionDao.update(option);
		
	}

	@Override
	public void delete(Long id) {
		optionDao.delete(id);
	}

	@Override
	public void verticalSort(Long questionId) {
		optionDao.verticalSort(questionId);
	}

	@Override
	public void horizontalSort(Long questionId) {
		optionDao.horizontalSort(questionId);
	}

}
