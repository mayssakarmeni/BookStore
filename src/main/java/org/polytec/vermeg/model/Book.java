package org.polytec.vermeg.model;




import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {
	@Id
	
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idBook;
	private String Title;
	private String Author;
	private double Price;
	private Date ReleaseDate;

	public long getIdBook() {
		return idBook;
	}
	public void setIdBook(long idBook) {
		this.idBook = idBook;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}

	public Date getReleaseDate() {
		return ReleaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		ReleaseDate = releaseDate;
	}
	


	public Book(long idBook, String title, String author, double price, Date releaseDate) {
		super();
		this.idBook = idBook;
		Title = title;
		Author = author;
		Price = price;
		ReleaseDate = releaseDate;
	}
	public Book() {
		
	}
	
	
}
