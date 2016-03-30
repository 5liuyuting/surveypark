package com.surveypark.action;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.surveypark.model.Data;
import com.surveypark.model.Question;
import com.surveypark.service.AnswerService;
import com.surveypark.service.QuestionService;
import com.surveypark.service.SurveyService;
import com.surveypark.util.AnswerUtil;
import com.surveypark.util.JfreeChartUtil;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class AnswerAction extends ActionSupport {

	private Long surveyId;
	private JFreeChart chart; 
	private int questionType;
	private Long questionId;

	@Resource
	private SurveyService surveyService;
	@Resource
	private QuestionService questionService;
	@Resource
	private AnswerService answerService;

	/**
	 * 展示所有问题
	 * 
	 * @return
	 * @throws Exception
	 */
	public String list() throws Exception {
		
		ActionContext.getContext().put("surveyTitle", surveyService.getById(surveyId).getTitle());
		List<Question> questionList = questionService.findAll(surveyId);
		ActionContext.getContext().put("questionList", questionList);
		return "list";
	}

	/**
	 * 提交结果
	 * 
	 * @return
	 * @throws Exception
	 */
	public String result() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		System.out.println(request.getParameterNames());
		Enumeration<String> paraNames = request.getParameterNames();
		for (Enumeration<String> e = paraNames; e.hasMoreElements();) {
			String name = e.nextElement().toString();
			System.out.println(request.getParameterValues(name));
			answerService.save(AnswerUtil.dealAnswer(name, request,
					questionService));
		}
		return "result";
	}
	
	public String report() throws Exception {
		ActionContext.getContext().put("surveyTitle", surveyService.getById(surveyId).getTitle());
		List<Question> questionList=questionService.findAll(surveyId);
		ActionContext.getContext().put("questionList", questionList);
		 return "report";
	}
	
	public String jfreeChart() throws Exception {
//		System.out.println(questionType);
//		System.out.println(questionId);
		List<Data> dataList=new ArrayList<Data>();
		if(questionType==1||questionType==2){
			dataList=answerService.countData(questionId);
			// 数据集   
	        DefaultPieDataset data = JfreeChartUtil.getPieData(dataList);
	        // 创建PieChart对象   
	       chart =  ChartFactory.createPieChart3D("" , data,  
	                true ,  true ,  false );
	      JfreeChartUtil.setPieAttribute(chart);
		}else if(questionType==5||questionType==6){
			dataList=answerService.countDataOther(questionId);
			chart = ChartFactory.createBarChart3D("",   
	                  "问题",  
	                  "",  
	                  JfreeChartUtil.getBarData(dataList),  
	                  PlotOrientation.VERTICAL,  
	                  true, 
	                  true,  
	                  false);  
			JfreeChartUtil.setBarAttribute(chart);
		}
		System.out.println(dataList);
		if(dataList.isEmpty()||dataList==null){
			return "noDataPage";
		}
        return "jfreeChart";
	}

	public Long getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(Long surveyId) {
		this.surveyId = surveyId;
	}

	public JFreeChart getChart() {
		return chart;
	}

	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}

	public int getQuestionType() {
		return questionType;
	}

	public void setQuestionType(int questionType) {
		this.questionType = questionType;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	


}
