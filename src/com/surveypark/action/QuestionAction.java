package com.surveypark.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.surveypark.model.Option;
import com.surveypark.model.Question;
import com.surveypark.model.Survey;
import com.surveypark.service.OptionService;
import com.surveypark.service.QuestionService;
import com.surveypark.service.SurveyService;
import com.surveypark.util.CreateQuestionUtil;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class QuestionAction extends ActionSupport {

	private Long surveyId;
	private String surveyTitle; // 调查问卷标题

	private Long id; // 问题id
	private int questionType; // 问题类型
	private String title; // 问题标题

	@Resource
	private SurveyService surveyService;
	@Resource
	private QuestionService questionService;
	@Resource
	private OptionService optionService;

	/*
	 * 创建问题页面
	 */
	public String createUI() throws Exception {
		ActionContext.getContext().put("surveyTitle", surveyTitle);
		List<Question> questionList = questionService.findAll(surveyId);
		ActionContext.getContext().put("questionList", questionList);
		return "createUI";
	}

	/*
	 * 创建问题
	 */
	public void createQuestion() throws Exception {
		Survey survey = surveyService.getById(surveyId);
		if (survey != null) {
			Question question = new Question();
			question.setQuestionType(questionType);
			// 初始化问题标题
			CreateQuestionUtil.dealTitle(question, questionType);
			question.setSurvey(survey);
			questionService.save(question);
			// 初始化选项集合
			if (questionType == 1 || questionType == 2) {
				optionService.save(new Option("选项1", 0, question));
				optionService.save(new Option("选项2", 0, question));
			}
			if (questionType == 5 || questionType == 6) {
				optionService.save(new Option("选项1", 1, question));
				optionService.save(new Option("选项2", 1, question));
				optionService.save(new Option("矩阵行1", 0, question));
				optionService.save(new Option("矩阵行2", 0, question));
			}
		}
	}

	/**
	 * 修改问题的标题（题目）
	 */
	public void updateTitle() throws Exception {
		Question question = questionService.getById(id);
		if (question != null) {
			question.setTitle(title);
			questionService.update(question);
		}
	}

	/**
	 * 删除问题
	 */
	public void delete() throws Exception {
		questionService.delete(id);
	}

	/**
	 * 上移
	 */
	public void moveUp() throws Exception {
		questionService.moveUp(id);
	}

	/**
	 * 下移
	 */
	public void moveDown() throws Exception {
		questionService.moveDown(id);
	}

	/**
	 * 预览
	 */
	public String preview() throws Exception {
		ActionContext.getContext().put("surveyTitle", surveyTitle);
		List<Question> questionList = questionService.findAll(surveyId);
		ActionContext.getContext().put("questionList", questionList);
		return "preview";
	}
	
	/**
	 * 发布
	 */
	public String release() throws Exception {
		Survey survey=surveyService.getById(surveyId);
		survey.setState(1); //修改为发布状态
		survey.setUrl("http://localhost:8080/surveypark/answer_list.action?surveyId="+surveyId); //修改url
		surveyService.save(survey);
		return "release";
	}

	public Long getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Long surveyId) {
		this.surveyId = surveyId;
	}

	public String getSurveyTitle() {
		return surveyTitle;
	}

	public void setSurveyTitle(String surveyTitle) {
		this.surveyTitle = surveyTitle;
	}

	public int getQuestionType() {
		return questionType;
	}

	public void setQuestionType(int questionType) {
		this.questionType = questionType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
