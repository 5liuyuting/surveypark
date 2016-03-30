package com.surveypark.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.surveypark.model.Option;
import com.surveypark.model.Question;
import com.surveypark.service.OptionService;
import com.surveypark.service.QuestionService;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class OptionAction extends ActionSupport {

	private Long questionId;
	private Long id;
	private String text;
	private int type; 
	
	@Resource
	private QuestionService questionService;
	@Resource
	private OptionService optionService;
	
	/**
	 * 修改选项的内容
	 */
	public void updateText() throws Exception {
		Option op=optionService.getById(id);
		if(op!=null){
			op.setText(text);
			optionService.update(op);
		}
	}
	
	/**
	 * 添加选项
	 */
	public void add() throws Exception {
		Question question=questionService.getById(questionId);
		if(question!=null){
			Option option=new Option();
			if(question.getQuestionType()==5||question.getQuestionType()==6){
				if(type==0){
					option.setText("新建行");
				}else {
					option.setText("新建列");
				}
			}
			else{
				option.setText("新建选项");
			}
			option.setType(type);
			option.setQuestion(question);
			optionService.save(option);
		}
	}

	/**
	 * 删除
	 */
	public void delete() throws Exception {
		optionService.delete(id);
	}

	/**
	 * 竖排
	 */
	public void verticalSort() throws Exception {
		optionService.verticalSort(questionId);
	}
	/**
	 * 横排
	 */
	public void horizontalSort() throws Exception {
		optionService.horizontalSort(questionId);
	}
	
	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	

	
}
