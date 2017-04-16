package com.shopping.dao;

import com.shopping.model.User;

public interface UserDao {

	User addUser(User u);

	User validateUser(User user);
}
