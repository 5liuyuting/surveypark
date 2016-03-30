<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<meta content="text/html; charset=gbk" http-equiv="Content-Type">
<title>问卷预览-${surveyTitle}</title>
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
		<h5>本页面为预览页面，无法修改和采集数据</h5>
		<div class="content">
			<h4>欢迎参加本次答题</h4>
			<hr>
			<s:iterator value="#questionList" var="question" status="status">
				<label>${status.count}.${question.title}</label>
				<br><br>
				<!-- 单选题 -->
				<s:if test="#question.questionType==1">
					<ul class="pagination">
						<s:iterator value="#question.options" var="option" status="status">
							<li>
								<input type="radio" name="radio"> ${option.text}
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
							<li><input type="checkbox" name="checkbox">
								${option.text}</li>
							<s:if test="#option.type==1">
								<br>
							</s:if>
						</s:iterator>
					</ul>
				</s:elseif>

				<!-- 单行填空-->
				<s:elseif test="#question.questionType==3">
					<input type="text">
				</s:elseif>

				<!-- 多行填空 -->
				<s:elseif test="#question.questionType==4">
					<textarea rows="2" cols="20"></textarea>
				</s:elseif>

				<!-- 矩阵单选题 -->
				<s:elseif test="#question.questionType==5">
					<table class="table table-bordered">
						<tr>
							<td></td>
							<s:iterator value="#question.options" var="option">
								<s:if test="#option.type==1">
									<td>${option.text}</td>
								</s:if>
							</s:iterator>
						</tr>
						<s:iterator value="#question.options" var="option">
							<s:if test="#option.type==0">
								<tr>
									<td>${option.text}</td>
									<s:iterator value="#question.options" var="option">
										<s:if test="#option.type==1">
											<td><input type="radio" name="radio"></td>
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
							<s:iterator value="#question.options" var="option">
								<s:if test="#option.type==1">
									<td>${option.text}</td>
								</s:if>
							</s:iterator>
						</tr>
						<s:iterator value="#question.options" var="option">
							<s:if test="#option.type==0">
								<tr>
									<td>${option.text}</td>
									<s:iterator value="#question.options" var="option">
										<s:if test="#option.type==1">
											<td><input type="checkbox" name="checkbox"></td>
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
				<button type="button" class="btn btn-primary" id="submitButton" >提  交 </button>
			</div>
		</div>
	</div>
</body>
</html>