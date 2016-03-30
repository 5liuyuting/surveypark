package com.surveypark.test;

import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.surveypark.model.User;
import com.surveypark.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestSurveypark {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private UserService userService;
	
	@Test
	public void testSession(){
		System.out.println(sessionFactory);
	}
	
	@Test
	public void testAddUser(){
		User user=new User();
		user.setEmail("123@qq.com");
		user.setName("chai");
		user.setNickName("jsjchai");
		user.setPassword(DigestUtils.md5Hex("123456"));
		user.setRegDate(new Date());
		userService.add(user);
	}
}
