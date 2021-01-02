package org.polytec.vermeg.JunitTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.polytec.vermeg.dao.BookImp;

import org.polytec.vermeg.model.Book;
import org.polytec.vermeg.service.bookService;
@ExtendWith ({MockitoExtension.class})
class BookServiceJunit {
	Date d = new Date (2020, 11,11);
	@Mock
BookImp bookImp;;
	
	@InjectMocks
	bookService bookS;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetAllbooks() {
		List <Book> books = new ArrayList<Book>();
		books.add(new Book(1, "HOPE", "annaMark", 1, d)) ;
		books.add(new Book(2, "LesParoles", "Jane", 1, d)) ;
		when(bookImp.getAll()).thenReturn(books);
		List<Book> books1 = bookS.getAllbooks() ;
		when(bookS.getAllbooks()).thenReturn(books);
		assertTrue(bookImp.getAll().size()==2,"size exact");
		assertTrue( bookS.getAllbooks().size()==2,"size exact et ajout exact");
		assertEquals(bookS.getAllbooks().size(),bookImp.getAll().size(),"liste service non ajouter ");

	}

	@Test
	void testGetbook() {
		Book b= new Book(1, "HOPE", "annaMark", 1, d);

		bookImp.getbookByID((long) 1);
		long id=b.getIdBook();
		when(bookImp.getbookByID(id)).thenReturn(b);

		assertEquals(bookImp.getbookByID((long) 1),bookS.getbook((long) 1),"incorrecte");
		


	}

	@Test
   	void testAddbook() {
Book b= new Book(1, "HOPE", "annaMark", 1, d);
bookImp.addbook(b);;
   verify(bookImp, times(1)).addbook(b);
 
		
		

	};
	@Test
	void testUpdatebook() {
		Book b= new Book(1, "HOPE", "annaMark", 1, d);
		Book b1= new Book(1, "LesParoles", "Jane", 1, d);
		bookImp.updatebook(b);
		verify(bookImp, times(1)).updatebook(b);
		
	}

	@Test
	void testDeletebook() {
		Book b= new Book(1, "HOPE", "annaMark", 1, d);
		Long id =b.getIdBook();
		bookImp.deletebook(id);
	verify(bookImp, times(1)).deletebook(id);
	
	
	}

}
