package org.polytec.vermeg.service;


import java.util.List;

import org.polytec.vermeg.dao.BookImp;
import org.polytec.vermeg.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("bookService")
public class bookService {
	@Autowired
	BookImp bookImp;
	@Transactional
	public List<Book> getAllbooks() {
		return bookImp.getAll();
	}

	@Transactional
	public Book getbook(Long idBook) {
		return bookImp.getbookByID(idBook);
	}

	@Transactional
	public void addbook(Book book) {
		 bookImp.addbook(book);
	}

	@Transactional
	public void updatebook(Book book) {
		bookImp.updatebook(book);

	}

	@Transactional
	public void deletebook(Long id) {
		bookImp.deletebook(id);
	}

	
}
