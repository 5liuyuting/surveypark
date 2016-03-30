package com.surveypark.dao.impl;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.surveypark.base.BaseDaoImpl;
import com.surveypark.dao.AnswerDao;
import com.surveypark.model.Answer;
import com.surveypark.model.Option;

@Repository
@Transactional
public class AnswerDaoImpl extends BaseDaoImpl<Answer> implements AnswerDao {

	@Override
	public Long countData(Long questionId,Option option, int questionType) {
		String sql = "select count(*) From Answer aw Where aw.question.id=:questionId and aw.result like :conditions";
		String conditions="";
		switch (questionType) {
		case 1:
			conditions=""+option.getId();
			break;
		case 2:
			conditions="[%"+option.getId()+"%]";
			break;
		}
		Query q = this.getSession().createQuery(sql);
		return (Long) q.setParameter("questionId", questionId)
				.setParameter("conditions",conditions)
				.uniqueResult();
	}

	@Override
	public Long countDataOther(Long questionId, String conditions,int questionType) {
		String sql = "select count(*) From Answer aw Where aw.question.id=:questionId and aw.result like :conditions";
		switch (questionType) {
		case 5:
			conditions="["+conditions+"]";
			break;
		case 6:
			conditions="[%"+conditions+",%]";
			break;
		}
		return (Long) this.getSession()
				.createQuery(sql)
				.setParameter("questionId", questionId)
				.setParameter("conditions",conditions)
				.uniqueResult();
	}

}
