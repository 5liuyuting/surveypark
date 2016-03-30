<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据分析</title>
<link
	href="${pageContext.request.contextPath}/static/css/bootstrap.min.css"
	rel="stylesheet">
<link type="text/css"
	href="${pageContext.request.contextPath}/static/css/report.css"
	rel="stylesheet">
<script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="report">
		<h1>${surveyTitle}</h1>
		<s:iterator value="questionList" var="question" status="status">
			<div class="content">
				<s:if test="#question.questionType==1||#question.questionType==2||#question.questionType==5||#question.questionType==6">
				<label>${question.title}</label> <br> 
						<img alt="jfreechart"
							src="answer_jfreeChart.action?questionId=${question.id}&questionType=${question.questionType}" />
				</s:if>
			</div>
		</s:iterator>
	</div>

</body>
</html>