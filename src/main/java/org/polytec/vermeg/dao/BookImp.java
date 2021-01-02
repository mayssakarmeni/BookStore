package org.polytec.vermeg.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.polytec.vermeg.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class BookImp implements IbookDAO {
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public Book getbookByName(String Title) {
		Session session = this.sessionFactory.getCurrentSession();
		Book b = (Book) session.createQuery("from Book where title=:title").setParameter("title", Title).uniqueResult();
		return b;	}
	

	@Override
	public List<Book> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Book> bookList = session.createQuery("from Book").list();
		
		return bookList;
	}


	@Override
	public Book getbookByID(Long idBook) {
		Session session = this.sessionFactory.getCurrentSession();
		Book b = (Book) session.createQuery("from Book where idBook=:idBook").setParameter("idBook", idBook).uniqueResult();
		return b;	}


	@Override
	public void addbook(Book book) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(book);
		
	}


	@Override
	public void updatebook(Book book) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(book);
		
	}


	@Override
	public void deletebook(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		Book b = (Book) session.load(Book.class, new Long(id));
		if (null != b) {
			session.delete(b);
		}
	
		
	}
}
