package com.surveypark.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.surveypark.model.Survey;
import com.surveypark.model.User;
import com.surveypark.service.SurveyService;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class SurveyAction extends ActionSupport {

	@Resource
	private SurveyService surveyService;

	private String title;
	private Long id;

	/*
	 * 添加调查问卷
	 */
	public String save() throws Exception {
		Survey survey = new Survey();
		survey.setCount(0);
		survey.setCreateTime(new Date());
		survey.setState(0);
		survey.setUrl("尚未发布");
		survey.setTitle(title);
		User u = (User) ActionContext.getContext().getSession().get("user");
		survey.setUser(u);
		if (title != null && !title.trim().equals("")&&u!=null) {
			surveyService.save(survey);
			id = survey.getId();
		}
		return "save";
	}

	/*
	 * 列出所有的调查问卷
	 */
	public String list() throws Exception {
		User u = (User) ActionContext.getContext().getSession().get("user");
		System.out.println(u);
		if (u != null) {
			List<Survey> surveyList = surveyService.findByUser(u);
			ActionContext.getContext().put("surveyList", surveyList);
		}
		return "list";
	}

	/**
	 * 删除
	 */
	public String delete() throws Exception {
		surveyService.delete(id);
		return "toList";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
