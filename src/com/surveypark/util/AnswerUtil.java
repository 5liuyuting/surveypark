package com.surveypark.util;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import com.surveypark.model.Answer;
import com.surveypark.service.QuestionService;

public class AnswerUtil {

	/**
	 * 处理字符串
	 * @param name
	 * @return
	 */
	public static Long getId(String name) {
		
		if(name.matches("^.+_.+_.+")){
			name=name.substring(name.indexOf("_")+1,name.lastIndexOf("_"));
		}
		else{
			name=name.substring(name.indexOf("_")+1);
		}
		return Long.valueOf(name);
	}

	/**
	 * 调查问卷问题
	 * 1.单选题
	 * 2.多选题
	 * 3.单行填空
	 * 4.多行填空
	 * 5.矩阵单选题
	 * 6.矩阵多选题
	 */
	public static Answer dealAnswer(String name, HttpServletRequest request,
			QuestionService questionService) {
		
		Answer answer = new Answer();

		if (name.startsWith("q1")|| name.startsWith("q3")|| name.startsWith("q4")) { // 处理单选题|处理单行填空|多行填空
			String value = request.getParameter(name);
			answer.setResult(value);
			answer.setQuestion(questionService.getById(getId(name)));

		} else if (name.startsWith("q2")|| name.startsWith("q5")|| name.startsWith("q6")) { // 处理多选题|矩阵单选题|矩阵多选题
			String[] values = request.getParameterValues(name);
			answer.setResult(Arrays.toString(values));
			answer.setQuestion(questionService.getById(getId(name)));
			
		}else {
			return null;
		}
		return answer;
	}
}
