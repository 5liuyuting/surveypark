package com.surveypark.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 * 调查问卷问题
 * 1.单选题
 * 2.多选题
 * 3.单行填空
 * 4.多行填空
 * 5.矩阵单选题
 * 6.矩阵多选题
 */
@Entity
@Table(name="t_question")
public class Question {
 
	private Long id;
	 
	private int questionType; //题型
	 
	private String title; //标题
	 
	private int position; //顺序
	
	private Survey survey; 
	
	private Set<Option> options=new HashSet<Option>(); //选项

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuestionType() {
		return questionType;
	}

	public void setQuestionType(int questionType) {
		this.questionType = questionType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	//本类与Survey是多对一关系
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="surveyId")
	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	//本类与Option是一对多关系
	@OneToMany(mappedBy="question")
	@OrderBy("position")
	public Set<Option> getOptions() {
		return options;
	}

	public void setOptions(Set<Option> options) {
		this.options = options;
	}
	 
}
 
