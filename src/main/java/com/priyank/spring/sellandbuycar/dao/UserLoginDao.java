package com.priyank.spring.sellandbuycar.dao;

import com.priyank.spring.sellandbuycar.model.UserLogin;

public interface UserLoginDao {
	boolean insertUser(UserLogin userLogin);
	UserLogin getUserByName(String id,String pass);
}
