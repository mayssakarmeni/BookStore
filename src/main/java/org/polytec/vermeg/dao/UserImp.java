package org.polytec.vermeg.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.polytec.vermeg.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserImp  implements IUserDAO{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User getUserByName(String username) {
		Session session = (this.sessionFactory).getCurrentSession();
		User u = (User) session.createQuery("from User where username=:username").setParameter("username", username).uniqueResult();
		return u;
	}

	@Override
	public List<User> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> UserList = session.createQuery("from User").list();
		
		return UserList;
	}

	@Override
	public User getUserByID(Long idUser) {
		Session session = this.sessionFactory.getCurrentSession();
		User u = (User) session.createQuery("from User where idUser=:idUser").setParameter("idUser", idUser).uniqueResult();
		return u;
	}

	@Override
	public void SignUp(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(user);
		
	}

	@Override
	public void updateUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(user);
		
	}

	@Override
	public void deleteUser(Long idUser) {
		Session session = this.sessionFactory.getCurrentSession();
		User u = (User) session.load(User.class, new Long(idUser));
		if (null != u) {
			session.delete(u);
		}
		
	}

}
