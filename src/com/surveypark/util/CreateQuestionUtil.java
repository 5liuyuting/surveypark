package com.surveypark.util;

import com.surveypark.model.Question;

public class CreateQuestionUtil {

	/**
	 * 初始化问题标题
	 */
	public static void dealTitle(Question question,int questionType){
		switch (questionType) {
		case 1:
			question.setTitle("单选题");
			break;
		case 2:
			question.setTitle("多选题");
			break;
		case 3:
			question.setTitle("单行填空");
			break;
		case 4:
			question.setTitle("多行填空");
			break;
		case 5:
			question.setTitle("矩阵单选题");
			break;
		case 6:
			question.setTitle("矩阵多选题");
			break;
		}
	}
}
