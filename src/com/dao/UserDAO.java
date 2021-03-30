package com.dao;

import org.hibernate.Session;

import com.entity.User;
import com.utils.HibernateUtils;

public class UserDAO {
	public User store(User entity) {
		Session session = HibernateUtils.getSession();
		session.beginTransaction();
		
		Integer id = (Integer) session.save(entity);
		
		session.getTransaction().commit();
		
		entity.setId(id);
		
		return entity;
	}
}
