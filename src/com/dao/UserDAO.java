package com.dao;

import java.util.List;

import javax.persistence.Query;

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
	
	public List<User> paginate(int offset, int limit)
	{
		String hql = "FROM User";
		Session session = HibernateUtils.getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(offset);
		query.setMaxResults(offset + limit);
		
		List<User> listUser = query.getResultList();
		
		return listUser;
	}
	
	public User findById(int id)
	{
		Session session = HibernateUtils.getSession();
		User entity = session.get(User.class, id);
		
		return entity;
	}
	
	public void update(User entity)
	{
		Session session = HibernateUtils.getSession();
		session.clear();
		
		try {
			session.beginTransaction();

			session.update(entity);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		}
	}
	
	public void delete(User entity)
	{
		Session session = HibernateUtils.getSession();
		session.clear();

		try {
			session.beginTransaction();

			session.delete(entity);

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			
			session.getTransaction().rollback();
		}
	}
	
	public User login(String email, String password)
	{
		String hql = "SELECT obj FROM User obj "
				+ "WHERE email = :email AND password = :password AND status = 1";

		Query query = HibernateUtils.getSession().createQuery(hql);
		query.setParameter("email", email);
		query.setParameter("password", password);

		try {
			User entity = (User) query.getSingleResult();
			
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
