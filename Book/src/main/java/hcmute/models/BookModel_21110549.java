package hcmute.models;

import java.io.Serializable;
import java.util.Date;

public class BookModel_21110549 implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private int bookid ;
    private int isbn ;
    private String title ;
    private String publisher ;
    private Double price ;
    private String description ;

    private java.sql.Date publish_date;
    private String cover_image;
    private Integer quantity ;
    private int total;
    
    private int authorid;
    private AuthorModel_21110549 author;
    
    private int total_reviews;

    
    public BookModel_21110549(int bookid, int isbn, String title, String publisher, Double price, String description,
			java.sql.Date publish_date, String cover_image, Integer quantity, int total, AuthorModel_21110549 author, int total_reviews) {
		super();
		this.bookid = bookid;
		this.isbn = isbn;
		this.title = title;
		this.publisher = publisher;
		this.price = price;
		this.description = description;
		this.publish_date = publish_date;
		this.cover_image = cover_image;
		this.quantity = quantity;
		this.total = total;
		this.author = author;
		this.total_reviews = total_reviews;
	}
    
    
    
	public int getTotal_reviews() {
		return total_reviews;
	}



	public void setTotal_reviews(int total_reviews) {
		this.total_reviews = total_reviews;
	}



	public AuthorModel_21110549 getAuthor() {
		return author;
	}
	public void setAuthor(AuthorModel_21110549 author) {
		this.author = author;
	}
	public int getAuthorid() {
		return authorid;
	}
	public void setAuthorid(int authorid) {
		this.authorid = authorid;
	}
	public BookModel_21110549(int authorid, int total) {
		super();
		this.authorid = authorid;
		this.total = total;
	}

	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public java.sql.Date getPublish_date() {
		return publish_date;
	}
	public void setPublish_date(java.sql.Date publish_date) {
		this.publish_date = publish_date;
	}
	public String getCover_image() {
		return cover_image;
	}
	public void setCover_image(String cover_image) {
		this.cover_image = cover_image;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BookModel_21110549() {
		super();
	}
	
	public BookModel_21110549(int bookid, int isbn, String title, String publisher, Double price, String description,
			java.sql.Date publish_date, String cover_image, Integer quantity) {
		super();
		this.bookid = bookid;
		this.isbn = isbn;
		this.title = title;
		this.publisher = publisher;
		this.price = price;
		this.description = description;
		this.publish_date = publish_date;
		this.cover_image = cover_image;
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "BookModel [bookid=" + bookid + ", isbn=" + isbn + ", title=" + title + ", publisher=" + publisher
				+ ", price=" + price + ", description=" + description + ", publish_date=" + publish_date
				+ ", cover_image=" + cover_image + ", quantity=" + quantity + "]";
	}
	public BookModel_21110549(int isbn, String title, String publisher, Double price, String description,
			java.sql.Date publish_date, String cover_image, Integer quantity) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.publisher = publisher;
		this.price = price;
		this.description = description;
		this.publish_date = publish_date;
		this.cover_image = cover_image;
		this.quantity = quantity;
	}
	
	public BookModel_21110549(int authorid,int bookid, int isbn, String title, String publisher, Double price, String description,
			java.sql.Date publish_date, String cover_image, Integer quantity) {
		super();
		this.authorid = authorid;
		this.bookid = bookid;
		this.isbn = isbn;
		this.title = title;
		this.publisher = publisher;
		this.price = price;
		this.description = description;
		this.publish_date = publish_date;
		this.cover_image = cover_image;
		this.quantity = quantity;
	}




}
