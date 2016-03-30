package com.surveypark.action;

import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.surveypark.model.User;
import com.surveypark.service.UserService;

@SuppressWarnings("serial")
@Controller
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User>{

	private String validCode;
	
	private User user =new User();
	
	@Resource
	private UserService userService;
	
	/**
	 *登录界面
	 */
	public String loginUI() throws Exception {
		return "loginUI";
	}
	
	/**
	 *登录
	 */
	public String login() throws Exception {
		if (validCode != null) {   //处理验证码
			if (validCode != null && !validCode.trim().equals("")) {
				String randStr = (String) ActionContext.getContext().getSession().get("randStr");
				if (validCode.equalsIgnoreCase(randStr)) {
					User u=userService.findEmailAndPassword(user.getEmail(),user.getPassword());
					if(u!=null){
						ActionContext.getContext().getSession().put("user", u);
						return "toList";
					}
				}
			}
		}
		ActionContext.getContext().put("email", user.getEmail());
		return "toLoginUI";
	}
	
	
	/**
	 *注册界面
	 */
	public String registerUI() throws Exception {
		return "registerUI";
	}
	
	/**
	 *注册
	 */
	public String register() throws Exception {
		user.setRegDate(new Date());
		user.setPassword(DigestUtils.md5Hex(user.getPassword()));
		userService.add(user);
		return "toLoginUI";
	}

	/**
	 * 注销
	 */
	
	public String logout() throws Exception {
		ActionContext.getContext().getSession().remove("user");
		return "toLoginUI";
	}
	
	@Override
	public User getModel() {
		return user;
	}

	public String getValidCode() {
		return validCode;
	}

	public void setValidcode(String validCode) {
		this.validCode = validCode;
	}

}
