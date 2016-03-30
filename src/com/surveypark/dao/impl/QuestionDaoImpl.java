package com.surveypark.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.surveypark.base.BaseDaoImpl;
import com.surveypark.dao.QuestionDao;
import com.surveypark.model.Question;

@Repository
@Transactional
public class QuestionDaoImpl extends BaseDaoImpl<Question> implements QuestionDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Question> getQuestionList(Long surveyId) {
		return getSession().createQuery("From Question q Where q.survey.id = "+surveyId +"order by q.position")
				.list();
	}

	@Override
	public void moveUp(Long id) {
		Question question=getById(id);
		Question other=(Question) getSession().createQuery(
				"From Question q where q.position < ? order by q.position DESC")
				.setParameter(0, question.getPosition())
				.setFirstResult(0)
				.setMaxResults(1)
				.uniqueResult();
		
		// 最上面的不能上移
		if(other==null){
			return;
		}
		
		// 交换position的值
		int temp=question.getPosition();
		question.setPosition(other.getPosition());
		other.setPosition(temp);
		
		// 更新到数据中（可以不写，因为对象现在是持久化状态）
		this.getSession().save(question);
		this.getSession().save(other);
	}
	
	@Override
	public void moveDown(Long id) {
		Question question=getById(id);
		Question other=(Question) getSession().createQuery(
				"From Question q where q.position > ? order by q.position ASC")
				.setParameter(0, question.getPosition())
				.setFirstResult(0)
				.setMaxResults(1)
				.uniqueResult();
		
		// 最上面的不能上移
		if(other==null){
			return;
		}
		
		// 交换position的值
		int temp=question.getPosition();
		question.setPosition(other.getPosition());
		other.setPosition(temp);
		
		// 更新到数据中（可以不写，因为对象现在是持久化状态）
		this.getSession().save(question);
		this.getSession().save(other);
	}


}
