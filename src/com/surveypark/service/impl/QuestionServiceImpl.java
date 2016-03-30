package com.surveypark.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.surveypark.dao.QuestionDao;
import com.surveypark.model.Question;
import com.surveypark.service.QuestionService;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService{

	@Resource
	private QuestionDao questionDao;
	
	/**
	 * 添加问题
	 */
	@Override
	public void save(Question question) {
		if(question!=null){
			questionDao.add(question);
			//设置问题位置
			question.setPosition(question.getId().intValue());
		}
	}

	/**
	 * 查询该调查问卷问题
	 */
	@Override
	public List<Question> findAll(Long surveyId) {
		return questionDao.getQuestionList(surveyId);
	}
  
	/**
	 * 修改问卷的标题（题目）
	 */
	public void updateTitle(Question question) {
		if(question!=null){
			questionDao.add(question);
			//设置问题位置
			question.setPosition(question.getId().intValue());
		}
	}

	/**
	 * 查询
	 */
	@Override
	public Question getById(Long id) {
		if(id!=null){
			return questionDao.getById(id);
		}
		return null;
	}

	/**
	 * 更新
	 */
	@Override
	public void update(Question question) {
		if(question!=null){
			questionDao.update(question);
		}
	}

	/**
	 * 删除
	 */
	@Override
	public void delete(Long id) {
		if(id!=null){
			questionDao.delete(id);
		}
	}

	@Override
	public void moveUp(Long id) {
		if(id!=null){
			questionDao.moveUp(id);
		}
		
	}

	@Override
	public void moveDown(Long id) {
		if(id!=null){
			questionDao.moveDown(id);
		}
		
	}
}
