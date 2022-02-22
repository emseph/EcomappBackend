package com.myapp.dao;

import com.myapp.model.User;

public interface UserDAO {
	// user related operation
	User getByEmail(String email);
	boolean add(User user);
	boolean delete(int empid);
	boolean update(User user);
	boolean authenticate(String email, String password) ;
}
