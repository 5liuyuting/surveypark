package com.surveypark.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 用户
 */
@Entity
@Table(name="t_user")
public class User {
 
	private Long id;
	 
	private String email; //邮箱
	 
	private String name;  //姓名
	 
	private String nickName; //昵称
	 
	private String password; //密码
	 
	private Date regDate; //注册时间
	
	private Set<Survey> surveies=new HashSet<Survey>();
	 
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@OneToMany(mappedBy="user")
	public Set<Survey> getSurveies() {
		return surveies;
	}

	public void setSurveies(Set<Survey> surveies) {
		this.surveies = surveies;
	}

}
 
