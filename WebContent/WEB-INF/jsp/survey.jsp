<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<meta content="text/html; charset=gbk" http-equiv="Content-Type">
<title>${surveyTitle}</title>
<link
	href="${pageContext.request.contextPath}/static/css/bootstrap.min.css"
	rel="stylesheet">
<link type="text/css"
	href="${pageContext.request.contextPath}/static/css/preview.css"
	rel="stylesheet">
<script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="preview">
		<h2>${surveyTitle}</h2>
		<div class="content">
			<h4>欢迎参加本次答题</h4>
			<hr>
			<s:form action="answer_result" method="post">
			<s:iterator value="#questionList" var="question" status="status">
				<label>${status.count}.${question.title}</label>
				<br><br>
				<!-- 单选题 -->
				<s:if test="#question.questionType==1">
					<ul class="pagination">
						<s:iterator value="#question.options" var="option" status="status">
							<li>
								<input type="radio" name="q1_${question.id}" value="${option.id}"> ${option.text}
							</li>
							
							<s:if test="#option.type==1">
								<br>
							</s:if>
						</s:iterator>
					</ul>
				</s:if>

				<!-- 多选题 -->
				<s:elseif test="#question.questionType==2">
					<ul class="pagination">
						<s:iterator value="#question.options" var="option" status="status">
							<li><input type="checkbox" name="q2_${question.id}" value="${option.id}">
								${option.text}</li>
							<s:if test="#option.type==1">
								<br>
							</s:if>
						</s:iterator>
					</ul>
				</s:elseif>

				<!-- 单行填空-->
				<s:elseif test="#question.questionType==3">
					<input type="text" name="q3_${question.id}">
				</s:elseif>

				<!-- 多行填空 -->
				<s:elseif test="#question.questionType==4">
					<textarea rows="2" cols="20" name="q4_${question.id}"></textarea>
				</s:elseif>

				<!-- 矩阵单选题 -->
				<s:elseif test="#question.questionType==5">
					<table class="table table-bordered">
						<tr>
							<td></td>
							<s:iterator value="#question.options" var="col">
								<s:if test="#col.type==1">
									<td>${col.text}</td>
								</s:if>
							</s:iterator>
						</tr>
						<s:iterator value="#question.options" var="row">
							<s:if test="#row.type==0">
								<tr>
									<td>${row.text}</td>
									<s:iterator value="#question.options" var="col">
										<s:if test="#col.type==1">
											<td><input type="radio" name="q5_${question.id}_${row.id}" value="${row.id}_${col.id}"></td>
										</s:if>
									</s:iterator>
								<tr>
							</s:if>
						</s:iterator>
					</table>
				</s:elseif>
				
				<!-- 矩阵多选题 -->
				<s:elseif test="#question.questionType==6">
					<table class="table table-bordered">
						<tr>
							<td></td>
							<s:iterator value="#question.options" var="col">
								<s:if test="#col.type==1">
									<td>${col.text}</td>
								</s:if>
							</s:iterator>
						</tr>
						<s:iterator value="#question.options" var="row">
							<s:if test="#row.type==0">
								<tr>
									<td>${row.text}</td>
									<s:iterator value="#question.options" var="col">
										<s:if test="#col.type==1">
											<td><input type="checkbox" name="q6_${question.id}_${row.id}" value="${row.id}_${col.id}"></td>
										</s:if>
									</s:iterator>
								<tr>
							</s:if>
						</s:iterator>
					</table>
				</s:elseif>

				<br>
				<br>
			</s:iterator>
			<div  class="WJButton">
				<input type="submit" class="btn btn-primary" id="submitButton" value="提  交" >
			</div>
			</s:form>
		</div>
	</div>
</body>
</html>