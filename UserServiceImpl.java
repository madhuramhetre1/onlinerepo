package com.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.dao.UserDao;
import com.shopping.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao dao;
	
	@Override
	public String addUser(User u) {
		User u1= dao.addUser(u);
        if(u1.getUserId()!=null)
		return "User added successfully";
        return "User registration failed";
	}

	@Override
	public User validateUser(User user) {
		// TODO login functionality
		System.out.println("inside service validuser");
        User userlog=dao.validateUser(user);
        System.out.println("service"+userlog.getUserName());
        return userlog;
	}

}
