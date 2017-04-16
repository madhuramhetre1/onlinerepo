package com.shopping.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.model.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SessionFactory sf;

	@Override
	public User addUser(User u) {
		sf.getCurrentSession().persist(u);
		return u;
	}


	@Override
	public User validateUser(User user) {
		// check for login
		System.out.println("inside valid user");
		User userlog=(User) sf.getCurrentSession().createQuery("select u from User u where u.userName= :uname and u.password= :pass")
				.setParameter("uname", user.getUserName()).setParameter("pass", user.getPassword()).uniqueResult();
		System.out.println("dao"+userlog.getUserName());
		return userlog;
	}

	

}
