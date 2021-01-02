package org.polytec.vermeg.JunitTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.polytec.vermeg.controller.bookController;
import org.polytec.vermeg.model.Book;
import org.polytec.vermeg.service.bookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
@ExtendWith ({MockitoExtension.class})
class BookJuintController {
	Book book;
	@Autowired
	private MockMvc mockMvc;

	Date d =new Date(2020-12-12);
	@Mock
	bookService bService;
	@InjectMocks
	private bookController bookControllerr;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(bookControllerr).build();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	
	@Test
	void testGetbooks() throws Exception {
		Book b= new Book(1, "HOPE", "annaMark", 1, d);
		Book b1= new Book(1, "LesParoles", "Jane", 1, d);
		List <Book> books = new ArrayList<Book>();
		books.add(b) ;
		books.add(b1) ;
		when(bService.getAllbooks()).thenReturn(books);
		this.mockMvc.perform(get("/book/getAll"))
		.andExpect(status().isOk())
		.andDo(print());
	}

	@Test
	void testGetbookById() throws Exception {
		Book b= new Book(1, "HOPE", "annaMark", 1, d);
		long idBook=b.getIdBook();
		when(bService.getbook(idBook)).thenReturn(b);
		this.mockMvc.perform(get("/book/getbook/"+idBook))
		.andExpect(status().isOk())
		.andDo(print());
	}

	@Test
	void testAddbook() throws Exception {
		Book b= new Book(1, "HOPE", "annaMark", 1, d);
		bService.addbook(b);;
		   verify(bService, times(1)).addbook(b);
	
	 this.mockMvc.perform(post("/book/addbook"))
			.andExpect(status().isOk())
			.andDo(print());
		 
	
	}

	@Test
	void testUpdatebook() throws Exception {
		Book b= new Book(1, "HOPE", "annaMark", 1, d);
		Book b1= new Book(1, "LesParoles", "Jane", 1, d);
		Long idBook =b.getIdBook();
		bService.updatebook(b);
		verify(bService, times(1)).updatebook(b);
		 this.mockMvc.perform(put("/book/updatebook/"+idBook))
		  .andExpect(status().isOk())
		   .andDo(print());
	}

	@Test
	void testDeletebook() throws Exception {
		Book b= new Book(1, "HOPE", "annaMark", 1, d);
		Long idBook =b.getIdBook();
		bService.deletebook(idBook);
	verify(bService, times(1)).deletebook(idBook);
    this.mockMvc.perform(delete("/book/deletebook/"+idBook))
	  .andExpect(status().isOk())
	   .andDo(print());
	}

}
