<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<meta content="text/html; charset=gbk" http-equiv="Content-Type">
<title>问卷调查</title>
<link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
<link  type="text/css"  href="${pageContext.request.contextPath}/static/css/list.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/add.js"></script>
</head>
<body>
	<header>
		<div id="list_head">
			<h3><span style="color: white;">欢迎使用问卷调查系统</span></h3>
		</div>
		<div id="user">
			<h3>
				<a><button type="button" class="btn btn-info">${user.nickName}</button></a>
				<a href="${pageContext.request.contextPath}/user_logout.action"><button type="button" class="btn btn-danger">退出登录</button></a>
			</h3>
		</div>
	</header>
	<div id="centerDiv">
		<a class="new_create" href="javaScript:;" style="display: block;" onclick="add()">+新建</a>
		&nbsp;&nbsp;
		<div class="btn-group">
			   <button type="button" class="btn btn-default dropdown-toggle" 
				  data-toggle="dropdown">
				  排序 <span class="caret"></span>
			   </button>
			   <ul class="dropdown-menu" role="menu">
				  <li><a href="#">从新到旧</a></li>
				  <li><a href="#">从旧到新</a></li>
			   </ul>
		</div>
		<br>
	<table class="table table-bordered">
   <thead>
      <tr>
         <td width="35%">标题</td>
		<td>收集状态</td>
		<td>收到数据</td>
		<td>创建时间</td>
		<td>问卷访问链接</td>
		<td>操作</td>
      </tr>
   </thead>
   <tbody>
   <s:iterator var="survey" value="#surveyList">
      <tr>
         <td>
        	 <a href="${pageContext.request.contextPath}/question_createUI.action?surveyId=${survey.id}&surveyTitle=${survey.title}">${survey.title}</a>
         </td>
         <td>
         	<s:select list="#{0:'未发布', 1:'收集中',2:'已结束'}" value="#survey.state" id="state"/>
		 </td>
         <td>${survey.count}</td>
		 <td>
		 <s:date name="#survey.createTime" format="yyyy-MM-dd HH:mm"/>
		 </td>
		 <td>${survey.url}</td>
		 <td>
			<a href="${pageContext.request.contextPath}/survey_delete.action?id=${survey.id}">删除</a>
			<a href="${pageContext.request.contextPath}/answer_report.action?surveyId=${survey.id}">分析结果</a>
		 </td>
      </tr>
     </s:iterator>
   </tbody>
</table>
</div>
<br>

<div id='pop-div' style="width: 300px;height: 200px;" class="pop-box" >
    <h5>添加调查问卷</h5>
    <form action="${pageContext.request.contextPath}/survey_save.action" method="post">
    <div class="pop-box-body" >
     	<label>问卷标题</label><br>
     	<input type="text" class="form-control" name="title" id="title" required="required"><br>
    </div>
    <div class='buttonPanel' style="text-align:center;">
       <input type="submit" class="btn btn-login" value="添　加"  style="background-color:#ff9500; width:100px;">
    </div>
   </form>
</div>

</body>
</html>