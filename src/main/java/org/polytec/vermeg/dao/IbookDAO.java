package org.polytec.vermeg.dao;

import java.util.List;

import org.polytec.vermeg.model.Book;

public interface IbookDAO {
	public Book getbookByName(String Title);
	

    public List<Book>  getAll();
	public Book getbookByID(Long idBook);
	public void addbook(Book book);
	public void updatebook(Book book);
	public void deletebook(Long id) ;
	
}
