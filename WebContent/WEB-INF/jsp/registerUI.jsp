<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册</title>
<link type="text/css"
	href="${pageContext.request.contextPath}/static/css/register.css"
	rel="stylesheet">
<script src="${pageContext.request.contextPath}/static/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/register.js"></script>
</head>
<body>
	<div id="login_bg" class="login_bg"
		style="background-image: url(${pageContext.request.contextPath}/static/images/blog_bg.jpg);"></div>
	<div class="login_header">
		<span></span>
	</div>

	<div class="container">
		<div class="form_header">
			<h1 id="logo">用户注册</h1>
			<h2 id="subheading">跟着我，离梦更近一步</h2>
		</div>
		<s:form action="user_register" method="post">
		<div class="signup_forms" class="signup_forms">
			<div id="signup_forms_container" class="signup_forms_container">
				<div class="signup_account" id="signup_account">
					<div class="form_username">
						<input type="text" name="nickName" placeholder="用户名"
							id="signup_username" required="required" > 
						
					</div>
					<div class="form_password">
						<input type="password" name="password" placeholder="登陆密码"
							id="signup_password" required="required">
					</div>
					<div class="form_confirm_password">
						<input type="password" placeholder="确认密码"
							id="signup_confirm_password" required="required">
					</div>
					<div class="form_user">
						<input type="text" name="email" placeholder="邮箱" id="signup_email" required="required">
					</div>
				</div>
			</div>
			<button type="submit" id="signup_forms_submit">
				<span style="font-size: 16px;"><strong>提交</strong></span>
			</button>
		</div>
     </s:form>
	<h4>已有账号请<a href="${pageContext.request.contextPath}/user_loginUI.action"><span style="color:blue;">登录</span></a></h4>
	</div>



</body>
</html>