package com.surveypark.util;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.surveypark.model.User;

@SuppressWarnings("serial")
public class CheckPrivilegeInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		/*
		 * System.out.println("---------> 之前"); String
		 * result=invocation.invoke(); //放行 System.out.println("---------> 之后");
		 * return result;
		 */

		// 获取信息
		User user = (User) ActionContext.getContext().getSession().get("user");
		// 获得action的代理对象-->得到action名字
		String actionName = invocation.getProxy().getActionName();
		String namespace = invocation.getProxy().getNamespace();
		String privUrl = namespace + actionName;
		

		// 如果未登陆
		if (user == null) {
			// 如果是去登录，就放行
			if (privUrl.startsWith("/user_login")
					|| privUrl.startsWith("/user_register")) { // "/user_loginUI",
				// "/user_login"
				return invocation.invoke();
			}else if (privUrl.startsWith("/answer_list")) {
				return invocation.invoke();
			}
			// 如果不是去登录，就转到登录页面
			return "loginUI";
		} 
		//如果已登陆，就放行
		else{
			return invocation.invoke();
		}
	}

}
