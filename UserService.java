package com.shopping.service;

import com.shopping.model.User;

public interface UserService {

	String addUser(User u);
	
	User validateUser(User user);
}
