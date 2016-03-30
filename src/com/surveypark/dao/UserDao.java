package com.surveypark.dao;

import com.surveypark.base.BaseDao;
import com.surveypark.model.User;

public interface UserDao extends BaseDao<User>{

	User getByEmail(String email);

}
