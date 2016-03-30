<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<meta content="text/html; charset=gbk" http-equiv="Content-Type">
<title>问卷设计-${surveyTitle}</title>
<link
	href="${pageContext.request.contextPath}/static/css/bootstrap.min.css"
	rel="stylesheet">
<link type="text/css"
	href="${pageContext.request.contextPath}/static/css/create.css"
	rel="stylesheet">
<script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/create.js"></script>
</head>
<body>
	<header>
		<h4>${surveyTitle}</h4>
	</header>
	<div id="centerDiv">
		<div id="leftDiv">
			<input type="hidden" value="${surveyId}" id="sId">
			<ul class="nav nav-pills nav-stacked">
				<li><a href="javascript:;" id="single">单选题</a></li>
				<li><a href="javascript:;" id="multiple">多选题</a></li>
				<li><a href="javascript:;" id="single_blank">单行填空</a></li>
				<li><a href="javascript:;" id="multiple_blank">多行填空</a></li>
				<li><a href="javascript:;" id="matrix_single">矩阵单选题</a></li>
				<li><a href="javascript:;" id="matrix_multiple">矩阵多选题</a></li>
			</ul>
		</div>
		<div id="rightDiv">
			<!-- 循环问题start -->
			<s:iterator value="#questionList" var="question" status="status">
				<div class="c_question">
					<div class="selection">
						<div class="question" id="question_">
						
							<label>${status.count}.</label>
							<input type="text" value="${question.title}" id="q_${question.id}"><br>
								
							<!-- 单选题 -->
							<s:if test="#question.questionType==1">
								<ul  class="pagination">
									<s:iterator value="#question.options" var="option" status="status">	
										<li><input type="radio" name="radio">
										<input type="text" value="${option.text}" id="op_${option.id}" >
										<label class="deleteOption" id="dop_${option.id}">
											<a style="font-size:30px;color:red;" id="del_${option.id}" href="javascript:;" title="删除选项">x</a>
										</label>
										</li>
											<s:if test="#option.type==1">
												<br>
											</s:if>
									<s:if test="#status.last">
										<a href="javascript:;" id="add_${question.id}&type=${option.type}" title="添加选项"><span style="font-size:30px;color:green;">+</span></a>
									</s:if>
									</s:iterator>
								</ul>
							</s:if>

							<!-- 多选题 -->
							<s:elseif test="#question.questionType==2">
								<ul class="pagination">
									<s:iterator value="#question.options" var="option" status="status">	
										<li><input type="checkbox" name="checkbox">
										<input type="text" value="${option.text}" id="op_${option.id}">
										<label class="deleteOption" id="dop_${option.id}">
											<a style="font-size:30px;color:red;" id="del_${option.id}" href="javascript:;" title="删除选项">x</a>
										</label>
										</li>
											<s:if test="#option.type==1">
												<br>
											</s:if>
										<s:if test="#status.last">
										<a href="javascript:;" id="add_${question.id}&type=${option.type}" title="添加选项"><span style="font-size:30px;color:green;">+</span></a>
									</s:if>
									</s:iterator>
								</ul>
							</s:elseif>

							<!-- 单行填空-->
							<s:elseif test="#question.questionType==3">
								<input type="text" class="s_blank">
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
												<td><input type="text" value="${option.text}" id="op_${option.id}"></td>
											</s:if>
										</s:iterator>
									</tr>
										<s:iterator value="#question.options" var="option">
											<s:if test="#option.type==0">
												<tr>
													<td><input type="text" value="${option.text}" id="op_${option.id}"></td>
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
												<td><input type="text" value="${option.text}" id="op_${option.id}"></td>
											</s:if>
										</s:iterator>
									</tr>
										<s:iterator value="#question.options" var="option">
											<s:if test="#option.type==0">
												<tr>
													<td><input type="text" value="${option.text}" id="op_${option.id}"></td>
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

						</div>
						<div class="q_operation">
							<a href="javascript:;" id="delq_${question.id}" title="删除问题">删除问题</a>
							<s:if test="#status.first">
								<span style="color:gray; cursor: pointer;" >上移</span>
							</s:if>
							<s:else>
								<a href="javascript:;" id="moveup_${question.id}"  title="上移" >上移</a>
							</s:else>
							<s:if test="#status.last">
								<span style="color:gray; cursor: pointer;">下移</span>
							</s:if>
							<s:else>
								<a href="javascript:;" id="movedown_${question.id}"  title="下移">下移</a>
							</s:else>
							<s:if test="#question.questionType==1||#question.questionType==2">
								<a  href="javascript:;" id="hsort_${question.id}" title="横排">横排</a>
								<a  href="javascript:;" id="vsort_${question.id}" title="竖排">竖排</a>
							</s:if>
							<s:if test="#question.questionType==5||#question.questionType==6">
								<a  href="javascript:;" id="addh_${question.id}" title="添加一行">添加一行</a>
								<a  href="javascript:;" id="addv_${question.id}" title="添加一列">添加一列</a>
							</s:if>
						</div>
					</div>
				</div>
			</s:iterator>
			<!-- 循环问题end  -->
			<footer>
					<a href="${pageContext.request.contextPath}/question_preview.action?surveyId=${surveyId}&surveyTitle=${surveyTitle}" target=" _blank">
						<button type="button" class="btn btn-primary">预览问卷</button>
					</a>
					<a href="${pageContext.request.contextPath}/question_release.action?surveyId=${surveyId}&surveyTitle=${surveyTitle}">
						<button type="button" class="btn btn-primary">发布问卷</button>
					</a>
			</footer>
		</div>
	</div>
	<br>
</body>
</html>