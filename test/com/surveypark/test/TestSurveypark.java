package com.surveypark.test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;




import com.surveypark.dao.UserDao;
import com.surveypark.model.Data;
import com.surveypark.model.User;
import com.surveypark.service.AnswerService;
import com.surveypark.service.SurveyService;
import com.surveypark.service.UserService;
import com.surveypark.util.AnswerUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class TestSurveypark {

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private UserService userService;
	@Autowired
	private SurveyService surveyService;
	@Autowired
	private UserDao userDao;
	@Autowired
	AnswerService answerService;
	
	@Test
	public void testSession(){
		System.out.println(sessionFactory);
	}
	
	@Test
	public void testAddUser(){
		
		User user=new User();
		user.setEmail("123@qq.com");
		user.setNickName("jsjchai");
		user.setPassword(DigestUtils.md5Hex("123456"));
		user.setRegDate(new Date());
		userService.add(user);
		
	}
	
	@Test
	public void testId(){
		System.out.println(AnswerUtil.getId("q1_10"));
	}
	
	@Test
	public void testStringArray(){
		String[] v={"1","2"};
		System.out.println(Arrays.toString(v));
	}
	
	@Test
	public void testgetByUser(){
		User user = userDao.getByEmail("123@1.com");
		surveyService.findByUser(user);
	}
	
	@Test
	public void testCountData(){
		List<Data> dataList=answerService.countData(22L);
		for(Data d:dataList){
			System.out.println(d.getCount()+"  "+d.getName());
		}
	}
	@Test
	public void testCountDataOther(){
		List<Data> dataList=answerService.countDataOther(27L);
		for(Data d:dataList){
			System.out.println(d.getCount()+"  "+d.getName()+" "+d.getOther());
		}
	}
}
