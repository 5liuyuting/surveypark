<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link  type="text/css"  href="${pageContext.request.contextPath}/static/css/login.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/login.js"></script>
</head>
<body>
<div class="login-box">
	<h1>用户登录</h1>
	<s:form method="get" action="user_login">
		<div class="name">
			<label>邮　　箱：</label>
			<input type="text" name="email"  tabindex="1" autocomplete="off" value="${email}" />
		</div>
		<div class="password">
			<label>密　　码：</label>
			<input type="password" name="password" maxlength="16" id="" tabindex="2"/>
		</div>
		<div class="code">
			<label>验&nbsp;证 &nbsp;码：</label>
			<input type="text" name="validcode" maxlength="5" id="code" tabindex="3"/>
			<div class="codeImg">
				<img src="${pageContext.request.contextPath}/pictureCheckCode" class="validcode"/>
			</div>
		</div>
		<br><br>
		<div class="login">
			<button type="submit" tabindex="5">登录</button>
		</div>
		<div class="remember">
			<label>没有账号，请<a href="${pageContext.request.contextPath}/user_registerUI.action">注册</a></label>
		</div>
	</s:form>
</div>


<div class="screenbg">
	<ul>
		<li><a href="javascript:;"><img src="${pageContext.request.contextPath}/static/images/0.jpg"></a></li>
		<li><a href="javascript:;"><img src="${pageContext.request.contextPath}/static/images/1.jpg"></a></li>
		<li><a href="javascript:;"><img src="${pageContext.request.contextPath}/static/images/2.jpg"></a></li>
               
	</ul>
</div>
</body>
</html>