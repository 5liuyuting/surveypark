package com.surveypark.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 选项
 */
@Entity
@Table(name="t_option")
public class Option {

	private Long id;
	
	private String text; //选项内容
	
	private int position; //选项顺序
	
	private int type; //选项类型  0-row 1-col
	
	private Question question;

	public Option() {}

	
	public Option(String text, int type, Question question) {

		this.text = text;
		this.type = type;
		this.question = question;
	}




	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	//本类与Question是多对一关系
	@ManyToOne
	@JoinColumn(name="questionId")
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	} 
}
